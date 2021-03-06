package com.mmk.refund.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mmk.gene.service.BaseService;
import com.mmk.refund.condition.RefundActionCondition;
import com.mmk.refund.model.RefundAction;

/**
* RefundActionService: 操作表 业务服务层接口
*2016-11-14 13:32:01
*@author huguangling 胡广玲
*@version 1.0
*/
public interface RefundActionService extends BaseService<RefundAction, Long> {
    /**
     * 生成的列表分页查询方法
     * @param refundActionCondition  查询条件
     * @param pageable 分页参数
     * @return 分页返回查询的结果
     * @author huguangling 胡广玲
     * 
     */
    Page<RefundAction> list(RefundActionCondition refundActionCondition, Pageable pageable);
    
    /**
     * 不分页查询相关信息，根据传入的model类对象取得查询结果集List
     * @param  refundAction 查询类
     * @return 查询的结果集
     * @author huguangling 胡广玲
     * 
     */
    public List<RefundAction> list(RefundActionCondition refundAction);

    /**
     * 根据给定的字段和属性值，获得符合条件的第一个结果
     * @param field RefundAction 中的某个字段
     * @param value 字段的值
     * @return RefundAction 返回符合条件的结果，如果没有返回null
     * @author huguangling 胡广玲
     * 
     * 
     */
    RefundAction findBy(String field,Object value);
    
    /**
     * 根据给定的字段和属性值，获得符合条件的所有结果
     * @param field RefundAction中的某个字段
     * @param value 字段的值
     * @return 返回符合条件的所有结果
     * @author huguangling 胡广玲
     * 
     * 
     */
    List<RefundAction> findAllBy(String field,Object value);
}