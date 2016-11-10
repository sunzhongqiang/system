/*
 * 
 *  ShippingDaoImpl 创建于 2016-11-10 08:56:06 版权归作者和作者当前组织所有
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

import com.mmk.trade.model.Shipping;
import com.mmk.trade.dao.ShippingDao;

import com.mmk.trade.condition.ShippingCondition;



/**
* ShippingDaoImpl: 物流公司 数据持久层接口实现
*@author huguangling 胡广玲
*@version 1.0
*
*/
@Repository
public class ShippingDaoImpl extends SpringDataQueryDaoImpl<Shipping> implements ShippingDao {
    
    private Log log = LogFactory.getLog(this.getClass());
    
    public ShippingDaoImpl(){
        super(Shipping.class);
    }
    
    /**
     * 分页查询相关信息，根据传入的bean类对象和分页对象page取得查询结果集List
     * @param shippingCondition 查询类
     * @param pageable 传入的分页对象
     * @return 符合条件的查询结果集
     * @author huguangling 胡广玲
     * 
     */
    @Override 
    public Page<Shipping> list(ShippingCondition shippingCondition,Pageable pageable){
        StringBuffer sb=new StringBuffer("select model from Shipping model  where 1=1  ");
        Map<String,Object> params = new HashMap<String,Object>();
        if(StringUtils.isNotBlank(shippingCondition.getShippingCode())){
            sb.append(" and model.shippingCode like :shippingCode ");
            params.put("shippingCode","%"+shippingCondition.getShippingCode()+"%");
        }
        if(StringUtils.isNotBlank(shippingCondition.getShippingName())){
            sb.append(" and model.shippingName like :shippingName ");
            params.put("shippingName","%"+shippingCondition.getShippingName()+"%");
        }
        if(shippingCondition.getSupportCod()!=null){
            sb.append(" and model.supportCod = :supportCod ");
            params.put("supportCod",shippingCondition.getSupportCod());
        }
        if(shippingCondition.getEnabled()!=null){
            sb.append(" and model.enabled = :enabled ");
            params.put("enabled",shippingCondition.getEnabled());
        }
        return queryByJpql(sb.toString(), params, pageable);
    }

    @Override 
    public List<Shipping> list(ShippingCondition shippingCondition){
        StringBuffer sb=new StringBuffer("select model from Shipping model  where 1=1  ");
        Map<String,Object> params = new HashMap<String,Object>();
        if(StringUtils.isNotBlank(shippingCondition.getShippingCode())){
            sb.append(" and model.shippingCode like :shippingCode ");
            params.put("shippingCode","%"+shippingCondition.getShippingCode()+"%");
        }
        if(StringUtils.isNotBlank(shippingCondition.getShippingName())){
            sb.append(" and model.shippingName like :shippingName ");
            params.put("shippingName","%"+shippingCondition.getShippingName()+"%");
        }
        if(shippingCondition.getSupportCod()!=null){
            sb.append(" and model.supportCod = :supportCod ");
            params.put("supportCod",shippingCondition.getSupportCod());
        }
        if(shippingCondition.getEnabled()!=null){
            sb.append(" and model.enabled = :enabled ");
            params.put("enabled",shippingCondition.getEnabled());
        }
        return queryByJpql(sb.toString(), params);
    }
    
    
    @Override 
    public Page< Map<String,Object>> listBySql(ShippingCondition condition,Pageable pageable){
        StringBuffer sb=new StringBuffer("select id,shipping_code,shipping_name,shipping_desc,support_cod,enabled,last_update_time from trade_shipping  where 1=1  ");
        Map<Integer,Object> params = new HashMap<Integer,Object>();
        if(StringUtils.isNotBlank(condition.getShippingCode())){
            sb.append(" and shipping_code like ?2 ");
            params.put(2,"%"+condition.getShippingCode()+"%");
        }
        if(StringUtils.isNotBlank(condition.getShippingName())){
            sb.append(" and shipping_name like ?3 ");
            params.put(3,"%"+condition.getShippingName()+"%");
        }
        if(condition.getSupportCod()!=null){
            sb.append(" and support_cod = ?5 ");
            params.put(5,condition.getSupportCod());
        }
        if(condition.getEnabled()!=null){
            sb.append(" and enabled = ?6 ");
            params.put(6,condition.getEnabled());
        }
        return queryFieldsBySql(sb.toString(), params, pageable);
    }
    
    @Override 
    public Shipping findBy(String field,Object value){
        StringBuffer sb=new StringBuffer("select model from Shipping model  where model.");
        sb.append(field);
        sb.append(" = :value ");
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("value",value);
        List<Shipping> result = queryByJpql(sb.toString(), params,0l,1l);
        return result.isEmpty() ? null : result.get(0);
    }
    
    @Override 
    public List<Shipping> findAllBy(String field,Object value){
        StringBuffer sb=new StringBuffer("select model from Shipping model  where model.");
        sb.append(field);
       sb.append(" = :value ");
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("value",value);
        return queryByJpql(sb.toString(), params);
    }
    
    
}