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
import com.mmk.trade.dao.TuanOrderRepository;
import com.mmk.trade.model.TuanOrder;
import com.mmk.trade.condition.TuanOrderCondition;
import com.mmk.trade.service.TuanOrderService;
import com.mmk.trade.dao.TuanOrderDao;
/**
* TuanOrderServiceImpl: 团订单管理 业务服务层实现
* 2016-11-05 13:27:33
* @author huguangling 胡广玲
* @version 1.0
*/
@Service
public class TuanOrderServiceImpl extends BaseServiceImpl<TuanOrder, Long> implements TuanOrderService {

    private Log log = LogFactory.getLog(this.getClass());
    @Resource
    private TuanOrderDao tuanOrderDao;
    
    private TuanOrderRepository tuanOrderRepository;
    /**
    *构造方法
    * @param tuanOrderRepository 数据容器
    */
    @Autowired
    public TuanOrderServiceImpl( TuanOrderRepository tuanOrderRepository) {
        super(tuanOrderRepository);
        this.tuanOrderRepository = tuanOrderRepository;
    }

    @Override
    public Page<TuanOrder> list(TuanOrderCondition tuanOrderCondition, Pageable pageable) {
        log.info("团订单管理查询列表");
        return tuanOrderDao.list(tuanOrderCondition, pageable);
    }
    
    @Override
    public List<TuanOrder> list(TuanOrderCondition tuanOrderCondition) {
        log.info("团订单管理查询列表无分页");
        return tuanOrderDao.list(tuanOrderCondition);
    }

    /**
     * 是否存在该
     * @param id 团订单ID
     * @return 如果存在的话返回true ,没有的返回false
     */
    @Override
    public boolean existsId(Long id){
        return tuanOrderRepository.findFirstById(id)!=null;
    }
    /**
     * 根据给定的字段返回符合的对象
     * @param id 团订单ID
     * @return 符合条件的唯一对象
     */
    @Override
    public TuanOrder findById(Long id){
         return tuanOrderRepository.findFirstById(id);
    }
    /**
     * 根据字段获取所有符合的记录
     * @param id 团订单ID
     * @return 符合条件的所有对象
     */
    @Override
    public List<TuanOrder>  findAllById(Long id){
        return tuanOrderRepository.findAllById(id);
    }
    
     @Override
    public Page<TuanOrder>  findAllById(Long id, Pageable pageable){
        return tuanOrderRepository.findAllById(id,pageable);
    }
    @Override 
    public TuanOrder findBy(String field,Object value){
        log.info("团订单管理根据字["+field+"="+value+"] 进行查询符合条件的唯一值");
        return tuanOrderDao.findBy(field,value);
    }
    
    @Override 
    public List<TuanOrder> findAllBy(String field,Object value){
        log.info("团订单管理根据字["+field+"="+value+"] 进行查询符合条件的所有记录");
        return tuanOrderDao.findAllBy(field,value);
    }
}