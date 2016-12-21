package com.mmk.system.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mmk.gene.service.BaseService;
import com.mmk.system.condition.ApiCondition;
import com.mmk.system.model.Api;

/**
* ApiService: 系统API 业务服务层接口
*2016-11-15 10:01:04
*@author 
*@version 1.0
*/
public interface ApiService extends BaseService<Api, Long> {
    /**
     * 生成的列表分页查询方法
     * @param apiCondition  查询条件
     * @param pageable 分页参数
     * @return 分页返回查询的结果
     * @author 
     * 
     */
    Page<Api> list(ApiCondition apiCondition, Pageable pageable);
    
    /**
     * 不分页查询相关信息，根据传入的model类对象取得查询结果集List
     * @param  api 查询类
     * @return 查询的结果集
     * @author 
     * 
     */
    public List<Api> list(ApiCondition api);

    /**
     * 根据给定的字段和属性值，获得符合条件的第一个结果
     * @param field Api 中的某个字段
     * @param value 字段的值
     * @return Api 返回符合条件的结果，如果没有返回null
     * @author 
     * 
     * 
     */
    Api findBy(String field,Object value);
    
    /**
     * 根据给定的字段和属性值，获得符合条件的所有结果
     * @param field Api中的某个字段
     * @param value 字段的值
     * @return 返回符合条件的所有结果
     * @author 
     * 
     * 
     */
    List<Api> findAllBy(String field,Object value);
}