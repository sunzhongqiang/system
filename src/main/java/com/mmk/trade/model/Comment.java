/*
 * 
 *  Comment 创建于 2016-11-11 13:31:11 版权归作者和作者当前组织所有
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
* Comment: 评价管理 数据领域模型
* 2016-11-11 13:31:11
*@author huguangling 胡广玲
*@version 1.0
*/
@Entity
@Table(name="trade_comment")
public class Comment {
    /**
     * 评价ID
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
     * 用户名
     */
    @Column(name="user_name")
    private String userName;

    /**
     * 评论内容
     */
    @Column(name="content")
    private String content;

    /**
     * 评论时间
     */
    @Temporal(TemporalType.TIMESTAMP)   
    @Column(name="content_time")
    private Date contentTime;

    /**
     * 追加评价
     */
    @Column(name="add_content")
    private String addContent;

    /**
     * 评价回复
     */
    @Column(name="reply")
    private String reply;

    /**
     * 商品图片
     */
    @Column(name="good_img")
    private String goodImg;

    public String getGoodImg() {
		return goodImg;
	}
	public void setGoodImg(String goodImg) {
		this.goodImg = goodImg;
	}
	/** 
	* @return id ：评价ID
	*/
    public Long getId() {
        return id;
    }
    /** 
    *@param id 设置评价ID 
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
	* @return content ：评论内容
	*/
    public String getContent() {
        return content;
    }
    /** 
    *@param content 设置评论内容 
    */
    public void setContent(String content) {
        this.content = content;
    }

    /** 
	* @return contentTime ：评论时间
	*/
    public Date getContentTime() {
        return contentTime;
    }
    /** 
    *@param contentTime 设置评论时间 
    */
    public void setContentTime(Date contentTime) {
        this.contentTime = contentTime;
    }

    /** 
	* @return addContent ：追加评价
	*/
    public String getAddContent() {
        return addContent;
    }
    /** 
    *@param addContent 设置追加评价 
    */
    public void setAddContent(String addContent) {
        this.addContent = addContent;
    }

    /** 
	* @return reply ：评价回复
	*/
    public String getReply() {
        return reply;
    }
    /** 
    *@param reply 设置评价回复 
    */
    public void setReply(String reply) {
        this.reply = reply;
    }


}