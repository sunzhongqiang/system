package com.mmk.refund.service;

import java.util.List;
import com.mmk.gene.service.BaseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.mmk.refund.model.Refund;
import com.mmk.refund.condition.RefundCondition;

/**
* RefundService: 退款表 业务服务层接口
*2016-11-14 13:07:10
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
     * 根据给定的字段返回符合的对象
     * @param id ID
     * @return 符合条件的唯一对象
     * @author huguangling 胡广玲
     * 
     */
    Refund findById(Long id);
    /**
     * 根据给定的字段返回符合的对象
     * @param goodsId 商品编号
     * @return 符合条件的唯一对象
     * @author huguangling 胡广玲
     * 
     */
    Refund findByGoodsId(Long goodsId);
    /**
     * 根据字段获取所有符合的记录
     * @param refundNo 退款编号
     * @return 符合条件的所有对象
     * @author huguangling 胡广玲
     * 
     */
    List<Refund> findAllByRefundNo(String refundNo);
    /**
     * 根据字段获取所有符合的记录
     * @param refundNo 退款编号
     * @param pageable 分页参数
     * @return 符合条件的所有对象
     * @author huguangling 胡广玲
     * 
     */
    Page<Refund> findAllByRefundNo(String refundNo, Pageable pageable);
    /**
     * 根据字段获取所有符合的记录
     * @param refundStatus 退款状态
     * @return 符合条件的所有对象
     * @author huguangling 胡广玲
     * 
     */
    List<Refund> findAllByRefundStatus(String refundStatus);
    /**
     * 根据字段获取所有符合的记录
     * @param refundStatus 退款状态
     * @param pageable 分页参数
     * @return 符合条件的所有对象
     * @author huguangling 胡广玲
     * 
     */
    Page<Refund> findAllByRefundStatus(String refundStatus, Pageable pageable);
    /**
     * 根据字段获取所有符合的记录
     * @param hasGoodsReturn 退款退货类型0-退款1-退货
     * @return 符合条件的所有对象
     * @author huguangling 胡广玲
     * 
     */
    List<Refund> findAllByHasGoodsReturn(String hasGoodsReturn);
    /**
     * 根据字段获取所有符合的记录
     * @param hasGoodsReturn 退款退货类型0-退款1-退货
     * @param pageable 分页参数
     * @return 符合条件的所有对象
     * @author huguangling 胡广玲
     * 
     */
    Page<Refund> findAllByHasGoodsReturn(String hasGoodsReturn, Pageable pageable);
    /**
     * 根据字段获取所有符合的记录
     * @param reason 退款原因
     * @return 符合条件的所有对象
     * @author huguangling 胡广玲
     * 
     */
    List<Refund> findAllByReason(String reason);
    /**
     * 根据字段获取所有符合的记录
     * @param reason 退款原因
     * @param pageable 分页参数
     * @return 符合条件的所有对象
     * @author huguangling 胡广玲
     * 
     */
    Page<Refund> findAllByReason(String reason, Pageable pageable);
    /**
     * 根据字段获取所有符合的记录
     * @param sid 物流单号
     * @return 符合条件的所有对象
     * @author huguangling 胡广玲
     * 
     */
    List<Refund> findAllBySid(String sid);
    /**
     * 根据字段获取所有符合的记录
     * @param sid 物流单号
     * @param pageable 分页参数
     * @return 符合条件的所有对象
     * @author huguangling 胡广玲
     * 
     */
    Page<Refund> findAllBySid(String sid, Pageable pageable);
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
}