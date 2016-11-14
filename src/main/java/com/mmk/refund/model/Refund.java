/*
 * 
 *  Refund 创建于 2016-11-14 13:07:09 版权归作者和作者当前组织所有
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
* 2016-11-14 13:07:09
*@author huguangling 胡广玲
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
    @Column(name="id")
    private Long id;

    /**
     * 订单主键
     */
    @Column(name="tid")
    private Long tid;

    /**
     * 订单编号
     */
    @Column(name="order_sn")
    private String orderSn;

    /**
     * 退款时的订单状态
     */
    @Column(name="order_status")
    private Long orderStatus;

    /**
     * 订单总金额
     */
    @Column(name="total_fee")
    private Double totalFee;

    /**
     * 商品编号
     */
    @Column(name="goods_id")
    private Long goodsId;

    /**
     * 商品价格
     */
    @Column(name="goods_price")
    private Double goodsPrice;

    /**
     * 商品数量
     */
    @Column(name="goods_num")
    private Long goodsNum;

    /**
     * 货物状态
     */
    @Column(name="goods_status")
    private String goodsStatus;

    /**
     * 用户id
     */
    @Column(name="user_id")
    private Long userId;

    /**
     * 用户名
     */
    @Column(name="username")
    private String username;

    /**
     * 退款编号
     */
    @Column(name="refund_no")
    private String refundNo;

    /**
     * 退款账户信息
     */
    @Column(name="refund_msg")
    private String refundMsg;

    /**
     * 申请时间
     */
    @Temporal(TemporalType.TIMESTAMP)   
    @Column(name="refund_create_time")
    private Date refundCreateTime;

    /**
     * 退款完成时间
     */
    @Temporal(TemporalType.TIMESTAMP)   
    @Column(name="refund_complete_time")
    private Date refundCompleteTime;

    /**
     * 退款状态
     */
    @Column(name="refund_status")
    private String refundStatus;

    /**
     * 退款退货类型0-退款1-退货
     */
    @Column(name="has_goods_return")
    private String hasGoodsReturn;

    /**
     * 退款金额
     */
    @Column(name="apply_refund_fee")
    private Double applyRefundFee;

    /**
     * 剩余金额
     */
    @Column(name="payment")
    private Double payment;

    /**
     * 退款原因
     */
    @Column(name="reason")
    private String reason;

    /**
     * 退款说明
     */
    @Column(name="description")
    private String description;

    /**
     * 退货地址
     */
    @Column(name="refund_address")
    private String refundAddress;

    /**
     * 实际退款金额
     */
    @Column(name="real_refund_fee")
    private Double realRefundFee;

    /**
     * 拒绝原因
     */
    @Column(name="refuse_reason")
    private String refuseReason;

    /**
     * 拒绝备注
     */
    @Column(name="refuse_desc")
    private String refuseDesc;

    /**
     * 凭证1
     */
    @Column(name="photo1")
    private String photo1;

    /**
     * 凭证2
     */
    @Column(name="photo2")
    private String photo2;

    /**
     * 凭证3
     */
    @Column(name="photo3")
    private String photo3;

    /**
     * 凭证4
     */
    @Column(name="photo4")
    private String photo4;

    /**
     * 凭证5
     */
    @Column(name="photo5")
    private String photo5;

    /**
     * 物流单号
     */
    @Column(name="sid")
    private String sid;

    /**
     * 物流公司名称
     */
    @Column(name="company_name")
    private String companyName;


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
    public Long getOrderStatus() {
        return orderStatus;
    }
    /** 
    *@param orderStatus 设置退款时的订单状态 
    */
    public void setOrderStatus(Long orderStatus) {
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
	* @return username ：用户名
	*/
    public String getUsername() {
        return username;
    }
    /** 
    *@param username 设置用户名 
    */
    public void setUsername(String username) {
        this.username = username;
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
	* @return refundAddress ：退货地址
	*/
    public String getRefundAddress() {
        return refundAddress;
    }
    /** 
    *@param refundAddress 设置退货地址 
    */
    public void setRefundAddress(String refundAddress) {
        this.refundAddress = refundAddress;
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


}