package com.ane.bean;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @program: route-forecast
 * @description: 留仓信息明细实体类
 * @author: rzx
 * @create: 2021-05-06 14:30
 **/
public class OptStockResult implements Serializable {

    private static final long serialVersionUID = -682492577510948316L;

    /**
     * 车型
     */
    private String carType;

    /**
     * 下一站(12点前)
     */
    private String nextFrontSiteName;

    /**
     * 运单编号
     */
    private String waybillNo;

    /**
     * 子单编号
     */
    private String subBillNo;

    /**
     * 交接单单号
     */
    private String deliveryReceiptNo;

    /**
     * 到达任务号
     */
    private String taskNo;

    /**
     * 留仓站点
     */
    private String scanSite;
    /**
     * 留仓站点code
     */
    private String scanSiteCode;
    /**
     * 留仓片区
     */
    private String scanArea;
    /**
     * 留仓大区
     */
    private String scanBigArea;
    /**
     * 留仓省区
     */
    private String scanProvinceArea;

    /**
     * 留仓区域
     */
    private String scanRegion;

    /**
     * 留仓省份
     */
    private String scanProvince;

    /**
     * 留仓城市
     */
    private String scanCity;

    /**
     * 留仓区县
     */
    private String scanCounty;

    /**
     * 留仓经度
     */
    private String scanLongitude;

    /**
     * 留仓纬度
     */
    private String scanLatitude;

    /**
     * 上一站分拨名称
     */
    private String preSite;
    /**
     * 上一站分拨编号
     */
    private String preSiteCode;
    /**
     * 上一站片区
     */
    private String preArea;
    /**
     * 上一站大区
     */
    private String preBigArea;
    /**
     * 上一站省区
     */
    private String preProvinceArea;

    /**
     * 上一站区域
     */
    private String preRegion;

    /**
     * 上一站省份
     */
    private String preProvince;

    /**
     * 上一站城市
     */
    private String preCity;

    /**
     * 上一站区县
     */
    private String preCounty;

    /**
     * 上一站经度
     */
    private String preLongitude;

    /**
     * 上一站纬度
     */
    private String preLatitude;

    /**
     * 下一站(12点后)
     */
    private String nextSite;

    /**
     * 下一站分拨编号
     */
    private String nextSiteCode;
    /**
     * 下一站片区
     */
    private String nextArea;
    /**
     * 下一站大区
     */
    private String nextBigArea;
    /**
     * 下一站省区
     */
    private String nextProvinceArea;

    /**
     * 下一站区域
     */
    private String nextRegion;

    /**
     * 下一站省份
     */
    private String nextProvince;

    /**
     * 下一站城市
     */
    private String nextCity;

    /**
     * 下一站区县
     */
    private String nextCounty;

    /**
     * 下一站经度
     */
    private String nextLongitude;

    /**
     * 下一站纬度
     */
    private String nextLatitude;

    /**
     * 始发网点名称
     */
    private String originSite;

    /**
     * 始发网点code
     */
    private String originSiteCode;

    /**
     * 始发分拨名称
     */
    private String originCenter;
    /**
     * 始发分拨编号
     */
    private String originCenterCode;
    /**
     * 始发片区
     */
    private String originArea;
    /**
     * 始发大区
     */
    private String originBigArea;
    /**
     * 始发省区
     */
    private String originProvinceArea;

    /**
     * 始发区域
     */
    private String originRegion;

    /**
     * 始发省份
     */
    private String originProvince;

    /**
     * 始发城市
     */
    private String originCity;

    /**
     * 始发区县
     */
    private String originCounty;

    /**
     * 始发经度
     */
    private String originLongitude;

    /**
     * 始发纬度
     */
    private String originLatitude;

    /**
     * 运单目的网点
     */
    private String destinationSite;

    /**
     * 运单目的网点编码
     */
    private String destinationSiteCode;

    /**
     * 目的分拨名称
     */
    private String destinationCenter;
    /**
     * 目的分拨编号
     */
    private String destinationCenterCode;
    /**
     * 目的片区
     */
    private String destinationArea;
    /**
     * 目的大区
     */
    private String destinationBigArea;
    /**
     * 目的省区
     */
    private String destinationProvinceArea;

    /**
     * 目的区域
     */
    private String destinationRegion;

    /**
     * 目的省份
     */
    private String destinationProvince;

    /**
     * 目的城市
     */
    private String destinationCity;

    /**
     * 目的区县
     */
    private String destinationCounty;

    /**
     * 目的经度
     */
    private String destinationLongitude;

