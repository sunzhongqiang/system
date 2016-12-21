package com.mmk.system.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mmk.gene.service.impl.BaseServiceImpl;
import com.mmk.system.condition.UserCondition;
import com.mmk.system.dao.UserDao;
import com.mmk.system.dao.UserRepository;
import com.mmk.system.model.User;
import com.mmk.system.service.UserService;

/**
 * 系统用户 业务服务层实现
 * 
 * @author 孙中强 sunzhongqiang
 * @version 1.0
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<User, Long> implements UserService {

	private Log log = LogFactory.getLog(this.getClass());
	@Resource
	private UserDao userDao;

	private UserRepository userRepository;

	/**
	 * 构造方法
	 * 
	 * @param userRepository 资源服务
	 */
	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		super(userRepository);
		this.userRepository = userRepository;
	}

	@Override
	public Page<User> list(UserCondition userCondition, Pageable pageable) {
		log.info("系统用户查询列表");
		return userDao.list(userCondition, pageable);
	}

	@Override
	public List<User> list(UserCondition userCondition) {
		log.info("系统用户查询列表无分页");
		return userDao.list(userCondition);
	}

	@Override
	public User findBy(String field, Object value) {
		log.info("系统用户根据字[" + field + "=" + value + "] 进行查询符合条件的唯一值");
		return userDao.findBy(field, value);
	}

	@Override
	public List<User> findAllBy(String field, Object value) {
		log.info("系统用户根据字[" + field + "=" + value + "] 进行查询符合条件的所有记录");
		return userDao.findAllBy(field, value);
	}

	@Override
	public User findByUsername(String name) {
		log.info("系统用户根据用户名：" + name + "获取对应的用户");
		return userRepository.findFirstByUsername(name);
	}

	@Override
	public Page<User> loadByOrgId(Long orgId, Pageable pageable) {
		return userDao.loadByOrgId(orgId, pageable);
	}
}