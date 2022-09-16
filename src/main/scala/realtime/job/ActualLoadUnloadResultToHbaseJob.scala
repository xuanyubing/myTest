package com.ane.realtime.job

import java.util.concurrent.TimeUnit

import org.apache.flink.api.common.restartstrategy.RestartStrategies
import org.apache.flink.api.common.time.Time
import org.apache.flink.streaming.api.environment.CheckpointConfig.ExternalizedCheckpointCleanup
import org.apache.flink.streaming.api.{CheckpointingMode, TimeCharacteristic}
import org.apache.flink.streaming.api.scala.StreamExecutionEnvironment
import org.apache.flink.table.api.{EnvironmentSettings, Table}
import org.apache.flink.table.api.bridge.scala.StreamTableEnvironment


/**
  * @description kafka数据写入hbase表 route_rs:actual_load_unload_result
  * @author zhangleilei
  * @create 2021/6/22
  */
object ActualLoadUnloadResultToHbaseJob {

  private val ACTUAL_LOAD_UNLOAD_RESULT_KAFKA_DDL =
    """
      |CREATE TABLE `actual_load_unload_result_kafka` (
      |  `version` INT,
      |  `waybillNo` STRING,
      |  `subBillNo` STRING,
      |  `goodsWeight` STRING,
      |  `calcWeight` STRING,
      |  `operateWeight` STRING,
      |  `goodsVolume` STRING,
      |  `piece` INT,
      |  `ticket` INT,
      |  `productType` STRING,
      |  `lengthOfTime` STRING,
      |  `mustGoGoods` STRING,
      |  `superiorityProduct` STRING,
      |  `areaType` STRING,
      |  `remark` STRING,
      |  `trackLine` STRING,
      |  `taskNo` STRING,
      |  `transportLineType` STRING,
      |  `deliveryReceiptNo` STRING,
      |  `carNo` STRING,
      |  `carType` STRING,
      |  `isOriginCenter` STRING,
      |  `isDestinationCenter` STRING,
      |  `routePath` STRING,
      |  `scanGoodsDepartureTime` STRING,
      |  `scanTime` STRING,
      |  `scanType` STRING,
      |  `scanSite` STRING,
      |  `scanSiteCode` STRING,
      |  `scanArea` STRING,
      |  `scanBigArea` STRING,
      |  `scanProvinceArea` STRING,
      |  `scanRegion` STRING,
      |  `scanProvince` STRING,
      |  `scanCity` STRING,
      |  `scanCounty` STRING,
      |  `scanLongitude` STRING,
      |  `scanLatitude` STRING,
      |  `preSite` STRING,
      |  `preSiteCode` STRING,
      |  `preArea` STRING,
      |  `preBigArea` STRING,
      |  `preProvinceArea` STRING,
      |  `preRegion` STRING,
      |  `preProvince` STRING,
      |  `preCity` STRING,
      |  `preCounty` STRING,
      |  `preLongitude` STRING,
      |  `preLatitude` STRING,
      |  `nextSite` STRING,
      |  `nextSiteCode` STRING,
      |  `nextArea` STRING,
      |  `nextBigArea` STRING,
      |  `nextProvinceArea` STRING,
      |  `nextRegion` STRING,
      |  `nextProvince` STRING,
      |  `nextCity` STRING,
      |  `nextCounty` STRING,
      |  `nextLongitude` STRING,
      |  `nextLatitude` STRING,
      |  `originCenter` STRING,
      |  `originCenterCode` STRING,
      |  `originArea` STRING,
      |  `originBigArea` STRING,
      |  `originProvinceArea` STRING,
      |  `originRegion` STRING,
      |  `originProvince` STRING,
      |  `originCity` STRING,
      |  `originCounty` STRING,
      |  `originLongitude` STRING,
      |  `originLatitude` STRING,
      |  `originSite` STRING,
      |  `originSiteCode` STRING,
      |  `destinationCenter` STRING,
      |  `destinationCenterCode` STRING,
      |  `destinationArea` STRING,
      |  `destinationBigArea` STRING,
      |  `destinationProvinceArea` STRING,
      |  `destinationRegion` STRING,
      |  `destinationProvince` STRING,
      |  `destinationCity` STRING,
      |  `destinationCounty` STRING,
      |  `destinationLongitude` STRING,
      |  `destinationLatitude` STRING,
      |  `destinationSite` STRING,
      |  `destinationSiteCode` STRING,
      |  `currentSystemTime` STRING,
      |  `aggregateIndexTime` STRING
      |) WITH (
      |  'connector' = 'kafka',
      |  'topic' = 'actual_load_unload_queue',
      |  'properties.bootstrap.servers' = 'datanode1:9092,datanode2:9092,datanode3:9092',
      |  'properties.group.id' = 'ActualLoadUnloadResultToHbaseJob',
      |  'format' = 'json',
      |  'scan.startup.mode' = 'latest-offset'
      |)
    """.stripMargin

