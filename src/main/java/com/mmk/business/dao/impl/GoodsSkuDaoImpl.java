/*
 * 
 *  GoodsSkuDaoImpl 创建于 2016-11-21 14:08:15 版权归作者和作者当前组织所有
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

import com.mmk.business.model.GoodsSku;
import com.mmk.business.dao.GoodsSkuDao;

import com.mmk.business.condition.GoodsSkuCondition;



/**
* GoodsSkuDaoImpl: 商品SKU 数据持久层接口实现
*@author sunzhongqiang 孙中强
*@version 1.0
*
*/
@Repository
public class GoodsSkuDaoImpl extends SpringDataQueryDaoImpl<GoodsSku> implements GoodsSkuDao {
    
    private Log log = LogFactory.getLog(this.getClass());
    
    public GoodsSkuDaoImpl(){
        super(GoodsSku.class);
    }
    
    /**
     * 分页查询相关信息，根据传入的bean类对象和分页对象page取得查询结果集List
     * @param goodsSkuCondition 查询类
     * @param pageable 传入的分页对象
     * @return 符合条件的查询结果集
     * @author sunzhongqiang 孙中强
     * 
     */
    @Override 
    public Page<GoodsSku> list(GoodsSkuCondition goodsSkuCondition,Pageable pageable){
        StringBuffer sb=new StringBuffer("select model from GoodsSku model  where 1=1  ");
        Map<String,Object> params = new HashMap<String,Object>();
        return queryByJpql(sb.toString(), params, pageable);
    }

    @Override 
    public List<GoodsSku> list(GoodsSkuCondition goodsSkuCondition){
        StringBuffer sb=new StringBuffer("select model from GoodsSku model  where 1=1  ");
        Map<String,Object> params = new HashMap<String,Object>();
        return queryByJpql(sb.toString(), params);
    }
    
    
    @Override 
    public Page< Map<String,Object>> listBySql(GoodsSkuCondition condition,Pageable pageable){
        StringBuffer sb=new StringBuffer("select id,good_id,sku_name,price,stock,code,weight from business_goods_sku  where 1=1  ");
        Map<Integer,Object> params = new HashMap<Integer,Object>();
        return queryFieldsBySql(sb.toString(), params, pageable);
    }
    
    @Override 
    public GoodsSku findBy(String field,Object value){
        StringBuffer sb=new StringBuffer("select model from GoodsSku model  where model.");
        sb.append(field);
        sb.append(" = :value ");
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("value",value);
        List<GoodsSku> result = queryByJpql(sb.toString(), params,0l,1l);
        return result.isEmpty() ? null : result.get(0);
    }
    
    @Override 
    public List<GoodsSku> findAllBy(String field,Object value){
        StringBuffer sb=new StringBuffer("select model from GoodsSku model  where model.");
        sb.append(field);
       sb.append(" = :value ");
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("value",value);
        return queryByJpql(sb.toString(), params);
    }
    
    
}