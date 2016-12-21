/*
 * 
 *  WxAppUserDaoImpl 创建于 2016-12-21 15:42:41 版权归作者和作者当前组织所有
 */
package com.mmk.weixin.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.mmk.gene.dao.impl.SpringDataQueryDaoImpl;
import com.mmk.weixin.condition.WxAppUserCondition;
import com.mmk.weixin.dao.WxAppUserDao;
import com.mmk.weixin.model.WxAppUser;



/**
* WxAppUserDaoImpl: 微信公众号的用户 数据持久层接口实现
*@author 
*@version 1.0
*
*/
@Repository
public class WxAppUserDaoImpl extends SpringDataQueryDaoImpl<WxAppUser> implements WxAppUserDao {
    
    private Log log = LogFactory.getLog(this.getClass());
    
    public WxAppUserDaoImpl(){
        super(WxAppUser.class);
    }
    
    /**
     * 分页查询相关信息，根据传入的bean类对象和分页对象page取得查询结果集List
     * @param wxAppUserCondition 查询类
     * @param pageable 传入的分页对象
     * @return 符合条件的查询结果集
     * @author 
     * 
     */
    @Override 
    public Page<WxAppUser> list(WxAppUserCondition wxAppUserCondition,Pageable pageable){
        StringBuffer sb=new StringBuffer("select model from WxAppUser model  where 1=1  ");
        Map<String,Object> params = new HashMap<String,Object>();
        return queryByJpql(sb.toString(), params, pageable);
    }

    @Override 
    public List<WxAppUser> list(WxAppUserCondition wxAppUserCondition){
        StringBuffer sb=new StringBuffer("select model from WxAppUser model  where 1=1  ");
        Map<String,Object> params = new HashMap<String,Object>();
        return queryByJpql(sb.toString(), params);
    }
    
    
    @Override 
    public Page< Map<String,Object>> listBySql(WxAppUserCondition condition,Pageable pageable){
        StringBuffer sb=new StringBuffer("select id,appid,openID,nickname,address_id,realname,sex,language,province,city,country,headimgurl,privilege from wx_app_user  where 1=1  ");
        Map<Integer,Object> params = new HashMap<Integer,Object>();
        return queryFieldsBySql(sb.toString(), params, pageable);
    }
    
    @Override 
    public WxAppUser findBy(String field,Object value){
        StringBuffer sb=new StringBuffer("select model from WxAppUser model  where model.");
        sb.append(field);
        sb.append(" = :value ");
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("value",value);
        List<WxAppUser> result = queryByJpql(sb.toString(), params,0l,1l);
        return result.isEmpty() ? null : result.get(0);
    }
    
    @Override 
    public List<WxAppUser> findAllBy(String field,Object value){
        StringBuffer sb=new StringBuffer("select model from WxAppUser model  where model.");
        sb.append(field);
       sb.append(" = :value ");
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("value",value);
        return queryByJpql(sb.toString(), params);
    }
    
    
}