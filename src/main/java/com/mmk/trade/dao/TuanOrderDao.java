/*
 * 
 *  OrderDao 创建于 2016-11-07 10:37:06 版权归作者和作者当前组织所有
 */
package com.mmk.trade.dao;

import java.util.List;
import java.util.Map;
import com.mmk.gene.dao.SpringDataQueryDao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.mmk.trade.condition.OrderCondition;
import com.mmk.trade.model.TuanOrder;
/**
* OrderDao:订单管理 数据持久层接口
* @author huguangling 胡广玲
* @version 1.0
*/
public interface TuanOrderDao extends SpringDataQueryDao<TuanOrder>{
    
    /**
     * 分页查询相关信息，根据传入的bean类对象和分页对象page取得查询结果集List
     * @param order 查询类
     * @param pageable 传入的分页对象
     * @return 符合条件的查询结果集
     * @author huguangling 胡广玲
     * 
     * 
     */
    Page<TuanOrder> list(OrderCondition order,Pageable pageable);
    /**
     * 不分页查询相关信息，根据传入的model类对象取得查询结果集List
     * @param order 查询类
     * @return 符合条件的查询结果集
     * @author huguangling 胡广玲
     * 
     */
    List<TuanOrder> list(OrderCondition order);
    /**
     * 使用sql查询，并以map和分页的形式进行返回数据结果
     * @param order Order类
     * @param pageable 传入的分页对象
     * @return 符合条件的查询结果集
     * @author huguangling 胡广玲
     * 
     * 
     */
    Page<Map<String,Object>> listBySql(OrderCondition order,Pageable pageable);
    /**
     * 根据给定的字段和属性值，获得符合条件的第一个结果
     * @param field Order 中的某个字段
     * @param value 字段对应的值
     * @return 返回符合条件的结果，如果没有返回null
     * @author huguangling 胡广玲
     * 
     * 
     */
    TuanOrder findBy(String field,Object value);
    
    /**
     * 根据给定的字段和属性值，获得符合条件的所有结果
     * @param field Order 中的某个字段
     * @param value 字段对应的值
     * @return 返回符合条件的所有结果
     * @author huguangling 胡广玲
     * 
     * 
     */
    List<TuanOrder> findAllBy(String field,Object value);
    /**
     * 统计订单数量
     * @param openid 用户的openid
     * @param status 订单状态
     * @return 订单的数量
     */
	Integer countByOpenid(String openid, String status);
	/**
	 * 用户订单列表
	 * @param openid 用户的openid
	 * @param orderCondition 订单查询条件
	 * @param pageable 分页参数
	 * @return 订单列表
	 */
	Page<TuanOrder> listBy(String openid, OrderCondition orderCondition, Pageable pageable);
	
	/**
	 * 根据团订单获取所有参团订单
	 * @param id 团订单ID
	 * @return 所有参团订单
	 */
	List<TuanOrder> findAllByTuanId(Long id);
	
	/**
	 * 根据团订单获取所有参团订单
	 * @param tuanStatus 团状态
	 * @return 所有参团订单
	 */
	List<TuanOrder> findTuanOrder(String openid, String tuanStatus);

}