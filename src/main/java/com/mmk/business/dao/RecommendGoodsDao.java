/*
 * 
 *  RecommendGoodsDao 创建于 2016-11-14 13:55:42 版权归作者和作者当前组织所有
 */
package com.mmk.business.dao;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mmk.business.condition.RecommendGoodsCondition;
import com.mmk.business.model.RecommendGoods;
import com.mmk.gene.dao.SpringDataQueryDao;
/**
* RecommendGoodsDao:商品 位置 关系表 数据持久层接口
* @author huguangling 胡广玲
* @version 1.0
*/
public interface RecommendGoodsDao extends SpringDataQueryDao<RecommendGoods>{
    
    /**
     * 分页查询相关信息，根据传入的bean类对象和分页对象page取得查询结果集List
     * @param recommendGoods 查询类
     * @param pageable 传入的分页对象
     * @return 符合条件的查询结果集
     * @author huguangling 胡广玲
     * 
     * 
     */
    Page<RecommendGoods> list(RecommendGoodsCondition recommendGoods,Pageable pageable);
    /**
     * 不分页查询相关信息，根据传入的model类对象取得查询结果集List
     * @param recommendGoods 查询类
     * @return 符合条件的查询结果集
     * @author huguangling 胡广玲
     * 
     */
    List<RecommendGoods> list(RecommendGoodsCondition recommendGoods);
    /**
     * 使用sql查询，并以map和分页的形式进行返回数据结果
     * @param recommendGoods RecommendGoods类
     * @param pageable 传入的分页对象
     * @return 符合条件的查询结果集
     * @author huguangling 胡广玲
     * 
     * 
     */
    Page<Map<String,Object>> listBySql(RecommendGoodsCondition recommendGoods,Pageable pageable);
    /**
     * 根据给定的字段和属性值，获得符合条件的第一个结果
     * @param field RecommendGoods 中的某个字段
     * @param value 字段对应的值
     * @return 返回符合条件的结果，如果没有返回null
     * @author huguangling 胡广玲
     * 
     * 
     */
    RecommendGoods findBy(String field,Object value);
    
    /**
     * 根据给定的字段和属性值，获得符合条件的所有结果
     * @param field RecommendGoods 中的某个字段
     * @param value 字段对应的值
     * @return 返回符合条件的所有结果
     * @author huguangling 胡广玲
     * 
     * 
     */
    List<RecommendGoods> findAllBy(String field,Object value);
    
    /**
     * 根据给定的字段和属性值，获得符合条件的所有结果
     * @param positionId RecommendGoods 中的某个字段
     * @param goodsId 字段对应的值
     * @return 返回符合条件的所有结果
     * @author huguangling 胡广玲
     * 
     * 
     */
	RecommendGoods findByPositionId(Long positionId, Long goodsId);
	
	/**
     * 根据给定的字段和属性值，获得符合条件的所有结果
     * @param positionId RecommendGoods 中的某个字段
     * @param goodsId 字段对应的值
     * @return 返回符合条件的所有结果
     * @author huguangling 胡广玲
     * 
     * 
     */
	List<RecommendGoods> findByPosition(Long positionId);


}