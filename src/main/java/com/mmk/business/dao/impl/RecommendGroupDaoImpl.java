/*
 * 
 *  RecommendGroupDaoImpl 创建于 2016-11-18 15:08:15 版权归作者和作者当前组织所有
 */
package com.mmk.business.dao.impl;

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

import com.mmk.business.model.RecommendGroup;
import com.mmk.business.dao.RecommendGroupDao;

import com.mmk.business.condition.RecommendGroupCondition;



/**
* RecommendGroupDaoImpl: 拼团管理 数据持久层接口实现
*@author huguangling 胡广玲
*@version 1.0
*
*/
@Repository
public class RecommendGroupDaoImpl extends SpringDataQueryDaoImpl<RecommendGroup> implements RecommendGroupDao {
    
    private Log log = LogFactory.getLog(this.getClass());
    
    public RecommendGroupDaoImpl(){
        super(RecommendGroup.class);
    }
    
    /**
     * 分页查询相关信息，根据传入的bean类对象和分页对象page取得查询结果集List
     * @param recommendGroupCondition 查询类
     * @param pageable 传入的分页对象
     * @return 符合条件的查询结果集
     * @author huguangling 胡广玲
     * 
     */
    @Override 
    public Page<RecommendGroup> list(RecommendGroupCondition recommendGroupCondition,Pageable pageable){
        StringBuffer sb=new StringBuffer("select model from RecommendGroup model  where 1=1  ");
        Map<String,Object> params = new HashMap<String,Object>();
        if(recommendGroupCondition.getGroupId()!=null){
            sb.append(" and model.groupId = :groupId ");
            params.put("groupId",recommendGroupCondition.getGroupId());
        }
        if(recommendGroupCondition.getPositionId()!=null){
            sb.append(" and model.positionId = :positionId ");
            params.put("positionId",recommendGroupCondition.getPositionId());
        }
        return queryByJpql(sb.toString(), params, pageable);
    }

    @Override 
    public List<RecommendGroup> list(RecommendGroupCondition recommendGroupCondition){
        StringBuffer sb=new StringBuffer("select model from RecommendGroup model  where 1=1  ");
        Map<String,Object> params = new HashMap<String,Object>();
        if(recommendGroupCondition.getGroupId()!=null){
            sb.append(" and model.groupId = :groupId ");
            params.put("groupId",recommendGroupCondition.getGroupId());
        }
        if(recommendGroupCondition.getPositionId()!=null){
            sb.append(" and model.positionId = :positionId ");
            params.put("positionId",recommendGroupCondition.getPositionId());
        }
        return queryByJpql(sb.toString(), params);
    }
    
    
    @Override 
    public Page< Map<String,Object>> listBySql(RecommendGroupCondition condition,Pageable pageable){
        StringBuffer sb=new StringBuffer("select id,group_id,position_id,orderby from business_recommend_group  where 1=1  ");
        Map<Integer,Object> params = new HashMap<Integer,Object>();
        if(condition.getGroupId()!=null){
            sb.append(" and group_id = ?2 ");
            params.put(2,condition.getGroupId());
        }
        if(condition.getPositionId()!=null){
            sb.append(" and position_id = ?3 ");
            params.put(3,condition.getPositionId());
        }
        return queryFieldsBySql(sb.toString(), params, pageable);
    }
    
    @Override 
    public RecommendGroup findBy(String field,Object value){
        StringBuffer sb=new StringBuffer("select model from RecommendGroup model  where model.");
        sb.append(field);
        sb.append(" = :value ");
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("value",value);
        List<RecommendGroup> result = queryByJpql(sb.toString(), params,0l,1l);
        return result.isEmpty() ? null : result.get(0);
    }
    
    @Override 
    public List<RecommendGroup> findAllBy(String field,Object value){
        StringBuffer sb=new StringBuffer("select model from RecommendGroup model  where model.");
        sb.append(field);
       sb.append(" = :value ");
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("value",value);
        return queryByJpql(sb.toString(), params);
    }
    
    
}