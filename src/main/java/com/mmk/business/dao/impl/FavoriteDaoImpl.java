/*
 * 
 *  FavoriteDaoImpl 创建于 2016-11-30 09:24:22 版权归作者和作者当前组织所有
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

import com.mmk.business.model.Favorite;
import com.mmk.business.dao.FavoriteDao;

import com.mmk.business.condition.FavoriteCondition;



/**
* FavoriteDaoImpl: 团收藏 数据持久层接口实现
*@author huguangling 胡广玲
*@version 1.0
*
*/
@Repository
public class FavoriteDaoImpl extends SpringDataQueryDaoImpl<Favorite> implements FavoriteDao {
    
    private Log log = LogFactory.getLog(this.getClass());
    
    public FavoriteDaoImpl(){
        super(Favorite.class);
    }
    
    /**
     * 分页查询相关信息，根据传入的bean类对象和分页对象page取得查询结果集List
     * @param favoriteCondition 查询类
     * @param pageable 传入的分页对象
     * @return 符合条件的查询结果集
     * @author huguangling 胡广玲
     * 
     */
    @Override 
    public Page<Favorite> list(FavoriteCondition favoriteCondition,Pageable pageable){
        StringBuffer sb=new StringBuffer("select model from Favorite model  where 1=1  ");
        Map<String,Object> params = new HashMap<String,Object>();
        return queryByJpql(sb.toString(), params, pageable);
    }

    @Override 
    public List<Favorite> list(FavoriteCondition favoriteCondition){
        StringBuffer sb=new StringBuffer("select model from Favorite model  where 1=1  ");
        Map<String,Object> params = new HashMap<String,Object>();
        return queryByJpql(sb.toString(), params);
    }
    
    
    @Override 
    public Page< Map<String,Object>> listBySql(FavoriteCondition condition,Pageable pageable){
        StringBuffer sb=new StringBuffer("select id,group_id,goods_id,user_id,openid from business_favorite  where 1=1  ");
        Map<Integer,Object> params = new HashMap<Integer,Object>();
        return queryFieldsBySql(sb.toString(), params, pageable);
    }
    
    @Override 
    public Favorite findBy(String field,Object value){
        StringBuffer sb=new StringBuffer("select model from Favorite model  where model.");
        sb.append(field);
        sb.append(" = :value ");
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("value",value);
        List<Favorite> result = queryByJpql(sb.toString(), params,0l,1l);
        return result.isEmpty() ? null : result.get(0);
    }
    
    @Override 
    public List<Favorite> findAllBy(String field,Object value){
        StringBuffer sb=new StringBuffer("select model from Favorite model  where model.");
        sb.append(field);
        sb.append(" = :value ");
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("value",value);
        return queryByJpql(sb.toString(), params);
    }

	@Override
	public Page<Favorite> findAllByUserId(Long userId, Pageable pageable) {
		StringBuffer sb=new StringBuffer("select model from Favorite model left join fetch model.groupGoods groupGoods left join fetch groupGoods.goods  where model.userId= :userId  ");
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("userId", userId);
        return queryByJpql(sb.toString(), params, pageable);
	}
    
    
}