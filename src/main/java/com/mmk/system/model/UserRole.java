/*
 * 
 *  UserRole 创建于 2016-10-27 08:21:19 版权归作者和作者当前组织所有
 */
package com.mmk.system.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * UserRole: 系统用户角色 数据领域模型 2016-10-27 08:21:19
 * 
 * @author code
 * @version 1.0
 */
@Entity
@Table(name = "system_user_role")
public class UserRole {
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
	 * 角色主键
	 */
	@Column(name = "role_id")
	private Long roleId;

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
	 * @return roleId ：角色主键
	 */
	public Long getRoleId() {
		return roleId;
	}

	/**
	 * @param roleId
	 *            设置角色主键
	 */
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

}