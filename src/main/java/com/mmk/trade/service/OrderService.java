package com.mmk.trade.service;

import java.util.List;
import com.mmk.gene.service.BaseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.mmk.trade.model.Order;
import com.mmk.trade.condition.OrderCondition;

/**
 * OrderService: 订单管理 业务服务层接口 2016-11-07 10:37:06
 * 
 * @author huguangling 胡广玲
 * @version 1.0
 */
public interface OrderService extends BaseService<Order, Long> {
	/**
	 * 生成的列表分页查询方法
	 * 
	 * @param orderCondition
	 *            查询条件
	 * @param pageable
	 *            分页参数
	 * @return 分页返回查询的结果
	 * @author huguangling 胡广玲
	 * 
	 */
	Page<Order> list(OrderCondition orderCondition, Pageable pageable);

	/**
	 * 不分页查询相关信息，根据传入的model类对象取得查询结果集List
	 * 
	 * @param order
	 *            查询类
	 * @return 查询的结果集
	 * @author huguangling 胡广玲
	 * 
	 */
	public List<Order> list(OrderCondition order);

	/**
	 * 根据给定的字段返回符合的对象
	 * 
	 * @param id
	 *            团订单ID
	 * @return 符合条件的唯一对象
	 * @author huguangling 胡广玲
	 * 
	 */
	Order findById(Long id);

	/**
	 * 根据字段获取所有符合的记录
	 * 
	 * @param id
	 *            团订单ID
	 * @return 符合条件的所有对象
	 * @author huguangling 胡广玲
	 * 
	 */
	List<Order> findAllById(Long id);

	/**
	 * 根据字段获取所有符合的记录
	 * 
	 * @param id
	 *            团订单ID
	 * @param pageable
	 *            分页参数
	 * @return 符合条件的所有对象
	 * @author huguangling 胡广玲
	 * 
	 */
	Page<Order> findAllById(Long id, Pageable pageable);

	/**
	 * 根据给定的字段返回符合的对象
	 * 
	 * @param tuanCode
	 *            团ID
	 * @return 符合条件的唯一对象
	 * @author huguangling 胡广玲
	 * 
	 */
	Order findByTuanCode(String tuanCode);

	/**
	 * 根据字段获取所有符合的记录
	 * 
	 * @param tuanCode
	 *            团ID
	 * @return 符合条件的所有对象
	 * @author huguangling 胡广玲
	 * 
	 */
	List<Order> findAllByTuanCode(String tuanCode);

	/**
	 * 根据字段获取所有符合的记录
	 * 
	 * @param tuanCode
	 *            团ID
	 * @param pageable
	 *            分页参数
	 * @return 符合条件的所有对象
	 * @author huguangling 胡广玲
	 * 
	 */
	Page<Order> findAllByTuanCode(String tuanCode, Pageable pageable);

	/**
	 * 根据给定的字段和属性值，获得符合条件的第一个结果
	 * 
	 * @param field
	 *            Order 中的某个字段
	 * @param value
	 *            字段的值
	 * @return Order 返回符合条件的结果，如果没有返回null
	 * @author huguangling 胡广玲
	 * 
	 * 
	 */
	Order findBy(String field, Object value);

	/**
	 * 根据给定的字段和属性值，获得符合条件的所有结果
	 * 
	 * @param field
	 *            Order中的某个字段
	 * @param value
	 *            字段的值
	 * @return 返回符合条件的所有结果
	 * @author huguangling 胡广玲
	 * 
	 * 
	 */
	List<Order> findAllBy(String field, Object value);
}