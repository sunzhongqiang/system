/*
 * 
 *  Shipping 创建于 2016-11-10 09:13:33 版权归作者和作者当前组织所有
 */
package com.mmk.trade.model;

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
* Shipping: 物流管理 数据领域模型
* 2016-11-10 09:13:33
*@author huguangling 胡广玲
*@version 1.0
*/
@Entity
@Table(name="trade_shipping")
public class Shipping {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long id;

    /**
     * 配送方式名称
     */
    @Column(name="shipping_name")
    private String shippingName;

    /**
     * 是否可用:1，是；2，否
     */
    @Column(name="enabled")
    private Long enabled;

    /**
     * 最后更新时间
     */
    @Temporal(TemporalType.TIMESTAMP)   
    @Column(name="last_update_time")
    private Date lastUpdateTime;


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


}