/*
 * 
 *  RoleDaoImpl 创建于 2016-10-24 14:26:41 版权归作者和作者当前组织所有
 */
package com.mmk.system.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.mmk.gene.dao.impl.SpringDataQueryDaoImpl;
import com.mmk.system.condition.RoleCondition;
import com.mmk.system.dao.RoleDao;
import com.mmk.system.model.Role;



/**
* RoleDaoImpl: 系统角色 数据持久层接口实现
*@author huguangling 胡广玲
*@version 1.0
*
*/
@Repository
public class RoleDaoImpl extends SpringDataQueryDaoImpl<Role> implements RoleDao {
    
    private Log log = LogFactory.getLog(this.getClass());
    
    public RoleDaoImpl(){
        super(Role.class);
    }
    
    /**
     * 分页查询相关信息，根据传入的bean类对象和分页对象page取得查询结果集List
     * @param roleCondition 查询类
     * @param pageable 传入的分页对象
     * @return 符合条件的查询结果集
     * @author huguangling 胡广玲
     * 
     */
    @Override 
    public Page<Role> list(RoleCondition roleCondition,Pageable pageable){
        StringBuffer sb=new StringBuffer("select model from Role model  where 1=1  ");
        Map<String,Object> params = new HashMap<String,Object>();
        if(StringUtils.isNotBlank(roleCondition.getCode())){
            sb.append(" and model.code like :code ");
            params.put("code","%"+roleCondition.getCode()+"%");
        }
        if(StringUtils.isNotBlank(roleCondition.getName())){
            sb.append(" and model.name like :name ");
            params.put("name","%"+roleCondition.getName()+"%");
        }
        if(StringUtils.isNotBlank(roleCondition.getStatus())){
            sb.append(" and model.status = :status ");
            params.put("status",roleCondition.getStatus());
        }
        return queryByJpql(sb.toString(), params, pageable);
    }

    @Override 
    public List<Role> list(RoleCondition roleCondition){
        StringBuffer sb=new StringBuffer("select model from Role model  where 1=1  ");
        Map<String,Object> params = new HashMap<String,Object>();
        if(StringUtils.isNotBlank(roleCondition.getCode())){
            sb.append(" and model.code like :code ");
            params.put("code","%"+roleCondition.getCode()+"%");
        }
        if(StringUtils.isNotBlank(roleCondition.getName())){
            sb.append(" and model.name like :name ");
            params.put("name","%"+roleCondition.getName()+"%");
        }
        if(StringUtils.isNotBlank(roleCondition.getStatus())){
            sb.append(" and model.status = :status ");
            params.put("status",roleCondition.getStatus());
        }
        return queryByJpql(sb.toString(), params);
    }
    
    
    @Override 
    public Page< Map<String,Object>> listBySql(RoleCondition condition,Pageable pageable){
        StringBuffer sb=new StringBuffer("select id,code,name,status from system_role  where 1=1  ");
        Map<Integer,Object> params = new HashMap<Integer,Object>();
        if(StringUtils.isNotBlank(condition.getCode())){
            sb.append(" and code like ?2 ");
            params.put(2,"%"+condition.getCode()+"%");
        }
        if(StringUtils.isNotBlank(condition.getName())){
            sb.append(" and name like ?3 ");
            params.put(3,"%"+condition.getName()+"%");
        }
        if(StringUtils.isNotBlank(condition.getStatus())){
            sb.append(" and status = ?4 ");
            params.put(4,condition.getStatus());
        }
        return queryFieldsBySql(sb.toString(), params, pageable);
    }
    
    @Override 
    public Role findBy(String field,Object value){
        StringBuffer sb=new StringBuffer("select model from Role model  where model.");
        sb.append(field);
        sb.append(" = :value ");
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("value",value);
        List<Role> result = queryByJpql(sb.toString(), params,0l,1l);
        return result.isEmpty() ? null : result.get(0);
    }
    
    @Override 
    public List<Role> findAllBy(String field,Object value){
        StringBuffer sb=new StringBuffer("select model from Role model  where model.");
        sb.append(field);
        sb.append(" = :value ");
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("value",value);
        return queryByJpql(sb.toString(), params);
    }
      
}