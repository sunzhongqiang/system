package com.mmk.system.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mmk.gene.service.BaseService;
import com.mmk.system.condition.LoginLogCondition;
import com.mmk.system.model.LoginLog;

/**
* LoginLogService: 系统登录日志 业务服务层接口
*2016-10-22 13:46:31
*@author codegenerator
*@version 1.0
*/
public interface LoginLogService extends BaseService<LoginLog, Long> {
    /**
     * 生成的列表分页查询方法
     * @param loginLogCondition  查询条件
     * @param pageable 分页参数
     * @return 分页返回查询的结果
     * @author codegenerator
     * 
     */
    Page<LoginLog> list(LoginLogCondition loginLogCondition, Pageable pageable);
    
    /**
     * 不分页查询相关信息，根据传入的model类对象取得查询结果集List
     * @param  loginLog 查询类
     * @return 查询的结果集
     * @author codegenerator
     * 
     */
    public List<LoginLog> list(LoginLogCondition loginLog);

    /**
     * 根据给定的字段和属性值，获得符合条件的第一个结果
     * @param field LoginLog 中的某个字段
     * @param value 字段的值
     * @return LoginLog 返回符合条件的结果，如果没有返回null
     * @author codegenerator
     * 
     * 
     */
    LoginLog findBy(String field,Object value);
    
    /**
     * 根据给定的字段和属性值，获得符合条件的所有结果
     * @param field LoginLog中的某个字段
     * @param value 字段的值
     * @return 返回符合条件的所有结果
     * @author codegenerator
     * 
     * 
     */
    List<LoginLog> findAllBy(String field,Object value);
}