    /**
     * 目的纬度
     */
    private String destinationLatitude;

    /**
     * 时效
     */
    private Integer lengthOfTime;
    /**
     * 订单来源
     */
    private String orderSource;
    /**
     * 产品类型
     */
    private String productType;

    /**
     * 开单时间
     */
    private String sendTime;

    /**
     * 卸车扫描时间
     */
    private String unloadScanTime;

    /**
     * 计划到达时间
     */
    private String planArrivalTime;

    /**
     * 交件延误时长
     */
    private Integer deliveryDelayOfTime;

    /**
     * 上一站晚发时长
     */
    private Integer preSiteLateOfTime;

    /**
     * 本站晚到时长
     */
    private Integer outSiteLateOfTime;

    /**
     * 卸车超时时长
     */
    private Integer unloadOverOfTime;

    /**
     * 分拣时长
     */
    private Integer sortingOfTime;

    /**
     * 在途时长
     */
    private Integer inTransitOfTime;

    /**
     * 分拣时间
     */
    private String sortingTime;

    /**
     * 货物重量
     */
    private BigDecimal goodsWeight;

    /**
     * 结算重量
     */
    private BigDecimal calcWeight;
    /**
     * 运营重量
     */
    private BigDecimal operateWeight;

    /**
     * 留仓件数
     */
    private Integer piece;

    /**
     * 票数
     */
    private Integer ticket;

    /**
     * 体积
     */
    private BigDecimal goodsVolume;

    /**
     * 车辆到达时间
     */
    private String carArrivalTime;

    /**
     * 网点规定交件时间
     */
    private String deliveryTime;

    /**
     * 当前时间
     */
    private String currentTime;

    /**
     * 装载率
     */
    private BigDecimal loadingRate;

    /**
     * 是否错分
     */
    private String misclassification;

    /**
     * 环节
     */
    private String link;

    /**
     * 集托时间
     */
    private String palletTime;

    /**
     * 卸车扫描人
     */
    private String unloadScanners;

    /**
     * 分拣人
     */
    private String palletManName;

    /**
     * 集托人
     */
    private String sortManName;

    /**
     * 留仓一级原因
     */
    private String optStockReasonOneLevel;

    /**
     * 留仓二级原因
     */
    private String optStockReasonTwoLevel;

    /**
     * 是否优质
     */
    private String superiorityProduct;

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getNextFrontSiteName() {
        return nextFrontSiteName;
    }

    public void setNextFrontSiteName(String nextFrontSiteName) {
        this.nextFrontSiteName = nextFrontSiteName;
    }

    public String getWaybillNo() {
        return waybillNo;
    }

    public void setWaybillNo(String waybillNo) {
        this.waybillNo = waybillNo;
    }

    public String getSubBillNo() {
        return subBillNo;
    }

    public void setSubBillNo(String subBillNo) {
        this.subBillNo = subBillNo;
    }

    public String getDeliveryReceiptNo() {
        return deliveryReceiptNo;
    }

    public void setDeliveryReceiptNo(String deliveryReceiptNo) {
        this.deliveryReceiptNo = deliveryReceiptNo;
    }

    public String getTaskNo() {
        return taskNo;
    }

    public void setTaskNo(String taskNo) {
        this.taskNo = taskNo;
    }

    public String getScanSite() {
        return scanSite;
    }

    public void setScanSite(String scanSite) {
        this.scanSite = scanSite;
    }

    public String getScanSiteCode() {
        return scanSiteCode;
    }

    public void setScanSiteCode(String scanSiteCode) {
        this.scanSiteCode = scanSiteCode;
    }

    public String getScanArea() {
        return scanArea;
    }

    public void setScanArea(String scanArea) {
        this.scanArea = scanArea;
    }

    public String getScanBigArea() {
        return scanBigArea;
    }

    public void setScanBigArea(String scanBigArea) {
        this.scanBigArea = scanBigArea;
    }

    public String getScanProvinceArea() {
        return scanProvinceArea;
    }

    public void setScanProvinceArea(String scanProvinceArea) {
        this.scanProvinceArea = scanProvinceArea;
    }

    public String getScanRegion() {
        return scanRegion;
    }

    public void setScanRegion(String scanRegion) {
        this.scanRegion = scanRegion;
    }

    public String getScanProvince() {
        return scanProvince;
    }

    public void setScanProvince(String scanProvince) {
        this.scanProvince = scanProvince;
    }

    public String getScanCity() {
        return scanCity;
    }

    public void setScanCity(String scanCity) {
        this.scanCity = scanCity;
    }

