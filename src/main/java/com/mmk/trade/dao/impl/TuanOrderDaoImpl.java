/*
 * 
 *  TuanOrderDaoImpl 创建于 2016-11-07 10:37:06 版权归作者和作者当前组织所有
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

import com.mmk.gene.dao.impl.SpringDataQueryDaoImpl;
import com.mmk.trade.condition.OrderCondition;
import com.mmk.trade.condition.TuanOrderStatus;
import com.mmk.trade.condition.TuanStatus;
import com.mmk.trade.dao.TuanOrderDao;
import com.mmk.trade.model.TuanOrder;

/**
 * TuanOrderDaoImpl: 订单管理 数据持久层接口实现
 * 
 * @author huguangling 胡广玲
 * @version 1.0
 *
 */
@Repository
public class TuanOrderDaoImpl extends SpringDataQueryDaoImpl<TuanOrder> implements TuanOrderDao {

	private Log log = LogFactory.getLog(this.getClass());

	public TuanOrderDaoImpl() {
		super(TuanOrder.class);
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
	public Page<TuanOrder> list(OrderCondition orderCondition, Pageable pageable) {
		StringBuffer sb = new StringBuffer("select model from TuanOrder model  where 1=1  ");
		Map<String, Object> params = new HashMap<String, Object>();
		if (StringUtils.isNotBlank(orderCondition.getUserName())) {
			sb.append(" and model.userName like :userName ");
			params.put("userName", "%" + orderCondition.getUserName() + "%");
		}
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
		
		sb.append(" order by model.id desc");
		return queryByJpql(sb.toString(), params, pageable);
	}

	@Override
	public List<TuanOrder> list(OrderCondition orderCondition) {
		StringBuffer sb = new StringBuffer("select model from TuanOrder model  where 1=1  ");
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
		if (StringUtils.isNotBlank(orderCondition.getOrderStatus())) {
			sb.append(" and model.orderStatus = :orderStatus ");
			params.put("orderStatus", orderCondition.getOrderStatus());
		}
		sb.append(" order by model.id desc");
		return queryByJpql(sb.toString(), params);
	}

	@Override
	public Page<Map<String, Object>> listBySql(OrderCondition condition, Pageable pageable) {
		StringBuffer sb = new StringBuffer(
				"select id,tuan_id,user_id,goods_id,user_name,order_code,order_time,pay_time,order_sort,good_img,good_des,good_code,good_price,order_price,order_status,address from trade_tuan_order  where 1=1  ");
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
		sb.append(" order by  id desc");
		return queryFieldsBySql(sb.toString(), params, pageable);
	}

	@Override
	public TuanOrder findBy(String field, Object value) {
		StringBuffer sb = new StringBuffer("select model from TuanOrder model  where model.");
		sb.append(field);
		sb.append(" = :value ");
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("value", value);
		List<TuanOrder> result = queryByJpql(sb.toString(), params, 0l, 1l);
		return result.isEmpty() ? null : result.get(0);
	}

	@Override
	public List<TuanOrder> findAllBy(String field, Object value) {
		StringBuffer sb = new StringBuffer("select model from TuanOrder model  where model.");
		sb.append(field);
		sb.append(" = :value ");
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("value", value);
		return queryByJpql(sb.toString(), params);
	}

	@Override
	public Integer countByOpenid(String openid, String status) {
		StringBuffer sb = new StringBuffer("select model from TuanOrder model  where model.user.openid = :openid ");
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("openid", openid);
		
		if(StringUtils.isNotBlank(status)){
			sb.append(" and model.orderStatus = :status ");
			params.put("status", status);
		}
		return countByJpql(sb.toString(), params).intValue();
	}

	@Override
	public Page<TuanOrder> listBy(String openid, OrderCondition orderCondition, Pageable pageable) {
		StringBuffer sb = new StringBuffer("select model from TuanOrder model where model.user.openid = :openid ");
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("openid", openid);
		
		if(orderCondition!=null){
			if (orderCondition.getOrderStatus()!=null) {
				sb.append(" and model.orderStatus = :status ");
				params.put("status", orderCondition.getOrderStatus());
			}
		}
		sb.append(" order by model.orderTime desc");
		return queryByJpql(sb.toString(), params,pageable);
	}

	@Override
	public List<TuanOrder> findAllByTuanId(Long id) {
		StringBuffer sb = new StringBuffer("select model from TuanOrder model left join fetch model.user  where model.tuanId = :id");
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);
		sb.append(" order by model.orderTime desc");
		return queryByJpql(sb.toString(), params);
	}

	@Override
	public List<TuanOrder> findTuanOrder(String openid, String tuanStatus) {
		StringBuffer sb = new StringBuffer("select model from TuanOrder model where model.user.openid = :openid ");
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("openid", openid);
		if(TuanStatus.WAIT_JOIN.name().equals(tuanStatus)){
//			sb.append(" or model.orderStatus = :status ");
//			params.put("status", TuanOrderStatus.WAIT_PAY.name());
			sb.append(" and model.orderStatus = :status ");
			params.put("status", TuanOrderStatus.WAIT_JOIN.name());
			
		} else if(TuanStatus.SUCCESSED.name().equals(tuanStatus)){
			sb.append(" and ( model.orderStatus = :status ");
			params.put("status", TuanOrderStatus.WAIT_SHIPPING.name());
			sb.append(" or model.orderStatus = :status ");
			params.put("status", TuanOrderStatus.WAIT_RECEIVE.name());
			sb.append(" or model.orderStatus = :status ");
			params.put("status", TuanOrderStatus.WAIT_COMMENT.name());
			sb.append(" or model.orderStatus = :status  )" );
			params.put("status", TuanOrderStatus.SUCCESSED.name());
			
		} else if(TuanStatus.FAIL.name().equals(tuanStatus)){
			sb.append(" and ( model.orderStatus = :status ");
			params.put("status", TuanOrderStatus.WAIT_REFUND_GOODS.name());
			sb.append(" or model.orderStatus = :status ");
			params.put("status", TuanOrderStatus.WAIT_REFUND_MONEY.name());
			sb.append(" or model.orderStatus = :status )");
			params.put("status", TuanOrderStatus.CLOSED.name());
			
		} else{
			sb.append(" and model.orderStatus != :status ");
			params.put("status", TuanOrderStatus.WAIT_PAY.name());
		}
		return queryByJpql(sb.toString(), params);
	}

	@Override
	public TuanOrder findByOrderCode(String orderCode) {
		StringBuffer sb = new StringBuffer("select model from TuanOrder model  where 1=1");
		Map<String, Object> params = new HashMap<String, Object>();
		if (orderCode !=null) {
			sb.append(" and model.orderCode = :orderCode ");
			params.put("orderCode", orderCode);
		}

		List<TuanOrder> result = queryByJpql(sb.toString(), params, 0l, 1l);
		return result.isEmpty() ? null : result.get(0);
	}

}