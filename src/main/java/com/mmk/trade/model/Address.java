/*
 * 
 *  Address 创建于 2016-11-05 13:29:18 版权归作者和作者当前组织所有
 */
package com.mmk.trade.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;

/**
* Address: 地址管理 数据领域模型
* 2016-11-05 13:29:18
*@author huguangling 胡广玲
*@version 1.0
*/
@Entity
@Table(name="trade_address")
public class Address {
    /**
     * 地址ID
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
     * 订单ID
     */
    @Column(name="order_id")
    private Long orderId;

    /**
     * 收货人姓名
     */
    @Column(name="consignee")
    private String consignee;

    /**
     * email
     */
    @Column(name="email")
    private String email;

    /**
     * 国家
     */
    @Column(name="country")
    private Long country;

    /**
     * 省
     */
    @Column(name="province")
    private Long province;

    /**
     * 市
     */
    @Column(name="city")
    private Long city;

    /**
     * 区、县
     */
    @Column(name="district")
    private Long district;

    /**
     * 地址
     */
    @Column(name="address")
    private String address;

    /**
     * 邮编
     */
    @Column(name="zipcode")
    private String zipcode;

    /**
     * 电话
     */
    @Column(name="tel")
    private String tel;

    /**
     * 手机
     */
    @Column(name="mobile")
    private String mobile;

    /**
     * 最佳送货时间
     */
    @Column(name="best_time")
    private String bestTime;


    /** 
	* @return id ：地址ID
	*/
    public Long getId() {
        return id;
    }
    /** 
    *@param id 设置地址ID 
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
	* @return orderId ：订单ID
	*/
    public Long getOrderId() {
        return orderId;
    }
    /** 
    *@param orderId 设置订单ID 
    */
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
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
	* @return email ：email
	*/
    public String getEmail() {
        return email;
    }
    /** 
    *@param email 设置email 
    */
    public void setEmail(String email) {
        this.email = email;
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

    /** 
	* @return bestTime ：最佳送货时间
	*/
    public String getBestTime() {
        return bestTime;
    }
    /** 
    *@param bestTime 设置最佳送货时间 
    */
    public void setBestTime(String bestTime) {
        this.bestTime = bestTime;
    }


}