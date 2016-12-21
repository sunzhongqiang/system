package com.mmk.system.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mmk.gene.service.BaseService;
import com.mmk.system.condition.RoleCondition;
import com.mmk.system.model.Role;

/**
* RoleService: 系统角色 业务服务层接口
*2016-10-24 14:26:41
*@author huguangling 胡广玲
*@version 1.0
*/
public interface RoleService extends BaseService<Role, Long> {
    /**
     * 生成的列表分页查询方法
     * @param roleCondition  查询条件
     * @param pageable 分页参数
     * @return 分页返回查询的结果
     * @author huguangling 胡广玲
     * 
     */
    Page<Role> list(RoleCondition roleCondition, Pageable pageable);
    
    /**
     * 不分页查询相关信息，根据传入的model类对象取得查询结果集List
     * @param  role 查询类
     * @return 查询的结果集
     * @author huguangling 胡广玲
     * 
     */
    public List<Role> list(RoleCondition role);

    /**
     * 根据给定的字段和属性值，获得符合条件的第一个结果
     * @param field Role 中的某个字段
     * @param value 字段的值
     * @return Role 返回符合条件的结果，如果没有返回null
     * @author huguangling 胡广玲
     * 
     * 
     */
    Role findBy(String field,Object value);
    
    /**
     * 根据给定的字段和属性值，获得符合条件的所有结果
     * @param field Role中的某个字段
     * @param value 字段的值
     * @return 返回符合条件的所有结果
     * @author huguangling 胡广玲
     * 
     * 
     */
    List<Role> findAllBy(String field,Object value);
}