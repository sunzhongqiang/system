/*
 * 
 *  TuanDaoImpl 创建于 2016-11-07 14:59:09 版权归作者和作者当前组织所有
 */
package com.mmk.trade.dao.impl;

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
import com.mmk.trade.condition.TuanCondition;
import com.mmk.trade.dao.TuanDao;
import com.mmk.trade.model.Tuan;



/**
* TuanDaoImpl: 团管理 数据持久层接口实现
*@author huguangling 胡广玲
*@version 1.0
*
*/
@Repository
public class TuanDaoImpl extends SpringDataQueryDaoImpl<Tuan> implements TuanDao {
    
    private Log log = LogFactory.getLog(this.getClass());
    
    public TuanDaoImpl(){
        super(Tuan.class);
    }
    
    /**
     * 分页查询相关信息，根据传入的bean类对象和分页对象page取得查询结果集List
     * @param tuanCondition 查询类
     * @param pageable 传入的分页对象
     * @return 符合条件的查询结果集
     * @author huguangling 胡广玲
     * 
     */
    @Override 
    public Page<Tuan> list(TuanCondition tuanCondition,Pageable pageable){
        StringBuffer sb=new StringBuffer("select model from Tuan model  where 1=1  ");
        Map<String,Object> params = new HashMap<String,Object>();
        if(tuanCondition.getId()!=null){
            sb.append(" and model.id = :id ");
            params.put("id",tuanCondition.getId());
        }
        if(tuanCondition.getGroupId()!=null){
            sb.append(" and model.goodsId = :goodsId ");
            params.put("goodsId",tuanCondition.getGroupId());
        }
        if(StringUtils.isNotBlank(tuanCondition.getTuanCode())){
            sb.append(" and model.tuanCode like :tuanCode ");
            params.put("tuanCode","%"+tuanCondition.getTuanCode()+"%");
        }
        if(tuanCondition.getTuanStartDate()!=null){
            sb.append(" and model.tuanStartDate = :tuanStartDate ");
            params.put("tuanStartDate",tuanCondition.getTuanStartDate());
        }
        if(tuanCondition.getTuanEndDate()!=null){
            sb.append(" and model.tuanEndDate = :tuanEndDate ");
            params.put("tuanEndDate",tuanCondition.getTuanEndDate());
        }
        if(tuanCondition.getOrderSort()!=null){
            sb.append(" and model.orderSort = :orderSort ");
            params.put("orderSort",tuanCondition.getOrderSort());
        }
        if(StringUtils.isNotBlank(tuanCondition.getUserName())){
            sb.append(" and model.userName like :userName ");
            params.put("userName","%"+tuanCondition.getUserName()+"%");
        }
        if(tuanCondition.getTuanStatus()!=null){
            sb.append(" and model.tuanStatus = :tuanStatus ");
            params.put("tuanStatus",tuanCondition.getTuanStatus());
        }
        return queryByJpql(sb.toString(), params, pageable);
    }

