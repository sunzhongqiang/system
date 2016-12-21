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
import com.mmk.system.condition.ApiCondition;
import com.mmk.system.dao.ApiDao;
import com.mmk.system.dao.ApiRepository;
import com.mmk.system.model.Api;
import com.mmk.system.service.ApiService;
/**
* ApiServiceImpl: 系统API 业务服务层实现
* 2016-11-15 10:01:04
* @author 
* @version 1.0
*/
@Service
public class ApiServiceImpl extends BaseServiceImpl<Api, Long> implements ApiService {

    private Log log = LogFactory.getLog(this.getClass());
    @Resource
    private ApiDao apiDao;
    
    private ApiRepository apiRepository;
    /**
    *构造方法
    * @param apiRepository 数据容器
    */
    @Autowired
    public ApiServiceImpl( ApiRepository apiRepository) {
        super(apiRepository);
        this.apiRepository = apiRepository;
    }

    @Override
    public Page<Api> list(ApiCondition apiCondition, Pageable pageable) {
        log.info("系统API查询列表");
        return apiDao.list(apiCondition, pageable);
    }
    
    @Override
    public List<Api> list(ApiCondition apiCondition) {
        log.info("系统API查询列表无分页");
        return apiDao.list(apiCondition);
    }

    @Override 
    public Api findBy(String field,Object value){
        log.info("系统API根据字["+field+"="+value+"] 进行查询符合条件的唯一值");
        return apiDao.findBy(field,value);
    }
    
    @Override 
    public List<Api> findAllBy(String field,Object value){
        log.info("系统API根据字["+field+"="+value+"] 进行查询符合条件的所有记录");
        return apiDao.findAllBy(field,value);
    }
}