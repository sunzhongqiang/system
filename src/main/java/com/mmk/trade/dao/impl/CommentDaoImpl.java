/*
 * 
 *  CommentDaoImpl 创建于 2016-11-11 13:31:11 版权归作者和作者当前组织所有
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
import com.mmk.trade.condition.CommentCondition;
import com.mmk.trade.dao.CommentDao;
import com.mmk.trade.model.Comment;



/**
* CommentDaoImpl: 评价管理 数据持久层接口实现
*@author huguangling 胡广玲
*@version 1.0
*
*/
@Repository
public class CommentDaoImpl extends SpringDataQueryDaoImpl<Comment> implements CommentDao {
    
    private Log log = LogFactory.getLog(this.getClass());
    
    public CommentDaoImpl(){
        super(Comment.class);
    }
    
    /**
     * 分页查询相关信息，根据传入的bean类对象和分页对象page取得查询结果集List
     * @param commentCondition 查询类
     * @param pageable 传入的分页对象
     * @return 符合条件的查询结果集
     * @author huguangling 胡广玲
     * 
     */
    @Override 
    public Page<Comment> list(CommentCondition commentCondition,Pageable pageable){
        StringBuffer sb=new StringBuffer("select model from Comment model  where 1=1  ");
        Map<String,Object> params = new HashMap<String,Object>();
        if(commentCondition.getGoodsId()!=null){
            sb.append(" and model.goodsId = :goodsId ");
            params.put("goodsId",commentCondition.getGoodsId());
        }
        if(StringUtils.isNotBlank(commentCondition.getUserName())){
            sb.append(" and model.userName like :userName ");
            params.put("userName","%"+commentCondition.getUserName()+"%");
        }
        return queryByJpql(sb.toString(), params, pageable);
    }

    @Override 
    public List<Comment> list(CommentCondition commentCondition){
        StringBuffer sb=new StringBuffer("select model from Comment model  where 1=1  ");
        Map<String,Object> params = new HashMap<String,Object>();
        if(commentCondition.getGoodsId()!=null){
            sb.append(" and model.goodsId = :goodsId ");
            params.put("goodsId",commentCondition.getGoodsId());
        }
        if(StringUtils.isNotBlank(commentCondition.getUserName())){
            sb.append(" and model.userName like :userName ");
            params.put("userName","%"+commentCondition.getUserName()+"%");
        }
        return queryByJpql(sb.toString(), params);
    }
    
    
    @Override 
    public Page< Map<String,Object>> listBySql(CommentCondition condition,Pageable pageable){
        StringBuffer sb=new StringBuffer("select id,goods_id,user_name,content,content_time,add_content,reply from trade_comment  where 1=1  ");
        Map<Integer,Object> params = new HashMap<Integer,Object>();
        if(condition.getGoodsId()!=null){
            sb.append(" and goods_id = ?2 ");
            params.put(2,condition.getGoodsId());
        }
        if(StringUtils.isNotBlank(condition.getUserName())){
            sb.append(" and user_name like ?3 ");
            params.put(3,"%"+condition.getUserName()+"%");
        }
        return queryFieldsBySql(sb.toString(), params, pageable);
    }
    
    @Override 
    public Comment findBy(String field,Object value){
        StringBuffer sb=new StringBuffer("select model from Comment model  where model.");
        sb.append(field);
        sb.append(" = :value ");
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("value",value);
        List<Comment> result = queryByJpql(sb.toString(), params,0l,1l);
        return result.isEmpty() ? null : result.get(0);
    }
    
    @Override 
    public List<Comment> findAllBy(String field,Object value){
        StringBuffer sb=new StringBuffer("select model from Comment model  where model.");
        sb.append(field);
       sb.append(" = :value ");
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("value",value);
        return queryByJpql(sb.toString(), params);
    }

	@Override
	public List<Comment> findCommentByGoodsId(Long goodsId) {
        StringBuffer sb=new StringBuffer("select model from Comment model  where 1=1  ");
        Map<String,Object> params = new HashMap<String,Object>();
        if(goodsId!=null){
            sb.append(" and model.goodsId = :goodsId ");
            params.put("goodsId", goodsId);
        }
        return queryByJpql(sb.toString(), params);
	}
    
}