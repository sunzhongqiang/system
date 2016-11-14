/*
 *  RefundRepository 创建于 2016-11-14 13:07:09 版权归作者和作者当前组织所有
 */
package com.mmk.refund.dao;

import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import com.mmk.refund.model.Refund;

/**
* RefundRepository: 退款表 数据资源层
* 2016-11-14 13:07:09
* @author huguangling 胡广玲
* @version 1.0
*/
public interface RefundRepository extends JpaRepository<Refund, Long>{

    /**
     *  根据给定的字段：id ID返回符合条件的第一个对象
     * @param id ID
     * @return 符合条件的唯一对象
     * @author huguangling 胡广玲
     * 
     */
    Refund findFirstById(Long id);
    /**
     *  根据给定的字段：goodsId 商品编号返回符合条件的第一个对象
     * @param goodsId 商品编号
     * @return 符合条件的唯一对象
     * @author huguangling 胡广玲
     * 
     */
    Refund findFirstByGoodsId(Long goodsId);
    /**
     *  根据给定的字段：refundNo 退款编号获取所有符合的记录
     * @param refundNo 退款编号
     * @return 符合条件的所有对象
     * @author huguangling 胡广玲
     * 
     */
    List<Refund> findAllByRefundNo(String refundNo);
    /**
     *  根据给定的字段：refundNo 退款编号所有符合的记录
     * @param refundNo 退款编号
     * @param pageable 分页参数
     * @return 符合条件的所有对象
     * @author huguangling 胡广玲
     * 
     */
    Page<Refund> findAllByRefundNo(String refundNo,Pageable pageable);
    /**
     *  根据给定的字段：refundStatus 退款状态获取所有符合的记录
     * @param refundStatus 退款状态
     * @return 符合条件的所有对象
     * @author huguangling 胡广玲
     * 
     */
    List<Refund> findAllByRefundStatus(String refundStatus);
    /**
     *  根据给定的字段：refundStatus 退款状态所有符合的记录
     * @param refundStatus 退款状态
     * @param pageable 分页参数
     * @return 符合条件的所有对象
     * @author huguangling 胡广玲
     * 
     */
    Page<Refund> findAllByRefundStatus(String refundStatus,Pageable pageable);
    /**
     *  根据给定的字段：hasGoodsReturn 退款退货类型0-退款1-退货获取所有符合的记录
     * @param hasGoodsReturn 退款退货类型0-退款1-退货
     * @return 符合条件的所有对象
     * @author huguangling 胡广玲
     * 
     */
    List<Refund> findAllByHasGoodsReturn(String hasGoodsReturn);
    /**
     *  根据给定的字段：hasGoodsReturn 退款退货类型0-退款1-退货所有符合的记录
     * @param hasGoodsReturn 退款退货类型0-退款1-退货
     * @param pageable 分页参数
     * @return 符合条件的所有对象
     * @author huguangling 胡广玲
     * 
     */
    Page<Refund> findAllByHasGoodsReturn(String hasGoodsReturn,Pageable pageable);
    /**
     *  根据给定的字段：reason 退款原因获取所有符合的记录
     * @param reason 退款原因
     * @return 符合条件的所有对象
     * @author huguangling 胡广玲
     * 
     */
    List<Refund> findAllByReason(String reason);
    /**
     *  根据给定的字段：reason 退款原因所有符合的记录
     * @param reason 退款原因
     * @param pageable 分页参数
     * @return 符合条件的所有对象
     * @author huguangling 胡广玲
     * 
     */
    Page<Refund> findAllByReason(String reason,Pageable pageable);
    /**
     *  根据给定的字段：sid 物流单号获取所有符合的记录
     * @param sid 物流单号
     * @return 符合条件的所有对象
     * @author huguangling 胡广玲
     * 
     */
    List<Refund> findAllBySid(String sid);
    /**
     *  根据给定的字段：sid 物流单号所有符合的记录
     * @param sid 物流单号
     * @param pageable 分页参数
     * @return 符合条件的所有对象
     * @author huguangling 胡广玲
     * 
     */
    Page<Refund> findAllBySid(String sid,Pageable pageable);

}