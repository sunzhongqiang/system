/*
 * 
 *  Tuan 创建于 2016-11-05 13:24:20 版权归作者和作者当前组织所有
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
* Tuan: 团管理 数据领域模型
* 2016-11-05 13:24:20
*@author huguangling 胡广玲
*@version 1.0
*/
@Entity
@Table(name="trade_tuan")
public class Tuan {
    /**
     * 团ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long id;

    /**
     * 订单ID
     */
    @Column(name="order_id")
    private Long orderId;

    /**
     * 人数
     */
    @Column(name="people_num")
    private Long peopleNum;

    /**
     * 团开始时间
     */
    @Temporal(TemporalType.TIMESTAMP)   
    @Column(name="tuan_start_date")
    private Date tuanStartDate;

    /**
     * 团结束时间
     */
    @Temporal(TemporalType.TIMESTAMP)   
    @Column(name="tuan_end_date")
    private Date tuanEndDate;

    /**
     * 团状态
     */
    @Column(name="tuan_status")
    private Long tuanStatus;


    /** 
	* @return id ：团ID
	*/
    public Long getId() {
        return id;
    }
    /** 
    *@param id 设置团ID 
    */
    public void setId(Long id) {
        this.id = id;
    }

    /** 
	* @return orderId ：订单ID
	*/
    public Long getOrderId() {
        return orderId;
    }
    /** 
    *@param orderId 设置订单ID 
    */
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    /** 
	* @return peopleNum ：人数
	*/
    public Long getPeopleNum() {
        return peopleNum;
    }
    /** 
    *@param peopleNum 设置人数 
    */
    public void setPeopleNum(Long peopleNum) {
        this.peopleNum = peopleNum;
    }

    /** 
	* @return tuanStartDate ：团开始时间
	*/
    public Date getTuanStartDate() {
        return tuanStartDate;
    }
    /** 
    *@param tuanStartDate 设置团开始时间 
    */
    public void setTuanStartDate(Date tuanStartDate) {
        this.tuanStartDate = tuanStartDate;
    }

    /** 
	* @return tuanEndDate ：团结束时间
	*/
    public Date getTuanEndDate() {
        return tuanEndDate;
    }
    /** 
    *@param tuanEndDate 设置团结束时间 
    */
    public void setTuanEndDate(Date tuanEndDate) {
        this.tuanEndDate = tuanEndDate;
    }

    /** 
	* @return tuanStatus ：团状态
	*/
    public Long getTuanStatus() {
        return tuanStatus;
    }
    /** 
    *@param tuanStatus 设置团状态 
    */
    public void setTuanStatus(Long tuanStatus) {
        this.tuanStatus = tuanStatus;
    }


}