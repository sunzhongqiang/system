/*
 * 
 *  Role 创建于 2016-10-24 14:26:41 版权归作者和作者当前组织所有
 */
package com.mmk.system.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
* Role: 系统角色 数据领域模型
* 2016-10-24 14:26:41
*@author huguangling 胡广玲
*@version 1.0
*/
@Entity
@Table(name="system_role")
public class Role {
    /**
     * 角色主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long id;

    /**
     * 角色编码
     */
    @Column(name="code")
    private String code;

    /**
     * 角色名称
     */
    @Column(name="name")
    private String name;

    /**
     * 状态：enable启用；disable:禁用
     */
    @Column(name="status")
    private String status;


    /** 
	* @return id ：角色主键
	*/
    public Long getId() {
        return id;
    }
    /** 
    *@param id 设置角色主键 
    */
    public void setId(Long id) {
        this.id = id;
    }

    /** 
	* @return code ：角色编码
	*/
    public String getCode() {
        return code;
    }
    /** 
    *@param code 设置角色编码 
    */
    public void setCode(String code) {
        this.code = code;
    }

    /** 
	* @return name ：角色名称
	*/
    public String getName() {
        return name;
    }
    /** 
    *@param name 设置角色名称 
    */
    public void setName(String name) {
        this.name = name;
    }

    /** 
	* @return status ：状态：enable启用；disable:禁用
	*/
    public String getStatus() {
        return status;
    }
    /** 
    *@param status 设置状态：enable启用；disable:禁用 
    */
    public void setStatus(String status) {
        this.status = status;
    }


}