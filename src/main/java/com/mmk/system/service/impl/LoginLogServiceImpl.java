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
import com.mmk.system.condition.LoginLogCondition;
import com.mmk.system.dao.LoginLogDao;
import com.mmk.system.dao.LoginLogRepository;
import com.mmk.system.model.LoginLog;
import com.mmk.system.service.LoginLogService;
/**
* LoginLogServiceImpl: 系统登录日志 业务服务层实现
* 2016-10-22 13:46:31
* @author codegenerator
* @version 1.0
*/
@Service
public class LoginLogServiceImpl extends BaseServiceImpl<LoginLog, Long> implements LoginLogService {

    private Log log = LogFactory.getLog(this.getClass());
    @Resource
    private LoginLogDao loginLogDao;
    
    private LoginLogRepository loginLogRepository;
    /**
    *构造方法
    * @param loginLogRepository 数据容器
    */
    @Autowired
    public LoginLogServiceImpl( LoginLogRepository loginLogRepository) {
        super(loginLogRepository);
        this.loginLogRepository = loginLogRepository;
    }

    @Override
    public Page<LoginLog> list(LoginLogCondition loginLogCondition, Pageable pageable) {
        log.info("系统登录日志查询列表");
        return loginLogDao.list(loginLogCondition, pageable);
    }
    
    @Override
    public List<LoginLog> list(LoginLogCondition loginLogCondition) {
        log.info("系统登录日志查询列表无分页");
        return loginLogDao.list(loginLogCondition);
    }

    @Override 
    public LoginLog findBy(String field,Object value){
        log.info("系统登录日志根据字["+field+"="+value+"] 进行查询符合条件的唯一值");
        return loginLogDao.findBy(field,value);
    }
    
    @Override 
    public List<LoginLog> findAllBy(String field,Object value){
        log.info("系统登录日志根据字["+field+"="+value+"] 进行查询符合条件的所有记录");
        return loginLogDao.findAllBy(field,value);
    }
}