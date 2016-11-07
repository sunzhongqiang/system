/*
 * 
 *  Tuan 创建于 2016-11-07 10:36:33 版权归作者和作者当前组织所有
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
* Tuan: 拼团管理 数据领域模型
* 2016-11-07 10:36:33
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
     * 订单分类：1，一元购；2，拼团
     */
    @Column(name="order_sort")
    private Long orderSort;

    /**
     * 商品图片
     */
    @Column(name="good_img")
    private String goodImg;

    /**
     * 商品描述
     */
    @Column(name="good_des")
    private String goodDes;

    /**
     * 商品编码
     */
    @Column(name="good_code")
    private String goodCode;

    /**
     * 商品金额
     */
    @Column(name="good_price")
    private Double goodPrice;

    /**
     * 订单编码
     */
    @Column(name="order_code")
    private String orderCode;

    /**
     * 用户名
     */
    @Column(name="user_name")
    private String userName;

    /**
     * 团状态：0，全部订单；1，待成团；2，已成团；3，拼团失败
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
	* @return orderSort ：订单分类：1，一元购；2，拼团
	*/
    public Long getOrderSort() {
        return orderSort;
    }
    /** 
    *@param orderSort 设置订单分类：1，一元购；2，拼团 
    */
    public void setOrderSort(Long orderSort) {
        this.orderSort = orderSort;
    }

    /** 
	* @return goodImg ：商品图片
	*/
    public String getGoodImg() {
        return goodImg;
    }
    /** 
    *@param goodImg 设置商品图片 
    */
    public void setGoodImg(String goodImg) {
        this.goodImg = goodImg;
    }

    /** 
	* @return goodDes ：商品描述
	*/
    public String getGoodDes() {
        return goodDes;
    }
    /** 
    *@param goodDes 设置商品描述 
    */
    public void setGoodDes(String goodDes) {
        this.goodDes = goodDes;
    }

    /** 
	* @return goodCode ：商品编码
	*/
    public String getGoodCode() {
        return goodCode;
    }
    /** 
    *@param goodCode 设置商品编码 
    */
    public void setGoodCode(String goodCode) {
        this.goodCode = goodCode;
    }

    /** 
	* @return goodPrice ：商品金额
	*/
    public Double getGoodPrice() {
        return goodPrice;
    }
    /** 
    *@param goodPrice 设置商品金额 
    */
    public void setGoodPrice(Double goodPrice) {
        this.goodPrice = goodPrice;
    }

    /** 
	* @return orderCode ：订单编码
	*/
    public String getOrderCode() {
        return orderCode;
    }
    /** 
    *@param orderCode 设置订单编码 
    */
    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    /** 
	* @return userName ：用户名
	*/
    public String getUserName() {
        return userName;
    }
    /** 
    *@param userName 设置用户名 
    */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /** 
	* @return tuanStatus ：团状态：0，全部订单；1，待成团；2，已成团；3，拼团失败
	*/
    public Long getTuanStatus() {
        return tuanStatus;
    }
    /** 
    *@param tuanStatus 设置团状态：0，全部订单；1，待成团；2，已成团；3，拼团失败 
    */
    public void setTuanStatus(Long tuanStatus) {
        this.tuanStatus = tuanStatus;
    }


}