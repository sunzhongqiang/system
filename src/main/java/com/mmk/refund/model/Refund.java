/*
 * 
 *  Refund 创建于 2016-12-26 08:56:45 版权归作者和作者当前组织所有
 */
package com.mmk.refund.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
* Refund: 退款表 数据领域模型
* 2016-12-26 09:06:25
*@author codegenerator
*@version 1.0
*/
@Entity
@Table(name="trade_refund")
public class Refund {
    /**
     * ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id",columnDefinition="COMMENT 'ID'")
    private Long id;

    /**
     * 订单主键
     */
    @Column(name="tid",columnDefinition="COMMENT '订单主键'")
    private Long tid;

    /**
     * 订单编号
     */
    @Column(name="order_sn",columnDefinition="COMMENT '订单编号'")
    private String orderSn;

    /**
     * 退款时的订单状态
     */
    @Column(name="order_status",columnDefinition="COMMENT '退款时的订单状态'")
    private String orderStatus;

    /**
     * 订单总金额
     */
    @Column(name="total_fee",columnDefinition="COMMENT '订单总金额'")
    private Double totalFee;

    /**
     * 商品编号
     */
    @Column(name="goods_id",columnDefinition="COMMENT '商品编号'")
    private Long goodsId;

    /**
     * 商品价格
     */
    @Column(name="goods_price",columnDefinition="COMMENT '商品价格'")
    private Double goodsPrice;

    /**
     * 商品名称
     */
    @Column(name="goods_name",columnDefinition="COMMENT '商品名称'")
    private String goodsName;

    /**
     * 商品图片
     */
    @Column(name="goods_img",columnDefinition="COMMENT '商品图片'")
    private String goodsImg;

    /**
     * 商品数量
     */
    @Column(name="goods_num",columnDefinition="COMMENT '商品数量'")
    private Long goodsNum;

    /**
     * 货物状态
     */
    @Column(name="goods_status",columnDefinition="COMMENT '货物状态'")
    private String goodsStatus;

    /**
     * 用户id
     */
    @Column(name="user_id",columnDefinition="COMMENT '用户id'")
    private Long userId;

    /**
     * 用户名
     */
    @Column(name="user_name",columnDefinition="COMMENT '用户名'")
    private String userName;

    /**
     * 退款编号
     */
    @Column(name="refund_no",columnDefinition="COMMENT '退款编号'")
    private String refundNo;

    /**
     * 退款账户信息
     */
    @Column(name="refund_msg",columnDefinition="COMMENT '退款账户信息'")
    private String refundMsg;

    /**
     * 申请时间
     */
    @Temporal(TemporalType.TIMESTAMP)   
    @Column(name="refund_create_time",columnDefinition="COMMENT '申请时间'")
    private Date refundCreateTime;

    /**
     * 退款完成时间
     */
    @Temporal(TemporalType.TIMESTAMP)   
    @Column(name="refund_complete_time",columnDefinition="COMMENT '退款完成时间'")
    private Date refundCompleteTime;

    /**
     * 退款状态
     */
    @Column(name="refund_status",columnDefinition="COMMENT '退款状态'")
    private String refundStatus;

    /**
     * 退款退货类型0-退款1-退货
     */
    @Column(name="has_goods_return",columnDefinition="COMMENT '退款退货类型0-退款1-退货'")
    private String hasGoodsReturn;

    /**
     * 退款金额
     */
    @Column(name="apply_refund_fee",columnDefinition="COMMENT '退款金额'")
    private Double applyRefundFee;

    /**
     * 剩余金额
     */
    @Column(name="payment",columnDefinition="COMMENT '剩余金额'")
    private Double payment;

    /**
     * 退款原因
     */
    @Column(name="reason",columnDefinition="COMMENT '退款原因'")
    private String reason;

    /**
     * 退款说明
     */
    @Column(name="description",columnDefinition="COMMENT '退款说明'")
    private String description;

    /**
     * 实际退款金额
     */
    @Column(name="real_refund_fee",columnDefinition="COMMENT '实际退款金额'")
    private Double realRefundFee;

    /**
     * 拒绝原因
     */
    @Column(name="refuse_reason",columnDefinition="COMMENT '拒绝原因'")
    private String refuseReason;

    /**
     * 拒绝备注
     */
    @Column(name="refuse_desc",columnDefinition="COMMENT '拒绝备注'")
    private String refuseDesc;

    /**
     * 凭证1
     */
    @Column(name="photo1",columnDefinition="COMMENT '凭证1'")
    private String photo1;

