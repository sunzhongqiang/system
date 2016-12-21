package com.mmk.business.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mmk.business.condition.AdPositionCondition;
import com.mmk.business.model.AdPosition;
import com.mmk.gene.service.BaseService;

/**
* AdPositionService: 广告位置 业务服务层接口
*2016-11-03 11:37:58
*@author huguangling 胡广玲
*@version 1.0
*/
public interface AdPositionService extends BaseService<AdPosition, Long> {
    /**
     * 生成的列表分页查询方法
     * @param adPositionCondition  查询条件
     * @param pageable 分页参数
     * @return 分页返回查询的结果
     * @author huguangling 胡广玲
     * 
     */
    Page<AdPosition> list(AdPositionCondition adPositionCondition, Pageable pageable);
    
    /**
     * 不分页查询相关信息，根据传入的model类对象取得查询结果集List
     * @param  adPosition 查询类
     * @return 查询的结果集
     * @author huguangling 胡广玲
     * 
     */
    public List<AdPosition> list(AdPositionCondition adPosition);

    /**
     * 是否存在该
     * @param positionId 广告位ID
     * @return 如果存在的话返回true ,没有的返回false
     * @author huguangling 胡广玲
     * 
     */
    boolean existsPositionId(Long positionId);
    /**
     * 根据给定的字段返回符合的对象
     * @param positionId 广告位ID
     * @return 符合条件的唯一对象
     * @author huguangling 胡广玲
     * 
     */
    AdPosition findByPositionId(Long positionId);
    /**
     * 根据字段获取所有符合的记录
     * @param positionId 广告位ID
     * @return 符合条件的所有对象
     * @author huguangling 胡广玲
     * 
     */
    List<AdPosition> findAllByPositionId(Long positionId);
    /**
     * 根据字段获取所有符合的记录
     * @param positionId 广告位ID
     * @param pageable 分页参数
     * @return 符合条件的所有对象
     * @author huguangling 胡广玲
     * 
     */
    Page<AdPosition> findAllByPositionId(Long positionId, Pageable pageable);
    /**
     * 根据给定的字段和属性值，获得符合条件的第一个结果
     * @param field AdPosition 中的某个字段
     * @param value 字段的值
     * @return AdPosition 返回符合条件的结果，如果没有返回null
     * @author huguangling 胡广玲
     * 
     * 
     */
    AdPosition findBy(String field,Object value);
    
    /**
     * 根据给定的字段和属性值，获得符合条件的所有结果
     * @param field AdPosition中的某个字段
     * @param value 字段的值
     * @return 返回符合条件的所有结果
     * @author huguangling 胡广玲
     * 
     * 
     */
    List<AdPosition> findAllBy(String field,Object value);

    /**
     * 生成的列表查询方法
     * @param adPositionCondition  查询条件
     * @return 分页返回查询的结果
     */
	List<AdPosition> listAll();
}