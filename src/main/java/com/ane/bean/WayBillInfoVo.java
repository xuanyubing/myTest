package com.ane.bean;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @ClassName: WayBillInfoVo
 * 录单实体类
 * @Date: 2021/6/1 13:29
 * @Author: sh
 */

public class WayBillInfoVo implements Serializable {
    /**
     * 开单主单号
     */
    private String waybillInfoWaybillNo;
    /**
     * 单号类型
     */
    private Integer waybillInfoBillType;
    /**
     * 开单日期
     */
    private String waybillInfoSendDate;
    /**
     * 寄件网点
     */
    private String waybillInfoSendSiteCode;
    /**
     * 寄件网点
     */
    private String waybillInfoSendSiteName;
    /**
     * 开单件数
     */
    private Integer waybillInfoTotalPiece;
    /**
     * 寄件一级网点
     */
    private String waybillInfoSendFirstSiteCode;
    /**
     * 省区
     */
    private String waybillInfoSendProvinceCode;
    /**
     * 大区
     */
    private String waybillInfoSendBigAreaCode;
    private String waybillInfoSendCodePath;
    /**
     * 收件员工
     */
    private String waybillInfoCollectEmpCode;
    /**
     * 收件员工名称
     */
    private String waybillInfoCollectEmpName;
    /**
     * 目的网点
     */
    private String waybillInfoDestSiteCode;
    /**
     * 目的网点对应一级网点
     */
    private String waybillInfoDestFirstSiteCode;
    /**
     * 目的分拨
     */
    private String waybillInfoDestCenterCode;
    /**
     * 省区
     */
    private String waybillInfoDestProvinceCode;
    /**
     * 大区
     */
    private String waybillInfoDestBigAreaCode;
    private String waybillInfoDestCodePath;
    /**
     * 收件员工名称
     */
    private String waybillContactSiteInfoCollectEmpName;
    /**
     * 寄件网点
     */
    private String waybillContactSiteInfoSendSiteName;
    private String waybillContactSiteInfoSendFirstSiteName;
    /**
     * 网点在max系统中对应的分拨中心编码
     */
    private String waybillContactSiteInfoSendCenterName;
    /**
     * 对应财务中心编码
     */
    private String waybillContactSiteInfoSendFinanceSiteCode;
    private String waybillContactSiteInfoSendFinanceSiteName;
    /**
     * 对应结算中心编码
     */
    private String waybillContactSiteInfoSendAccountSiteCode;
    private String waybillContactSiteInfoSendAccountSiteName;
    /**
     * 省区
     */
    private String waybillContactSiteInfoSendProvinceCode;
    private String waybillContactSiteInfoSendProvinceName;
    /**
     * 大区
     */
    private String waybillContactSiteInfoSendBigAreaCode;
    private String waybillContactSiteInfoSendBigAreaName;
    /**
     * 目的网点
     */
    private String waybillContactSiteInfoDestSiteName;
    /**
     * 目的分拨
     */
    private String waybillContactSiteInfoDestFirstSiteName;
    /**
     * 网点在max系统中对应的分拨中心编码
     */
    private String waybillContactSiteInfoDestCenterName;
    /**
     * 对应财务中心编码
     */
    private String waybillContactSiteInfoDestFinanceSiteCode;
    private String waybillContactSiteInfoDestFinanceSiteName;
    /**
     * 对应结算中心编码
     */
    private String waybillContactSiteInfoDestAccountSiteCode;
    private String waybillContactSiteInfoDestAccountSiteName;
    /**
     * 省区
     */
    private String waybillContactSiteInfoDestProvinceCode;
    private String waybillContactSiteInfoDestProvinceName;
    /**
     * 大区
     */
    private String waybillContactSiteInfoDestBigAreaCode;
    private String waybillContactSiteInfoDestBigAreaName;
    /**
     * 直发车分拨
     */
    private String waybillContactSiteInfoDirectTrainCenterCode;
    private String waybillContactSiteInfoDirectTrainCenterName;
    /**
     * 产品线
     */
    private String waybillInfoProductLineCode;
    /**
     * 产品类型
     */
    private String waybillInfoProductTypeCode;
    /**
     * 货物总重量
     */
    private BigDecimal waybillInfoTotalWeight;
    /**
     * 货物结算重量
     */
    private BigDecimal waybillInfoCalcWeight;
    /**
     * 货物尺寸
     */
    private String waybillInfoPackageSize;
    /**
     * 货物最长边
     */
    private BigDecimal waybillInfoMaxLength;
    /**
     * 特殊件数 与最长边结合使用    有特殊件数则一定有最长边
     */
    private Integer waybillInfoSpecialNum;
    /**
     * 平均重量   ----   通过计算得出   TotalWeight ／ TotalPiece
     */
    private BigDecimal waybillInfoAvgWeight;
    /**
     * 平均体积   ----   通过计算得出    TotalVol ／ TotalPiece
     */
    private BigDecimal waybillInfoAvgVolume;
    /**
     * 总体积
     */
    private BigDecimal waybillInfoTotalVol;
    /**
     * 总体积重
     */
    private BigDecimal waybillInfoTotalVolWeight;
    /**
     * 中转体积重
     */
    private BigDecimal waybillInfoTransVolWeight;
    /**
     * 回单号
     */
    private String waybillInfoReceiptWaybillNo;
    /**
     * 回单类型  （10：纸质回单；20：电子回单）
     */
    private Integer waybillInfoReceiptType;
    /**
     * 回单返回类型 （10：原单返回；20：拍照返回）
     */
    private Integer waybillInfoReceiptReturnType;
    /**
     * 创建人编号
     */
    private String waybillInfoCreatorCode;
    /**
     * 修改人编号
     */
    private String waybillInfoUpdateCode;
    /**
     * 运单开单总金额
     */
    private BigDecimal waybillInfoTotalAmount;
    /**
     * 运单开单公司收网点费用
     */
    /**
     * 中转费结算重量
     */
    private BigDecimal waybillAneAmountTransCalcWeight;
    /**
     * 记抛比模式
     */
    private int waybillAneAmountCalcThrowModel;
    private int waybillAneAmountThrowNum;
    private int waybillAneAmountOfferDiscount;
    /**
     * 网点中转费报价打折标识
     */
    private Integer waybillAneAmountOfferDiscount4Site;
    /**
     * 政策下放
     */
    private Integer waybillAneAmountTransferPolicy;
    /**
     * 中转费
     */
    private BigDecimal waybillAneAmountTransAmount;
    /**
     * 收寄站派费
     */
    private BigDecimal waybillAneAmountDispatchAmount;
    /**
     * 客户运费报价
     */
    private BigDecimal waybillAneAmountCusFreightAmount;
    /**
     * 收保费
     */
    private BigDecimal waybillAneAmountPremiumAmount;
    /**
     * 付派站派件费
     */
    private BigDecimal waybillAneAmountPayDispatcherAmount;
    /**
     * 收出货红利基金1362
     */
    private BigDecimal waybillAneAmountBonusPoolFee;
    /**
     * 收寄站操作费
     */
    private BigDecimal waybillAneAmountOptAmount;
    /**
     * 燃油费
     */
    private BigDecimal waybillAneAmountFuelAmount;
    /**
     * 会务费
     */
    private BigDecimal waybillAneAmountMeetingAmount;
    /**
     * 会务费补贴
     */
    private BigDecimal waybillAneAmountMeetingSubsidyAmount;
    /**
     * 付派站操作费
     */
    private BigDecimal waybillAneAmountPaySendOperationAmount;
    /**
     * 到付操作费
     */
    private BigDecimal waybillAneAmountArriveOptAmount;
    /**
     * 付派站保费
     */
    private BigDecimal waybillAneAmountPayPremiumAmount;
    /**
     * 付派站回单费
     */
    private BigDecimal waybillAneAmountReceiptAmount;
    /**
     * 扣寄站到付款手续费
     */
    private BigDecimal waybillAneAmountCollectAmount;
    /**
     * 付派站到付款手续费
     */
    private BigDecimal waybillAneAmountPayDispatchCollectAmount;
    /**
     * 收寄站代收货款操作费
     */
    private BigDecimal waybillAneAmountCodOptAmount;
    /**
     * 收服务补贴
     */
    private BigDecimal waybillAneAmountReceiveSendFee;
    /**
     * 网点中转费
     */
    private BigDecimal waybillAneAmountSiteTransAmount;
    /**
     * 网点收派件费
     */
    private BigDecimal waybillAneAmountSiteReDispachFee;
    /**
     * 网点付派件费
     */
    private BigDecimal waybillAneAmountSitePayDispatchFee;
    /**
     * 提货费
     */
    private BigDecimal waybillAneAmountPickUpAmount;
    /**
     * 派送费
     */
    private BigDecimal waybillAneAmountDeliveryAmount;
    /**
     * 客户保险费
     */
    private BigDecimal waybillAneAmountCusPremiumAmount;
    /**
     * 燃油附加费
     */
    private BigDecimal waybillAneAmountFuelAddAmount;
    /**
     * 制单费
     */
    private BigDecimal waybillAneAmountDocumentAmount;
    /**
     * 收上楼费
     */
    private BigDecimal waybillAneAmountStairsAmount;
    /**
     * 付上楼费
     */
    private BigDecimal waybillAneAmountPayStairsAmount;
    /**
     * 派件代收货款
     */
    private BigDecimal waybillAneAmountCodCharge;
    /**
     * 子单返款
     */
    private BigDecimal waybillAneAmountSonBillReturnAmount;
    /**
     * 寄件到付款
     */
    private BigDecimal waybillAneAmountSendPayMent;
    /**
     * 派件到付款
     */
    private BigDecimal waybillAneAmountDispatchPayMent;
    /**
     * 代收货款扣寄件客户手续费
     */
    private BigDecimal waybillAneAmountCodBuckSendCustomerFee;
    /**
     * 代收货款付派站手续费
     */
    private BigDecimal waybillAneAmountCodPayDispatchFee;
    /**
     * 付派站服务补贴
     */
    private BigDecimal waybillAneAmountPayDispatchServiceFee;
    /**
     * 付出货红利基金
     */
    private BigDecimal waybillAneAmountPayBonusPoolFee;
    /**
     * 网点费用。费用类型
     */
    private BigDecimal waybillAneAmountPriceTypeMap;
    /**
     * 易碎品服务费
     */
    private BigDecimal waybillAneAmountFragileGoodsFee;
    /**
     *
     */
    private BigDecimal waybillAneAmountFreightAmount;
    /**
     *
     */
    private BigDecimal waybillAneAmountQuoteType;
    /**
     * 收超重费
     */
    private BigDecimal waybillAneAmountOverWeightAmount;
    /**
     * 电商入仓费
     */
    private BigDecimal waybillAneAmountWareHouseCharge;
    /**
     * 付派站超重费
     */
    private BigDecimal waybillAneAmountPayOverWeightAmount;
    /**
     * 网点收寄站到付手续费
     */
    private BigDecimal waybillAneAmountSiteReArrivePayFee;
    /**
     * 网点付到付款手续费
     */
    private BigDecimal waybillAneAmountSiteDisArrivePayFee;
    /**
     * 网点会务费
     */
    private BigDecimal waybillAneAmountSiteMeetingAmount;
    /**
     * 公里费
     */
    private BigDecimal waybillAneAmountKiloMetreAmount;
    /**
     * 卸货费
     */
    private BigDecimal waybillAneAmountDisChargeCargoAmount;
    /**
     * 运单开单网点收客户总金额
     */
    private BigDecimal waybillInfoSiteTotalAmount;
    /**
     * 网点收客户费用明细
     */
    /**
     * 支付方编码
     */
    private String waybillSiteAmountPayerTypeCode;
    /**
     * 支付方
     */
    private String waybillSiteAmountPayerType;
    /**
     * 支付方式
     * 10: 现金
     * 20: 月结
     * 30: 到付
     */
    private String waybillSiteAmountPaymentType;
    /**
     * 货币类型;默认为人民币
     */
    private String waybillSiteAmountCurrency;
    /**
     * 楼梯类型
     */
    private String waybillSiteAmountStairType;
    /**
     * 收客户总费用
     */
    private BigDecimal waybillSiteAmountTotalCustomerAmount;
    /**
     * 保价金额
     */
    private BigDecimal waybillSiteAmountInsuredAmount;
    /**
     * 保价费
     */
    private BigDecimal waybillSiteAmountPremiumAmount;
    /**
     * 运费
     */
    private BigDecimal waybillSiteAmountFreightAmount;
    /**
     * 原始实收运费金额
     */
    private BigDecimal waybillSiteAmountFirstFreightAmount;
    /**
     * 开箱清点费
     */
    private BigDecimal waybillSiteAmountBoxCheckAmount;
    /**
     * 上楼费
     */
    private BigDecimal waybillSiteAmountUpStairsAmount;
    /**
     * 清点费
     */
    private BigDecimal waybillSiteAmountCheckAmount;
    /**
     * 转退件、代取件费
     */
    private BigDecimal waybillSiteAmountTrunsAmount;
    /**
     * 进仓服务费
     */
    private BigDecimal waybillSiteAmountInWarehouseAmount;
    /**
     * 特殊区域加收服务费
     */
    private BigDecimal waybillSiteAmountSpecialAreaAmount;
    /**
     * 特殊货物上楼费
     */
    private BigDecimal waybillSiteAmountSpecialUpStairsAmount;
    /**
     * 超标货物上楼费
     */
    private BigDecimal waybillSiteAmountPassStandardUpStairsAmount;
    /**
     * 盲区请车费
     */
    private BigDecimal waybillSiteAmountBlindZoneCarAmount;
    /**
     * 加急货物请车费
     */
    private BigDecimal waybillSiteAmountUrgentCarAmount;
    /**
     * 超标货物请车费
     */
    private BigDecimal waybillSiteAmountPassStandardCarAmount;
    /**
     * 其他费用
     */
    private BigDecimal waybillSiteAmountOtherAmount;
    /**
     * 费用备注信息
     */
    private String waybillSiteAmountRemark;
    /**
     * 网点单票毛利
     */
    private BigDecimal waybillInfoGrossProfit;
    /**
     * 支付方式
     * 10: 现金
     * 20: 月结
     * 30: 到付
     */
    private String waybillInfoPaymentType;
    /**
     * 提送货类型
     */
    private String waybillInfoPickType;
    /**
     * 结算客户编码
     */
    private String waybillInfoCalcCustomerCode;
    /**
     * 运单所属客户账单
     */
    private String waybillInfoCalcCustomerBillNo;
    /**
     * 开单对应的收寄件信息
     */
    /**
     * 寄件客户是否为vip客户 10: 不是vip 20: 是vip
     */
    private Integer waybillSendReceiveInfoVip;
    /**
     * 寄件省份
     */
    private String waybillSendReceiveInfoSendProvince;
    private Integer waybillSendReceiveInfoSendProvinceCode;
    /**
     * 寄件城市
     */
    private String waybillSendReceiveInfoSendCity;
    private Integer waybillSendReceiveInfoSendCityCode;
    /**
     * 寄件区域
     */
    private String waybillSendReceiveInfoSendDistrict;
    private Integer waybillSendReceiveInfoSendDistrictCode;
    /**
     * 寄件街道
     */
    private String waybillSendReceiveInfoSendStreet;
    private Integer waybillSendReceiveInfoSendStreetCode;
    /**
     * 寄件地址
     */
    private String waybillSendReceiveInfoSendAddress;
    /**
     * 寄件人编码   -----     前台选择客户后传递的编码
     */
    private String waybillSendReceiveInfoSenderCode;
    /**
     * 寄件人姓名 /  公司简称
     */
    private String waybillSendReceiveInfoSenderName;
    /**
     * 寄件人公司  /  公司全称
     */
    private String waybillSendReceiveInfoSenderCompany;
    /**
     * 寄件人手机
     * 如果发送短信,则使用该字段
     */
    private String waybillSendReceiveInfoSenderMobile;
    /**
     * 寄件联系人
     */
    private String waybillSendReceiveInfoSenderLinkMan;
    /**
     * 寄件人电话
     */
    private String waybillSendReceiveInfoSenderPhone;
    /**
     * 寄件人证件类型
     * 10 身份证
     */
    private int waybillSendReceiveInfoSenderCardType;
    /**
     * 寄件人证件号
     */
    private String waybillSendReceiveInfoSenderCardNo;
    /**
     * 寄件邮编
     */
    private String waybillSendReceiveInfoSenderPostCode;
    /**
     * 收件省份
     */
    private Integer waybillSendReceiveInfoReceiveProvinceCode;
    private String waybillSendReceiveInfoReceiveProvince;
    /**
     * 收件城市
     */
    private Integer waybillSendReceiveInfoReceiveCityCode;
    private String waybillSendReceiveInfoReceiveCity;
    /**
     * 收件区域
     */
    private Integer waybillSendReceiveInfoReceiveDistrictCode;
    private String waybillSendReceiveInfoReceiveDistrict;
    /**
     * 收件街道
     */
    private Integer waybillSendReceiveInfoReceiveStreetCode;
    private String waybillSendReceiveInfoReceiveStreet;
    /**
     * 收件地址
     */
    private String waybillSendReceiveInfoReceiveAddress;
    /**
     * 收件人编码 -----     前台选择客户后传递的编码
     */
    private String waybillSendReceiveInfoReceiverCode;
    /**
     * 收件人姓名
     */
    private String waybillSendReceiveInfoReceiverName;
    /**
     * 收件人公司
     */
    private String waybillSendReceiveInfoReceiverCompany;
    /**
     * 收件人手机
     */
    private String waybillSendReceiveInfoReceiverMobile;
    /**
     * 收件联系人
     */
    private String waybillSendReceiveInfoReceiverLinkMan;
    /**
     * 收件人电话
     */
    private String waybillSendReceiveInfoReceiverPhone;
    /**
     * 收件人证件类型
     * 10 身份证
     */
    private int waybillSendReceiveInfoReceiverCardType;
    /**
     * 收件人证件号
     */
    private String waybillSendReceiveInfoReceiverCardNo;
    /**
     * 收件邮编
     */
    private String waybillSendReceiveInfoReceiverPostCode;
    /**
     * 运单状态
     */
    private Integer waybillInfoBillStatus;
    /**
     * 运单状态修改时间
     */
    private String waybillInfoWaybillStatusDate;
    /**
     * 走货路由 --- 可能并不存在
     */
    private String waybillInfoWaybillRoute;
    /**
     * 发件分拨
     */
    private String waybillInfoSendCenterCode;
    /**
     * 开单数据来源
     */
    private Integer waybillInfoWaybillSource;
    /**
     * 数据录入方式;
     * 10扫描 20 手工输入
     */
    private Integer waybillInfoOperatorType;
    /**
     * 设备编码
     */
    private String waybillInfoDeviceNo;
    /**
     * 货物类型;
     * eg: 文件、普通货物、床垫
     */
    private String waybillInfoGoodsType;
    /**
     * 货物类别
     * eg：易碎品、普通货物
     */
    private String waybillInfoGoodsCategory;
    /**
     * 货物属性   重货、重抛、轻抛
     */
    private String waybillInfoGoodsProp;
    /**
     * 货物信息
     */
    /**
     * 向上件
     */
    private Integer waybillGoodsInfoUpward;
    /**
     * 勿压件
     */
    private Integer waybillGoodsInfoUnPress;
    /**
     * 特殊件数
     */
    private Integer waybillGoodsInfoSpecialNum;
    /**
     * 长宽高件数 1.0X1.0X2.2X2
     */
    private String waybillGoodsInfoVolEl;
    /**
     * 货物类型;
     * eg: 文件、普通货物、床垫
     */
    private String waybillGoodsInfoGoodsType;
    /**
     * 货物类别
     * eg：易碎品、普通货物
     */
    private String waybillGoodsInfoGoodsCategory;
    /**
     * 物品名称
     */
    private String waybillGoodsInfoGoodsName;
    /**
     * 物品描述 --- 内件说明
     */
    private String waybillGoodsInfoGoodsDesc;
    /**
     * 包装类型
     */
    private String waybillGoodsInfoPackType;
    /**
     * 订单信息
     */
    /**
     * 电商来源
     */
    private Integer WaybillOrderInfoEcommerceSource;
    /**
     * 电商仓库
     */
    private Integer WaybillOrderInfoEcommerceWarehouse;
    /**
     * 订单号
     */
    private String WaybillOrderInfoOrderNo;
    /**
     * 照片上传时间
     */
    private String waybillInfoPhotoUploadTime;
    /**
     * 照片回传时间
     */
    private String waybillInfoPhotoBackTime;
    private Integer waybillInfoStatus;
    private String waybillInfoRemark;
    /**
     * 代收银行信息
     */
    /**
     * 代收货款币
     */
    private String waybillCodBankInfoCodCurrency;
    /**
     * 代收款支付方式编码
     */
    private String waybillCodBankInfoCodPayMode;
    /**
     * 代收款支付方式名称
     */
    private String waybillCodBankInfoCodPayModeName;
    /**
     * 返款实效,T + N (只保留n)   -----    返回时效对应的字典编码
     */
    private String waybillCodBankInfoReturnTime;
    /**
     * 开户名
     */
    private String waybillCodBankInfoCodAccountName;
    /**
     * 开户行名称
     */
    private String waybillCodBankInfoCodBankName;
    /**
     * 开户账号
     */
    private String waybillCodBankInfoCodAccountNo;
    /**
     * 寄件账户银行地区
     */
    private String waybillCodBankInfoCodBankArea;
    /**
     * 寄件账户省份名称
     */
    private String waybillCodBankInfoCodProvinceName;
    /**
     * 寄件账户城市名称
     */
    private String waybillCodBankInfoCodCityName;
    /**
     * 寄件账户银行网点
     */
    private String waybillCodBankInfoCodBankSite;
    /**
     * 寄件账户联行号
     */
    private String waybillCodBankInfoCodCombinenum;
    /**
     * 收款人手机号
     */
    private String waybillCodBankInfoSenderMobile;
    /**
     * 账号类型
     * 10是个人
     * 20是事业单位
     * 30 是公司
     */
    private String waybillCodBankInfoAccountType;
    /**
     * 时效要求(10：产品时效，20：次日达，30：隔日达)
     */
    private Integer busiAttributeslimitationPeriod;
    /**
     * 是否优质产品(10：是，20：否)
     */
    private Integer busiAttributesProductProperties;
    /**
     * 是否省内件(省内件10   非省内件20)
     */
    private Integer busiAttributesprovincePiece;
    /**
     * 代收金额
     */
    private BigDecimal waybillInfoCodAmount;
    /**
     * 运单信息订阅
     * eg:
     * new Integer[]{
     * 110,  -- 不发送开单短信
     * 122,  -- 发送发件短信给寄件客户
     * 130,  -- 不发送到件短信
     * 141,  -- 发送派件短信给收件客户
     * 152   -- 发送签收短信给寄件客户
     * }
     */
    private String waybillInfoSubscribeFlag;
    /**
     * 子单号
     */
    private String waybillInfoSubEwbNo;

