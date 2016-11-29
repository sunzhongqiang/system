/*
 * 
 *  CategoryDao 创建于 2016-11-29 13:54:25 版权归作者和作者当前组织所有
 */
package com.mmk.business.dao;

import java.util.List;
import java.util.Map;
import com.mmk.gene.dao.SpringDataQueryDao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.mmk.business.condition.CategoryCondition;
import com.mmk.business.model.Category;
/**
* CategoryDao:商品分类 数据持久层接口
* @author 孙中强 sunzhongqiang
* @version 1.0
*/
public interface CategoryDao extends SpringDataQueryDao<Category>{
    
    /**
     * 分页查询相关信息，根据传入的bean类对象和分页对象page取得查询结果集List
     * @param category 查询类
     * @param pageable 传入的分页对象
     * @return 符合条件的查询结果集
     * @author 孙中强 sunzhongqiang
     * 
     * 
     */
    Page<Category> list(CategoryCondition category,Pageable pageable);
    /**
     * 不分页查询相关信息，根据传入的model类对象取得查询结果集List
     * @param category 查询类
     * @return 符合条件的查询结果集
     * @author 孙中强 sunzhongqiang
     * 
     */
    List<Category> list(CategoryCondition category);
    /**
     * 使用sql查询，并以map和分页的形式进行返回数据结果
     * @param category Category类
     * @param pageable 传入的分页对象
     * @return 符合条件的查询结果集
     * @author 孙中强 sunzhongqiang
     * 
     * 
     */
    Page<Map<String,Object>> listBySql(CategoryCondition category,Pageable pageable);
    /**
     * 根据给定的字段和属性值，获得符合条件的第一个结果
     * @param field Category 中的某个字段
     * @param value 字段对应的值
     * @return 返回符合条件的结果，如果没有返回null
     * @author 孙中强 sunzhongqiang
     * 
     * 
     */
    Category findBy(String field,Object value);
    
    /**
     * 根据给定的字段和属性值，获得符合条件的所有结果
     * @param field Category 中的某个字段
     * @param value 字段对应的值
     * @return 返回符合条件的所有结果
     * @author 孙中强 sunzhongqiang
     * 
     * 
     */
    List<Category> findAllBy(String field,Object value);
    /**
     * 根据查询条件获取分类数据
     * @param categoryCondition 查询条件
     * @return 符合条件的数据
     */
	List<Category> findAllBy(CategoryCondition categoryCondition);
	/**
	 * 根据路径获取所有子节点
	 * @param path 路径
	 * @return 路径下的所有子节点
	 */
	List<Category> findChildrenByPath(String path);
    
    

}