    @Override 
    public List<Tuan> list(TuanCondition tuanCondition){
        StringBuffer sb=new StringBuffer("select model from Tuan model  where 1=1  ");
        Map<String,Object> params = new HashMap<String,Object>();
        if(tuanCondition.getId()!=null){
            sb.append(" and model.id = :id ");
            params.put("id",tuanCondition.getId());
        }
        if(tuanCondition.getGroupId()!=null){
            sb.append(" and model.goodsId = :goodsId ");
            params.put("goodsId",tuanCondition.getGroupId());
        }
        if(StringUtils.isNotBlank(tuanCondition.getTuanCode())){
            sb.append(" and model.tuanCode like :tuanCode ");
            params.put("tuanCode","%"+tuanCondition.getTuanCode()+"%");
        }
        if(tuanCondition.getTuanStartDate()!=null){
            sb.append(" and model.tuanStartDate = :tuanStartDate ");
            params.put("tuanStartDate",tuanCondition.getTuanStartDate());
        }
        if(tuanCondition.getTuanEndDate()!=null){
            sb.append(" and model.tuanEndDate = :tuanEndDate ");
            params.put("tuanEndDate",tuanCondition.getTuanEndDate());
        }
        if(tuanCondition.getOrderSort()!=null){
            sb.append(" and model.orderSort = :orderSort ");
            params.put("orderSort",tuanCondition.getOrderSort());
        }
        if(StringUtils.isNotBlank(tuanCondition.getUserName())){
            sb.append(" and model.userName like :userName ");
            params.put("userName","%"+tuanCondition.getUserName()+"%");
        }
        if(tuanCondition.getTuanStatus()!=null){
            sb.append(" and model.tuanStatus = :tuanStatus ");
            params.put("tuanStatus",tuanCondition.getTuanStatus());
        }
        return queryByJpql(sb.toString(), params);
    }
    
    
    @Override 
    public Page< Map<String,Object>> listBySql(TuanCondition condition,Pageable pageable){
        StringBuffer sb=new StringBuffer("select id,goods_id,tuan_code,people_num,tuan_start_date,tuan_end_date,order_sort,good_img,good_name,good_code,good_price,order_code,user_name,tuan_status from trade_tuan  where 1=1  ");
        Map<Integer,Object> params = new HashMap<Integer,Object>();
        if(condition.getId()!=null){
            sb.append(" and id = ?1 ");
            params.put(1,condition.getId());
        }
        if(condition.getGroupId()!=null){
            sb.append(" and goods_id = ?2 ");
            params.put(2,condition.getGroupId());
        }
        if(StringUtils.isNotBlank(condition.getTuanCode())){
            sb.append(" and tuan_code like ?3 ");
            params.put(3,"%"+condition.getTuanCode()+"%");
        }
        if(condition.getTuanStartDate()!=null){
            sb.append(" and tuan_start_date = ?5 ");
            params.put(5,condition.getTuanStartDate());
        }
        if(condition.getTuanEndDate()!=null){
            sb.append(" and tuan_end_date = ?6 ");
            params.put(6,condition.getTuanEndDate());
        }
        if(condition.getOrderSort()!=null){
            sb.append(" and order_sort = ?7 ");
            params.put(7,condition.getOrderSort());
        }
        if(StringUtils.isNotBlank(condition.getUserName())){
            sb.append(" and user_name like ?13 ");
            params.put(13,"%"+condition.getUserName()+"%");
        }
        if(condition.getTuanStatus()!=null){
            sb.append(" and tuan_status = ?14 ");
            params.put(14,condition.getTuanStatus());
        }
        return queryFieldsBySql(sb.toString(), params, pageable);
    }
    
    @Override 
    public Tuan findBy(String field,Object value){
        StringBuffer sb=new StringBuffer("select model from Tuan model  where model.");
        sb.append(field);
        sb.append(" = :value ");
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("value",value);
        List<Tuan> result = queryByJpql(sb.toString(), params,0l,1l);
        return result.isEmpty() ? null : result.get(0);
    }
    
    @Override 
    public List<Tuan> findAllBy(String field,Object value){
        StringBuffer sb=new StringBuffer("select model from Tuan model  where model.");
        sb.append(field);
       sb.append(" = :value ");
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("value",value);
        return queryByJpql(sb.toString(), params);
    }

	@Override
	public Tuan findById(Long id) {
        StringBuffer sb=new StringBuffer("select model from Tuan model where 1=1  ");
        Map<String,Object> params = new HashMap<String,Object>();

		sb.append(" and model.id = :id ");
		params.put("id", id);
        List<Tuan> tuanList = queryByJpql(sb.toString(), params);
        return tuanList.isEmpty() ? null : tuanList.get(0);
	}

	@Override
	public Page<Tuan> findAllByGroupIdAndStatus(Long groupId, Long status, Pageable pageable) {
		StringBuffer sb=new StringBuffer("select model from Tuan model  where 1=1  ");
        Map<String,Object> params = new HashMap<String,Object>();
        if(groupId!=null){
            sb.append(" and model.groupId = :groupId ");
            params.put("groupId",groupId);
        }
        if(status!=null){
            sb.append(" and model.tuanStatus = :tuanStatus ");
            params.put("tuanStatus",status);
        }
        return queryByJpql(sb.toString(), params, pageable);
	}
   
}