    /**
     * 寄件网点分片索引
     */
    private Integer waybillInfoSendProvinceIndex;
    /**
     * 目的网点省份   ------ 通过计算得出   不能传参    与SendProvinceIndex值一样
     */
    private Integer waybillInfoDestProvinceIndex;

    private String waybillInfoupdateDate;

    private String currentTime;

    public String getWaybillInfoWaybillNo() {
        return waybillInfoWaybillNo;
    }

    public void setWaybillInfoWaybillNo(String waybillInfoWaybillNo) {
        this.waybillInfoWaybillNo = waybillInfoWaybillNo;
    }

    public Integer getWaybillInfoBillType() {
        return waybillInfoBillType;
    }

    public void setWaybillInfoBillType(Integer waybillInfoBillType) {
        this.waybillInfoBillType = waybillInfoBillType;
    }

    public String getWaybillInfoSendDate() {
        return waybillInfoSendDate;
    }

    public void setWaybillInfoSendDate(String waybillInfoSendDate) {
        this.waybillInfoSendDate = waybillInfoSendDate;
    }

    public String getWaybillInfoSendSiteCode() {
        return waybillInfoSendSiteCode;
    }

    public void setWaybillInfoSendSiteCode(String waybillInfoSendSiteCode) {
        this.waybillInfoSendSiteCode = waybillInfoSendSiteCode;
    }

    public String getWaybillInfoSendSiteName() {
        return waybillInfoSendSiteName;
    }

    public void setWaybillInfoSendSiteName(String waybillInfoSendSiteName) {
        this.waybillInfoSendSiteName = waybillInfoSendSiteName;
    }

