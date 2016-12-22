package com.mmk.weixin.service;

import java.util.Date;
import java.util.List;
import com.mmk.gene.service.BaseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.mmk.weixin.model.WxAppConfig;
import com.mmk.weixin.condition.WxAppConfigCondition;

/**
* WxAppConfigService: 微信开发者账号配置 业务服务层接口
*2016-12-22 08:39:57
*@author 孙中强 sunzhongqiang
*@version 1.0
*/
public interface WxAppConfigService extends BaseService<WxAppConfig, Long> {
    /**
     * 生成的列表分页查询方法
     * @param wxAppConfigCondition  查询条件
     * @param pageable 分页参数
     * @return 分页返回查询的结果
     * @author 孙中强 sunzhongqiang
     * 
     */
    Page<WxAppConfig> list(WxAppConfigCondition wxAppConfigCondition, Pageable pageable);
    
    /**
     * 不分页查询相关信息，根据传入的model类对象取得查询结果集List
     * @param  wxAppConfig 查询类
     * @return 查询的结果集
     * @author 孙中强 sunzhongqiang
     * 
     */
    public List<WxAppConfig> list(WxAppConfigCondition wxAppConfig);

    /**
     * 是否存在该
     * @param code 配置名称
     * @return 如果存在的话返回true ,没有的返回false
     * @author 孙中强 sunzhongqiang
     * 
     */
    boolean existsCode(String code);
    /**
     * 根据给定的字段返回符合的对象
     * @param code 配置名称
     * @return 符合条件的唯一对象
     * @author 孙中强 sunzhongqiang
     * 
     */
    WxAppConfig findByCode(String code);
    /**
     * 根据给定的字段和属性值，获得符合条件的第一个结果
     * @param field WxAppConfig 中的某个字段
     * @param value 字段的值
     * @return WxAppConfig 返回符合条件的结果，如果没有返回null
     * @author 孙中强 sunzhongqiang
     * 
     * 
     */
    WxAppConfig findBy(String field,Object value);
    
    /**
     * 根据给定的字段和属性值，获得符合条件的所有结果
     * @param field WxAppConfig中的某个字段
     * @param value 字段的值
     * @return 返回符合条件的所有结果
     * @author 孙中强 sunzhongqiang
     * 
     * 
     */
    List<WxAppConfig> findAllBy(String field,Object value);
    
    /**
     * 刷新配置的值
     * @param code 编码
     * @param value 值
     * @param remark 备注
     */
    void refresh(String code,String value ,String remark);
}