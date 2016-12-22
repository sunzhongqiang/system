/*
 * 
 *  WxAppConfig 创建于 2016-12-22 08:39:57 版权归作者和作者当前组织所有
 */
package com.mmk.weixin.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;

/**
* WxAppConfig: 微信开发者账号配置 数据领域模型
* 2016-12-22 08:39:57
*@author 孙中强 sunzhongqiang
*@version 1.0
*/
@Entity
@Table(name="wx_app_config")
public class WxAppConfig {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id",columnDefinition="COMMENT '主键'")
    private Long id;

    /**
     * 配置名称
     */
    @Column(name="code",columnDefinition="COMMENT '配置名称'")
    private String code;

    /**
     * 配置值
     */
    @Column(name="value",columnDefinition="COMMENT '配置值'")
    private String value;

    /**
     * 备注
     */
    @Column(name="remark",columnDefinition="COMMENT '备注'")
    private String remark;


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
	* @return code ：配置名称
	*/
    public String getCode() {
        return code;
    }
    /** 
    *@param code 设置配置名称 
    */
    public void setCode(String code) {
        this.code = code;
    }

    /** 
	* @return value ：配置值
	*/
    public String getValue() {
        return value;
    }
    /** 
    *@param value 设置配置值 
    */
    public void setValue(String value) {
        this.value = value;
    }

    /** 
	* @return remark ：备注
	*/
    public String getRemark() {
        return remark;
    }
    /** 
    *@param remark 设置备注 
    */
    public void setRemark(String remark) {
        this.remark = remark;
    }


}