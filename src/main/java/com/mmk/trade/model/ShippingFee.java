/*
 * 
 *  ShippingFee 创建于 2016-11-26 11:33:41 版权归作者和作者当前组织所有
 */
package com.mmk.trade.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Column;

/**
* ShippingFee: 快递地区运费 数据领域模型
* 2016-11-26 11:33:41
*@author huguangling 胡广玲
*@version 1.0
*/
@Entity
@Table(name="trade_shipping_fee")
public class ShippingFee {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long id;

    /**
     * 配送方式
     */
    @ManyToOne
    @JoinColumn(name="shipping_id")
    private Shipping shipping;

    /**
     * 地区主键
     */
    @Column(name="region_id")
    private Long regionId;

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
	* @return shippingId ：配送方式
	*/
    public Shipping getShipping() {
        return shipping;
    }
    /** 
    *@param shippingId 设置配送方式 
    */
    public void setShipping(Shipping shipping) {
        this.shipping = shipping;
    }

    /** 
	* @return regionId ：地区主键
	*/
    public Long getRegionId() {
        return regionId;
    }
    /** 
    *@param regionId 设置地区主键 
    */
    public void setRegionId(Long regionId) {
        this.regionId = regionId;
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