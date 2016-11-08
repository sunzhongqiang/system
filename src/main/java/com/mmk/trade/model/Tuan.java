/*
 * 
 *  Tuan 创建于 2016-11-07 14:59:09 版权归作者和作者当前组织所有
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
* 2016-11-07 14:59:09
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
     * 商品ID
     */
    @Column(name="good_id")
    private Long goodId;

    /**
     * 团编码
     */
    @Column(name="tuan_code")
    private String tuanCode;

    /**
     * 成团人数
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
     * 商品名称
     */
    @Column(name="good_name")
    private String goodName;

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
	* @return goodId ：商品ID
	*/
    public Long getGoodId() {
        return goodId;
    }
    /** 
    *@param goodId 设置商品ID 
    */
    public void setGoodId(Long goodId) {
        this.goodId = goodId;
    }

    /** 
	* @return tuanCode ：团编码
	*/
    public String getTuanCode() {
        return tuanCode;
    }
    /** 
    *@param tuanCode 设置团编码 
    */
    public void setTuanCode(String tuanCode) {
        this.tuanCode = tuanCode;
    }

    /** 
	* @return peopleNum ：成团人数
	*/
    public Long getPeopleNum() {
        return peopleNum;
    }
    /** 
    *@param peopleNum 设置成团人数 
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
	* @return goodName ：商品名称
	*/
    public String getGoodName() {
        return goodName;
    }
    /** 
    *@param goodName 设置商品名称 
    */
    public void setGoodName(String goodName) {
        this.goodName = goodName;
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