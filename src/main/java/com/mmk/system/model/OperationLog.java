/*
 * 
 *  OperationLog 创建于 2016-10-22 12:17:32 版权归作者和作者当前组织所有
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
 * OperationLog: 系统操作日志 数据领域模型 2016-10-22 12:17:32
 * 
 * @author 孙中强
 * @version 1.0
 */
@Entity
@Table(name = "system_operation_log")
public class OperationLog {
	/**
	 * 日志
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	/**
	 * 用户id
	 */
	@Column(name = "user_id")
	private String userId;

	/**
	 * 用户名
	 */
	@Column(name = "username")
	private String username;

	/**
	 * 用户真实名称
	 */
	@Column(name = "realname")
	private String realname;

	/**
	 * 角色编码
	 */
	@Column(name = "role_code")
	private String roleCode;

	/**
	 * 角色名称
	 */
	@Column(name = "role_name")
	private String roleName;

	/**
	 * 访问资源地址
	 */
	@Column(name = "function_uri")
	private String functionUri;

	/**
	 * 资源名称
	 */
	@Column(name = "function_name")
	private String functionName;

	/**
	 * 访问日期
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "operation_time")
	private Date operationTime;

	/**
	 * 访问状态，成功还是失败
	 */
	@Column(name = "status")
	private String status;

	/**
	 * 调用IP
	 */
	@Column(name = "ip")
	private String ip;

	/**
	 * @return id ：日志
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            设置日志
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return userId ：用户id
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId
	 *            设置用户id
	 */
	public void setUserId(String userId) {
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
	 * @return realname ：用户真实名称
	 */
	public String getRealname() {
		return realname;
	}

	/**
	 * @param realname
	 *            设置用户真实名称
	 */
	public void setRealname(String realname) {
		this.realname = realname;
	}

	/**
	 * @return roleCode ：角色编码
	 */
	public String getRoleCode() {
		return roleCode;
	}

	/**
	 * @param roleCode
	 *            设置角色编码
	 */
	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	/**
	 * @return roleName ：角色名称
	 */
	public String getRoleName() {
		return roleName;
	}

	/**
	 * @param roleName
	 *            设置角色名称
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	/**
	 * @return functionUri ：访问资源地址
	 */
	public String getFunctionUri() {
		return functionUri;
	}

	/**
	 * @param functionUri
	 *            设置访问资源地址
	 */
	public void setFunctionUri(String functionUri) {
		this.functionUri = functionUri;
	}

	/**
	 * @return functionName ：资源名称
	 */
	public String getFunctionName() {
		return functionName;
	}

	/**
	 * @param functionName
	 *            设置资源名称
	 */
	public void setFunctionName(String functionName) {
		this.functionName = functionName;
	}

	/**
	 * @return operationTime ：访问日期
	 */
	public Date getOperationTime() {
		return operationTime;
	}

	/**
	 * @param operationTime
	 *            设置访问日期
	 */
	public void setOperationTime(Date operationTime) {
		this.operationTime = operationTime;
	}

	/**
	 * @return status ：访问状态，成功还是失败
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            设置访问状态，成功还是失败
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return ip ：调用IP
	 */
	public String getIp() {
		return ip;
	}

	/**
	 * @param ip
	 *            设置调用IP
	 */
	public void setIp(String ip) {
		this.ip = ip;
	}

}