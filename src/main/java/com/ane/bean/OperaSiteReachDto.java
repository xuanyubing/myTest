package com.ane.bean;

import java.math.BigDecimal;

/**
 * <网点到件>
 *
 * @author: xc
 * @date: 2019/10/16 16:27
 */
public class OperaSiteReachDto {

    private String scanBillNo;

    private String waybillNo;

    private Integer scanProvinceIndex;

    private BigDecimal codAmount;

    private BigDecimal arriveAmount;

    private String scanSiteCode;

    private String scanTime;

    private String scannerCode;

    private Integer prevSiteType;

    private String prevSiteCode;

    private String deviceNo;

    private String scanSource;

    private Integer scanType;

    private String currentTime;

    public String getScanBillNo() {
        return scanBillNo;
    }

    public void setScanBillNo(String scanBillNo) {
        this.scanBillNo = scanBillNo;
    }

    public String getWaybillNo() {
        return waybillNo;
    }

    public void setWaybillNo(String waybillNo) {
        this.waybillNo = waybillNo;
    }

    public Integer getScanProvinceIndex() {
        return scanProvinceIndex;
    }

    public void setScanProvinceIndex(Integer scanProvinceIndex) {
        this.scanProvinceIndex = scanProvinceIndex;
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

    public Integer getPrevSiteType() {
        return prevSiteType;
    }

    public void setPrevSiteType(Integer prevSiteType) {
        this.prevSiteType = prevSiteType;
    }

    public String getPrevSiteCode() {
        return prevSiteCode;
    }

    public void setPrevSiteCode(String prevSiteCode) {
        this.prevSiteCode = prevSiteCode;
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

    public Integer getScanType() {
        return scanType;
    }

    public void setScanType(Integer scanType) {
        this.scanType = scanType;
    }

    public String getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(String currentTime) {
        this.currentTime = currentTime;
    }

    public BigDecimal getCodAmount() {
        return codAmount;
    }

    public void setCodAmount(BigDecimal codAmount) {
        this.codAmount = codAmount;
    }

    public BigDecimal getArriveAmount() {
        return arriveAmount;
    }

    public void setArriveAmount(BigDecimal arriveAmount) {
        this.arriveAmount = arriveAmount;
    }
}
