package com.mmk.business.service;

import java.util.List;
import com.mmk.gene.service.BaseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.mmk.business.model.WxUser;
import com.mmk.business.condition.WxUserCondition;

/**
* WxUserService: 微信用户 业务服务层接口
*2016-10-28 14:50:57
*@author 胡广玲 huguangling
*@version 1.0
*/
public interface WxUserService extends BaseService<WxUser, Long> {
    /**
     * 生成的列表分页查询方法
     * @param wxUserCondition  查询条件
     * @param pageable 分页参数
     * @return 分页返回查询的结果
     * @author 胡广玲 huguangling
     * 
     */
    Page<WxUser> list(WxUserCondition wxUserCondition, Pageable pageable);
    
    /**
     * 不分页查询相关信息，根据传入的model类对象取得查询结果集List
     * @param  wxUser 查询类
     * @return 查询的结果集
     * @author 胡广玲 huguangling
     * 
     */
    public List<WxUser> list(WxUserCondition wxUser);

    /**
     * 根据给定的字段和属性值，获得符合条件的第一个结果
     * @param field WxUser 中的某个字段
     * @param value 字段的值
     * @return WxUser 返回符合条件的结果，如果没有返回null
     * @author 胡广玲 huguangling
     * 
     * 
     */
    WxUser findBy(String field,Object value);
    
    /**
     * 根据给定的字段和属性值，获得符合条件的所有结果
     * @param field WxUser中的某个字段
     * @param value 字段的值
     * @return 返回符合条件的所有结果
     * @author 胡广玲 huguangling
     * 
     * 
     */
    List<WxUser> findAllBy(String field,Object value);
}