  private val ACTUAL_LOAD_UNLOAD_RESULT_PRINT_DDL =
    """
      |CREATE TABLE `actual_load_unload_result_print` (
      | `version` INT,
      | `waybillNo` STRING,
      | `subBillNo` STRING,
      | `goodsWeight` STRING,
      | `calcWeight` STRING,
      | `operateWeight` STRING,
      | `goodsVolume` STRING,
      | `piece` INT,
      | `ticket` INT,
      | `productType` STRING,
      | `lengthOfTime` STRING,
      | `mustGoGoods` STRING,
      | `superiorityProduct` STRING,
      | `areaType` STRING,
      | `remark` STRING,
      | `trackLine` STRING,
      | `taskNo` STRING,
      | `transportLineType` STRING,
      | `deliveryReceiptNo` STRING,
      | `carNo` STRING,
      | `carType` STRING,
      | `isOriginCenter` STRING,
      | `isDestinationCenter` STRING,
      | `routePath` STRING,
      | `scanGoodsDepartureTime` STRING,
      | `scanTime` STRING,
      | `scanType` STRING,
      | `scanSite` STRING,
      | `scanSiteCode` STRING,
      | `scanArea` STRING,
      | `scanBigArea` STRING,
      | `scanProvinceArea` STRING,
      | `scanRegion` STRING,
      | `scanProvince` STRING,
      | `scanCity` STRING,
      | `scanCounty` STRING,
      | `scanLongitude` STRING,
      | `scanLatitude` STRING,
      | `preSite` STRING,
      | `preSiteCode` STRING,
      | `preArea` STRING,
      | `preBigArea` STRING,
      | `preProvinceArea` STRING,
      | `preRegion` STRING,
      | `preProvince` STRING,
      | `preCity` STRING,
      | `preCounty` STRING,
      | `preLongitude` STRING,
      | `preLatitude` STRING,
      | `nextSite` STRING,
      | `nextSiteCode` STRING,
      | `nextArea` STRING,
      | `nextBigArea` STRING,
      | `nextProvinceArea` STRING,
      | `nextRegion` STRING,
      | `nextProvince` STRING,
      | `nextCity` STRING,
      | `nextCounty` STRING,
      | `nextLongitude` STRING,
      | `nextLatitude` STRING,
      | `originCenter` STRING,
      | `originCenterCode` STRING,
      | `originArea` STRING,
      | `originBigArea` STRING,
      | `originProvinceArea` STRING,
      | `originRegion` STRING,
      | `originProvince` STRING,
      | `originCity` STRING,
      | `originCounty` STRING,
      | `originLongitude` STRING,
      | `originLatitude` STRING,
      | `originSite` STRING,
      | `originSiteCode` STRING,
      | `destinationCenter` STRING,
      | `destinationCenterCode` STRING,
      | `destinationArea` STRING,
      | `destinationBigArea` STRING,
      | `destinationProvinceArea` STRING,
      | `destinationRegion` STRING,
      | `destinationProvince` STRING,
      | `destinationCity` STRING,
      | `destinationCounty` STRING,
      | `destinationLongitude` STRING,
      | `destinationLatitude` STRING,
      | `destinationSite` STRING,
      | `destinationSiteCode` STRING,
      | `currentSystemTime` STRING,
      | `aggregateIndexTime` STRING
      |) WITH (
      |  'connector' = 'print'
      |)
    """.stripMargin

  private val ACTUAL_LOAD_UNLOAD_RESULT_PRINT_AS =
    """
      |CREATE TABLE `actual_load_unload_result_print`
      |WITH ('connector' = 'print')
      |LIKE `actual_load_unload_result_kafka` (EXCLUDING ALL)
    """.stripMargin