    public String getScanCounty() {
        return scanCounty;
    }

    public void setScanCounty(String scanCounty) {
        this.scanCounty = scanCounty;
    }

    public String getScanLongitude() {
        return scanLongitude;
    }

    public void setScanLongitude(String scanLongitude) {
        this.scanLongitude = scanLongitude;
    }

    public String getScanLatitude() {
        return scanLatitude;
    }

    public void setScanLatitude(String scanLatitude) {
        this.scanLatitude = scanLatitude;
    }

    public String getPreSite() {
        return preSite;
    }

    public void setPreSite(String preSite) {
        this.preSite = preSite;
    }

    public String getPreSiteCode() {
        return preSiteCode;
    }

    public void setPreSiteCode(String preSiteCode) {
        this.preSiteCode = preSiteCode;
    }

    public String getPreArea() {
        return preArea;
    }

    public void setPreArea(String preArea) {
        this.preArea = preArea;
    }

    public String getPreBigArea() {
        return preBigArea;
    }

    public void setPreBigArea(String preBigArea) {
        this.preBigArea = preBigArea;
    }

    public String getPreProvinceArea() {
        return preProvinceArea;
    }

    public void setPreProvinceArea(String preProvinceArea) {
        this.preProvinceArea = preProvinceArea;
    }

    public String getPreRegion() {
        return preRegion;
    }

    public void setPreRegion(String preRegion) {
        this.preRegion = preRegion;
    }

    public String getPreProvince() {
        return preProvince;
    }

    public void setPreProvince(String preProvince) {
        this.preProvince = preProvince;
    }

    public String getPreCity() {
        return preCity;
    }

    public void setPreCity(String preCity) {
        this.preCity = preCity;
    }

    public String getPreCounty() {
        return preCounty;
    }

    public void setPreCounty(String preCounty) {
        this.preCounty = preCounty;
    }

    public String getPreLongitude() {
        return preLongitude;
    }

    public void setPreLongitude(String preLongitude) {
        this.preLongitude = preLongitude;
    }

    public String getPreLatitude() {
        return preLatitude;
    }

    public void setPreLatitude(String preLatitude) {
        this.preLatitude = preLatitude;
    }

    public String getNextSite() {
        return nextSite;
    }

    public void setNextSite(String nextSite) {
        this.nextSite = nextSite;
    }

    public String getNextSiteCode() {
        return nextSiteCode;
    }

    public void setNextSiteCode(String nextSiteCode) {
        this.nextSiteCode = nextSiteCode;
    }

    public String getNextArea() {
        return nextArea;
    }

    public void setNextArea(String nextArea) {
        this.nextArea = nextArea;
    }

    public String getNextBigArea() {
        return nextBigArea;
    }

    public void setNextBigArea(String nextBigArea) {
        this.nextBigArea = nextBigArea;
    }

    public String getNextProvinceArea() {
        return nextProvinceArea;
    }

    public void setNextProvinceArea(String nextProvinceArea) {
        this.nextProvinceArea = nextProvinceArea;
    }

    public String getNextRegion() {
        return nextRegion;
    }

    public void setNextRegion(String nextRegion) {
        this.nextRegion = nextRegion;
    }

    public String getNextProvince() {
        return nextProvince;
    }

    public void setNextProvince(String nextProvince) {
        this.nextProvince = nextProvince;
    }

    public String getNextCity() {
        return nextCity;
    }

    public void setNextCity(String nextCity) {
        this.nextCity = nextCity;
    }

    public String getNextCounty() {
        return nextCounty;
    }

    public void setNextCounty(String nextCounty) {
        this.nextCounty = nextCounty;
    }

    public String getNextLongitude() {
        return nextLongitude;
    }

    public void setNextLongitude(String nextLongitude) {
        this.nextLongitude = nextLongitude;
    }

    public String getNextLatitude() {
        return nextLatitude;
    }

    public void setNextLatitude(String nextLatitude) {
        this.nextLatitude = nextLatitude;
    }

    public String getOriginSite() {
        return originSite;
    }

    public void setOriginSite(String originSite) {
        this.originSite = originSite;
    }

    public String getOriginSiteCode() {
        return originSiteCode;
    }

    public void setOriginSiteCode(String originSiteCode) {
        this.originSiteCode = originSiteCode;
    }

    public String getOriginCenter() {
        return originCenter;
    }

    public void setOriginCenter(String originCenter) {
        this.originCenter = originCenter;
    }

    public String getOriginCenterCode() {
        return originCenterCode;
    }

    public void setOriginCenterCode(String originCenterCode) {
        this.originCenterCode = originCenterCode;
    }

