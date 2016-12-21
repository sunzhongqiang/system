/*
 * 
 *  ApiDao 创建于 2016-11-15 10:01:04 版权归作者和作者当前组织所有
 */
package com.mmk.system.dao;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mmk.gene.dao.SpringDataQueryDao;
import com.mmk.system.condition.ApiCondition;
import com.mmk.system.model.Api;
/**
* ApiDao:系统API 数据持久层接口
* @author 
* @version 1.0
*/
public interface ApiDao extends SpringDataQueryDao<Api>{
    
    /**
     * 分页查询相关信息，根据传入的bean类对象和分页对象page取得查询结果集List
     * @param api 查询类
     * @param pageable 传入的分页对象
     * @return 符合条件的查询结果集
     * @author 
     * 
     * 
     */
    Page<Api> list(ApiCondition api,Pageable pageable);
    /**
     * 不分页查询相关信息，根据传入的model类对象取得查询结果集List
     * @param api 查询类
     * @return 符合条件的查询结果集
     * @author 
     * 
     */
    List<Api> list(ApiCondition api);
    /**
     * 使用sql查询，并以map和分页的形式进行返回数据结果
     * @param api Api类
     * @param pageable 传入的分页对象
     * @return 符合条件的查询结果集
     * @author 
     * 
     * 
     */
    Page<Map<String,Object>> listBySql(ApiCondition api,Pageable pageable);
    /**
     * 根据给定的字段和属性值，获得符合条件的第一个结果
     * @param field Api 中的某个字段
     * @param value 字段对应的值
     * @return 返回符合条件的结果，如果没有返回null
     * @author 
     * 
     * 
     */
    Api findBy(String field,Object value);
    
    /**
     * 根据给定的字段和属性值，获得符合条件的所有结果
     * @param field Api 中的某个字段
     * @param value 字段对应的值
     * @return 返回符合条件的所有结果
     * @author 
     * 
     * 
     */
    List<Api> findAllBy(String field,Object value);
    
}