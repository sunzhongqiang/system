package com.mmk.trade.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mmk.gene.service.BaseService;
import com.mmk.trade.condition.ShippingFeeCondition;
import com.mmk.trade.model.ShippingFee;

/**
* ShippingFeeService: 快递地区运费 业务服务层接口
*2016-11-26 11:33:42
*@author huguangling 胡广玲
*@version 1.0
*/
public interface ShippingFeeService extends BaseService<ShippingFee, Long> {
    /**
     * 生成的列表分页查询方法
     * @param shippingFeeCondition  查询条件
     * @param pageable 分页参数
     * @return 分页返回查询的结果
     * @author huguangling 胡广玲
     * 
     */
    Page<ShippingFee> list(ShippingFeeCondition shippingFeeCondition, Pageable pageable);
    
    /**
     * 不分页查询相关信息，根据传入的model类对象取得查询结果集List
     * @param  shippingFee 查询类
     * @return 查询的结果集
     * @author huguangling 胡广玲
     * 
     */
    public List<ShippingFee> list(ShippingFeeCondition shippingFee);

    /**
     * 根据给定的字段返回符合的对象
     * @param id 主键
     * @return 符合条件的唯一对象
     * @author huguangling 胡广玲
     * 
     */
    ShippingFee findById(Long id);
    /**
     * 根据字段获取所有符合的记录
     * @param shippingId 配送方式
     * @return 符合条件的所有对象
     * @author huguangling 胡广玲
     * 
     */
    List<ShippingFee> findAllByShippingId(Long shippingId);
    /**
     * 根据字段获取所有符合的记录
     * @param shippingId 配送方式
     * @param pageable 分页参数
     * @return 符合条件的所有对象
     * @author huguangling 胡广玲
     * 
     */
    Page<ShippingFee> findAllByShippingId(Long shippingId, Pageable pageable);
    /**
     * 根据给定的字段和属性值，获得符合条件的第一个结果
     * @param field ShippingFee 中的某个字段
     * @param value 字段的值
     * @return ShippingFee 返回符合条件的结果，如果没有返回null
     * @author huguangling 胡广玲
     * 
     * 
     */
    ShippingFee findBy(String field,Object value);
    
    /**
     * 根据给定的字段和属性值，获得符合条件的所有结果
     * @param field ShippingFee中的某个字段
     * @param value 字段的值
     * @return 返回符合条件的所有结果
     * @author huguangling 胡广玲
     * 
     * 
     */
    List<ShippingFee> findAllBy(String field,Object value);
}