  private val ACTUAL_LOAD_UNLOAD_RESULT_HBASE_DDL =
    """
      |CREATE TABLE `actual_load_unload_result_hbase`(
      |   rowkey String,
      |   info ROW(`version` INT,`waybillNo` STRING,`subBillNo` STRING,`goodsWeight` STRING,`calcWeight` STRING,`operateWeight` STRING,`goodsVolume` STRING,`piece` INT,`ticket` INT,`productType` STRING,`lengthOfTime` STRING,`mustGoGoods` STRING,`superiorityProduct` STRING,`areaType` STRING,`remark` STRING,`trackLine` STRING,`taskNo` STRING,`transportLineType` STRING,`deliveryReceiptNo` STRING,`carNo` STRING,`carType` STRING,`isOriginCenter` STRING,`isDestinationCenter` STRING,`routePath` STRING,`scanGoodsDepartureTime` STRING,`scanTime` STRING,`scanType` STRING,`scanTypeCode` STRING, `scanSite` STRING,`scanSiteCode` STRING,`scanArea` STRING,`scanBigArea` STRING,`scanProvinceArea` STRING,`scanRegion` STRING,`scanProvince` STRING,`scanCity` STRING,`scanCounty` STRING,`scanLongitude` STRING,`scanLatitude` STRING,`preSite` STRING,`preSiteCode` STRING,`preArea` STRING,`preBigArea` STRING,`preProvinceArea` STRING,`preRegion` STRING,`preProvince` STRING,`preCity` STRING,`preCounty` STRING,`preLongitude` STRING,`preLatitude` STRING,`nextSite` STRING,`nextSiteCode` STRING,`nextArea` STRING,`nextBigArea` STRING,`nextProvinceArea` STRING,`nextRegion` STRING,`nextProvince` STRING,`nextCity` STRING,`nextCounty` STRING,`nextLongitude` STRING,`nextLatitude` STRING,`originCenter` STRING,`originCenterCode` STRING,`originArea` STRING,`originBigArea` STRING,`originProvinceArea` STRING,`originRegion` STRING,`originProvince` STRING,`originCity` STRING,`originCounty` STRING,`originLongitude` STRING,`originLatitude` STRING,`originSite` STRING,`originSiteCode` STRING,`destinationCenter` STRING,`destinationCenterCode` STRING,`destinationArea` STRING,`destinationBigArea` STRING,`destinationProvinceArea` STRING,`destinationRegion` STRING,`destinationProvince` STRING,`destinationCity` STRING,`destinationCounty` STRING,`destinationLongitude` STRING,`destinationLatitude` STRING,`destinationSite` STRING,`destinationSiteCode` STRING, `currentSystemTime` STRING, `aggregateIndexTime` STRING),
      |   PRIMARY KEY (rowkey) NOT ENFORCED
      |) WITH (
      |  'connector' = 'hbase-2.2',
      |  'table-name' = 'route_rs:actual_load_unload_result',
      |  'zookeeper.quorum' = 'datanode3:2181,datanode7:2181,datanode8:2181'
      |)
      |""".stripMargin

