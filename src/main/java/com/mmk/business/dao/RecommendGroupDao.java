/*
 * 
 *  RecommendGroupDao 创建于 2016-11-18 15:33:45 版权归作者和作者当前组织所有
 */
package com.mmk.business.dao;

import java.util.List;
import java.util.Map;
import com.mmk.gene.dao.SpringDataQueryDao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.mmk.business.condition.RecommendGroupCondition;
import com.mmk.business.model.RecommendGroup;
/**
* RecommendGroupDao:拼团推荐管理 数据持久层接口
* @author huguangling 胡广玲
* @version 1.0
*/
public interface RecommendGroupDao extends SpringDataQueryDao<RecommendGroup>{
    
    /**
     * 分页查询相关信息，根据传入的bean类对象和分页对象page取得查询结果集List
     * @param recommendGroup 查询类
     * @param pageable 传入的分页对象
     * @return 符合条件的查询结果集
     * @author huguangling 胡广玲
     * 
     * 
     */
    Page<RecommendGroup> list(RecommendGroupCondition recommendGroup,Pageable pageable);
    /**
     * 不分页查询相关信息，根据传入的model类对象取得查询结果集List
     * @param recommendGroup 查询类
     * @return 符合条件的查询结果集
     * @author huguangling 胡广玲
     * 
     */
    List<RecommendGroup> list(RecommendGroupCondition recommendGroup);
    /**
     * 使用sql查询，并以map和分页的形式进行返回数据结果
     * @param recommendGroup RecommendGroup类
     * @param pageable 传入的分页对象
     * @return 符合条件的查询结果集
     * @author huguangling 胡广玲
     * 
     * 
     */
    Page<Map<String,Object>> listBySql(RecommendGroupCondition recommendGroup,Pageable pageable);
    /**
     * 根据给定的字段和属性值，获得符合条件的第一个结果
     * @param field RecommendGroup 中的某个字段
     * @param value 字段对应的值
     * @return 返回符合条件的结果，如果没有返回null
     * @author huguangling 胡广玲
     * 
     * 
     */
    RecommendGroup findBy(String field,Object value);
    
    /**
     * 根据给定的字段和属性值，获得符合条件的所有结果
     * @param field RecommendGroup 中的某个字段
     * @param value 字段对应的值
     * @return 返回符合条件的所有结果
     * @author huguangling 胡广玲
     * 
     * 
     */
    List<RecommendGroup> findAllBy(String field,Object value);
    
    /**
     * 根据给定的字段和属性值，获得符合条件的所有结果
     * @param positionId RecommendGroup 中的某个字段
     * @param goodId 字段对应的值
     * @return 返回符合条件的所有结果
     * @author huguangling 胡广玲
     */
	RecommendGroup findByPositionId(Long positionId, Long goodId);
	
	/**
     * 根据给定的字段和属性值，获得符合条件的所有结果
     * @param positionId RecommendGroup 中的某个字段
     * @param goodId 字段对应的值
     * @return 返回符合条件的所有结果
     * @author huguangling 胡广玲
     */
	List<RecommendGroup> findByPosition(Long positionId);
}