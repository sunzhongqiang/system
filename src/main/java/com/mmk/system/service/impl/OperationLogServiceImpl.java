package com.mmk.system.service.impl;

import javax.annotation.Resource;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.mmk.gene.service.impl.BaseServiceImpl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.mmk.system.dao.OperationLogRepository;
import com.mmk.system.model.OperationLog;
import com.mmk.system.condition.OperationLogCondition;
import com.mmk.system.service.OperationLogService;
import com.mmk.system.dao.OperationLogDao;
/**
* OperationLogServiceImpl: 系统操作日志 业务服务层实现
* 2016-10-12 11:54:15
* @author sunzhongqiang 孙中强
* @version 1.0
*/
@CacheConfig(cacheNames="demo")
@Service
public class OperationLogServiceImpl extends BaseServiceImpl<OperationLog, Long> implements OperationLogService {

    private Log log = LogFactory.getLog(this.getClass());
    @Resource
    private OperationLogDao operationLogDao;
    
    private OperationLogRepository operationLogRepository;
    /**
    *构造方法
    * @param operationLogRepository 数据容器
    */
    @Autowired
    public OperationLogServiceImpl( OperationLogRepository operationLogRepository) {
        super(operationLogRepository);
        this.operationLogRepository = operationLogRepository;
    }
    
    
    @Cacheable(cacheNames="demo")
    @Override
    public Page<OperationLog> list(OperationLogCondition operationLogCondition, Pageable pageable) {
        log.info("系统操作日志查询列表");
        return operationLogDao.list(operationLogCondition, pageable);
    }
    
    @Override
    public List<OperationLog> list(OperationLogCondition operationLogCondition) {
        log.info("系统操作日志查询列表无分页");
        return operationLogDao.list(operationLogCondition);
    }

    @Override 
    public OperationLog findBy(String field,Object value){
        log.info("系统操作日志根据字["+field+"="+value+"] 进行查询符合条件的唯一值");
        return operationLogDao.findBy(field,value);
    }
    
    @Override 
    public List<OperationLog> findAllBy(String field,Object value){
        log.info("系统操作日志根据字["+field+"="+value+"] 进行查询符合条件的所有记录");
        return operationLogDao.findAllBy(field,value);
    }
}