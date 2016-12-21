/*
 * 
 *  GoodsSkuDao 创建于 2016-11-21 14:08:15 版权归作者和作者当前组织所有
 */
package com.mmk.business.dao;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mmk.business.condition.GoodsSkuCondition;
import com.mmk.business.model.GoodsSku;
import com.mmk.gene.dao.SpringDataQueryDao;
/**
* GoodsSkuDao:商品SKU 数据持久层接口
* @author sunzhongqiang 孙中强
* @version 1.0
*/
public interface GoodsSkuDao extends SpringDataQueryDao<GoodsSku>{
    
    /**
     * 分页查询相关信息，根据传入的bean类对象和分页对象page取得查询结果集List
     * @param goodsSku 查询类
     * @param pageable 传入的分页对象
     * @return 符合条件的查询结果集
     * @author sunzhongqiang 孙中强
     * 
     * 
     */
    Page<GoodsSku> list(GoodsSkuCondition goodsSku,Pageable pageable);
    /**
     * 不分页查询相关信息，根据传入的model类对象取得查询结果集List
     * @param goodsSku 查询类
     * @return 符合条件的查询结果集
     * @author sunzhongqiang 孙中强
     * 
     */
    List<GoodsSku> list(GoodsSkuCondition goodsSku);
    /**
     * 使用sql查询，并以map和分页的形式进行返回数据结果
     * @param goodsSku GoodsSku类
     * @param pageable 传入的分页对象
     * @return 符合条件的查询结果集
     * @author sunzhongqiang 孙中强
     * 
     * 
     */
    Page<Map<String,Object>> listBySql(GoodsSkuCondition goodsSku,Pageable pageable);
    /**
     * 根据给定的字段和属性值，获得符合条件的第一个结果
     * @param field GoodsSku 中的某个字段
     * @param value 字段对应的值
     * @return 返回符合条件的结果，如果没有返回null
     * @author sunzhongqiang 孙中强
     * 
     * 
     */
    GoodsSku findBy(String field,Object value);
    
    /**
     * 根据给定的字段和属性值，获得符合条件的所有结果
     * @param field GoodsSku 中的某个字段
     * @param value 字段对应的值
     * @return 返回符合条件的所有结果
     * @author sunzhongqiang 孙中强
     * 
     * 
     */
    List<GoodsSku> findAllBy(String field,Object value);
    
    

}