/*
 * 
 *  LoginLogDaoImpl 创建于 2016-10-12 11:54:12 版权归作者和作者当前组织所有
 */
package com.mmk.system.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.mmk.gene.dao.impl.SpringDataQueryDaoImpl;
import com.mmk.system.condition.LoginLogCondition;
import com.mmk.system.dao.LoginLogDao;
import com.mmk.system.model.LoginLog;



/**
* LoginLogDaoImpl: 系统登录日志 数据持久层接口实现
*@author sunzhongqiang 孙中强
*@version 1.0
*
*/
@Repository
public class LoginLogDaoImpl extends SpringDataQueryDaoImpl<LoginLog> implements LoginLogDao {
    
    private Log log = LogFactory.getLog(this.getClass());
    
    public LoginLogDaoImpl(){
        super(LoginLog.class);
    }
    
    /**
     * 分页查询相关信息，根据传入的bean类对象和分页对象page取得查询结果集List
     * @param loginLogCondition 查询类
     * @param pageable 传入的分页对象
     * @return 符合条件的查询结果集
     * @author sunzhongqiang 孙中强
     * 
     */
    @Override 
    public Page<LoginLog> list(LoginLogCondition loginLogCondition,Pageable pageable){
        StringBuffer sb=new StringBuffer("select model from LoginLog model  where 1=1  ");
        Map<String,Object> params = new HashMap<String,Object>();
        if(loginLogCondition.getId()!=null){
            sb.append(" and model.id = :id ");
            params.put("id",loginLogCondition.getId());
        }
        if(loginLogCondition.getUserId()!=null){
            sb.append(" and model.userId = :userId ");
            params.put("userId",loginLogCondition.getUserId());
        }
        if(loginLogCondition.getLoginTime()!=null){
            sb.append(" and model.loginTime = :loginTime ");
            params.put("loginTime",loginLogCondition.getLoginTime());
        }
        return queryByJpql(sb.toString(), params, pageable);
    }

    @Override 
    public List<LoginLog> list(LoginLogCondition loginLogCondition){
        StringBuffer sb=new StringBuffer("select model from LoginLog model  where 1=1  ");
        Map<String,Object> params = new HashMap<String,Object>();
        if(loginLogCondition.getId()!=null){
            sb.append(" and model.id = :id ");
            params.put("id",loginLogCondition.getId());
        }
        if(loginLogCondition.getUserId()!=null){
            sb.append(" and model.userId = :userId ");
            params.put("userId",loginLogCondition.getUserId());
        }
        if(loginLogCondition.getLoginTime()!=null){
            sb.append(" and model.loginTime = :loginTime ");
            params.put("loginTime",loginLogCondition.getLoginTime());
        }
        return queryByJpql(sb.toString(), params);
    }
    
    
    @Override 
    public Page< Map<String,Object>> listBySql(LoginLogCondition condition,Pageable pageable){
        StringBuffer sb=new StringBuffer("select id,user_id,username,realname,login_time,status,ip from system_login_log  where 1=1  ");
        Map<Integer,Object> params = new HashMap<Integer,Object>();
        if(condition.getId()!=null){
            sb.append(" and id = ?1 ");
            params.put(1,condition.getId());
        }
        if(condition.getUserId()!=null){
            sb.append(" and user_id = ?2 ");
            params.put(2,condition.getUserId());
        }
        if(condition.getLoginTime()!=null){
            sb.append(" and login_time = ?5 ");
            params.put(5,condition.getLoginTime());
        }
        return queryFieldsBySql(sb.toString(), params, pageable);
    }
    
    @Override 
    public LoginLog findBy(String field,Object value){
        StringBuffer sb=new StringBuffer("select model from LoginLog model  where model.");
        sb.append(field);
        sb.append(" = :value ");
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("value",value);
        List<LoginLog> result = queryByJpql(sb.toString(), params,0l,1l);
        return result.isEmpty() ? null : result.get(0);
    }
    
    @Override 
    public List<LoginLog> findAllBy(String field,Object value){
        StringBuffer sb=new StringBuffer("select model from LoginLog model  where model.");
        sb.append(field);
       sb.append(" = :value ");
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("value",value);
        return queryByJpql(sb.toString(), params);
    }
    
    
}