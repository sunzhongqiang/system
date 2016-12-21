package com.mmk.weixin.service.impl;

import javax.annotation.Resource;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.mmk.gene.service.impl.BaseServiceImpl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.mmk.weixin.dao.WxAuthAppRepository;
import com.mmk.weixin.model.WxAuthApp;
import com.mmk.weixin.condition.WxAuthAppCondition;
import com.mmk.weixin.service.WxAuthAppService;
import com.mmk.weixin.dao.WxAuthAppDao;
/**
* WxAuthAppServiceImpl: 微信授权APP 业务服务层实现
* 2016-12-21 11:14:34
* @author 孙中强 sunzhongqiang
* @version 1.0
*/
@Service
public class WxAuthAppServiceImpl extends BaseServiceImpl<WxAuthApp, Long> implements WxAuthAppService {

    private Log log = LogFactory.getLog(this.getClass());
    @Resource
    private WxAuthAppDao wxAuthAppDao;
    
    private WxAuthAppRepository wxAuthAppRepository;
    /**
    *构造方法
    * @param wxAuthAppRepository 数据容器
    */
    @Autowired
    public WxAuthAppServiceImpl( WxAuthAppRepository wxAuthAppRepository) {
        super(wxAuthAppRepository);
        this.wxAuthAppRepository = wxAuthAppRepository;
    }

    @Override
    public Page<WxAuthApp> list(WxAuthAppCondition wxAuthAppCondition, Pageable pageable) {
        log.info("微信授权APP查询列表");
        return wxAuthAppDao.list(wxAuthAppCondition, pageable);
    }
    
    @Override
    public List<WxAuthApp> list(WxAuthAppCondition wxAuthAppCondition) {
        log.info("微信授权APP查询列表无分页");
        return wxAuthAppDao.list(wxAuthAppCondition);
    }

    /**
     * 根据给定的字段返回符合的对象
     * @param authorizerAppid 授权方appid
     * @return 符合条件的唯一对象
     */
    @Override
    public WxAuthApp findByAuthorizerAppid(String authorizerAppid){
         return wxAuthAppRepository.findFirstByAuthorizerAppid(authorizerAppid);
    }
    /**
     * 根据字段获取所有符合的记录
     * @param modified 更新时间
     * @return 符合条件的所有对象
     */
    @Override
    public List<WxAuthApp>  findAllByModified(Date modified){
        return wxAuthAppRepository.findAllByModified(modified);
    }
    
     @Override
    public Page<WxAuthApp>  findAllByModified(Date modified, Pageable pageable){
        return wxAuthAppRepository.findAllByModified(modified,pageable);
    }
    /**
     * 根据给定的字段返回符合的对象
     * @param nickName 昵称
     * @return 符合条件的唯一对象
     */
    @Override
    public WxAuthApp findByNickName(String nickName){
         return wxAuthAppRepository.findFirstByNickName(nickName);
    }
    @Override 
    public WxAuthApp findBy(String field,Object value){
        log.info("微信授权APP根据字["+field+"="+value+"] 进行查询符合条件的唯一值");
        return wxAuthAppDao.findBy(field,value);
    }
    
    @Override 
    public List<WxAuthApp> findAllBy(String field,Object value){
        log.info("微信授权APP根据字["+field+"="+value+"] 进行查询符合条件的所有记录");
        return wxAuthAppDao.findAllBy(field,value);
    }
}