    public String getOriginArea() {
        return originArea;
    }

    public void setOriginArea(String originArea) {
        this.originArea = originArea;
    }

    public String getOriginBigArea() {
        return originBigArea;
    }

    public void setOriginBigArea(String originBigArea) {
        this.originBigArea = originBigArea;
    }

    public String getOriginProvinceArea() {
        return originProvinceArea;
    }

    public void setOriginProvinceArea(String originProvinceArea) {
        this.originProvinceArea = originProvinceArea;
    }

    public String getOriginRegion() {
        return originRegion;
    }

    public void setOriginRegion(String originRegion) {
        this.originRegion = originRegion;
    }

    public String getOriginProvince() {
        return originProvince;
    }

    public void setOriginProvince(String originProvince) {
        this.originProvince = originProvince;
    }

    public String getOriginCity() {
        return originCity;
    }

    public void setOriginCity(String originCity) {
        this.originCity = originCity;
    }

    public String getOriginCounty() {
        return originCounty;
    }

    public void setOriginCounty(String originCounty) {
        this.originCounty = originCounty;
    }

    public String getOriginLongitude() {
        return originLongitude;
    }

    public void setOriginLongitude(String originLongitude) {
        this.originLongitude = originLongitude;
    }

    public String getOriginLatitude() {
        return originLatitude;
    }

    public void setOriginLatitude(String originLatitude) {
        this.originLatitude = originLatitude;
    }

    public String getDestinationSite() {
        return destinationSite;
    }

    public void setDestinationSite(String destinationSite) {
        this.destinationSite = destinationSite;
    }

    public String getDestinationSiteCode() {
        return destinationSiteCode;
    }

    public void setDestinationSiteCode(String destinationSiteCode) {
        this.destinationSiteCode = destinationSiteCode;
    }

    public String getDestinationCenter() {
        return destinationCenter;
    }

    public void setDestinationCenter(String destinationCenter) {
        this.destinationCenter = destinationCenter;
    }

    public String getDestinationCenterCode() {
        return destinationCenterCode;
    }

    public void setDestinationCenterCode(String destinationCenterCode) {
        this.destinationCenterCode = destinationCenterCode;
    }

    public String getDestinationArea() {
        return destinationArea;
    }

    public void setDestinationArea(String destinationArea) {
        this.destinationArea = destinationArea;
    }

    public String getDestinationBigArea() {
        return destinationBigArea;
    }

    public void setDestinationBigArea(String destinationBigArea) {
        this.destinationBigArea = destinationBigArea;
    }

    public String getDestinationProvinceArea() {
        return destinationProvinceArea;
    }

    public void setDestinationProvinceArea(String destinationProvinceArea) {
        this.destinationProvinceArea = destinationProvinceArea;
    }

    public String getDestinationRegion() {
        return destinationRegion;
    }

    public void setDestinationRegion(String destinationRegion) {
        this.destinationRegion = destinationRegion;
    }

    public String getDestinationProvince() {
        return destinationProvince;
    }

    public void setDestinationProvince(String destinationProvince) {
        this.destinationProvince = destinationProvince;
    }

    public String getDestinationCity() {
        return destinationCity;
    }

    public void setDestinationCity(String destinationCity) {
        this.destinationCity = destinationCity;
    }

    public String getDestinationCounty() {
        return destinationCounty;
    }

    public void setDestinationCounty(String destinationCounty) {
        this.destinationCounty = destinationCounty;
    }

    public String getDestinationLongitude() {
        return destinationLongitude;
    }

    public void setDestinationLongitude(String destinationLongitude) {
        this.destinationLongitude = destinationLongitude;
    }

    public String getDestinationLatitude() {
        return destinationLatitude;
    }

    public void setDestinationLatitude(String destinationLatitude) {
        this.destinationLatitude = destinationLatitude;
    }

    public Integer getLengthOfTime() {
        return lengthOfTime;
    }

    public void setLengthOfTime(Integer lengthOfTime) {
        this.lengthOfTime = lengthOfTime;
    }

    public String getOrderSource() {
        return orderSource;
    }

