package com.mmk.base.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.mmk.base.model.Region;



public interface RegionRepository extends JpaRepository<Region, Long> {
	
	List<Region> findByParentId(Long parentId);
	/**
	 * 获取地区列表
	 * @param type 类型
	 * @param display 是否显示
	 * @return
	 */
	List<Region> findByRegionTypeAndIsDisplay(Integer type,Boolean display);
	
	/**
     * @Description 根据给定的字段：regionId 主键返回符合条件的第一个对象
     * @param regionId 主键
     * @return 符合条件的唯一对象
     * @author code generator
     * @date 2016-05-23 14:56:50
     */
    Region findFirstByRegionId(Long regionId);
    /**
     * @Description 根据给定的字段：parentId 所属区域id获取所有符合的记录
     * @param parentId 所属区域id
     * @return 符合条件的所有对象
     * @author code generator
     * @date 2016-05-23 14:56:50
     */
    List<Region> findAllByParentId(Long parentId);
    /**
     * @Description 根据给定的字段：parentId 所属区域id所有符合的记录
     * @param parentId 所属区域id
     * @param Pageable pageable 分页参数
     * @return 符合条件的所有对象
     * @author code generator
     * @date 2016-05-23 14:56:50
     */
    Page<Region> findAllByParentId(Long parentId,Pageable pageable);
    /**
     * @Description 根据给定的字段：regionName 区域名称返回符合条件的第一个对象
     * @param regionName 区域名称
     * @return 符合条件的唯一对象
     * @author code generator
     * @date 2016-05-23 14:56:50
     */
    Region findFirstByRegionName(String regionName);
    /**
     * @Description 根据给定的字段：regionType 区域级别货类型获取所有符合的记录
     * @param regionType 区域级别货类型
     * @return 符合条件的所有对象
     * @author code generator
     * @date 2016-05-23 14:56:50
     */
    List<Region> findAllByRegionType(Long regionType);
    /**
     * @Description 根据给定的字段：regionType 区域级别货类型所有符合的记录
     * @param regionType 区域级别货类型
     * @param Pageable pageable 分页参数
     * @return 符合条件的所有对象
     * @author code generator
     * @date 2016-05-23 14:56:50
     */
    Page<Region> findAllByRegionType(Long regionType,Pageable pageable);
}
