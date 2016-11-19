/*
 * 
 *  RecommendPositionDaoImpl 创建于 2016-11-14 13:56:04 版权归作者和作者当前组织所有
 */
package com.mmk.business.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.mmk.business.condition.RecommendPositionCondition;
import com.mmk.business.dao.RecommendPositionDao;
import com.mmk.business.model.RecommendPosition;
import com.mmk.gene.dao.impl.SpringDataQueryDaoImpl;

/**
 * RecommendPositionDaoImpl: 位置表 数据持久层接口实现
 * 
 * @author huguangling 胡广玲
 * @version 1.0
 *
 */
@Repository
public class RecommendPositionDaoImpl extends SpringDataQueryDaoImpl<RecommendPosition>
		implements RecommendPositionDao {

	private Log log = LogFactory.getLog(this.getClass());

	public RecommendPositionDaoImpl() {
		super(RecommendPosition.class);
	}

	/**
	 * 分页查询相关信息，根据传入的bean类对象和分页对象page取得查询结果集List
	 * 
	 * @param recommendPositionCondition    查询类
	 * @param pageable  传入的分页对象
	 * @return 符合条件的查询结果集
	 * @author huguangling 胡广玲
	 * 
	 */
	@Override
	public Page<RecommendPosition> list(RecommendPositionCondition recommendPositionCondition, Pageable pageable) {
		StringBuffer sb = new StringBuffer("select model from RecommendPosition model  where 1=1  ");
		Map<String, Object> params = new HashMap<String, Object>();
		if (StringUtils.isNotBlank(recommendPositionCondition.getPositionName())) {
			sb.append(" and model.positionName like :positionName ");
			params.put("positionName", "%" + recommendPositionCondition.getPositionName() + "%");
		}
		if (StringUtils.isNotBlank(recommendPositionCondition.getCode())) {
			sb.append(" and model.code like :code ");
			params.put("code", "%" + recommendPositionCondition.getCode() + "%");
		}
		return queryByJpql(sb.toString(), params, pageable);
	}

	@Override
	public List<RecommendPosition> list(RecommendPositionCondition recommendPositionCondition) {
		StringBuffer sb = new StringBuffer("select model from RecommendPosition model  where 1=1  ");
		Map<String, Object> params = new HashMap<String, Object>();
		if (StringUtils.isNotBlank(recommendPositionCondition.getPositionName())) {
			sb.append(" and model.positionName like :positionName ");
			params.put("positionName", "%" + recommendPositionCondition.getPositionName() + "%");
		}
		if (StringUtils.isNotBlank(recommendPositionCondition.getCode())) {
			sb.append(" and model.code like :code ");
			params.put("code", "%" + recommendPositionCondition.getCode() + "%");
		}
		return queryByJpql(sb.toString(), params);
	}

	@Override
	public Page<Map<String, Object>> listBySql(RecommendPositionCondition condition, Pageable pageable) {
		StringBuffer sb = new StringBuffer(
				"select id,position_name,code from business_recommend_position  where 1=1  ");
		Map<Integer, Object> params = new HashMap<Integer, Object>();
		if (StringUtils.isNotBlank(condition.getPositionName())) {
			sb.append(" and position_name like ?2 ");
			params.put(2, "%" + condition.getPositionName() + "%");
		}
		if (StringUtils.isNotBlank(condition.getCode())) {
			sb.append(" and code like ?3 ");
			params.put(3, "%" + condition.getCode() + "%");
		}
		return queryFieldsBySql(sb.toString(), params, pageable);
	}

	@Override
	public RecommendPosition findBy(String field, Object value) {
		StringBuffer sb = new StringBuffer("select model from RecommendPosition model  where model.");
		sb.append(field);
		sb.append(" = :value ");
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("value", value);
		List<RecommendPosition> result = queryByJpql(sb.toString(), params, 0l, 1l);
		return result.isEmpty() ? null : result.get(0);
	}

	@Override
	public List<RecommendPosition> findAllBy(String field, Object value) {
		StringBuffer sb = new StringBuffer("select model from RecommendPosition model  where model.");
		sb.append(field);
		sb.append(" = :value ");
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("value", value);
		return queryByJpql(sb.toString(), params);
	}

}