    public void setOrderSource(String orderSource) {
        this.orderSource = orderSource;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public Integer getDeliveryDelayOfTime() {
        return deliveryDelayOfTime;
    }

    public void setDeliveryDelayOfTime(Integer deliveryDelayOfTime) {
        this.deliveryDelayOfTime = deliveryDelayOfTime;
    }

    public Integer getPreSiteLateOfTime() {
        return preSiteLateOfTime;
    }

    public void setPreSiteLateOfTime(Integer preSiteLateOfTime) {
        this.preSiteLateOfTime = preSiteLateOfTime;
    }

    public Integer getOutSiteLateOfTime() {
        return outSiteLateOfTime;
    }

    public void setOutSiteLateOfTime(Integer outSiteLateOfTime) {
        this.outSiteLateOfTime = outSiteLateOfTime;
    }

    public Integer getUnloadOverOfTime() {
        return unloadOverOfTime;
    }

    public void setUnloadOverOfTime(Integer unloadOverOfTime) {
        this.unloadOverOfTime = unloadOverOfTime;
    }

    public Integer getSortingOfTime() {
        return sortingOfTime;
    }

    public void setSortingOfTime(Integer sortingOfTime) {
        this.sortingOfTime = sortingOfTime;
    }

    public Integer getInTransitOfTime() {
        return inTransitOfTime;
    }

    public void setInTransitOfTime(Integer inTransitOfTime) {
        this.inTransitOfTime = inTransitOfTime;
    }

    public BigDecimal getGoodsWeight() {
        return goodsWeight;
    }

    public void setGoodsWeight(BigDecimal goodsWeight) {
        this.goodsWeight = goodsWeight;
    }

    public BigDecimal getCalcWeight() {
        return calcWeight;
    }

    public void setCalcWeight(BigDecimal calcWeight) {
        this.calcWeight = calcWeight;
    }

    public BigDecimal getOperateWeight() {
        return operateWeight;
    }

    public void setOperateWeight(BigDecimal operateWeight) {
        this.operateWeight = operateWeight;
    }

    public Integer getPiece() {
        return piece;
    }

    public void setPiece(Integer piece) {
        this.piece = piece;
    }

    public Integer getTicket() {
        return ticket;
    }

    public void setTicket(Integer ticket) {
        this.ticket = ticket;
    }

    public BigDecimal getGoodsVolume() {
        return goodsVolume;
    }

    public void setGoodsVolume(BigDecimal goodsVolume) {
        this.goodsVolume = goodsVolume;
    }

    public BigDecimal getLoadingRate() {
        return loadingRate;
    }

    public void setLoadingRate(BigDecimal loadingRate) {
        this.loadingRate = loadingRate;
    }

    public String getMisclassification() {
        return misclassification;
    }

    public void setMisclassification(String misclassification) {
        this.misclassification = misclassification;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getUnloadScanners() {
        return unloadScanners;
    }

    public void setUnloadScanners(String unloadScanners) {
        this.unloadScanners = unloadScanners;
    }

    public String getPalletManName() {
        return palletManName;
    }

    public void setPalletManName(String palletManName) {
        this.palletManName = palletManName;
    }

    public String getSortManName() {
        return sortManName;
    }

    public void setSortManName(String sortManName) {
        this.sortManName = sortManName;
    }

    public String getOptStockReasonOneLevel() {
        return optStockReasonOneLevel;
    }

    public void setOptStockReasonOneLevel(String optStockReasonOneLevel) {
        this.optStockReasonOneLevel = optStockReasonOneLevel;
    }

    public String getOptStockReasonTwoLevel() {
        return optStockReasonTwoLevel;
    }

    public void setOptStockReasonTwoLevel(String optStockReasonTwoLevel) {
        this.optStockReasonTwoLevel = optStockReasonTwoLevel;
    }

    public String getSuperiorityProduct() {
        return superiorityProduct;
    }

    public void setSuperiorityProduct(String superiorityProduct) {
        this.superiorityProduct = superiorityProduct;
    }

    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }

    public String getUnloadScanTime() {
        return unloadScanTime;
    }

    public void setUnloadScanTime(String unloadScanTime) {
        this.unloadScanTime = unloadScanTime;
    }

    public String getPlanArrivalTime() {
        return planArrivalTime;
    }

    public void setPlanArrivalTime(String planArrivalTime) {
        this.planArrivalTime = planArrivalTime;
    }

    public String getSortingTime() {
        return sortingTime;
    }

    public void setSortingTime(String sortingTime) {
        this.sortingTime = sortingTime;
    }

    public String getCarArrivalTime() {
        return carArrivalTime;
    }

    public void setCarArrivalTime(String carArrivalTime) {
        this.carArrivalTime = carArrivalTime;
    }

    public String getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(String deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public String getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(String currentTime) {
        this.currentTime = currentTime;
    }

    public String getPalletTime() {
        return palletTime;
    }

    public void setPalletTime(String palletTime) {
        this.palletTime = palletTime;
    }
}
