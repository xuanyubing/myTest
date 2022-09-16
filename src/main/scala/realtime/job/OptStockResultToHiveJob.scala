package com.ane.realtime.job

import java.util.Properties
import java.util.concurrent.TimeUnit

import com.alibaba.fastjson.JSON
import com.ane.bean.OptStockResult
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
 * @ClassName OptStockResultToHiveJob
 * @Description opt_stock_result_topic 留仓数据写入hive
 * @Author zhangleilei
 * @Date 2020/9/15 15:15
 * @Version 1.0
 */

object OptStockResultToHiveJob {

  private val catalogName = "myhive"
  private val defaultDatabase = "route_rs"
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
    properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG, "OptStockResultToHiveJob")

    // Flink-kafka消费分区动态发现
//    properties.put("flink.partition-discovery.interval-millis","10000")
    properties.put("scan.topic-partition-discovery.interval","10000")

    val flinkKafkaConsumer = new FlinkKafkaConsumer[String](ConfigUtils.kafkaTopicOptStockResult, new SimpleStringSchema(), properties)
//     flinkKafkaConsumer.setStartFromEarliest()
    flinkKafkaConsumer.setStartFromGroupOffsets()

    val dataStream = env.addSource(flinkKafkaConsumer)
      .map(value => {
//        println("kafka data ==============================" + value)
        val record = JSON.parseObject(value, classOf[OptStockResult])
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
    tableEnv.createTemporaryView("tmp_opt_stock_result", dataTable)


    val insertSql = """
                      |INSERT INTO t_opt_stock_result
                      |select
                      |carType as car_type,
                      |nextFrontSiteName as next_front_site_name,
                      |waybillNo as waybill_no,
                      |subBillNo as sub_bill_no,
                      |deliveryReceiptNo as delivery_receipt_no,
                      |taskNo as task_no,
                      |scanSite as scan_site,
                      |scanSiteCode as scan_site_code,
                      |scanArea as scan_area,
                      |scanBigArea as scan_big_area,
                      |scanProvinceArea as scan_province_area,
                      |scanRegion as scan_region,
                      |scanProvince as scan_province,
                      |scanCity as scan_city,
                      |scanCounty as scan_county,
                      |scanLongitude as scan_longitude,
                      |scanLatitude as scan_latitude,
                      |preSite as pre_site,
                      |preSiteCode as pre_site_code,
                      |preArea as pre_area,
                      |preBigArea as pre_big_area,
                      |preProvinceArea as pre_province_area,
                      |preRegion as pre_region,
                      |preProvince as pre_province,
                      |preCity as pre_city,
                      |preCounty as pre_county,
                      |preLongitude as pre_longitude,
                      |preLatitude as pre_latitude,
                      |nextSite as next_site,
                      |nextSiteCode as next_site_code,
                      |nextArea as next_area,
                      |nextBigArea as next_big_area,
                      |nextProvinceArea as next_province_area,
                      |nextRegion as next_region,
                      |nextProvince as next_province,
                      |nextCity as next_city,
                      |nextCounty as next_county,
                      |nextLongitude as next_longitude,
                      |nextLatitude as next_latitude,
                      |originSite as origin_site,
                      |originSiteCode as origin_site_code,
                      |originCenter as origin_center,
                      |originCenterCode as origin_center_code,
                      |originArea as origin_area,
                      |originBigArea as origin_big_area,
                      |originProvinceArea as origin_province_area,
                      |originRegion as origin_region,
                      |originProvince as origin_province,
                      |originCity as origin_city,
                      |originCounty as origin_county,
                      |originLongitude as origin_longitude,
                      |originLatitude as origin_latitude,
                      |destinationSite as destination_site,
                      |destinationSiteCode as destination_site_code,
                      |destinationCenter as destination_center,
                      |destinationCenterCode as destination_center_code,
                      |destinationArea as destination_area,
                      |destinationBigArea as destination_big_area,
                      |destinationProvinceArea as destination_province_area,
                      |destinationRegion as destination_region,
                      |destinationProvince as destination_province,
                      |destinationCity as destination_city,
                      |destinationCounty as destination_county,
                      |destinationLongitude as destination_longitude,
                      |destinationLatitude as destination_latitude,
                      |lengthOfTime as length_of_time,
                      |orderSource as order_source,
                      |productType as product_type,
                      |sendTime as send_time,
                      |unloadScanTime as unload_scan_time,
                      |planArrivalTime as plan_arrival_time,
                      |deliveryDelayOfTime as delivery_delay_of_time,
                      |preSiteLateOfTime as pre_site_late_of_time,
                      |outSiteLateOfTime as out_site_late_of_time,
                      |unloadOverOfTime as unload_over_of_time,
                      |sortingOfTime as sorting_of_time,
                      |inTransitOfTime as in_transit_of_time,
                      |sortingTime as sorting_time,
                      |goodsWeight as goods_weight,
                      |calcWeight as calc_weight,
                      |operateWeight as operate_weight,
                      |piece as piece,
                      |ticket as ticket,
                      |goodsVolume as goods_volume,
                      |carArrivalTime as car_arrival_time,
                      |deliveryTime as delivery_time,
                      |currentTime as current_tm,
                      |loadingRate as loading_rate,
                      |misclassification as misclassification,
                      |link as link,
                      |palletTime as pallet_time,
                      |unloadScanners as unload_scanners,
                      |palletManName as pallet_man_name,
                      |sortManName as sort_man_name,
                      |optStockReasonOneLevel as opt_stock_reason_one_level,
                      |optStockReasonTwoLevel as opt_stock_reason_two_level,
                      |superiorityProduct as superiority_product,
                      |date_format(unloadScanTime,'yyyyMMdd') as dt
                      |from tmp_opt_stock_result
                      |""".stripMargin
    tableEnv.executeSql(insertSql)
  }
}
