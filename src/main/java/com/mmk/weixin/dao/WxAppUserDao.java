/*
 * 
 *  WxAppUserDao 创建于 2016-12-21 15:42:41 版权归作者和作者当前组织所有
 */
package com.mmk.weixin.dao;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mmk.gene.dao.SpringDataQueryDao;
import com.mmk.weixin.condition.WxAppUserCondition;
import com.mmk.weixin.model.WxAppUser;
/**
* WxAppUserDao:微信公众号的用户 数据持久层接口
* @author 
* @version 1.0
*/
public interface WxAppUserDao extends SpringDataQueryDao<WxAppUser>{
    
    /**
     * 分页查询相关信息，根据传入的bean类对象和分页对象page取得查询结果集List
     * @param wxAppUser 查询类
     * @param pageable 传入的分页对象
     * @return 符合条件的查询结果集
     * @author 
     * 
     * 
     */
    Page<WxAppUser> list(WxAppUserCondition wxAppUser,Pageable pageable);
    /**
     * 不分页查询相关信息，根据传入的model类对象取得查询结果集List
     * @param wxAppUser 查询类
     * @return 符合条件的查询结果集
     * @author 
     * 
     */
    List<WxAppUser> list(WxAppUserCondition wxAppUser);
    /**
     * 使用sql查询，并以map和分页的形式进行返回数据结果
     * @param wxAppUser WxAppUser类
     * @param pageable 传入的分页对象
     * @return 符合条件的查询结果集
     * @author 
     * 
     * 
     */
    Page<Map<String,Object>> listBySql(WxAppUserCondition wxAppUser,Pageable pageable);
    /**
     * 根据给定的字段和属性值，获得符合条件的第一个结果
     * @param field WxAppUser 中的某个字段
     * @param value 字段对应的值
     * @return 返回符合条件的结果，如果没有返回null
     * @author 
     * 
     * 
     */
    WxAppUser findBy(String field,Object value);
    
    /**
     * 根据给定的字段和属性值，获得符合条件的所有结果
     * @param field WxAppUser 中的某个字段
     * @param value 字段对应的值
     * @return 返回符合条件的所有结果
     * @author 
     * 
     * 
     */
    List<WxAppUser> findAllBy(String field,Object value);
    
    

}