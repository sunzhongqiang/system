/*
 * 
 *  AdPositionDaoImpl 创建于 2016-11-03 11:37:58 版权归作者和作者当前组织所有
 */
package com.mmk.business.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.mmk.business.condition.AdPositionCondition;
import com.mmk.business.dao.AdPositionDao;
import com.mmk.business.model.AdPosition;
import com.mmk.gene.dao.impl.SpringDataQueryDaoImpl;



/**
* AdPositionDaoImpl: 广告位置 数据持久层接口实现
*@author huguangling 胡广玲
*@version 1.0
*
*/
@Repository
public class AdPositionDaoImpl extends SpringDataQueryDaoImpl<AdPosition> implements AdPositionDao {
    
    private Log log = LogFactory.getLog(this.getClass());
    
    public AdPositionDaoImpl(){
        super(AdPosition.class);
    }
    
    /**
     * 分页查询相关信息，根据传入的bean类对象和分页对象page取得查询结果集List
     * @param adPositionCondition 查询类
     * @param pageable 传入的分页对象
     * @return 符合条件的查询结果集
     * @author huguangling 胡广玲
     * 
     */
    @Override 
    public Page<AdPosition> list(AdPositionCondition adPositionCondition,Pageable pageable){
        StringBuffer sb=new StringBuffer("select model from AdPosition model  where 1=1  ");
        Map<String,Object> params = new HashMap<String,Object>();
        return queryByJpql(sb.toString(), params, pageable);
    }

    @Override 
    public List<AdPosition> list(AdPositionCondition adPositionCondition){
        StringBuffer sb=new StringBuffer("select model from AdPosition model  where 1=1  ");
        Map<String,Object> params = new HashMap<String,Object>();
        return queryByJpql(sb.toString(), params);
    }
    
    
    @Override 
    public Page< Map<String,Object>> listBySql(AdPositionCondition condition,Pageable pageable){
        StringBuffer sb=new StringBuffer("select position_id,position_name,ad_width,ad_height,position_desc from business_ad_position  where 1=1  ");
        Map<Integer,Object> params = new HashMap<Integer,Object>();
        return queryFieldsBySql(sb.toString(), params, pageable);
    }
    
    @Override 
    public AdPosition findBy(String field,Object value){
        StringBuffer sb=new StringBuffer("select model from AdPosition model  where model.");
        sb.append(field);
        sb.append(" = :value ");
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("value",value);
        List<AdPosition> result = queryByJpql(sb.toString(), params,0l,1l);
        return result.isEmpty() ? null : result.get(0);
    }
    
    @Override 
    public List<AdPosition> findAllBy(String field,Object value){
        StringBuffer sb=new StringBuffer("select model from AdPosition model  where model.");
        sb.append(field);
       sb.append(" = :value ");
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("value",value);
        return queryByJpql(sb.toString(), params);
    }
    
	@Override
	public List<AdPosition> listAll() {
    	StringBuffer sb=new StringBuffer("select model from AdPosition model ORDER BY model.positionId DESC");
        Map<String,Object> params = new HashMap<String,Object>();

        return queryByJpql(sb.toString(), params);
	}
    
}