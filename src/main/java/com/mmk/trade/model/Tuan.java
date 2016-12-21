/*
 * 
 *  Tuan 创建于 2016-11-30 14:06:49 版权归作者和作者当前组织所有
 */
package com.mmk.trade.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.mmk.business.model.WxUser;

/**
* Tuan: 团订单 数据领域模型
* 2016-11-30 14:06:49
*@author 
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
    @Column(name="group_id")
    private Long groupId;

    /**
     * 团长ID
     */
    @NotFound(action=NotFoundAction.IGNORE)
    @ManyToOne
    @JoinColumn(name="commander_id")
    private WxUser commander;

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
     * 已经加入的人数
     */
    @Column(name="join_num")
    private Long joinNum;

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
    @Column(name="goods_img")
    private String goodsImg;

    /**
     * 商品名称
     */
    @Column(name="goods_name")
    private String goodsName;

    /**
     * 商品编码
     */
    @Column(name="goods_code")
    private String goodsCode;

    /**
     * 商品金额
     */
    @Column(name="goods_price")
    private Double goodsPrice;

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
    private String tuanStatus;


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
	* @return groupId ：商品ID
	*/
    public Long getGroupId() {
        return groupId;
    }
    /** 
    *@param groupId 设置商品ID 
    */
    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    /** 
	* @return commander ：团长ID
	*/
    public WxUser getCommander() {
        return commander;
    }
    /** 
    *@param commander 设置团长ID 
    */
    public void setCommander(WxUser commander) {
        this.commander = commander;
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
	* @return joinNum ：已经加入的人数
	*/
    public Long getJoinNum() {
        return joinNum;
    }
    /** 
    *@param joinNum 设置已经加入的人数 
    */
    public void setJoinNum(Long joinNum) {
        this.joinNum = joinNum;
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
	* @return orderSort ：订单分类：0，一元购；1，拼团
	*/
    public Long getOrderSort() {
        return orderSort;
    }
    /** 
    *@param orderSort 设置订单分类：0，一元购；1，拼团 
    */
    public void setOrderSort(Long orderSort) {
        this.orderSort = orderSort;
    }

    /** 
	* @return goodsImg ：商品图片
	*/
    public String getGoodsImg() {
        return goodsImg;
    }
    /** 
    *@param goodsImg 设置商品图片 
    */
    public void setGoodsImg(String goodsImg) {
        this.goodsImg = goodsImg;
    }

    /** 
	* @return goodsName ：商品名称
	*/
    public String getGoodsName() {
        return goodsName;
    }
    /** 
    *@param goodsName 设置商品名称 
    */
    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    /** 
	* @return goodsCode ：商品编码
	*/
    public String getGoodsCode() {
        return goodsCode;
    }
    /** 
    *@param goodsCode 设置商品编码 
    */
    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode;
    }

    /** 
	* @return goodsPrice ：商品金额
	*/
    public Double getGoodsPrice() {
        return goodsPrice;
    }
    /** 
    *@param goodsPrice 设置商品金额 
    */
    public void setGoodsPrice(Double goodsPrice) {
        this.goodsPrice = goodsPrice;
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
    public String getTuanStatus() {
        return tuanStatus;
    }
    /** 
    *@param tuanStatus 设置团状态：0，全部订单；1，待成团；2，已成团；3，拼团失败 
    */
    public void setTuanStatus(String tuanStatus) {
        this.tuanStatus = tuanStatus;
    }


}