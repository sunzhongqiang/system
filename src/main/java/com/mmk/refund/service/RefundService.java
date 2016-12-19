package com.mmk.refund.service;

import java.util.List;
import com.mmk.gene.service.BaseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.mmk.refund.model.Refund;
import com.mmk.refund.condition.RefundCondition;

/**
* RefundService: 退款表 业务服务层接口
*2016-11-14 13:17:40
*@author huguangling 胡广玲
*@version 1.0
*/
public interface RefundService extends BaseService<Refund, Long> {
    /**
     * 生成的列表分页查询方法
     * @param refundCondition  查询条件
     * @param pageable 分页参数
     * @return 分页返回查询的结果
     * @author huguangling 胡广玲
     * 
     */
    Page<Refund> list(RefundCondition refundCondition, Pageable pageable);
    
    /**
     * 不分页查询相关信息，根据传入的model类对象取得查询结果集List
     * @param  refund 查询类
     * @return 查询的结果集
     * @author huguangling 胡广玲
     * 
     */
    public List<Refund> list(RefundCondition refund);

    /**
     * 根据给定的字段和属性值，获得符合条件的第一个结果
     * @param field Refund 中的某个字段
     * @param value 字段的值
     * @return Refund 返回符合条件的结果，如果没有返回null
     * @author huguangling 胡广玲
     * 
     * 
     */
    Refund findBy(String field,Object value);
    
    /**
     * 根据给定的字段和属性值，获得符合条件的所有结果
     * @param field Refund中的某个字段
     * @param value 字段的值
     * @return 返回符合条件的所有结果
     * @author huguangling 胡广玲
     * 
     * 
     */
    List<Refund> findAllBy(String field,Object value);

    /**
     * 根据给定的字段和属性值，获得符合条件的所有结果
     * @param field Refund中的某个字段
     * @param value 字段的值
     * @return 返回符合条件的所有结果
     * @author huguangling 胡广玲
     * 
     * 
     */
    Refund findByOrderID(Long id);

    /**
     * 根据订单id进行退款
     * @param id 订单id
     * @return 成功和失败
     */
	boolean refundByOrderId(Long id);
}