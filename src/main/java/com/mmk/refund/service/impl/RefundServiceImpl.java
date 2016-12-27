package com.mmk.refund.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mmk.common.tool.ApiClient;
import com.mmk.gene.service.impl.BaseServiceImpl;
import com.mmk.refund.condition.RefundCondition;
import com.mmk.refund.constants.RefundStatus;
import com.mmk.refund.dao.RefundDao;
import com.mmk.refund.dao.RefundRepository;
import com.mmk.refund.model.Refund;
import com.mmk.refund.service.RefundService;
import com.mmk.trade.condition.TuanOrderStatus;
import com.mmk.trade.model.TuanOrder;
import com.mmk.trade.service.TuanOrderService;
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
    
    @Resource
    private TuanOrderService orderService;
    
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

	@Override
	public Refund findByOrderID(Long id) {
        log.info("根据订单ID查找对应的退款详情");
        return refundDao.findByOrderID(id);
	}

	@Override
	public boolean refundByOrderId(Long id) {
		TuanOrder tuanOrder = orderService.find(id);
		String refundNo = "REFUND"+DateTime.now().toString("yyyyMMddHHmmssSSS"); 
		Map<String, Object> params = new HashMap<String,Object>();
		params.put("tradeNo", tuanOrder.getTuanCode());
		params.put("refundFee", tuanOrder.getOrderPrice());
		params.put("totalFee", tuanOrder.getOrderPrice());
		params.put("refundNo", refundNo);
		
		Refund refund = new Refund();
		refund.setOrderSn(tuanOrder.getTuanCode());
		refund.setRefundNo(refundNo);
		refund.setApplyRefundFee(tuanOrder.getOrderPrice());
		refund.setGoodsId(tuanOrder.getGoodsId());
		refund.setGoodsPrice(tuanOrder.getGoodsPrice());
		refund.setGoodsImg(tuanOrder.getGoodsImg());
		refund.setGoodsName(tuanOrder.getGoodsName());
		refund.setHasGoodsReturn("0");
		refund.setOrderStatus(tuanOrder.getOrderStatus());
		refund.setRefundStatus(RefundStatus.WAIT_REFUND_MONEY.name());
		refund.setRealRefundFee(tuanOrder.getOrderPrice());
		refund.setRefundCreateTime(new Date());
		refund.setUserId(tuanOrder.getUser().getId());
		refund.setUserName(tuanOrder.getUserName());
		
		
		copyAddress(tuanOrder,refund);
		
		

		if(refundMoney(refund)){
			refund.setRefundStatus(RefundStatus.SUCCESSED.name());
			tuanOrder.setOrderStatus(TuanOrderStatus.CLOSED.name());
		}else{
			refund.setRefundStatus(RefundStatus.WAIT_REFUND_MONEY.name());
		}
		
		save(refund);
		
		
		orderService.save(tuanOrder);
		
		return false;
	}

	private Refund copyAddress(TuanOrder address, Refund refund) {
		refund.setAddress(address.getAddress());
		refund.setCity(address.getCity());
		refund.setConsignee(address.getConsignee());
		refund.setCountry(address.getCountry());
		refund.setCountyName(address.getCountyName());
		refund.setProvince(address.getProvince());
		refund.setProvinceName(address.getProvinceName());
		refund.setCityName(address.getCityName());
		refund.setDistrict(address.getDistrict());
		refund.setDistrictName(address.getDistrictName());
		refund.setZipcode(address.getZipcode());
		refund.setTel(address.getTel());
		refund.setMobile(address.getMobile());
		return refund;
		
	}

	@Override
	public boolean refundMoney(Refund refund) {
		Map<String, Object> params = new HashMap<String,Object>();
		params.put("tradeNo", refund.getOrderSn());
		params.put("refundFee", refund.getRealRefundFee());
		params.put("totalFee", refund.getTotalFee());
		params.put("refundNo", refund.getRefundNo());
		String result = ApiClient.post("http://wx.yiqingo.net/Api/WxPay/Refund", params);
		log.debug("退款接口调用结果："+result);
		if(StringUtils.isNotBlank(result)&&StringUtils.contains(result, "true")){
			return true;
		}else{
			return false;
		}
	}
}