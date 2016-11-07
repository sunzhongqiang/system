package com.mmk.trade.service;

import java.util.List;
import com.mmk.gene.service.BaseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.mmk.trade.model.Tuan;
import com.mmk.trade.condition.TuanCondition;

/**
* TuanService: 拼团管理 业务服务层接口
*2016-11-07 10:36:33
*@author huguangling 胡广玲
*@version 1.0
*/
public interface TuanService extends BaseService<Tuan, Long> {
    /**
     * 生成的列表分页查询方法
     * @param tuanCondition  查询条件
     * @param pageable 分页参数
     * @return 分页返回查询的结果
     * @author huguangling 胡广玲
     * 
     */
    Page<Tuan> list(TuanCondition tuanCondition, Pageable pageable);
    
    /**
     * 不分页查询相关信息，根据传入的model类对象取得查询结果集List
     * @param  tuan 查询类
     * @return 查询的结果集
     * @author huguangling 胡广玲
     * 
     */
    public List<Tuan> list(TuanCondition tuan);

    /**
     * 是否存在该
     * @param orderId 订单ID
     * @return 如果存在的话返回true ,没有的返回false
     * @author huguangling 胡广玲
     * 
     */
    boolean existsOrderId(Long orderId);
    /**
     * 根据给定的字段返回符合的对象
     * @param orderId 订单ID
     * @return 符合条件的唯一对象
     * @author huguangling 胡广玲
     * 
     */
    Tuan findByOrderId(Long orderId);
    /**
     * 根据字段获取所有符合的记录
     * @param orderId 订单ID
     * @return 符合条件的所有对象
     * @author huguangling 胡广玲
     * 
     */
    List<Tuan> findAllByOrderId(Long orderId);
    /**
     * 根据字段获取所有符合的记录
     * @param orderId 订单ID
     * @param pageable 分页参数
     * @return 符合条件的所有对象
     * @author huguangling 胡广玲
     * 
     */
    Page<Tuan> findAllByOrderId(Long orderId, Pageable pageable);
    /**
     * 根据给定的字段和属性值，获得符合条件的第一个结果
     * @param field Tuan 中的某个字段
     * @param value 字段的值
     * @return Tuan 返回符合条件的结果，如果没有返回null
     * @author huguangling 胡广玲
     * 
     * 
     */
    Tuan findBy(String field,Object value);
    
    /**
     * 根据给定的字段和属性值，获得符合条件的所有结果
     * @param field Tuan中的某个字段
     * @param value 字段的值
     * @return 返回符合条件的所有结果
     * @author huguangling 胡广玲
     * 
     * 
     */
    List<Tuan> findAllBy(String field,Object value);
}