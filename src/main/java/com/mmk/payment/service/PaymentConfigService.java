package com.mmk.payment.service;

import java.util.List;
import com.mmk.gene.service.BaseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.mmk.payment.model.PaymentConfig;
import com.mmk.payment.condition.PaymentConfigCondition;

/**
* PaymentConfigService: 支付配置参数 业务服务层接口
*2016-12-05 11:46:37
*@author 孙中强 sunzhongqiang
*@version 1.0
*/
public interface PaymentConfigService extends BaseService<PaymentConfig, Long> {
    /**
     * 生成的列表分页查询方法
     * @param paymentConfigCondition  查询条件
     * @param pageable 分页参数
     * @return 分页返回查询的结果
     * @author 孙中强 sunzhongqiang
     * 
     */
    Page<PaymentConfig> list(PaymentConfigCondition paymentConfigCondition, Pageable pageable);
    
    /**
     * 不分页查询相关信息，根据传入的model类对象取得查询结果集List
     * @param  paymentConfig 查询类
     * @return 查询的结果集
     * @author 孙中强 sunzhongqiang
     * 
     */
    public List<PaymentConfig> list(PaymentConfigCondition paymentConfig);

    /**
     * 根据给定的字段和属性值，获得符合条件的第一个结果
     * @param field PaymentConfig 中的某个字段
     * @param value 字段的值
     * @return PaymentConfig 返回符合条件的结果，如果没有返回null
     * @author 孙中强 sunzhongqiang
     * 
     * 
     */
    PaymentConfig findBy(String field,Object value);
    
    /**
     * 根据给定的字段和属性值，获得符合条件的所有结果
     * @param field PaymentConfig中的某个字段
     * @param value 字段的值
     * @return 返回符合条件的所有结果
     * @author 孙中强 sunzhongqiang
     * 
     * 
     */
    List<PaymentConfig> findAllBy(String field,Object value);
}