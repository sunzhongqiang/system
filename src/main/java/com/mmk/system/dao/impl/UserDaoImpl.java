/*
 * 
 *  UserDaoImpl 创建于 2016-10-12 11:54:22 版权归作者和作者当前组织所有
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
import com.mmk.system.condition.UserCondition;
import com.mmk.system.dao.UserDao;
import com.mmk.system.model.User;
import com.mmk.tool.SqlStringTool;

/**
 * UserDaoImpl: 系统用户 数据持久层接口实现
 * 
 * @author sunzhongqiang 孙中强
 * @version 1.0
 *
 */
@Repository
public class UserDaoImpl extends SpringDataQueryDaoImpl<User> implements UserDao {

	private Log log = LogFactory.getLog(this.getClass());

	public UserDaoImpl() {
		super(User.class);
	}

	/**
	 * 分页查询相关信息，根据传入的bean类对象和分页对象page取得查询结果集List
	 * 
	 * @param userCondition 查询类
	 * @param pageable 传入的分页对象
	 * @return 符合条件的查询结果集
	 * @author sunzhongqiang 孙中强
	 * 
	 */
	@Override
	public Page<User> list(UserCondition userCondition, Pageable pageable) {
		StringBuffer sb = new StringBuffer("select model from User model left join fetch model.organization  where 1=1  ");
		Map<String, Object> params = new HashMap<String, Object>();
		if (userCondition.getId() != null) {
			sb.append(" and model.id = :id ");
			params.put("id", userCondition.getId());
		}
		if (StringUtils.isNotBlank(userCondition.getUsername())) {
			sb.append(" and model.username like :username ");
			params.put("username", SqlStringTool.anyMatch(userCondition.getUsername()));
		}
		if (StringUtils.isNotBlank(userCondition.getRealname())) {
			sb.append(" and model.realname like :realname ");
			params.put("realname", SqlStringTool.anyMatch(userCondition.getRealname()));
		}
		if (StringUtils.isNotBlank(userCondition.getStatus())) {
			sb.append(" and model.status = :status ");
			params.put("status", userCondition.getRealname());
		}
		if (userCondition.getCreateTime() != null) {
			sb.append(" and model.createTime = :createTime ");
			params.put("createTime", userCondition.getCreateTime());
		}
		if (userCondition.getModifiedTime() != null) {
			sb.append(" and model.modifiedTime = :modifiedTime ");
			params.put("modifiedTime", userCondition.getModifiedTime());
		}
		return queryByJpql(sb.toString(), params, pageable);
	}

	@Override
	public List<User> list(UserCondition userCondition) {
		StringBuffer sb = new StringBuffer("select model from User model  where 1=1  ");
		Map<String, Object> params = new HashMap<String, Object>();
		if (userCondition.getId() != null) {
			sb.append(" and model.id = :id ");
			params.put("id", userCondition.getId());
		}
		if (userCondition.getCreateTime() != null) {
			sb.append(" and model.createTime = :createTime ");
			params.put("createTime", userCondition.getCreateTime());
		}
		if (userCondition.getModifiedTime() != null) {
			sb.append(" and model.modifiedTime = :modifiedTime ");
			params.put("modifiedTime", userCondition.getModifiedTime());
		}
		return queryByJpql(sb.toString(), params);
	}

	@Override
	public Page<Map<String, Object>> listBySql(UserCondition condition, Pageable pageable) {
		StringBuffer sb = new StringBuffer(
				"select id,username,password,realname,status,description,create_time,modified_time from system_user  where 1=1  ");
		Map<Integer, Object> params = new HashMap<Integer, Object>();
		if (condition.getId() != null) {
			sb.append(" and id = ?1 ");
			params.put(1, condition.getId());
		}
		if (condition.getCreateTime() != null) {
			sb.append(" and create_time = ?7 ");
			params.put(7, condition.getCreateTime());
		}
		if (condition.getModifiedTime() != null) {
			sb.append(" and modified_time = ?8 ");
			params.put(8, condition.getModifiedTime());
		}
		return queryFieldsBySql(sb.toString(), params, pageable);
	}

	@Override
	public User findBy(String field, Object value) {
		StringBuffer sb = new StringBuffer("select model from User model  where model.");
		sb.append(field);
		sb.append(" = :value ");
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("value", value);
		List<User> result = queryByJpql(sb.toString(), params, 0l, 1l);
		return result.isEmpty() ? null : result.get(0);
	}

	@Override
	public List<User> findAllBy(String field, Object value) {
		StringBuffer sb = new StringBuffer("select model from User model  where model.");
		sb.append(field);
		sb.append(" = :value ");
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("value", value);
		return queryByJpql(sb.toString(), params);
	}

	@Override
	public Page<User> loadByOrgId(Long orgId, Pageable pageable) {
		StringBuffer sb = new StringBuffer("select model from User model  where 1=1  ");
		Map<String, Object> params = new HashMap<String, Object>();
		if (orgId != null) {
			sb.append(" and model.organization.id = :organizationId ");
			params.put("organizationId", orgId);
		}
		return queryByJpql(sb.toString(), params, pageable);
	}

}