    public Integer getWaybillInfoTotalPiece() {
        return waybillInfoTotalPiece;
    }

    public void setWaybillInfoTotalPiece(Integer waybillInfoTotalPiece) {
        this.waybillInfoTotalPiece = waybillInfoTotalPiece;
    }

    public String getWaybillInfoSendFirstSiteCode() {
        return waybillInfoSendFirstSiteCode;
    }

    public void setWaybillInfoSendFirstSiteCode(String waybillInfoSendFirstSiteCode) {
        this.waybillInfoSendFirstSiteCode = waybillInfoSendFirstSiteCode;
    }

    public String getWaybillInfoSendProvinceCode() {
        return waybillInfoSendProvinceCode;
    }

    public void setWaybillInfoSendProvinceCode(String waybillInfoSendProvinceCode) {
        this.waybillInfoSendProvinceCode = waybillInfoSendProvinceCode;
    }

    public String getWaybillInfoSendBigAreaCode() {
        return waybillInfoSendBigAreaCode;
    }

    public void setWaybillInfoSendBigAreaCode(String waybillInfoSendBigAreaCode) {
        this.waybillInfoSendBigAreaCode = waybillInfoSendBigAreaCode;
    }

    public String getWaybillInfoSendCodePath() {
        return waybillInfoSendCodePath;
    }

    public void setWaybillInfoSendCodePath(String waybillInfoSendCodePath) {
        this.waybillInfoSendCodePath = waybillInfoSendCodePath;
    }

    public String getWaybillInfoCollectEmpCode() {
        return waybillInfoCollectEmpCode;
    }

    public void setWaybillInfoCollectEmpCode(String waybillInfoCollectEmpCode) {
        this.waybillInfoCollectEmpCode = waybillInfoCollectEmpCode;
    }

    public String getWaybillInfoCollectEmpName() {
        return waybillInfoCollectEmpName;
    }

    public void setWaybillInfoCollectEmpName(String waybillInfoCollectEmpName) {
        this.waybillInfoCollectEmpName = waybillInfoCollectEmpName;
    }

    public String getWaybillInfoDestSiteCode() {
        return waybillInfoDestSiteCode;
    }

    public void setWaybillInfoDestSiteCode(String waybillInfoDestSiteCode) {
        this.waybillInfoDestSiteCode = waybillInfoDestSiteCode;
    }

    public String getWaybillInfoDestFirstSiteCode() {
        return waybillInfoDestFirstSiteCode;
    }

    public void setWaybillInfoDestFirstSiteCode(String waybillInfoDestFirstSiteCode) {
        this.waybillInfoDestFirstSiteCode = waybillInfoDestFirstSiteCode;
    }

    public String getWaybillInfoDestCenterCode() {
        return waybillInfoDestCenterCode;
    }

    public void setWaybillInfoDestCenterCode(String waybillInfoDestCenterCode) {
        this.waybillInfoDestCenterCode = waybillInfoDestCenterCode;
    }

    public String getWaybillInfoDestProvinceCode() {
        return waybillInfoDestProvinceCode;
    }

    public void setWaybillInfoDestProvinceCode(String waybillInfoDestProvinceCode) {
        this.waybillInfoDestProvinceCode = waybillInfoDestProvinceCode;
    }

    public String getWaybillInfoDestBigAreaCode() {
        return waybillInfoDestBigAreaCode;
    }

    public void setWaybillInfoDestBigAreaCode(String waybillInfoDestBigAreaCode) {
        this.waybillInfoDestBigAreaCode = waybillInfoDestBigAreaCode;
    }

    public String getWaybillInfoDestCodePath() {
        return waybillInfoDestCodePath;
    }

    public void setWaybillInfoDestCodePath(String waybillInfoDestCodePath) {
        this.waybillInfoDestCodePath = waybillInfoDestCodePath;
    }

    public String getWaybillContactSiteInfoCollectEmpName() {
        return waybillContactSiteInfoCollectEmpName;
    }

    public void setWaybillContactSiteInfoCollectEmpName(String waybillContactSiteInfoCollectEmpName) {
        this.waybillContactSiteInfoCollectEmpName = waybillContactSiteInfoCollectEmpName;
    }

    public String getWaybillContactSiteInfoSendSiteName() {
        return waybillContactSiteInfoSendSiteName;
    }

    public void setWaybillContactSiteInfoSendSiteName(String waybillContactSiteInfoSendSiteName) {
        this.waybillContactSiteInfoSendSiteName = waybillContactSiteInfoSendSiteName;
    }

    public String getWaybillContactSiteInfoSendFirstSiteName() {
        return waybillContactSiteInfoSendFirstSiteName;
    }

    public void setWaybillContactSiteInfoSendFirstSiteName(String waybillContactSiteInfoSendFirstSiteName) {
        this.waybillContactSiteInfoSendFirstSiteName = waybillContactSiteInfoSendFirstSiteName;
    }

    public String getWaybillContactSiteInfoSendCenterName() {
        return waybillContactSiteInfoSendCenterName;
    }

    public void setWaybillContactSiteInfoSendCenterName(String waybillContactSiteInfoSendCenterName) {
        this.waybillContactSiteInfoSendCenterName = waybillContactSiteInfoSendCenterName;
    }

    public String getWaybillContactSiteInfoSendFinanceSiteCode() {
        return waybillContactSiteInfoSendFinanceSiteCode;
    }

    public void setWaybillContactSiteInfoSendFinanceSiteCode(String waybillContactSiteInfoSendFinanceSiteCode) {
        this.waybillContactSiteInfoSendFinanceSiteCode = waybillContactSiteInfoSendFinanceSiteCode;
    }

    public String getWaybillContactSiteInfoSendFinanceSiteName() {
        return waybillContactSiteInfoSendFinanceSiteName;
    }

    public void setWaybillContactSiteInfoSendFinanceSiteName(String waybillContactSiteInfoSendFinanceSiteName) {
        this.waybillContactSiteInfoSendFinanceSiteName = waybillContactSiteInfoSendFinanceSiteName;
    }

    public String getWaybillContactSiteInfoSendAccountSiteCode() {
        return waybillContactSiteInfoSendAccountSiteCode;
    }

    public void setWaybillContactSiteInfoSendAccountSiteCode(String waybillContactSiteInfoSendAccountSiteCode) {
        this.waybillContactSiteInfoSendAccountSiteCode = waybillContactSiteInfoSendAccountSiteCode;
    }

    public String getWaybillContactSiteInfoSendAccountSiteName() {
        return waybillContactSiteInfoSendAccountSiteName;
    }

    public void setWaybillContactSiteInfoSendAccountSiteName(String waybillContactSiteInfoSendAccountSiteName) {
        this.waybillContactSiteInfoSendAccountSiteName = waybillContactSiteInfoSendAccountSiteName;
    }

    public String getWaybillContactSiteInfoSendProvinceCode() {
        return waybillContactSiteInfoSendProvinceCode;
    }

    public void setWaybillContactSiteInfoSendProvinceCode(String waybillContactSiteInfoSendProvinceCode) {
        this.waybillContactSiteInfoSendProvinceCode = waybillContactSiteInfoSendProvinceCode;
    }

    public String getWaybillContactSiteInfoSendProvinceName() {
        return waybillContactSiteInfoSendProvinceName;
    }

    public void setWaybillContactSiteInfoSendProvinceName(String waybillContactSiteInfoSendProvinceName) {
        this.waybillContactSiteInfoSendProvinceName = waybillContactSiteInfoSendProvinceName;
    }

    public String getWaybillContactSiteInfoSendBigAreaCode() {
        return waybillContactSiteInfoSendBigAreaCode;
    }

    public void setWaybillContactSiteInfoSendBigAreaCode(String waybillContactSiteInfoSendBigAreaCode) {
        this.waybillContactSiteInfoSendBigAreaCode = waybillContactSiteInfoSendBigAreaCode;
    }

    public String getWaybillContactSiteInfoSendBigAreaName() {
        return waybillContactSiteInfoSendBigAreaName;
    }

    public void setWaybillContactSiteInfoSendBigAreaName(String waybillContactSiteInfoSendBigAreaName) {
        this.waybillContactSiteInfoSendBigAreaName = waybillContactSiteInfoSendBigAreaName;
    }

    public String getWaybillContactSiteInfoDestSiteName() {
        return waybillContactSiteInfoDestSiteName;
    }

    public void setWaybillContactSiteInfoDestSiteName(String waybillContactSiteInfoDestSiteName) {
        this.waybillContactSiteInfoDestSiteName = waybillContactSiteInfoDestSiteName;
    }

    public String getWaybillContactSiteInfoDestFirstSiteName() {
        return waybillContactSiteInfoDestFirstSiteName;
    }

    public void setWaybillContactSiteInfoDestFirstSiteName(String waybillContactSiteInfoDestFirstSiteName) {
        this.waybillContactSiteInfoDestFirstSiteName = waybillContactSiteInfoDestFirstSiteName;
    }

    public String getWaybillContactSiteInfoDestCenterName() {
        return waybillContactSiteInfoDestCenterName;
    }

    public void setWaybillContactSiteInfoDestCenterName(String waybillContactSiteInfoDestCenterName) {
        this.waybillContactSiteInfoDestCenterName = waybillContactSiteInfoDestCenterName;
    }

    public String getWaybillContactSiteInfoDestFinanceSiteCode() {
        return waybillContactSiteInfoDestFinanceSiteCode;
    }

    public void setWaybillContactSiteInfoDestFinanceSiteCode(String waybillContactSiteInfoDestFinanceSiteCode) {
        this.waybillContactSiteInfoDestFinanceSiteCode = waybillContactSiteInfoDestFinanceSiteCode;
    }

    public String getWaybillContactSiteInfoDestFinanceSiteName() {
        return waybillContactSiteInfoDestFinanceSiteName;
    }

    public void setWaybillContactSiteInfoDestFinanceSiteName(String waybillContactSiteInfoDestFinanceSiteName) {
        this.waybillContactSiteInfoDestFinanceSiteName = waybillContactSiteInfoDestFinanceSiteName;
    }

    public String getWaybillContactSiteInfoDestAccountSiteCode() {
        return waybillContactSiteInfoDestAccountSiteCode;
    }

    public void setWaybillContactSiteInfoDestAccountSiteCode(String waybillContactSiteInfoDestAccountSiteCode) {
        this.waybillContactSiteInfoDestAccountSiteCode = waybillContactSiteInfoDestAccountSiteCode;
    }

    public String getWaybillContactSiteInfoDestAccountSiteName() {
        return waybillContactSiteInfoDestAccountSiteName;
    }

    public void setWaybillContactSiteInfoDestAccountSiteName(String waybillContactSiteInfoDestAccountSiteName) {
        this.waybillContactSiteInfoDestAccountSiteName = waybillContactSiteInfoDestAccountSiteName;
    }

    public String getWaybillContactSiteInfoDestProvinceCode() {
        return waybillContactSiteInfoDestProvinceCode;
    }

    public void setWaybillContactSiteInfoDestProvinceCode(String waybillContactSiteInfoDestProvinceCode) {
        this.waybillContactSiteInfoDestProvinceCode = waybillContactSiteInfoDestProvinceCode;
    }

    public String getWaybillContactSiteInfoDestProvinceName() {
        return waybillContactSiteInfoDestProvinceName;
    }

    public void setWaybillContactSiteInfoDestProvinceName(String waybillContactSiteInfoDestProvinceName) {
        this.waybillContactSiteInfoDestProvinceName = waybillContactSiteInfoDestProvinceName;
    }

    public String getWaybillContactSiteInfoDestBigAreaCode() {
        return waybillContactSiteInfoDestBigAreaCode;
    }

    public void setWaybillContactSiteInfoDestBigAreaCode(String waybillContactSiteInfoDestBigAreaCode) {
        this.waybillContactSiteInfoDestBigAreaCode = waybillContactSiteInfoDestBigAreaCode;
    }

    public String getWaybillContactSiteInfoDestBigAreaName() {
        return waybillContactSiteInfoDestBigAreaName;
    }

    public void setWaybillContactSiteInfoDestBigAreaName(String waybillContactSiteInfoDestBigAreaName) {
        this.waybillContactSiteInfoDestBigAreaName = waybillContactSiteInfoDestBigAreaName;
    }

    public String getWaybillContactSiteInfoDirectTrainCenterCode() {
        return waybillContactSiteInfoDirectTrainCenterCode;
    }

