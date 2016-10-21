/*
 * 
 *  FunctionDaoImpl 创建于 2016-10-21 15:48:04 版权归作者和作者当前组织所有
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

import com.mmk.system.model.Function;
import com.mmk.system.dao.FunctionDao;

import com.mmk.system.condition.FunctionCondition;



/**
* FunctionDaoImpl: 系统功能 数据持久层接口实现
*@author codegenerator
*@version 1.0
*
*/
@Repository
public class FunctionDaoImpl extends SpringDataQueryDaoImpl<Function> implements FunctionDao {
    
    private Log log = LogFactory.getLog(this.getClass());
    
    public FunctionDaoImpl(){
        super(Function.class);
    }
    
    /**
     * 分页查询相关信息，根据传入的bean类对象和分页对象page取得查询结果集List
     * @param functionCondition 查询类
     * @param pageable 传入的分页对象
     * @return 符合条件的查询结果集
     * @author codegenerator
     * 
     */
    @Override 
    public Page<Function> list(FunctionCondition functionCondition,Pageable pageable){
        StringBuffer sb=new StringBuffer("select model from Function model  where 1=1  ");
        Map<String,Object> params = new HashMap<String,Object>();
        if(functionCondition.getParentUri()!=null){
            sb.append(" and model.parentUri = :parentUri ");
            params.put("parentUri",functionCondition.getParentUri());
        }
        return queryByJpql(sb.toString(), params, pageable);
    }

    @Override 
    public List<Function> list(FunctionCondition functionCondition){
        StringBuffer sb=new StringBuffer("select model from Function model  where 1=1  ");
        Map<String,Object> params = new HashMap<String,Object>();
        if(functionCondition.getParentUri()!=null){
            sb.append(" and model.parentUri = :parentUri ");
            params.put("parentUri",functionCondition.getParentUri());
        }
        return queryByJpql(sb.toString(), params);
    }
    
    
    @Override 
    public Page< Map<String,Object>> listBySql(FunctionCondition condition,Pageable pageable){
        StringBuffer sb=new StringBuffer("select uri,name,type,parent_uri,description from system_function  where 1=1  ");
        Map<Integer,Object> params = new HashMap<Integer,Object>();
        if(condition.getParentUri()!=null){
            sb.append(" and parent_uri = ?4 ");
            params.put(4,condition.getParentUri());
        }
        return queryFieldsBySql(sb.toString(), params, pageable);
    }
    
    @Override 
    public Function findBy(String field,Object value){
        StringBuffer sb=new StringBuffer("select model from Function model  where model.");
        sb.append(field);
        sb.append(" = :value ");
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("value",value);
        List<Function> result = queryByJpql(sb.toString(), params,0l,1l);
        return result.isEmpty() ? null : result.get(0);
    }
    
    @Override 
    public List<Function> findAllBy(String field,Object value){
        StringBuffer sb=new StringBuffer("select model from Function model  where model.");
        sb.append(field);
       sb.append(" = :value ");
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("value",value);
        return queryByJpql(sb.toString(), params);
    }
    
    
}