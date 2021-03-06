/*
 * 
 *  TuanOrder 创建于 2016-11-10 11:42:15 版权归作者和作者当前组织所有
 */
package com.mmk.trade.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.mmk.business.model.WxUser;

/**
* TuanOrder: 广告 数据领域模型
* 2016-11-10 11:42:15
*@author huguangling 胡广玲
*@version 1.0
*/
@Entity
@Table(name="trade_tuan_order")
public class TuanOrder {
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
    @NotFound(action=NotFoundAction.IGNORE)
    @ManyToOne
    @JoinColumn(name="user_id")
    private WxUser user;
    
    /**
     * 团ID
     */
    @NotFound(action=NotFoundAction.IGNORE)
    @ManyToOne
    @JoinColumn(name="tuan_id")
    private Tuan tuan;
    
    /**
     * 团商品ID
     */
    @JoinColumn(name="group_id")
    private Long groupId;

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
     * 头像路径
     */
    @Column(name="headimgurl")
    private String headimgurl;

    /**
     * 订单手机号
     */
    @Column(name="order_phone")
    private String orderPhone;
    
	/**
     * 交易编号
     */
    @Column(name="order_pay_code")
    private String orderPayCode;
    
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
     * 订单分类：0，一元购；1，拼团
     */
    @Column(name="order_sort")
    private Long orderSort;

    /**
     * 商品图片
     */
    @Column(name="goods_img")
    private String goodsImg;

    /**
     * 商品名称
     */
    @Column(name="goods_name")
    private String goodsName;

    /**
     * 商品编码
     */
    @Column(name="goods_code")
    private String goodsCode;

    /**
     * 商品价格
     */
    @Column(name="goods_price")
    private Double goodsPrice;

    /**
     * 订单价格
     */
    @Column(name="order_price")
    private Double orderPrice;

    /**
     * 订单状态：
	*	wait_pay:待付款;
	*	wait_join:待成团;
	*	wait_shipping待发货;
	*	wait_receive:待收货;
	*	wait_comment:待评价;
	*	successed:已完成;
	*	wait_refund_goods:待退货
	*	wait_refund_money:待退款
	*	closed:已关闭; 
     * 
     */
    @Column(name="order_status")
    private String orderStatus;

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
    public WxUser getUser() {
        return user;
    }
    /** 
    *@param userId 设置用户ID 
    */
    public void setUser(WxUser user) {
        this.user = user;
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
    public String getGoodsImg() {
        return goodsImg;
    }
    /** 
    *@param goodImg 设置商品图片 
    */
    public void setGoodsImg(String goodsImg) {
        this.goodsImg = goodsImg;
    }

    /** 
	* @return goodName ：商品名称
	*/
    public String getGoodsName() {
        return goodsName;
    }
    /** 
    *@param goodName 设置商品名称 
    */
    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    /** 
	* @return goodCode ：商品编码
	*/
    public String getGoodsCode() {
        return goodsCode;
    }
    /** 
    *@param goodCode 设置商品编码 
    */
    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode;
    }

    /** 
	* @return goodPrice ：商品价格
	*/
    public Double getGoodsPrice() {
        return goodsPrice;
    }
    /** 
    *@param goodPrice 设置商品价格 
    */
    public void setGoodsPrice(Double goodsPrice) {
        this.goodsPrice = goodsPrice;
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
    * 订单状态：
	*	wait_pay:待付款;
	*	wait_join:待成团;
	*	wait_shipping待发货;
	*	wait_receive:待收货;
	*	wait_comment:待评价;
	*	successed:已完成;
	*	wait_refund_goods:待退货
	*	wait_refund_money:待退款
	*	closed:已关闭;
	* @return orderStatus ：订单状态
	*/
    public String getOrderStatus() {
        return orderStatus;
    }
    /**
    * 订单状态：
	*	wait_pay:待付款;
	*	wait_join:待成团;
	*	wait_shipping待发货;
	*	wait_receive:待收货;
	*	wait_comment:待评价;
	*	successed:已完成;
	*	wait_refund_goods:待退货
	*	wait_refund_money:待退款
	*	closed:已关闭; 
    *@param orderStatus 设置订单状态：0，全部；1，待付款；2，拼团中；3，待发货；4，待收货；5，已成功；6，已关闭 
    */
    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }
    
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

    public String getOrderPhone() {
		return orderPhone;
	}
	public void setOrderPhone(String orderPhone) {
		this.orderPhone = orderPhone;
	}
	public Tuan getTuan() {
		return tuan;
	}
	public void setTuan(Tuan tuan) {
		this.tuan = tuan;
	}
	public String getHeadimgurl() {
		return headimgurl;
	}
	public void setHeadimgurl(String headimgurl) {
		this.headimgurl = headimgurl;
	}
    public String getOrderPayCode() {
		return orderPayCode;
	}
	public void setOrderPayCode(String orderPayCode) {
		this.orderPayCode = orderPayCode;
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
	public Long getGroupId() {
		return groupId;
	}
	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}



}

