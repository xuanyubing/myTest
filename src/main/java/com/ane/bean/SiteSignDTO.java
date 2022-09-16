/**
 * Copyright (C), 2019-2020
 * FileName: SiteSignDTO
 * Author:   danyits
 * Date:     2020/2/15 下午5:42
 * Description: 网点签收信息交互类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ane.bean;


/**
 * 〈网点签收信息交互类〉
 *
 * @author danyits
 * @date 2020/2/15
 * @since 1.0.0
 */
public class SiteSignDTO  {
    /**
     * 签收主单号
     */
    private String waybillNo;
    /**
     * 签收网点code
     **/
    private String scanSiteCode;

    private String scanSiteName;
    /**目的分拨id**/
    private String destCenterSiteCode;
    /**目的首发网点**/
    private String destFirstSiteCode;
    /**目的网点**/
    private String destSiteCode;
    /**
     * 扫描时间
     **/
    private String scanTime;
    /**
     * 扫描人
     **/
    private String scanManCode;

    private String scanManName;
    /**
     * 签收类型
     * 正常签收   10
     * 自提       20
     * 代收点签收  30
     * 异常签收  > 40, 具体值为异常签收类型
     */
    private Integer signType;

    /**
     * 签收人
     **/

    private String signMan;
    /**
     * 设备编号= 数据录入来源+数据录入方式(扫描、手输)+签收设备
     **/
    private String deviceNo;
    /**
     * 子单签收时,扫描子单号
     **/
    private String subBillNo;
    /**
     * 备注
     **/
    private String remark;

    private Integer destProvinceIndex;

    private String exRemark;

    private String exTypeCode;

    private String exTypeDesc;

    private Integer hasAttach;

    private String scanMan;

    private String scanDeviceCode;

    private Integer scanType;

    private String scanSource;

    private String attachUrl;
    /**
     * 数据状态 10或者为空 为扫描   20为删除
     */
    private Integer dataStatus;

    private String currentTime;

    public String getWaybillNo() {
        return waybillNo;
    }

    public void setWaybillNo(String waybillNo) {
        this.waybillNo = waybillNo;
    }

    public String getScanSiteCode() {
        return scanSiteCode;
    }

    public void setScanSiteCode(String scanSiteCode) {
        this.scanSiteCode = scanSiteCode;
    }

    public String getScanSiteName() {
        return scanSiteName;
    }

    public void setScanSiteName(String scanSiteName) {
        this.scanSiteName = scanSiteName;
    }

    public String getDestCenterSiteCode() {
        return destCenterSiteCode;
    }

    public void setDestCenterSiteCode(String destCenterSiteCode) {
        this.destCenterSiteCode = destCenterSiteCode;
    }

    public String getDestFirstSiteCode() {
        return destFirstSiteCode;
    }

    public void setDestFirstSiteCode(String destFirstSiteCode) {
        this.destFirstSiteCode = destFirstSiteCode;
    }

    public String getDestSiteCode() {
        return destSiteCode;
    }

    public void setDestSiteCode(String destSiteCode) {
        this.destSiteCode = destSiteCode;
    }

    public String getScanTime() {
        return scanTime;
    }

    public void setScanTime(String scanTime) {
        this.scanTime = scanTime;
    }

    public String getScanManCode() {
        return scanManCode;
    }

    public void setScanManCode(String scanManCode) {
        this.scanManCode = scanManCode;
    }

    public String getScanManName() {
        return scanManName;
    }

    public void setScanManName(String scanManName) {
        this.scanManName = scanManName;
    }

    public Integer getSignType() {
        return signType;
    }

    public void setSignType(Integer signType) {
        this.signType = signType;
    }

    public String getSignMan() {
        return signMan;
    }

    public void setSignMan(String signMan) {
        this.signMan = signMan;
    }

    public String getDeviceNo() {
        return deviceNo;
    }

    public void setDeviceNo(String deviceNo) {
        this.deviceNo = deviceNo;
    }



    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getDestProvinceIndex() {
        return destProvinceIndex;
    }

    public void setDestProvinceIndex(Integer destProvinceIndex) {
        this.destProvinceIndex = destProvinceIndex;
    }

    public String getExRemark() {
        return exRemark;
    }

    public void setExRemark(String exRemark) {
        this.exRemark = exRemark;
    }

    public String getExTypeCode() {
        return exTypeCode;
    }

    public void setExTypeCode(String exTypeCode) {
        this.exTypeCode = exTypeCode;
    }

    public String getExTypeDesc() {
        return exTypeDesc;
    }

    public void setExTypeDesc(String exTypeDesc) {
        this.exTypeDesc = exTypeDesc;
    }

    public Integer getHasAttach() {
        return hasAttach;
    }

    public void setHasAttach(Integer hasAttach) {
        this.hasAttach = hasAttach;
    }

    public String getScanMan() {
        return scanMan;
    }

    public void setScanMan(String scanMan) {
        this.scanMan = scanMan;
    }

    public String getScanDeviceCode() {
        return scanDeviceCode;
    }

    public void setScanDeviceCode(String scanDeviceCode) {
        this.scanDeviceCode = scanDeviceCode;
    }

    public Integer getScanType() {
        return scanType;
    }

    public void setScanType(Integer scanType) {
        this.scanType = scanType;
    }

    public String getScanSource() {
        return scanSource;
    }

    public void setScanSource(String scanSource) {
        this.scanSource = scanSource;
    }



    public Integer getDataStatus() {
        return dataStatus;
    }

    public void setDataStatus(Integer dataStatus) {
        this.dataStatus = dataStatus;
    }

    public String getSubBillNo() {
        return subBillNo;
    }

    public void setSubBillNo(String subBillNo) {
        this.subBillNo = subBillNo;
    }

    public String getAttachUrl() {
        return attachUrl;
    }

    public void setAttachUrl(String attachUrl) {
        this.attachUrl = attachUrl;
    }

    public String getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(String currentTime) {
        this.currentTime = currentTime;
    }
}
