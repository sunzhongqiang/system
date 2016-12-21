package com.mmk.trade.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mmk.gene.service.BaseService;
import com.mmk.trade.condition.CommentCondition;
import com.mmk.trade.model.Comment;

/**
* CommentService: 评价管理 业务服务层接口
*2016-11-11 13:31:11
*@author huguangling 胡广玲
*@version 1.0
*/
public interface CommentService extends BaseService<Comment, Long> {
    /**
     * 生成的列表分页查询方法
     * @param commentCondition  查询条件
     * @param pageable 分页参数
     * @return 分页返回查询的结果
     * @author huguangling 胡广玲
     * 
     */
    Page<Comment> list(CommentCondition commentCondition, Pageable pageable);
    
    /**
     * 不分页查询相关信息，根据传入的model类对象取得查询结果集List
     * @param  comment 查询类
     * @return 查询的结果集
     * @author huguangling 胡广玲
     * 
     */
    public List<Comment> list(CommentCondition comment);

    /**
     * 根据给定的字段返回符合的对象
     * @param id 评价ID
     * @return 符合条件的唯一对象
     * @author huguangling 胡广玲
     * 
     */
    Comment findById(Long id);
    /**
     * 根据字段获取所有符合的记录
     * @param userName 用户名
     * @return 符合条件的所有对象
     * @author huguangling 胡广玲
     * 
     */
    List<Comment> findAllByUserName(String userName);
    /**
     * 根据字段获取所有符合的记录
     * @param userName 用户名
     * @param pageable 分页参数
     * @return 符合条件的所有对象
     * @author huguangling 胡广玲
     * 
     */
    Page<Comment> findAllByUserName(String userName, Pageable pageable);
    /**
     * 根据给定的字段和属性值，获得符合条件的第一个结果
     * @param field Comment 中的某个字段
     * @param value 字段的值
     * @return Comment 返回符合条件的结果，如果没有返回null
     * @author huguangling 胡广玲
     * 
     * 
     */
    Comment findBy(String field,Object value);
    
    /**
     * 根据给定的字段和属性值，获得符合条件的所有结果
     * @param field Comment中的某个字段
     * @param value 字段的值
     * @return 返回符合条件的所有结果
     * @author huguangling 胡广玲
     * 
     * 
     */
    List<Comment> findAllBy(String field,Object value);

    /**
     * 根据给定的字段和属性值，获得符合条件的所有结果
     * @param field Comment中的某个字段
     * @param value 字段的值
     * @return 返回符合条件的所有结果
     * @author huguangling 胡广玲
     * 
     * 
     */
	List<Comment> findCommentByGoodsId(Long goodsId);
}