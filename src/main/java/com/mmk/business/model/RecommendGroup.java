/*
 * 
 *  RecommendGroup 创建于 2016-11-18 15:08:15 版权归作者和作者当前组织所有
 */
package com.mmk.business.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;

/**
* RecommendGroup: 拼团管理 数据领域模型
* 2016-11-18 15:08:15
*@author huguangling 胡广玲
*@version 1.0
*/
@Entity
@Table(name="business_recommend_group")
public class RecommendGroup {
    /**
     * 主键
     */
    @Column(name="id")
    private Long id;

    /**
     * 拼团组ID
     */
    @Column(name="group_id")
    private Long groupId;

    /**
     * 位置id
     */
    @Column(name="position_id")
    private Long positionId;

    /**
     * 排序
     */
    @Column(name="orderby")
    private Long orderby;


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
	* @return groupId ：拼团组ID
	*/
    public Long getGroupId() {
        return groupId;
    }
    /** 
    *@param groupId 设置拼团组ID 
    */
    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    /** 
	* @return positionId ：位置id
	*/
    public Long getPositionId() {
        return positionId;
    }
    /** 
    *@param positionId 设置位置id 
    */
    public void setPositionId(Long positionId) {
        this.positionId = positionId;
    }

    /** 
	* @return orderby ：排序
	*/
    public Long getOrderby() {
        return orderby;
    }
    /** 
    *@param orderby 设置排序 
    */
    public void setOrderby(Long orderby) {
        this.orderby = orderby;
    }


}