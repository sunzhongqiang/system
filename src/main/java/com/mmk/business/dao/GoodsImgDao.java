/*
 * 
 *  GoodsImgDao 创建于 2016-11-01 09:00:03 版权归作者和作者当前组织所有
 */
package com.mmk.business.dao;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mmk.business.condition.GoodsImgCondition;
import com.mmk.business.model.GoodsImg;
import com.mmk.gene.dao.SpringDataQueryDao;

/**
 * GoodsImgDao:商品相册 数据持久层接口
 * 
 * @author huguangling 胡广玲
 * @version 1.0
 */
public interface GoodsImgDao extends SpringDataQueryDao<GoodsImg> {

	/**
	 * 分页查询相关信息，根据传入的bean类对象和分页对象page取得查询结果集List
	 * 
	 * @param goodsImg　 查询类
	 * @param pageable　传入的分页对象
	 * @return 符合条件的查询结果集
	 * @author huguangling 胡广玲
	 * 
	 * 
	 */
	Page<GoodsImg> list(GoodsImgCondition goodsImg, Pageable pageable);

	/**
	 * 不分页查询相关信息，根据传入的model类对象取得查询结果集List
	 * 
	 * @param goodsImg　 查询类
	 * @return 符合条件的查询结果集
	 * @author huguangling 胡广玲
	 * 
	 */
	List<GoodsImg> list(GoodsImgCondition goodsImg);

	/**
	 * 使用sql查询，并以map和分页的形式进行返回数据结果
	 * 
	 * @param goodsImg　GoodsImg类
	 * @param pageable　 传入的分页对象
	 * @return 符合条件的查询结果集
	 * @author huguangling 胡广玲
	 * 
	 * 
	 */
	Page<Map<String, Object>> listBySql(GoodsImgCondition goodsImg, Pageable pageable);

	/**
	 * 根据给定的字段和属性值，获得符合条件的第一个结果
	 * 
	 * @param field　 GoodsImg 中的某个字段
	 * @param value  字段对应的值
	 * @return 返回符合条件的结果，如果没有返回null
	 * @author huguangling 胡广玲
	 * 
	 * 
	 */
	GoodsImg findBy(String field, Object value);

	/**
	 * 根据给定的字段和属性值，获得符合条件的所有结果
	 * 
	 * @param field GoodsImg 中的某个字段
	 * @param value 字段对应的值
	 * @return 返回符合条件的所有结果
	 * @author huguangling 胡广玲
	 * 
	 * 
	 */
	List<GoodsImg> findAllBy(String field, Object value);

	/**
	 * 根据给定的字段和属性值，获得符合条件的所有结果
	 * 
	 * @param field  GoodsImg 中的某个字段
	 * @param value 字段对应的值
	 * @return 返回符合条件的所有结果
	 * @author huguangling 胡广玲
	 * 
	 * 
	 */
	List<GoodsImg> findByGoodsId(Long id);

}