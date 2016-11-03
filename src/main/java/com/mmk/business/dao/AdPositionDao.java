/*
 * 
 *  AdPositionDao 创建于 2016-11-03 11:37:58 版权归作者和作者当前组织所有
 */
package com.mmk.business.dao;

import java.util.List;
import java.util.Map;
import com.mmk.gene.dao.SpringDataQueryDao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.mmk.business.condition.AdPositionCondition;
import com.mmk.business.model.AdPosition;
/**
* AdPositionDao:广告位置 数据持久层接口
* @author huguangling 胡广玲
* @version 1.0
*/
public interface AdPositionDao extends SpringDataQueryDao<AdPosition>{
    
    /**
     * 分页查询相关信息，根据传入的bean类对象和分页对象page取得查询结果集List
     * @param adPosition 查询类
     * @param pageable 传入的分页对象
     * @return 符合条件的查询结果集
     * @author huguangling 胡广玲
     * 
     * 
     */
    Page<AdPosition> list(AdPositionCondition adPosition,Pageable pageable);
    /**
     * 不分页查询相关信息，根据传入的model类对象取得查询结果集List
     * @param adPosition 查询类
     * @return 符合条件的查询结果集
     * @author huguangling 胡广玲
     * 
     */
    List<AdPosition> list(AdPositionCondition adPosition);
    /**
     * 使用sql查询，并以map和分页的形式进行返回数据结果
     * @param adPosition AdPosition类
     * @param pageable 传入的分页对象
     * @return 符合条件的查询结果集
     * @author huguangling 胡广玲
     * 
     * 
     */
    Page<Map<String,Object>> listBySql(AdPositionCondition adPosition,Pageable pageable);
    /**
     * 根据给定的字段和属性值，获得符合条件的第一个结果
     * @param field AdPosition 中的某个字段
     * @param value 字段对应的值
     * @return 返回符合条件的结果，如果没有返回null
     * @author huguangling 胡广玲
     * 
     * 
     */
    AdPosition findBy(String field,Object value);
    
    /**
     * 根据给定的字段和属性值，获得符合条件的所有结果
     * @param field AdPosition 中的某个字段
     * @param value 字段对应的值
     * @return 返回符合条件的所有结果
     * @author huguangling 胡广玲
     * 
     * 
     */
    List<AdPosition> findAllBy(String field,Object value);
    
    /**
     * 取得查询结果集List
     * @return 查询的结果集
     * 
     */
	List<AdPosition> listAll();
    
    

}