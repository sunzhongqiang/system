/*
 * 
 *  Privilege 创建于 2016-10-25 09:35:10 版权归作者和作者当前组织所有
 */
package com.mmk.system.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
* Privilege: 系统权限表 数据领域模型
* 2016-10-25 09:35:10
*@author 
*@version 1.0
*/
@Entity
@Table(name="system_privilege")
public class Privilege {
    /**
     * 权限主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long id;

    /**
     * 角色编码
     */
    @Column(name="role_id")
    private Long roleId;

    /**
     * 功能资源地址
     */
    @Column(name="function_id")
    private Long functionId;

    /**
     * 功能资源地址
     */
    @Column(name="function_uri")
    private String functionUri;
    
    /** 
	* @return id ：权限主键
	*/
    public Long getId() {
        return id;
    }
    /** 
    *@param id 设置权限主键 
    */
    public void setId(Long id) {
        this.id = id;
    }

    /** 
	* @return roleId ：角色编码
	*/
    public Long getRoleId() {
        return roleId;
    }
    /** 
    *@param roleId 设置角色编码 
    */
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    /** 
	* @return functionId ：功能资源地址
	*/
    public Long getFunctionId() {
        return functionId;
    }
    /** 
    *@param functionUri 设置功能资源地址 
    */
    public void setFunctionId(Long functionId) {
        this.functionId = functionId;
    }
    /** 
    *@param functionUri 设置功能资源地址 
    */
    public void setFunctionUri(String functionUri) {
        this.functionUri = functionUri;
    }

    /** 
	* @return functionId ：功能资源地址
	*/
    public String getFunctionUri() {
        return functionUri;
    }
}