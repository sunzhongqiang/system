/*
 * 
 *  Payment 创建于 2016-12-05 14:38:40 版权归作者和作者当前组织所有
 */
package com.mmk.payment.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
* Payment: 支付方式 数据领域模型
* 2016-12-05 14:38:40
*@author 
*@version 1.0
*/
@Entity
@Table(name="pay_payment")
public class Payment {
    /**
     * 支付主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long id;

    /**
     * 支付编码
     */
    @Column(name="code")
    private String code;

    /**
     * 支付名称
     */
    @Column(name="name")
    private String name;

    /**
     * 支付类型：online,offline,bank,cod
     */
    @Column(name="type")
    private String type;

    /**
     * 备注
     */
    @Column(name="remark")
    private String remark;

    /**
     * 排序
     */
    @Column(name="order_sort")
    private Long orderSort;


    /** 
	* @return id ：支付主键
	*/
    public Long getId() {
        return id;
    }
    /** 
    *@param id 设置支付主键 
    */
    public void setId(Long id) {
        this.id = id;
    }

    /** 
	* @return code ：支付编码
	*/
    public String getCode() {
        return code;
    }
    /** 
    *@param code 设置支付编码 
    */
    public void setCode(String code) {
        this.code = code;
    }

    /** 
	* @return name ：支付名称
	*/
    public String getName() {
        return name;
    }
    /** 
    *@param name 设置支付名称 
    */
    public void setName(String name) {
        this.name = name;
    }

    /** 
	* @return type ：支付类型：online,offline,bank,cod
	*/
    public String getType() {
        return type;
    }
    /** 
    *@param type 设置支付类型：online,offline,bank,cod 
    */
    public void setType(String type) {
        this.type = type;
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

    /** 
	* @return orderSort ：排序
	*/
    public Long getOrderSort() {
        return orderSort;
    }
    /** 
    *@param orderSort 设置排序 
    */
    public void setOrderSort(Long orderSort) {
        this.orderSort = orderSort;
    }


}