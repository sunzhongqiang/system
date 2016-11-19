/*
 *  OrderRepository 创建于 2016-11-07 10:37:06 版权归作者和作者当前组织所有
 */
package com.mmk.trade.dao;

import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import com.mmk.trade.model.Order;

/**
 * OrderRepository: 订单管理 数据资源层 2016-11-07 10:37:06
 * 
 * @author huguangling 胡广玲
 * @version 1.0
 */
public interface OrderRepository extends JpaRepository<Order, Long> {

	/**
	 * 根据给定的字段：id 团订单ID返回符合条件的第一个对象
	 * 
	 * @param id　团订单ID
	 * @return 符合条件的唯一对象
	 * @author huguangling 胡广玲
	 * 
	 */
	Order findFirstById(Long id);

	/**
	 * 根据给定的字段：id 团订单ID获取所有符合的记录
	 * 
	 * @param id　团订单ID
	 * @return 符合条件的所有对象
	 * @author huguangling 胡广玲
	 * 
	 */
	List<Order> findAllById(Long id);

	/**
	 * 根据给定的字段：id 团订单ID所有符合的记录
	 * 
	 * @param id　团订单ID
	 * @param pageable　分页参数
	 * @return 符合条件的所有对象
	 * @author huguangling 胡广玲
	 * 
	 */
	Page<Order> findAllById(Long id, Pageable pageable);

	/**
	 * 根据给定的字段：tuanCode 团ID返回符合条件的第一个对象
	 * 
	 * @param tuanCode　团ID
	 * @return 符合条件的唯一对象
	 * @author huguangling 胡广玲
	 * 
	 */
	Order findFirstByTuanCode(String tuanCode);

	/**
	 * 根据给定的字段：tuanCode 团ID获取所有符合的记录
	 * 
	 * @param tuanCode　团ID
	 * @return 符合条件的所有对象
	 * @author huguangling 胡广玲
	 * 
	 */
	List<Order> findAllByTuanCode(String tuanCode);

	/**
	 * 根据给定的字段：tuanCode 团ID所有符合的记录
	 * 
	 * @param tuanCode　团ID
	 * @param pageable　分页参数
	 * @return 符合条件的所有对象
	 * @author huguangling 胡广玲
	 * 
	 */
	Page<Order> findAllByTuanCode(String tuanCode, Pageable pageable);

}