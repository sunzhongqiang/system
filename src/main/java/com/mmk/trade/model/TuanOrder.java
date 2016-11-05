/*
 * 
 *  TuanOrder 创建于 2016-11-05 13:27:33 版权归作者和作者当前组织所有
 */
package com.mmk.trade.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;

/**
* TuanOrder: 团订单管理 数据领域模型
* 2016-11-05 13:27:33
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
     * 团ID
     */
    @Column(name="tuan_id")
    private Long tuanId;

    /**
     * 用户ID
     */
    @Column(name="user_id")
    private Long userId;

    /**
     * 商品ID
     */
    @Column(name="goods_id")
    private Long goodsId;

    /**
     * 用户昵称
     */
    @Column(name="user_nick_name")
    private String userNickName;

    /**
     * 真实姓名
     */
    @Column(name="user_real_name")
    private String userRealName;

    /**
     * 用户性别
     */
    @Column(name="user_sex")
    private Long userSex;

    /**
     * 收货人姓名
     */
    @Column(name="consignee")
    private String consignee;

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
	* @return tuanId ：团ID
	*/
    public Long getTuanId() {
        return tuanId;
    }
    /** 
    *@param tuanId 设置团ID 
    */
    public void setTuanId(Long tuanId) {
        this.tuanId = tuanId;
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
	* @return userNickName ：用户昵称
	*/
    public String getUserNickName() {
        return userNickName;
    }
    /** 
    *@param userNickName 设置用户昵称 
    */
    public void setUserNickName(String userNickName) {
        this.userNickName = userNickName;
    }

    /** 
	* @return userRealName ：真实姓名
	*/
    public String getUserRealName() {
        return userRealName;
    }
    /** 
    *@param userRealName 设置真实姓名 
    */
    public void setUserRealName(String userRealName) {
        this.userRealName = userRealName;
    }

    /** 
	* @return userSex ：用户性别
	*/
    public Long getUserSex() {
        return userSex;
    }
    /** 
    *@param userSex 设置用户性别 
    */
    public void setUserSex(Long userSex) {
        this.userSex = userSex;
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