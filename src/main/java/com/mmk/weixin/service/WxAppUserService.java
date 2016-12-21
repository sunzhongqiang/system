package com.mmk.weixin.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mmk.gene.service.BaseService;
import com.mmk.weixin.condition.WxAppUserCondition;
import com.mmk.weixin.model.WxAppUser;

/**
* WxAppUserService: 微信公众号的用户 业务服务层接口
*2016-12-21 15:42:41
*@author 
*@version 1.0
*/
public interface WxAppUserService extends BaseService<WxAppUser, Long> {
    /**
     * 生成的列表分页查询方法
     * @param wxAppUserCondition  查询条件
     * @param pageable 分页参数
     * @return 分页返回查询的结果
     * @author 
     * 
     */
    Page<WxAppUser> list(WxAppUserCondition wxAppUserCondition, Pageable pageable);
    
    /**
     * 不分页查询相关信息，根据传入的model类对象取得查询结果集List
     * @param  wxAppUser 查询类
     * @return 查询的结果集
     * @author 
     * 
     */
    public List<WxAppUser> list(WxAppUserCondition wxAppUser);

    /**
     * 根据字段获取所有符合的记录
     * @param appid 公众号ID
     * @return 符合条件的所有对象
     * @author 
     * 
     */
    List<WxAppUser> findAllByAppid(String appid);
    /**
     * 根据字段获取所有符合的记录
     * @param appid 公众号ID
     * @param pageable 分页参数
     * @return 符合条件的所有对象
     * @author 
     * 
     */
    Page<WxAppUser> findAllByAppid(String appid, Pageable pageable);
    /**
     * 根据给定的字段返回符合的对象
     * @param openid 窗口id
     * @return 符合条件的唯一对象
     * @author 
     * 
     */
    WxAppUser findByOpenid(String openid);
    /**
     * 根据给定的字段返回符合的对象
     * @param nickname 昵称
     * @return 符合条件的唯一对象
     * @author 
     * 
     */
    WxAppUser findByNickname(String nickname);
    /**
     * 根据给定的字段和属性值，获得符合条件的第一个结果
     * @param field WxAppUser 中的某个字段
     * @param value 字段的值
     * @return WxAppUser 返回符合条件的结果，如果没有返回null
     * @author 
     * 
     * 
     */
    WxAppUser findBy(String field,Object value);
    
    /**
     * 根据给定的字段和属性值，获得符合条件的所有结果
     * @param field WxAppUser中的某个字段
     * @param value 字段的值
     * @return 返回符合条件的所有结果
     * @author 
     * 
     * 
     */
    List<WxAppUser> findAllBy(String field,Object value);

    /**
     * 根据公众号和openid获取用户信息
     * @param appid 公众号
     * @param openid openid
     * @return null或者对应的用户
     */
	WxAppUser findByAppIdAndOpenId(String appid, String openid);
}