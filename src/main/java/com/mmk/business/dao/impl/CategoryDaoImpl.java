/*
 * 
 *  CategoryDaoImpl 创建于 2016-11-29 13:54:25 版权归作者和作者当前组织所有
 */
package com.mmk.business.dao.impl;

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

import com.mmk.business.model.Category;
import com.mmk.business.dao.CategoryDao;

import com.mmk.business.condition.CategoryCondition;



/**
* CategoryDaoImpl: 商品分类 数据持久层接口实现
*@author 孙中强 sunzhongqiang
*@version 1.0
*
*/
@Repository
public class CategoryDaoImpl extends SpringDataQueryDaoImpl<Category> implements CategoryDao {
    
    private Log log = LogFactory.getLog(this.getClass());
    
    public CategoryDaoImpl(){
        super(Category.class);
    }
    
    /**
     * 分页查询相关信息，根据传入的bean类对象和分页对象page取得查询结果集List
     * @param categoryCondition 查询类
     * @param pageable 传入的分页对象
     * @return 符合条件的查询结果集
     * @author 孙中强 sunzhongqiang
     * 
     */
    @Override 
    public Page<Category> list(CategoryCondition categoryCondition,Pageable pageable){
        StringBuffer sb=new StringBuffer("select model from Category model  where 1=1  ");
        Map<String,Object> params = new HashMap<String,Object>();
        if(StringUtils.isNotBlank(categoryCondition.getName())){
            sb.append(" and model.name like :name ");
            params.put("name","%"+categoryCondition.getName()+"%");
        }
        if(StringUtils.isNotBlank(categoryCondition.getPath())){
            sb.append(" and model.path like :path ");
            params.put("path","%"+categoryCondition.getPath()+"%");
        }
        sb.append(" order by model.sortOrder ");
        return queryByJpql(sb.toString(), params, pageable);
    }

    @Override 
    public List<Category> list(CategoryCondition categoryCondition){
        StringBuffer sb=new StringBuffer("select model from Category model  where 1=1  ");
        Map<String,Object> params = new HashMap<String,Object>();
        if(StringUtils.isNotBlank(categoryCondition.getName())){
            sb.append(" and model.name like :name ");
            params.put("name","%"+categoryCondition.getName()+"%");
        }
        if(StringUtils.isNotBlank(categoryCondition.getPath())){
            sb.append(" and model.path like :path ");
            params.put("path","%"+categoryCondition.getPath()+"%");
        }
        sb.append(" order by model.sortOrder ");
        return queryByJpql(sb.toString(), params);
    }
    
    
    @Override 
    public Page< Map<String,Object>> listBySql(CategoryCondition condition,Pageable pageable){
        StringBuffer sb=new StringBuffer("select id,parent_id,name,path,sort_order,is_show,cat_ico,cat_logo from business_category  where 1=1  ");
        Map<Integer,Object> params = new HashMap<Integer,Object>();
        if(StringUtils.isNotBlank(condition.getName())){
            sb.append(" and name like ?3 ");
            params.put(3,"%"+condition.getName()+"%");
        }
        if(StringUtils.isNotBlank(condition.getPath())){
            sb.append(" and path like ?4 ");
            params.put(4,"%"+condition.getPath()+"%");
        }
        return queryFieldsBySql(sb.toString(), params, pageable);
    }
    
    @Override 
    public Category findBy(String field,Object value){
        StringBuffer sb=new StringBuffer("select model from Category model  where model.");
        sb.append(field);
        sb.append(" = :value ");
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("value",value);
        List<Category> result = queryByJpql(sb.toString(), params,0l,1l);
        return result.isEmpty() ? null : result.get(0);
    }
    
    @Override 
    public List<Category> findAllBy(String field,Object value){
        StringBuffer sb=new StringBuffer("select model from Category model  where model.");
        sb.append(field);
       sb.append(" = :value ");
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("value",value);
        return queryByJpql(sb.toString(), params);
    }

	@Override
	public List<Category> findAllBy(CategoryCondition categoryCondition) {
		StringBuffer sb=new StringBuffer("select model from Category model  where 1=1  ");
        Map<String,Object> params = new HashMap<String,Object>();
        if(StringUtils.isNotBlank(categoryCondition.getName())){
            sb.append(" and model.name like :name ");
            params.put("name","%"+categoryCondition.getName()+"%");
        }
        if(StringUtils.isNotBlank(categoryCondition.getPath())){
            sb.append(" and model.path like :path ");
            params.put("path","%"+categoryCondition.getPath()+"%");
        }
        sb.append(" order by model.sortOrder ");
		return queryByJpql(sb.toString(), params);
	}

	@Override
	public List<Category> findChildrenByPath(String path) {
		StringBuffer sb=new StringBuffer("select model from Category model  where 1=1  ");
        Map<String,Object> params = new HashMap<String,Object>();
        if(StringUtils.isNotBlank(path)){
            sb.append(" and model.path like :path ");
            params.put("path",path+"%");
        }
        sb.append(" order by model.sortOrder ");
		return queryByJpql(sb.toString(), params);
	}
    
    
}