    public void setWaybillContactSiteInfoDirectTrainCenterCode(String waybillContactSiteInfoDirectTrainCenterCode) {
        this.waybillContactSiteInfoDirectTrainCenterCode = waybillContactSiteInfoDirectTrainCenterCode;
    }

    public String getWaybillContactSiteInfoDirectTrainCenterName() {
        return waybillContactSiteInfoDirectTrainCenterName;
    }

    public void setWaybillContactSiteInfoDirectTrainCenterName(String waybillContactSiteInfoDirectTrainCenterName) {
        this.waybillContactSiteInfoDirectTrainCenterName = waybillContactSiteInfoDirectTrainCenterName;
    }

    public String getWaybillInfoProductLineCode() {
        return waybillInfoProductLineCode;
    }

    public void setWaybillInfoProductLineCode(String waybillInfoProductLineCode) {
        this.waybillInfoProductLineCode = waybillInfoProductLineCode;
    }

    public String getWaybillInfoProductTypeCode() {
        return waybillInfoProductTypeCode;
    }

    public void setWaybillInfoProductTypeCode(String waybillInfoProductTypeCode) {
        this.waybillInfoProductTypeCode = waybillInfoProductTypeCode;
    }

    public BigDecimal getWaybillInfoTotalWeight() {
        return waybillInfoTotalWeight;
    }

    public void setWaybillInfoTotalWeight(BigDecimal waybillInfoTotalWeight) {
        this.waybillInfoTotalWeight = waybillInfoTotalWeight;
    }

    public BigDecimal getWaybillInfoCalcWeight() {
        return waybillInfoCalcWeight;
    }

    public void setWaybillInfoCalcWeight(BigDecimal waybillInfoCalcWeight) {
        this.waybillInfoCalcWeight = waybillInfoCalcWeight;
    }

    public String getWaybillInfoPackageSize() {
        return waybillInfoPackageSize;
    }

    public void setWaybillInfoPackageSize(String waybillInfoPackageSize) {
        this.waybillInfoPackageSize = waybillInfoPackageSize;
    }

    public BigDecimal getWaybillInfoMaxLength() {
        return waybillInfoMaxLength;
    }

    public void setWaybillInfoMaxLength(BigDecimal waybillInfoMaxLength) {
        this.waybillInfoMaxLength = waybillInfoMaxLength;
    }

    public Integer getWaybillInfoSpecialNum() {
        return waybillInfoSpecialNum;
    }

    public void setWaybillInfoSpecialNum(Integer waybillInfoSpecialNum) {
        this.waybillInfoSpecialNum = waybillInfoSpecialNum;
    }

    public BigDecimal getWaybillInfoAvgWeight() {
        return waybillInfoAvgWeight;
    }

    public void setWaybillInfoAvgWeight(BigDecimal waybillInfoAvgWeight) {
        this.waybillInfoAvgWeight = waybillInfoAvgWeight;
    }

    public BigDecimal getWaybillInfoAvgVolume() {
        return waybillInfoAvgVolume;
    }

    public void setWaybillInfoAvgVolume(BigDecimal waybillInfoAvgVolume) {
        this.waybillInfoAvgVolume = waybillInfoAvgVolume;
    }

    public BigDecimal getWaybillInfoTotalVol() {
        return waybillInfoTotalVol;
    }

    public void setWaybillInfoTotalVol(BigDecimal waybillInfoTotalVol) {
        this.waybillInfoTotalVol = waybillInfoTotalVol;
    }

    public BigDecimal getWaybillInfoTotalVolWeight() {
        return waybillInfoTotalVolWeight;
    }

    public void setWaybillInfoTotalVolWeight(BigDecimal waybillInfoTotalVolWeight) {
        this.waybillInfoTotalVolWeight = waybillInfoTotalVolWeight;
    }

    public BigDecimal getWaybillInfoTransVolWeight() {
        return waybillInfoTransVolWeight;
    }

    public void setWaybillInfoTransVolWeight(BigDecimal waybillInfoTransVolWeight) {
        this.waybillInfoTransVolWeight = waybillInfoTransVolWeight;
    }

    public String getWaybillInfoReceiptWaybillNo() {
        return waybillInfoReceiptWaybillNo;
    }

    public void setWaybillInfoReceiptWaybillNo(String waybillInfoReceiptWaybillNo) {
        this.waybillInfoReceiptWaybillNo = waybillInfoReceiptWaybillNo;
    }

    public Integer getWaybillInfoReceiptType() {
        return waybillInfoReceiptType;
    }

    public void setWaybillInfoReceiptType(Integer waybillInfoReceiptType) {
        this.waybillInfoReceiptType = waybillInfoReceiptType;
    }

    public Integer getWaybillInfoReceiptReturnType() {
        return waybillInfoReceiptReturnType;
    }

    public void setWaybillInfoReceiptReturnType(Integer waybillInfoReceiptReturnType) {
        this.waybillInfoReceiptReturnType = waybillInfoReceiptReturnType;
    }

    public String getWaybillInfoCreatorCode() {
        return waybillInfoCreatorCode;
    }

    public void setWaybillInfoCreatorCode(String waybillInfoCreatorCode) {
        this.waybillInfoCreatorCode = waybillInfoCreatorCode;
    }

    public String getWaybillInfoUpdateCode() {
        return waybillInfoUpdateCode;
    }

    public void setWaybillInfoUpdateCode(String waybillInfoUpdateCode) {
        this.waybillInfoUpdateCode = waybillInfoUpdateCode;
    }

    public BigDecimal getWaybillInfoTotalAmount() {
        return waybillInfoTotalAmount;
    }

    public void setWaybillInfoTotalAmount(BigDecimal waybillInfoTotalAmount) {
        this.waybillInfoTotalAmount = waybillInfoTotalAmount;
    }

    public BigDecimal getWaybillAneAmountTransCalcWeight() {
        return waybillAneAmountTransCalcWeight;
    }

    public void setWaybillAneAmountTransCalcWeight(BigDecimal waybillAneAmountTransCalcWeight) {
        this.waybillAneAmountTransCalcWeight = waybillAneAmountTransCalcWeight;
    }

    public int getWaybillAneAmountCalcThrowModel() {
        return waybillAneAmountCalcThrowModel;
    }

    public void setWaybillAneAmountCalcThrowModel(int waybillAneAmountCalcThrowModel) {
        this.waybillAneAmountCalcThrowModel = waybillAneAmountCalcThrowModel;
    }

    public int getWaybillAneAmountThrowNum() {
        return waybillAneAmountThrowNum;
    }

    public void setWaybillAneAmountThrowNum(int waybillAneAmountThrowNum) {
        this.waybillAneAmountThrowNum = waybillAneAmountThrowNum;
    }

    public int getWaybillAneAmountOfferDiscount() {
        return waybillAneAmountOfferDiscount;
    }

    public void setWaybillAneAmountOfferDiscount(int waybillAneAmountOfferDiscount) {
        this.waybillAneAmountOfferDiscount = waybillAneAmountOfferDiscount;
    }

    public Integer getWaybillAneAmountOfferDiscount4Site() {
        return waybillAneAmountOfferDiscount4Site;
    }

    public void setWaybillAneAmountOfferDiscount4Site(Integer waybillAneAmountOfferDiscount4Site) {
        this.waybillAneAmountOfferDiscount4Site = waybillAneAmountOfferDiscount4Site;
    }

    public Integer getWaybillAneAmountTransferPolicy() {
        return waybillAneAmountTransferPolicy;
    }

    public void setWaybillAneAmountTransferPolicy(Integer waybillAneAmountTransferPolicy) {
        this.waybillAneAmountTransferPolicy = waybillAneAmountTransferPolicy;
    }

    public BigDecimal getWaybillAneAmountTransAmount() {
        return waybillAneAmountTransAmount;
    }

    public void setWaybillAneAmountTransAmount(BigDecimal waybillAneAmountTransAmount) {
        this.waybillAneAmountTransAmount = waybillAneAmountTransAmount;
    }

    public BigDecimal getWaybillAneAmountDispatchAmount() {
        return waybillAneAmountDispatchAmount;
    }

    public void setWaybillAneAmountDispatchAmount(BigDecimal waybillAneAmountDispatchAmount) {
        this.waybillAneAmountDispatchAmount = waybillAneAmountDispatchAmount;
    }

    public BigDecimal getWaybillAneAmountCusFreightAmount() {
        return waybillAneAmountCusFreightAmount;
    }

    public void setWaybillAneAmountCusFreightAmount(BigDecimal waybillAneAmountCusFreightAmount) {
        this.waybillAneAmountCusFreightAmount = waybillAneAmountCusFreightAmount;
    }

    public BigDecimal getWaybillAneAmountPremiumAmount() {
        return waybillAneAmountPremiumAmount;
    }

    public void setWaybillAneAmountPremiumAmount(BigDecimal waybillAneAmountPremiumAmount) {
        this.waybillAneAmountPremiumAmount = waybillAneAmountPremiumAmount;
    }

    public BigDecimal getWaybillAneAmountPayDispatcherAmount() {
        return waybillAneAmountPayDispatcherAmount;
    }

    public void setWaybillAneAmountPayDispatcherAmount(BigDecimal waybillAneAmountPayDispatcherAmount) {
        this.waybillAneAmountPayDispatcherAmount = waybillAneAmountPayDispatcherAmount;
    }

    public BigDecimal getWaybillAneAmountBonusPoolFee() {
        return waybillAneAmountBonusPoolFee;
    }

    public void setWaybillAneAmountBonusPoolFee(BigDecimal waybillAneAmountBonusPoolFee) {
        this.waybillAneAmountBonusPoolFee = waybillAneAmountBonusPoolFee;
    }

    public BigDecimal getWaybillAneAmountOptAmount() {
        return waybillAneAmountOptAmount;
    }

    public void setWaybillAneAmountOptAmount(BigDecimal waybillAneAmountOptAmount) {
        this.waybillAneAmountOptAmount = waybillAneAmountOptAmount;
    }

    public BigDecimal getWaybillAneAmountFuelAmount() {
        return waybillAneAmountFuelAmount;
    }

    public void setWaybillAneAmountFuelAmount(BigDecimal waybillAneAmountFuelAmount) {
        this.waybillAneAmountFuelAmount = waybillAneAmountFuelAmount;
    }

    public BigDecimal getWaybillAneAmountMeetingAmount() {
        return waybillAneAmountMeetingAmount;
    }

    public void setWaybillAneAmountMeetingAmount(BigDecimal waybillAneAmountMeetingAmount) {
        this.waybillAneAmountMeetingAmount = waybillAneAmountMeetingAmount;
    }

    public BigDecimal getWaybillAneAmountMeetingSubsidyAmount() {
        return waybillAneAmountMeetingSubsidyAmount;
    }

    public void setWaybillAneAmountMeetingSubsidyAmount(BigDecimal waybillAneAmountMeetingSubsidyAmount) {
        this.waybillAneAmountMeetingSubsidyAmount = waybillAneAmountMeetingSubsidyAmount;
    }

    public BigDecimal getWaybillAneAmountPaySendOperationAmount() {
        return waybillAneAmountPaySendOperationAmount;
    }

    public void setWaybillAneAmountPaySendOperationAmount(BigDecimal waybillAneAmountPaySendOperationAmount) {
        this.waybillAneAmountPaySendOperationAmount = waybillAneAmountPaySendOperationAmount;
    }

    public BigDecimal getWaybillAneAmountArriveOptAmount() {
        return waybillAneAmountArriveOptAmount;
    }

    public void setWaybillAneAmountArriveOptAmount(BigDecimal waybillAneAmountArriveOptAmount) {
        this.waybillAneAmountArriveOptAmount = waybillAneAmountArriveOptAmount;
    }

    public BigDecimal getWaybillAneAmountPayPremiumAmount() {
        return waybillAneAmountPayPremiumAmount;
    }

    public void setWaybillAneAmountPayPremiumAmount(BigDecimal waybillAneAmountPayPremiumAmount) {
        this.waybillAneAmountPayPremiumAmount = waybillAneAmountPayPremiumAmount;
    }

    public BigDecimal getWaybillAneAmountReceiptAmount() {
        return waybillAneAmountReceiptAmount;
    }

    public void setWaybillAneAmountReceiptAmount(BigDecimal waybillAneAmountReceiptAmount) {
        this.waybillAneAmountReceiptAmount = waybillAneAmountReceiptAmount;
    }

    public BigDecimal getWaybillAneAmountCollectAmount() {
        return waybillAneAmountCollectAmount;
    }

