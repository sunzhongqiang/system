/*
 * 
 *  RefundActionDaoImpl 创建于 2016-11-14 13:32:01 版权归作者和作者当前组织所有
 */
package com.mmk.refund.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.mmk.gene.dao.impl.SpringDataQueryDaoImpl;
import com.mmk.refund.condition.RefundActionCondition;
import com.mmk.refund.dao.RefundActionDao;
import com.mmk.refund.model.RefundAction;



/**
* RefundActionDaoImpl: 操作表 数据持久层接口实现
*@author huguangling 胡广玲
*@version 1.0
*
*/
@Repository
public class RefundActionDaoImpl extends SpringDataQueryDaoImpl<RefundAction> implements RefundActionDao {
    
    private Log log = LogFactory.getLog(this.getClass());
    
    public RefundActionDaoImpl(){
        super(RefundAction.class);
    }
    
    /**
     * 分页查询相关信息，根据传入的bean类对象和分页对象page取得查询结果集List
     * @param refundActionCondition 查询类
     * @param pageable 传入的分页对象
     * @return 符合条件的查询结果集
     * @author huguangling 胡广玲
     * 
     */
    @Override 
    public Page<RefundAction> list(RefundActionCondition refundActionCondition,Pageable pageable){
        StringBuffer sb=new StringBuffer("select model from RefundAction model  where 1=1  ");
        Map<String,Object> params = new HashMap<String,Object>();
        if(refundActionCondition.getRefundId()!=null){
            sb.append(" and model.refundId = :refundId ");
            params.put("refundId",refundActionCondition.getRefundId());
        }
        if(StringUtils.isNotBlank(refundActionCondition.getRefundStatus())){
            sb.append(" and model.refundStatus like :refundStatus ");
            params.put("refundStatus","%"+refundActionCondition.getRefundStatus()+"%");
        }
        if(StringUtils.isNotBlank(refundActionCondition.getUsername())){
            sb.append(" and model.username like :username ");
            params.put("username","%"+refundActionCondition.getUsername()+"%");
        }
        if(refundActionCondition.getCreateTime()!=null){
            sb.append(" and model.createTime = :createTime ");
            params.put("createTime",refundActionCondition.getCreateTime());
        }
        return queryByJpql(sb.toString(), params, pageable);
    }

    @Override 
    public List<RefundAction> list(RefundActionCondition refundActionCondition){
        StringBuffer sb=new StringBuffer("select model from RefundAction model  where 1=1  ");
        Map<String,Object> params = new HashMap<String,Object>();
        if(refundActionCondition.getRefundId()!=null){
            sb.append(" and model.refundId = :refundId ");
            params.put("refundId",refundActionCondition.getRefundId());
        }
        if(StringUtils.isNotBlank(refundActionCondition.getRefundStatus())){
            sb.append(" and model.refundStatus like :refundStatus ");
            params.put("refundStatus","%"+refundActionCondition.getRefundStatus()+"%");
        }
        if(StringUtils.isNotBlank(refundActionCondition.getUsername())){
            sb.append(" and model.username like :username ");
            params.put("username","%"+refundActionCondition.getUsername()+"%");
        }
        if(refundActionCondition.getCreateTime()!=null){
            sb.append(" and model.createTime = :createTime ");
            params.put("createTime",refundActionCondition.getCreateTime());
        }
        return queryByJpql(sb.toString(), params);
    }
    
    
    @Override 
    public Page< Map<String,Object>> listBySql(RefundActionCondition condition,Pageable pageable){
        StringBuffer sb=new StringBuffer("select id,refund_id,refund_status,username,create_time,remark from trade_refund_action  where 1=1  ");
        Map<Integer,Object> params = new HashMap<Integer,Object>();
        if(condition.getRefundId()!=null){
            sb.append(" and refund_id = ?2 ");
            params.put(2,condition.getRefundId());
        }
        if(StringUtils.isNotBlank(condition.getRefundStatus())){
            sb.append(" and refund_status like ?3 ");
            params.put(3,"%"+condition.getRefundStatus()+"%");
        }
        if(StringUtils.isNotBlank(condition.getUsername())){
            sb.append(" and username like ?4 ");
            params.put(4,"%"+condition.getUsername()+"%");
        }
        if(condition.getCreateTime()!=null){
            sb.append(" and create_time = ?5 ");
            params.put(5,condition.getCreateTime());
        }
        return queryFieldsBySql(sb.toString(), params, pageable);
    }
    
    @Override 
    public RefundAction findBy(String field,Object value){
        StringBuffer sb=new StringBuffer("select model from RefundAction model  where model.");
        sb.append(field);
        sb.append(" = :value ");
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("value",value);
        List<RefundAction> result = queryByJpql(sb.toString(), params,0l,1l);
        return result.isEmpty() ? null : result.get(0);
    }
    
    @Override 
    public List<RefundAction> findAllBy(String field,Object value){
        StringBuffer sb=new StringBuffer("select model from RefundAction model  where model.");
        sb.append(field);
       sb.append(" = :value ");
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("value",value);
        return queryByJpql(sb.toString(), params);
    }
     
}