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
import com.mmk.trade.dao.TuanRepository;
import com.mmk.trade.model.Tuan;
import com.mmk.trade.condition.TuanCondition;
import com.mmk.trade.service.TuanService;
import com.mmk.trade.dao.TuanDao;
/**
* TuanServiceImpl: 拼团管理 业务服务层实现
* 2016-11-07 10:36:33
* @author huguangling 胡广玲
* @version 1.0
*/
@Service
public class TuanServiceImpl extends BaseServiceImpl<Tuan, Long> implements TuanService {

    private Log log = LogFactory.getLog(this.getClass());
    @Resource
    private TuanDao tuanDao;
    
    private TuanRepository tuanRepository;
    /**
    *构造方法
    * @param tuanRepository 数据容器
    */
    @Autowired
    public TuanServiceImpl( TuanRepository tuanRepository) {
        super(tuanRepository);
        this.tuanRepository = tuanRepository;
    }

    @Override
    public Page<Tuan> list(TuanCondition tuanCondition, Pageable pageable) {
        log.info("拼团管理查询列表");
        return tuanDao.list(tuanCondition, pageable);
    }
    
    @Override
    public List<Tuan> list(TuanCondition tuanCondition) {
        log.info("拼团管理查询列表无分页");
        return tuanDao.list(tuanCondition);
    }

    /**
     * 是否存在该
     * @param orderId 订单ID
     * @return 如果存在的话返回true ,没有的返回false
     */
    @Override
    public boolean existsOrderId(Long orderId){
        return tuanRepository.findFirstByOrderId(orderId)!=null;
    }
    /**
     * 根据给定的字段返回符合的对象
     * @param orderId 订单ID
     * @return 符合条件的唯一对象
     */
    @Override
    public Tuan findByOrderId(Long orderId){
         return tuanRepository.findFirstByOrderId(orderId);
    }
    /**
     * 根据字段获取所有符合的记录
     * @param orderId 订单ID
     * @return 符合条件的所有对象
     */
    @Override
    public List<Tuan>  findAllByOrderId(Long orderId){
        return tuanRepository.findAllByOrderId(orderId);
    }
    
     @Override
    public Page<Tuan>  findAllByOrderId(Long orderId, Pageable pageable){
        return tuanRepository.findAllByOrderId(orderId,pageable);
    }
    @Override 
    public Tuan findBy(String field,Object value){
        log.info("拼团管理根据字["+field+"="+value+"] 进行查询符合条件的唯一值");
        return tuanDao.findBy(field,value);
    }
    
    @Override 
    public List<Tuan> findAllBy(String field,Object value){
        log.info("拼团管理根据字["+field+"="+value+"] 进行查询符合条件的所有记录");
        return tuanDao.findAllBy(field,value);
    }
}