    public void setWaybillAneAmountCollectAmount(BigDecimal waybillAneAmountCollectAmount) {
        this.waybillAneAmountCollectAmount = waybillAneAmountCollectAmount;
    }

    public BigDecimal getWaybillAneAmountPayDispatchCollectAmount() {
        return waybillAneAmountPayDispatchCollectAmount;
    }

    public void setWaybillAneAmountPayDispatchCollectAmount(BigDecimal waybillAneAmountPayDispatchCollectAmount) {
        this.waybillAneAmountPayDispatchCollectAmount = waybillAneAmountPayDispatchCollectAmount;
    }

    public BigDecimal getWaybillAneAmountCodOptAmount() {
        return waybillAneAmountCodOptAmount;
    }

    public void setWaybillAneAmountCodOptAmount(BigDecimal waybillAneAmountCodOptAmount) {
        this.waybillAneAmountCodOptAmount = waybillAneAmountCodOptAmount;
    }

    public BigDecimal getWaybillAneAmountReceiveSendFee() {
        return waybillAneAmountReceiveSendFee;
    }

    public void setWaybillAneAmountReceiveSendFee(BigDecimal waybillAneAmountReceiveSendFee) {
        this.waybillAneAmountReceiveSendFee = waybillAneAmountReceiveSendFee;
    }

    public BigDecimal getWaybillAneAmountSiteTransAmount() {
        return waybillAneAmountSiteTransAmount;
    }

    public void setWaybillAneAmountSiteTransAmount(BigDecimal waybillAneAmountSiteTransAmount) {
        this.waybillAneAmountSiteTransAmount = waybillAneAmountSiteTransAmount;
    }

    public BigDecimal getWaybillAneAmountSiteReDispachFee() {
        return waybillAneAmountSiteReDispachFee;
    }

    public void setWaybillAneAmountSiteReDispachFee(BigDecimal waybillAneAmountSiteReDispachFee) {
        this.waybillAneAmountSiteReDispachFee = waybillAneAmountSiteReDispachFee;
    }

    public BigDecimal getWaybillAneAmountSitePayDispatchFee() {
        return waybillAneAmountSitePayDispatchFee;
    }

    public void setWaybillAneAmountSitePayDispatchFee(BigDecimal waybillAneAmountSitePayDispatchFee) {
        this.waybillAneAmountSitePayDispatchFee = waybillAneAmountSitePayDispatchFee;
    }

    public BigDecimal getWaybillAneAmountPickUpAmount() {
        return waybillAneAmountPickUpAmount;
    }

    public void setWaybillAneAmountPickUpAmount(BigDecimal waybillAneAmountPickUpAmount) {
        this.waybillAneAmountPickUpAmount = waybillAneAmountPickUpAmount;
    }

    public BigDecimal getWaybillAneAmountDeliveryAmount() {
        return waybillAneAmountDeliveryAmount;
    }

    public void setWaybillAneAmountDeliveryAmount(BigDecimal waybillAneAmountDeliveryAmount) {
        this.waybillAneAmountDeliveryAmount = waybillAneAmountDeliveryAmount;
    }

    public BigDecimal getWaybillAneAmountCusPremiumAmount() {
        return waybillAneAmountCusPremiumAmount;
    }

    public void setWaybillAneAmountCusPremiumAmount(BigDecimal waybillAneAmountCusPremiumAmount) {
        this.waybillAneAmountCusPremiumAmount = waybillAneAmountCusPremiumAmount;
    }

    public BigDecimal getWaybillAneAmountFuelAddAmount() {
        return waybillAneAmountFuelAddAmount;
    }

    public void setWaybillAneAmountFuelAddAmount(BigDecimal waybillAneAmountFuelAddAmount) {
        this.waybillAneAmountFuelAddAmount = waybillAneAmountFuelAddAmount;
    }

    public BigDecimal getWaybillAneAmountDocumentAmount() {
        return waybillAneAmountDocumentAmount;
    }

    public void setWaybillAneAmountDocumentAmount(BigDecimal waybillAneAmountDocumentAmount) {
        this.waybillAneAmountDocumentAmount = waybillAneAmountDocumentAmount;
    }

    public BigDecimal getWaybillAneAmountStairsAmount() {
        return waybillAneAmountStairsAmount;
    }

    public void setWaybillAneAmountStairsAmount(BigDecimal waybillAneAmountStairsAmount) {
        this.waybillAneAmountStairsAmount = waybillAneAmountStairsAmount;
    }

    public BigDecimal getWaybillAneAmountPayStairsAmount() {
        return waybillAneAmountPayStairsAmount;
    }

    public void setWaybillAneAmountPayStairsAmount(BigDecimal waybillAneAmountPayStairsAmount) {
        this.waybillAneAmountPayStairsAmount = waybillAneAmountPayStairsAmount;
    }

    public BigDecimal getWaybillAneAmountCodCharge() {
        return waybillAneAmountCodCharge;
    }

    public void setWaybillAneAmountCodCharge(BigDecimal waybillAneAmountCodCharge) {
        this.waybillAneAmountCodCharge = waybillAneAmountCodCharge;
    }

    public BigDecimal getWaybillAneAmountSonBillReturnAmount() {
        return waybillAneAmountSonBillReturnAmount;
    }

    public void setWaybillAneAmountSonBillReturnAmount(BigDecimal waybillAneAmountSonBillReturnAmount) {
        this.waybillAneAmountSonBillReturnAmount = waybillAneAmountSonBillReturnAmount;
    }

    public BigDecimal getWaybillAneAmountSendPayMent() {
        return waybillAneAmountSendPayMent;
    }

    public void setWaybillAneAmountSendPayMent(BigDecimal waybillAneAmountSendPayMent) {
        this.waybillAneAmountSendPayMent = waybillAneAmountSendPayMent;
    }

    public BigDecimal getWaybillAneAmountDispatchPayMent() {
        return waybillAneAmountDispatchPayMent;
    }

    public void setWaybillAneAmountDispatchPayMent(BigDecimal waybillAneAmountDispatchPayMent) {
        this.waybillAneAmountDispatchPayMent = waybillAneAmountDispatchPayMent;
    }

    public BigDecimal getWaybillAneAmountCodBuckSendCustomerFee() {
        return waybillAneAmountCodBuckSendCustomerFee;
    }

    public void setWaybillAneAmountCodBuckSendCustomerFee(BigDecimal waybillAneAmountCodBuckSendCustomerFee) {
        this.waybillAneAmountCodBuckSendCustomerFee = waybillAneAmountCodBuckSendCustomerFee;
    }

    public BigDecimal getWaybillAneAmountCodPayDispatchFee() {
        return waybillAneAmountCodPayDispatchFee;
    }

    public void setWaybillAneAmountCodPayDispatchFee(BigDecimal waybillAneAmountCodPayDispatchFee) {
        this.waybillAneAmountCodPayDispatchFee = waybillAneAmountCodPayDispatchFee;
    }

    public BigDecimal getWaybillAneAmountPayDispatchServiceFee() {
        return waybillAneAmountPayDispatchServiceFee;
    }

    public void setWaybillAneAmountPayDispatchServiceFee(BigDecimal waybillAneAmountPayDispatchServiceFee) {
        this.waybillAneAmountPayDispatchServiceFee = waybillAneAmountPayDispatchServiceFee;
    }

    public BigDecimal getWaybillAneAmountPayBonusPoolFee() {
        return waybillAneAmountPayBonusPoolFee;
    }

    public void setWaybillAneAmountPayBonusPoolFee(BigDecimal waybillAneAmountPayBonusPoolFee) {
        this.waybillAneAmountPayBonusPoolFee = waybillAneAmountPayBonusPoolFee;
    }

    public BigDecimal getWaybillAneAmountPriceTypeMap() {
        return waybillAneAmountPriceTypeMap;
    }

    public void setWaybillAneAmountPriceTypeMap(BigDecimal waybillAneAmountPriceTypeMap) {
        this.waybillAneAmountPriceTypeMap = waybillAneAmountPriceTypeMap;
    }

    public BigDecimal getWaybillAneAmountFragileGoodsFee() {
        return waybillAneAmountFragileGoodsFee;
    }

    public void setWaybillAneAmountFragileGoodsFee(BigDecimal waybillAneAmountFragileGoodsFee) {
        this.waybillAneAmountFragileGoodsFee = waybillAneAmountFragileGoodsFee;
    }

    public BigDecimal getWaybillAneAmountFreightAmount() {
        return waybillAneAmountFreightAmount;
    }

    public void setWaybillAneAmountFreightAmount(BigDecimal waybillAneAmountFreightAmount) {
        this.waybillAneAmountFreightAmount = waybillAneAmountFreightAmount;
    }

    public BigDecimal getWaybillAneAmountQuoteType() {
        return waybillAneAmountQuoteType;
    }

    public void setWaybillAneAmountQuoteType(BigDecimal waybillAneAmountQuoteType) {
        this.waybillAneAmountQuoteType = waybillAneAmountQuoteType;
    }

    public BigDecimal getWaybillAneAmountOverWeightAmount() {
        return waybillAneAmountOverWeightAmount;
    }

    public void setWaybillAneAmountOverWeightAmount(BigDecimal waybillAneAmountOverWeightAmount) {
        this.waybillAneAmountOverWeightAmount = waybillAneAmountOverWeightAmount;
    }

    public BigDecimal getWaybillAneAmountWareHouseCharge() {
        return waybillAneAmountWareHouseCharge;
    }

    public void setWaybillAneAmountWareHouseCharge(BigDecimal waybillAneAmountWareHouseCharge) {
        this.waybillAneAmountWareHouseCharge = waybillAneAmountWareHouseCharge;
    }

    public BigDecimal getWaybillAneAmountPayOverWeightAmount() {
        return waybillAneAmountPayOverWeightAmount;
    }

    public void setWaybillAneAmountPayOverWeightAmount(BigDecimal waybillAneAmountPayOverWeightAmount) {
        this.waybillAneAmountPayOverWeightAmount = waybillAneAmountPayOverWeightAmount;
    }

    public BigDecimal getWaybillAneAmountSiteReArrivePayFee() {
        return waybillAneAmountSiteReArrivePayFee;
    }

    public void setWaybillAneAmountSiteReArrivePayFee(BigDecimal waybillAneAmountSiteReArrivePayFee) {
        this.waybillAneAmountSiteReArrivePayFee = waybillAneAmountSiteReArrivePayFee;
    }

    public BigDecimal getWaybillAneAmountSiteDisArrivePayFee() {
        return waybillAneAmountSiteDisArrivePayFee;
    }

    public void setWaybillAneAmountSiteDisArrivePayFee(BigDecimal waybillAneAmountSiteDisArrivePayFee) {
        this.waybillAneAmountSiteDisArrivePayFee = waybillAneAmountSiteDisArrivePayFee;
    }

    public BigDecimal getWaybillAneAmountSiteMeetingAmount() {
        return waybillAneAmountSiteMeetingAmount;
    }

    public void setWaybillAneAmountSiteMeetingAmount(BigDecimal waybillAneAmountSiteMeetingAmount) {
        this.waybillAneAmountSiteMeetingAmount = waybillAneAmountSiteMeetingAmount;
    }

    public BigDecimal getWaybillAneAmountKiloMetreAmount() {
        return waybillAneAmountKiloMetreAmount;
    }

    public void setWaybillAneAmountKiloMetreAmount(BigDecimal waybillAneAmountKiloMetreAmount) {
        this.waybillAneAmountKiloMetreAmount = waybillAneAmountKiloMetreAmount;
    }

    public BigDecimal getWaybillAneAmountDisChargeCargoAmount() {
        return waybillAneAmountDisChargeCargoAmount;
    }

    public void setWaybillAneAmountDisChargeCargoAmount(BigDecimal waybillAneAmountDisChargeCargoAmount) {
        this.waybillAneAmountDisChargeCargoAmount = waybillAneAmountDisChargeCargoAmount;
    }

    public BigDecimal getWaybillInfoSiteTotalAmount() {
        return waybillInfoSiteTotalAmount;
    }

    public void setWaybillInfoSiteTotalAmount(BigDecimal waybillInfoSiteTotalAmount) {
        this.waybillInfoSiteTotalAmount = waybillInfoSiteTotalAmount;
    }

    public String getWaybillSiteAmountPayerTypeCode() {
        return waybillSiteAmountPayerTypeCode;
    }

