package com.mmk.base.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.mmk.base.condition.RegionCondition;
import com.mmk.base.dao.RegionDao;
import com.mmk.base.model.Region;
import com.mmk.gene.dao.impl.SpringDataQueryDaoImpl;



/**
*@Title: 地区表dao层实现类
*@Description: 
*@Copyright: Copyright (c) 2011
*@Company: echin
*@author codebuilder
*@version 1.0
*/
@Repository
public class RegionDaoImpl extends SpringDataQueryDaoImpl<Region> implements RegionDao {

	public RegionDaoImpl(){
        super(Region.class);
    }

	@Override
	public List<Region> listByRegionType(String regionType) {
		StringBuffer sb=new StringBuffer("select model from Region model  where 1=1  ");
        Map<String,Object> params = new HashMap<String,Object>();
        
        if(!StringUtils.isNotBlank(regionType)) {
            sb.append(" and model.regionType in :regionType");
            params.put("regionType", regionType);
        }
        
        sb.append(" and model.regionName <> '' order by model.parentId asc, model.id asc");
        
        return queryByJpql(sb.toString(), params);
	}

	@Override
	public List<Map<String, Object>> listBigRegionInfo(Integer regionType,Long shippingId) {
		StringBuffer sql=new StringBuffer();
		Map<Integer,Object> params = new HashMap<Integer,Object>();
        
		sql.append(" select belongs_bigregion, ");
		sql.append(" concat(GROUP_CONCAT(concat(t.region_id,':',region_name,':',if(r.shipping_id is null,'0','1'))),'') as regions ");
		sql.append(" from ecs_region t ");
		sql.append(" left join ( ");
		sql.append(" 	select a.region_id,s.shipping_id from ecs_area_region a  ");
		sql.append(" 	left join ecs_shipping_area s on a.shipping_area_id =s.shipping_area_id ");
		sql.append(" 	where s.shipping_id = ?1 ");
		sql.append(" ) r on t.region_id = r.region_id where 1=1  ");
		
		params.put(1, shippingId==null?0L:shippingId);
		
        if(null!=regionType) {
        	sql.append(" and parent_id =?2 ");
            params.put(2, regionType);
        }
        
        sql.append(" group by belongs_bigregion order by length(belongs_bigregion),belongs_bigregion ");
        
        return queryFieldsBySql(sql.toString(), params);
	}

	@Override
	public List<Map<String, Object>> isRegionAllSet(String regionName) {
		StringBuffer sql=new StringBuffer();
		Map<Integer,Object> params = new HashMap<Integer,Object>();
        
		sql.append(" select GROUP_CONCAT(t.region_name) as region_names,GROUP_CONCAT(t.region_id) as region_ids  ");
		sql.append(" from ecs_region t  ");
		sql.append(" where t.parent_id=1 ");
		sql.append(" and t.region_id not in( ");
		sql.append(regionName);
		sql.append(" ) group  by t.parent_id ");
		
        return queryFieldsBySql(sql.toString(), params);
	}

	
	 /**
     * 分页查询相关信息，根据传入的bean类对象和分页对象page取得查询结果集List
     * @param modelRegionCondition类
     * @param page 传入的分页对象
     * @return Page<Region> 查询的结果集
     * @author code generator
     * @date 2016-05-23 14:56:51
     */
    @Override 
    public Page<Region> list(RegionCondition regionCondition,Pageable pageable){
        StringBuffer sb=new StringBuffer("select model from Region model  where model.regionId!=0  ");
        Map<String,Object> params = new HashMap<String,Object>();
        if(regionCondition.getRegionId()!=null){
            sb.append(" and model.regionId = :regionId ");
            params.put("regionId",regionCondition.getRegionId());
        }
        
        if(regionCondition.getParentId()!=null){
            sb.append(" and model.parentId = :parentId ");
            params.put("parentId",regionCondition.getParentId());
        }else{
        	sb.append(" and model.parentId = 0 ");
        }
        
        if(StringUtils.isNotBlank(regionCondition.getRegionName())){
            sb.append(" and model.regionName like :regionName ");
            params.put("regionName","%"+regionCondition.getRegionName()+"%");
        }
        
//        if(regionCondition.getRegionType()!=null){
//            sb.append(" and model.regionType = :regionType ");
//            params.put("regionType",regionCondition.getRegionType());
//        }
        return queryByJpql(sb.toString(), params, pageable);
    }

