package com.mmk.business.service;

import java.util.List;
import com.mmk.gene.service.BaseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.mmk.business.model.GoodsImg;
import com.mmk.business.condition.GoodsImgCondition;

/**
 * GoodsImgService: 商品相册 业务服务层接口 2016-11-01 09:00:03
 * 
 * @author huguangling 胡广玲
 * @version 1.0
 */
public interface GoodsImgService extends BaseService<GoodsImg, Long> {
	/**
	 * 生成的列表分页查询方法
	 * 
	 * @param goodsImgCondition
	 *            查询条件
	 * @param pageable
	 *            分页参数
	 * @return 分页返回查询的结果
	 * @author huguangling 胡广玲
	 * 
	 */
	Page<GoodsImg> list(GoodsImgCondition goodsImgCondition, Pageable pageable);

	/**
	 * 不分页查询相关信息，根据传入的model类对象取得查询结果集List
	 * 
	 * @param goodsImg
	 *            查询类
	 * @return 查询的结果集
	 * @author huguangling 胡广玲
	 * 
	 */
	public List<GoodsImg> list(GoodsImgCondition goodsImg);

	/**
	 * 根据给定的字段和属性值，获得符合条件的第一个结果
	 * 
	 * @param field
	 *            GoodsImg 中的某个字段
	 * @param value
	 *            字段的值
	 * @return GoodsImg 返回符合条件的结果，如果没有返回null
	 * @author huguangling 胡广玲
	 * 
	 * 
	 */
	GoodsImg findBy(String field, Object value);

	/**
	 * 根据给定的字段和属性值，获得符合条件的所有结果
	 * 
	 * @param field
	 *            GoodsImg中的某个字段
	 * @param value
	 *            字段的值
	 * @return 返回符合条件的所有结果
	 * @author huguangling 胡广玲
	 * 
	 * 
	 */
	List<GoodsImg> findAllBy(String field, Object value);

	/**
	 * 根据给定的字段和属性值，获得符合条件的所有结果
	 * 
	 * @param field
	 *            GoodsImg中的某个字段
	 * @param value
	 *            字段的值
	 * @return 返回符合条件的所有结果
	 * @author huguangling 胡广玲
	 * 
	 * 
	 */
	List<GoodsImg> findByGoodId(Long id);
}