  def main(args: Array[String]): Unit = {

    val env = StreamExecutionEnvironment.getExecutionEnvironment

    env.setStreamTimeCharacteristic(TimeCharacteristic.ProcessingTime)
    env.enableCheckpointing(3 * 60 * 1000, CheckpointingMode.EXACTLY_ONCE)
    //env.getCheckpointConfig.setMinPauseBetweenCheckpoints(3 * 60 * 1000L)
    //env.getCheckpointConfig.enableExternalizedCheckpoints(ExternalizedCheckpointCleanup.RETAIN_ON_CANCELLATION)
    //env.setRestartStrategy(RestartStrategies.failureRateRestart(3, Time.of(10, TimeUnit.MINUTES), Time.of(20, TimeUnit.SECONDS)))

    val settings = EnvironmentSettings
      .newInstance()
      .useBlinkPlanner()
      .inStreamingMode()
      .build()

    val tableEnv = StreamTableEnvironment.create(env, settings)

    tableEnv.executeSql(ACTUAL_LOAD_UNLOAD_RESULT_KAFKA_DDL)
    tableEnv.executeSql(ACTUAL_LOAD_UNLOAD_RESULT_HBASE_DDL)
    tableEnv.executeSql(ACTUAL_LOAD_UNLOAD_RESULT_PRINT_AS)

    val sql =
      """
        |select
        |version ,
        |waybillNo ,
        |subBillNo ,
        |goodsWeight ,
        |calcWeight ,
        |operateWeight ,
        |goodsVolume ,
        |piece ,
        |ticket ,
        |productType ,
        |lengthOfTime ,
        |mustGoGoods ,
        |superiorityProduct ,
        |areaType ,
        |remark ,
        |trackLine ,
        |taskNo ,
        |transportLineType ,
        |deliveryReceiptNo ,
        |carNo ,
        |carType ,
        |isOriginCenter ,
        |isDestinationCenter ,
        |routePath ,
        |scanGoodsDepartureTime ,
        |scanTime ,
        |scanType ,
        |case scanType
        |when '录单'     then     '10'
        |when '网点发件'  then    '20'
        |when '网点到件'  then    '30'
        |when '分拨到车'  then    '40'
        |when '分拨发车'  then    '50'
        |when '分拨卸车'  then    '60'
        |when '分拨装车'  then    '70'
        |when '签收'      then    '80'
        |end as scanTypeCode,
        |scanSite ,
        |scanSiteCode ,
        |scanArea ,
        |scanBigArea ,
        |scanProvinceArea ,
        |scanRegion ,
        |scanProvince ,
        |scanCity ,
        |scanCounty ,
        |scanLongitude ,
        |scanLatitude ,
        |preSite ,
        |preSiteCode ,
        |preArea ,
        |preBigArea ,
        |preProvinceArea ,
        |preRegion ,
        |preProvince ,
        |preCity ,
        |preCounty ,
        |preLongitude ,
        |preLatitude ,
        |nextSite ,
        |nextSiteCode ,
        |nextArea ,
        |nextBigArea ,
        |nextProvinceArea ,
        |nextRegion ,
        |nextProvince ,
        |nextCity ,
        |nextCounty ,
        |nextLongitude ,
        |nextLatitude ,
        |originCenter ,
        |originCenterCode ,
        |originArea ,
        |originBigArea ,
        |originProvinceArea ,
        |originRegion ,
        |originProvince ,
        |originCity ,
        |originCounty ,
        |originLongitude ,
        |originLatitude ,
        |originSite ,
        |originSiteCode ,
        |destinationCenter ,
        |destinationCenterCode ,
        |destinationArea ,
        |destinationBigArea ,
        |destinationProvinceArea ,
        |destinationRegion ,
        |destinationProvince ,
        |destinationCity ,
        |destinationCounty ,
        |destinationLongitude ,
        |destinationLatitude ,
        |destinationSite ,
        |destinationSiteCode,
        |currentSystemTime,
        |aggregateIndexTime
        |from actual_load_unload_result_kafka
        |""".stripMargin

    val resultTable: Table = tableEnv.sqlQuery(sql)
    tableEnv.createTemporaryView("actual_load_unload_result_tmp", resultTable)


    val sqlPrint =
      """
        |INSERT INTO actual_load_unload_result_print
        |select * from actual_load_unload_result_kafka
        |""".stripMargin

    val stat = tableEnv.createStatementSet()
//    stat.addInsertSql(sqlPrint)

    val sinkDbSql =
      """
        |INSERT INTO actual_load_unload_result_hbase
        |select
        |    CONCAT_WS('_', reverse(subBillNo), scanSiteCode, scanTypeCode),
        |    ROW(
        |       version ,
        |       waybillNo ,
        |       subBillNo ,
        |       goodsWeight ,
        |       calcWeight ,
        |       operateWeight ,
        |       goodsVolume ,
        |       piece ,
        |       ticket ,
        |       productType ,
        |       lengthOfTime ,
        |       mustGoGoods ,
        |       superiorityProduct ,
        |       areaType ,
        |       remark ,
        |       trackLine ,
        |       taskNo ,
        |       transportLineType ,
        |       deliveryReceiptNo ,
        |       carNo ,
        |       carType ,
        |       isOriginCenter ,
        |       isDestinationCenter ,
        |       routePath ,
        |       scanGoodsDepartureTime ,
        |       scanTime ,
        |       scanType ,
        |       scanTypeCode ,
        |       scanSite ,
        |       scanSiteCode ,
        |       scanArea ,
        |       scanBigArea ,
        |       scanProvinceArea ,
        |       scanRegion ,
        |       scanProvince ,
        |       scanCity ,
        |       scanCounty ,
        |       scanLongitude ,
        |       scanLatitude ,
        |       preSite ,
        |       preSiteCode ,
        |       preArea ,
        |       preBigArea ,
        |       preProvinceArea ,
        |       preRegion ,
        |       preProvince ,
        |       preCity ,
        |       preCounty ,
        |       preLongitude ,
        |       preLatitude ,
        |       nextSite ,
        |       nextSiteCode ,
        |       nextArea ,
        |       nextBigArea ,
        |       nextProvinceArea ,
        |       nextRegion ,
        |       nextProvince ,
        |       nextCity ,
        |       nextCounty ,
        |       nextLongitude ,
        |       nextLatitude ,
        |       originCenter ,
        |       originCenterCode ,
        |       originArea ,
        |       originBigArea ,
        |       originProvinceArea ,
        |       originRegion ,
        |       originProvince ,
        |       originCity ,
        |       originCounty ,
        |       originLongitude ,
        |       originLatitude ,
        |       originSite ,
        |       originSiteCode ,
        |       destinationCenter ,
        |       destinationCenterCode ,
        |       destinationArea ,
        |       destinationBigArea ,
        |       destinationProvinceArea ,
        |       destinationRegion ,
        |       destinationProvince ,
        |       destinationCity ,
        |       destinationCounty ,
        |       destinationLongitude ,
        |       destinationLatitude ,
        |       destinationSite ,
        |       destinationSiteCode,
        |       currentSystemTime,
        |       aggregateIndexTime
        |     )
        |from actual_load_unload_result_tmp
        |""".stripMargin

    stat.addInsertSql(sinkDbSql)
    stat.execute()
    //    tEnv.executeSql(sinkDbSql)
    //    tEnv.createStatementSet()
  }
}
