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
import com.mmk.refund.dao.RefundActionRepository;
import com.mmk.refund.model.RefundAction;
import com.mmk.refund.condition.RefundActionCondition;
import com.mmk.refund.service.RefundActionService;
import com.mmk.refund.dao.RefundActionDao;
/**
* RefundActionServiceImpl: 操作表 业务服务层实现
* 2016-11-14 13:32:01
* @author huguangling 胡广玲
* @version 1.0
*/
@Service
public class RefundActionServiceImpl extends BaseServiceImpl<RefundAction, Long> implements RefundActionService {

    private Log log = LogFactory.getLog(this.getClass());
    @Resource
    private RefundActionDao refundActionDao;
    
    private RefundActionRepository refundActionRepository;
    /**
    *构造方法
    * @param refundActionRepository 数据容器
    */
    @Autowired
    public RefundActionServiceImpl( RefundActionRepository refundActionRepository) {
        super(refundActionRepository);
        this.refundActionRepository = refundActionRepository;
    }

    @Override
    public Page<RefundAction> list(RefundActionCondition refundActionCondition, Pageable pageable) {
        log.info("操作表查询列表");
        return refundActionDao.list(refundActionCondition, pageable);
    }
    
    @Override
    public List<RefundAction> list(RefundActionCondition refundActionCondition) {
        log.info("操作表查询列表无分页");
        return refundActionDao.list(refundActionCondition);
    }

    @Override 
    public RefundAction findBy(String field,Object value){
        log.info("操作表根据字["+field+"="+value+"] 进行查询符合条件的唯一值");
        return refundActionDao.findBy(field,value);
    }
    
    @Override 
    public List<RefundAction> findAllBy(String field,Object value){
        log.info("操作表根据字["+field+"="+value+"] 进行查询符合条件的所有记录");
        return refundActionDao.findAllBy(field,value);
    }
}