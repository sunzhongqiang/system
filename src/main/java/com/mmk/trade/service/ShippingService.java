package com.mmk.trade.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mmk.gene.service.BaseService;
import com.mmk.trade.condition.ShippingCondition;
import com.mmk.trade.model.Shipping;

/**
* ShippingService: 物流管理 业务服务层接口
*2016-11-10 09:13:33
*@author huguangling 胡广玲
*@version 1.0
*/
public interface ShippingService extends BaseService<Shipping, Long> {
    /**
     * 生成的列表分页查询方法
     * @param shippingCondition  查询条件
     * @param pageable 分页参数
     * @return 分页返回查询的结果
     * @author huguangling 胡广玲
     * 
     */
    Page<Shipping> list(ShippingCondition shippingCondition, Pageable pageable);
    
    /**
     * 不分页查询相关信息，根据传入的model类对象取得查询结果集List
     * @param  shipping 查询类
     * @return 查询的结果集
     * @author huguangling 胡广玲
     * 
     */
    public List<Shipping> list(ShippingCondition shipping);

    /**
     * 根据给定的字段返回符合的对象
     * @param id 主键
     * @return 符合条件的唯一对象
     * @author huguangling 胡广玲
     * 
     */
    Shipping findById(Long id);
    /**
     * 根据字段获取所有符合的记录
     * @param id 主键
     * @return 符合条件的所有对象
     * @author huguangling 胡广玲
     * 
     */
    List<Shipping> findAllById(Long id);
    /**
     * 根据字段获取所有符合的记录
     * @param id 主键
     * @param pageable 分页参数
     * @return 符合条件的所有对象
     * @author huguangling 胡广玲
     * 
     */
    Page<Shipping> findAllById(Long id, Pageable pageable);
    /**
     * 根据给定的字段和属性值，获得符合条件的第一个结果
     * @param field Shipping 中的某个字段
     * @param value 字段的值
     * @return Shipping 返回符合条件的结果，如果没有返回null
     * @author huguangling 胡广玲
     * 
     * 
     */
    Shipping findBy(String field,Object value);
    
    /**
     * 根据给定的字段和属性值，获得符合条件的所有结果
     * @param field Shipping中的某个字段
     * @param value 字段的值
     * @return 返回符合条件的所有结果
     * @author huguangling 胡广玲
     * 
     * 
     */
    List<Shipping> findAllBy(String field,Object value);

    /**
     * 根据给定的字段和属性值，获得符合条件的所有结果
     * @return 返回符合条件的所有结果
     * @author huguangling 胡广玲
     * 
     * 
     */
    List<Shipping> find();
}