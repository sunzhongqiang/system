

/*
 * 
 *  TuanOrder 创建于 2016-11-10 11:42:15 版权归作者和作者当前组织所有
 */
package com.mmk.trade.model;

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
* TuanOrder: 广告 数据领域模型
* 2016-11-10 11:42:15
*@author huguangling 胡广玲
*@version 1.0
*/
@Entity
@Table(name="trade_order")
public class Order {
    /**
     * 团订单ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long id;

    /**
     * 用户ID
     */
    @Column(name="user_id")
    private Long userId;

    /**
     * 团编码
     */
    @Column(name="tuan_code")
    private String tuanCode;

    /**
     * 商品ID
     */
    @Column(name="goods_id")
    private Long goodsId;

    /**
     * 用户名
     */
    @Column(name="user_name")
    private String userName;

    /**
     * 订单编号
     */
    @Column(name="order_code")
    private String orderCode;

    /**
     * 下单时间
     */
    @Temporal(TemporalType.TIMESTAMP)   
    @Column(name="order_time")
    private Date orderTime;

    /**
     * 支付时间
     */
    @Temporal(TemporalType.TIMESTAMP)   
    @Column(name="pay_time")
    private Date payTime;

    /**
     * 订单分类：1，一元购；2，拼团
     */
    @Column(name="order_sort")
    private Long orderSort;

    /**
     * 商品图片
     */
    @Column(name="good_img")
    private String goodImg;

    /**
     * 商品名称
     */
    @Column(name="good_name")
    private String goodName;

    /**
     * 商品编码
     */
    @Column(name="good_code")
    private String goodCode;

    /**
     * 商品价格
     */
    @Column(name="good_price")
    private Double goodPrice;

    /**
     * 订单价格
     */
    @Column(name="order_price")
    private Double orderPrice;

    /**
     * 订单状态：0，全部；1，待付款；2，拼团中；3，待发货；4，待收货；5，已成功；6，已关闭
     */
    @Column(name="order_status")
    private Long orderStatus;

    /**
     * 收获地址
     */
    @Column(name="address")
    private String address;

    /**
     * 是否中奖：1，是；2，否
     */
    @Column(name="lucky_order")
    private Long luckyOrder;

    /**
     * 团长
     */
    @Column(name="colonel")
    private Long colonel;

    /**
     * 物流单号
     */
    @Column(name="invoice_no")
    private String invoiceNo;

    /**
     * 物流公司名称
     */
    @Column(name="shipping_name")
    private String shippingName;

    /**
     * 物流公司ID
     */
    @Column(name="shipping_id")
    private Long shippingId;

    /**
     * 发货时间
     */
    @Temporal(TemporalType.TIMESTAMP)   
    @Column(name="shipping_time")
    private Date shippingTime;


    /** 
	* @return id ：团订单ID
	*/
    public Long getId() {
        return id;
    }
    /** 
    *@param id 设置团订单ID 
    */
    public void setId(Long id) {
        this.id = id;
    }

    /** 
	* @return userId ：用户ID
	*/
    public Long getUserId() {
        return userId;
    }
    /** 
    *@param userId 设置用户ID 
    */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /** 
	* @return tuanCode ：团编码
	*/
    public String getTuanCode() {
        return tuanCode;
    }
    /** 
    *@param tuanCode 设置团编码 
    */
    public void setTuanCode(String tuanCode) {
        this.tuanCode = tuanCode;
    }

    /** 
	* @return goodsId ：商品ID
	*/
    public Long getGoodsId() {
        return goodsId;
    }
    /** 
    *@param goodsId 设置商品ID 
    */
    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
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
	* @return orderCode ：订单编号
	*/
    public String getOrderCode() {
        return orderCode;
    }
    /** 
    *@param orderCode 设置订单编号 
    */
    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    /** 
	* @return orderTime ：下单时间
	*/
    public Date getOrderTime() {
        return orderTime;
    }
    /** 
    *@param orderTime 设置下单时间 
    */
    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    /** 
	* @return payTime ：支付时间
	*/
    public Date getPayTime() {
        return payTime;
    }
    /** 
    *@param payTime 设置支付时间 
    */
    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    /** 
	* @return orderSort ：订单分类：1，一元购；2，拼团
	*/
    public Long getOrderSort() {
        return orderSort;
    }
    /** 
    *@param orderSort 设置订单分类：1，一元购；2，拼团 
    */
    public void setOrderSort(Long orderSort) {
        this.orderSort = orderSort;
    }

