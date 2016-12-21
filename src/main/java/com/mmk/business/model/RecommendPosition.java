/*
 * 
 *  RecommendPosition 创建于 2016-11-14 13:56:04 版权归作者和作者当前组织所有
 */
package com.mmk.business.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
* RecommendPosition: 位置表 数据领域模型
* 2016-11-14 13:56:04
*@author huguangling 胡广玲
*@version 1.0
*/
@Entity
@Table(name="business_recommend_position")
public class RecommendPosition {
    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long id;

    /**
     * 位置名称
     */
    @Column(name="position_name")
    private String positionName;

    /**
     * 位置编码
     */
    @Column(name="code")
    private String code;


    /** 
	* @return id ：id
	*/
    public Long getId() {
        return id;
    }
    /** 
    *@param id 设置id 
    */
    public void setId(Long id) {
        this.id = id;
    }

    /** 
	* @return positionName ：位置名称
	*/
    public String getPositionName() {
        return positionName;
    }
    /** 
    *@param positionName 设置位置名称 
    */
    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    /** 
	* @return code ：位置编码
	*/
    public String getCode() {
        return code;
    }
    /** 
    *@param code 设置位置编码 
    */
    public void setCode(String code) {
        this.code = code;
    }


}