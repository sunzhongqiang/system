/*
 * 
 *  UserRoleDaoImpl 创建于 2016-10-13 16:53:44 版权归作者和作者当前组织所有
 */
package com.mmk.system.dao.impl;

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

import com.mmk.system.model.UserRole;
import com.mmk.system.dao.UserRoleDao;

import com.mmk.system.condition.UserRoleCondition;



/**
* UserRoleDaoImpl: 系统用户角色 数据持久层接口实现
*@author 孙中强 sunzhongqiang
*@version 1.0
*
*/
@Repository
public class UserRoleDaoImpl extends SpringDataQueryDaoImpl<UserRole> implements UserRoleDao {
    
    private Log log = LogFactory.getLog(this.getClass());
    
    public UserRoleDaoImpl(){
        super(UserRole.class);
    }
    
    /**
     * 分页查询相关信息，根据传入的bean类对象和分页对象page取得查询结果集List
     * @param userRoleCondition 查询类
     * @param pageable 传入的分页对象
     * @return 符合条件的查询结果集
     * @author 孙中强 sunzhongqiang
     * 
     */
    @Override 
    public Page<UserRole> list(UserRoleCondition userRoleCondition,Pageable pageable){
        StringBuffer sb=new StringBuffer("select model from UserRole model  where 1=1  ");
        Map<String,Object> params = new HashMap<String,Object>();
        if(userRoleCondition.getId()!=null){
            sb.append(" and model.id = :id ");
            params.put("id",userRoleCondition.getId());
        }
        if(userRoleCondition.getUserId()!=null){
            sb.append(" and model.userId = :userId ");
            params.put("userId",userRoleCondition.getUserId());
        }
        return queryByJpql(sb.toString(), params, pageable);
    }

    @Override 
    public List<UserRole> list(UserRoleCondition userRoleCondition){
        StringBuffer sb=new StringBuffer("select model from UserRole model  where 1=1  ");
        Map<String,Object> params = new HashMap<String,Object>();
        if(userRoleCondition.getId()!=null){
            sb.append(" and model.id = :id ");
            params.put("id",userRoleCondition.getId());
        }
        if(userRoleCondition.getUserId()!=null){
            sb.append(" and model.userId = :userId ");
            params.put("userId",userRoleCondition.getUserId());
        }
        return queryByJpql(sb.toString(), params);
    }
    
    
    @Override 
    public Page< Map<String,Object>> listBySql(UserRoleCondition condition,Pageable pageable){
        StringBuffer sb=new StringBuffer("select id,user_id,role_code from system_user_role  where 1=1  ");
        Map<Integer,Object> params = new HashMap<Integer,Object>();
        if(condition.getId()!=null){
            sb.append(" and id = ?1 ");
            params.put(1,condition.getId());
        }
        if(condition.getUserId()!=null){
            sb.append(" and user_id = ?2 ");
            params.put(2,condition.getUserId());
        }
        return queryFieldsBySql(sb.toString(), params, pageable);
    }
    
    @Override 
    public UserRole findBy(String field,Object value){
        StringBuffer sb=new StringBuffer("select model from UserRole model  where model.");
        sb.append(field);
        sb.append(" = :value ");
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("value",value);
        List<UserRole> result = queryByJpql(sb.toString(), params,0l,1l);
        return result.isEmpty() ? null : result.get(0);
    }
    
    @Override 
    public List<UserRole> findAllBy(String field,Object value){
        StringBuffer sb=new StringBuffer("select model from UserRole model  where model.");
        sb.append(field);
       sb.append(" = :value ");
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("value",value);
        return queryByJpql(sb.toString(), params);
    }
    
    
}