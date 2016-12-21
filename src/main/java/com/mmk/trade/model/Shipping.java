/*
 * 
 *  Shipping 创建于 2016-11-10 09:13:33 版权归作者和作者当前组织所有
 */
package com.mmk.trade.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Shipping: 物流管理 数据领域模型 2016-11-10 09:13:33
 * 
 * @author huguangling 胡广玲
 * @version 1.0
 */
@Entity
@Table(name = "trade_shipping")
public class Shipping {
	/**
	 * 主键
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	/**
	 * 配送方式名称
	 */
	@Column(name = "shipping_name")
	private String shippingName;

	/**
	 * 是否可用:1，是；2，否
	 */
	@Column(name = "enabled")
	private Long enabled;

	/**
	 * 最后更新时间
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "last_update_time")
	private Date lastUpdateTime;

	
    /**
     * 首重
     */
    @Column(name="init_start")
    private Long initStart;

    /**
     * 首费
     */
    @Column(name="init_fee")
    private Double initFee;

    /**
     * 续重
     */
    @Column(name="add_start")
    private Long addStart;

    /**
     * 续费
     */
    @Column(name="add_fee")
    private Double addFee;


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
	* @return shippingName ：配送方式名称
	*/
    public String getShippingName() {
        return shippingName;
    }
    /** 
    *@param shippingName 设置配送方式名称 
    */
    public void setShippingName(String shippingName) {
        this.shippingName = shippingName;
    }

    /** 
	* @return enabled ：是否可用:1，是；2，否
	*/
    public Long getEnabled() {
        return enabled;
    }
    /** 
    *@param enabled 设置是否可用:1，是；2，否 
    */
    public void setEnabled(Long enabled) {
        this.enabled = enabled;
    }

    /** 
	* @return lastUpdateTime ：最后更新时间
	*/
    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }
    /** 
    *@param lastUpdateTime 设置最后更新时间 
    */
    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    /** 
	* @return initStart ：首重
	*/
    public Long getInitStart() {
        return initStart;
    }
    /** 
    *@param initStart 设置首重 
    */
    public void setInitStart(Long initStart) {
        this.initStart = initStart;
    }

    /** 
	* @return initFee ：首费
	*/
    public Double getInitFee() {
        return initFee;
    }
    /** 
    *@param initFee 设置首费 
    */
    public void setInitFee(Double initFee) {
        this.initFee = initFee;
    }

    /** 
	* @return addStart ：续重
	*/
    public Long getAddStart() {
        return addStart;
    }
    /** 
    *@param addStart 设置续重 
    */
    public void setAddStart(Long addStart) {
        this.addStart = addStart;
    }

    /** 
	* @return addFee ：续费
	*/
    public Double getAddFee() {
        return addFee;
    }
    /** 
    *@param addFee 设置续费 
    */
    public void setAddFee(Double addFee) {
        this.addFee = addFee;
    }



}