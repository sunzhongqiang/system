package com.mmk.refund.service.impl;

import javax.annotation.Resource;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.mmk.gene.service.impl.BaseServiceImpl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.mmk.refund.dao.RefundRepository;
import com.mmk.refund.model.Refund;
import com.mmk.refund.condition.RefundCondition;
import com.mmk.refund.service.RefundService;
import com.mmk.refund.dao.RefundDao;
/**
* RefundServiceImpl: 退款表 业务服务层实现
* 2016-11-14 13:07:10
* @author huguangling 胡广玲
* @version 1.0
*/
@Service
public class RefundServiceImpl extends BaseServiceImpl<Refund, Long> implements RefundService {

    private Log log = LogFactory.getLog(this.getClass());
    @Resource
    private RefundDao refundDao;
    
    private RefundRepository refundRepository;
    /**
    *构造方法
    * @param refundRepository 数据容器
    */
    @Autowired
    public RefundServiceImpl( RefundRepository refundRepository) {
        super(refundRepository);
        this.refundRepository = refundRepository;
    }

    @Override
    public Page<Refund> list(RefundCondition refundCondition, Pageable pageable) {
        log.info("退款表查询列表");
        return refundDao.list(refundCondition, pageable);
    }
    
    @Override
    public List<Refund> list(RefundCondition refundCondition) {
        log.info("退款表查询列表无分页");
        return refundDao.list(refundCondition);
    }

    /**
     * 根据给定的字段返回符合的对象
     * @param id ID
     * @return 符合条件的唯一对象
     */
    @Override
    public Refund findById(Long id){
         return refundRepository.findFirstById(id);
    }
    /**
     * 根据给定的字段返回符合的对象
     * @param goodsId 商品编号
     * @return 符合条件的唯一对象
     */
    @Override
    public Refund findByGoodsId(Long goodsId){
         return refundRepository.findFirstByGoodsId(goodsId);
    }
    /**
     * 根据字段获取所有符合的记录
     * @param refundNo 退款编号
     * @return 符合条件的所有对象
     */
    @Override
    public List<Refund>  findAllByRefundNo(String refundNo){
        return refundRepository.findAllByRefundNo(refundNo);
    }
    
     @Override
    public Page<Refund>  findAllByRefundNo(String refundNo, Pageable pageable){
        return refundRepository.findAllByRefundNo(refundNo,pageable);
    }
    /**
     * 根据字段获取所有符合的记录
     * @param refundStatus 退款状态
     * @return 符合条件的所有对象
     */
    @Override
    public List<Refund>  findAllByRefundStatus(String refundStatus){
        return refundRepository.findAllByRefundStatus(refundStatus);
    }
    
     @Override
    public Page<Refund>  findAllByRefundStatus(String refundStatus, Pageable pageable){
        return refundRepository.findAllByRefundStatus(refundStatus,pageable);
    }
    /**
     * 根据字段获取所有符合的记录
     * @param hasGoodsReturn 退款退货类型0-退款1-退货
     * @return 符合条件的所有对象
     */
    @Override
    public List<Refund>  findAllByHasGoodsReturn(String hasGoodsReturn){
        return refundRepository.findAllByHasGoodsReturn(hasGoodsReturn);
    }
    
     @Override
    public Page<Refund>  findAllByHasGoodsReturn(String hasGoodsReturn, Pageable pageable){
        return refundRepository.findAllByHasGoodsReturn(hasGoodsReturn,pageable);
    }
    /**
     * 根据字段获取所有符合的记录
     * @param reason 退款原因
     * @return 符合条件的所有对象
     */
    @Override
    public List<Refund>  findAllByReason(String reason){
        return refundRepository.findAllByReason(reason);
    }
    
     @Override
    public Page<Refund>  findAllByReason(String reason, Pageable pageable){
        return refundRepository.findAllByReason(reason,pageable);
    }
    /**
     * 根据字段获取所有符合的记录
     * @param sid 物流单号
     * @return 符合条件的所有对象
     */
    @Override
    public List<Refund>  findAllBySid(String sid){
        return refundRepository.findAllBySid(sid);
    }
    
     @Override
    public Page<Refund>  findAllBySid(String sid, Pageable pageable){
        return refundRepository.findAllBySid(sid,pageable);
    }
    @Override 
    public Refund findBy(String field,Object value){
        log.info("退款表根据字["+field+"="+value+"] 进行查询符合条件的唯一值");
        return refundDao.findBy(field,value);
    }
    
    @Override 
    public List<Refund> findAllBy(String field,Object value){
        log.info("退款表根据字["+field+"="+value+"] 进行查询符合条件的所有记录");
        return refundDao.findAllBy(field,value);
    }
}