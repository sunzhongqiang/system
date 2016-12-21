/*
 * 
 *  Region 创建于 2016-11-14 13:31:38 版权归作者和作者当前组织所有
 */
package com.mmk.system.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
* Region: 区域管理 数据领域模型
* 2016-11-14 13:31:38
*@author huguangling 胡广玲
*@version 1.0
*/
@Entity
@Table(name="system_region")
public class Region {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="region_id")
    private Long regionId;

    /**
     * 所属区域id
     */
    @Column(name="parent_id")
    private Long parentId;

    /**
     * 区域名称
     */
    @Column(name="region_name")
    private String regionName;
    
    /**
     * 地区类型
     */
    @Column(name="region_type")
    private Long regionType;

    /**
     * 是否显示1-显示
     */
    @Column(name="is_display")
    private Long isDisplay;

    /**
     * 所属大区：华东、华北等，存汉字，总共就这些个区域
     */
    @Column(name="belongs_bigregion")
    private String belongsBigregion;

    /**
     * 区域全地址
     */
    @Column(name="full_region_name")
    private String fullRegionName;
    
    @Transient
    private String state;


    /** 
	* @return regionId ：主键
	*/
    public Long getRegionId() {
        return regionId;
    }
    /** 
    *@param regionId 设置主键 
    */
    public void setRegionId(Long regionId) {
        this.regionId = regionId;
    }

    /** 
	* @return parentId ：所属区域id
	*/
    public Long getParentId() {
        return parentId;
    }
    /** 
    *@param parentId 设置所属区域id 
    */
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    /** 
	* @return regionName ：区域名称
	*/
    public String getRegionName() {
        return regionName;
    }
    /** 
    *@param regionName 设置区域名称 
    */
    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    /** 
	* @return isDisplay ：是否显示1-显示
	*/
    public Long getIsDisplay() {
        return isDisplay;
    }
    /** 
    *@param isDisplay 设置是否显示1-显示 
    */
    public void setIsDisplay(Long isDisplay) {
        this.isDisplay = isDisplay;
    }

    /** 
	* @return belongsBigregion ：所属大区：华东、华北等，存汉字，总共就这些个区域
	*/
    public String getBelongsBigregion() {
        return belongsBigregion;
    }
    /** 
    *@param belongsBigregion 设置所属大区：华东、华北等，存汉字，总共就这些个区域 
    */
    public void setBelongsBigregion(String belongsBigregion) {
        this.belongsBigregion = belongsBigregion;
    }

    /** 
	* @return fullRegionName ：区域全地址
	*/
    public String getFullRegionName() {
        return fullRegionName;
    }
    /** 
    *@param fullRegionName 设置区域全地址 
    */
    public void setFullRegionName(String fullRegionName) {
        this.fullRegionName = fullRegionName;
    }
	public String getState() {
		if(regionType==null||regionType!=3){
			return "closed";
		}else{
			return null;
		}
	}
	public void setState(String state) {
		this.state = state;
	}
	public Long getRegionType() {
		return regionType;
	}
	public void setRegionType(Long regionType) {
		this.regionType = regionType;
	}


}