/*
 *  GoodsRepository 创建于 2016-10-31 10:48:36 版权归作者和作者当前组织所有
 */
package com.mmk.business.dao;

import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import com.mmk.business.model.Goods;

/**
 * GoodsRepository: 商品活动 数据资源层 2016-10-31 10:48:36
 * 
 * @author huguangling 胡广玲
 * @version 1.0
 */
public interface GoodsRepository extends JpaRepository<Goods, Long> {

	/**
	 * 根据给定的字段：id 商品ID返回符合条件的第一个对象
	 * 
	 * @param id 商品ID
	 * @return 符合条件的唯一对象
	 * @author huguangling 胡广玲
	 * 
	 */
	Goods findFirstById(Long id);

	/**
	 * 根据给定的字段：id 商品ID获取所有符合的记录
	 * 
	 * @param id 商品ID
	 * @return 符合条件的所有对象
	 * @author huguangling 胡广玲
	 * 
	 */
	List<Goods> findAllById(Long id);

	/**
	 * 根据给定的字段：id 商品ID所有符合的记录
	 * 
	 * @param id 商品ID
	 * @param pageable  分页参数
	 * @return 符合条件的所有对象
	 * @author huguangling 胡广玲
	 * 
	 */
	Page<Goods> findAllById(Long id, Pageable pageable);

}