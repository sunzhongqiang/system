package com.mmk.system.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mmk.common.model.Tree;
import com.mmk.gene.service.BaseService;
import com.mmk.system.condition.UserRoleCondition;
import com.mmk.system.model.UserRole;

/**
* UserRoleService: 系统用户角色 业务服务层接口
*2016-10-27 08:21:19
*@author code
*@version 1.0
*/
public interface UserRoleService extends BaseService<UserRole, Long> {
    /**
     * 生成的列表分页查询方法
     * @param userRoleCondition  查询条件
     * @param pageable 分页参数
     * @return 分页返回查询的结果
     * @author code
     * 
     */
    Page<UserRole> list(UserRoleCondition userRoleCondition, Pageable pageable);
    
    /**
     * 不分页查询相关信息，根据传入的model类对象取得查询结果集List
     * @param  userRole 查询类
     * @return 查询的结果集
     * @author code
     * 
     */
    public List<UserRole> list(UserRoleCondition userRole);

    /**
     * 根据字段获取所有符合的记录
     * @param userId 用户主键
     * @return 符合条件的所有对象
     * @author code
     * 
     */
    List<UserRole> findAllByUserId(Long userId);
    /**
     * 根据字段获取所有符合的记录
     * @param userId 用户主键
     * @param pageable 分页参数
     * @return 符合条件的所有对象
     * @author code
     * 
     */
    Page<UserRole> findAllByUserId(Long userId, Pageable pageable);
    /**
     * 根据字段获取所有符合的记录
     * @param roleId 角色主键
     * @return 符合条件的所有对象
     * @author code
     * 
     */
    List<UserRole> findAllByRoleId(Long roleId);
    /**
     * 根据字段获取所有符合的记录
     * @param roleId 角色主键
     * @param pageable 分页参数
     * @return 符合条件的所有对象
     * @author code
     * 
     */
    Page<UserRole> findAllByRoleId(Long roleId, Pageable pageable);
    /**
     * 根据给定的字段和属性值，获得符合条件的第一个结果
     * @param field UserRole 中的某个字段
     * @param value 字段的值
     * @return UserRole 返回符合条件的结果，如果没有返回null
     * @author code
     * 
     * 
     */
    UserRole findBy(String field,Object value);
    
    /**
     * 根据给定的字段和属性值，获得符合条件的所有结果
     * @param field UserRole中的某个字段
     * @param value 字段的值
     * @return 返回符合条件的所有结果
     * @author code
     * 
     * 
     */
    List<UserRole> findAllBy(String field,Object value);

    /**
     * 根据给定的字段和属性值，获取符合条件的所有字段
     * @param userId
     * @return userRole
     */
    List<Tree> findRoleListByUserId(Long userId);

    /**
     * 根据给定的字段和属性值，获取符合条件的所有字段
     * @param userId
     * @param roleId
     * @return 用户角色
     */
	UserRole findByUserIdAndRoleId(Long userId, Long roleId);
}