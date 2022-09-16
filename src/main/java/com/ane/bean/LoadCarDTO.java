package com.ane.bean;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author coderYSW
 * @version v1.0
 * @ClassName：LoadCarDTO
 * @Description: 装车扫描数据DTO
 * @date 2019-05-21 16:42:40
 */
public class LoadCarDTO implements Serializable {

    private static final long serialVersionUID = -3055382513311716376L;

    private Long id;

    private String deviceNo;

    private String pdaVersion;

    private Integer scanType;

    private String subBillCode;

    private String billCode;

    private String scanUser;

    private String scanSite;

    private String scanTime;

    private String preSite;

    private String nextSite;

    private String taskCode;

    private String teamName;

    private String groupName;

    private String outMembers;

    private String members;

    private Integer operateType;

    private BigDecimal sonWeight;

    private BigDecimal sonVol;

    private BigDecimal calcWeight;

    private String servicesType;

    private String currentTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDeviceNo() {
        return deviceNo;
    }

    public void setDeviceNo(String deviceNo) {
        this.deviceNo = deviceNo;
    }

    public String getPdaVersion() {
        return pdaVersion;
    }

    public void setPdaVersion(String pdaVersion) {
        this.pdaVersion = pdaVersion;
    }

    public Integer getScanType() {
        return scanType;
    }

    public void setScanType(Integer scanType) {
        this.scanType = scanType;
    }

    public String getSubBillCode() {
        return subBillCode;
    }

    public void setSubBillCode(String subBillCode) {
        this.subBillCode = subBillCode;
    }

    public String getBillCode() {
        return billCode;
    }

    public void setBillCode(String billCode) {
        this.billCode = billCode;
    }

    public String getScanUser() {
        return scanUser;
    }

    public void setScanUser(String scanUser) {
        this.scanUser = scanUser;
    }

    public String getScanSite() {
        return scanSite;
    }

    public void setScanSite(String scanSite) {
        this.scanSite = scanSite;
    }

    public String getScanTime() {
        return scanTime;
    }

    public void setScanTime(String scanTime) {
        this.scanTime = scanTime;
    }

    public String getPreSite() {
        return preSite;
    }

    public void setPreSite(String preSite) {
        this.preSite = preSite;
    }

    public String getNextSite() {
        return nextSite;
    }

    public void setNextSite(String nextSite) {
        this.nextSite = nextSite;
    }

    public String getTaskCode() {
        return taskCode;
    }

    public void setTaskCode(String taskCode) {
        this.taskCode = taskCode;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getOutMembers() {
        return outMembers;
    }

    public void setOutMembers(String outMembers) {
        this.outMembers = outMembers;
    }

    public String getMembers() {
        return members;
    }

    public void setMembers(String members) {
        this.members = members;
    }

    public Integer getOperateType() {
        return operateType;
    }

    public void setOperateType(Integer operateType) {
        this.operateType = operateType;
    }

    public String getServicesType() {
        return servicesType;
    }

    public void setServicesType(String servicesType) {
        this.servicesType = servicesType;
    }

    public String getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(String currentTime) {
        this.currentTime = currentTime;
    }

    public BigDecimal getSonWeight() {
        return sonWeight;
    }

    public void setSonWeight(BigDecimal sonWeight) {
        this.sonWeight = sonWeight;
    }

    public BigDecimal getSonVol() {
        return sonVol;
    }

    public void setSonVol(BigDecimal sonVol) {
        this.sonVol = sonVol;
    }

    public BigDecimal getCalcWeight() {
        return calcWeight;
    }

    public void setCalcWeight(BigDecimal calcWeight) {
        this.calcWeight = calcWeight;
    }
}
