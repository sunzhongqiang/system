/*
 * 
 *  UserRoleDaoImpl 创建于 2016-10-27 08:21:19 版权归作者和作者当前组织所有
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
import com.mmk.system.condition.UserRoleCondition;
import com.mmk.system.dao.UserRoleDao;
import com.mmk.system.model.UserRole;



/**
* UserRoleDaoImpl: 系统用户角色 数据持久层接口实现
*@author code
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
     * @author code
     * 
     */
    @Override 
    public Page<UserRole> list(UserRoleCondition userRoleCondition,Pageable pageable){
        StringBuffer sb=new StringBuffer("select model from UserRole model  where 1=1  ");
        Map<String,Object> params = new HashMap<String,Object>();
        if(userRoleCondition.getUserId() !=null ){
            sb.append(" and model.userId = :userId ");
            params.put("userId",userRoleCondition.getUserId());
        }
        if(userRoleCondition.getRoleId()!= null){
            sb.append(" and model.roleId = :roleId ");
            params.put("roleId",userRoleCondition.getRoleId());
        }
        return queryByJpql(sb.toString(), params, pageable);
    }

    @Override 
    public List<UserRole> list(UserRoleCondition userRoleCondition){
        StringBuffer sb=new StringBuffer("select model from UserRole model  where 1=1  ");
        Map<String,Object> params = new HashMap<String,Object>();
        if(userRoleCondition.getUserId()!=null){
            sb.append(" and model.userId = :userId ");
            params.put("userId",userRoleCondition.getUserId());
        }
        if(userRoleCondition.getRoleId()!=null){
            sb.append(" and model.roleId = :roleId ");
            params.put("roleId",userRoleCondition.getRoleId());
        }
        return queryByJpql(sb.toString(), params);
    }
    
    
    @Override 
    public Page< Map<String,Object>> listBySql(UserRoleCondition condition,Pageable pageable){
        StringBuffer sb=new StringBuffer("select id,user_id,role_id from system_user_role  where 1=1  ");
        Map<Integer,Object> params = new HashMap<Integer,Object>();
        if(condition.getUserId()!=null){
            sb.append(" and user_id = ?2 ");
            params.put(2,condition.getUserId());
        }
        if(condition.getRoleId()!=null){
            sb.append(" and role_id = ?3 ");
            params.put(3,condition.getRoleId());
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

	@Override
	public List<Map<String, Object>> findRoleListByUserId(Long userId) {
		Map<Integer, Object> params = new HashMap<Integer, Object>();
		StringBuffer sb = new StringBuffer("SELECT role.id AS roleID,role.name AS roleName, user_role.user_id AS userId, user_role.id AS userRoleID ");
		sb.append("from system_role  role");
	    sb.append(" LEFT JOIN ( ");
	    sb.append(" select role_id,user_id,id from system_user_role  uRole ");
	    if(userId!=null){
	    	sb.append(" where uRole.user_id = ?1 ");
	    	params.put(1, userId);
	    }else{
	    	sb.append(" where 1<>1 ");
	    }
	    sb.append(" )   user_role ON role.id=  user_role.role_id ");
	    return queryFieldsBySql(sb.toString(), params);
	}

	@Override
	public UserRole findByUserIdAndRoleId(Long userId, Long roleId) {
		StringBuffer sb = new StringBuffer("select model from UserRole model  where 1=1  ");
		Map<String, Object> params = new HashMap<String, Object>();
		if(roleId!=null){
			sb.append(" and model.roleId = :roleId ");
			params.put("roleId", roleId);
		}
		if(roleId!=null){
			sb.append(" and model.userId = :userId ");
			params.put("userId", userId);
		}
		List<UserRole> result = queryByJpql(sb.toString(), params);
		return result.isEmpty() ? null : result.get(0);
	}
       
}