    /**
     * 凭证2
     */
    @Column(name="photo2",columnDefinition="COMMENT '凭证2'")
    private String photo2;

    /**
     * 凭证3
     */
    @Column(name="photo3",columnDefinition="COMMENT '凭证3'")
    private String photo3;

    /**
     * 凭证4
     */
    @Column(name="photo4",columnDefinition="COMMENT '凭证4'")
    private String photo4;

    /**
     * 凭证5
     */
    @Column(name="photo5",columnDefinition="COMMENT '凭证5'")
    private String photo5;

    /**
     * 物流单号
     */
    @Column(name="sid",columnDefinition="COMMENT '物流单号'")
    private String sid;

    /**
     * 物流公司名称
     */
    @Column(name="company_name",columnDefinition="COMMENT '物流公司名称'")
    private String companyName;

    /**
     * 收货人姓名
     */
    @Column(name="consignee",columnDefinition="COMMENT '收货人姓名'")
    private String consignee;

    /**
     * 国家
     */
    @Column(name="country",columnDefinition="COMMENT '国家'")
    private Long country;

    /**
     * 国家名称
     */
    @Column(name="county_name",columnDefinition="COMMENT '国家名称'")
    private String countyName;

    /**
     * 省
     */
    @Column(name="province",columnDefinition="COMMENT '省'")
    private Long province;

    /**
     * 省名称
     */
    @Column(name="province_name",columnDefinition="COMMENT '省名称'")
    private String provinceName;

    /**
     * 市
     */
    @Column(name="city",columnDefinition="COMMENT '市'")
    private Long city;

    /**
     * 城市名称
     */
    @Column(name="city_name",columnDefinition="COMMENT '城市名称'")
    private String cityName;

    /**
     * 区、县
     */
    @Column(name="district",columnDefinition="COMMENT '区、县'")
    private Long district;

    /**
     * 区县名称
     */
    @Column(name="district_name",columnDefinition="COMMENT '区县名称'")
    private String districtName;

    /**
     * 地址
     */
    @Column(name="address",columnDefinition="COMMENT '地址'")
    private String address;

    /**
     * 邮编
     */
    @Column(name="zipcode",columnDefinition="COMMENT '邮编'")
    private String zipcode;

    /**
     * 电话
     */
    @Column(name="tel",columnDefinition="COMMENT '电话'")
    private String tel;

    /**
     * 手机
     */
    @Column(name="mobile",columnDefinition="COMMENT '手机'")
    private String mobile;


    /** 
	* @return id ：ID
	*/
    public Long getId() {
        return id;
    }
    /** 
    *@param id 设置ID 
    */
    public void setId(Long id) {
        this.id = id;
    }

    /** 
	* @return tid ：订单主键
	*/
    public Long getTid() {
        return tid;
    }
    /** 
    *@param tid 设置订单主键 
    */
    public void setTid(Long tid) {
        this.tid = tid;
    }

