/*
 * 
 *  AttentionDaoImpl 创建于 2016-11-30 09:25:29 版权归作者和作者当前组织所有
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

import com.mmk.business.model.Attention;
import com.mmk.business.model.Favorite;
import com.mmk.business.dao.AttentionDao;

import com.mmk.business.condition.AttentionCondition;



/**
* AttentionDaoImpl: 商品或者团的关注 数据持久层接口实现
*@author huguangling 胡广玲
*@version 1.0
*
*/
@Repository
public class AttentionDaoImpl extends SpringDataQueryDaoImpl<Attention> implements AttentionDao {
    
    private Log log = LogFactory.getLog(this.getClass());
    
    public AttentionDaoImpl(){
        super(Attention.class);
    }
    
    /**
     * 分页查询相关信息，根据传入的bean类对象和分页对象page取得查询结果集List
     * @param attentionCondition 查询类
     * @param pageable 传入的分页对象
     * @return 符合条件的查询结果集
     * @author huguangling 胡广玲
     * 
     */
    @Override 
    public Page<Attention> list(AttentionCondition attentionCondition,Pageable pageable){
        StringBuffer sb=new StringBuffer("select model from Attention model  where 1=1  ");
        Map<String,Object> params = new HashMap<String,Object>();
        return queryByJpql(sb.toString(), params, pageable);
    }

    @Override 
    public List<Attention> list(AttentionCondition attentionCondition){
        StringBuffer sb=new StringBuffer("select model from Attention model  where 1=1  ");
        Map<String,Object> params = new HashMap<String,Object>();
        return queryByJpql(sb.toString(), params);
    }
    
    
    @Override 
    public Page< Map<String,Object>> listBySql(AttentionCondition condition,Pageable pageable){
        StringBuffer sb=new StringBuffer("select id,group_id,goods_id,user_id,openid from business_attention  where 1=1  ");
        Map<Integer,Object> params = new HashMap<Integer,Object>();
        return queryFieldsBySql(sb.toString(), params, pageable);
    }
    
    @Override 
    public Attention findBy(String field,Object value){
        StringBuffer sb=new StringBuffer("select model from Attention model  where model.");
        sb.append(field);
        sb.append(" = :value ");
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("value",value);
        List<Attention> result = queryByJpql(sb.toString(), params,0l,1l);
        return result.isEmpty() ? null : result.get(0);
    }
    
    @Override 
    public List<Attention> findAllBy(String field,Object value){
        StringBuffer sb=new StringBuffer("select model from Attention model  where model.");
        sb.append(field);
       sb.append(" = :value ");
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("value",value);
        return queryByJpql(sb.toString(), params);
    }

	@Override
	public Page<Attention> findAllByUserId(Long userId, Pageable pageable) {
		StringBuffer sb=new StringBuffer("select model from Attention model  where model.userId = :userId  ");
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("userId", userId);
        return queryByJpql(sb.toString(), params, pageable);
	}

	@Override
	public Attention findByUserIdAndGroupId(Long userId, Long groupId) {
		StringBuffer sb=new StringBuffer("select model from Attention model where 1=1  ");
        Map<String, Object> params = new HashMap<String, Object>();
	    if(userId != null){
            sb.append(" and model.userId = :userId ");
            params.put("userId", userId);
        }
	    if(groupId != null){
            sb.append(" and model.groupId = :groupId ");
            params.put("groupId", groupId);
        }

		return getOne(sb.toString(), params);
	}
       
}