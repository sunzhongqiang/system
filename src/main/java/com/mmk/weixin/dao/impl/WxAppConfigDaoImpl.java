/*
 * 
 *  WxAppConfigDaoImpl 创建于 2016-12-22 08:39:57 版权归作者和作者当前组织所有
 */
package com.mmk.weixin.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import javax.annotation.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import com.mmk.gene.dao.impl.SpringDataQueryDaoImpl;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.mmk.weixin.model.WxAppConfig;
import com.mmk.weixin.dao.WxAppConfigDao;

import com.mmk.weixin.condition.WxAppConfigCondition;



/**
* WxAppConfigDaoImpl: 微信开发者账号配置 数据持久层接口实现
*@author 孙中强 sunzhongqiang
*@version 1.0
*
*/
@Repository
public class WxAppConfigDaoImpl extends SpringDataQueryDaoImpl<WxAppConfig> implements WxAppConfigDao {
    
    private Log log = LogFactory.getLog(this.getClass());
    
    public WxAppConfigDaoImpl(){
        super(WxAppConfig.class);
    }
    
    /**
     * 分页查询相关信息，根据传入的bean类对象和分页对象page取得查询结果集List
     * @param wxAppConfigCondition 查询类
     * @param pageable 传入的分页对象
     * @return 符合条件的查询结果集
     * @author 孙中强 sunzhongqiang
     * 
     */
    @Override 
    public Page<WxAppConfig> list(WxAppConfigCondition wxAppConfigCondition,Pageable pageable){
        StringBuffer sb=new StringBuffer("select model from WxAppConfig model  where 1=1  ");
        Map<String,Object> params = new HashMap<String,Object>();
        return queryByJpql(sb.toString(), params, pageable);
    }

    @Override 
    public List<WxAppConfig> list(WxAppConfigCondition wxAppConfigCondition){
        StringBuffer sb=new StringBuffer("select model from WxAppConfig model  where 1=1  ");
        Map<String,Object> params = new HashMap<String,Object>();
        return queryByJpql(sb.toString(), params);
    }
    
    
    @Override 
    public Page< Map<String,Object>> listBySql(WxAppConfigCondition condition,Pageable pageable){
        StringBuffer sb=new StringBuffer("select id,code,value,remark from wx_app_config  where 1=1  ");
        Map<Integer,Object> params = new HashMap<Integer,Object>();
        return queryFieldsBySql(sb.toString(), params, pageable);
    }
    
    @Override 
    public WxAppConfig findBy(String field,Object value){
        StringBuffer sb=new StringBuffer("select model from WxAppConfig model  where model.");
        sb.append(field);
        sb.append(" = :value ");
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("value",value);
        List<WxAppConfig> result = queryByJpql(sb.toString(), params,0l,1l);
        return result.isEmpty() ? null : result.get(0);
    }
    
    @Override 
    public List<WxAppConfig> findAllBy(String field,Object value){
        StringBuffer sb=new StringBuffer("select model from WxAppConfig model  where model.");
        sb.append(field);
       sb.append(" = :value ");
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("value",value);
        return queryByJpql(sb.toString(), params);
    }
    
    
}