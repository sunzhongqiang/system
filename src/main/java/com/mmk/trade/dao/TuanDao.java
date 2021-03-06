/*
 * 
 *  TuanDao 创建于 2016-11-07 14:59:09 版权归作者和作者当前组织所有
 */
package com.mmk.trade.dao;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mmk.gene.dao.SpringDataQueryDao;
import com.mmk.trade.condition.TuanCondition;
import com.mmk.trade.model.Tuan;
/**
* TuanDao:团管理 数据持久层接口
* @author huguangling 胡广玲
* @version 1.0
*/
public interface TuanDao extends SpringDataQueryDao<Tuan>{
    
    /**
     * 分页查询相关信息，根据传入的bean类对象和分页对象page取得查询结果集List
     * @param tuan 查询类
     * @param pageable 传入的分页对象
     * @return 符合条件的查询结果集
     * @author huguangling 胡广玲
     * 
     * 
     */
    Page<Tuan> list(TuanCondition tuan,Pageable pageable);
    /**
     * 不分页查询相关信息，根据传入的model类对象取得查询结果集List
     * @param tuan 查询类
     * @return 符合条件的查询结果集
     * @author huguangling 胡广玲
     * 
     */
    List<Tuan> list(TuanCondition tuan);
    /**
     * 使用sql查询，并以map和分页的形式进行返回数据结果
     * @param tuan Tuan类
     * @param pageable 传入的分页对象
     * @return 符合条件的查询结果集
     * @author huguangling 胡广玲
     * 
     * 
     */
    Page<Map<String,Object>> listBySql(TuanCondition tuan,Pageable pageable);
    /**
     * 根据给定的字段和属性值，获得符合条件的第一个结果
     * @param field Tuan 中的某个字段
     * @param value 字段对应的值
     * @return 返回符合条件的结果，如果没有返回null
     * @author huguangling 胡广玲
     * 
     * 
     */
    Tuan findBy(String field,Object value);
    
    /**
     * 根据给定的字段和属性值，获得符合条件的所有结果
     * @param field Tuan 中的某个字段
     * @param value 字段对应的值
     * @return 返回符合条件的所有结果
     * @author huguangling 胡广玲
     * 
     * 
     */
    List<Tuan> findAllBy(String field,Object value);
    
    /**
     * 根据给定的字段和属性值，获得符合条件的所有结果
     * @param field Tuan 中的某个字段
     * @param value 字段对应的值
     * @return 返回符合条件的所有结果
     * @author huguangling 胡广玲
     * 
     * 
     */
	Tuan findById(Long id);
	/**
	 * 根据团商品和
	 * @param groupId
	 * @param status
	 * @param pageable
	 * @return
	 */
	Page<Tuan> findAllByGroupIdAndStatus(Long groupId, String status, Pageable pageable);
	/**
	 * 根据状态获取所有超时订单
	 * @param status 订单状态
	 * @param pageable 分页
	 * @return
	 */
	Page<Tuan> findAllOvertime(String status, Pageable pageable);    

}