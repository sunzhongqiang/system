package com.mmk.system.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mmk.gene.service.BaseService;
import com.mmk.system.condition.OperationLogCondition;
import com.mmk.system.model.OperationLog;

/**
* OperationLogService: 系统操作日志 业务服务层接口
*2016-10-22 12:17:33
*@author 孙中强
*@version 1.0
*/
public interface OperationLogService extends BaseService<OperationLog, Long> {
    /**
     * 生成的列表分页查询方法
     * @param operationLogCondition  查询条件
     * @param pageable 分页参数
     * @return 分页返回查询的结果
     * @author 孙中强
     * 
     */
    Page<OperationLog> list(OperationLogCondition operationLogCondition, Pageable pageable);
    
    /**
     * 不分页查询相关信息，根据传入的model类对象取得查询结果集List
     * @param  operationLog 查询类
     * @return 查询的结果集
     * @author 孙中强
     * 
     */
    public List<OperationLog> list(OperationLogCondition operationLog);

    /**
     * 根据给定的字段和属性值，获得符合条件的第一个结果
     * @param field OperationLog 中的某个字段
     * @param value 字段的值
     * @return OperationLog 返回符合条件的结果，如果没有返回null
     * @author 孙中强
     * 
     * 
     */
    OperationLog findBy(String field,Object value);
    
    /**
     * 根据给定的字段和属性值，获得符合条件的所有结果
     * @param field OperationLog中的某个字段
     * @param value 字段的值
     * @return 返回符合条件的所有结果
     * @author 孙中强
     * 
     * 
     */
    List<OperationLog> findAllBy(String field,Object value);
}