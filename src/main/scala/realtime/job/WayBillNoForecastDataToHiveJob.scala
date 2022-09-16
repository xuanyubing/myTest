package com.ane.realtime.job

import java.util.Properties
import java.util.concurrent.TimeUnit

import com.alibaba.fastjson.JSON
import com.ane.bean.WayBillInfoVo
import com.ane.realtime.config.ConfigUtils
import org.apache.flink.api.common.restartstrategy.RestartStrategies
import org.apache.flink.api.common.serialization.SimpleStringSchema
import org.apache.flink.api.common.time.Time
import org.apache.flink.streaming.api.environment.CheckpointConfig.ExternalizedCheckpointCleanup
import org.apache.flink.streaming.api.scala._
import org.apache.flink.streaming.api.{CheckpointingMode, TimeCharacteristic}
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer
import org.apache.flink.table.api.bridge.scala.StreamTableEnvironment
import org.apache.flink.table.api.{EnvironmentSettings, SqlDialect, Table}
import org.apache.flink.table.catalog.hive.HiveCatalog
import org.apache.hadoop.hive.conf.HiveConf
import org.apache.kafka.clients.consumer.ConsumerConfig

/**
 * @ClassName WayBillNoForecastDataToHiveJob
 * @Description waybill_no_forecast_data_queue 录单表数据写入hive
 * @Author zhangleilei
 * @Date 2020/9/15 15:15
 * @Version 1.0
 */

object WayBillNoForecastDataToHiveJob {

  private val catalogName = "myhive"
  private val defaultDatabase = "route"
  private val hiveConfDir = "/etc/hive/conf"
  private val version = "2.1.1"

  def main(args: Array[String]): Unit = {

    val env = StreamExecutionEnvironment.getExecutionEnvironment
    env.setStreamTimeCharacteristic(TimeCharacteristic.ProcessingTime)
    env.enableCheckpointing(3 * 60 * 1000, CheckpointingMode.EXACTLY_ONCE)
    env.getCheckpointConfig.setMinPauseBetweenCheckpoints(3 * 60 * 1000L)
    env.getCheckpointConfig.enableExternalizedCheckpoints(ExternalizedCheckpointCleanup.RETAIN_ON_CANCELLATION)
    env.setRestartStrategy(RestartStrategies.failureRateRestart(3, Time.of(10, TimeUnit.MINUTES), Time.of(20, TimeUnit.SECONDS)))

    val tableEnvSettings = EnvironmentSettings.newInstance()
        .inStreamingMode()
        .build()

    val tableEnv = StreamTableEnvironment.create(env, tableEnvSettings)
    val properties = new Properties()

    properties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, ConfigUtils.kafkaBootstrapServers)
    properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG, "WayBillNoForecastDataToHiveJob")

    // Flink-kafka消费分区动态发现
