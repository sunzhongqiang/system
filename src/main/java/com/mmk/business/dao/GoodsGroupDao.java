/*
 * 
 *  GoodsGroupDao 创建于 2016-11-17 11:42:27 版权归作者和作者当前组织所有
 */
package com.mmk.business.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mmk.business.condition.GoodsGroupCondition;
import com.mmk.business.model.GoodsGroup;
import com.mmk.gene.dao.SpringDataQueryDao;
/**
* GoodsGroupDao:商品拼团管理 数据持久层接口
* @author 孙中强 sunzhongqiang
* @version 1.0
*/
public interface GoodsGroupDao extends SpringDataQueryDao<GoodsGroup>{
    
    /**
     * 分页查询相关信息，根据传入的bean类对象和分页对象page取得查询结果集List
     * @param goodsGroup 查询类
     * @param pageable 传入的分页对象
     * @return 符合条件的查询结果集
     * @author 孙中强 sunzhongqiang
     * 
     * 
     */
    Page<GoodsGroup> list(GoodsGroupCondition goodsGroup,Pageable pageable);
    /**
     * 不分页查询相关信息，根据传入的model类对象取得查询结果集List
     * @param goodsGroup 查询类
     * @return 符合条件的查询结果集
     * @author 孙中强 sunzhongqiang
     * 
     */
    List<GoodsGroup> list(GoodsGroupCondition goodsGroup);
    /**
     * 使用sql查询，并以map和分页的形式进行返回数据结果
     * @param goodsGroup GoodsGroup类
     * @param pageable 传入的分页对象
     * @return 符合条件的查询结果集
     * @author 孙中强 sunzhongqiang
     * 
     * 
     */
    Page<Map<String,Object>> listBySql(GoodsGroupCondition goodsGroup,Pageable pageable);
    /**
     * 根据给定的字段和属性值，获得符合条件的第一个结果
     * @param field GoodsGroup 中的某个字段
     * @param value 字段对应的值
     * @return 返回符合条件的结果，如果没有返回null
     * @author 孙中强 sunzhongqiang
     * 
     * 
     */
    GoodsGroup findBy(String field,Object value);
    
    /**
     * 根据给定的字段和属性值，获得符合条件的所有结果
     * @param field GoodsGroup 中的某个字段
     * @param value 字段对应的值
     * @return 返回符合条件的所有结果
     * @author 孙中强 sunzhongqiang
     * 
     * 
     */
    List<GoodsGroup> findAllBy(String field,Object value);
    
    /**
     * 更加
     * @param goods
     * @return
     */
	List<GoodsGroup> findAllByGoodsId(Long goodsId);
	/**
	 * 获得推荐的团商品
	 * @param code
	 * @param pageable
	 * @return
	 */
	Page<GoodsGroup> findRecommend(String code, Pageable pageable);
	
	/**
	 * 获取即将开始的团 
	 * @param pageable
	 * @return
	 */
	Page<GoodsGroup> findAllByStart(Date begin, Date end,Long type,Pageable pageable);
	
	/**
	 * 根据类型和状态进行返回到期结束的商品
	 * @param type
	 * @param status
	 * @param pageable
	 * @return 返回到期结束的商品
	 */
	Page<GoodsGroup> findAllOverTime(long type, String status, Pageable pageable);
	
    
    

}