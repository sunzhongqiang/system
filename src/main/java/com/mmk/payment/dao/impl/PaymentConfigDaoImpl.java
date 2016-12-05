/*
 * 
 *  PaymentConfigDaoImpl 创建于 2016-12-05 11:57:19 版权归作者和作者当前组织所有
 */
package com.mmk.payment.dao.impl;

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

import com.mmk.payment.model.PaymentConfig;
import com.mmk.payment.dao.PaymentConfigDao;

import com.mmk.payment.condition.PaymentConfigCondition;



/**
* PaymentConfigDaoImpl: 支付配置参数 数据持久层接口实现
*@author 孙中强 sunzhongqiang
*@version 1.0
*
*/
@Repository
public class PaymentConfigDaoImpl extends SpringDataQueryDaoImpl<PaymentConfig> implements PaymentConfigDao {
    
    private Log log = LogFactory.getLog(this.getClass());
    
    public PaymentConfigDaoImpl(){
        super(PaymentConfig.class);
    }
    
    /**
     * 分页查询相关信息，根据传入的bean类对象和分页对象page取得查询结果集List
     * @param paymentConfigCondition 查询类
     * @param pageable 传入的分页对象
     * @return 符合条件的查询结果集
     * @author 孙中强 sunzhongqiang
     * 
     */
    @Override 
    public Page<PaymentConfig> list(PaymentConfigCondition paymentConfigCondition,Pageable pageable){
        StringBuffer sb=new StringBuffer("select model from PaymentConfig model  where 1=1  ");
        Map<String,Object> params = new HashMap<String,Object>();
        return queryByJpql(sb.toString(), params, pageable);
    }

    @Override 
    public List<PaymentConfig> list(PaymentConfigCondition paymentConfigCondition){
        StringBuffer sb=new StringBuffer("select model from PaymentConfig model  where 1=1  ");
        Map<String,Object> params = new HashMap<String,Object>();
        return queryByJpql(sb.toString(), params);
    }
    
    
    @Override 
    public Page< Map<String,Object>> listBySql(PaymentConfigCondition condition,Pageable pageable){
        StringBuffer sb=new StringBuffer("select id,payment_id,code,value,remark,order_sort from pay_payment_config  where 1=1  ");
        Map<Integer,Object> params = new HashMap<Integer,Object>();
        return queryFieldsBySql(sb.toString(), params, pageable);
    }
    
    @Override 
    public PaymentConfig findBy(String field,Object value){
        StringBuffer sb=new StringBuffer("select model from PaymentConfig model  where model.");
        sb.append(field);
        sb.append(" = :value ");
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("value",value);
        List<PaymentConfig> result = queryByJpql(sb.toString(), params,0l,1l);
        return result.isEmpty() ? null : result.get(0);
    }
    
    @Override 
    public List<PaymentConfig> findAllBy(String field,Object value){
        StringBuffer sb=new StringBuffer("select model from PaymentConfig model  where model.");
        sb.append(field);
       sb.append(" = :value ");
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("value",value);
        return queryByJpql(sb.toString(), params);
    }
    
    
}