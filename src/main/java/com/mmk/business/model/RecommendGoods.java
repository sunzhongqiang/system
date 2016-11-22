/*
 * 
 *  RecommendGoods 创建于 2016-11-14 13:55:42 版权归作者和作者当前组织所有
 */
package com.mmk.business.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;

/**
* RecommendGoods: 商品 位置 关系表 数据领域模型
* 2016-11-14 13:55:42
*@author huguangling 胡广玲
*@version 1.0
*/
@Entity
@Table(name="business_recommend_goods")
public class RecommendGoods {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long id;

    /**
     * 商品id
     */
    @Column(name="goods_id")
    private Long goodsId;

    /**
     * 位置id
     */
    @Column(name="position_id")
    private Long positionId;

    /**
     * 该商品在该位置的排序位置
     */
    @Column(name="sort")
    private Long sort;

    /**
     * 该商品在该位置的排序位置
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
	* @return goodsId ：商品id
	*/
    public Long getGoodsId() {
        return goodsId;
    }
    /** 
    *@param goodsId 设置商品id 
    */
    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
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
	* @return sort ：该商品在该位置的排序位置
	*/
    public Long getSort() {
        return sort;
    }
    /** 
    *@param sort 设置该商品在该位置的排序位置 
    */
    public void setSort(Long sort) {
        this.sort = sort;
    }
    public Long getOrderby() {
		return orderby;
	}
	public void setOrderby(Long orderby) {
		this.orderby = orderby;
	}

}