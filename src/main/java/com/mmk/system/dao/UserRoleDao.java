/*
 * 
 *  UserRoleDao 创建于 2016-10-27 08:21:19 版权归作者和作者当前组织所有
 */
package com.mmk.system.dao;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mmk.gene.dao.SpringDataQueryDao;
import com.mmk.system.condition.UserRoleCondition;
import com.mmk.system.model.UserRole;
/**
* UserRoleDao:系统用户角色 数据持久层接口
* @author code
* @version 1.0
*/
public interface UserRoleDao extends SpringDataQueryDao<UserRole>{
    
    /**
     * 分页查询相关信息，根据传入的bean类对象和分页对象page取得查询结果集List
     * @param userRole 查询类
     * @param pageable 传入的分页对象
     * @return 符合条件的查询结果集
     * @author code
     * 
     * 
     */
    Page<UserRole> list(UserRoleCondition userRole,Pageable pageable);
    /**
     * 不分页查询相关信息，根据传入的model类对象取得查询结果集List
     * @param userRole 查询类
     * @return 符合条件的查询结果集
     * @author code
     * 
     */
    List<UserRole> list(UserRoleCondition userRole);
    /**
     * 使用sql查询，并以map和分页的形式进行返回数据结果
     * @param userRole UserRole类
     * @param pageable 传入的分页对象
     * @return 符合条件的查询结果集
     * @author code
     * 
     * 
     */
    Page<Map<String,Object>> listBySql(UserRoleCondition userRole,Pageable pageable);
    /**
     * 根据给定的字段和属性值，获得符合条件的第一个结果
     * @param field UserRole 中的某个字段
     * @param value 字段对应的值
     * @return 返回符合条件的结果，如果没有返回null
     * @author code
     * 
     * 
     */
    UserRole findBy(String field,Object value);
    
    /**
     * 根据给定的字段和属性值，获得符合条件的所有结果
     * @param field UserRole 中的某个字段
     * @param value 字段对应的值
     * @return 返回符合条件的所有结果
     * @author code
     * 
     * 
     */
    List<UserRole> findAllBy(String field,Object value);
    /**
     * 根据给定的字段和属性值，获得符合条件的所有结果
     * @param userId
     * @return 角色
     */
	List<Map<String, Object>> findRoleListByUserId(Long userId);
	
	/**
	 * 根据给定的字段和属性值，获得符合条件的所有结果
	 * @param userId
	 * @param roleId
	 * @return 用户角色
	 */
	UserRole findByUserIdAndRoleId(Long userId, Long roleId);
	
}