package com.ane.bean;

import java.math.BigDecimal;

/**
 * <网点发件  / 中心应到件>
 *
 * @author: xc
 * @date: 2019/10/16 16:27
 */

public class OperaSiteSendDto {

    private Long siteSendId;

    private String scanBillNo;

    private String carNo;

    private String classId;

    private String waybillNo;

    private Integer billType;

    private Integer scanType;

    private BigDecimal goodsVolume;

    private BigDecimal volumeWeight;

    private String scanSiteCode;

    private String scanTime;

    private String scannerCode;

    private Integer scanProvinceIndex;

    private Integer nextSiteType;

    private String nextSiteCode;

    private String deviceNo;

    private String scanSource;

    private String currentTime;

    public Long getSiteSendId() {
        return siteSendId;
    }

    public void setSiteSendId(Long siteSendId) {
        this.siteSendId = siteSendId;
    }

    public String getScanBillNo() {
        return scanBillNo;
    }

    public void setScanBillNo(String scanBillNo) {
        this.scanBillNo = scanBillNo;
    }

    public String getCarNo() {
        return carNo;
    }

    public void setCarNo(String carNo) {
        this.carNo = carNo;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getWaybillNo() {
        return waybillNo;
    }

    public void setWaybillNo(String waybillNo) {
        this.waybillNo = waybillNo;
    }

    public Integer getBillType() {
        return billType;
    }

    public void setBillType(Integer billType) {
        this.billType = billType;
    }

    public Integer getScanType() {
        return scanType;
    }

    public void setScanType(Integer scanType) {
        this.scanType = scanType;
    }

    public String getScanSiteCode() {
        return scanSiteCode;
    }

    public void setScanSiteCode(String scanSiteCode) {
        this.scanSiteCode = scanSiteCode;
    }

    public String getScanTime() {
        return scanTime;
    }

    public void setScanTime(String scanTime) {
        this.scanTime = scanTime;
    }

    public String getScannerCode() {
        return scannerCode;
    }

    public void setScannerCode(String scannerCode) {
        this.scannerCode = scannerCode;
    }

    public Integer getScanProvinceIndex() {
        return scanProvinceIndex;
    }

    public void setScanProvinceIndex(Integer scanProvinceIndex) {
        this.scanProvinceIndex = scanProvinceIndex;
    }

    public Integer getNextSiteType() {
        return nextSiteType;
    }

    public void setNextSiteType(Integer nextSiteType) {
        this.nextSiteType = nextSiteType;
    }

    public String getNextSiteCode() {
        return nextSiteCode;
    }

    public void setNextSiteCode(String nextSiteCode) {
        this.nextSiteCode = nextSiteCode;
    }

    public String getDeviceNo() {
        return deviceNo;
    }

    public void setDeviceNo(String deviceNo) {
        this.deviceNo = deviceNo;
    }

    public String getScanSource() {
        return scanSource;
    }

    public void setScanSource(String scanSource) {
        this.scanSource = scanSource;
    }

    public String getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(String currentTime) {
        this.currentTime = currentTime;
    }

    public BigDecimal getGoodsVolume() {
        return goodsVolume;
    }

    public void setGoodsVolume(BigDecimal goodsVolume) {
        this.goodsVolume = goodsVolume;
    }

    public BigDecimal getVolumeWeight() {
        return volumeWeight;
    }

    public void setVolumeWeight(BigDecimal volumeWeight) {
        this.volumeWeight = volumeWeight;
    }
}
