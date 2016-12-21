package com.mmk.business.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mmk.business.condition.AdCondition;
import com.mmk.business.model.Ad;
import com.mmk.gene.service.BaseService;

/**
* AdService: 广告 业务服务层接口
*2016-11-03 11:37:27
*@author huguangling 胡广玲
*@version 1.0
*/
public interface AdService extends BaseService<Ad, Long> {
    /**
     * 生成的列表分页查询方法
     * @param adCondition  查询条件
     * @param pageable 分页参数
     * @return 分页返回查询的结果
     * @author huguangling 胡广玲
     * 
     */
    Page<Ad> list(AdCondition adCondition, Pageable pageable);
    
    /**
     * 不分页查询相关信息，根据传入的model类对象取得查询结果集List
     * @param  ad 查询类
     * @return 查询的结果集
     * @author huguangling 胡广玲
     * 
     */
    public List<Ad> list(AdCondition ad);

    /**
     * 是否存在该
     * @param positionId 位置ID
     * @return 如果存在的话返回true ,没有的返回false
     * @author huguangling 胡广玲
     * 
     */
    boolean existsPositionId(Long positionId);
    /**
     * 根据给定的字段返回符合的对象
     * @param positionId 位置ID
     * @return 符合条件的唯一对象
     * @author huguangling 胡广玲
     * 
     */
    Ad findByPositionId(Long positionId);
    /**
     * 根据字段获取所有符合的记录
     * @param positionId 位置ID
     * @return 符合条件的所有对象
     * @author huguangling 胡广玲
     * 
     */
    List<Ad> findAllByPositionId(Long positionId);
    /**
     * 根据字段获取所有符合的记录
     * @param positionId 位置ID
     * @param pageable 分页参数
     * @return 符合条件的所有对象
     * @author huguangling 胡广玲
     * 
     */
    Page<Ad> findAllByPositionId(Long positionId, Pageable pageable);
    /**
     * 根据给定的字段和属性值，获得符合条件的第一个结果
     * @param field Ad 中的某个字段
     * @param value 字段的值
     * @return Ad 返回符合条件的结果，如果没有返回null
     * @author huguangling 胡广玲
     * 
     * 
     */
    Ad findBy(String field,Object value);
    
    /**
     * 根据给定的字段和属性值，获得符合条件的所有结果
     * @param field Ad中的某个字段
     * @param value 字段的值
     * @return 返回符合条件的所有结果
     * @author huguangling 胡广玲
     * 
     * 
     */
    List<Ad> findAllBy(String field,Object value);
    
    /**
     * 根据广告位置获取广告位下的所有广告
     * @param code
     * @return
     */
    List<Ad> findAllByPositionCode(String code);
}