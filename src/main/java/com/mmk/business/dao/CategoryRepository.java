/*
 *  CategoryRepository 创建于 2016-11-29 13:54:25 版权归作者和作者当前组织所有
 */
package com.mmk.business.dao;

import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import com.mmk.business.model.Category;

/**
* CategoryRepository: 商品分类 数据资源层
* 2016-11-29 13:54:25
* @author 孙中强 sunzhongqiang
* @version 1.0
*/
public interface CategoryRepository extends JpaRepository<Category, Long>{

    /**
     *  根据给定的字段：parentId 父分类的id获取所有符合的记录
     * @param parentId 父分类的id
     * @return 符合条件的所有对象
     * @author 孙中强 sunzhongqiang
     * 
     */
    List<Category> findAllByParentId(Long parentId);
    /**
     *  根据给定的字段：parentId 父分类的id所有符合的记录
     * @param parentId 父分类的id
     * @param pageable 分页参数
     * @return 符合条件的所有对象
     * @author 孙中强 sunzhongqiang
     * 
     */
    Page<Category> findAllByParentId(Long parentId,Pageable pageable);
    /**
     *  根据给定的字段：name 分类名称返回符合条件的第一个对象
     * @param name 分类名称
     * @return 符合条件的唯一对象
     * @author 孙中强 sunzhongqiang
     * 
     */
    Category findFirstByName(String name);
    /**
     *  根据给定的字段：path 分类路径获取所有符合的记录
     * @param path 分类路径
     * @return 符合条件的所有对象
     * @author 孙中强 sunzhongqiang
     * 
     */
    List<Category> findAllByPath(String path);
    /**
     *  根据给定的字段：path 分类路径所有符合的记录
     * @param path 分类路径
     * @param pageable 分页参数
     * @return 符合条件的所有对象
     * @author 孙中强 sunzhongqiang
     * 
     */
    Page<Category> findAllByPath(String path,Pageable pageable);

}