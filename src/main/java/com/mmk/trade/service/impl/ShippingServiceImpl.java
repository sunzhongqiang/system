package com.mmk.trade.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mmk.gene.service.impl.BaseServiceImpl;
import com.mmk.trade.condition.ShippingCondition;
import com.mmk.trade.dao.ShippingDao;
import com.mmk.trade.dao.ShippingRepository;
import com.mmk.trade.model.Shipping;
import com.mmk.trade.service.ShippingService;
/**
* ShippingServiceImpl: 物流管理 业务服务层实现
* 2016-11-10 09:13:33
* @author huguangling 胡广玲
* @version 1.0
*/
@Service
public class ShippingServiceImpl extends BaseServiceImpl<Shipping, Long> implements ShippingService {

    private Log log = LogFactory.getLog(this.getClass());
    @Resource
    private ShippingDao shippingDao;
    
    private ShippingRepository shippingRepository;
    /**
    *构造方法
    * @param shippingRepository 数据容器
    */
    @Autowired
    public ShippingServiceImpl( ShippingRepository shippingRepository) {
        super(shippingRepository);
        this.shippingRepository = shippingRepository;
    }

    @Override
    public Page<Shipping> list(ShippingCondition shippingCondition, Pageable pageable) {
        log.info("物流管理查询列表");
        return shippingDao.list(shippingCondition, pageable);
    }
    
    @Override
    public List<Shipping> list(ShippingCondition shippingCondition) {
        log.info("物流管理查询列表无分页");
        return shippingDao.list(shippingCondition);
    }

    /**
     * 根据给定的字段返回符合的对象
     * @param id 主键
     * @return 符合条件的唯一对象
     */
    @Override
    public Shipping findById(Long id){
         return shippingRepository.findFirstById(id);
    }
    /**
     * 根据字段获取所有符合的记录
     * @param id 主键
     * @return 符合条件的所有对象
     */
    @Override
    public List<Shipping>  findAllById(Long id){
        return shippingRepository.findAllById(id);
    }
    
     @Override
    public Page<Shipping>  findAllById(Long id, Pageable pageable){
        return shippingRepository.findAllById(id,pageable);
    }
    @Override 
    public Shipping findBy(String field,Object value){
        log.info("物流管理根据字["+field+"="+value+"] 进行查询符合条件的唯一值");
        return shippingDao.findBy(field,value);
    }
    
    @Override 
    public List<Shipping> findAllBy(String field,Object value){
        log.info("物流管理根据字["+field+"="+value+"] 进行查询符合条件的所有记录");
        return shippingDao.findAllBy(field,value);
    }

	@Override
	public List<Shipping> find() {
        log.info("查询可以使用的所有快递公司");
        return shippingDao.find();
	}
}