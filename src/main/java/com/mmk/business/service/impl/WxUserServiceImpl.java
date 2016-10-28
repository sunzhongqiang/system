package com.mmk.business.service.impl;

import javax.annotation.Resource;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.mmk.gene.service.impl.BaseServiceImpl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.mmk.business.dao.WxUserRepository;
import com.mmk.business.model.WxUser;
import com.mmk.business.condition.WxUserCondition;
import com.mmk.business.service.WxUserService;
import com.mmk.business.dao.WxUserDao;
/**
* WxUserServiceImpl: 微信用户 业务服务层实现
* 2016-10-28 14:34:36
* @author 胡广玲
* @version 1.0
*/
@Service
public class WxUserServiceImpl extends BaseServiceImpl<WxUser, Long> implements WxUserService {

    private Log log = LogFactory.getLog(this.getClass());
    @Resource
    private WxUserDao wxUserDao;
    
    private WxUserRepository wxUserRepository;
    /**
    *构造方法
    * @param wxUserRepository 数据容器
    */
    @Autowired
    public WxUserServiceImpl( WxUserRepository wxUserRepository) {
        super(wxUserRepository);
        this.wxUserRepository = wxUserRepository;
    }

    @Override
    public Page<WxUser> list(WxUserCondition wxUserCondition, Pageable pageable) {
        log.info("微信用户查询列表");
        return wxUserDao.list(wxUserCondition, pageable);
    }
    
    @Override
    public List<WxUser> list(WxUserCondition wxUserCondition) {
        log.info("微信用户查询列表无分页");
        return wxUserDao.list(wxUserCondition);
    }

    @Override 
    public WxUser findBy(String field,Object value){
        log.info("微信用户根据字["+field+"="+value+"] 进行查询符合条件的唯一值");
        return wxUserDao.findBy(field,value);
    }
    
    @Override 
    public List<WxUser> findAllBy(String field,Object value){
        log.info("微信用户根据字["+field+"="+value+"] 进行查询符合条件的所有记录");
        return wxUserDao.findAllBy(field,value);
    }
}