package com.mmk.trade.service.impl;

import javax.annotation.Resource;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.mmk.gene.service.impl.BaseServiceImpl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.mmk.trade.dao.ShippingFeeRepository;
import com.mmk.trade.model.ShippingFee;
import com.mmk.trade.condition.ShippingFeeCondition;
import com.mmk.trade.service.ShippingFeeService;
import com.mmk.trade.dao.ShippingFeeDao;
/**
* ShippingFeeServiceImpl: 快递地区运费 业务服务层实现
* 2016-11-26 11:33:42
* @author huguangling 胡广玲
* @version 1.0
*/
@Service
public class ShippingFeeServiceImpl extends BaseServiceImpl<ShippingFee, Long> implements ShippingFeeService {

    private Log log = LogFactory.getLog(this.getClass());
    @Resource
    private ShippingFeeDao shippingFeeDao;
    
    private ShippingFeeRepository shippingFeeRepository;
    /**
    *构造方法
    * @param shippingFeeRepository 数据容器
    */
    @Autowired
    public ShippingFeeServiceImpl( ShippingFeeRepository shippingFeeRepository) {
        super(shippingFeeRepository);
        this.shippingFeeRepository = shippingFeeRepository;
    }

    @Override
    public Page<ShippingFee> list(ShippingFeeCondition shippingFeeCondition, Pageable pageable) {
        log.info("快递地区运费查询列表");
        return shippingFeeDao.list(shippingFeeCondition, pageable);
    }
    
    @Override
    public List<ShippingFee> list(ShippingFeeCondition shippingFeeCondition) {
        log.info("快递地区运费查询列表无分页");
        return shippingFeeDao.list(shippingFeeCondition);
    }

    /**
     * 根据给定的字段返回符合的对象
     * @param id 主键
     * @return 符合条件的唯一对象
     */
    @Override
    public ShippingFee findById(Long id){
         return shippingFeeRepository.findFirstById(id);
    }
    /**
     * 根据字段获取所有符合的记录
     * @param shippingId 配送方式
     * @return 符合条件的所有对象
     */
    @Override
    public List<ShippingFee>  findAllByShippingId(Long shippingId){
        return shippingFeeRepository.findAllByShippingId(shippingId);
    }
    
     @Override
    public Page<ShippingFee>  findAllByShippingId(Long shippingId, Pageable pageable){
        return shippingFeeRepository.findAllByShippingId(shippingId,pageable);
    }
    @Override 
    public ShippingFee findBy(String field,Object value){
        log.info("快递地区运费根据字["+field+"="+value+"] 进行查询符合条件的唯一值");
        return shippingFeeDao.findBy(field,value);
    }
    
    @Override 
    public List<ShippingFee> findAllBy(String field,Object value){
        log.info("快递地区运费根据字["+field+"="+value+"] 进行查询符合条件的所有记录");
        return shippingFeeDao.findAllBy(field,value);
    }
}