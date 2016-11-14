/*
 * 
 *  RefundAction 创建于 2016-11-14 13:32:00 版权归作者和作者当前组织所有
 */
package com.mmk.refund.model;

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
* RefundAction: 操作表 数据领域模型
* 2016-11-14 13:32:00
*@author huguangling 胡广玲
*@version 1.0
*/
@Entity
@Table(name="trade_refund_action")
public class RefundAction {
    /**
     * ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long id;

    /**
     * 退款ID
     */
    @Column(name="refund_id")
    private Long refundId;

    /**
     * 操作状态
     */
    @Column(name="refund_status")
    private String refundStatus;

    /**
     * 操作人
     */
    @Column(name="username")
    private String username;

    /**
     * 操作时间
     */
    @Temporal(TemporalType.TIMESTAMP)   
    @Column(name="create_time")
    private Date createTime;

    /**
     * 备注
     */
    @Column(name="remark")
    private String remark;


    /** 
	* @return id ：ID
	*/
    public Long getId() {
        return id;
    }
    /** 
    *@param id 设置ID 
    */
    public void setId(Long id) {
        this.id = id;
    }

    /** 
	* @return refundId ：退款ID
	*/
    public Long getRefundId() {
        return refundId;
    }
    /** 
    *@param refundId 设置退款ID 
    */
    public void setRefundId(Long refundId) {
        this.refundId = refundId;
    }

    /** 
	* @return refundStatus ：操作状态
	*/
    public String getRefundStatus() {
        return refundStatus;
    }
    /** 
    *@param refundStatus 设置操作状态 
    */
    public void setRefundStatus(String refundStatus) {
        this.refundStatus = refundStatus;
    }

    /** 
	* @return username ：操作人
	*/
    public String getUsername() {
        return username;
    }
    /** 
    *@param username 设置操作人 
    */
    public void setUsername(String username) {
        this.username = username;
    }

    /** 
	* @return createTime ：操作时间
	*/
    public Date getCreateTime() {
        return createTime;
    }
    /** 
    *@param createTime 设置操作时间 
    */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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


}