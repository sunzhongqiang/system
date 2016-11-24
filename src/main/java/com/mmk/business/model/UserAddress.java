/*
 * 
 *  UserAddress 创建于 2016-11-16 09:37:57 版权归作者和作者当前组织所有
 */
package com.mmk.business.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang3.StringUtils;

import javax.persistence.Column;

/**
* UserAddress: 会员地址 数据领域模型
* 2016-11-16 09:37:57
*@author huguangling 胡广玲
*@version 1.0
*/
@Entity
@Table(name="business_user_address")
public class UserAddress {
    /**
     * 地址id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long id;

    /**
     * 地址名称
     */
    @Column(name="address_name")
    private String addressName;

    /**
     * 会员id
     */
    @Column(name="user_id")
    private Long userId;

    /**
     * openid
     */
    @Column(name="openid")
    private String openid;

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
     * 国家名称
     */
    @Column(name="county_name")
    private String countyName;

    /**
     * 省
     */
    @Column(name="province")
    private Long province;

    /**
     * 省名称
     */
    @Column(name="province_name")
    private String provinceName;

    /**
     * 市
     */
    @Column(name="city")
    private Long city;

    /**
     * 城市名称
     */
    @Column(name="city_name")
    private String cityName;

    /**
     * 区、县
     */
    @Column(name="district")
    private Long district;

    /**
     * 区县名称
     */
    @Column(name="district_name")
    private String districtName;

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
	* @return id ：地址id
	*/
    public Long getId() {
        return id;
    }
    /** 
    *@param id 设置地址id 
    */
    public void setId(Long id) {
        this.id = id;
    }

    /** 
	* @return addressName ：地址名称
	*/
    public String getAddressName() {
        return addressName;
    }
    /** 
    *@param addressName 设置地址名称 
    */
    public void setAddressName(String addressName) {
        this.addressName = addressName;
    }

    /** 
	* @return userId ：会员id
	*/
    public Long getUserId() {
        return userId;
    }
    /** 
    *@param userId 设置会员id 
    */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /** 
	* @return openid ：openid
	*/
    public String getOpenid() {
        return openid;
    }
    /** 
    *@param openid 设置openid 
    */
    public void setOpenid(String openid) {
        this.openid = openid;
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


    @Override
    public String toString() {
    	StringBuilder address = new StringBuilder();
    	address.append("收货人：");
    	address.append(StringUtils.trimToEmpty(consignee));
    	address.append(" 联系电话：");
    	address.append(StringUtils.trimToEmpty(tel));
    	address.append(" ");
    	address.append(StringUtils.trimToEmpty(mobile));
    	address.append(" 地址：");
    	address.append( StringUtils.trimToEmpty(provinceName));
    	address.append(" ");
    	address.append( StringUtils.trimToEmpty(cityName));
    	address.append(" ");
    	address.append( StringUtils.trimToEmpty(districtName));
    	address.append(" ");
    	address.append( StringUtils.trimToEmpty(addressName));
    	address.append(" 邮编：");
    	address.append(zipcode);
    	return address.toString();
    }
}