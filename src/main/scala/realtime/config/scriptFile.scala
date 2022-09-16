package com.ane.realtime.config

import com.typesafe.config.{Config, ConfigFactory}

/**
  * Created by Derek
  */
class ConfigUtils {

  private val config: Config = ConfigFactory.load("config.properties")

  // kafka相关配置
  val kafkaBootstrapServers: String = config.getString("bootstrap.servers")

  // zk相关配置
  val zkQuorum: String = config.getString("zookeeper.quorum")

  // 实际表(结果表)
  val kafkaTopicActualLoadUnload: String = config.getString("kafka.topic.actual.load.unload")

  // 计划表(结果表)
  val kafkaTopicRoutePlanResult: String = config.getString("kafka.topic.route.plan.result")

  //预报表(结果表)
  val kafkaTopicActualForecastResult: String = config.getString("kafka.topic.actual.forecast.result")

  // 最优表(结果表)
  val kafkaTopicRoutePlanOptimalResult: String = config.getString("kafka.topic.route.plan.optimal.result")

  // 留仓表(结果表)
  val kafkaTopicOptStockResult: String = config.getString("kafka.topic.opt.stock")

  // 录单(原始表)
  val kafkaTopicWayBillNoForecastData: String = config.getString("kafka.topic.waybillno.forecast.data")

  // 装车(原始表)
  val kafkaTopicActualLoadData: String = config.getString("kafka.topic.actual.load.data")

  // 卸车(原始表)
  val kafkaTopicActualUnloadData: String = config.getString("kafka.topic.actual.unload.data")

  // 网点到件(原始表)
  val kafkaTopicActualOptSiteReachData: String = config.getString("kafka.topic.actual.opt.site.reach.data")

  // 网点发件(原始表)
  val kafkaTopicActualOptSiteSendData: String = config.getString("kafka.topic.actual.opt.site.send.data")

  // 签收(原始表)
  val kafkaTopicActualSignData: String = config.getString("kafka.topic.actual.sign.data")


  // hive相关配置

}

object ConfigUtils extends ConfigUtils{

}
