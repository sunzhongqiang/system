/*
 *  RegionRepository 创建于 2016-11-14 13:31:38 版权归作者和作者当前组织所有
 */
package com.mmk.system.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mmk.system.model.Region;

/**
* RegionRepository: 区域管理 数据资源层
* 2016-11-14 13:31:38
* @author huguangling 胡广玲
* @version 1.0
*/
public interface RegionRepository extends JpaRepository<Region, Long>{

    /**
     *  根据给定的字段：parentId 所属区域id返回符合条件的第一个对象
     * @param parentId 所属区域id
     * @return 符合条件的唯一对象
     * @author huguangling 胡广玲
     * 
     */
    Region findFirstByParentId(Long parentId);
    /**
     *  根据给定的字段：regionName 区域名称返回符合条件的第一个对象
     * @param regionName 区域名称
     * @return 符合条件的唯一对象
     * @author huguangling 胡广玲
     * 
     */
    Region findFirstByRegionName(String regionName);
    /**
     * 根据父类获取省市区
     * @param parentId 父类
     * @return 地区列表
     */
	List<Region> findAllByParentId(Long parentId);

}