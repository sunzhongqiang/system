/*
 * 
 *  GoodsGroup 创建于 2016-11-17 11:42:27 版权归作者和作者当前组织所有
 */
package com.mmk.business.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Column;
import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

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
    @NotFound(action=NotFoundAction.IGNORE)
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="goods_id")
    private Goods goods;

    
    /**
     * 拼团数量
     */
    @Column(name="num")
    private Long num;
    
    /**
     * 拼团类型
     */
    @Column(name="type")
    private Long type;

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
     * 持续时间：天
     */
    @Column(name="duration")
    private Long duration;
    
    /**
     * 已经开始的团数量
     */
    @Column(name="group_num")
    private Long groupNum;



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
    public Goods getGoods() {
        return goods;
    }
    /** 
    *@param goodsId 设置商品主键 
    */
    public void setGoods(Goods goods) {
        this.goods = goods;
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

	/**
	 * @return duration ：持续时间：天
	 */
	public Long getDuration() {
		return duration;
	}

	/**
	 * @param duration
	 *            设置持续时间：天
	 */
	public void setDuration(Long duration) {
		this.duration = duration;
	}
	
	
	public Long getType() {
		return type;
	}
	public void setType(Long type) {
		this.type = type;
	}
	public Long getGroupNum() {
		return groupNum;
	}
	public void setGroupNum(Long groupNum) {
		this.groupNum = groupNum;
	}

}