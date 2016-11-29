package com.mmk.business.service;

import java.util.List;
import com.mmk.gene.service.BaseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.mmk.business.model.Category;
import com.mmk.common.model.Tree;
import com.mmk.business.condition.CategoryCondition;

/**
* CategoryService: 商品分类 业务服务层接口
*2016-11-29 13:54:25
*@author 孙中强 sunzhongqiang
*@version 1.0
*/
public interface CategoryService extends BaseService<Category, Long> {
    /**
     * 生成的列表分页查询方法
     * @param categoryCondition  查询条件
     * @param pageable 分页参数
     * @return 分页返回查询的结果
     * @author 孙中强 sunzhongqiang
     * 
     */
    Page<Category> list(CategoryCondition categoryCondition, Pageable pageable);
    
    /**
     * 不分页查询相关信息，根据传入的model类对象取得查询结果集List
     * @param  category 查询类
     * @return 查询的结果集
     * @author 孙中强 sunzhongqiang
     * 
     */
    public List<Category> list(CategoryCondition category);

    /**
     * 根据字段获取所有符合的记录
     * @param parentId 父分类的id
     * @return 符合条件的所有对象
     * @author 孙中强 sunzhongqiang
     * 
     */
    List<Category> findAllByParentId(Long parentId);
    /**
     * 根据字段获取所有符合的记录
     * @param parentId 父分类的id
     * @param pageable 分页参数
     * @return 符合条件的所有对象
     * @author 孙中强 sunzhongqiang
     * 
     */
    Page<Category> findAllByParentId(Long parentId, Pageable pageable);
    /**
     * 根据给定的字段返回符合的对象
     * @param name 分类名称
     * @return 符合条件的唯一对象
     * @author 孙中强 sunzhongqiang
     * 
     */
    Category findByName(String name);
    /**
     * 根据字段获取所有符合的记录
     * @param path 分类路径
     * @return 符合条件的所有对象
     * @author 孙中强 sunzhongqiang
     * 
     */
    List<Category> findAllByPath(String path);
    /**
     * 根据字段获取所有符合的记录
     * @param path 分类路径
     * @param pageable 分页参数
     * @return 符合条件的所有对象
     * @author 孙中强 sunzhongqiang
     * 
     */
    Page<Category> findAllByPath(String path, Pageable pageable);
    /**
     * 根据给定的字段和属性值，获得符合条件的第一个结果
     * @param field Category 中的某个字段
     * @param value 字段的值
     * @return Category 返回符合条件的结果，如果没有返回null
     * @author 孙中强 sunzhongqiang
     * 
     * 
     */
    Category findBy(String field,Object value);
    
    /**
     * 根据给定的字段和属性值，获得符合条件的所有结果
     * @param field Category中的某个字段
     * @param value 字段的值
     * @return 返回符合条件的所有结果
     * @author 孙中强 sunzhongqiang
     * 
     * 
     */
    List<Category> findAllBy(String field,Object value);

    /**
     * 根据查询条件获取treeGrid的数据
     * @param categoryCondition  查询条件
     * @return 分类列表
     */
	List<CategoryCondition> treeGrid(CategoryCondition categoryCondition);

	/**
     * 根据查询条件获取tree的数据
     * @param categoryCondition  查询条件
     * @return 分类列表树结构
     */
	List<Tree> tree(CategoryCondition categoryCondition);
	
	List<Category> findChildrenByPath(String path);
	
}