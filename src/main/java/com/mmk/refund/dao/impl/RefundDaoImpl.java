/*
 * 
 *  RefundDaoImpl 创建于 2016-11-14 13:07:10 版权归作者和作者当前组织所有
 */
package com.mmk.refund.dao.impl;

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

import com.mmk.refund.model.Refund;
import com.mmk.refund.dao.RefundDao;

import com.mmk.refund.condition.RefundCondition;



/**
* RefundDaoImpl: 退款表 数据持久层接口实现
*@author huguangling 胡广玲
*@version 1.0
*
*/
@Repository
public class RefundDaoImpl extends SpringDataQueryDaoImpl<Refund> implements RefundDao {
    
    private Log log = LogFactory.getLog(this.getClass());
    
    public RefundDaoImpl(){
        super(Refund.class);
    }
    
    /**
     * 分页查询相关信息，根据传入的bean类对象和分页对象page取得查询结果集List
     * @param refundCondition 查询类
     * @param pageable 传入的分页对象
     * @return 符合条件的查询结果集
     * @author huguangling 胡广玲
     * 
     */
    @Override 
    public Page<Refund> list(RefundCondition refundCondition,Pageable pageable){
        StringBuffer sb=new StringBuffer("select model from Refund model  where 1=1  ");
        Map<String,Object> params = new HashMap<String,Object>();
        return queryByJpql(sb.toString(), params, pageable);
    }

    @Override 
    public List<Refund> list(RefundCondition refundCondition){
        StringBuffer sb=new StringBuffer("select model from Refund model  where 1=1  ");
        Map<String,Object> params = new HashMap<String,Object>();
        return queryByJpql(sb.toString(), params);
    }
    
    
    @Override 
    public Page< Map<String,Object>> listBySql(RefundCondition condition,Pageable pageable){
        StringBuffer sb=new StringBuffer("select id,tid,order_sn,order_status,total_fee,goods_id,goods_price,goods_num,goods_status,user_id,username,refund_no,refund_msg,refund_create_time,refund_complete_time,refund_status,has_goods_return,apply_refund_fee,payment,reason,description,refund_address,real_refund_fee,refuse_reason,refuse_desc,photo1,photo2,photo3,photo4,photo5,sid,company_name from trade_refund  where 1=1  ");
        Map<Integer,Object> params = new HashMap<Integer,Object>();
        return queryFieldsBySql(sb.toString(), params, pageable);
    }
    
    @Override 
    public Refund findBy(String field,Object value){
        StringBuffer sb=new StringBuffer("select model from Refund model  where model.");
        sb.append(field);
        sb.append(" = :value ");
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("value",value);
        List<Refund> result = queryByJpql(sb.toString(), params,0l,1l);
        return result.isEmpty() ? null : result.get(0);
    }
    
    @Override 
    public List<Refund> findAllBy(String field,Object value){
        StringBuffer sb=new StringBuffer("select model from Refund model  where model.");
        sb.append(field);
       sb.append(" = :value ");
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("value",value);
        return queryByJpql(sb.toString(), params);
    }
    
    
}