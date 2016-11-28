/*
 * 
 *  ApiDaoImpl 创建于 2016-11-15 10:01:04 版权归作者和作者当前组织所有
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
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Repository;

import com.mmk.gene.dao.impl.SpringDataQueryDaoImpl;
import com.mmk.system.condition.ApiCondition;
import com.mmk.system.dao.ApiDao;
import com.mmk.system.model.Api;



/**
* ApiDaoImpl: 系统API 数据持久层接口实现
*@author 
*@version 1.0
*
*/
@Repository
public class ApiDaoImpl extends SpringDataQueryDaoImpl<Api> implements ApiDao {
    
    private Log log = LogFactory.getLog(this.getClass());
    
    public ApiDaoImpl(){
        super(Api.class);
    }
    
    /**
     * 分页查询相关信息，根据传入的bean类对象和分页对象page取得查询结果集List
     * @param apiCondition 查询类
     * @param pageable 传入的分页对象
     * @return 符合条件的查询结果集
     * @author 
     * 
     */
    @Override 
    public Page<Api> list(ApiCondition apiCondition,Pageable pageable){
        StringBuffer sb=new StringBuffer("select model from Api model  where 1=1  ");
        Map<String,Object> params = new HashMap<String,Object>();
        if(StringUtils.isNotBlank(apiCondition.getApiGroup())){
            sb.append(" and model.apiGroup = :apiGroup ");
            params.put("apiGroup",apiCondition.getApiGroup());
        }
        if(StringUtils.isNotBlank(apiCondition.getName())){
            sb.append(" and model.name like :name ");
            params.put("name","%"+apiCondition.getName()+"%");
        }
        if(StringUtils.isNotBlank(apiCondition.getUri())){
            sb.append(" and model.uri like :uri ");
            params.put("uri","%"+apiCondition.getUri()+"%");
        }
		Sort sort = pageable.getSort();
		if (sort != null) {
			sb.append(" order by ");
			for (Order order : sort) {
				sb.append(" model.".concat(order.getProperty()));
				sb.append(" ".concat(order.getDirection().toString()));
			}
		} else {
			sb.append(" order by model.apiGroup ");
		}
        return queryByJpql(sb.toString(), params, pageable);
    }

    @Override 
    public List<Api> list(ApiCondition apiCondition){
        StringBuffer sb=new StringBuffer("select model from Api model  where 1=1  ");
        Map<String,Object> params = new HashMap<String,Object>();
        if(StringUtils.isNotBlank(apiCondition.getApiGroup())){
            sb.append(" and model.apiGroup = :apiGroup ");
            params.put("apiGroup",apiCondition.getApiGroup());
        }
        if(StringUtils.isNotBlank(apiCondition.getName())){
            sb.append(" and model.name like :name ");
            params.put("name","%"+apiCondition.getName()+"%");
        }
        if(StringUtils.isNotBlank(apiCondition.getUri())){
            sb.append(" and model.uri like :uri ");
            params.put("uri","%"+apiCondition.getUri()+"%");
        }
        return queryByJpql(sb.toString(), params);
    }
    
    
    @Override 
    public Page< Map<String,Object>> listBySql(ApiCondition condition,Pageable pageable){
        StringBuffer sb=new StringBuffer("select id,api_group,name,description,uri,params,return_values from system_api  where 1=1  ");
        Map<Integer,Object> params = new HashMap<Integer,Object>();
        if(StringUtils.isNotBlank(condition.getApiGroup())){
            sb.append(" and api_group = ?2 ");
            params.put(2,condition.getApiGroup());
        }
        if(StringUtils.isNotBlank(condition.getName())){
            sb.append(" and name like ?3 ");
            params.put(3,"%"+condition.getName()+"%");
        }
        if(StringUtils.isNotBlank(condition.getUri())){
            sb.append(" and uri like ?5 ");
            params.put(5,"%"+condition.getUri()+"%");
        }
        return queryFieldsBySql(sb.toString(), params, pageable);
    }
    
    @Override 
    public Api findBy(String field,Object value){
        StringBuffer sb=new StringBuffer("select model from Api model  where model.");
        sb.append(field);
        sb.append(" = :value ");
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("value",value);
        List<Api> result = queryByJpql(sb.toString(), params,0l,1l);
        return result.isEmpty() ? null : result.get(0);
    }
    
    @Override 
    public List<Api> findAllBy(String field,Object value){
        StringBuffer sb=new StringBuffer("select model from Api model  where model.");
        sb.append(field);
       sb.append(" = :value ");
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("value",value);
        return queryByJpql(sb.toString(), params);
    }
     
}