    public void setWaybillSiteAmountPayerTypeCode(String waybillSiteAmountPayerTypeCode) {
        this.waybillSiteAmountPayerTypeCode = waybillSiteAmountPayerTypeCode;
    }

    public String getWaybillSiteAmountPayerType() {
        return waybillSiteAmountPayerType;
    }

    public void setWaybillSiteAmountPayerType(String waybillSiteAmountPayerType) {
        this.waybillSiteAmountPayerType = waybillSiteAmountPayerType;
    }

    public String getWaybillSiteAmountPaymentType() {
        return waybillSiteAmountPaymentType;
    }

    public void setWaybillSiteAmountPaymentType(String waybillSiteAmountPaymentType) {
        this.waybillSiteAmountPaymentType = waybillSiteAmountPaymentType;
    }

    public String getWaybillSiteAmountCurrency() {
        return waybillSiteAmountCurrency;
    }

    public void setWaybillSiteAmountCurrency(String waybillSiteAmountCurrency) {
        this.waybillSiteAmountCurrency = waybillSiteAmountCurrency;
    }

    public String getWaybillSiteAmountStairType() {
        return waybillSiteAmountStairType;
    }

    public void setWaybillSiteAmountStairType(String waybillSiteAmountStairType) {
        this.waybillSiteAmountStairType = waybillSiteAmountStairType;
    }

    public BigDecimal getWaybillSiteAmountTotalCustomerAmount() {
        return waybillSiteAmountTotalCustomerAmount;
    }

    public void setWaybillSiteAmountTotalCustomerAmount(BigDecimal waybillSiteAmountTotalCustomerAmount) {
        this.waybillSiteAmountTotalCustomerAmount = waybillSiteAmountTotalCustomerAmount;
    }

    public BigDecimal getWaybillSiteAmountInsuredAmount() {
        return waybillSiteAmountInsuredAmount;
    }

    public void setWaybillSiteAmountInsuredAmount(BigDecimal waybillSiteAmountInsuredAmount) {
        this.waybillSiteAmountInsuredAmount = waybillSiteAmountInsuredAmount;
    }

    public BigDecimal getWaybillSiteAmountPremiumAmount() {
        return waybillSiteAmountPremiumAmount;
    }

    public void setWaybillSiteAmountPremiumAmount(BigDecimal waybillSiteAmountPremiumAmount) {
        this.waybillSiteAmountPremiumAmount = waybillSiteAmountPremiumAmount;
    }

    public BigDecimal getWaybillSiteAmountFreightAmount() {
        return waybillSiteAmountFreightAmount;
    }

    public void setWaybillSiteAmountFreightAmount(BigDecimal waybillSiteAmountFreightAmount) {
        this.waybillSiteAmountFreightAmount = waybillSiteAmountFreightAmount;
    }

    public BigDecimal getWaybillSiteAmountFirstFreightAmount() {
        return waybillSiteAmountFirstFreightAmount;
    }

    public void setWaybillSiteAmountFirstFreightAmount(BigDecimal waybillSiteAmountFirstFreightAmount) {
        this.waybillSiteAmountFirstFreightAmount = waybillSiteAmountFirstFreightAmount;
    }

    public BigDecimal getWaybillSiteAmountBoxCheckAmount() {
        return waybillSiteAmountBoxCheckAmount;
    }

    public void setWaybillSiteAmountBoxCheckAmount(BigDecimal waybillSiteAmountBoxCheckAmount) {
        this.waybillSiteAmountBoxCheckAmount = waybillSiteAmountBoxCheckAmount;
    }

    public BigDecimal getWaybillSiteAmountUpStairsAmount() {
        return waybillSiteAmountUpStairsAmount;
    }

    public void setWaybillSiteAmountUpStairsAmount(BigDecimal waybillSiteAmountUpStairsAmount) {
        this.waybillSiteAmountUpStairsAmount = waybillSiteAmountUpStairsAmount;
    }

    public BigDecimal getWaybillSiteAmountCheckAmount() {
        return waybillSiteAmountCheckAmount;
    }

    public void setWaybillSiteAmountCheckAmount(BigDecimal waybillSiteAmountCheckAmount) {
        this.waybillSiteAmountCheckAmount = waybillSiteAmountCheckAmount;
    }

    public BigDecimal getWaybillSiteAmountTrunsAmount() {
        return waybillSiteAmountTrunsAmount;
    }

    public void setWaybillSiteAmountTrunsAmount(BigDecimal waybillSiteAmountTrunsAmount) {
        this.waybillSiteAmountTrunsAmount = waybillSiteAmountTrunsAmount;
    }

    public BigDecimal getWaybillSiteAmountInWarehouseAmount() {
        return waybillSiteAmountInWarehouseAmount;
    }

    public void setWaybillSiteAmountInWarehouseAmount(BigDecimal waybillSiteAmountInWarehouseAmount) {
        this.waybillSiteAmountInWarehouseAmount = waybillSiteAmountInWarehouseAmount;
    }

    public BigDecimal getWaybillSiteAmountSpecialAreaAmount() {
        return waybillSiteAmountSpecialAreaAmount;
    }

    public void setWaybillSiteAmountSpecialAreaAmount(BigDecimal waybillSiteAmountSpecialAreaAmount) {
        this.waybillSiteAmountSpecialAreaAmount = waybillSiteAmountSpecialAreaAmount;
    }

    public BigDecimal getWaybillSiteAmountSpecialUpStairsAmount() {
        return waybillSiteAmountSpecialUpStairsAmount;
    }

    public void setWaybillSiteAmountSpecialUpStairsAmount(BigDecimal waybillSiteAmountSpecialUpStairsAmount) {
        this.waybillSiteAmountSpecialUpStairsAmount = waybillSiteAmountSpecialUpStairsAmount;
    }

    public BigDecimal getWaybillSiteAmountPassStandardUpStairsAmount() {
        return waybillSiteAmountPassStandardUpStairsAmount;
    }

    public void setWaybillSiteAmountPassStandardUpStairsAmount(BigDecimal waybillSiteAmountPassStandardUpStairsAmount) {
        this.waybillSiteAmountPassStandardUpStairsAmount = waybillSiteAmountPassStandardUpStairsAmount;
    }

    public BigDecimal getWaybillSiteAmountBlindZoneCarAmount() {
        return waybillSiteAmountBlindZoneCarAmount;
    }

    public void setWaybillSiteAmountBlindZoneCarAmount(BigDecimal waybillSiteAmountBlindZoneCarAmount) {
        this.waybillSiteAmountBlindZoneCarAmount = waybillSiteAmountBlindZoneCarAmount;
    }

    public BigDecimal getWaybillSiteAmountUrgentCarAmount() {
        return waybillSiteAmountUrgentCarAmount;
    }

    public void setWaybillSiteAmountUrgentCarAmount(BigDecimal waybillSiteAmountUrgentCarAmount) {
        this.waybillSiteAmountUrgentCarAmount = waybillSiteAmountUrgentCarAmount;
    }

    public BigDecimal getWaybillSiteAmountPassStandardCarAmount() {
        return waybillSiteAmountPassStandardCarAmount;
    }

    public void setWaybillSiteAmountPassStandardCarAmount(BigDecimal waybillSiteAmountPassStandardCarAmount) {
        this.waybillSiteAmountPassStandardCarAmount = waybillSiteAmountPassStandardCarAmount;
    }

    public BigDecimal getWaybillSiteAmountOtherAmount() {
        return waybillSiteAmountOtherAmount;
    }

    public void setWaybillSiteAmountOtherAmount(BigDecimal waybillSiteAmountOtherAmount) {
        this.waybillSiteAmountOtherAmount = waybillSiteAmountOtherAmount;
    }

    public String getWaybillSiteAmountRemark() {
        return waybillSiteAmountRemark;
    }

    public void setWaybillSiteAmountRemark(String waybillSiteAmountRemark) {
        this.waybillSiteAmountRemark = waybillSiteAmountRemark;
    }

    public BigDecimal getWaybillInfoGrossProfit() {
        return waybillInfoGrossProfit;
    }

    public void setWaybillInfoGrossProfit(BigDecimal waybillInfoGrossProfit) {
        this.waybillInfoGrossProfit = waybillInfoGrossProfit;
    }

    public String getWaybillInfoPaymentType() {
        return waybillInfoPaymentType;
    }

    public void setWaybillInfoPaymentType(String waybillInfoPaymentType) {
        this.waybillInfoPaymentType = waybillInfoPaymentType;
    }

    public String getWaybillInfoPickType() {
        return waybillInfoPickType;
    }

    public void setWaybillInfoPickType(String waybillInfoPickType) {
        this.waybillInfoPickType = waybillInfoPickType;
    }

    public String getWaybillInfoCalcCustomerCode() {
        return waybillInfoCalcCustomerCode;
    }

    public void setWaybillInfoCalcCustomerCode(String waybillInfoCalcCustomerCode) {
        this.waybillInfoCalcCustomerCode = waybillInfoCalcCustomerCode;
    }

    public String getWaybillInfoCalcCustomerBillNo() {
        return waybillInfoCalcCustomerBillNo;
    }

    public void setWaybillInfoCalcCustomerBillNo(String waybillInfoCalcCustomerBillNo) {
        this.waybillInfoCalcCustomerBillNo = waybillInfoCalcCustomerBillNo;
    }

    public Integer getWaybillSendReceiveInfoVip() {
        return waybillSendReceiveInfoVip;
    }

    public void setWaybillSendReceiveInfoVip(Integer waybillSendReceiveInfoVip) {
        this.waybillSendReceiveInfoVip = waybillSendReceiveInfoVip;
    }

    public String getWaybillSendReceiveInfoSendProvince() {
        return waybillSendReceiveInfoSendProvince;
    }

    public void setWaybillSendReceiveInfoSendProvince(String waybillSendReceiveInfoSendProvince) {
        this.waybillSendReceiveInfoSendProvince = waybillSendReceiveInfoSendProvince;
    }

    public Integer getWaybillSendReceiveInfoSendProvinceCode() {
        return waybillSendReceiveInfoSendProvinceCode;
    }

    public void setWaybillSendReceiveInfoSendProvinceCode(Integer waybillSendReceiveInfoSendProvinceCode) {
        this.waybillSendReceiveInfoSendProvinceCode = waybillSendReceiveInfoSendProvinceCode;
    }

    public String getWaybillSendReceiveInfoSendCity() {
        return waybillSendReceiveInfoSendCity;
    }

    public void setWaybillSendReceiveInfoSendCity(String waybillSendReceiveInfoSendCity) {
        this.waybillSendReceiveInfoSendCity = waybillSendReceiveInfoSendCity;
    }

    public Integer getWaybillSendReceiveInfoSendCityCode() {
        return waybillSendReceiveInfoSendCityCode;
    }

    public void setWaybillSendReceiveInfoSendCityCode(Integer waybillSendReceiveInfoSendCityCode) {
        this.waybillSendReceiveInfoSendCityCode = waybillSendReceiveInfoSendCityCode;
    }

    public String getWaybillSendReceiveInfoSendDistrict() {
        return waybillSendReceiveInfoSendDistrict;
    }

    public void setWaybillSendReceiveInfoSendDistrict(String waybillSendReceiveInfoSendDistrict) {
        this.waybillSendReceiveInfoSendDistrict = waybillSendReceiveInfoSendDistrict;
    }

    public Integer getWaybillSendReceiveInfoSendDistrictCode() {
        return waybillSendReceiveInfoSendDistrictCode;
    }

    public void setWaybillSendReceiveInfoSendDistrictCode(Integer waybillSendReceiveInfoSendDistrictCode) {
        this.waybillSendReceiveInfoSendDistrictCode = waybillSendReceiveInfoSendDistrictCode;
    }

    public String getWaybillSendReceiveInfoSendStreet() {
        return waybillSendReceiveInfoSendStreet;
    }

    public void setWaybillSendReceiveInfoSendStreet(String waybillSendReceiveInfoSendStreet) {
        this.waybillSendReceiveInfoSendStreet = waybillSendReceiveInfoSendStreet;
    }

    public Integer getWaybillSendReceiveInfoSendStreetCode() {
        return waybillSendReceiveInfoSendStreetCode;
    }

    public void setWaybillSendReceiveInfoSendStreetCode(Integer waybillSendReceiveInfoSendStreetCode) {
        this.waybillSendReceiveInfoSendStreetCode = waybillSendReceiveInfoSendStreetCode;
    }

