/*
 * 
 *  RegionDaoImpl 创建于 2016-11-14 13:31:38 版权归作者和作者当前组织所有
 */
package com.mmk.system.dao.impl;

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
import com.mmk.system.condition.RegionCondition;
import com.mmk.system.dao.RegionDao;
import com.mmk.system.model.Region;



/**
* RegionDaoImpl: 区域管理 数据持久层接口实现
*@author huguangling 胡广玲
*@version 1.0
*
*/
@Repository
public class RegionDaoImpl extends SpringDataQueryDaoImpl<Region> implements RegionDao {
    
    private Log log = LogFactory.getLog(this.getClass());
    
    public RegionDaoImpl(){
        super(Region.class);
    }
    
    /**
     * 分页查询相关信息，根据传入的bean类对象和分页对象page取得查询结果集List
     * @param regionCondition 查询类
     * @param pageable 传入的分页对象
     * @return 符合条件的查询结果集
     * @author huguangling 胡广玲
     * 
     */
    @Override 
    public Page<Region> list(RegionCondition regionCondition,Pageable pageable){
        StringBuffer sb=new StringBuffer("select model from Region model  where 1=1  ");
        Map<String,Object> params = new HashMap<String,Object>();
        if(regionCondition.getParentId()!=null){
            sb.append(" and model.parentId = :parentId ");
            params.put("parentId",regionCondition.getParentId());
        }
        if(StringUtils.isNotBlank(regionCondition.getRegionName())){
            sb.append(" and model.regionName like :regionName ");
            params.put("regionName","%"+regionCondition.getRegionName()+"%");
        }
        if(regionCondition.getIsDisplay()!=null){
            sb.append(" and model.isDisplay = :isDisplay ");
            params.put("isDisplay",regionCondition.getIsDisplay());
        }
        if(StringUtils.isNotBlank(regionCondition.getBelongsBigregion())){
            sb.append(" and model.belongsBigregion like :belongsBigregion ");
            params.put("belongsBigregion","%"+regionCondition.getBelongsBigregion()+"%");
        }
        return queryByJpql(sb.toString(), params, pageable);
    }

    @Override 
    public List<Region> list(RegionCondition regionCondition){
        StringBuffer sb=new StringBuffer("select model from Region model  where 1=1  ");
        Map<String,Object> params = new HashMap<String,Object>();
        if(regionCondition.getParentId()!=null){
            sb.append(" and model.parentId = :parentId ");
            params.put("parentId",regionCondition.getParentId());
        }
        if(StringUtils.isNotBlank(regionCondition.getRegionName())){
            sb.append(" and model.regionName like :regionName ");
            params.put("regionName","%"+regionCondition.getRegionName()+"%");
        }
        if(regionCondition.getIsDisplay()!=null){
            sb.append(" and model.isDisplay = :isDisplay ");
            params.put("isDisplay",regionCondition.getIsDisplay());
        }
        if(StringUtils.isNotBlank(regionCondition.getBelongsBigregion())){
            sb.append(" and model.belongsBigregion like :belongsBigregion ");
            params.put("belongsBigregion","%"+regionCondition.getBelongsBigregion()+"%");
        }
        return queryByJpql(sb.toString(), params);
    }
    
    
    @Override 
    public Page< Map<String,Object>> listBySql(RegionCondition condition,Pageable pageable){
        StringBuffer sb=new StringBuffer("select region_id,parent_id,region_name,is_display,belongs_bigregion,full_region_name from system_region  where 1=1  ");
        Map<Integer,Object> params = new HashMap<Integer,Object>();
        if(condition.getParentId()!=null){
            sb.append(" and parent_id = ?2 ");
            params.put(2,condition.getParentId());
        }
        if(StringUtils.isNotBlank(condition.getRegionName())){
            sb.append(" and region_name like ?3 ");
            params.put(3,"%"+condition.getRegionName()+"%");
        }
        if(condition.getIsDisplay()!=null){
            sb.append(" and is_display = ?4 ");
            params.put(4,condition.getIsDisplay());
        }
        if(StringUtils.isNotBlank(condition.getBelongsBigregion())){
            sb.append(" and belongs_bigregion like ?5 ");
            params.put(5,"%"+condition.getBelongsBigregion()+"%");
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
	public List<Region> loadByParentId(Long parentId) {
		StringBuffer sb=new StringBuffer("select model from Region model  where 1=1  ");
        Map<String,Object> params = new HashMap<String,Object>();
        if(parentId!=null){
            sb.append(" and model.parentId = :parentId ");
            params.put("parentId",parentId);
        }else{
        	  sb.append(" and model.parentId = 0 ");
        }
        return queryByJpql(sb.toString(), params);
	}
       
}