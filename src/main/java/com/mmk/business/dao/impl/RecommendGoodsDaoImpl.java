/*
 * 
 *  RecommendGoodsDaoImpl 创建于 2016-11-14 13:55:42 版权归作者和作者当前组织所有
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

import com.mmk.business.model.RecommendGoods;
import com.mmk.business.dao.RecommendGoodsDao;

import com.mmk.business.condition.RecommendGoodsCondition;



/**
* RecommendGoodsDaoImpl: 商品 位置 关系表 数据持久层接口实现
*@author huguangling 胡广玲
*@version 1.0
*
*/
@Repository
public class RecommendGoodsDaoImpl extends SpringDataQueryDaoImpl<RecommendGoods> implements RecommendGoodsDao {
    
    private Log log = LogFactory.getLog(this.getClass());
    
    public RecommendGoodsDaoImpl(){
        super(RecommendGoods.class);
    }
    
    /**
     * 分页查询相关信息，根据传入的bean类对象和分页对象page取得查询结果集List
     * @param recommendGoodsCondition 查询类
     * @param pageable 传入的分页对象
     * @return 符合条件的查询结果集
     * @author huguangling 胡广玲
     * 
     */
    @Override 
    public Page<RecommendGoods> list(RecommendGoodsCondition recommendGoodsCondition,Pageable pageable){
        StringBuffer sb=new StringBuffer("select model from RecommendGoods model  where 1=1  ");
        Map<String,Object> params = new HashMap<String,Object>();
        if(recommendGoodsCondition.getGoodId()!=null){
            sb.append(" and model.goodId = :goodId ");
            params.put("goodId",recommendGoodsCondition.getGoodId());
        }
        if(recommendGoodsCondition.getPositionId()!=null){
            sb.append(" and model.positionId = :positionId ");
            params.put("positionId",recommendGoodsCondition.getPositionId());
        }
        return queryByJpql(sb.toString(), params, pageable);
    }

    @Override 
    public List<RecommendGoods> list(RecommendGoodsCondition recommendGoodsCondition){
        StringBuffer sb=new StringBuffer("select model from RecommendGoods model  where 1=1  ");
        Map<String,Object> params = new HashMap<String,Object>();
        if(recommendGoodsCondition.getGoodId()!=null){
            sb.append(" and model.goodId = :goodId ");
            params.put("goodId",recommendGoodsCondition.getGoodId());
        }
        if(recommendGoodsCondition.getPositionId()!=null){
            sb.append(" and model.positionId = :positionId ");
            params.put("positionId",recommendGoodsCondition.getPositionId());
        }
        return queryByJpql(sb.toString(), params);
    }
    
    
    @Override 
    public Page< Map<String,Object>> listBySql(RecommendGoodsCondition condition,Pageable pageable){
        StringBuffer sb=new StringBuffer("select id,good_id,position_id,sort from business_recommend_goods  where 1=1  ");
        Map<Integer,Object> params = new HashMap<Integer,Object>();
        if(condition.getGoodId()!=null){
            sb.append(" and good_id = ?2 ");
            params.put(2,condition.getGoodId());
        }
        if(condition.getPositionId()!=null){
            sb.append(" and position_id = ?3 ");
            params.put(3,condition.getPositionId());
        }
        return queryFieldsBySql(sb.toString(), params, pageable);
    }
    
    @Override 
    public RecommendGoods findBy(String field,Object value){
        StringBuffer sb=new StringBuffer("select model from RecommendGoods model  where model.");
        sb.append(field);
        sb.append(" = :value ");
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("value",value);
        List<RecommendGoods> result = queryByJpql(sb.toString(), params,0l,1l);
        return result.isEmpty() ? null : result.get(0);
    }
    
    @Override 
    public List<RecommendGoods> findAllBy(String field,Object value){
        StringBuffer sb=new StringBuffer("select model from RecommendGoods model  where model.");
        sb.append(field);
       sb.append(" = :value ");
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("value",value);
        return queryByJpql(sb.toString(), params);
    }
    
    
}