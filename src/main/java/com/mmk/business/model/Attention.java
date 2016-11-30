/*
 * 
 *  Attention 创建于 2016-11-30 09:25:29 版权归作者和作者当前组织所有
 */
package com.mmk.business.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;

/**
* Attention: 商品或者团的关注 数据领域模型
* 2016-11-30 09:25:29
*@author huguangling 胡广玲
*@version 1.0
*/
@Entity
@Table(name="business_attention")
public class Attention {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long id;

    /**
     * 团id
     */
    @Column(name="group_id")
    private Long groupId;

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
	* @return groupId ：团id
	*/
    public Long getGroupId() {
        return groupId;
    }
    /** 
    *@param groupId 设置团id 
    */
    public void setGroupId(Long groupId) {
        this.groupId = groupId;
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