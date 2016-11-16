/*
 * 
 *  GoodsDaoImpl 创建于 2016-10-31 10:48:36 版权归作者和作者当前组织所有
 */
package com.mmk.business.dao.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.mmk.business.condition.GoodsCondition;
import com.mmk.business.dao.GoodsDao;
import com.mmk.business.model.Goods;
import com.mmk.gene.dao.impl.SpringDataQueryDaoImpl;



/**
* GoodsDaoImpl: 商品活动 数据持久层接口实现
*@author huguangling 胡广玲
*@version 1.0
*
*/
@Repository
public class GoodsDaoImpl extends SpringDataQueryDaoImpl<Goods> implements GoodsDao {
    
    private Log log = LogFactory.getLog(this.getClass());
    
    public GoodsDaoImpl(){
        super(Goods.class);
    }
    
    /**
     * 分页查询相关信息，根据传入的bean类对象和分页对象page取得查询结果集List
     * @param goodsCondition 查询类
     * @param pageable 传入的分页对象
     * @return 符合条件的查询结果集
     * @author huguangling 胡广玲
     * 
     */
    @Override 
    public Page<Goods> list(GoodsCondition goodsCondition,Pageable pageable){
        StringBuffer sb=new StringBuffer("select model from Goods model  where 1=1  ");
        Map<String,Object> params = new HashMap<String,Object>();
        return queryByJpql(sb.toString(), params, pageable);
    }

    @Override 
    public List<Goods> list(GoodsCondition goodsCondition){
        StringBuffer sb=new StringBuffer("select model from Goods model  where 1=1  ");
        Map<String,Object> params = new HashMap<String,Object>();
        return queryByJpql(sb.toString(), params);
    }
    
    
    @Override 
    public Page< Map<String,Object>> listBySql(GoodsCondition condition,Pageable pageable){
        StringBuffer sb=new StringBuffer("select id,goods_cat,goods_name,goods_number,goods_original_price,promote_price,promote_start_date,promote_end_date,promote_number,saled_number,goods_thumb,goods_main_img,goods_original_img,is_delete from business_goods  where 1=1  ");
        Map<Integer,Object> params = new HashMap<Integer,Object>();
        return queryFieldsBySql(sb.toString(), params, pageable);
    }
    
    @Override 
    public Goods findBy(String field,Object value){
        StringBuffer sb=new StringBuffer("select model from Goods model  where model.");
        sb.append(field);
        sb.append(" = :value ");
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("value",value);
        List<Goods> result = queryByJpql(sb.toString(), params,0l,1l);
        return result.isEmpty() ? null : result.get(0);
    }
    
    @Override 
    public List<Goods> findAllBy(String field,Object value){
        StringBuffer sb=new StringBuffer("select model from Goods model  where model.");
        sb.append(field);
       sb.append(" = :value ");
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("value",value);
        return queryByJpql(sb.toString(), params);
    }

	@Override
	public List<Object[]> findGoodsGrid(Long positionId) {
        StringBuffer sb=new StringBuffer("select model,recommendGoods from Goods model,RecommendGoods recommendGoods where recommendGoods.goodId = model.id ");
        Map<String,Object> params = new HashMap<String,Object>();
        sb.append(" and recommendGoods.positionId = :positionId ");
        params.put("positionId", positionId);
        sb.append(" order by recommendGoods.orderby asc ");
        
        return queryArrayByJpql(sb.toString(), params);
        
	}

	@Override
	public Page<Goods> findAllGoodsBy(Date begin, Date end, long cat, Pageable pageable) {
		StringBuffer sb = new StringBuffer("select model from Goods model  where model.goodsCat = :cat  ");
		sb.append(" and model.promoteStartDate between :start and :end ");
		
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("cat", cat);
        params.put("start", begin);
        params.put("end", end);
        
        return queryByJpql(sb.toString(), params, pageable);
	}
}