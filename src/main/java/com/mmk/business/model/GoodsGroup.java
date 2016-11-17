/*
 * 
 *  GoodsGroup 创建于 2016-11-17 11:42:27 版权归作者和作者当前组织所有
 */
package com.mmk.business.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
* GoodsGroup: 商品拼团管理 数据领域模型
* 2016-11-17 11:42:27
*@author 孙中强 sunzhongqiang
*@version 1.0
*/
@Entity
@Table(name="business_goods_group")
public class GoodsGroup {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long id;

    /**
     * 商品主键
     */
    @Column(name="goods_id")
    private Long goodsId;

    /**
     * 拼团数量
     */
    @Column(name="num")
    private Long num;

    /**
     * 拼团价
     */
    @Column(name="group_price")
    private Double groupPrice;

    /**
     * 拼团开始时间
     */
    @Temporal(TemporalType.TIMESTAMP)   
    @Column(name="start_time")
    private Date startTime;

    /**
     * 拼团结束时间
     */
    @Temporal(TemporalType.TIMESTAMP)   
    @Column(name="end_time")
    private Date endTime;


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
	* @return goodsId ：商品主键
	*/
    public Long getGoodsId() {
        return goodsId;
    }
    /** 
    *@param goodsId 设置商品主键 
    */
    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    /** 
	* @return num ：拼团数量
	*/
    public Long getNum() {
        return num;
    }
    /** 
    *@param num 设置拼团数量 
    */
    public void setNum(Long num) {
        this.num = num;
    }

    /** 
	* @return groupPrice ：拼团价
	*/
    public Double getGroupPrice() {
        return groupPrice;
    }
    /** 
    *@param groupPrice 设置拼团价 
    */
    public void setGroupPrice(Double groupPrice) {
        this.groupPrice = groupPrice;
    }

    /** 
	* @return startTime ：拼团开始时间
	*/
    public Date getStartTime() {
        return startTime;
    }
    /** 
    *@param startTime 设置拼团开始时间 
    */
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    /** 
	* @return endTime ：拼团结束时间
	*/
    public Date getEndTime() {
        return endTime;
    }
    /** 
    *@param endTime 设置拼团结束时间 
    */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }


}