    public String getWaybillSendReceiveInfoSendAddress() {
        return waybillSendReceiveInfoSendAddress;
    }

    public void setWaybillSendReceiveInfoSendAddress(String waybillSendReceiveInfoSendAddress) {
        this.waybillSendReceiveInfoSendAddress = waybillSendReceiveInfoSendAddress;
    }

    public String getWaybillSendReceiveInfoSenderCode() {
        return waybillSendReceiveInfoSenderCode;
    }

    public void setWaybillSendReceiveInfoSenderCode(String waybillSendReceiveInfoSenderCode) {
        this.waybillSendReceiveInfoSenderCode = waybillSendReceiveInfoSenderCode;
    }

    public String getWaybillSendReceiveInfoSenderName() {
        return waybillSendReceiveInfoSenderName;
    }

    public void setWaybillSendReceiveInfoSenderName(String waybillSendReceiveInfoSenderName) {
        this.waybillSendReceiveInfoSenderName = waybillSendReceiveInfoSenderName;
    }

    public String getWaybillSendReceiveInfoSenderCompany() {
        return waybillSendReceiveInfoSenderCompany;
    }

    public void setWaybillSendReceiveInfoSenderCompany(String waybillSendReceiveInfoSenderCompany) {
        this.waybillSendReceiveInfoSenderCompany = waybillSendReceiveInfoSenderCompany;
    }

    public String getWaybillSendReceiveInfoSenderMobile() {
        return waybillSendReceiveInfoSenderMobile;
    }

    public void setWaybillSendReceiveInfoSenderMobile(String waybillSendReceiveInfoSenderMobile) {
        this.waybillSendReceiveInfoSenderMobile = waybillSendReceiveInfoSenderMobile;
    }

    public String getWaybillSendReceiveInfoSenderLinkMan() {
        return waybillSendReceiveInfoSenderLinkMan;
    }

    public void setWaybillSendReceiveInfoSenderLinkMan(String waybillSendReceiveInfoSenderLinkMan) {
        this.waybillSendReceiveInfoSenderLinkMan = waybillSendReceiveInfoSenderLinkMan;
    }

    public String getWaybillSendReceiveInfoSenderPhone() {
        return waybillSendReceiveInfoSenderPhone;
    }

    public void setWaybillSendReceiveInfoSenderPhone(String waybillSendReceiveInfoSenderPhone) {
        this.waybillSendReceiveInfoSenderPhone = waybillSendReceiveInfoSenderPhone;
    }

    public int getWaybillSendReceiveInfoSenderCardType() {
        return waybillSendReceiveInfoSenderCardType;
    }

    public void setWaybillSendReceiveInfoSenderCardType(int waybillSendReceiveInfoSenderCardType) {
        this.waybillSendReceiveInfoSenderCardType = waybillSendReceiveInfoSenderCardType;
    }

    public String getWaybillSendReceiveInfoSenderCardNo() {
        return waybillSendReceiveInfoSenderCardNo;
    }

    public void setWaybillSendReceiveInfoSenderCardNo(String waybillSendReceiveInfoSenderCardNo) {
        this.waybillSendReceiveInfoSenderCardNo = waybillSendReceiveInfoSenderCardNo;
    }

    public String getWaybillSendReceiveInfoSenderPostCode() {
        return waybillSendReceiveInfoSenderPostCode;
    }

    public void setWaybillSendReceiveInfoSenderPostCode(String waybillSendReceiveInfoSenderPostCode) {
        this.waybillSendReceiveInfoSenderPostCode = waybillSendReceiveInfoSenderPostCode;
    }

    public Integer getWaybillSendReceiveInfoReceiveProvinceCode() {
        return waybillSendReceiveInfoReceiveProvinceCode;
    }

    public void setWaybillSendReceiveInfoReceiveProvinceCode(Integer waybillSendReceiveInfoReceiveProvinceCode) {
        this.waybillSendReceiveInfoReceiveProvinceCode = waybillSendReceiveInfoReceiveProvinceCode;
    }

    public String getWaybillSendReceiveInfoReceiveProvince() {
        return waybillSendReceiveInfoReceiveProvince;
    }

    public void setWaybillSendReceiveInfoReceiveProvince(String waybillSendReceiveInfoReceiveProvince) {
        this.waybillSendReceiveInfoReceiveProvince = waybillSendReceiveInfoReceiveProvince;
    }

    public Integer getWaybillSendReceiveInfoReceiveCityCode() {
        return waybillSendReceiveInfoReceiveCityCode;
    }

    public void setWaybillSendReceiveInfoReceiveCityCode(Integer waybillSendReceiveInfoReceiveCityCode) {
        this.waybillSendReceiveInfoReceiveCityCode = waybillSendReceiveInfoReceiveCityCode;
    }

    public String getWaybillSendReceiveInfoReceiveCity() {
        return waybillSendReceiveInfoReceiveCity;
    }

    public void setWaybillSendReceiveInfoReceiveCity(String waybillSendReceiveInfoReceiveCity) {
        this.waybillSendReceiveInfoReceiveCity = waybillSendReceiveInfoReceiveCity;
    }

    public Integer getWaybillSendReceiveInfoReceiveDistrictCode() {
        return waybillSendReceiveInfoReceiveDistrictCode;
    }

    public void setWaybillSendReceiveInfoReceiveDistrictCode(Integer waybillSendReceiveInfoReceiveDistrictCode) {
        this.waybillSendReceiveInfoReceiveDistrictCode = waybillSendReceiveInfoReceiveDistrictCode;
    }

    public String getWaybillSendReceiveInfoReceiveDistrict() {
        return waybillSendReceiveInfoReceiveDistrict;
    }

    public void setWaybillSendReceiveInfoReceiveDistrict(String waybillSendReceiveInfoReceiveDistrict) {
        this.waybillSendReceiveInfoReceiveDistrict = waybillSendReceiveInfoReceiveDistrict;
    }

    public Integer getWaybillSendReceiveInfoReceiveStreetCode() {
        return waybillSendReceiveInfoReceiveStreetCode;
    }

    public void setWaybillSendReceiveInfoReceiveStreetCode(Integer waybillSendReceiveInfoReceiveStreetCode) {
        this.waybillSendReceiveInfoReceiveStreetCode = waybillSendReceiveInfoReceiveStreetCode;
    }

    public String getWaybillSendReceiveInfoReceiveStreet() {
        return waybillSendReceiveInfoReceiveStreet;
    }

    public void setWaybillSendReceiveInfoReceiveStreet(String waybillSendReceiveInfoReceiveStreet) {
        this.waybillSendReceiveInfoReceiveStreet = waybillSendReceiveInfoReceiveStreet;
    }

    public String getWaybillSendReceiveInfoReceiveAddress() {
        return waybillSendReceiveInfoReceiveAddress;
    }

    public void setWaybillSendReceiveInfoReceiveAddress(String waybillSendReceiveInfoReceiveAddress) {
        this.waybillSendReceiveInfoReceiveAddress = waybillSendReceiveInfoReceiveAddress;
    }

    public String getWaybillSendReceiveInfoReceiverCode() {
        return waybillSendReceiveInfoReceiverCode;
    }

    public void setWaybillSendReceiveInfoReceiverCode(String waybillSendReceiveInfoReceiverCode) {
        this.waybillSendReceiveInfoReceiverCode = waybillSendReceiveInfoReceiverCode;
    }

    public String getWaybillSendReceiveInfoReceiverName() {
        return waybillSendReceiveInfoReceiverName;
    }

    public void setWaybillSendReceiveInfoReceiverName(String waybillSendReceiveInfoReceiverName) {
        this.waybillSendReceiveInfoReceiverName = waybillSendReceiveInfoReceiverName;
    }

    public String getWaybillSendReceiveInfoReceiverCompany() {
        return waybillSendReceiveInfoReceiverCompany;
    }

    public void setWaybillSendReceiveInfoReceiverCompany(String waybillSendReceiveInfoReceiverCompany) {
        this.waybillSendReceiveInfoReceiverCompany = waybillSendReceiveInfoReceiverCompany;
    }

    public String getWaybillSendReceiveInfoReceiverMobile() {
        return waybillSendReceiveInfoReceiverMobile;
    }

    public void setWaybillSendReceiveInfoReceiverMobile(String waybillSendReceiveInfoReceiverMobile) {
        this.waybillSendReceiveInfoReceiverMobile = waybillSendReceiveInfoReceiverMobile;
    }

    public String getWaybillSendReceiveInfoReceiverLinkMan() {
        return waybillSendReceiveInfoReceiverLinkMan;
    }

    public void setWaybillSendReceiveInfoReceiverLinkMan(String waybillSendReceiveInfoReceiverLinkMan) {
        this.waybillSendReceiveInfoReceiverLinkMan = waybillSendReceiveInfoReceiverLinkMan;
    }

    public String getWaybillSendReceiveInfoReceiverPhone() {
        return waybillSendReceiveInfoReceiverPhone;
    }

    public void setWaybillSendReceiveInfoReceiverPhone(String waybillSendReceiveInfoReceiverPhone) {
        this.waybillSendReceiveInfoReceiverPhone = waybillSendReceiveInfoReceiverPhone;
    }

    public int getWaybillSendReceiveInfoReceiverCardType() {
        return waybillSendReceiveInfoReceiverCardType;
    }

    public void setWaybillSendReceiveInfoReceiverCardType(int waybillSendReceiveInfoReceiverCardType) {
        this.waybillSendReceiveInfoReceiverCardType = waybillSendReceiveInfoReceiverCardType;
    }

    public String getWaybillSendReceiveInfoReceiverCardNo() {
        return waybillSendReceiveInfoReceiverCardNo;
    }

    public void setWaybillSendReceiveInfoReceiverCardNo(String waybillSendReceiveInfoReceiverCardNo) {
        this.waybillSendReceiveInfoReceiverCardNo = waybillSendReceiveInfoReceiverCardNo;
    }

    public String getWaybillSendReceiveInfoReceiverPostCode() {
        return waybillSendReceiveInfoReceiverPostCode;
    }

    public void setWaybillSendReceiveInfoReceiverPostCode(String waybillSendReceiveInfoReceiverPostCode) {
        this.waybillSendReceiveInfoReceiverPostCode = waybillSendReceiveInfoReceiverPostCode;
    }

    public Integer getWaybillInfoBillStatus() {
        return waybillInfoBillStatus;
    }

    public void setWaybillInfoBillStatus(Integer waybillInfoBillStatus) {
        this.waybillInfoBillStatus = waybillInfoBillStatus;
    }

    public String getWaybillInfoWaybillStatusDate() {
        return waybillInfoWaybillStatusDate;
    }

    public void setWaybillInfoWaybillStatusDate(String waybillInfoWaybillStatusDate) {
        this.waybillInfoWaybillStatusDate = waybillInfoWaybillStatusDate;
    }

    public String getWaybillInfoWaybillRoute() {
        return waybillInfoWaybillRoute;
    }

    public void setWaybillInfoWaybillRoute(String waybillInfoWaybillRoute) {
        this.waybillInfoWaybillRoute = waybillInfoWaybillRoute;
    }

    public String getWaybillInfoSendCenterCode() {
        return waybillInfoSendCenterCode;
    }

    public void setWaybillInfoSendCenterCode(String waybillInfoSendCenterCode) {
        this.waybillInfoSendCenterCode = waybillInfoSendCenterCode;
    }

    public Integer getWaybillInfoWaybillSource() {
        return waybillInfoWaybillSource;
    }

    public void setWaybillInfoWaybillSource(Integer waybillInfoWaybillSource) {
        this.waybillInfoWaybillSource = waybillInfoWaybillSource;
    }

    public Integer getWaybillInfoOperatorType() {
        return waybillInfoOperatorType;
    }

    public void setWaybillInfoOperatorType(Integer waybillInfoOperatorType) {
        this.waybillInfoOperatorType = waybillInfoOperatorType;
    }

    public String getWaybillInfoDeviceNo() {
        return waybillInfoDeviceNo;
    }

    public void setWaybillInfoDeviceNo(String waybillInfoDeviceNo) {
        this.waybillInfoDeviceNo = waybillInfoDeviceNo;
    }

    public String getWaybillInfoGoodsType() {
        return waybillInfoGoodsType;
    }

    public void setWaybillInfoGoodsType(String waybillInfoGoodsType) {
        this.waybillInfoGoodsType = waybillInfoGoodsType;
    }

