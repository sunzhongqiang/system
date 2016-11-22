package com.mmk.business.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mmk.business.condition.RecommendGoodsCondition;
import com.mmk.business.model.RecommendGoods;
import com.mmk.gene.service.BaseService;

/**
 * RecommendGoodsService: 商品 位置 关系表 业务服务层接口 2016-11-14 13:55:42
 * 
 * @author huguangling 胡广玲
 * @version 1.0
 */
public interface RecommendGoodsService extends BaseService<RecommendGoods, Long> {
	/**
	 * 生成的列表分页查询方法
	 * 
	 * @param recommendGoodsCondition  查询条件
	 * @param pageable  分页参数
	 * @return 分页返回查询的结果
	 * @author huguangling 胡广玲
	 * 
	 */
	Page<RecommendGoods> list(RecommendGoodsCondition recommendGoodsCondition, Pageable pageable);

	/**
	 * 不分页查询相关信息，根据传入的model类对象取得查询结果集List
	 * 
	 * @param recommendGoods       查询类
	 * @return 查询的结果集
	 * @author huguangling 胡广玲
	 * 
	 */
	public List<RecommendGoods> list(RecommendGoodsCondition recommendGoods);

	/**
	 * 根据给定的字段返回符合的对象
	 * 
	 * @param id 主键
	 * @return 符合条件的唯一对象
	 * @author huguangling 胡广玲
	 * 
	 */
	RecommendGoods findById(Long id);

	/**
	 * 根据给定的字段和属性值，获得符合条件的第一个结果
	 * 
	 * @param field  RecommendGoods 中的某个字段
	 * @param value  字段的值
	 * @return RecommendGoods 返回符合条件的结果，如果没有返回null
	 * @author huguangling 胡广玲
	 * 
	 * 
	 */
	RecommendGoods findBy(String field, Object value);

	/**
	 * 根据给定的字段和属性值，获得符合条件的所有结果
	 * 
	 * @param field  RecommendGoods中的某个字段
	 * @param value    字段的值
	 * @return 返回符合条件的所有结果
	 * @author huguangling 胡广玲
	 * 
	 * 
	 */
	List<RecommendGoods> findAllBy(String field, Object value);

	 /**
     * 根据给定的字段和属性值，获得符合条件的所有结果
     * @param field RecommendGroup中的某个字段
     * @param value 字段的值
     * @return 返回符合条件的所有结果
     * @author huguangling 胡广玲
     * 
     */
	RecommendGoods findByPositionId(Long positionId, Long goodsId);
	
	 /**
     * 根据给定的字段和属性值，获得符合条件的所有结果
     * @param field RecommendGroup中的某个字段
     * @param value 字段的值
     * @return 返回符合条件的所有结果
     * @author huguangling 胡广玲
     * 
     */
	List<RecommendGoods> findByPosition(Long id);

}