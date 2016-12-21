/*
 * 
 *  WxAuthAppDaoImpl 创建于 2016-12-21 11:14:34 版权归作者和作者当前组织所有
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
import com.mmk.weixin.condition.WxAppAuthCondition;
import com.mmk.weixin.dao.WxAppAuthDao;
import com.mmk.weixin.model.WxAppAuth;



/**
* WxAuthAppDaoImpl: 微信授权APP 数据持久层接口实现
*@author 孙中强 sunzhongqiang
*@version 1.0
*
*/
@Repository
public class WxAppAuthDaoImpl extends SpringDataQueryDaoImpl<WxAppAuth> implements WxAppAuthDao {
    
    private Log log = LogFactory.getLog(this.getClass());
    
    public WxAppAuthDaoImpl(){
        super(WxAppAuth.class);
    }
    
    /**
     * 分页查询相关信息，根据传入的bean类对象和分页对象page取得查询结果集List
     * @param wxAuthAppCondition 查询类
     * @param pageable 传入的分页对象
     * @return 符合条件的查询结果集
     * @author 孙中强 sunzhongqiang
     * 
     */
    @Override 
    public Page<WxAppAuth> list(WxAppAuthCondition wxAuthAppCondition,Pageable pageable){
        StringBuffer sb=new StringBuffer("select model from WxAuthApp model  where 1=1  ");
        Map<String,Object> params = new HashMap<String,Object>();
        return queryByJpql(sb.toString(), params, pageable);
    }

    @Override 
    public List<WxAppAuth> list(WxAppAuthCondition wxAuthAppCondition){
        StringBuffer sb=new StringBuffer("select model from WxAuthApp model  where 1=1  ");
        Map<String,Object> params = new HashMap<String,Object>();
        return queryByJpql(sb.toString(), params);
    }
    
    
    @Override 
    public Page< Map<String,Object>> listBySql(WxAppAuthCondition condition,Pageable pageable){
        StringBuffer sb=new StringBuffer("select id,authorizer_appid,authorizer_access_token,authorizer_refresh_token,expires_in,modified,nick_name,head_img,user_name,principal_name,alias,business_info,qrcode_url,func_info,authorization_info from wx_auth_app  where 1=1  ");
        Map<Integer,Object> params = new HashMap<Integer,Object>();
        return queryFieldsBySql(sb.toString(), params, pageable);
    }
    
    @Override 
    public WxAppAuth findBy(String field,Object value){
        StringBuffer sb=new StringBuffer("select model from WxAuthApp model  where model.");
        sb.append(field);
        sb.append(" = :value ");
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("value",value);
        List<WxAppAuth> result = queryByJpql(sb.toString(), params,0l,1l);
        return result.isEmpty() ? null : result.get(0);
    }
    
    @Override 
    public List<WxAppAuth> findAllBy(String field,Object value){
        StringBuffer sb=new StringBuffer("select model from WxAuthApp model  where model.");
        sb.append(field);
       sb.append(" = :value ");
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("value",value);
        return queryByJpql(sb.toString(), params);
    }
    
    
}