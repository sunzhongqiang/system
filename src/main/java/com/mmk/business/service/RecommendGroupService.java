package com.mmk.business.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mmk.business.condition.RecommendGroupCondition;
import com.mmk.business.model.RecommendGroup;
import com.mmk.gene.service.BaseService;

/**
* RecommendGroupService: 拼团推荐管理 业务服务层接口
*2016-11-18 15:33:45
*@author huguangling 胡广玲
*@version 1.0
*/
public interface RecommendGroupService extends BaseService<RecommendGroup, Long> {
    /**
     * 生成的列表分页查询方法
     * @param recommendGroupCondition  查询条件
     * @param pageable 分页参数
     * @return 分页返回查询的结果
     * @author huguangling 胡广玲
     * 
     */
    Page<RecommendGroup> list(RecommendGroupCondition recommendGroupCondition, Pageable pageable);
    
    /**
     * 不分页查询相关信息，根据传入的model类对象取得查询结果集List
     * @param  recommendGroup 查询类
     * @return 查询的结果集
     * @author huguangling 胡广玲
     * 
     */
    public List<RecommendGroup> list(RecommendGroupCondition recommendGroup);

    /**
     * 根据给定的字段返回符合的对象
     * @param id 主键
     * @return 符合条件的唯一对象
     * @author huguangling 胡广玲
     * 
     */
    RecommendGroup findById(Long id);
    /**
     * 根据给定的字段和属性值，获得符合条件的第一个结果
     * @param field RecommendGroup 中的某个字段
     * @param value 字段的值
     * @return RecommendGroup 返回符合条件的结果，如果没有返回null
     * @author huguangling 胡广玲
     * 
     * 
     */
    RecommendGroup findBy(String field,Object value);
    
    /**
     * 根据给定的字段和属性值，获得符合条件的所有结果
     * @param field RecommendGroup中的某个字段
     * @param value 字段的值
     * @return 返回符合条件的所有结果
     * @author huguangling 胡广玲
     * 
     * 
     */
    List<RecommendGroup> findAllBy(String field,Object value);
    
	 /**
     * 根据给定的字段和属性值，获得符合条件的所有结果
     * @param field RecommendGroup中的某个字段
     * @param value 字段的值
     * @return 返回符合条件的所有结果
     * @author huguangling 胡广玲
     * 
     */
    RecommendGroup findByPositionId(Long positionId, Long goodId);
}