package com.mmk.payment.service.impl;

import javax.annotation.Resource;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.mmk.gene.service.impl.BaseServiceImpl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.mmk.payment.dao.PaymentRepository;
import com.mmk.payment.model.Payment;
import com.mmk.payment.condition.PaymentCondition;
import com.mmk.payment.service.PaymentService;
import com.mmk.payment.dao.PaymentDao;
/**
* PaymentServiceImpl: 支付方式 业务服务层实现
* 2016-12-05 11:28:29
* @author 孙中强 sunzhongqiang
* @version 1.0
*/
@Service
public class PaymentServiceImpl extends BaseServiceImpl<Payment, Long> implements PaymentService {

    private Log log = LogFactory.getLog(this.getClass());
    @Resource
    private PaymentDao paymentDao;
    
    private PaymentRepository paymentRepository;
    /**
    *构造方法
    * @param paymentRepository 数据容器
    */
    @Autowired
    public PaymentServiceImpl( PaymentRepository paymentRepository) {
        super(paymentRepository);
        this.paymentRepository = paymentRepository;
    }

    @Override
    public Page<Payment> list(PaymentCondition paymentCondition, Pageable pageable) {
        log.info("支付方式查询列表");
        return paymentDao.list(paymentCondition, pageable);
    }
    
    @Override
    public List<Payment> list(PaymentCondition paymentCondition) {
        log.info("支付方式查询列表无分页");
        return paymentDao.list(paymentCondition);
    }

    @Override 
    public Payment findBy(String field,Object value){
        log.info("支付方式根据字["+field+"="+value+"] 进行查询符合条件的唯一值");
        return paymentDao.findBy(field,value);
    }
    
    @Override 
    public List<Payment> findAllBy(String field,Object value){
        log.info("支付方式根据字["+field+"="+value+"] 进行查询符合条件的所有记录");
        return paymentDao.findAllBy(field,value);
    }
}