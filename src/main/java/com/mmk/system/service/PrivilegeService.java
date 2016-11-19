package com.mmk.system.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mmk.common.model.Tree;
import com.mmk.gene.service.BaseService;
import com.mmk.system.condition.PrivilegeCondition;
import com.mmk.system.model.Privilege;

/**
 * PrivilegeService: 系统权限表 业务服务层接口 2016-10-25 09:35:10
 * 
 * @author
 * @version 1.0
 */
public interface PrivilegeService extends BaseService<Privilege, Long> {
	/**
	 * 生成的列表分页查询方法
	 * 
	 * @param privilegeCondition 查询条件
	 * @param pageable 分页参数
	 * @return 分页返回查询的结果
	 * @author
	 * 
	 */
	Page<Privilege> list(PrivilegeCondition privilegeCondition, Pageable pageable);

	/**
	 * 不分页查询相关信息，根据传入的model类对象取得查询结果集List
	 * 
	 * @param privilege 查询类
	 * @return 查询的结果集
	 * @author
	 * 
	 */
	public List<Privilege> list(PrivilegeCondition privilege);

	/**
	 * 根据给定的字段和属性值，获得符合条件的第一个结果
	 * 
	 * @param field Privilege 中的某个字段
	 * @param value 字段的值
	 * @return Privilege 返回符合条件的结果，如果没有返回null
	 * @author
	 * 
	 * 
	 */
	Privilege findBy(String field, Object value);

	/**
	 * 根据给定的字段和属性值，获得符合条件的所有结果
	 * 
	 * @param field  Privilege中的某个字段
	 * @param value 字段的值
	 * @return 返回符合条件的所有结果
	 * @author
	 * 
	 * 
	 */
	List<Privilege> findAllBy(String field, Object value);

	/**
	 * 根据给定的字段和属性值，获得符合条件的所有结果
	 * 
	 * @param field Privilege中的某个字段
	 * @param value 字段的值
	 * @return 返回符合条件的所有结果
	 * @author
	 * 
	 * 
	 */
	Privilege findByIdAndFunctionID(Long roleId, Long functionId);

	/**
	 * 根据给定的字段和属性值，获得符合条件的所有结果
	 * 
	 * @param field Privilege中的某个字段
	 * @param value 字段的值
	 * @return 返回符合条件的所有结果
	 * @author
	 * 
	 * 
	 */
	Privilege findByRoleIdAndPrivilegeID(Long roleId, String privilegeID);

	/**
	 * 根据角色id获取角色功能树
	 * 
	 * @param roleId 角色id
	 * @return 功能树
	 */
	List<Tree> findFunctionTreeByRoleId(Long roleId);

	/**
	 * 检查用户是否拥有权限
	 * 
	 * @param authority
	 * @param requestURI
	 * @return
	 */
	boolean checkRight(Long authority, String requestURI);

}