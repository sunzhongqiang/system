/*
 * 
 *  AdPosition 创建于 2016-11-03 11:37:58 版权归作者和作者当前组织所有
 */
package com.mmk.business.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
* AdPosition: 广告位置 数据领域模型
* 2016-11-03 11:37:58
*@author huguangling 胡广玲
*@version 1.0
*/
@Entity
@Table(name="business_ad_position")
public class AdPosition {
    /**
     * 广告位ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="position_id")
    private Long positionId;

    /**
     * 广告位编码
     */
    @Column(name="position_code")
    private String positionCode;
    
	/**
     * 广告位名称
     */
    @Column(name="position_name")
    private String positionName;

    /**
     * 广告位宽度
     */
    @Column(name="ad_width")
    private Long adWidth;

    /**
     * 广告位高度
     */
    @Column(name="ad_height")
    private Long adHeight;

    /**
     * 广告位描述
     */
    @Column(name="position_desc")
    private String positionDesc;


    /** 
	* @return positionId ：广告位ID
	*/
    public Long getPositionId() {
        return positionId;
    }
    /** 
    *@param positionId 设置广告位ID 
    */
    public void setPositionId(Long positionId) {
        this.positionId = positionId;
    }

    /** 
	* @return positionName ：广告位名称
	*/
    public String getPositionName() {
        return positionName;
    }
    /** 
    *@param positionName 设置广告位名称 
    */
    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    /** 
	* @return adWidth ：广告位宽度
	*/
    public Long getAdWidth() {
        return adWidth;
    }
    /** 
    *@param adWidth 设置广告位宽度 
    */
    public void setAdWidth(Long adWidth) {
        this.adWidth = adWidth;
    }

    /** 
	* @return adHeight ：广告位高度
	*/
    public Long getAdHeight() {
        return adHeight;
    }
    /** 
    *@param adHeight 设置广告位高度 
    */
    public void setAdHeight(Long adHeight) {
        this.adHeight = adHeight;
    }

    /** 
	* @return positionDesc ：广告位描述
	*/
    public String getPositionDesc() {
        return positionDesc;
    }
    /** 
    *@param positionDesc 设置广告位描述 
    */
    public void setPositionDesc(String positionDesc) {
        this.positionDesc = positionDesc;
    }

    public String getPositionCode() {
		return positionCode;
	}
	public void setPositionCode(String positionCode) {
		this.positionCode = positionCode;
	}

}