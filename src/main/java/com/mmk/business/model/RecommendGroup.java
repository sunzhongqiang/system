/*
 * 
 *  RecommendGroup 创建于 2016-11-18 15:33:44 版权归作者和作者当前组织所有
 */
package com.mmk.business.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;

/**
* RecommendGroup: 拼团推荐管理 数据领域模型
* 2016-11-18 15:33:44
*@author huguangling 胡广玲
*@version 1.0
*/
@Entity
@Table(name="business_recommend_group")
public class RecommendGroup {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long id;

    /**
     * 拼团组ID
     */
    @Column(name="good_id")
    private Long goodId;

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
	* @return goodId ：拼团组ID
	*/
    public Long getGoodId() {
        return goodId;
    }
    /** 
    *@param goodId 设置拼团组ID 
    */
    public void setGoodId(Long goodId) {
        this.goodId = goodId;
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