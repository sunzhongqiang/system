/*
 * 
 *  Favorite 创建于 2016-11-30 09:24:22 版权归作者和作者当前组织所有
 */
package com.mmk.business.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.Column;

/**
* Favorite: 团收藏 数据领域模型
* 2016-11-30 09:24:22
*@author huguangling 胡广玲
*@version 1.0
*/
@Entity
@Table(name="business_favorite")
public class Favorite {
    /**
     * 收藏主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long id;

    /**
     * 团id
     */
    @NotFound(action=NotFoundAction.IGNORE)
    @ManyToOne
    @JoinColumn(name="group_id")
    private GoodsGroup groupGoods;

    /**
     * 商品主键
     */
    @Column(name="goods_id")
    private Long goodsId;

    /**
     * 用户ID
     */
    @Column(name="user_id")
    private Long userId;

    /**
     * openid
     */
    @Column(name="openid")
    private String openid;


    /** 
	* @return id ：收藏主键
	*/
    public Long getId() {
        return id;
    }
    /** 
    *@param id 设置收藏主键 
    */
    public void setId(Long id) {
        this.id = id;
    }

    /** 
	* @return groupId ：团id
	*/
    public GoodsGroup getGroupId() {
        return groupGoods;
    }
    /** 
    *@param groupId 设置团id 
    */
    public void setGroupId(GoodsGroup groupGoods) {
        this.groupGoods = groupGoods;
    }

    /** 
	* @return goodsId ：商品主键
	*/
    public Long getGoodsId() {
        return goodsId;
    }
    /** 
    *@param goodsId 设置商品主键 
    */
    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    /** 
	* @return userId ：用户ID
	*/
    public Long getUserId() {
        return userId;
    }
    /** 
    *@param userId 设置用户ID 
    */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /** 
	* @return openid ：openid
	*/
    public String getOpenid() {
        return openid;
    }
    /** 
    *@param openid 设置openid 
    */
    public void setOpenid(String openid) {
        this.openid = openid;
    }


}