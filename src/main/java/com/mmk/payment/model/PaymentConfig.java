/*
 * 
 *  PaymentConfig 创建于 2016-12-05 11:46:36 版权归作者和作者当前组织所有
 */
package com.mmk.payment.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;

/**
* PaymentConfig: 支付配置参数 数据领域模型
* 2016-12-05 11:46:36
*@author 孙中强 sunzhongqiang
*@version 1.0
*/
@Entity
@Table(name="pay_payment_config")
public class PaymentConfig {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long id;

    /**
     * 支付主键
     */
    @Column(name="payment_id")
    private Long paymentId;

    /**
     * 参数名
     */
    @Column(name="code")
    private String code;

    /**
     * 参数值
     */
    @Column(name="value")
    private String value;

    /**
     * 参数说明
     */
    @Column(name="remark")
    private String remark;


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
	* @return paymentId ：支付主键
	*/
    public Long getPaymentId() {
        return paymentId;
    }
    /** 
    *@param paymentId 设置支付主键 
    */
    public void setPaymentId(Long paymentId) {
        this.paymentId = paymentId;
    }

    /** 
	* @return code ：参数名
	*/
    public String getCode() {
        return code;
    }
    /** 
    *@param code 设置参数名 
    */
    public void setCode(String code) {
        this.code = code;
    }

    /** 
	* @return value ：参数值
	*/
    public String getValue() {
        return value;
    }
    /** 
    *@param value 设置参数值 
    */
    public void setValue(String value) {
        this.value = value;
    }

    /** 
	* @return remark ：参数说明
	*/
    public String getRemark() {
        return remark;
    }
    /** 
    *@param remark 设置参数说明 
    */
    public void setRemark(String remark) {
        this.remark = remark;
    }


}