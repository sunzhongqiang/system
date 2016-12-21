package com.mmk.weixin.service.impl;

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

import com.mmk.gene.service.impl.BaseServiceImpl;
import com.mmk.weixin.condition.WxAppUserCondition;
import com.mmk.weixin.dao.WxAppUserDao;
import com.mmk.weixin.dao.WxAppUserRepository;
import com.mmk.weixin.model.WxAppUser;
import com.mmk.weixin.service.WxAppUserService;
/**
* WxAppUserServiceImpl: 微信公众号的用户 业务服务层实现
* 2016-12-21 15:42:41
* @author 
* @version 1.0
*/
@Service
public class WxAppUserServiceImpl extends BaseServiceImpl<WxAppUser, Long> implements WxAppUserService {

    private Log log = LogFactory.getLog(this.getClass());
    @Resource
    private WxAppUserDao wxAppUserDao;
    
    private WxAppUserRepository wxAppUserRepository;
    /**
    *构造方法
    * @param wxAppUserRepository 数据容器
    */
    @Autowired
    public WxAppUserServiceImpl( WxAppUserRepository wxAppUserRepository) {
        super(wxAppUserRepository);
        this.wxAppUserRepository = wxAppUserRepository;
    }

    @Override
    public Page<WxAppUser> list(WxAppUserCondition wxAppUserCondition, Pageable pageable) {
        log.info("微信公众号的用户查询列表");
        return wxAppUserDao.list(wxAppUserCondition, pageable);
    }
    
    @Override
    public List<WxAppUser> list(WxAppUserCondition wxAppUserCondition) {
        log.info("微信公众号的用户查询列表无分页");
        return wxAppUserDao.list(wxAppUserCondition);
    }

    /**
     * 根据字段获取所有符合的记录
     * @param appid 公众号ID
     * @return 符合条件的所有对象
     */
    @Override
    public List<WxAppUser>  findAllByAppid(String appid){
        return wxAppUserRepository.findAllByAppid(appid);
    }
    
     @Override
    public Page<WxAppUser>  findAllByAppid(String appid, Pageable pageable){
        return wxAppUserRepository.findAllByAppid(appid,pageable);
    }
    /**
     * 根据给定的字段返回符合的对象
     * @param openid 窗口id
     * @return 符合条件的唯一对象
     */
    @Override
    public WxAppUser findByOpenid(String openid){
         return wxAppUserRepository.findFirstByOpenid(openid);
    }
    /**
     * 根据给定的字段返回符合的对象
     * @param nickname 昵称
     * @return 符合条件的唯一对象
     */
    @Override
    public WxAppUser findByNickname(String nickname){
         return wxAppUserRepository.findFirstByNickname(nickname);
    }
    @Override 
    public WxAppUser findBy(String field,Object value){
        log.info("微信公众号的用户根据字["+field+"="+value+"] 进行查询符合条件的唯一值");
        return wxAppUserDao.findBy(field,value);
    }
    
    @Override 
    public List<WxAppUser> findAllBy(String field,Object value){
        log.info("微信公众号的用户根据字["+field+"="+value+"] 进行查询符合条件的所有记录");
        return wxAppUserDao.findAllBy(field,value);
    }

	@Override
	public WxAppUser findByAppIdAndOpenId(String appid, String openid) {
		Map<String, Object> params = new HashMap<String,Object>();
		params.put("appid", appid);
		params.put("openid", openid);
		return wxAppUserDao.findBy(params );
	}
}