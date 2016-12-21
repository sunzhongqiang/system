package com.mmk.weixin.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mmk.gene.service.impl.BaseServiceImpl;
import com.mmk.weixin.condition.WxAppAuthCondition;
import com.mmk.weixin.dao.WxAppAuthDao;
import com.mmk.weixin.dao.WxAppAuthRepository;
import com.mmk.weixin.model.WxAppAuth;
import com.mmk.weixin.service.WxAppAuthService;
/**
* WxAuthAppServiceImpl: 微信授权APP 业务服务层实现
* 2016-12-21 11:14:34
* @author 孙中强 sunzhongqiang
* @version 1.0
*/
@Service
public class WxAppAuthServiceImpl extends BaseServiceImpl<WxAppAuth, Long> implements WxAppAuthService {

    private Log log = LogFactory.getLog(this.getClass());
    @Resource
    private WxAppAuthDao wxAuthAppDao;
    
    private WxAppAuthRepository wxAuthAppRepository;
    /**
    *构造方法
    * @param wxAuthAppRepository 数据容器
    */
    @Autowired
    public WxAppAuthServiceImpl( WxAppAuthRepository wxAuthAppRepository) {
        super(wxAuthAppRepository);
        this.wxAuthAppRepository = wxAuthAppRepository;
    }

    @Override
    public Page<WxAppAuth> list(WxAppAuthCondition wxAuthAppCondition, Pageable pageable) {
        log.info("微信授权APP查询列表");
        return wxAuthAppDao.list(wxAuthAppCondition, pageable);
    }
    
    @Override
    public List<WxAppAuth> list(WxAppAuthCondition wxAuthAppCondition) {
        log.info("微信授权APP查询列表无分页");
        return wxAuthAppDao.list(wxAuthAppCondition);
    }

    /**
     * 根据给定的字段返回符合的对象
     * @param authorizerAppid 授权方appid
     * @return 符合条件的唯一对象
     */
    @Override
    public WxAppAuth findByAuthorizerAppid(String authorizerAppid){
         return wxAuthAppRepository.findFirstByAuthorizerAppid(authorizerAppid);
    }
    /**
     * 根据字段获取所有符合的记录
     * @param modified 更新时间
     * @return 符合条件的所有对象
     */
    @Override
    public List<WxAppAuth>  findAllByModified(Date modified){
        return wxAuthAppRepository.findAllByModified(modified);
    }
    
     @Override
    public Page<WxAppAuth>  findAllByModified(Date modified, Pageable pageable){
        return wxAuthAppRepository.findAllByModified(modified,pageable);
    }
    /**
     * 根据给定的字段返回符合的对象
     * @param nickName 昵称
     * @return 符合条件的唯一对象
     */
    @Override
    public WxAppAuth findByNickName(String nickName){
         return wxAuthAppRepository.findFirstByNickName(nickName);
    }
    @Override 
    public WxAppAuth findBy(String field,Object value){
        log.info("微信授权APP根据字["+field+"="+value+"] 进行查询符合条件的唯一值");
        return wxAuthAppDao.findBy(field,value);
    }
    
    @Override 
    public List<WxAppAuth> findAllBy(String field,Object value){
        log.info("微信授权APP根据字["+field+"="+value+"] 进行查询符合条件的所有记录");
        return wxAuthAppDao.findAllBy(field,value);
    }
}