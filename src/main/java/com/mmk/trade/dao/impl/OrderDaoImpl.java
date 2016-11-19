/*
 * 
 *  OrderDaoImpl 创建于 2016-11-07 10:37:06 版权归作者和作者当前组织所有
 */
package com.mmk.trade.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.mmk.business.constants.TuanConstant;
import com.mmk.gene.dao.impl.SpringDataQueryDaoImpl;
import com.mmk.trade.condition.OrderCondition;
import com.mmk.trade.dao.OrderDao;
import com.mmk.trade.model.Order;

/**
 * OrderDaoImpl: 订单管理 数据持久层接口实现
 * 
 * @author huguangling 胡广玲
 * @version 1.0
 *
 */
@Repository
public class OrderDaoImpl extends SpringDataQueryDaoImpl<Order> implements OrderDao {

	private Log log = LogFactory.getLog(this.getClass());

	public OrderDaoImpl() {
		super(Order.class);
	}

	/**
	 * 分页查询相关信息，根据传入的bean类对象和分页对象page取得查询结果集List
	 * 
	 * @param orderCondition  查询类
	 * @param pageable 传入的分页对象
	 * @return 符合条件的查询结果集
	 * @author huguangling 胡广玲
	 * 
	 */
	@Override
	public Page<Order> list(OrderCondition orderCondition, Pageable pageable) {
		StringBuffer sb = new StringBuffer("select model from Order model  where 1=1  ");
		Map<String, Object> params = new HashMap<String, Object>();
		if (StringUtils.isNotBlank(orderCondition.getUserName())) {
			sb.append(" and model.userName like :userName ");
			params.put("userName", "%" + orderCondition.getUserName() + "%");
		}
		if (StringUtils.isNotBlank(orderCondition.getOrderCode())) {
			sb.append(" and model.orderCode like :orderCode ");
			params.put("orderCode", "%" + orderCondition.getOrderCode() + "%");
		}
		if (StringUtils.isNotBlank(orderCondition.getTuanCode())) {
			sb.append(" and model.tuanCode like :tuanCode ");
			params.put("tuanCode", "%" + orderCondition.getTuanCode() + "%");
		}
		if (orderCondition.getOrderTime() != null) {
			sb.append(" and model.orderTime = :orderTime ");
			params.put("orderTime", orderCondition.getOrderTime());
		}
		if (orderCondition.getPayTime() != null) {
			sb.append(" and model.payTime = :payTime ");
			params.put("payTime", orderCondition.getPayTime());
		}
		if (orderCondition.getOrderSort() != null) {
			sb.append(" and model.orderSort = :orderSort ");
			params.put("orderSort", orderCondition.getOrderSort());
		}
		if (orderCondition.getOrderStatus() != null) {
			sb.append(" and model.orderStatus = :orderStatus ");
			params.put("orderStatus", orderCondition.getOrderStatus());
		}
		return queryByJpql(sb.toString(), params, pageable);
	}

	@Override
	public List<Order> list(OrderCondition orderCondition) {
		StringBuffer sb = new StringBuffer("select model from Order model  where 1=1  ");
		Map<String, Object> params = new HashMap<String, Object>();
		if (StringUtils.isNotBlank(orderCondition.getUserName())) {
			sb.append(" and model.userName like :userName ");
			params.put("userName", "%" + orderCondition.getUserName() + "%");
		}
		if (StringUtils.isNotBlank(orderCondition.getOrderCode())) {
			sb.append(" and model.orderCode like :orderCode ");
			params.put("orderCode", "%" + orderCondition.getOrderCode() + "%");
		}
		if (orderCondition.getOrderTime() != null) {
			sb.append(" and model.orderTime = :orderTime ");
			params.put("orderTime", orderCondition.getOrderTime());
		}
		if (orderCondition.getPayTime() != null) {
			sb.append(" and model.payTime = :payTime ");
			params.put("payTime", orderCondition.getPayTime());
		}
		if (orderCondition.getOrderSort() != null) {
			sb.append(" and model.orderSort = :orderSort ");
			params.put("orderSort", orderCondition.getOrderSort());
		}
		if (orderCondition.getOrderStatus() != null
				|| !TuanConstant.TUAN_STATUS_ALL.equals(orderCondition.getOrderStatus())) {
			sb.append(" and model.orderStatus = :orderStatus ");
			params.put("orderStatus", orderCondition.getOrderStatus());
		}
		return queryByJpql(sb.toString(), params);
	}

	@Override
	public Page<Map<String, Object>> listBySql(OrderCondition condition, Pageable pageable) {
		StringBuffer sb = new StringBuffer(
				"select id,tuan_id,user_id,goods_id,user_name,order_code,order_time,pay_time,order_sort,good_img,good_des,good_code,good_price,order_price,order_status,address from trade_order  where 1=1  ");
		Map<Integer, Object> params = new HashMap<Integer, Object>();
		if (StringUtils.isNotBlank(condition.getUserName())) {
			sb.append(" and user_name like ?5 ");
			params.put(5, "%" + condition.getUserName() + "%");
		}
		if (StringUtils.isNotBlank(condition.getOrderCode())) {
			sb.append(" and order_code like ?6 ");
			params.put(6, "%" + condition.getOrderCode() + "%");
		}
		if (condition.getOrderTime() != null) {
			sb.append(" and order_time = ?7 ");
			params.put(7, condition.getOrderTime());
		}
		if (condition.getPayTime() != null) {
			sb.append(" and pay_time = ?8 ");
			params.put(8, condition.getPayTime());
		}
		if (condition.getOrderSort() != null) {
			sb.append(" and order_sort = ?9 ");
			params.put(9, condition.getOrderSort());
		}
		if (condition.getOrderStatus() != null) {
			sb.append(" and order_status = ?15 ");
			params.put(15, condition.getOrderStatus());
		}
		return queryFieldsBySql(sb.toString(), params, pageable);
	}

	@Override
	public Order findBy(String field, Object value) {
		StringBuffer sb = new StringBuffer("select model from Order model  where model.");
		sb.append(field);
		sb.append(" = :value ");
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("value", value);
		List<Order> result = queryByJpql(sb.toString(), params, 0l, 1l);
		return result.isEmpty() ? null : result.get(0);
	}

	@Override
	public List<Order> findAllBy(String field, Object value) {
		StringBuffer sb = new StringBuffer("select model from Order model  where model.");
		sb.append(field);
		sb.append(" = :value ");
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("value", value);
		return queryByJpql(sb.toString(), params);
	}

}