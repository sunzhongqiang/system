/*
 * 
 *  User 创建于 2016-10-12 11:54:22 版权归作者和作者当前组织所有
 */
package com.mmk.system.model;

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

/**
 * User: 系统用户 数据领域模型 2016-10-12 11:54:22
 * 
 * @author sunzhongqiang 孙中强
 * @version 1.0
 */
@Entity
@Table(name = "system_user")
public class User {
	/**
	 * 主键
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	/**
	 * 部门主键
	 */
	@NotFound(action=NotFoundAction.IGNORE)
	@ManyToOne
	@JoinColumn(name = "organization_id")
	private Organization organization;

	/**
	 * 用户名
	 */
	@Column(name = "username")
	private String username;

	/**
	 * 密码
	 */
	@Column(name = "password")
	private String password;

	/**
	 * 用户显示昵称
	 */
	@Column(name = "realname")
	private String realname;

	/**
	 * 状态：enable启用；disable:禁用
	 */
	@Column(name = "status")
	private String status;

	/**
	 * 描述
	 */
	@Column(name = "description")
	private String description;

	/**
	 * 创建时间
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_time")
	private Date createTime;

	/**
	 * 修改时间
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "modified_time")
	private Date modifiedTime;

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
	 * @return organization ：部门主键
	 */
	public Organization getOrganization() {
		return organization;
	}

	/**
	 * @param organization
	 *            设置部门主键
	 */
	public void setOrganization(Organization organization) {
		this.organization = organization;
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
	 * @return password ：密码
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            设置密码
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return realname ：用户显示昵称
	 */
	public String getRealname() {
		return realname;
	}

	/**
	 * @param realname
	 *            设置用户显示昵称
	 */
	public void setRealname(String realname) {
		this.realname = realname;
	}

	/**
	 * @return status ：状态：enable启用；disable:禁用
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            设置状态：enable启用；disable:禁用
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return description ：描述
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            设置描述
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return createTime ：创建时间
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * @param createTime
	 *            设置创建时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * @return modifiedTime ：修改时间
	 */
	public Date getModifiedTime() {
		return modifiedTime;
	}

	/**
	 * @param modifiedTime
	 *            设置修改时间
	 */
	public void setModifiedTime(Date modifiedTime) {
		this.modifiedTime = modifiedTime;
	}
	
}