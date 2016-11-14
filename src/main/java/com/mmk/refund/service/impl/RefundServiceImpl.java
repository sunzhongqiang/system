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
* 2016-11-14 13:17:40
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