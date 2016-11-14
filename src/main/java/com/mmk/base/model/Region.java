package com.mmk.base.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
*@Title: Region
*@Description: 行政区域管理 数据领域模型
*@author code generator
*@version 1.0
*@date 2016-05-23 14:56:50
*/
@Entity
@Table(name = "ecs_region")
public class Region {
    /**
     * 主键
     */
    @Id
    @Column(name="region_id",length=5)
    private Long regionId;

    /**
     * 所属区域id
     */
    @Column(name="parent_id" ,length=5)
    private Long parentId;

    /**
     * 区域名称
     */
    @Column(name="region_name" ,length=120)
    private String regionName;

    /**
     * 区域级别货类型
     */
    @Column(name="region_type" ,length=3)
    private Long regionType;

    /**
     * 代理id?
     */
    @Column(name="agency_id" ,length=5)
    private Long agencyId;

    /**
     * hot_city
     */
    @Column(name="hot_city" ,length=10)
    private Long hotCity;

    /**
     * 是否显示1-显示
     */
    @Column(name="is_display" ,length=10)
    private Long isDisplay;

    /**
     * check_num
     */
    @Column(name="check_num" ,length=10)
    private Long checkNum;

    /**
     * 所属大区：华东、华北等，存汉字，总共就这些个区域
     */
    @Column(name="belongs_bigregion" ,length=20)
    private String belongsBigregion;

    /**
     * 区域全称
     */
    @Column(name="full_region_name")
    private String fullRegionName;

    /** 
	* @return regionId ：主键
	*/
    public Long getRegionId() {
        return regionId;
    }
    /** 
    * @param regionId 设置主键 
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
    * @param parentId 设置所属区域id 
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
    * @param regionName 设置区域名称 
    */
    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }
    /** 
	* @return regionType ：区域级别货类型
	*/
    public Long getRegionType() {
        return regionType;
    }
    /** 
    * @param regionType 设置区域级别货类型 
    */
    public void setRegionType(Long regionType) {
        this.regionType = regionType;
    }
    /** 
	* @return agencyId ：代理id?
	*/
    public Long getAgencyId() {
        return agencyId;
    }
    /** 
    * @param agencyId 设置代理id? 
    */
    public void setAgencyId(Long agencyId) {
        this.agencyId = agencyId;
    }
    /** 
	* @return hotCity ：hot_city
	*/
    public Long getHotCity() {
        return hotCity;
    }
    /** 
    * @param hotCity 设置hot_city 
    */
    public void setHotCity(Long hotCity) {
        this.hotCity = hotCity;
    }
    /** 
	* @return isDisplay ：是否显示1-显示
	*/
    public Long getIsDisplay() {
        return isDisplay;
    }
    /** 
    * @param isDisplay 设置是否显示1-显示 
    */
    public void setIsDisplay(Long isDisplay) {
        this.isDisplay = isDisplay;
    }
    /** 
	* @return checkNum ：check_num
	*/
    public Long getCheckNum() {
        return checkNum;
    }
    /** 
    * @param checkNum 设置check_num 
    */
    public void setCheckNum(Long checkNum) {
        this.checkNum = checkNum;
    }
    /** 
	* @return belongsBigregion ：所属大区：华东、华北等，存汉字，总共就这些个区域
	*/
    public String getBelongsBigregion() {
        return belongsBigregion;
    }
    /** 
    * @param belongsBigregion 设置所属大区：华东、华北等，存汉字，总共就这些个区域 
    */
    public void setBelongsBigregion(String belongsBigregion) {
        this.belongsBigregion = belongsBigregion;
    }
	public String getFullRegionName() {
		return fullRegionName;
	}
	public void setFullRegionName(String fullRegionName) {
		this.fullRegionName = fullRegionName;
	}
	   
}