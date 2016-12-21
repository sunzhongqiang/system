package com.mmk.system.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mmk.common.model.Tree;
import com.mmk.gene.service.BaseService;
import com.mmk.system.condition.OrganizationCondition;
import com.mmk.system.model.Organization;

/**
* OrganizationService: 组织机构 业务服务层接口
*2016-10-24 10:07:36
*@author 孙中强 sunzhongqiang
*@version 1.0
*/
public interface OrganizationService extends BaseService<Organization, Long> {
    /**
     * 生成的列表分页查询方法
     * @param organizationCondition  查询条件
     * @param pageable 分页参数
     * @return 分页返回查询的结果
     * @author 孙中强 sunzhongqiang
     * 
     */
    Page<Organization> list(OrganizationCondition organizationCondition, Pageable pageable);
    
    /**
     * 不分页查询相关信息，根据传入的model类对象取得查询结果集List
     * @param  organization 查询类
     * @return 查询的结果集
     * @author 孙中强 sunzhongqiang
     * 
     */
    public List<Organization> list(OrganizationCondition organization);

    /**
     * 根据给定的字段和属性值，获得符合条件的第一个结果
     * @param field Organization 中的某个字段
     * @param value 字段的值
     * @return Organization 返回符合条件的结果，如果没有返回null
     * @author 孙中强 sunzhongqiang
     * 
     * 
     */
    Organization findBy(String field,Object value);
    
    /**
     * 根据给定的字段和属性值，获得符合条件的所有结果
     * @param field Organization中的某个字段
     * @param value 字段的值
     * @return 返回符合条件的所有结果
     * @author 孙中强 sunzhongqiang
     * 
     * 
     */
    List<Organization> findAllBy(String field,Object value);

    /**
     * 组织结构树
     * @param organizationCondition 
     * @return tree数据
     */
    List<Tree> tree();
    

    /**
     * 组织结构树treeGrid
     * @param organizationCondition 
     * @return treeGrid数据
     */
	List<Organization> treeGrid();
}