/*
 * 
 *  RoleDao 创建于 2016-10-24 14:26:41 版权归作者和作者当前组织所有
 */
package com.mmk.system.dao;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mmk.gene.dao.SpringDataQueryDao;
import com.mmk.system.condition.RoleCondition;
import com.mmk.system.model.Role;
/**
* RoleDao:系统角色 数据持久层接口
* @author huguangling 胡广玲
* @version 1.0
*/
public interface RoleDao extends SpringDataQueryDao<Role>{
    
    /**
     * 分页查询相关信息，根据传入的bean类对象和分页对象page取得查询结果集List
     * @param role 查询类
     * @param pageable 传入的分页对象
     * @return 符合条件的查询结果集
     * @author huguangling 胡广玲
     * 
     * 
     */
    Page<Role> list(RoleCondition role,Pageable pageable);
    /**
     * 不分页查询相关信息，根据传入的model类对象取得查询结果集List
     * @param role 查询类
     * @return 符合条件的查询结果集
     * @author huguangling 胡广玲
     * 
     */
    List<Role> list(RoleCondition role);
    /**
     * 使用sql查询，并以map和分页的形式进行返回数据结果
     * @param role Role类
     * @param pageable 传入的分页对象
     * @return 符合条件的查询结果集
     * @author huguangling 胡广玲
     * 
     * 
     */
    Page<Map<String,Object>> listBySql(RoleCondition role,Pageable pageable);
    /**
     * 根据给定的字段和属性值，获得符合条件的第一个结果
     * @param field Role 中的某个字段
     * @param value 字段对应的值
     * @return 返回符合条件的结果，如果没有返回null
     * @author huguangling 胡广玲
     * 
     * 
     */
    Role findBy(String field,Object value);
    
    /**
     * 根据给定的字段和属性值，获得符合条件的所有结果
     * @param field Role 中的某个字段
     * @param value 字段对应的值
     * @return 返回符合条件的所有结果
     * @author huguangling 胡广玲
     * 
     * 
     */
    List<Role> findAllBy(String field,Object value);
    
}