    public String getWaybillInfoGoodsCategory() {
        return waybillInfoGoodsCategory;
    }

    public void setWaybillInfoGoodsCategory(String waybillInfoGoodsCategory) {
        this.waybillInfoGoodsCategory = waybillInfoGoodsCategory;
    }

    public String getWaybillInfoGoodsProp() {
        return waybillInfoGoodsProp;
    }

    public void setWaybillInfoGoodsProp(String waybillInfoGoodsProp) {
        this.waybillInfoGoodsProp = waybillInfoGoodsProp;
    }

    public Integer getWaybillGoodsInfoUpward() {
        return waybillGoodsInfoUpward;
    }

    public void setWaybillGoodsInfoUpward(Integer waybillGoodsInfoUpward) {
        this.waybillGoodsInfoUpward = waybillGoodsInfoUpward;
    }

    public Integer getWaybillGoodsInfoUnPress() {
        return waybillGoodsInfoUnPress;
    }

    public void setWaybillGoodsInfoUnPress(Integer waybillGoodsInfoUnPress) {
        this.waybillGoodsInfoUnPress = waybillGoodsInfoUnPress;
    }

    public Integer getWaybillGoodsInfoSpecialNum() {
        return waybillGoodsInfoSpecialNum;
    }

    public void setWaybillGoodsInfoSpecialNum(Integer waybillGoodsInfoSpecialNum) {
        this.waybillGoodsInfoSpecialNum = waybillGoodsInfoSpecialNum;
    }

    public String getWaybillGoodsInfoVolEl() {
        return waybillGoodsInfoVolEl;
    }

    public void setWaybillGoodsInfoVolEl(String waybillGoodsInfoVolEl) {
        this.waybillGoodsInfoVolEl = waybillGoodsInfoVolEl;
    }

    public String getWaybillGoodsInfoGoodsType() {
        return waybillGoodsInfoGoodsType;
    }

    public void setWaybillGoodsInfoGoodsType(String waybillGoodsInfoGoodsType) {
        this.waybillGoodsInfoGoodsType = waybillGoodsInfoGoodsType;
    }

    public String getWaybillGoodsInfoGoodsCategory() {
        return waybillGoodsInfoGoodsCategory;
    }

    public void setWaybillGoodsInfoGoodsCategory(String waybillGoodsInfoGoodsCategory) {
        this.waybillGoodsInfoGoodsCategory = waybillGoodsInfoGoodsCategory;
    }

    public String getWaybillGoodsInfoGoodsName() {
        return waybillGoodsInfoGoodsName;
    }

    public void setWaybillGoodsInfoGoodsName(String waybillGoodsInfoGoodsName) {
        this.waybillGoodsInfoGoodsName = waybillGoodsInfoGoodsName;
    }

    public String getWaybillGoodsInfoGoodsDesc() {
        return waybillGoodsInfoGoodsDesc;
    }

    public void setWaybillGoodsInfoGoodsDesc(String waybillGoodsInfoGoodsDesc) {
        this.waybillGoodsInfoGoodsDesc = waybillGoodsInfoGoodsDesc;
    }

    public String getWaybillGoodsInfoPackType() {
        return waybillGoodsInfoPackType;
    }

    public void setWaybillGoodsInfoPackType(String waybillGoodsInfoPackType) {
        this.waybillGoodsInfoPackType = waybillGoodsInfoPackType;
    }

    public Integer getWaybillOrderInfoEcommerceSource() {
        return WaybillOrderInfoEcommerceSource;
    }

    public void setWaybillOrderInfoEcommerceSource(Integer waybillOrderInfoEcommerceSource) {
        WaybillOrderInfoEcommerceSource = waybillOrderInfoEcommerceSource;
    }

    public Integer getWaybillOrderInfoEcommerceWarehouse() {
        return WaybillOrderInfoEcommerceWarehouse;
    }

    public void setWaybillOrderInfoEcommerceWarehouse(Integer waybillOrderInfoEcommerceWarehouse) {
        WaybillOrderInfoEcommerceWarehouse = waybillOrderInfoEcommerceWarehouse;
    }

    public String getWaybillOrderInfoOrderNo() {
        return WaybillOrderInfoOrderNo;
    }

    public void setWaybillOrderInfoOrderNo(String waybillOrderInfoOrderNo) {
        WaybillOrderInfoOrderNo = waybillOrderInfoOrderNo;
    }

    public String getWaybillInfoPhotoUploadTime() {
        return waybillInfoPhotoUploadTime;
    }

    public void setWaybillInfoPhotoUploadTime(String waybillInfoPhotoUploadTime) {
        this.waybillInfoPhotoUploadTime = waybillInfoPhotoUploadTime;
    }

    public String getWaybillInfoPhotoBackTime() {
        return waybillInfoPhotoBackTime;
    }

    public void setWaybillInfoPhotoBackTime(String waybillInfoPhotoBackTime) {
        this.waybillInfoPhotoBackTime = waybillInfoPhotoBackTime;
    }

    public Integer getWaybillInfoStatus() {
        return waybillInfoStatus;
    }

    public void setWaybillInfoStatus(Integer waybillInfoStatus) {
        this.waybillInfoStatus = waybillInfoStatus;
    }

    public String getWaybillInfoRemark() {
        return waybillInfoRemark;
    }

    public void setWaybillInfoRemark(String waybillInfoRemark) {
        this.waybillInfoRemark = waybillInfoRemark;
    }

    public String getWaybillCodBankInfoCodCurrency() {
        return waybillCodBankInfoCodCurrency;
    }

    public void setWaybillCodBankInfoCodCurrency(String waybillCodBankInfoCodCurrency) {
        this.waybillCodBankInfoCodCurrency = waybillCodBankInfoCodCurrency;
    }

    public String getWaybillCodBankInfoCodPayMode() {
        return waybillCodBankInfoCodPayMode;
    }

    public void setWaybillCodBankInfoCodPayMode(String waybillCodBankInfoCodPayMode) {
        this.waybillCodBankInfoCodPayMode = waybillCodBankInfoCodPayMode;
    }

    public String getWaybillCodBankInfoCodPayModeName() {
        return waybillCodBankInfoCodPayModeName;
    }

    public void setWaybillCodBankInfoCodPayModeName(String waybillCodBankInfoCodPayModeName) {
        this.waybillCodBankInfoCodPayModeName = waybillCodBankInfoCodPayModeName;
    }

    public String getWaybillCodBankInfoReturnTime() {
        return waybillCodBankInfoReturnTime;
    }

    public void setWaybillCodBankInfoReturnTime(String waybillCodBankInfoReturnTime) {
        this.waybillCodBankInfoReturnTime = waybillCodBankInfoReturnTime;
    }

    public String getWaybillCodBankInfoCodAccountName() {
        return waybillCodBankInfoCodAccountName;
    }

    public void setWaybillCodBankInfoCodAccountName(String waybillCodBankInfoCodAccountName) {
        this.waybillCodBankInfoCodAccountName = waybillCodBankInfoCodAccountName;
    }

    public String getWaybillCodBankInfoCodBankName() {
        return waybillCodBankInfoCodBankName;
    }

    public void setWaybillCodBankInfoCodBankName(String waybillCodBankInfoCodBankName) {
        this.waybillCodBankInfoCodBankName = waybillCodBankInfoCodBankName;
    }

    public String getWaybillCodBankInfoCodAccountNo() {
        return waybillCodBankInfoCodAccountNo;
    }

    public void setWaybillCodBankInfoCodAccountNo(String waybillCodBankInfoCodAccountNo) {
        this.waybillCodBankInfoCodAccountNo = waybillCodBankInfoCodAccountNo;
    }

    public String getWaybillCodBankInfoCodBankArea() {
        return waybillCodBankInfoCodBankArea;
    }

    public void setWaybillCodBankInfoCodBankArea(String waybillCodBankInfoCodBankArea) {
        this.waybillCodBankInfoCodBankArea = waybillCodBankInfoCodBankArea;
    }

    public String getWaybillCodBankInfoCodProvinceName() {
        return waybillCodBankInfoCodProvinceName;
    }

    public void setWaybillCodBankInfoCodProvinceName(String waybillCodBankInfoCodProvinceName) {
        this.waybillCodBankInfoCodProvinceName = waybillCodBankInfoCodProvinceName;
    }

    public String getWaybillCodBankInfoCodCityName() {
        return waybillCodBankInfoCodCityName;
    }

    public void setWaybillCodBankInfoCodCityName(String waybillCodBankInfoCodCityName) {
        this.waybillCodBankInfoCodCityName = waybillCodBankInfoCodCityName;
    }

    public String getWaybillCodBankInfoCodBankSite() {
        return waybillCodBankInfoCodBankSite;
    }

    public void setWaybillCodBankInfoCodBankSite(String waybillCodBankInfoCodBankSite) {
        this.waybillCodBankInfoCodBankSite = waybillCodBankInfoCodBankSite;
    }

    public String getWaybillCodBankInfoCodCombinenum() {
        return waybillCodBankInfoCodCombinenum;
    }

    public void setWaybillCodBankInfoCodCombinenum(String waybillCodBankInfoCodCombinenum) {
        this.waybillCodBankInfoCodCombinenum = waybillCodBankInfoCodCombinenum;
    }

    public String getWaybillCodBankInfoSenderMobile() {
        return waybillCodBankInfoSenderMobile;
    }

    public void setWaybillCodBankInfoSenderMobile(String waybillCodBankInfoSenderMobile) {
        this.waybillCodBankInfoSenderMobile = waybillCodBankInfoSenderMobile;
    }

    public String getWaybillCodBankInfoAccountType() {
        return waybillCodBankInfoAccountType;
    }

    public void setWaybillCodBankInfoAccountType(String waybillCodBankInfoAccountType) {
        this.waybillCodBankInfoAccountType = waybillCodBankInfoAccountType;
    }

    public Integer getBusiAttributeslimitationPeriod() {
        return busiAttributeslimitationPeriod;
    }

    public void setBusiAttributeslimitationPeriod(Integer busiAttributeslimitationPeriod) {
        this.busiAttributeslimitationPeriod = busiAttributeslimitationPeriod;
    }

    public Integer getBusiAttributesProductProperties() {
        return busiAttributesProductProperties;
    }

    public void setBusiAttributesProductProperties(Integer busiAttributesProductProperties) {
        this.busiAttributesProductProperties = busiAttributesProductProperties;
    }

    public Integer getBusiAttributesprovincePiece() {
        return busiAttributesprovincePiece;
    }

    public void setBusiAttributesprovincePiece(Integer busiAttributesprovincePiece) {
        this.busiAttributesprovincePiece = busiAttributesprovincePiece;
    }

    public BigDecimal getWaybillInfoCodAmount() {
        return waybillInfoCodAmount;
    }

    public void setWaybillInfoCodAmount(BigDecimal waybillInfoCodAmount) {
        this.waybillInfoCodAmount = waybillInfoCodAmount;
    }

    public String getWaybillInfoSubscribeFlag() {
        return waybillInfoSubscribeFlag;
    }

    public void setWaybillInfoSubscribeFlag(String waybillInfoSubscribeFlag) {
        this.waybillInfoSubscribeFlag = waybillInfoSubscribeFlag;
    }

    public String getWaybillInfoSubEwbNo() {
        return waybillInfoSubEwbNo;
    }

    public void setWaybillInfoSubEwbNo(String waybillInfoSubEwbNo) {
        this.waybillInfoSubEwbNo = waybillInfoSubEwbNo;
    }

    public Integer getWaybillInfoSendProvinceIndex() {
        return waybillInfoSendProvinceIndex;
    }

    public void setWaybillInfoSendProvinceIndex(Integer waybillInfoSendProvinceIndex) {
        this.waybillInfoSendProvinceIndex = waybillInfoSendProvinceIndex;
    }

    public Integer getWaybillInfoDestProvinceIndex() {
        return waybillInfoDestProvinceIndex;
    }

    public void setWaybillInfoDestProvinceIndex(Integer waybillInfoDestProvinceIndex) {
        this.waybillInfoDestProvinceIndex = waybillInfoDestProvinceIndex;
    }

    public String getWaybillInfoupdateDate() {
        return waybillInfoupdateDate;
    }

    public void setWaybillInfoupdateDate(String waybillInfoupdateDate) {
        this.waybillInfoupdateDate = waybillInfoupdateDate;
    }

    public String getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(String currentTime) {
        this.currentTime = currentTime;
    }
}