    @Override 
    public List<Region> list(RegionCondition regionCondition){
        StringBuffer sb=new StringBuffer("select model from Region model  where 1=1  ");
        Map<String,Object> params = new HashMap<String,Object>();
        if(regionCondition.getRegionId()!=null){
            sb.append(" and model.regionId = :regionId ");
            params.put("regionId",regionCondition.getRegionId());
        }
        if(regionCondition.getParentId()!=null){
            sb.append(" and model.parentId = :parentId ");
            params.put("parentId",regionCondition.getParentId());
        }
        if(StringUtils.isNotBlank(regionCondition.getRegionName())){
            sb.append(" and model.regionName like :regionName ");
            params.put("regionName","%"+regionCondition.getRegionName()+"%");
        }
        if(regionCondition.getRegionType()!=null){
            sb.append(" and model.regionType = :regionType ");
            params.put("regionType",regionCondition.getRegionType());
        }
        return queryByJpql(sb.toString(), params);
    }
    
    
    @Override 
    public Page< Map<String,Object>> listBySql(RegionCondition condition,Pageable pageable){
        StringBuffer sb=new StringBuffer("select region_id,parent_id,region_name,region_type,agency_id,hot_city,is_display,check_num,belongs_bigregion from ecs_region  where 1=1  ");
        Map<Integer,Object> params = new HashMap<Integer,Object>();
        if(condition.getRegionId()!=null){
            sb.append(" and region_id = ?1 ");
            params.put(1,condition.getRegionId());
        }
        if(condition.getParentId()!=null){
            sb.append(" and parent_id = ?2 ");
            params.put(2,condition.getParentId());
        }
        if(StringUtils.isNotBlank(condition.getRegionName())){
            sb.append(" and region_name like ?3 ");
            params.put(3,"%"+condition.getRegionName()+"%");
        }
        if(condition.getRegionType()!=null){
            sb.append(" and region_type = ?4 ");
            params.put(4,condition.getRegionType());
        }
        return queryFieldsBySql(sb.toString(), params, pageable);
    }
    
    
    @Override 
    public Region findBy(String field,Object value){
        StringBuffer sb=new StringBuffer("select model from Region model  where model.");
        sb.append(field);
        sb.append(" = :value ");
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("value",value);
        List<Region> result = queryByJpql(sb.toString(), params,0l,1l);
        return result.isEmpty() ? null : result.get(0);
    }
    
    @Override 
    public List<Region> findAllBy(String field,Object value){
        StringBuffer sb=new StringBuffer("select model from Region model  where model.");
        sb.append(field);
       sb.append(" = :value ");
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("value",value);
        return queryByJpql(sb.toString(), params);
    }
    
    @Override 
    public Long findMaxRegionId(){
    	StringBuffer sql=new StringBuffer("select (if(max(region_id) is null,0,max(region_id))+1) as maxNum from ecs_region ");
        Map<Integer,Object> params = new HashMap<Integer,Object>();
        List<Map<String,Object>> list  = queryFieldsBySql(sql.toString(), params);
        
        return list.isEmpty()?1L:MapUtils.getLong(list.get(0),"maxNum");
    }
    
    @Override 
    public List<Region> findAllRegionByProxyId(Long proxyId,String proxyGrade){    	
       
        StringBuffer sql = new StringBuffer();
        sql.append(" select t.* from ecs_region t where 1=1 ");        
        if("1".equals(proxyGrade)){
        	 sql.append(" and t.region_id in ( ")
        	 	.append(" 	select district_region_id from  echin_proxy_region pr ")
        	 	.append(" 	where pr.proxy_id = ?1 ")
        	 	.append(" ) ");
        }else if("2".equals(proxyGrade)){
        	sql.append(" and t.parent_id in ( ")
	    	 	.append(" 	select city_region_id from  echin_proxy_region pr ")
	    	 	.append(" 	where pr.proxy_id = ?1 ")
	    	 	.append(" ) ");
        }else if("3".equals(proxyGrade)){
        	sql.append(" and t.parent_id in ( ")
        		.append(" 	select r.region_id from ecs_region r where r.parent_id in ( ")
        		.append(" 		select province_region_id from  echin_proxy_region pr  ")
        		.append(" 		where pr.proxy_id = ?1 ")
        		.append(" 	) ")
	    	 	.append(" ) ");
        }
        
        Map<Integer,Object> params = new HashMap<Integer,Object>();
        params.put(1, proxyId);
        
        return queryBySql(sql.toString(), params);
    }
}
