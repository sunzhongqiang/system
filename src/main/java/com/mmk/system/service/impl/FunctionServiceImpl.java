package com.mmk.system.service.impl;

import javax.annotation.Resource;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.mmk.gene.service.impl.BaseServiceImpl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.mmk.system.dao.FunctionRepository;
import com.mmk.system.model.Function;
import com.mmk.system.condition.FunctionCondition;
import com.mmk.system.service.FunctionService;
import com.mmk.system.dao.FunctionDao;
/**
* FunctionServiceImpl: 系统功能 业务服务层实现
* 2016-10-24 15:52:09
* @author huguangling 胡广玲
* @version 1.0
*/
@Service
public class FunctionServiceImpl extends BaseServiceImpl<Function, Long> implements FunctionService {

    private Log log = LogFactory.getLog(this.getClass());
    @Resource
    private FunctionDao functionDao;
    
    private FunctionRepository functionRepository;
    /**
    *构造方法
    * @param functionRepository 数据容器
    */
    @Autowired
    public FunctionServiceImpl( FunctionRepository functionRepository) {
        super(functionRepository);
        this.functionRepository = functionRepository;
    }

    @Override
    public Page<Function> list(FunctionCondition functionCondition, Pageable pageable) {
        log.info("系统功能查询列表");
        return functionDao.list(functionCondition, pageable);
    }
    
    @Override
    public List<Function> list(FunctionCondition functionCondition) {
        log.info("系统功能查询列表无分页");
        return functionDao.list(functionCondition);
    }

    @Override 
    public Function findBy(String field,Object value){
        log.info("系统功能根据字["+field+"="+value+"] 进行查询符合条件的唯一值");
        return functionDao.findBy(field,value);
    }
    
    @Override 
    public List<Function> findAllBy(String field,Object value){
        log.info("系统功能根据字["+field+"="+value+"] 进行查询符合条件的所有记录");
        return functionDao.findAllBy(field,value);
    }
}