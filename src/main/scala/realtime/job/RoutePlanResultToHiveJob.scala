package com.ane.realtime.job

import java.util.Properties
import java.util.concurrent.TimeUnit

import com.alibaba.fastjson.JSON
import com.ane.realtime.bean.ActualLoadUnloadResultBean
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
 * @ClassName RoutePlanResultToHiveJob
 * @Description route_plan_result_queue03 计划数据写入hive
 * @Author zhangleilei
 * @Date 2020/9/15 15:15
 * @Version 1.0
 */

object RoutePlanResultToHiveJob {

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
    properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG, "RoutePlanResultToHiveJob")

    // Flink-kafka消费分区动态发现
//    properties.put("flink.partition-discovery.interval-millis","10000")
    properties.put("scan.topic-partition-discovery.interval","10000")

    val flinkKafkaConsumer = new FlinkKafkaConsumer[String](ConfigUtils.kafkaTopicRoutePlanResult, new SimpleStringSchema(), properties)
    // flinkKafkaConsumer.setStartFromEarliest()
    flinkKafkaConsumer.setStartFromGroupOffsets()

    val dataStream = env.addSource(flinkKafkaConsumer)
      .map(value => {
//        println("kafka data ==============================" + value)
        val record = JSON.parseObject(value, classOf[ActualLoadUnloadResultBean])
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
    tableEnv.createTemporaryView("tmp_route_plan_result", dataTable)


    val insertSql = """
                      |INSERT INTO t_route_plan_result
                      |select
                      |version as version,
                      |waybillNo as waybill_no,
                      |subBillNo as sub_bill_no,
                      |goodsWeight as goods_weight,
                      |calcWeight as calc_weight,
                      |operateWeight as operate_weight,
                      |goodsVolume as goods_volume,
                      |piece as piece,
                      |ticket as ticket,
                      |productType as product_type,
                      |lengthOfTime as length_of_time,
                      |mustGoGoods as must_go_goods,
                      |superiorityProduct as superiority_product,
                      |areaType as area_type,
                      |remark as remark,
                      |trackLine as track_line,
                      |taskNo as task_no,
                      |transportLineType as transport_line_type,
                      |deliveryReceiptNo as delivery_receipt_no,
                      |carNo as car_no,
                      |carType as car_type,
                      |isOriginCenter as is_origin_center,
                      |isDestinationCenter as is_destination_denter,
                      |routePath as route_path,
                      |scanGoodsDepartureTime as scan_goods_departure_time,
                      |scanTime as scan_time,
                      |scanType as scan_type,
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
                      |originSite as origin_site,
                      |originSiteCode as origin_site_code,
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
                      |destinationSite as destination_site,
                      |destinationSiteCode as destination_site_code,
                      |currentSystemTime as current_tm,
                      |aggregateIndexTime as aggregate_index_time,
                      |date_format(scanTime,'yyyyMMdd') as dt
                      |from tmp_route_plan_result
                      |""".stripMargin
    tableEnv.executeSql(insertSql)
  }
}
