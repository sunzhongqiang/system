package com.mmk.base.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mmk.base.condition.RegionCondition;
import com.mmk.base.model.Region;
import com.mmk.gene.service.BaseService;

public interface RegionService extends BaseService<Region, Long>{
	/**
	 * 根据id获取地区
	 * @param id
	 * @return
	 */
	Region findOne(Long id);
	
	List<Region> findAll();
	
	/**
     * 生成的列表分页查询方法
     * @param regionCondition  查询条件
     * @param pageable 分页参数
     * @return 分页返回查询的结果
     * @author code generator
     * @date 2016-05-23 14:56:51
     */
    Page<Region> list(RegionCondition regionCondition, Pageable pageable);
    
    /**
     * 不分页查询相关信息，根据传入的model类对象取得查询结果集List
     * @param bean Region类
     * @return List<Region> 查询的结果集
     * @author code generator
     * @date 2016-05-23 14:56:51
     */
    public List<Region> list(RegionCondition region);

    /**
     * 根据给定的字段返回符合的对象
     * @param regionId 主键
     * @return 符合条件的唯一对象
     * @author code generator
     * @date 2016-05-23 14:56:51
     */
    Region findByRegionId(Long regionId);
    /**
     * 根据字段获取所有符合的记录
     * @param parentId 所属区域id
     * @return 符合条件的所有对象
     * @author code generator
     * @date 2016-05-23 14:56:51
     */
    List<Region> findAllByParentId(Long parentId);
    /**
     * 根据字段获取所有符合的记录
     * @param parentId 所属区域id
     * @param Pageable pageable 分页参数
     * @return 符合条件的所有对象
     * @author code generator
     * @date 2016-05-23 14:56:51
     */
    Page<Region> findAllByParentId(Long parentId, Pageable pageable);
    /**
     * 是否存在该
     * @param regionName 区域名称
     * @return 如果存在的话返回true ,没有的返回false
     * @author code generator
     * @date 2016-05-23 14:56:51
     */
    boolean existsRegionName(String regionName);
    /**
     * 根据字段获取所有符合的记录
     * @param regionType 区域级别货类型
     * @return 符合条件的所有对象
     * @author code generator
     * @date 2016-05-23 14:56:51
     */
    List<Region> findAllByRegionType(Long regionType);
    /**
     * 根据字段获取所有符合的记录
     * @param regionType 区域级别货类型
     * @param Pageable pageable 分页参数
     * @return 符合条件的所有对象
     * @author code generator
     * @date 2016-05-23 14:56:51
     */
    Page<Region> findAllByRegionType(Long regionType, Pageable pageable);

    /**
     * 根据给定的字段和属性值，获得符合条件的第一个结果
     * @param field Region 中的某个字段
     * @return Region 返回符合条件的结果，如果没有返回null
     * @author code generator
     * @date 2016-05-23 14:56:51
     * 
     */
    Region findBy(String field,Object value);
    
    /**
     * 根据给定的字段和属性值，获得符合条件的所有结果
     * @param field Region 中的某个字段
     * @return List<Region> 返回符合条件的所有结果
     * @author code generator
     * @date 2016-05-23 14:56:51
     * 
     */
    List<Region> findAllBy(String field,Object value);
}
