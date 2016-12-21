/*
 * 
 *  LoginLog 创建于 2016-10-22 13:46:30 版权归作者和作者当前组织所有
 */
package com.mmk.system.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * LoginLog: 系统登录日志 数据领域模型 2016-10-22 13:46:30
 * 
 * @author codegenerator
 * @version 1.0
 */
@Entity
@Table(name = "system_login_log")
public class LoginLog {
	/**
	 * 主键
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	/**
	 * 用户主键
	 */
	@Column(name = "user_id")
	private Long userId;

	/**
	 * 用户名
	 */
	@Column(name = "username")
	private String username;

	/**
	 * 真实姓名
	 */
	@Column(name = "realname")
	private String realname;

	/**
	 * 登录时间
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "login_time")
	private Date loginTime;

	/**
	 * 验证结果：成功，失败
	 */
	@Column(name = "status")
	private String status;

	/**
	 * 登录ip
	 */
	@Column(name = "ip")
	private String ip;

	/**
	 * @return id ：主键
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            设置主键
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return userId ：用户主键
	 */
	public Long getUserId() {
		return userId;
	}

	/**
	 * @param userId
	 *            设置用户主键
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
	 * @param username
	 *            设置用户名
	 */
	public void setUsername(String username) {
		this.username = username;
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
	 * @return loginTime ：登录时间
	 */
	public Date getLoginTime() {
		return loginTime;
	}

	/**
	 * @param loginTime
	 *            设置登录时间
	 */
	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}

	/**
	 * @return status ：验证结果：成功，失败
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            设置验证结果：成功，失败
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return ip ：登录ip
	 */
	public String getIp() {
		return ip;
	}

	/**
	 * @param ip
	 *            设置登录ip
	 */
	public void setIp(String ip) {
		this.ip = ip;
	}

}