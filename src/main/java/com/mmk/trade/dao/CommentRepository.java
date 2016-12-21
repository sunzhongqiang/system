/*
 *  CommentRepository 创建于 2016-11-11 13:31:11 版权归作者和作者当前组织所有
 */
package com.mmk.trade.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.mmk.trade.model.Comment;

/**
* CommentRepository: 评价管理 数据资源层
* 2016-11-11 13:31:11
* @author huguangling 胡广玲
* @version 1.0
*/
public interface CommentRepository extends JpaRepository<Comment, Long>{

    /**
     *  根据给定的字段：id 评价ID返回符合条件的第一个对象
     * @param id 评价ID
     * @return 符合条件的唯一对象
     * @author huguangling 胡广玲
     * 
     */
    Comment findFirstById(Long id);
    /**
     *  根据给定的字段：userName 用户名获取所有符合的记录
     * @param userName 用户名
     * @return 符合条件的所有对象
     * @author huguangling 胡广玲
     * 
     */
    List<Comment> findAllByUserName(String userName);
    /**
     *  根据给定的字段：userName 用户名所有符合的记录
     * @param userName 用户名
     * @param pageable 分页参数
     * @return 符合条件的所有对象
     * @author huguangling 胡广玲
     * 
     */
    Page<Comment> findAllByUserName(String userName,Pageable pageable);

}