/*
 * 
 *  UserDao 创建于 2016-10-12 11:54:22 版权归作者和作者当前组织所有
 */
package com.mmk.system.dao;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mmk.gene.dao.SpringDataQueryDao;
import com.mmk.system.condition.UserCondition;
import com.mmk.system.model.User;

/**
 * UserDao:系统用户 数据持久层接口
 * 
 * @author sunzhongqiang 孙中强
 * @version 1.0 Modified By Modified Date
 */
public interface UserDao extends SpringDataQueryDao<User> {

	/**
	 * 分页查询相关信息，根据传入的bean类对象和分页对象page取得查询结果集List
	 * 
	 * @param user 查询类
	 * @param pageable 传入的分页对象
	 * @return 符合条件的查询结果集
	 * @author sunzhongqiang 孙中强
	 * 
	 * 
	 */
	Page<User> list(UserCondition user, Pageable pageable);

	/**
	 * 不分页查询相关信息，根据传入的model类对象取得查询结果集List
	 * 
	 * @param user 查询类
	 * @return 符合条件的查询结果集
	 * @author sunzhongqiang 孙中强
	 * 
	 */
	List<User> list(UserCondition user);

	/**
	 * 使用sql查询，并以map和分页的形式进行返回数据结果
	 * 
	 * @param user User类
	 * @param pageable 传入的分页对象
	 * @return 符合条件的查询结果集
	 * @author sunzhongqiang 孙中强
	 * 
	 * 
	 */
	Page<Map<String, Object>> listBySql(UserCondition user, Pageable pageable);

	/**
	 * 根据给定的字段和属性值，获得符合条件的第一个结果
	 * 
	 * @param field User 中的某个字段
	 * @param value 字段对应的值
	 * @return 返回符合条件的结果，如果没有返回null
	 * @author sunzhongqiang 孙中强
	 * 
	 * 
	 */
	User findBy(String field, Object value);

	/**
	 * 根据给定的字段和属性值，获得符合条件的所有结果
	 * 
	 * @param field　User 中的某个字段
	 * @param value　字段对应的值
	 * @return 返回符合条件的所有结果
	 * @author sunzhongqiang 孙中强
	 * 
	 * 
	 */
	List<User> findAllBy(String field, Object value);

	/**
	 * 根据用户组织加载用户
	 * 
	 * @param orgId　组织id
	 * @param pageable　分页参数
	 * @return 用户分页
	 */
	Page<User> loadByOrgId(Long orgId, Pageable pageable);

}