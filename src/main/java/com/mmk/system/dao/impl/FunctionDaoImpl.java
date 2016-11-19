/*
 * 
 *  FunctionDaoImpl 创建于 2016-10-24 15:52:09 版权归作者和作者当前组织所有
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
import com.mmk.system.condition.FunctionCondition;
import com.mmk.system.dao.FunctionDao;
import com.mmk.system.model.Function;



/**
* FunctionDaoImpl: 系统功能 数据持久层接口实现
*@author huguangling 胡广玲
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
     * @author huguangling 胡广玲
     * 
     */
    @Override 
    public Page<Function> list(FunctionCondition functionCondition,Pageable pageable){
        StringBuffer sb=new StringBuffer("select model from Function model  where 1=1  ");
        Map<String,Object> params = new HashMap<String,Object>();
        if(StringUtils.isNotBlank(functionCondition.getUri())){
            sb.append(" and model.uri like :uri ");
            params.put("uri","%"+functionCondition.getUri()+"%");
        }
        if(StringUtils.isNotBlank(functionCondition.getName())){
            sb.append(" and model.name like :name ");
            params.put("name","%"+functionCondition.getName()+"%");
        }
        if(StringUtils.isNotBlank(functionCondition.getType())){
            sb.append(" and model.type = :type ");
            params.put("type",functionCondition.getType());
        }
        sb.append(" order by sort ");
        return queryByJpql(sb.toString(), params, pageable);
    }

    @Override 
    public List<Function> list(FunctionCondition functionCondition){
        StringBuffer sb=new StringBuffer("select model from Function model  where 1=1  ");
        Map<String,Object> params = new HashMap<String,Object>();
        if(StringUtils.isNotBlank(functionCondition.getUri())){
            sb.append(" and model.uri like :uri ");
            params.put("uri","%"+functionCondition.getUri()+"%");
        }
        if(StringUtils.isNotBlank(functionCondition.getName())){
            sb.append(" and model.name like :name ");
            params.put("name","%"+functionCondition.getName()+"%");
        }
        if(StringUtils.isNotBlank(functionCondition.getType())){
            sb.append(" and model.type = :type ");
            params.put("type",functionCondition.getType());
        }
        sb.append(" order by sort ");
        return queryByJpql(sb.toString(), params);
    }
    
    
    @Override 
    public Page< Map<String,Object>> listBySql(FunctionCondition condition,Pageable pageable){
        StringBuffer sb=new StringBuffer("select id,uri,name,type,parent_id,description,parent_uri from system_function  where 1=1  ");
        Map<Integer,Object> params = new HashMap<Integer,Object>();
        if(StringUtils.isNotBlank(condition.getUri())){
            sb.append(" and uri like ?2 ");
            params.put(2,"%"+condition.getUri()+"%");
        }
        if(StringUtils.isNotBlank(condition.getName())){
            sb.append(" and name like ?3 ");
            params.put(3,"%"+condition.getName()+"%");
        }
        if(StringUtils.isNotBlank(condition.getType())){
            sb.append(" and type = ?4 ");
            params.put(4,condition.getType());
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

	@Override
	public List<Function> findAllByRoleIds(List<Long> roleIdList) {
		StringBuffer sb = new StringBuffer("select distinct function from Privilege model,Function function where function.id = model.functionId and function.type in ('menu','module','system') ");
		Map<String, Object> params = new HashMap<String, Object>();
		if(roleIdList!=null&&!roleIdList.isEmpty()){
			sb.append(" and model.roleId in :roleIds ");
			params.put("roleIds", roleIdList);
		}
		sb.append("order by function.sort,function.id");
		return queryArrayByJpql(sb.toString(),params);
	}
    
}