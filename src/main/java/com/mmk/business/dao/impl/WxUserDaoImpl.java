/*
 * 
 *  WxUserDaoImpl 创建于 2016-10-28 14:50:57 版权归作者和作者当前组织所有
 */
package com.mmk.business.dao.impl;

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

import com.mmk.business.model.WxUser;
import com.mmk.business.dao.WxUserDao;

import com.mmk.business.condition.WxUserCondition;



/**
* WxUserDaoImpl: 微信用户 数据持久层接口实现
*@author 胡广玲 huguangling
*@version 1.0
*
*/
@Repository
public class WxUserDaoImpl extends SpringDataQueryDaoImpl<WxUser> implements WxUserDao {
    
    private Log log = LogFactory.getLog(this.getClass());
    
    public WxUserDaoImpl(){
        super(WxUser.class);
    }
    
    /**
     * 分页查询相关信息，根据传入的bean类对象和分页对象page取得查询结果集List
     * @param wxUserCondition 查询类
     * @param pageable 传入的分页对象
     * @return 符合条件的查询结果集
     * @author 胡广玲 huguangling
     * 
     */
    @Override 
    public Page<WxUser> list(WxUserCondition wxUserCondition,Pageable pageable){
        StringBuffer sb=new StringBuffer("select model from WxUser model  where 1=1  ");
        Map<String,Object> params = new HashMap<String,Object>();
        if(StringUtils.isNotBlank(wxUserCondition.getNickname())){
            sb.append(" and model.nickname like :nickname ");
            params.put("nickname","%"+wxUserCondition.getNickname()+"%");
        }
        if(StringUtils.isNotBlank(wxUserCondition.getRealname())){
            sb.append(" and model.realname like :realname ");
            params.put("realname","%"+wxUserCondition.getRealname()+"%");
        }
        if(StringUtils.isNotBlank(wxUserCondition.getCity())){
            sb.append(" and model.city = :city ");
            params.put("city",wxUserCondition.getCity());
        }
        if(StringUtils.isNotBlank(wxUserCondition.getCountry())){
            sb.append(" and model.country = :country ");
            params.put("country",wxUserCondition.getCountry());
        }
        return queryByJpql(sb.toString(), params, pageable);
    }

    @Override 
    public List<WxUser> list(WxUserCondition wxUserCondition){
        StringBuffer sb=new StringBuffer("select model from WxUser model  where 1=1  ");
        Map<String,Object> params = new HashMap<String,Object>();
        if(StringUtils.isNotBlank(wxUserCondition.getNickname())){
            sb.append(" and model.nickname like :nickname ");
            params.put("nickname","%"+wxUserCondition.getNickname()+"%");
        }
        if(StringUtils.isNotBlank(wxUserCondition.getRealname())){
            sb.append(" and model.realname like :realname ");
            params.put("realname","%"+wxUserCondition.getRealname()+"%");
        }
        if(StringUtils.isNotBlank(wxUserCondition.getCity())){
            sb.append(" and model.city = :city ");
            params.put("city",wxUserCondition.getCity());
        }
        if(StringUtils.isNotBlank(wxUserCondition.getCountry())){
            sb.append(" and model.country = :country ");
            params.put("country",wxUserCondition.getCountry());
        }
        return queryByJpql(sb.toString(), params);
    }
    
    
    @Override 
    public Page< Map<String,Object>> listBySql(WxUserCondition condition,Pageable pageable){
        StringBuffer sb=new StringBuffer("select id,openID,nickname,realname,sex,language,privince,city,country,headimgurl,privilege from business_wx_user  where 1=1  ");
        Map<Integer,Object> params = new HashMap<Integer,Object>();
        if(StringUtils.isNotBlank(condition.getNickname())){
            sb.append(" and nickname like ?3 ");
            params.put(3,"%"+condition.getNickname()+"%");
        }
        if(StringUtils.isNotBlank(condition.getRealname())){
            sb.append(" and realname like ?4 ");
            params.put(4,"%"+condition.getRealname()+"%");
        }
        if(StringUtils.isNotBlank(condition.getCity())){
            sb.append(" and city = ?8 ");
            params.put(8,condition.getCity());
        }
        if(StringUtils.isNotBlank(condition.getCountry())){
            sb.append(" and country = ?9 ");
            params.put(9,condition.getCountry());
        }
        return queryFieldsBySql(sb.toString(), params, pageable);
    }
    
    @Override 
    public WxUser findBy(String field,Object value){
        StringBuffer sb=new StringBuffer("select model from WxUser model  where model.");
        sb.append(field);
        sb.append(" = :value ");
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("value",value);
        List<WxUser> result = queryByJpql(sb.toString(), params,0l,1l);
        return result.isEmpty() ? null : result.get(0);
    }
    
    @Override 
    public List<WxUser> findAllBy(String field,Object value){
        StringBuffer sb=new StringBuffer("select model from WxUser model  where model.");
        sb.append(field);
       sb.append(" = :value ");
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("value",value);
        return queryByJpql(sb.toString(), params);
    }
    
    
}