//    properties.put("flink.partition-discovery.interval-millis","10000")
    properties.put("scan.topic-partition-discovery.interval","10000")

    val flinkKafkaConsumer = new FlinkKafkaConsumer[String](ConfigUtils.kafkaTopicWayBillNoForecastData, new SimpleStringSchema(), properties)
    // flinkKafkaConsumer.setStartFromEarliest()
    flinkKafkaConsumer.setStartFromGroupOffsets()

    val dataStream = env.addSource(flinkKafkaConsumer)
      .map(value => {
//        println("kafka data ==============================" + value)
        val record = JSON.parseObject(value, classOf[WayBillInfoVo])
//        println("record data ==============================" + record)
        record
      })
      //.filter(value => value.getInsDbTm.toLong >= 1615996800000L)  // insDbTm 在 2021-03-18 后的数据


    tableEnv.getConfig.setSqlDialect(SqlDialect.HIVE)

    val hiveConf = new HiveConf()

    hiveConf.setVar(HiveConf.ConfVars.METASTOREURIS, "thrift://panebdlyname02:9083,thrift://panebdlyname03:9083")
    hiveConf.setVar(HiveConf.ConfVars.METASTOREWAREHOUSE, "hdfs://nameservice1/user/hive/warehouse")

    hiveConf.set("fs.defaultFS", "hdfs://nameservice1")
    hiveConf.set("dfs.nameservices", "nameservice1")
    hiveConf.set("dfs.ha.namenodes.nameservice1", "namenode108,namenode396")
    hiveConf.set("dfs.namenode.rpc-address.nameservice1.namenode108", "panebdlyname02:8020")
    hiveConf.set("dfs.namenode.rpc-address.nameservice1.namenode396", "panebdlyname03:8020")
    hiveConf.set("dfs.client.failover.proxy.provider.nameservice1", "org.apache.hadoop.hdfs.server.namenode.ha.ConfiguredFailoverProxyProvider")

    val catalog = new HiveCatalog(
      catalogName,
      defaultDatabase,
      hiveConf,
      version
    )

    tableEnv.registerCatalog(catalogName, catalog)
    tableEnv.useCatalog(catalogName)
    tableEnv.useDatabase(defaultDatabase)

    val dataTable: Table = tableEnv.fromDataStream(dataStream)
    tableEnv.createTemporaryView("tmp_waybill_no_forecast", dataTable)


    val insertSql = """
                      |INSERT INTO t_waybill_no_forecast
                      |select
                      |waybillInfoWaybillNo as waybill_info_waybill_no,
                      |waybillInfoBillType as waybill_info_bill_type,
                      |waybillInfoSendDate as waybill_info_send_date,
                      |waybillInfoSendSiteCode as waybill_info_send_site_code,
                      |waybillInfoSendSiteName as waybill_info_send_site_name,
                      |waybillInfoTotalPiece as waybill_info_total_piece,
                      |waybillInfoSendFirstSiteCode as waybill_info_send_first_site_code,
                      |waybillInfoSendProvinceCode as waybill_info_send_province_code,
                      |waybillInfoSendBigAreaCode as waybill_info_send_big_area_code,
                      |waybillInfoSendCodePath as waybill_info_send_code_path,
                      |waybillInfoCollectEmpCode as waybill_info_collect_emp_code,
                      |waybillInfoCollectEmpName as waybill_info_collect_emp_name,
                      |waybillInfoDestSiteCode as waybill_info_dest_site_code,
                      |waybillInfoDestFirstSiteCode as waybill_info_dest_first_site_code,
                      |waybillInfoDestCenterCode as waybill_info_dest_center_code,
                      |waybillInfoDestProvinceCode as waybill_info_dest_province_code,
                      |waybillInfoDestBigAreaCode as waybill_info_dest_big_area_code,
                      |waybillInfoDestCodePath as waybill_info_dest_code_path,
                      |waybillContactSiteInfoCollectEmpName as waybill_contact_site_info_collect_emp_name,
                      |waybillContactSiteInfoSendSiteName as waybill_contact_site_info_send_site_name,
                      |waybillContactSiteInfoSendFirstSiteName as waybill_contact_site_info_send_first_site_name,
                      |waybillContactSiteInfoSendCenterName as waybill_contact_site_info_send_center_name,
                      |waybillContactSiteInfoSendFinanceSiteCode as waybill_contact_site_info_send_finance_site_code,
                      |waybillContactSiteInfoSendFinanceSiteName as waybill_contact_site_info_send_finance_site_name,
                      |waybillContactSiteInfoSendAccountSiteCode as waybill_contact_site_info_send_account_site_code,
                      |waybillContactSiteInfoSendAccountSiteName as waybill_contact_site_info_send_account_site_name,
                      |waybillContactSiteInfoSendProvinceCode as waybill_contact_site_info_send_province_code,
                      |waybillContactSiteInfoSendProvinceName as waybill_contact_site_info_send_province_name,
                      |waybillContactSiteInfoSendBigAreaCode as waybill_contact_site_info_send_big_area_code,
                      |waybillContactSiteInfoSendBigAreaName as waybill_contact_site_info_send_big_area_name,
                      |waybillContactSiteInfoDestSiteName as waybill_contact_site_info_dest_site_name,
                      |waybillContactSiteInfoDestFirstSiteName as waybill_contact_site_info_dest_first_site_name,
                      |waybillContactSiteInfoDestCenterName as waybill_contact_site_info_dest_center_name,
                      |waybillContactSiteInfoDestFinanceSiteCode as waybill_contact_site_info_dest_finance_site_code,
                      |waybillContactSiteInfoDestFinanceSiteName as waybill_contact_site_info_dest_finance_site_name,
                      |waybillContactSiteInfoDestAccountSiteCode as waybill_contact_site_info_dest_account_site_code,
                      |waybillContactSiteInfoDestAccountSiteName as waybill_contact_site_info_dest_account_site_name,
                      |waybillContactSiteInfoDestProvinceCode as waybill_contact_site_info_dest_province_code,
                      |waybillContactSiteInfoDestProvinceName as waybill_contact_site_info_dest_province_name,
                      |waybillContactSiteInfoDestBigAreaCode as waybill_contact_site_info_dest_big_area_code,
                      |waybillContactSiteInfoDestBigAreaName as waybill_contact_site_info_dest_big_area_name,
                      |waybillContactSiteInfoDirectTrainCenterCode as waybill_contact_site_info_direct_train_center_code,
                      |waybillContactSiteInfoDirectTrainCenterName as waybill_contact_site_info_direct_train_center_name,
                      |waybillInfoProductLineCode as waybill_info_product_line_code,
                      |waybillInfoProductTypeCode as waybill_info_product_type_code,
                      |waybillInfoTotalWeight as waybill_info_total_weight,
                      |waybillInfoCalcWeight as waybill_info_calc_weight,
                      |waybillInfoPackageSize as waybill_info_package_size,
                      |waybillInfoMaxLength as waybill_info_max_length,
                      |waybillInfoSpecialNum as waybill_info_special_num,
                      |waybillInfoAvgWeight as waybill_info_avg_weight,
                      |waybillInfoAvgVolume as waybill_info_avg_volume,
                      |waybillInfoTotalVol as waybill_info_total_vol,
                      |waybillInfoTotalVolWeight as waybill_info_total_vol_weight,
                      |waybillInfoTransVolWeight as waybill_info_trans_vol_weight,
                      |waybillInfoReceiptWaybillNo as waybill_info_receipt_waybill_no,
                      |waybillInfoReceiptType as waybill_info_receipt_type,
                      |waybillInfoReceiptReturnType as waybill_info_receipt_return_type,
                      |waybillInfoCreatorCode as waybill_info_creator_code,
                      |waybillInfoUpdateCode as waybill_info_update_code,
                      |waybillInfoTotalAmount as waybill_info_total_amount,
                      |waybillAneAmountTransCalcWeight as waybill_ane_amount_trans_calc_weight,
                      |waybillAneAmountCalcThrowModel as waybill_ane_amount_calc_throw_model,
                      |waybillAneAmountThrowNum as waybill_ane_amount_throw_num,
                      |waybillAneAmountOfferDiscount as waybill_ane_amount_offer_discount,
                      |waybillAneAmountOfferDiscount4Site as waybill_ane_amount_offer_discount4_site,
                      |waybillAneAmountTransferPolicy as waybill_ane_amount_transfer_policy,
                      |waybillAneAmountTransAmount as waybill_ane_amount_trans_amount,
                      |waybillAneAmountDispatchAmount as waybill_ane_amount_dispatch_amount,
                      |waybillAneAmountCusFreightAmount as waybill_ane_amount_cus_freight_amount,
                      |waybillAneAmountPremiumAmount as waybill_ane_amount_premium_amount,
                      |waybillAneAmountPayDispatcherAmount as waybill_ane_amount_pay_dispatcher_amount,
                      |waybillAneAmountBonusPoolFee as waybill_ane_amount_bonus_pool_fee,
                      |waybillAneAmountOptAmount as waybill_ane_amount_opt_amount,
                      |waybillAneAmountFuelAmount as waybill_ane_amount_fuel_amount,
                      |waybillAneAmountMeetingAmount as waybill_ane_amount_meeting_amount,
                      |waybillAneAmountMeetingSubsidyAmount as waybill_ane_amount_meeting_subsidy_amount,
                      |waybillAneAmountPaySendOperationAmount as waybill_ane_amount_pay_send_operation_amount,
                      |waybillAneAmountArriveOptAmount as waybill_ane_amount_arrive_opt_amount,
                      |waybillAneAmountPayPremiumAmount as waybill_ane_amount_pay_premium_amount,
                      |waybillAneAmountReceiptAmount as waybill_ane_amount_receipt_amount,
                      |waybillAneAmountCollectAmount as waybill_ane_amount_collect_amount,
                      |waybillAneAmountPayDispatchCollectAmount as waybill_ane_amount_pay_dispatch_collect_amount,
                      |waybillAneAmountCodOptAmount as waybill_ane_amount_cod_opt_amount,
                      |waybillAneAmountReceiveSendFee as waybill_ane_amount_receive_send_fee,
                      |waybillAneAmountSiteTransAmount as waybill_ane_amount_site_trans_amount,
                      |waybillAneAmountSiteReDispachFee as waybill_ane_amount_site_re_dispach_fee,
                      |waybillAneAmountSitePayDispatchFee as waybill_ane_amount_site_pay_dispatch_fee,
                      |waybillAneAmountPickUpAmount as waybill_ane_amount_pick_up_amount,
                      |waybillAneAmountDeliveryAmount as waybill_ane_amount_delivery_amount,
                      |waybillAneAmountCusPremiumAmount as waybill_ane_amount_cus_premium_amount,
                      |waybillAneAmountFuelAddAmount as waybill_ane_amount_fuel_add_amount,
                      |waybillAneAmountDocumentAmount as waybill_ane_amount_document_amount,
                      |waybillAneAmountStairsAmount as waybill_ane_amount_stairs_amount,
                      |waybillAneAmountPayStairsAmount as waybill_ane_amount_pay_stairs_amount,
                      |waybillAneAmountCodCharge as waybill_ane_amount_cod_charge,
                      |waybillAneAmountSonBillReturnAmount as waybill_ane_amount_son_bill_return_amount,
                      |waybillAneAmountSendPayMent as waybill_ane_amount_send_pay_ment,
                      |waybillAneAmountDispatchPayMent as waybill_ane_amount_dispatch_pay_ment,
                      |waybillAneAmountCodBuckSendCustomerFee as waybill_ane_amount_cod_buck_send_customer_fee,
                      |waybillAneAmountCodPayDispatchFee as waybill_ane_amount_cod_pay_dispatch_fee,
                      |waybillAneAmountPayDispatchServiceFee as waybill_ane_amount_pay_dispatch_service_fee,
                      |waybillAneAmountPayBonusPoolFee as waybill_ane_amount_pay_bonus_pool_fee,
                      |waybillAneAmountPriceTypeMap as waybill_ane_amount_price_type_map,
                      |waybillAneAmountFragileGoodsFee as waybill_ane_amount_fragile_goods_fee,
                      |waybillAneAmountFreightAmount as waybill_ane_amount_freight_amount,
                      |waybillAneAmountQuoteType as waybill_ane_amount_quote_type,
                      |waybillAneAmountOverWeightAmount as waybill_ane_amount_over_weight_amount,
                      |waybillAneAmountWareHouseCharge as waybill_ane_amount_ware_house_charge,
                      |waybillAneAmountPayOverWeightAmount as waybill_ane_amount_pay_over_weight_amount,
                      |waybillAneAmountSiteReArrivePayFee as waybill_ane_amount_site_re_arrive_pay_fee,
                      |waybillAneAmountSiteDisArrivePayFee as waybill_ane_amount_site_dis_arrive_pay_fee,
                      |waybillAneAmountSiteMeetingAmount as waybill_ane_amount_site_meeting_amount,
                      |waybillAneAmountKiloMetreAmount as waybill_ane_amount_kilo_metre_amount,
                      |waybillAneAmountDisChargeCargoAmount as waybill_ane_amount_dis_charge_cargo_amount,
                      |waybillInfoSiteTotalAmount as waybill_info_site_total_amount,
                      |waybillSiteAmountPayerTypeCode as waybill_site_amount_payer_type_code,
                      |waybillSiteAmountPayerType as waybill_site_amount_payer_type,
                      |waybillSiteAmountPaymentType as waybill_site_amount_payment_type,
                      |waybillSiteAmountCurrency as waybill_site_amount_currency,
                      |waybillSiteAmountStairType as waybill_site_amount_stair_type,
                      |waybillSiteAmountTotalCustomerAmount as waybill_site_amount_total_customer_amount,
                      |waybillSiteAmountInsuredAmount as waybill_site_amount_insured_amount,
                      |waybillSiteAmountPremiumAmount as waybill_site_amount_premium_amount,
                      |waybillSiteAmountFreightAmount as waybill_site_amount_freight_amount,
                      |waybillSiteAmountFirstFreightAmount as waybill_site_amount_first_freight_amount,
                      |waybillSiteAmountBoxCheckAmount as waybill_site_amount_box_check_amount,
                      |waybillSiteAmountUpStairsAmount as waybill_site_amount_up_stairs_amount,
                      |waybillSiteAmountCheckAmount as waybill_site_amount_check_amount,
                      |waybillSiteAmountTrunsAmount as waybill_site_amount_truns_amount,
                      |waybillSiteAmountInWarehouseAmount as waybill_site_amount_in_warehouse_amount,
                      |waybillSiteAmountSpecialAreaAmount as waybill_site_amount_special_area_amount,
                      |waybillSiteAmountSpecialUpStairsAmount as waybill_site_amount_special_up_stairs_amount,
                      |waybillSiteAmountPassStandardUpStairsAmount as waybill_site_amount_pass_standard_up_stairs_amount,
                      |waybillSiteAmountBlindZoneCarAmount as waybill_site_amount_blind_zone_car_amount,
                      |waybillSiteAmountUrgentCarAmount as waybill_site_amount_urgent_car_amount,
                      |waybillSiteAmountPassStandardCarAmount as waybill_site_amount_pass_standard_car_amount,
                      |waybillSiteAmountOtherAmount as waybill_site_amount_other_amount,
                      |waybillSiteAmountRemark as waybill_site_amount_remark,
                      |waybillInfoGrossProfit as waybill_info_gross_profit,
                      |waybillInfoPaymentType as waybill_info_payment_type,
                      |waybillInfoPickType as waybill_info_pick_type,
                      |waybillInfoCalcCustomerCode as waybill_info_calc_customer_code,
                      |waybillInfoCalcCustomerBillNo as waybill_info_calc_customer_bill_no,
                      |waybillSendReceiveInfoVip as waybill_send_receive_info_vip,
                      |waybillSendReceiveInfoSendProvince as waybill_send_receive_info_send_province,
                      |waybillSendReceiveInfoSendProvinceCode as waybill_send_receive_info_send_province_code,
                      |waybillSendReceiveInfoSendCity as waybill_send_receive_info_send_city,
                      |waybillSendReceiveInfoSendCityCode as waybill_send_receive_info_send_city_code,
                      |waybillSendReceiveInfoSendDistrict as waybill_send_receive_info_send_district,
                      |waybillSendReceiveInfoSendDistrictCode as waybill_send_receive_info_send_district_code,
                      |waybillSendReceiveInfoSendStreet as waybill_send_receive_info_send_street,
                      |waybillSendReceiveInfoSendStreetCode as waybill_send_receive_info_send_street_code,
                      |waybillSendReceiveInfoSendAddress as waybill_send_receive_info_send_address,
                      |waybillSendReceiveInfoSenderCode as waybill_send_receive_info_sender_code,
                      |waybillSendReceiveInfoSenderName as waybill_send_receive_info_sender_name,
                      |waybillSendReceiveInfoSenderCompany as waybill_send_receive_info_sender_company,
                      |waybillSendReceiveInfoSenderMobile as waybill_send_receive_info_sender_mobile,
                      |waybillSendReceiveInfoSenderLinkMan as waybill_send_receive_info_sender_link_man,
                      |waybillSendReceiveInfoSenderPhone as waybill_send_receive_info_sender_phone,
                      |waybillSendReceiveInfoSenderCardType as waybill_send_receive_info_sender_card_type,
                      |waybillSendReceiveInfoSenderCardNo as waybill_send_receive_info_sender_card_no,
                      |waybillSendReceiveInfoSenderPostCode as waybill_send_receive_info_sender_post_code,
                      |waybillSendReceiveInfoReceiveProvinceCode as waybill_send_receive_info_receive_province_code,
                      |waybillSendReceiveInfoReceiveProvince as waybill_send_receive_info_receive_province,
                      |waybillSendReceiveInfoReceiveCityCode as waybill_send_receive_info_receive_city_code,
                      |waybillSendReceiveInfoReceiveCity as waybill_send_receive_info_receive_city,
                      |waybillSendReceiveInfoReceiveDistrictCode as waybill_send_receive_info_receive_district_code,
                      |waybillSendReceiveInfoReceiveDistrict as waybill_send_receive_info_receive_district,
                      |waybillSendReceiveInfoReceiveStreetCode as waybill_send_receive_info_receive_street_code,
                      |waybillSendReceiveInfoReceiveStreet as waybill_send_receive_info_receive_street,
                      |waybillSendReceiveInfoReceiveAddress as waybill_send_receive_info_receive_address,
                      |waybillSendReceiveInfoReceiverCode as waybill_send_receive_info_receiver_code,
                      |waybillSendReceiveInfoReceiverName as waybill_send_receive_info_receiver_name,
                      |waybillSendReceiveInfoReceiverCompany as waybill_send_receive_info_receiver_company,
                      |waybillSendReceiveInfoReceiverMobile as waybill_send_receive_info_receiver_mobile,
                      |waybillSendReceiveInfoReceiverLinkMan as waybill_send_receive_info_receiver_link_man,
                      |waybillSendReceiveInfoReceiverPhone as waybill_send_receive_info_receiver_phone,
                      |waybillSendReceiveInfoReceiverCardType as waybill_send_receive_info_receiver_card_type,
                      |waybillSendReceiveInfoReceiverCardNo as waybill_send_receive_info_receiver_card_no,
                      |waybillSendReceiveInfoReceiverPostCode as waybill_send_receive_info_receiver_post_code,
                      |waybillInfoBillStatus as waybill_info_bill_status,
                      |waybillInfoWaybillStatusDate as waybill_info_waybill_status_date,
                      |waybillInfoWaybillRoute as waybill_info_waybill_route,
                      |waybillInfoSendCenterCode as waybill_info_send_center_code,
                      |waybillInfoWaybillSource as waybill_info_waybill_source,
                      |waybillInfoOperatorType as waybill_info_operator_type,
                      |waybillInfoDeviceNo as waybill_info_device_no,
                      |waybillInfoGoodsType as waybill_info_goods_type,
                      |waybillInfoGoodsCategory as waybill_info_goods_category,
                      |waybillInfoGoodsProp as waybill_info_goods_prop,
                      |waybillGoodsInfoUpward as waybill_goods_info_upward,
                      |waybillGoodsInfoUnPress as waybill_goods_info_un_press,
                      |waybillGoodsInfoSpecialNum as waybill_goods_info_special_num,
                      |waybillGoodsInfoVolEl as waybill_goods_info_vol_el,
                      |waybillGoodsInfoGoodsType as waybill_goods_info_goods_type,
                      |waybillGoodsInfoGoodsCategory as waybill_goods_info_goods_category,
                      |waybillGoodsInfoGoodsName as waybill_goods_info_goods_name,
                      |waybillGoodsInfoGoodsDesc as waybill_goods_info_goods_desc,
                      |waybillGoodsInfoPackType as waybill_goods_info_pack_type,
                      |WaybillOrderInfoEcommerceSource as waybill_order_info_ecommerce_source,
                      |WaybillOrderInfoEcommerceWarehouse as waybill_order_info_ecommerce_warehouse,
                      |WaybillOrderInfoOrderNo as waybill_order_info_order_no,
                      |waybillInfoPhotoUploadTime as waybill_info_photo_upload_time,
                      |waybillInfoPhotoBackTime as waybill_info_photo_back_time,
                      |waybillInfoStatus as waybill_info_status,
                      |waybillInfoRemark as waybill_info_remark,
                      |waybillCodBankInfoCodCurrency as waybill_cod_bank_info_cod_currency,
                      |waybillCodBankInfoCodPayMode as waybill_cod_bank_info_cod_pay_mode,
                      |waybillCodBankInfoCodPayModeName as waybill_cod_bank_info_cod_pay_mode_name,
                      |waybillCodBankInfoReturnTime as waybill_cod_bank_info_return_time,
                      |waybillCodBankInfoCodAccountName as waybill_cod_bank_info_cod_account_name,
                      |waybillCodBankInfoCodBankName as waybill_cod_bank_info_cod_bank_name,
                      |waybillCodBankInfoCodAccountNo as waybill_cod_bank_info_cod_account_no,
                      |waybillCodBankInfoCodBankArea as waybill_cod_bank_info_cod_bank_area,
                      |waybillCodBankInfoCodProvinceName as waybill_cod_bank_info_cod_province_name,
                      |waybillCodBankInfoCodCityName as waybill_cod_bank_info_cod_city_name,
                      |waybillCodBankInfoCodBankSite as waybill_cod_bank_info_cod_bank_site,
                      |waybillCodBankInfoCodCombinenum as waybill_cod_bank_info_cod_combinenum,
                      |waybillCodBankInfoSenderMobile as waybill_cod_bank_info_sender_mobile,
                      |waybillCodBankInfoAccountType as waybill_cod_bank_info_account_type,
                      |busiAttributeslimitationPeriod as busi_attributeslimitation_period,
                      |busiAttributesProductProperties as busi_attributes_product_properties,
                      |busiAttributesprovincePiece as busi_attributesprovince_piece,
                      |waybillInfoCodAmount as waybill_info_cod_amount,
                      |waybillInfoSubscribeFlag as waybill_info_subscribe_flag,
                      |waybillInfoSubEwbNo as waybill_info_sub_ewb_no,
                      |waybillInfoSendProvinceIndex as waybill_info_send_province_index,
                      |waybillInfoDestProvinceIndex as waybill_info_dest_province_index,
                      |waybillInfoupdateDate as waybill_infoupdate_date,
                      |currentTime as current_tm,
                      |date_format(waybillInfoSendDate,'yyyyMMdd') as dt
                      |from tmp_waybill_no_forecast
                      |""".stripMargin
    tableEnv.executeSql(insertSql)
  }
}