    /** 
	* @return orderSn ：订单编号
	*/
    public String getOrderSn() {
        return orderSn;
    }
    /** 
    *@param orderSn 设置订单编号 
    */
    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn;
    }

    /** 
	* @return orderStatus ：退款时的订单状态
	*/
    public String getOrderStatus() {
        return orderStatus;
    }
    /** 
    *@param orderStatus 设置退款时的订单状态 
    */
    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    /** 
	* @return totalFee ：订单总金额
	*/
    public Double getTotalFee() {
        return totalFee;
    }
    /** 
    *@param totalFee 设置订单总金额 
    */
    public void setTotalFee(Double totalFee) {
        this.totalFee = totalFee;
    }

    /** 
	* @return goodsId ：商品编号
	*/
    public Long getGoodsId() {
        return goodsId;
    }
    /** 
    *@param goodsId 设置商品编号 
    */
    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    /** 
	* @return goodsPrice ：商品价格
	*/
    public Double getGoodsPrice() {
        return goodsPrice;
    }
    /** 
    *@param goodsPrice 设置商品价格 
    */
    public void setGoodsPrice(Double goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    /** 
	* @return goodsName ：商品名称
	*/
    public String getGoodsName() {
        return goodsName;
    }
    /** 
    *@param goodsName 设置商品名称 
    */
    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    /** 
	* @return goodsImg ：商品图片
	*/
    public String getGoodsImg() {
        return goodsImg;
    }
    /** 
    *@param goodsImg 设置商品图片 
    */
    public void setGoodsImg(String goodsImg) {
        this.goodsImg = goodsImg;
    }

    /** 
	* @return goodsNum ：商品数量
	*/
    public Long getGoodsNum() {
        return goodsNum;
    }
    /** 
    *@param goodsNum 设置商品数量 
    */
    public void setGoodsNum(Long goodsNum) {
        this.goodsNum = goodsNum;
    }

    /** 
	* @return goodsStatus ：货物状态
	*/
    public String getGoodsStatus() {
        return goodsStatus;
    }
    /** 
    *@param goodsStatus 设置货物状态 
    */
    public void setGoodsStatus(String goodsStatus) {
        this.goodsStatus = goodsStatus;
    }

    /** 
	* @return userId ：用户id
	*/
    public Long getUserId() {
        return userId;
    }
    /** 
    *@param userId 设置用户id 
    */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /** 
	* @return userName ：用户名
	*/
    public String getUserName() {
        return userName;
    }
    /** 
    *@param userName 设置用户名 
    */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /** 
	* @return refundNo ：退款编号
	*/
    public String getRefundNo() {
        return refundNo;
    }
    /** 
    *@param refundNo 设置退款编号 
    */
    public void setRefundNo(String refundNo) {
        this.refundNo = refundNo;
    }

    /** 
	* @return refundMsg ：退款账户信息
	*/
    public String getRefundMsg() {
        return refundMsg;
    }
    /** 
    *@param refundMsg 设置退款账户信息 
    */
    public void setRefundMsg(String refundMsg) {
        this.refundMsg = refundMsg;
    }

    /** 
	* @return refundCreateTime ：申请时间
	*/
    public Date getRefundCreateTime() {
        return refundCreateTime;
    }
    /** 
    *@param refundCreateTime 设置申请时间 
    */
    public void setRefundCreateTime(Date refundCreateTime) {
        this.refundCreateTime = refundCreateTime;
    }

    /** 
	* @return refundCompleteTime ：退款完成时间
	*/
    public Date getRefundCompleteTime() {
        return refundCompleteTime;
    }
    /** 
    *@param refundCompleteTime 设置退款完成时间 
    */
    public void setRefundCompleteTime(Date refundCompleteTime) {
        this.refundCompleteTime = refundCompleteTime;
    }

    /** 
	* @return refundStatus ：退款状态
	*/
    public String getRefundStatus() {
        return refundStatus;
    }
    /** 
    *@param refundStatus 设置退款状态 
    */
    public void setRefundStatus(String refundStatus) {
        this.refundStatus = refundStatus;
    }

    /** 
	* @return hasGoodsReturn ：退款退货类型0-退款1-退货
	*/
    public String getHasGoodsReturn() {
        return hasGoodsReturn;
    }
    /** 
    *@param hasGoodsReturn 设置退款退货类型0-退款1-退货 
    */
    public void setHasGoodsReturn(String hasGoodsReturn) {
        this.hasGoodsReturn = hasGoodsReturn;
    }

    /** 
	* @return applyRefundFee ：退款金额
	*/
    public Double getApplyRefundFee() {
        return applyRefundFee;
    }
    /** 
    *@param applyRefundFee 设置退款金额 
    */
    public void setApplyRefundFee(Double applyRefundFee) {
        this.applyRefundFee = applyRefundFee;
    }

    /** 
	* @return payment ：剩余金额
	*/
    public Double getPayment() {
        return payment;
    }
    /** 
    *@param payment 设置剩余金额 
    */
    public void setPayment(Double payment) {
        this.payment = payment;
    }

    /** 
	* @return reason ：退款原因
	*/
    public String getReason() {
        return reason;
    }
    /** 
    *@param reason 设置退款原因 
    */
    public void setReason(String reason) {
        this.reason = reason;
    }

    /** 
	* @return description ：退款说明
	*/
    public String getDescription() {
        return description;
    }
    /** 
    *@param description 设置退款说明 
    */
    public void setDescription(String description) {
        this.description = description;
    }

    /** 
	* @return realRefundFee ：实际退款金额
	*/
    public Double getRealRefundFee() {
        return realRefundFee;
    }
    /** 
    *@param realRefundFee 设置实际退款金额 
    */
    public void setRealRefundFee(Double realRefundFee) {
        this.realRefundFee = realRefundFee;
    }

    /** 
	* @return refuseReason ：拒绝原因
	*/
    public String getRefuseReason() {
        return refuseReason;
    }
    /** 
    *@param refuseReason 设置拒绝原因 
    */
    public void setRefuseReason(String refuseReason) {
        this.refuseReason = refuseReason;
    }

    /** 
	* @return refuseDesc ：拒绝备注
	*/
    public String getRefuseDesc() {
        return refuseDesc;
    }
    /** 
    *@param refuseDesc 设置拒绝备注 
    */
    public void setRefuseDesc(String refuseDesc) {
        this.refuseDesc = refuseDesc;
    }

    /** 
	* @return photo1 ：凭证1
	*/
    public String getPhoto1() {
        return photo1;
    }
    /** 
    *@param photo1 设置凭证1 
    */
    public void setPhoto1(String photo1) {
        this.photo1 = photo1;
    }

    /** 
	* @return photo2 ：凭证2
	*/
    public String getPhoto2() {
        return photo2;
    }
    /** 
    *@param photo2 设置凭证2 
    */
    public void setPhoto2(String photo2) {
        this.photo2 = photo2;
    }

    /** 
	* @return photo3 ：凭证3
	*/
    public String getPhoto3() {
        return photo3;
    }
    /** 
    *@param photo3 设置凭证3 
    */
    public void setPhoto3(String photo3) {
        this.photo3 = photo3;
    }

    /** 
	* @return photo4 ：凭证4
	*/
    public String getPhoto4() {
        return photo4;
    }
    /** 
    *@param photo4 设置凭证4 
    */
    public void setPhoto4(String photo4) {
        this.photo4 = photo4;
    }

    /** 
	* @return photo5 ：凭证5
	*/
    public String getPhoto5() {
        return photo5;
    }
    /** 
    *@param photo5 设置凭证5 
    */
    public void setPhoto5(String photo5) {
        this.photo5 = photo5;
    }

    /** 
	* @return sid ：物流单号
	*/
    public String getSid() {
        return sid;
    }
    /** 
    *@param sid 设置物流单号 
    */
    public void setSid(String sid) {
        this.sid = sid;
    }

    /** 
	* @return companyName ：物流公司名称
	*/
    public String getCompanyName() {
        return companyName;
    }
    /** 
    *@param companyName 设置物流公司名称 
    */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    /** 
	* @return consignee ：收货人姓名
	*/
    public String getConsignee() {
        return consignee;
    }
    /** 
    *@param consignee 设置收货人姓名 
    */
    public void setConsignee(String consignee) {
        this.consignee = consignee;
    }

    /** 
	* @return country ：国家
	*/
    public Long getCountry() {
        return country;
    }
    /** 
    *@param country 设置国家 
    */
    public void setCountry(Long country) {
        this.country = country;
    }

    /** 
	* @return countyName ：国家名称
	*/
    public String getCountyName() {
        return countyName;
    }
    /** 
    *@param countyName 设置国家名称 
    */
    public void setCountyName(String countyName) {
        this.countyName = countyName;
    }

    /** 
	* @return province ：省
	*/
    public Long getProvince() {
        return province;
    }
    /** 
    *@param province 设置省 
    */
    public void setProvince(Long province) {
        this.province = province;
    }

    /** 
	* @return provinceName ：省名称
	*/
    public String getProvinceName() {
        return provinceName;
    }
    /** 
    *@param provinceName 设置省名称 
    */
    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    /** 
	* @return city ：市
	*/
    public Long getCity() {
        return city;
    }
    /** 
    *@param city 设置市 
    */
    public void setCity(Long city) {
        this.city = city;
    }

    /** 
	* @return cityName ：城市名称
	*/
    public String getCityName() {
        return cityName;
    }
    /** 
    *@param cityName 设置城市名称 
    */
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    /** 
	* @return district ：区、县
	*/
    public Long getDistrict() {
        return district;
    }
    /** 
    *@param district 设置区、县 
    */
    public void setDistrict(Long district) {
        this.district = district;
    }

    /** 
	* @return districtName ：区县名称
	*/
    public String getDistrictName() {
        return districtName;
    }
    /** 
    *@param districtName 设置区县名称 
    */
    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    /** 
	* @return address ：地址
	*/
    public String getAddress() {
        return address;
    }
    /** 
    *@param address 设置地址 
    */
    public void setAddress(String address) {
        this.address = address;
    }

    /** 
	* @return zipcode ：邮编
	*/
    public String getZipcode() {
        return zipcode;
    }
    /** 
    *@param zipcode 设置邮编 
    */
    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    /** 
	* @return tel ：电话
	*/
    public String getTel() {
        return tel;
    }
    /** 
    *@param tel 设置电话 
    */
    public void setTel(String tel) {
        this.tel = tel;
    }

    /** 
	* @return mobile ：手机
	*/
    public String getMobile() {
        return mobile;
    }
    /** 
    *@param mobile 设置手机 
    */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }


}