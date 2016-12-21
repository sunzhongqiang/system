/*
 * 
 *  WxUser 创建于 2016-10-28 14:50:57 版权归作者和作者当前组织所有
 */
package com.mmk.business.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * WxUser: 微信用户 数据领域模型 2016-10-28 14:50:57
 * 
 * @author 胡广玲 huguangling
 * @version 1.0
 */
@Entity
@Table(name = "business_wx_user")
public class WxUser {
	/**
	 * 用户id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	/**
	 *  id
	 */
	@Column(name = "openID")
	private String openid;

	/**
	 * 昵称
	 */
	@Column(name = "nickname")
	private String nickname;

	/**
	 * 真实姓名
	 */
	@Column(name = "realname")
	private String realname;

	/**
	 * 性别
	 */
	@Column(name = "sex")
	private String sex;

	/**
	 * 语言
	 */
	@Column(name = "language")
	private String language;

	/**
	 * 省份
	 */
	@Column(name = "province")
	private String province;

	/**
	 * 城市
	 */
	@Column(name = "city")
	private String city;

	/**
	 * 国家
	 */
	@Column(name = "country")
	private String country;

	/**
	 * 头像路径
	 */
	@Column(name = "headimgurl")
	private String headimgurl;

	/**
	 * 权限
	 */
	@Column(name = "privilege")
	private String privilege;
	

	/**
	 * 部门主键
	 */
	@Column(name = "address_id")
	private Long addressId;

	/**
	 * @return id ：用户id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            设置用户id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return openid ：窗口id
	 */
	public String getOpenid() {
		return openid;
	}

	/**
	 * @param openid
	 *            设置窗口id
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
	 * @param nickname
	 *            设置昵称
	 */
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	/**
	 * @return realname ：真实姓名
	 */
	public String getRealname() {
		return realname;
	}

	/**
	 * @param realname
	 *            设置真实姓名
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
	 * @param sex
	 *            设置性别
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
	 * @param language
	 *            设置语言
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
	 * @param province
	 *            设置省份
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
	 * @param city
	 *            设置城市
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
	 * @param country
	 *            设置国家
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
	 * @param headimgurl
	 *            设置头像路径
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
	 * @param privilege
	 *            设置权限
	 */
	public void setPrivilege(String privilege) {
		this.privilege = privilege;
	}
	
	public Long getAddressId() {
		return addressId;
	}

	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}

}