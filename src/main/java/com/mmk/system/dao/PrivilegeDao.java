/*
 * 
 *  PrivilegeDao 创建于 2016-10-25 09:35:10 版权归作者和作者当前组织所有
 */
package com.mmk.system.dao;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mmk.gene.dao.SpringDataQueryDao;
import com.mmk.system.condition.PrivilegeCondition;
import com.mmk.system.model.Privilege;

/**
 * PrivilegeDao:系统权限表 数据持久层接口
 * 
 * @author
 * @version 1.0
 */
public interface PrivilegeDao extends SpringDataQueryDao<Privilege> {

	/**
	 * 分页查询相关信息，根据传入的bean类对象和分页对象page取得查询结果集List
	 * 
	 * @param privilege 查询类
	 * @param pageable 传入的分页对象
	 * @return 符合条件的查询结果集
	 * @author
	 * 
	 * 
	 */
	Page<Privilege> list(PrivilegeCondition privilege, Pageable pageable);

	/**
	 * 不分页查询相关信息，根据传入的model类对象取得查询结果集List
	 * 
	 * @param privilege 查询类
	 * @return 符合条件的查询结果集
	 * @author
	 * 
	 */
	List<Privilege> list(PrivilegeCondition privilege);

	/**
	 * 使用sql查询，并以map和分页的形式进行返回数据结果
	 * 
	 * @param privilege Privilege类
	 * @param pageable 传入的分页对象
	 * @return 符合条件的查询结果集
	 * @author
	 * 
	 * 
	 */
	Page<Map<String, Object>> listBySql(PrivilegeCondition privilege, Pageable pageable);

	/**
	 * 根据给定的字段和属性值，获得符合条件的第一个结果
	 * 
	 * @param field Privilege 中的某个字段
	 * @param value 字段对应的值
	 * @return 返回符合条件的结果，如果没有返回null
	 * @author
	 * 
	 * 
	 */
	Privilege findBy(String field, Object value);

	/**
	 * 根据给定的字段和属性值，获得符合条件的所有结果
	 * 
	 * @param field Privilege 中的某个字段
	 * @param value 字段对应的值
	 * @return 返回符合条件的所有结果
	 * @author
	 * 
	 * 
	 */
	List<Privilege> findAllBy(String field, Object value);

	/**
	 * 根据给定的角色Id和功能ID，获取符合条件的所有结果
	 * 
	 * @param roleId 角色ID
	 * @param functionId 功能ID
	 * @return 返回符合条件的结果
	 */
	Privilege findByIdAndFunctionID(Long roleId, Long functionId);

	/**
	 * 获取角色的权限
	 * 
	 * @param roleId
	 * @return 用户权限列表
	 */
	List<Map<String, Object>> findRolePrivilege(Long roleId);

	/**
	 * 获取权限
	 * 
	 * @param roleId
	 * @param privilegeID
	 * @return
	 */
	Privilege findByRoleIdAndPrivilegeID(Long roleId, String privilegeID);

	/**
	 * 根据角色id和uri获取权限
	 * 
	 * @param authority 角色id
	 * @param requestURI 功能地址
	 * @return
	 */
	Privilege findByRoleIdAndUri(String authority, String requestURI);

	/**
	 * 根据角色id和uri获取权限
	 * 
	 * @param authority 角色id
	 * @param id 功能地址
	 * @return
	 */
	Privilege findByRoleIdAndFunctionId(Long authority, Long id);

}