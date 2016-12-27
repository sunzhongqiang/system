/*
 * 
 *  RefundDaoImpl 创建于 2016-11-14 13:17:40 版权归作者和作者当前组织所有
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
import com.mmk.refund.condition.RefundCondition;
import com.mmk.refund.dao.RefundDao;
import com.mmk.refund.model.Refund;



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
        if(refundCondition.getGoodsId()!=null){
            sb.append(" and model.goodsId = :goodsId ");
            params.put("goodsId",refundCondition.getGoodsId());
        }
        if(StringUtils.isNotBlank(refundCondition.getUserName())){
            sb.append(" and model.userName like :userName ");
            params.put("userName","%"+refundCondition.getUserName()+"%");
        }
        if(StringUtils.isNotBlank(refundCondition.getRefundNo())){
            sb.append(" and model.refundNo like :refundNo ");
            params.put("refundNo","%"+refundCondition.getRefundNo()+"%");
        }
        if(refundCondition.getRefundCreateTime()!=null){
            sb.append(" and model.refundCreateTime = :refundCreateTime ");
            params.put("refundCreateTime",refundCondition.getRefundCreateTime());
        }
        if(StringUtils.isNotBlank(refundCondition.getRefundStatus())){
            sb.append(" and model.refundStatus like :refundStatus ");
            params.put("refundStatus","%"+refundCondition.getRefundStatus()+"%");
        }
        if(StringUtils.isNotBlank(refundCondition.getHasGoodsReturn())){
            sb.append(" and model.hasGoodsReturn like :hasGoodsReturn ");
            params.put("hasGoodsReturn","%"+refundCondition.getHasGoodsReturn()+"%");
        }
        sb.append(" order by model.id desc ");
        return queryByJpql(sb.toString(), params, pageable);
    }

    @Override 
    public List<Refund> list(RefundCondition refundCondition){
        StringBuffer sb=new StringBuffer("select model from Refund model  where 1=1  ");
        Map<String,Object> params = new HashMap<String,Object>();
        if(refundCondition.getGoodsId()!=null){
            sb.append(" and model.goodsId = :goodsId ");
            params.put("goodsId",refundCondition.getGoodsId());
        }
        if(StringUtils.isNotBlank(refundCondition.getUserName())){
            sb.append(" and model.userName like :userName ");
            params.put("userName","%"+refundCondition.getUserName()+"%");
        }
        if(StringUtils.isNotBlank(refundCondition.getRefundNo())){
            sb.append(" and model.refundNo like :refundNo ");
            params.put("refundNo","%"+refundCondition.getRefundNo()+"%");
        }
        if(refundCondition.getRefundCreateTime()!=null){
            sb.append(" and model.refundCreateTime = :refundCreateTime ");
            params.put("refundCreateTime",refundCondition.getRefundCreateTime());
        }
        if(StringUtils.isNotBlank(refundCondition.getRefundStatus())){
            sb.append(" and model.refundStatus like :refundStatus ");
            params.put("refundStatus","%"+refundCondition.getRefundStatus()+"%");
        }
        if(StringUtils.isNotBlank(refundCondition.getHasGoodsReturn())){
            sb.append(" and model.hasGoodsReturn like :hasGoodsReturn ");
            params.put("hasGoodsReturn","%"+refundCondition.getHasGoodsReturn()+"%");
        }
        sb.append(" order by model.id desc ");
        return queryByJpql(sb.toString(), params);
    }
    
    
    @Override 
    public Page< Map<String,Object>> listBySql(RefundCondition condition,Pageable pageable){
        StringBuffer sb=new StringBuffer("select id,tid,order_sn,order_status,total_fee,goods_id,goods_price,goods_num,goods_status,user_id,username,refund_no,refund_msg,refund_create_time,refund_complete_time,refund_status,has_goods_return,apply_refund_fee,payment,reason,description,refund_address,real_refund_fee,refuse_reason,refuse_desc,photo1,photo2,photo3,photo4,photo5,sid,company_name from trade_refund  where 1=1  ");
        Map<Integer,Object> params = new HashMap<Integer,Object>();
        if(condition.getGoodsId()!=null){
            sb.append(" and goods_id = ?6 ");
            params.put(6,condition.getGoodsId());
        }
        if(StringUtils.isNotBlank(condition.getUserName())){
            sb.append(" and userName like ?11 ");
            params.put(11,"%"+condition.getUserName()+"%");
        }
        if(StringUtils.isNotBlank(condition.getRefundNo())){
            sb.append(" and refund_no like ?12 ");
            params.put(12,"%"+condition.getRefundNo()+"%");
        }
        if(condition.getRefundCreateTime()!=null){
            sb.append(" and refund_create_time = ?14 ");
            params.put(14,condition.getRefundCreateTime());
        }
        if(StringUtils.isNotBlank(condition.getRefundStatus())){
            sb.append(" and refund_status like ?16 ");
            params.put(16,"%"+condition.getRefundStatus()+"%");
        }
        if(StringUtils.isNotBlank(condition.getHasGoodsReturn())){
            sb.append(" and has_goods_return like ?17 ");
            params.put(17,"%"+condition.getHasGoodsReturn()+"%");
        }
        sb.append(" order by id desc ");
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

	@Override
	public Refund findByOrderID(Long id) {
		StringBuffer sb=new StringBuffer("select model from Refund model  where 1=1  ");
        Map<String,Object> params = new HashMap<String,Object>();
        if(id != null){
            sb.append(" and model.tid = :tid ");
            params.put("tid",id);
        }
        List<Refund> result = queryByJpql(sb.toString(), params);
        return result.isEmpty() ? null : result.get(0);
	}
       
}