/*
 * 
 *  Ad 创建于 2016-11-03 11:37:27 版权归作者和作者当前组织所有
 */
package com.mmk.business.model;

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
* Ad: 广告 数据领域模型
* 2016-11-03 11:37:27
*@author huguangling 胡广玲
*@version 1.0
*/
@Entity
@Table(name="business_ad")
public class Ad {
    /**
     * 广告ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ad_id")
    private Long adId;

    /**
     * 位置ID
     */
    @Column(name="position_id")
    private Long positionId;

    /**
     * 广告名称
     */
    @Column(name="ad_name")
    private String adName;

    /**
     * 广告图片
     */
    @Column(name="ad_img")
    private String adImg;
    
	/**
     * 广告链接
     */
    @Column(name="ad_link")
    private String adLink;

    /**
     * 广告编码
     */
    @Column(name="ad_code")
    private String adCode;

    /**
     * 开始时间
     */
    @Temporal(TemporalType.TIMESTAMP)   
    @Column(name="start_time")
    private Date startTime;

    /**
     * 结束时间
     */
    @Temporal(TemporalType.TIMESTAMP)   
    @Column(name="end_time")
    private Date endTime;

    /**
     * 点击次数
     */
    @Column(name="click_count")
    private Long clickCount;

    /**
     * 描述
     */
    @Column(name="description")
    private String description;


    /** 
	* @return adId ：广告ID
	*/
    public Long getAdId() {
        return adId;
    }
    /** 
    *@param adId 设置广告ID 
    */
    public void setAdId(Long adId) {
        this.adId = adId;
    }

    /** 
	* @return positionId ：位置ID
	*/
    public Long getPositionId() {
        return positionId;
    }
    /** 
    *@param positionId 设置位置ID 
    */
    public void setPositionId(Long positionId) {
        this.positionId = positionId;
    }

    /** 
	* @return adName ：广告名称
	*/
    public String getAdName() {
        return adName;
    }
    /** 
    *@param adName 设置广告名称 
    */
    public void setAdName(String adName) {
        this.adName = adName;
    }

    /** 
	* @return adLink ：
	*/
    public String getAdLink() {
        return adLink;
    }
    /** 
    *@param adLink 设置 
    */
    public void setAdLink(String adLink) {
        this.adLink = adLink;
    }

    /** 
	* @return adCode ：广告编码
	*/
    public String getAdCode() {
        return adCode;
    }
    /** 
    *@param adCode 设置广告编码 
    */
    public void setAdCode(String adCode) {
        this.adCode = adCode;
    }

    /** 
	* @return startTime ：开始时间
	*/
    public Date getStartTime() {
        return startTime;
    }
    /** 
    *@param startTime 设置开始时间 
    */
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    /** 
	* @return endTime ：结束时间
	*/
    public Date getEndTime() {
        return endTime;
    }
    /** 
    *@param endTime 设置结束时间 
    */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    /** 
	* @return clickCount ：点击次数
	*/
    public Long getClickCount() {
        return clickCount;
    }
    /** 
    *@param clickCount 设置点击次数 
    */
    public void setClickCount(Long clickCount) {
        this.clickCount = clickCount;
    }

    /** 
	* @return description ：描述
	*/
    public String getDescription() {
        return description;
    }
    /** 
    *@param description 设置描述 
    */
    public void setDescription(String description) {
        this.description = description;
    }


    public String getAdImg() {
		return adImg;
	}
	public void setAdImg(String adImg) {
		this.adImg = adImg;
	}
}