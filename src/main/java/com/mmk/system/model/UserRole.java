/*
 * 
 *  UserRole 创建于 2016-10-13 16:53:44 版权归作者和作者当前组织所有
 */
package com.mmk.system.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;

/**
* UserRole: 系统用户角色 数据领域模型
* 2016-10-13 16:53:44
*@author 孙中强 sunzhongqiang
*@version 1.0
*/
@Entity
@Table(name="system_user_role")
public class UserRole {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long id;

    /**
     * 用户主键
     */
    @Column(name="user_id")
    private Long userId;

    /**
     * 角色编码
     */
    @Column(name="role_code")
    private String roleCode;


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
	* @return userId ：用户主键
	*/
    public Long getUserId() {
        return userId;
    }
    /** 
    *@param userId 设置用户主键 
    */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /** 
	* @return roleCode ：角色编码
	*/
    public String getRoleCode() {
        return roleCode;
    }
    /** 
    *@param roleCode 设置角色编码 
    */
    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }


}