    /** 
	* @return goodImg ：商品图片
	*/
    public String getGoodImg() {
        return goodImg;
    }
    /** 
    *@param goodImg 设置商品图片 
    */
    public void setGoodImg(String goodImg) {
        this.goodImg = goodImg;
    }

    /** 
	* @return goodName ：商品名称
	*/
    public String getGoodName() {
        return goodName;
    }
    /** 
    *@param goodName 设置商品名称 
    */
    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

    /** 
	* @return goodCode ：商品编码
	*/
    public String getGoodCode() {
        return goodCode;
    }
    /** 
    *@param goodCode 设置商品编码 
    */
    public void setGoodCode(String goodCode) {
        this.goodCode = goodCode;
    }

    /** 
	* @return goodPrice ：商品价格
	*/
    public Double getGoodPrice() {
        return goodPrice;
    }
    /** 
    *@param goodPrice 设置商品价格 
    */
    public void setGoodPrice(Double goodPrice) {
        this.goodPrice = goodPrice;
    }

    /** 
	* @return orderPrice ：订单价格
	*/
    public Double getOrderPrice() {
        return orderPrice;
    }
    /** 
    *@param orderPrice 设置订单价格 
    */
    public void setOrderPrice(Double orderPrice) {
        this.orderPrice = orderPrice;
    }

    /** 
	* @return orderStatus ：订单状态：0，全部；1，待付款；2，拼团中；3，待发货；4，待收货；5，已成功；6，已关闭
	*/
    public Long getOrderStatus() {
        return orderStatus;
    }
    /** 
    *@param orderStatus 设置订单状态：0，全部；1，待付款；2，拼团中；3，待发货；4，待收货；5，已成功；6，已关闭 
    */
    public void setOrderStatus(Long orderStatus) {
        this.orderStatus = orderStatus;
    }

    /** 
	* @return address ：收获地址
	*/
    public String getAddress() {
        return address;
    }
    /** 
    *@param address 设置收获地址 
    */
    public void setAddress(String address) {
        this.address = address;
    }

    /** 
	* @return luckyOrder ：是否中奖：1，是；2，否
	*/
    public Long getLuckyOrder() {
        return luckyOrder;
    }
    /** 
    *@param luckyOrder 设置是否中奖：1，是；2，否 
    */
    public void setLuckyOrder(Long luckyOrder) {
        this.luckyOrder = luckyOrder;
    }

    /** 
	* @return colonel ：团长
	*/
    public Long getColonel() {
        return colonel;
    }
    /** 
    *@param colonel 设置团长 
    */
    public void setColonel(Long colonel) {
        this.colonel = colonel;
    }

    /** 
	* @return invoiceNo ：物流单号
	*/
    public String getInvoiceNo() {
        return invoiceNo;
    }
    /** 
    *@param invoiceNo 设置物流单号 
    */
    public void setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    /** 
	* @return shippingName ：物流公司名称
	*/
    public String getShippingName() {
        return shippingName;
    }
    /** 
    *@param shippingName 设置物流公司名称 
    */
    public void setShippingName(String shippingName) {
        this.shippingName = shippingName;
    }

    /** 
	* @return shippingId ：物流公司ID
	*/
    public Long getShippingId() {
        return shippingId;
    }
    /** 
    *@param shippingId 设置物流公司ID 
    */
    public void setShippingId(Long shippingId) {
        this.shippingId = shippingId;
    }

    /** 
	* @return shippingTime ：发货时间
	*/
    public Date getShippingTime() {
        return shippingTime;
    }
    /** 
    *@param shippingTime 设置发货时间 
    */
    public void setShippingTime(Date shippingTime) {
        this.shippingTime = shippingTime;
    }


}

