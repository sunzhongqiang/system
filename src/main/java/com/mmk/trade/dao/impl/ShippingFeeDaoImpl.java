/*
 * 
 *  ShippingFeeDaoImpl 创建于 2016-11-26 11:33:42 版权归作者和作者当前组织所有
 */
package com.mmk.trade.dao.impl;

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

import com.mmk.trade.model.ShippingFee;
import com.mmk.trade.dao.ShippingFeeDao;

import com.mmk.trade.condition.ShippingFeeCondition;



/**
* ShippingFeeDaoImpl: 快递地区运费 数据持久层接口实现
*@author huguangling 胡广玲
*@version 1.0
*
*/
@Repository
public class ShippingFeeDaoImpl extends SpringDataQueryDaoImpl<ShippingFee> implements ShippingFeeDao {
    
    private Log log = LogFactory.getLog(this.getClass());
    
    public ShippingFeeDaoImpl(){
        super(ShippingFee.class);
    }
    
    /**
     * 分页查询相关信息，根据传入的bean类对象和分页对象page取得查询结果集List
     * @param shippingFeeCondition 查询类
     * @param pageable 传入的分页对象
     * @return 符合条件的查询结果集
     * @author huguangling 胡广玲
     * 
     */
    @Override 
    public Page<ShippingFee> list(ShippingFeeCondition shippingFeeCondition,Pageable pageable){
        StringBuffer sb=new StringBuffer("select model from ShippingFee model  where 1=1  ");
        Map<String,Object> params = new HashMap<String,Object>();
        if(shippingFeeCondition.getShippingId()!=null){
            sb.append(" and model.shippingId = :shippingId ");
            params.put("shippingId",shippingFeeCondition.getShippingId());
        }
        if(shippingFeeCondition.getRegionId()!=null){
            sb.append(" and model.regionId = :regionId ");
            params.put("regionId",shippingFeeCondition.getRegionId());
        }
        return queryByJpql(sb.toString(), params, pageable);
    }

    @Override 
    public List<ShippingFee> list(ShippingFeeCondition shippingFeeCondition){
        StringBuffer sb=new StringBuffer("select model from ShippingFee model  where 1=1  ");
        Map<String,Object> params = new HashMap<String,Object>();
        if(shippingFeeCondition.getShippingId()!=null){
            sb.append(" and model.shippingId = :shippingId ");
            params.put("shippingId",shippingFeeCondition.getShippingId());
        }
        if(shippingFeeCondition.getRegionId()!=null){
            sb.append(" and model.regionId = :regionId ");
            params.put("regionId",shippingFeeCondition.getRegionId());
        }
        return queryByJpql(sb.toString(), params);
    }
    
    
    @Override 
    public Page< Map<String,Object>> listBySql(ShippingFeeCondition condition,Pageable pageable){
        StringBuffer sb=new StringBuffer("select id,shipping_id,region_id,init_start,init_fee,add_start,add_fee from trade_shipping_fee  where 1=1  ");
        Map<Integer,Object> params = new HashMap<Integer,Object>();
        if(condition.getShippingId()!=null){
            sb.append(" and shipping_id = ?2 ");
            params.put(2,condition.getShippingId());
        }
        if(condition.getRegionId()!=null){
            sb.append(" and region_id = ?3 ");
            params.put(3,condition.getRegionId());
        }
        return queryFieldsBySql(sb.toString(), params, pageable);
    }
    
    @Override 
    public ShippingFee findBy(String field,Object value){
        StringBuffer sb=new StringBuffer("select model from ShippingFee model  where model.");
        sb.append(field);
        sb.append(" = :value ");
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("value",value);
        List<ShippingFee> result = queryByJpql(sb.toString(), params,0l,1l);
        return result.isEmpty() ? null : result.get(0);
    }
    
    @Override 
    public List<ShippingFee> findAllBy(String field,Object value){
        StringBuffer sb=new StringBuffer("select model from ShippingFee model  where model.");
        sb.append(field);
       sb.append(" = :value ");
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("value",value);
        return queryByJpql(sb.toString(), params);
    }
    
    
}