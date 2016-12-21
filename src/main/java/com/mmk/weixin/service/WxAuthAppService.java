package com.mmk.weixin.service;

import java.util.Date;
import java.util.List;
import com.mmk.gene.service.BaseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.mmk.weixin.model.WxAuthApp;
import com.mmk.weixin.condition.WxAuthAppCondition;

/**
* WxAuthAppService: 微信授权APP 业务服务层接口
*2016-12-21 11:14:34
*@author 孙中强 sunzhongqiang
*@version 1.0
*/
public interface WxAuthAppService extends BaseService<WxAuthApp, Long> {
    /**
     * 生成的列表分页查询方法
     * @param wxAuthAppCondition  查询条件
     * @param pageable 分页参数
     * @return 分页返回查询的结果
     * @author 孙中强 sunzhongqiang
     * 
     */
    Page<WxAuthApp> list(WxAuthAppCondition wxAuthAppCondition, Pageable pageable);
    
    /**
     * 不分页查询相关信息，根据传入的model类对象取得查询结果集List
     * @param  wxAuthApp 查询类
     * @return 查询的结果集
     * @author 孙中强 sunzhongqiang
     * 
     */
    public List<WxAuthApp> list(WxAuthAppCondition wxAuthApp);

    /**
     * 根据给定的字段返回符合的对象
     * @param authorizerAppid 授权方appid
     * @return 符合条件的唯一对象
     * @author 孙中强 sunzhongqiang
     * 
     */
    WxAuthApp findByAuthorizerAppid(String authorizerAppid);
    /**
     * 根据字段获取所有符合的记录
     * @param modified 更新时间
     * @return 符合条件的所有对象
     * @author 孙中强 sunzhongqiang
     * 
     */
    List<WxAuthApp> findAllByModified(Date modified);
    /**
     * 根据字段获取所有符合的记录
     * @param modified 更新时间
     * @param pageable 分页参数
     * @return 符合条件的所有对象
     * @author 孙中强 sunzhongqiang
     * 
     */
    Page<WxAuthApp> findAllByModified(Date modified, Pageable pageable);
    /**
     * 根据给定的字段返回符合的对象
     * @param nickName 昵称
     * @return 符合条件的唯一对象
     * @author 孙中强 sunzhongqiang
     * 
     */
    WxAuthApp findByNickName(String nickName);
    /**
     * 根据给定的字段和属性值，获得符合条件的第一个结果
     * @param field WxAuthApp 中的某个字段
     * @param value 字段的值
     * @return WxAuthApp 返回符合条件的结果，如果没有返回null
     * @author 孙中强 sunzhongqiang
     * 
     * 
     */
    WxAuthApp findBy(String field,Object value);
    
    /**
     * 根据给定的字段和属性值，获得符合条件的所有结果
     * @param field WxAuthApp中的某个字段
     * @param value 字段的值
     * @return 返回符合条件的所有结果
     * @author 孙中强 sunzhongqiang
     * 
     * 
     */
    List<WxAuthApp> findAllBy(String field,Object value);
}