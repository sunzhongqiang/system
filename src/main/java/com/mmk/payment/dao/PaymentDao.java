/*
 * 
 *  PaymentDao 创建于 2016-12-05 11:56:57 版权归作者和作者当前组织所有
 */
package com.mmk.payment.dao;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mmk.gene.dao.SpringDataQueryDao;
import com.mmk.payment.condition.PaymentCondition;
import com.mmk.payment.model.Payment;
/**
* PaymentDao:支付方式 数据持久层接口
* @author 孙中强 sunzhongqiang
* @version 1.0
*/
public interface PaymentDao extends SpringDataQueryDao<Payment>{
    
    /**
     * 分页查询相关信息，根据传入的bean类对象和分页对象page取得查询结果集List
     * @param payment 查询类
     * @param pageable 传入的分页对象
     * @return 符合条件的查询结果集
     * @author 孙中强 sunzhongqiang
     * 
     * 
     */
    Page<Payment> list(PaymentCondition payment,Pageable pageable);
    /**
     * 不分页查询相关信息，根据传入的model类对象取得查询结果集List
     * @param payment 查询类
     * @return 符合条件的查询结果集
     * @author 孙中强 sunzhongqiang
     * 
     */
    List<Payment> list(PaymentCondition payment);
    /**
     * 使用sql查询，并以map和分页的形式进行返回数据结果
     * @param payment Payment类
     * @param pageable 传入的分页对象
     * @return 符合条件的查询结果集
     * @author 孙中强 sunzhongqiang
     * 
     * 
     */
    Page<Map<String,Object>> listBySql(PaymentCondition payment,Pageable pageable);
    /**
     * 根据给定的字段和属性值，获得符合条件的第一个结果
     * @param field Payment 中的某个字段
     * @param value 字段对应的值
     * @return 返回符合条件的结果，如果没有返回null
     * @author 孙中强 sunzhongqiang
     * 
     * 
     */
    Payment findBy(String field,Object value);
    
    /**
     * 根据给定的字段和属性值，获得符合条件的所有结果
     * @param field Payment 中的某个字段
     * @param value 字段对应的值
     * @return 返回符合条件的所有结果
     * @author 孙中强 sunzhongqiang
     * 
     * 
     */
    List<Payment> findAllBy(String field,Object value);
    
    

}