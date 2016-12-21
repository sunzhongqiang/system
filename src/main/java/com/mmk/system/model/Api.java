/*
 * 
 *  Api 创建于 2016-11-15 10:01:04 版权归作者和作者当前组织所有
 */
package com.mmk.system.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
* Api: 系统API 数据领域模型
* 2016-11-15 10:01:04
*@author 
*@version 1.0
*/
@Entity
@Table(name="system_api")
public class Api {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long id;

    /**
     * API组
     */
    @Column(name="api_group")
    private String apiGroup;

    /**
     * API名称
     */
    @Column(name="name")
    private String name;

    /**
     * 接口说明
     */
    @Column(name="description")
    private String description;

    /**
     * 地址
     */
    @Column(name="uri")
    private String uri;

    /**
     * 参数
     */
    @Column(name="params")
    private String params;

    /**
     * 返回值
     */
    @Column(name="return_values")
    private String returnValues;


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
	* @return apiGroup ：API组
	*/
    public String getApiGroup() {
        return apiGroup;
    }
    /** 
    *@param apiGroup 设置API组 
    */
    public void setApiGroup(String apiGroup) {
        this.apiGroup = apiGroup;
    }

    /** 
	* @return name ：API名称
	*/
    public String getName() {
        return name;
    }
    /** 
    *@param name 设置API名称 
    */
    public void setName(String name) {
        this.name = name;
    }

    /** 
	* @return description ：接口说明
	*/
    public String getDescription() {
        return description;
    }
    /** 
    *@param description 设置接口说明 
    */
    public void setDescription(String description) {
        this.description = description;
    }

    /** 
	* @return uri ：地址
	*/
    public String getUri() {
        return uri;
    }
    /** 
    *@param uri 设置地址 
    */
    public void setUri(String uri) {
        this.uri = uri;
    }

    /** 
	* @return params ：参数
	*/
    public String getParams() {
        return params;
    }
    /** 
    *@param params 设置参数 
    */
    public void setParams(String params) {
        this.params = params;
    }

    /** 
	* @return returnValues ：返回值
	*/
    public String getReturnValues() {
        return returnValues;
    }
    /** 
    *@param returnValues 设置返回值 
    */
    public void setReturnValues(String returnValues) {
        this.returnValues = returnValues;
    }


}