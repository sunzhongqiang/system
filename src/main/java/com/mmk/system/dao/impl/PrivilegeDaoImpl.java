/*
 * 
 *  PrivilegeDaoImpl 创建于 2016-10-25 09:35:10 版权归作者和作者当前组织所有
 */
package com.mmk.system.dao.impl;

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
import com.mmk.system.condition.PrivilegeCondition;
import com.mmk.system.dao.PrivilegeDao;
import com.mmk.system.model.Privilege;

/**
 * PrivilegeDaoImpl: 系统权限表 数据持久层接口实现
 * 
 * @author
 * @version 1.0
 *
 */
@Repository
public class PrivilegeDaoImpl extends SpringDataQueryDaoImpl<Privilege> implements PrivilegeDao {

	private Log log = LogFactory.getLog(this.getClass());

	public PrivilegeDaoImpl() {
		super(Privilege.class);
	}

	/**
	 * 分页查询相关信息，根据传入的bean类对象和分页对象page取得查询结果集List
	 * 
	 * @param privilegeCondition 查询类
	 * @param pageable  传入的分页对象
	 * @return 符合条件的查询结果集
	 * @author
	 * 
	 */
	@Override
	public Page<Privilege> list(PrivilegeCondition privilegeCondition, Pageable pageable) {
		StringBuffer sb = new StringBuffer("select model from Privilege model  where 1=1  ");
		Map<String, Object> params = new HashMap<String, Object>();
		return queryByJpql(sb.toString(), params, pageable);
	}

	@Override
	public List<Privilege> list(PrivilegeCondition privilegeCondition) {
		StringBuffer sb = new StringBuffer("select model from Privilege model  where 1=1  ");
		Map<String, Object> params = new HashMap<String, Object>();
		return queryByJpql(sb.toString(), params);
	}

	@Override
	public Page<Map<String, Object>> listBySql(PrivilegeCondition condition, Pageable pageable) {
		StringBuffer sb = new StringBuffer("select id,role_code,function_uri from system_privilege  where 1=1  ");
		Map<Integer, Object> params = new HashMap<Integer, Object>();
		return queryFieldsBySql(sb.toString(), params, pageable);
	}

	@Override
	public Privilege findBy(String field, Object value) {
		StringBuffer sb = new StringBuffer("select model from Privilege model  where model.");
		sb.append(field);
		sb.append(" = :value ");
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("value", value);
		List<Privilege> result = queryByJpql(sb.toString(), params, 0l, 1l);
		return result.isEmpty() ? null : result.get(0);
	}

	@Override
	public List<Privilege> findAllBy(String field, Object value) {
		StringBuffer sb = new StringBuffer("select model from Privilege model  where model.");
		sb.append(field);
		sb.append(" = :value ");
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("value", value);
		return queryByJpql(sb.toString(), params);
	}

	@Override
	public Privilege findByIdAndFunctionID(Long roleId, Long functionId) {
		StringBuffer sb = new StringBuffer("select model from Privilege model  where 1=1  ");
		Map<String, Object> params = new HashMap<String, Object>();
		if (roleId != null) {
			sb.append(" and model.roleId = :roleId ");
			params.put("roleId", roleId);
		}
		if (roleId != null) {
			sb.append(" and model.functionId = :functionId ");
			params.put("functionId", functionId);
		}
		List<Privilege> result = queryByJpql(sb.toString(), params);
		return result.isEmpty() ? null : result.get(0);
	}

	@Override
	public List<Map<String, Object>> findRolePrivilege(Long roleId) {
		Map<Integer, Object> params = new HashMap<Integer, Object>();
		StringBuffer sb = new StringBuffer(
				" SELECT distinct func.id AS functionId,func.name AS functionName, func.parent_id AS parentId,pri.id as privilegeId FROM system_function func ");
		sb.append(" LEFT JOIN ( ");
		sb.append(" SELECT id,function_id,role_id FROM system_privilege privilege  ");
		if (roleId != null) {
			sb.append(" WHERE privilege.role_id = ?1 ");
			params.put(1, roleId);
		} else {
			sb.append(" where 1<>1 ");
		}
		sb.append(" ) pri ON func.id = pri.function_id order by func.sort  ");
		return queryFieldsBySql(sb.toString(), params);
	}

	@Override
	public Privilege findByRoleIdAndPrivilegeID(Long roleId, String privilegeID) {
		StringBuffer sb = new StringBuffer("select model from Privilege model  where model.");
		Map<String, Object> params = new HashMap<String, Object>();
		if (roleId != null) {
			sb.append(" and model.roleId = :roleId ");
			params.put("roleId", roleId);
		}
		if (roleId != null) {
			sb.append(" and model.functionId = :privilegeID ");
			params.put("privilegeID", privilegeID);
		}
		List<Privilege> result = queryByJpql(sb.toString(), params);
		return result.isEmpty() ? null : result.get(0);
	}

	@Override
	public Privilege findByRoleIdAndUri(String authority, String requestURI) {
		StringBuffer sb = new StringBuffer(
				"select model from Privilege model , Function function where function.id = model.functionId ");
		Map<String, Object> params = new HashMap<String, Object>();
		if (StringUtils.isNotBlank(authority) && StringUtils.isNumeric(authority)) {
			sb.append(" and model.roleId = :authority ");
			params.put("authority", Long.valueOf(authority));
		}

		if (StringUtils.isNotBlank(requestURI)) {
			sb.append(" and function.uri = :uri ");
			params.put("uri", requestURI);
		}
		List<Privilege> resultList = queryByJpql(sb.toString(), params);
		return resultList.isEmpty() ? null : resultList.get(0);
	}

	@Override
	public Privilege findByRoleIdAndFunctionId(Long authority, Long functionId) {
		StringBuffer sb = new StringBuffer("select model from Privilege model  where 1=1 ");
		Map<String, Object> params = new HashMap<String, Object>();
		if (authority != null) {
			sb.append(" and model.roleId = :roleId ");
			params.put("roleId", authority);
		}
		if (functionId != null) {
			sb.append(" and model.functionId = :functionId ");
			params.put("functionId", functionId);
		}
		List<Privilege> result = queryByJpql(sb.toString(), params);
		return result.isEmpty() ? null : result.get(0);
	}

}