/*
 * 
 *  WxAppUser 创建于 2016-12-21 15:42:41 版权归作者和作者当前组织所有
 */
package com.mmk.weixin.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
* WxAppUser: 微信公众号的用户 数据领域模型
* 2016-12-21 15:42:41
*@author 
*@version 1.0
*/
@Entity
@Table(name="wx_app_user")
public class WxAppUser {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id",columnDefinition="COMMENT '主键'")
    private Long id;

    /**
     * 公众号ID
     */
    @Column(name="appid",columnDefinition="COMMENT '公众号ID'")
    private String appid;

    /**
     * 窗口id
     */
    @Column(name="openID",columnDefinition="COMMENT '窗口id'")
    private String openid;

    /**
     * 昵称
     */
    @Column(name="nickname",columnDefinition="COMMENT '昵称'")
    private String nickname;

    /**
     * 地址ID
     */
    @Column(name="address_id",columnDefinition="COMMENT '地址ID'")
    private Long addressId;

    /**
     * 真实姓名
     */
    @Column(name="realname",columnDefinition="COMMENT '真实姓名'")
    private String realname;

    /**
     * 性别
     */
    @Column(name="sex",columnDefinition="COMMENT '性别'")
    private String sex;

    /**
     * 语言
     */
    @Column(name="language",columnDefinition="COMMENT '语言'")
    private String language;

    /**
     * 省份
     */
    @Column(name="province",columnDefinition="COMMENT '省份'")
    private String province;

    /**
     * 城市
     */
    @Column(name="city",columnDefinition="COMMENT '城市'")
    private String city;

    /**
     * 国家
     */
    @Column(name="country",columnDefinition="COMMENT '国家'")
    private String country;

    /**
     * 头像路径
     */
    @Column(name="headimgurl",columnDefinition="COMMENT '头像路径'")
    private String headimgurl;

    /**
     * 权限
     */
    @Column(name="privilege",columnDefinition="COMMENT '权限'")
    private String privilege;


    /** 
	* @return id ：主键
	*/
    public Long getId() {
        return id;
    }
    /** 
    *@param id 设置主键 
    */
    public void setId(Long id) {
        this.id = id;
    }

    /** 
	* @return appid ：公众号ID
	*/
    public String getAppid() {
        return appid;
    }
    /** 
    *@param appid 设置公众号ID 
    */
    public void setAppid(String appid) {
        this.appid = appid;
    }

    /** 
	* @return openid ：窗口id
	*/
    public String getOpenid() {
        return openid;
    }
    /** 
    *@param openid 设置窗口id 
    */
    public void setOpenid(String openid) {
        this.openid = openid;
    }

    /** 
	* @return nickname ：昵称
	*/
    public String getNickname() {
        return nickname;
    }
    /** 
    *@param nickname 设置昵称 
    */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /** 
	* @return addressId ：地址ID
	*/
    public Long getAddressId() {
        return addressId;
    }
    /** 
    *@param addressId 设置地址ID 
    */
    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    /** 
	* @return realname ：真实姓名
	*/
    public String getRealname() {
        return realname;
    }
    /** 
    *@param realname 设置真实姓名 
    */
    public void setRealname(String realname) {
        this.realname = realname;
    }

    /** 
	* @return sex ：性别
	*/
    public String getSex() {
        return sex;
    }
    /** 
    *@param sex 设置性别 
    */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /** 
	* @return language ：语言
	*/
    public String getLanguage() {
        return language;
    }
    /** 
    *@param language 设置语言 
    */
    public void setLanguage(String language) {
        this.language = language;
    }

    /** 
	* @return province ：省份
	*/
    public String getProvince() {
        return province;
    }
    /** 
    *@param province 设置省份 
    */
    public void setProvince(String province) {
        this.province = province;
    }

    /** 
	* @return city ：城市
	*/
    public String getCity() {
        return city;
    }
    /** 
    *@param city 设置城市 
    */
    public void setCity(String city) {
        this.city = city;
    }

    /** 
	* @return country ：国家
	*/
    public String getCountry() {
        return country;
    }
    /** 
    *@param country 设置国家 
    */
    public void setCountry(String country) {
        this.country = country;
    }

    /** 
	* @return headimgurl ：头像路径
	*/
    public String getHeadimgurl() {
        return headimgurl;
    }
    /** 
    *@param headimgurl 设置头像路径 
    */
    public void setHeadimgurl(String headimgurl) {
        this.headimgurl = headimgurl;
    }

    /** 
	* @return privilege ：权限
	*/
    public String getPrivilege() {
        return privilege;
    }
    /** 
    *@param privilege 设置权限 
    */
    public void setPrivilege(String privilege) {
        this.privilege = privilege;
    }


}