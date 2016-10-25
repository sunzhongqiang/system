/*
 * 
 *  PrivilegeDaoImpl 创建于 2016-10-25 09:35:10 版权归作者和作者当前组织所有
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

import com.mmk.system.model.Privilege;
import com.mmk.system.dao.PrivilegeDao;

import com.mmk.system.condition.PrivilegeCondition;



/**
* PrivilegeDaoImpl: 系统权限表 数据持久层接口实现
*@author 
*@version 1.0
*
*/
@Repository
public class PrivilegeDaoImpl extends SpringDataQueryDaoImpl<Privilege> implements PrivilegeDao {
    
    private Log log = LogFactory.getLog(this.getClass());
    
    public PrivilegeDaoImpl(){
        super(Privilege.class);
    }
    
    /**
     * 分页查询相关信息，根据传入的bean类对象和分页对象page取得查询结果集List
     * @param privilegeCondition 查询类
     * @param pageable 传入的分页对象
     * @return 符合条件的查询结果集
     * @author 
     * 
     */
    @Override 
    public Page<Privilege> list(PrivilegeCondition privilegeCondition,Pageable pageable){
        StringBuffer sb=new StringBuffer("select model from Privilege model  where 1=1  ");
        Map<String,Object> params = new HashMap<String,Object>();
        return queryByJpql(sb.toString(), params, pageable);
    }

    @Override 
    public List<Privilege> list(PrivilegeCondition privilegeCondition){
        StringBuffer sb=new StringBuffer("select model from Privilege model  where 1=1  ");
        Map<String,Object> params = new HashMap<String,Object>();
        return queryByJpql(sb.toString(), params);
    }
    
    
    @Override 
    public Page< Map<String,Object>> listBySql(PrivilegeCondition condition,Pageable pageable){
        StringBuffer sb=new StringBuffer("select id,role_code,function_uri from system_privilege  where 1=1  ");
        Map<Integer,Object> params = new HashMap<Integer,Object>();
        return queryFieldsBySql(sb.toString(), params, pageable);
    }
    
    @Override 
    public Privilege findBy(String field,Object value){
        StringBuffer sb=new StringBuffer("select model from Privilege model  where model.");
        sb.append(field);
        sb.append(" = :value ");
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("value",value);
        List<Privilege> result = queryByJpql(sb.toString(), params,0l,1l);
        return result.isEmpty() ? null : result.get(0);
    }
    
    @Override 
    public List<Privilege> findAllBy(String field,Object value){
        StringBuffer sb=new StringBuffer("select model from Privilege model  where model.");
        sb.append(field);
       sb.append(" = :value ");
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("value",value);
        return queryByJpql(sb.toString(), params);
    }
    
    
}