package com.mmk.trade.service.impl;

import java.util.List;
import java.util.Random;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mmk.gene.service.impl.BaseServiceImpl;
import com.mmk.refund.service.RefundService;
import com.mmk.trade.condition.OrderCondition;
import com.mmk.trade.condition.TuanOrderStatus;
import com.mmk.trade.dao.TuanOrderDao;
import com.mmk.trade.dao.TuanOrderRepository;
import com.mmk.trade.model.TuanOrder;
import com.mmk.trade.service.TuanOrderService;
/**
* OrderServiceImpl: 订单管理 业务服务层实现
* 2016-11-07 10:37:06
* @author huguangling 胡广玲
* @version 1.0
*/
@Service
public class TuanOrderServiceImpl extends BaseServiceImpl<TuanOrder, Long> implements TuanOrderService {

    private Log log = LogFactory.getLog(this.getClass());
    @Resource
    private TuanOrderDao orderDao;
    
    @Resource
    private RefundService refundService;
    
    private TuanOrderRepository orderRepository;
    /**
    *构造方法
    * @param orderRepository 数据容器
    */
    @Autowired
    public TuanOrderServiceImpl( TuanOrderRepository orderRepository) {
        super(orderRepository);
        this.orderRepository = orderRepository;
    }

    @Override
    public Page<TuanOrder> list(OrderCondition orderCondition, Pageable pageable) {
        log.info("订单管理查询列表");
        return orderDao.list(orderCondition, pageable);
    }
    
    @Override
    public List<TuanOrder> list(OrderCondition orderCondition) {
        log.info("订单管理查询列表无分页");
        return orderDao.list(orderCondition);
    }

    /**
     * 根据给定的字段返回符合的对象
     * @param id 团订单ID
     * @return 符合条件的唯一对象
     */
    @Override
    public TuanOrder findById(Long id){
         return orderRepository.findFirstById(id);
    }
    /**
     * 根据字段获取所有符合的记录
     * @param id 团订单ID
     * @return 符合条件的所有对象
     */
    @Override
    public List<TuanOrder>  findAllById(Long id){
        return orderRepository.findAllById(id);
    }
    
     @Override
    public Page<TuanOrder>  findAllById(Long id, Pageable pageable){
        return orderRepository.findAllById(id,pageable);
    }
    /**
     * 根据给定的字段返回符合的对象
     * @param tuanCode 团ID
     * @return 符合条件的唯一对象
     */
    @Override
    public TuanOrder findByTuanCode(String tuanCode){
         return orderRepository.findFirstByTuanCode(tuanCode);
    }
    /**
     * 根据字段获取所有符合的记录
     * @param tuanCode 团ID
     * @return 符合条件的所有对象
     */
    @Override
    public List<TuanOrder>  findAllByTuanCode(String tuanCode){
        return orderRepository.findAllByTuanCode(tuanCode);
    }
    
     @Override
    public Page<TuanOrder>  findAllByTuanCode(String tuanCode, Pageable pageable){
        return orderRepository.findAllByTuanCode(tuanCode,pageable);
    }
    @Override 
    public TuanOrder findBy(String field,Object value){
        log.info("订单管理根据字["+field+"="+value+"] 进行查询符合条件的唯一值");
        return orderDao.findBy(field,value);
    }
    
    @Override 
    public List<TuanOrder> findAllBy(String field,Object value){
        log.info("订单管理根据字["+field+"="+value+"] 进行查询符合条件的所有记录");
        return orderDao.findAllBy(field,value);
    }

	@Override
	public Integer countByOpenid(String openid, String status) {
		return orderDao.countByOpenid(openid,status);
	}

	@Override
	public Page<TuanOrder> listBy(String openid, OrderCondition orderCondition, Pageable pageable) {
		return orderDao.listBy(openid,orderCondition,pageable);
	}

	@Override
	public List<TuanOrder> findAllByTuanId(Long id) {
		return orderDao.findAllByTuanId(id);
	}

	@Override
	public List<TuanOrder> findTuanOrder(String openid, String tuanStatus) {
		return orderDao.findTuanOrder(openid, tuanStatus);
	}

	@Override
	public void changeTuanStatusByTuanId(Long id , String status) {
		
		//根据团更改团订单的状态
		List<TuanOrder> tuanOrders = findAllByTuanId(id);
		for (TuanOrder tuanOrder : tuanOrders) {
			tuanOrder.setOrderStatus(status);
		}
		save(tuanOrders);
	}

	@Override
	public void chooseLucker(Long id) {
		List<TuanOrder> tuanOrders = findAllByTuanId(id);
		Random random = new Random();
		int nextInt = random.nextInt(tuanOrders.size());
		for (int i = 0; i < tuanOrders.size(); i++) {
			TuanOrder tuanOrder = tuanOrders.get(i);
			if(nextInt==i){
				tuanOrder.setOrderStatus(TuanOrderStatus.WAIT_SHIPPING.name());
				save(tuanOrder);
			}else{
				refundService.refundByOrderId(tuanOrder.getId());
			}
		}
	}

    public static int[] GetRandomSequence2(int total)
      {
    	  int[] sequence = new int[total];
          int[] output = new int[total];

          for (int i = 0; i < total; i++){
              sequence[i] = i;
          }

          Random random = new Random();
          int end = total - 1;

          for (int i = 0; i < total; i++){
              int num = random.nextInt(total);
              output[i] = sequence[num];
              sequence[num] = sequence[end];
              end--;
          }

          return output;
      }
	  
	@Override
	public TuanOrder findByOrderCode(String orderCode) {
		return orderDao.findByOrderCode(orderCode);
	}
}