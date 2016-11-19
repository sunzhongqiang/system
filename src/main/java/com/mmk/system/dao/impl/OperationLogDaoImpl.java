/*
 * 
 *  OperationLogDaoImpl 创建于 2016-10-22 12:17:32 版权归作者和作者当前组织所有
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
import com.mmk.system.condition.OperationLogCondition;
import com.mmk.system.dao.OperationLogDao;
import com.mmk.system.model.OperationLog;



/**
* OperationLogDaoImpl: 系统操作日志 数据持久层接口实现
*@author 孙中强
*@version 1.0
*
*/
@Repository
public class OperationLogDaoImpl extends SpringDataQueryDaoImpl<OperationLog> implements OperationLogDao {
    
    private Log log = LogFactory.getLog(this.getClass());
    
    public OperationLogDaoImpl(){
        super(OperationLog.class);
    }
    
    /**
     * 分页查询相关信息，根据传入的bean类对象和分页对象page取得查询结果集List
     * @param operationLogCondition 查询类
     * @param pageable 传入的分页对象
     * @return 符合条件的查询结果集
     * @author 孙中强
     * 
     */
    @Override 
    public Page<OperationLog> list(OperationLogCondition operationLogCondition,Pageable pageable){
        StringBuffer sb=new StringBuffer("select model from OperationLog model  where 1=1  ");
        Map<String,Object> params = new HashMap<String,Object>();
        if(StringUtils.isNotBlank(operationLogCondition.getUsername())){
            sb.append(" and model.username like :username ");
            params.put("username","%"+operationLogCondition.getUsername()+"%");
        }
        if(StringUtils.isNotBlank(operationLogCondition.getRealname())){
            sb.append(" and model.realname like :realname ");
            params.put("realname","%"+operationLogCondition.getRealname()+"%");
        }
        if(StringUtils.isNotBlank(operationLogCondition.getFunctionUri())){
            sb.append(" and model.functionUri like :functionUri ");
            params.put("functionUri","%"+operationLogCondition.getFunctionUri()+"%");
        }
        if(StringUtils.isNotBlank(operationLogCondition.getFunctionName())){
            sb.append(" and model.functionName like :functionName ");
            params.put("functionName","%"+operationLogCondition.getFunctionName()+"%");
        }
        return queryByJpql(sb.toString(), params, pageable);
    }

    @Override 
    public List<OperationLog> list(OperationLogCondition operationLogCondition){
        StringBuffer sb=new StringBuffer("select model from OperationLog model  where 1=1  ");
        Map<String,Object> params = new HashMap<String,Object>();
        if(StringUtils.isNotBlank(operationLogCondition.getUsername())){
            sb.append(" and model.username like :username ");
            params.put("username","%"+operationLogCondition.getUsername()+"%");
        }
        if(StringUtils.isNotBlank(operationLogCondition.getRealname())){
            sb.append(" and model.realname like :realname ");
            params.put("realname","%"+operationLogCondition.getRealname()+"%");
        }
        if(StringUtils.isNotBlank(operationLogCondition.getFunctionUri())){
            sb.append(" and model.functionUri like :functionUri ");
            params.put("functionUri","%"+operationLogCondition.getFunctionUri()+"%");
        }
        if(StringUtils.isNotBlank(operationLogCondition.getFunctionName())){
            sb.append(" and model.functionName like :functionName ");
            params.put("functionName","%"+operationLogCondition.getFunctionName()+"%");
        }
        return queryByJpql(sb.toString(), params);
    }
    
    
    @Override 
    public Page< Map<String,Object>> listBySql(OperationLogCondition condition,Pageable pageable){
        StringBuffer sb=new StringBuffer("select id,user_id,username,realname,role_code,role_name,function_uri,function_name,operation_time,status,ip from system_operation_log  where 1=1  ");
        Map<Integer,Object> params = new HashMap<Integer,Object>();
        if(StringUtils.isNotBlank(condition.getUsername())){
            sb.append(" and username like ?3 ");
            params.put(3,"%"+condition.getUsername()+"%");
        }
        if(StringUtils.isNotBlank(condition.getRealname())){
            sb.append(" and realname like ?4 ");
            params.put(4,"%"+condition.getRealname()+"%");
        }
        if(StringUtils.isNotBlank(condition.getFunctionUri())){
            sb.append(" and function_uri like ?7 ");
            params.put(7,"%"+condition.getFunctionUri()+"%");
        }
        if(StringUtils.isNotBlank(condition.getFunctionName())){
            sb.append(" and function_name like ?8 ");
            params.put(8,"%"+condition.getFunctionName()+"%");
        }
        return queryFieldsBySql(sb.toString(), params, pageable);
    }
    
    @Override 
    public OperationLog findBy(String field,Object value){
        StringBuffer sb=new StringBuffer("select model from OperationLog model  where model.");
        sb.append(field);
        sb.append(" = :value ");
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("value",value);
        List<OperationLog> result = queryByJpql(sb.toString(), params,0l,1l);
        return result.isEmpty() ? null : result.get(0);
    }
    
    @Override 
    public List<OperationLog> findAllBy(String field,Object value){
        StringBuffer sb=new StringBuffer("select model from OperationLog model  where model.");
        sb.append(field);
       sb.append(" = :value ");
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("value",value);
        return queryByJpql(sb.toString(), params);
    }
      
}