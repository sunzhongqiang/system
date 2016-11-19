/*
 * 
 *  OrganizationDaoImpl 创建于 2016-10-24 10:07:36 版权归作者和作者当前组织所有
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
import com.mmk.system.condition.OrganizationCondition;
import com.mmk.system.dao.OrganizationDao;
import com.mmk.system.model.Organization;



/**
* OrganizationDaoImpl: 组织机构 数据持久层接口实现
*@author 孙中强 sunzhongqiang
*@version 1.0
*
*/
@Repository
public class OrganizationDaoImpl extends SpringDataQueryDaoImpl<Organization> implements OrganizationDao {
    
    private Log log = LogFactory.getLog(this.getClass());
    
    public OrganizationDaoImpl(){
        super(Organization.class);
    }
    
    /**
     * 分页查询相关信息，根据传入的bean类对象和分页对象page取得查询结果集List
     * @param organizationCondition 查询类
     * @param pageable 传入的分页对象
     * @return 符合条件的查询结果集
     * @author 孙中强 sunzhongqiang
     * 
     */
    @Override 
    public Page<Organization> list(OrganizationCondition organizationCondition,Pageable pageable){
        StringBuffer sb=new StringBuffer("select model from Organization model  where 1=1  ");
        Map<String,Object> params = new HashMap<String,Object>();
        return queryByJpql(sb.toString(), params, pageable);
    }

    @Override 
    public List<Organization> list(OrganizationCondition organizationCondition){
        StringBuffer sb=new StringBuffer("select model from Organization model  where 1=1  ");
        Map<String,Object> params = new HashMap<String,Object>();
        return queryByJpql(sb.toString(), params);
    }
    
    
    @Override 
    public Page< Map<String,Object>> listBySql(OrganizationCondition condition,Pageable pageable){
        StringBuffer sb=new StringBuffer("select id,name,code,parent_id from system_organization  where 1=1  ");
        Map<Integer,Object> params = new HashMap<Integer,Object>();
        return queryFieldsBySql(sb.toString(), params, pageable);
    }
    
    @Override 
    public Organization findBy(String field,Object value){
        StringBuffer sb=new StringBuffer("select model from Organization model  where model.");
        sb.append(field);
        sb.append(" = :value ");
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("value",value);
        List<Organization> result = queryByJpql(sb.toString(), params,0l,1l);
        return result.isEmpty() ? null : result.get(0);
    }
    
    @Override 
    public List<Organization> findAllBy(String field,Object value){
        StringBuffer sb=new StringBuffer("select model from Organization model  where model.");
        sb.append(field);
       sb.append(" = :value ");
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("value",value);
        return queryByJpql(sb.toString(), params);
    }
      
}