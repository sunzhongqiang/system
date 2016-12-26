package com.mmk.business.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mmk.business.condition.UserAddressCondition;
import com.mmk.business.dao.UserAddressDao;
import com.mmk.business.dao.UserAddressRepository;
import com.mmk.business.model.UserAddress;
import com.mmk.business.service.UserAddressService;
import com.mmk.gene.service.impl.BaseServiceImpl;
import com.mmk.trade.model.TuanOrder;

/**
 * UserAddressServiceImpl: 会员地址 业务服务层实现 2016-11-16 09:37:58
 * 
 * @author huguangling 胡广玲
 * @version 1.0
 */
@Service
public class UserAddressServiceImpl extends BaseServiceImpl<UserAddress, Long> implements UserAddressService {

	private Log log = LogFactory.getLog(this.getClass());
	@Resource
	private UserAddressDao userAddressDao;

	private UserAddressRepository userAddressRepository;

	/**
	 * 构造方法
	 * 
	 * @param userAddressRepository  数据容器
	 */
	@Autowired
	public UserAddressServiceImpl(UserAddressRepository userAddressRepository) {
		super(userAddressRepository);
		this.userAddressRepository = userAddressRepository;
	}

	@Override
	public Page<UserAddress> list(UserAddressCondition userAddressCondition, Pageable pageable) {
		log.info("会员地址查询列表");
		return userAddressDao.list(userAddressCondition, pageable);
	}

	@Override
	public List<UserAddress> list(UserAddressCondition userAddressCondition) {
		log.info("会员地址查询列表无分页");
		return userAddressDao.list(userAddressCondition);
	}

	/**
	 * 根据给定的字段返回符合的对象
	 * 
	 * @param id 地址id
	 * @return 符合条件的唯一对象
	 */
	@Override
	public UserAddress findById(Long id) {
		return userAddressRepository.findFirstById(id);
	}

	/**
	 * 根据字段获取所有符合的记录
	 * 
	 * @param userId  会员id
	 * @return 符合条件的所有对象
	 */
	@Override
	public List<UserAddress> findAllByUserId(Long userId) {
		return userAddressRepository.findAllByUserId(userId);
	}

	@Override
	public Page<UserAddress> findAllByUserId(Long userId, Pageable pageable) {
		return userAddressRepository.findAllByUserId(userId, pageable);
	}

	@Override
	public UserAddress findBy(String field, Object value) {
		log.info("会员地址根据字[" + field + "=" + value + "] 进行查询符合条件的唯一值");
		return userAddressDao.findBy(field, value);
	}

	@Override
	public List<UserAddress> findAllBy(String field, Object value) {
		log.info("会员地址根据字[" + field + "=" + value + "] 进行查询符合条件的所有记录");
		return userAddressDao.findAllBy(field, value);
	}

	@Override
	public Page<UserAddress> findAllByOpenid(String openid, Pageable pageable) {
		return userAddressRepository.findAllByOpenid(openid, pageable);
	}

	@Override
	public UserAddress findDefaultByOpenid(String openid) {
		Map<String, Object> params = new HashMap<String,Object>();
		return userAddressDao.findBy(params );
	}

	@Override
	public TuanOrder copyAddress(TuanOrder order, UserAddress address) {
		order.setAddress(address.getAddress());
		order.setCity(address.getCity());
		order.setConsignee(address.getConsignee());
		order.setCountry(address.getCountry());
		order.setCountyName(address.getCountyName());
		order.setProvince(address.getProvince());
		order.setProvinceName(address.getProvinceName());
		order.setCityName(address.getCityName());
		order.setDistrict(address.getDistrict());
		order.setDistrictName(address.getDistrictName());
		order.setZipcode(address.getZipcode());
		order.setTel(address.getTel());
		order.setMobile(address.getMobile());
		return order;
	}
}