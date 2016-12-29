/*
 * 
 *  GoodsGroupDaoImpl 创建于 2016-11-17 11:42:27 版权归作者和作者当前组织所有
 */
package com.mmk.business.dao.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.mmk.business.condition.GoodsGroupCondition;
import com.mmk.business.dao.GoodsGroupDao;
import com.mmk.business.model.GoodsGroup;
import com.mmk.gene.dao.impl.SpringDataQueryDaoImpl;



/**
* GoodsGroupDaoImpl: 商品拼团管理 数据持久层接口实现
*@author 孙中强 sunzhongqiang
*@version 1.0
*
*/
@Repository
public class GoodsGroupDaoImpl extends SpringDataQueryDaoImpl<GoodsGroup> implements GoodsGroupDao {
    
    private Log log = LogFactory.getLog(this.getClass());
    
    public GoodsGroupDaoImpl(){
        super(GoodsGroup.class);
    }
    
    /**
     * 分页查询相关信息，根据传入的bean类对象和分页对象page取得查询结果集List
     * @param goodsGroupCondition 查询类
     * @param pageable 传入的分页对象
     * @return 符合条件的查询结果集
     * @author 孙中强 sunzhongqiang
     * 
     */
    @Override 
    public Page<GoodsGroup> list(GoodsGroupCondition goodsGroupCondition,Pageable pageable){
        StringBuffer sb=new StringBuffer("select model from GoodsGroup model left join fetch model.goods  where 1=1  ");
        Map<String,Object> params = new HashMap<String,Object>();
        if(goodsGroupCondition.getGroupPrice()!=null){
            sb.append(" and model.groupPrice = :groupPrice ");
            params.put("groupPrice",goodsGroupCondition.getGroupPrice());
        }
        if(goodsGroupCondition.getStartTime()!=null){
            sb.append(" and model.startTime = :startTime ");
            params.put("startTime",goodsGroupCondition.getStartTime());
        }
        if(goodsGroupCondition.getEndTime()!=null){
            sb.append(" and model.endTime = :endTime ");
            params.put("endTime",goodsGroupCondition.getEndTime());
        }
        
        if(goodsGroupCondition.getGoods()!=null){
        	if(StringUtils.isNotBlank(goodsGroupCondition.getGoods().getGoodsName())){
        		 sb.append(" and model.goods.goodsName like :goodsName ");
                 params.put("goodsName","%"+goodsGroupCondition.getGoods().getGoodsName()+"%");
        	}
        }
        return queryByJpql(sb.toString(), params, pageable);
    }

    @Override 
    public List<GoodsGroup> list(GoodsGroupCondition goodsGroupCondition){
        StringBuffer sb=new StringBuffer("select model from GoodsGroup model left join fetch model.goods  where 1=1  ");
        Map<String,Object> params = new HashMap<String,Object>();
        if(goodsGroupCondition.getGroupPrice()!=null){
            sb.append(" and model.groupPrice = :groupPrice ");
            params.put("groupPrice",goodsGroupCondition.getGroupPrice());
        }
        if(goodsGroupCondition.getStartTime()!=null){
            sb.append(" and model.startTime = :startTime ");
            params.put("startTime",goodsGroupCondition.getStartTime());
        }
        if(goodsGroupCondition.getEndTime()!=null){
            sb.append(" and model.endTime = :endTime ");
            params.put("endTime",goodsGroupCondition.getEndTime());
        }
        return queryByJpql(sb.toString(), params);
    }
    
    
    @Override 
    public Page< Map<String,Object>> listBySql(GoodsGroupCondition condition,Pageable pageable){
        StringBuffer sb=new StringBuffer("select id,goods_id,num,group_price,start_time,end_time from business_goods_group  where 1=1  ");
        Map<Integer,Object> params = new HashMap<Integer,Object>();
        if(condition.getGroupPrice()!=null){
            sb.append(" and group_price = ?4 ");
            params.put(4,condition.getGroupPrice());
        }
        if(condition.getStartTime()!=null){
            sb.append(" and start_time = ?5 ");
            params.put(5,condition.getStartTime());
        }
        if(condition.getEndTime()!=null){
            sb.append(" and end_time = ?6 ");
            params.put(6,condition.getEndTime());
        }
        return queryFieldsBySql(sb.toString(), params, pageable);
    }
    
    @Override 
    public GoodsGroup findBy(String field,Object value){
        StringBuffer sb=new StringBuffer("select model from GoodsGroup model  where model.");
        sb.append(field);
        sb.append(" = :value ");
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("value",value);
        List<GoodsGroup> result = queryByJpql(sb.toString(), params,0l,1l);
        return result.isEmpty() ? null : result.get(0);
    }
    
    @Override 
    public List<GoodsGroup> findAllBy(String field,Object value){
        StringBuffer sb=new StringBuffer("select model from GoodsGroup model  where model.");
        sb.append(field);
       sb.append(" = :value ");
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("value",value);
        return queryByJpql(sb.toString(), params);
    }

	@Override
	public List<GoodsGroup> findAllByGoodsId(Long goodsId) {
		 StringBuffer sb=new StringBuffer("select model from GoodsGroup model left join fetch model.goods  where model.goods.id = :goodsId ");
	        Map<String,Object> params = new HashMap<String,Object>();
	        params.put("goodsId",goodsId);
	        return queryByJpql(sb.toString(), params);
	}

	@Override
	public Page<GoodsGroup> findRecommend(String code, Pageable pageable) {
		StringBuffer sb = new StringBuffer("select model from RecommendPosition position , RecommendGroup recommendGroup, GoodsGroup model join fetch model.goods ");
		sb.append("   where position.id = recommendGroup.positionId and  model.id =  recommendGroup.groupId  ");
		sb.append(" and position.code = :code ");
		sb.append(" order by recommendGroup.orderby ");
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("code", code);
		return queryByJpql(sb.toString(), params, pageable);
	}

	@Override
	public Page<GoodsGroup> findAllByStart(Date begin, Date end,Long type,Pageable pageable) {
		StringBuffer sb = new StringBuffer("select model from GoodsGroup model ");
//		sb.append(" where model.startTime between DATE(:start) and DATE(:end) ");
		sb.append(" where model.startTime > DATE(:start) ");

		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("start", begin);
//		params.put("end", end);
		if(type!=null){
			sb.append(" and model.type = :type ");
			params.put("type", type);
		}
		return queryByJpql(sb.toString(), params, pageable);
	}

	@Override
	public Page<GoodsGroup> findAllOverTime(int type, String status, Pageable pageable) {
		StringBuffer sb = new StringBuffer("select model from GoodsGroup model   where model.status = :status ");
		sb.append(" and model.type = :type ");
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("status", status);
		params.put("type", type);
		return queryByJpql(sb.toString(), params, pageable);
	}

	
    
    
}