/*
 * 
 *  Function 创建于 2016-11-30 13:49:33 版权归作者和作者当前组织所有
 */
package com.mmk.system.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
* Function: 系统功能 数据领域模型
* 2016-11-30 13:49:33
*@author 
*@version 1.0
*/
@Entity
@Table(name="system_function")
public class Function {
    /**
     * 功能主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long id;

    /**
     * 统一资源标识符
     */
    @Column(name="uri")
    private String uri;

    /**
     * 资源名称
     */
    @Column(name="name")
    private String name;

    /**
     * 图标样式
     */
    @Column(name="icon_cls")
    private String iconCls;
    
    /**
     * closed:关闭，open:打开
     */
    @Column(name="state")
    private String state;

    /**
     * 资源类型：function:功能;menu:菜单;module:模块;system:系统;一个系统有多个模块，一个模块包含多个功能
     */
    @Column(name="type")
    private String type;

    /**
     * 父类
     */
    @Column(name="parent_id")
    private Long parentId;

    /**
     * 描述
     */
    @Column(name="description")
    private String description;

    /**
     * 排序字段
     */
    @Column(name="sort")
    private Long sort;


    /** 
	* @return id ：功能主键
	*/
    public Long getId() {
        return id;
    }
    /** 
    *@param id 设置功能主键 
    */
    public void setId(Long id) {
        this.id = id;
    }

    /** 
	* @return uri ：统一资源标识符
	*/
    public String getUri() {
        return uri;
    }
    /** 
    *@param uri 设置统一资源标识符 
    */
    public void setUri(String uri) {
        this.uri = uri;
    }

    /** 
	* @return name ：资源名称
	*/
    public String getName() {
        return name;
    }
    /** 
    *@param name 设置资源名称 
    */
    public void setName(String name) {
        this.name = name;
    }

    /** 
	* @return iconCls ：图标样式
	*/
    public String getIconCls() {
        return iconCls;
    }
    /** 
    *@param iconCls 设置图标样式 
    */
    public void setIconCls(String iconCls) {
        this.iconCls = iconCls;
    }
    
    /** 
	* @return state ：closed:关闭，open:打开
	*/
    public String getState() {
        return state;
    }
    /** 
    *@param state 设置closed:关闭，open:打开 
    */
    public void setState(String state) {
        this.state = state;
    }

    /** 
	* @return type ：资源类型：function:功能;menu:菜单;module:模块;system:系统;一个系统有多个模块，一个模块包含多个功能
	*/
    public String getType() {
        return type;
    }
    /** 
    *@param type 设置资源类型：function:功能;menu:菜单;module:模块;system:系统;一个系统有多个模块，一个模块包含多个功能 
    */
    public void setType(String type) {
        this.type = type;
    }

    /** 
	* @return parentId ：父类
	*/
    public Long getParentId() {
        return parentId;
    }
    /** 
    *@param parentId 设置父类 
    */
    public void setParentId(Long parentId) {
        this.parentId = parentId;
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

    /** 
	* @return sort ：排序字段
	*/
    public Long getSort() {
        return sort;
    }
    /** 
    *@param sort 设置排序字段 
    */
    public void setSort(Long sort) {
        this.sort = sort;
    }


}