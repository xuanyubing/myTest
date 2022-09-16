package com.ane.realtime.job

import java.util.Properties
import java.util.concurrent.TimeUnit

import com.alibaba.fastjson.JSON
import com.ane.bean.{LoadCarDTO, UnloadCarDTO}
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
 * @ClassName ActualUnloadDataToHiveJob
 * @Description actual_unload_data_queue 卸车数据写入hive
 * @Author zhangleilei
 * @Date 2020/9/15 15:15
 * @Version 1.0
 */

object ActualUnloadDataToHiveJob {

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
    properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG, "ActualUnloadDataToHiveJob")

    // Flink-kafka消费分区动态发现
    //    properties.put("flink.partition-discovery.interval-millis","10000")
    properties.put("scan.topic-partition-discovery.interval","10000")

    val flinkKafkaConsumer = new FlinkKafkaConsumer[String](ConfigUtils.kafkaTopicActualUnloadData, new SimpleStringSchema(), properties)
    // flinkKafkaConsumer.setStartFromEarliest()
    flinkKafkaConsumer.setStartFromGroupOffsets()

    val dataStream = env.addSource(flinkKafkaConsumer)
      .map(value => {
//        println("kafka data ==============================" + value)
        val record = JSON.parseObject(value, classOf[UnloadCarDTO])
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
    tableEnv.createTemporaryView("tmp_actual_unload", dataTable)


    val insertSql = """
                      |INSERT INTO t_actual_unload
                      |select
                      |id as id,
                      |deviceNo as device_no,
                      |pdaVersion as pda_version,
                      |scanType as scan_type,
                      |billCode as bill_code,
                      |subBillCode as sub_bill_code,
                      |scanUser as scan_user,
                      |scanSite as scan_site,
                      |scanTime as scan_time,
                      |preSite as pre_site,
                      |nextSite as next_site,
                      |taskCode as task_code,
                      |teamName as team_name,
                      |groupName as group_name,
                      |outMembers as out_members,
                      |members as members,
                      |operateType as operate_type,
                      |palletCode as pallet_code,
                      |deliveryNum as delivery_num,
                      |platformCode as platform_code,
                      |areaCode as area_code,
                      |piece as piece,
                      |servicesType as services_type,
                      |operateWeight as operate_weight,
                      |sonOperateWeight as son_operate_weight,
                      |sonWeight as son_weight,
                      |sonVol as son_vol,
                      |calcWeight as calc_weight,
                      |currentTime as current_tm,
                      |date_format(scanTime,'yyyyMMdd') as dt
                      |from tmp_actual_unload
                      |""".stripMargin
    tableEnv.executeSql(insertSql)
  }
}
