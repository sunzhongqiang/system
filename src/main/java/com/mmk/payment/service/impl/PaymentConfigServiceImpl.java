package com.mmk.payment.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mmk.gene.service.impl.BaseServiceImpl;
import com.mmk.payment.condition.PaymentConfigCondition;
import com.mmk.payment.dao.PaymentConfigDao;
import com.mmk.payment.dao.PaymentConfigRepository;
import com.mmk.payment.model.PaymentConfig;
import com.mmk.payment.service.PaymentConfigService;
/**
* PaymentConfigServiceImpl: 支付配置参数 业务服务层实现
* 2016-12-05 11:57:19
* @author 孙中强 sunzhongqiang
* @version 1.0
*/
@Service
public class PaymentConfigServiceImpl extends BaseServiceImpl<PaymentConfig, Long> implements PaymentConfigService {

    private Log log = LogFactory.getLog(this.getClass());
    @Resource
    private PaymentConfigDao paymentConfigDao;
    
    private PaymentConfigRepository paymentConfigRepository;
    /**
    *构造方法
    * @param paymentConfigRepository 数据容器
    */
    @Autowired
    public PaymentConfigServiceImpl( PaymentConfigRepository paymentConfigRepository) {
        super(paymentConfigRepository);
        this.paymentConfigRepository = paymentConfigRepository;
    }

    @Override
    public Page<PaymentConfig> list(PaymentConfigCondition paymentConfigCondition, Pageable pageable) {
        log.info("支付配置参数查询列表");
        return paymentConfigDao.list(paymentConfigCondition, pageable);
    }
    
    @Override
    public List<PaymentConfig> list(PaymentConfigCondition paymentConfigCondition) {
        log.info("支付配置参数查询列表无分页");
        return paymentConfigDao.list(paymentConfigCondition);
    }

    @Override 
    public PaymentConfig findBy(String field,Object value){
        log.info("支付配置参数根据字["+field+"="+value+"] 进行查询符合条件的唯一值");
        return paymentConfigDao.findBy(field,value);
    }
    
    @Override 
    public List<PaymentConfig> findAllBy(String field,Object value){
        log.info("支付配置参数根据字["+field+"="+value+"] 进行查询符合条件的所有记录");
        return paymentConfigDao.findAllBy(field,value);
    }

	@Override
	public List<PaymentConfig> loadByPaymentId(Long paymentId) {
		log.info("根据支付ID获取支付配置参数查询列表");
        return paymentConfigDao.loadByPaymentId(paymentId);
	}
}