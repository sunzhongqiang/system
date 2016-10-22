/*
 * 
 *  OperationLogDaoImpl 创建于 2016-10-22 11:38:04 版权归作者和作者当前组织所有
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

import com.mmk.system.model.OperationLog;
import com.mmk.tool.SqlStringTool;
import com.mmk.system.dao.OperationLogDao;

import com.mmk.system.condition.OperationLogCondition;



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
        if(operationLogCondition.getId()!=null){
            sb.append(" and model.id = :id ");
            params.put("id",operationLogCondition.getId());
        }
        if(StringUtils.isNotBlank(operationLogCondition.getFunctionUri())){
            sb.append(" and model.functionUri like :uri ");
            params.put("uri",SqlStringTool.anyMatch(operationLogCondition.getFunctionUri()));
        }
        if(operationLogCondition.getOperationTime()!=null){
            sb.append(" and model.operationTime = :operationTime ");
            params.put("operationTime",operationLogCondition.getOperationTime());
        }
        return queryByJpql(sb.toString(), params, pageable);
    }

    @Override 
    public List<OperationLog> list(OperationLogCondition operationLogCondition){
        StringBuffer sb=new StringBuffer("select model from OperationLog model  where 1=1  ");
        Map<String,Object> params = new HashMap<String,Object>();
        if(operationLogCondition.getId()!=null){
            sb.append(" and model.id = :id ");
            params.put("id",operationLogCondition.getId());
        }
        if(operationLogCondition.getOperationTime()!=null){
            sb.append(" and model.operationTime = :operationTime ");
            params.put("operationTime",operationLogCondition.getOperationTime());
        }
        return queryByJpql(sb.toString(), params);
    }
    
    
    @Override 
    public Page< Map<String,Object>> listBySql(OperationLogCondition condition,Pageable pageable){
        StringBuffer sb=new StringBuffer("select id,user_id,username,realname,role_code,role_name,function_uri,function_name,operation_time,status,ip from system_operation_log  where 1=1  ");
        Map<Integer,Object> params = new HashMap<Integer,Object>();
        if(condition.getId()!=null){
            sb.append(" and id = ?1 ");
            params.put(1,condition.getId());
        }
        if(condition.getOperationTime()!=null){
            sb.append(" and operation_time = ?9 ");
            params.put(9,condition.getOperationTime());
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