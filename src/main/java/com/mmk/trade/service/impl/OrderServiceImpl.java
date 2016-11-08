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
import com.mmk.trade.dao.OrderRepository;
import com.mmk.trade.model.Order;
import com.mmk.trade.condition.OrderCondition;
import com.mmk.trade.service.OrderService;
import com.mmk.trade.dao.OrderDao;
/**
* OrderServiceImpl: 订单管理 业务服务层实现
* 2016-11-07 10:37:06
* @author huguangling 胡广玲
* @version 1.0
*/
@Service
public class OrderServiceImpl extends BaseServiceImpl<Order, Long> implements OrderService {

    private Log log = LogFactory.getLog(this.getClass());
    @Resource
    private OrderDao orderDao;
    
    private OrderRepository orderRepository;
    /**
    *构造方法
    * @param orderRepository 数据容器
    */
    @Autowired
    public OrderServiceImpl( OrderRepository orderRepository) {
        super(orderRepository);
        this.orderRepository = orderRepository;
    }

    @Override
    public Page<Order> list(OrderCondition orderCondition, Pageable pageable) {
        log.info("订单管理查询列表");
        return orderDao.list(orderCondition, pageable);
    }
    
    @Override
    public List<Order> list(OrderCondition orderCondition) {
        log.info("订单管理查询列表无分页");
        return orderDao.list(orderCondition);
    }

    /**
     * 根据给定的字段返回符合的对象
     * @param id 团订单ID
     * @return 符合条件的唯一对象
     */
    @Override
    public Order findById(Long id){
         return orderRepository.findFirstById(id);
    }
    /**
     * 根据字段获取所有符合的记录
     * @param id 团订单ID
     * @return 符合条件的所有对象
     */
    @Override
    public List<Order>  findAllById(Long id){
        return orderRepository.findAllById(id);
    }
    
     @Override
    public Page<Order>  findAllById(Long id, Pageable pageable){
        return orderRepository.findAllById(id,pageable);
    }
    /**
     * 根据给定的字段返回符合的对象
     * @param tuanCode 团ID
     * @return 符合条件的唯一对象
     */
    @Override
    public Order findByTuanCode(String tuanCode){
         return orderRepository.findFirstByTuanCode(tuanCode);
    }
    /**
     * 根据字段获取所有符合的记录
     * @param tuanCode 团ID
     * @return 符合条件的所有对象
     */
    @Override
    public List<Order>  findAllByTuanCode(String tuanCode){
        return orderRepository.findAllByTuanCode(tuanCode);
    }
    
     @Override
    public Page<Order>  findAllByTuanCode(String tuanCode, Pageable pageable){
        return orderRepository.findAllByTuanCode(tuanCode,pageable);
    }
    @Override 
    public Order findBy(String field,Object value){
        log.info("订单管理根据字["+field+"="+value+"] 进行查询符合条件的唯一值");
        return orderDao.findBy(field,value);
    }
    
    @Override 
    public List<Order> findAllBy(String field,Object value){
        log.info("订单管理根据字["+field+"="+value+"] 进行查询符合条件的所有记录");
        return orderDao.findAllBy(field,value);
    }
}