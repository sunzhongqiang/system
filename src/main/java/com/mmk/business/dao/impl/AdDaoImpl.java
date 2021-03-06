/*
 * 
 *  AdDaoImpl 创建于 2016-11-03 11:37:27 版权归作者和作者当前组织所有
 */
package com.mmk.business.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.mmk.business.condition.AdCondition;
import com.mmk.business.dao.AdDao;
import com.mmk.business.model.Ad;
import com.mmk.gene.dao.impl.SpringDataQueryDaoImpl;



/**
* AdDaoImpl: 广告 数据持久层接口实现
*@author huguangling 胡广玲
*@version 1.0
*
*/
@Repository
public class AdDaoImpl extends SpringDataQueryDaoImpl<Ad> implements AdDao {
    
    private Log log = LogFactory.getLog(this.getClass());
    
    public AdDaoImpl(){
        super(Ad.class);
    }
    
    /**
     * 分页查询相关信息，根据传入的bean类对象和分页对象page取得查询结果集List
     * @param adCondition 查询类
     * @param pageable 传入的分页对象
     * @return 符合条件的查询结果集
     * @author huguangling 胡广玲
     * 
     */
    @Override 
    public Page<Ad> list(AdCondition adCondition,Pageable pageable){
        StringBuffer sb=new StringBuffer("select model from Ad model  where 1=1  ");
        Map<String,Object> params = new HashMap<String,Object>();
        if(adCondition.getPositionId() != null){
	        sb.append(" and model.positionId = :positionId ");
	        params.put("positionId", adCondition.getPositionId());
        }
        
        return queryByJpql(sb.toString(), params, pageable);
    }

    @Override 
    public List<Ad> list(AdCondition adCondition){
        StringBuffer sb=new StringBuffer("select model from Ad model  where 1=1  ");
        Map<String,Object> params = new HashMap<String,Object>();
        return queryByJpql(sb.toString(), params);
    }
    
    
    @Override 
    public Page< Map<String,Object>> listBySql(AdCondition condition,Pageable pageable){
        StringBuffer sb=new StringBuffer("select ad_id,position_id,ad_name,ad_link,ad_code,start_time,end_time,click_count,description from business_ad  where 1=1  ");
        Map<Integer,Object> params = new HashMap<Integer,Object>();
        return queryFieldsBySql(sb.toString(), params, pageable);
    }
    
    @Override 
    public Ad findBy(String field,Object value){
        StringBuffer sb=new StringBuffer("select model from Ad model  where model.");
        sb.append(field);
        sb.append(" = :value ");
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("value",value);
        List<Ad> result = queryByJpql(sb.toString(), params,0l,1l);
        return result.isEmpty() ? null : result.get(0);
    }
    
    @Override 
    public List<Ad> findAllBy(String field,Object value){
        StringBuffer sb=new StringBuffer("select model from Ad model  where model.");
        sb.append(field);
       sb.append(" = :value ");
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("value",value);
        return queryByJpql(sb.toString(), params);
    }

	@Override
	public List<Ad> findAllByPositionCode(String code) {
		StringBuffer sb=new StringBuffer("select model from Ad  model ,AdPosition postion where model.positionId = postion.positionId  ");
        Map<String,Object> params = new HashMap<String,Object>();
        if(StringUtils.isNotBlank(code)){
        	sb.append(" and postion.positionCode = :code ");
        	params.put("code", code);
        }
        return queryByJpql(sb.toString(), params);
	}
    
    
}