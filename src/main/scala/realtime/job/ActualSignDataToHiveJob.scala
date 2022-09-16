package com.ane.realtime.job

import java.util.Properties
import java.util.concurrent.TimeUnit

import com.alibaba.fastjson.JSON
import com.ane.bean.SiteSignDTO
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
 * @ClassName ActualSignDataToHiveJob
 * @Description actual_sign_data_queue 签收数据写入hive
 * @Author zhangleilei
 * @Date 2020/9/15 15:15
 * @Version 1.0
 */

object ActualSignDataToHiveJob {

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
    properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG, "ActualSignDataToHiveJob")

    // Flink-kafka消费分区动态发现
    //    properties.put("flink.partition-discovery.interval-millis","10000")
    properties.put("scan.topic-partition-discovery.interval","10000")

    val flinkKafkaConsumer = new FlinkKafkaConsumer[String](ConfigUtils.kafkaTopicActualSignData, new SimpleStringSchema(), properties)
    // flinkKafkaConsumer.setStartFromEarliest()
    flinkKafkaConsumer.setStartFromGroupOffsets()

    val dataStream = env.addSource(flinkKafkaConsumer)
      .map(value => {
//        println("kafka data ==============================" + value)
        val record = JSON.parseObject(value, classOf[SiteSignDTO])
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
    tableEnv.createTemporaryView("tmp_actual_sign", dataTable)


    val insertSql = """
                      |INSERT INTO t_actual_sign
                      |select
                      |waybillNo as way_bill_no,
                      |scanSiteCode as scan_site_code,
                      |scanSiteName as scan_site_name,
                      |destCenterSiteCode as dest_center_site_code,
                      |destFirstSiteCode as dest_first_site_code,
                      |destSiteCode as dest_site_code,
                      |scanTime as scan_time,
                      |scanManCode as scan_man_code,
                      |scanManName as scan_man_name,
                      |signType as sign_type,
                      |signMan as sign_man,
                      |deviceNo as device_no,
                      |subBillNo as sub_bill_nos,
                      |remark as remark,
                      |destProvinceIndex as dest_province_index,
                      |exRemark as ex_remark,
                      |exTypeCode as ex_type_code,
                      |exTypeDesc as ex_type_desc,
                      |hasAttach as has_attach,
                      |scanMan as scan_man,
                      |scanDeviceCode as scan_device_code,
                      |scanType as scan_type,
                      |scanSource as scan_source,
                      |attachUrl as attach_urls,
                      |dataStatus as data_status,
                      |currentTime as current_tm,
                      |date_format(scanTime,'yyyyMMdd') as dt
                      |from tmp_actual_sign
                      |""".stripMargin
    tableEnv.executeSql(insertSql)
  }
}
