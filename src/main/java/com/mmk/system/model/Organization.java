/*
 * 
 *  Organization 创建于 2016-10-24 10:09:34 版权归作者和作者当前组织所有
 */
package com.mmk.system.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;

/**
* Organization: 组织机构 数据领域模型
* 2016-10-24 10:09:34
*@author 孙中强 sunzhongqiang
*@version 1.0
*/
@Entity
@Table(name="system_organization")
public class Organization {
    /**
     * 组织主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long id;

    /**
     * 机构名称
     */
    @Column(name="name")
    private String name;

    /**
     * 机构编码
     */
    @Column(name="code")
    private String code;

    /**
     * 父类Id
     */
    @Column(name="parent_id")
    private Long parentId;


    /** 
	* @return id ：组织主键
	*/
    public Long getId() {
        return id;
    }
    /** 
    *@param id 设置组织主键 
    */
    public void setId(Long id) {
        this.id = id;
    }

    /** 
	* @return name ：机构名称
	*/
    public String getName() {
        return name;
    }
    /** 
    *@param name 设置机构名称 
    */
    public void setName(String name) {
        this.name = name;
    }

    /** 
	* @return code ：机构编码
	*/
    public String getCode() {
        return code;
    }
    /** 
    *@param code 设置机构编码 
    */
    public void setCode(String code) {
        this.code = code;
    }

    /** 
	* @return parentId ：父类Id
	*/
    public Long getParentId() {
        return parentId;
    }
    /** 
    *@param parentId 设置父类Id 
    */
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }


}