package com.mmk.system.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mmk.gene.service.BaseService;
import com.mmk.system.condition.RegionCondition;
import com.mmk.system.model.Region;

/**
* RegionService: 区域管理 业务服务层接口
*2016-11-14 13:31:38
*@author huguangling 胡广玲
*@version 1.0
*/
public interface RegionService extends BaseService<Region, Long> {
    /**
     * 生成的列表分页查询方法
     * @param regionCondition  查询条件
     * @param pageable 分页参数
     * @return 分页返回查询的结果
     * @author huguangling 胡广玲
     * 
     */
    Page<Region> list(RegionCondition regionCondition, Pageable pageable);
    
    /**
     * 不分页查询相关信息，根据传入的model类对象取得查询结果集List
     * @param  region 查询类
     * @return 查询的结果集
     * @author huguangling 胡广玲
     * 
     */
    public List<Region> list(RegionCondition region);

    /**
     * 根据给定的字段返回符合的对象
     * @param parentId 所属区域id
     * @return 符合条件的唯一对象
     * @author huguangling 胡广玲
     * 
     */
    Region findByParentId(Long parentId);
    /**
     * 根据给定的字段返回符合的对象
     * @param regionName 区域名称
     * @return 符合条件的唯一对象
     * @author huguangling 胡广玲
     * 
     */
    Region findByRegionName(String regionName);
    /**
     * 根据给定的字段和属性值，获得符合条件的第一个结果
     * @param field Region 中的某个字段
     * @param value 字段的值
     * @return Region 返回符合条件的结果，如果没有返回null
     * @author huguangling 胡广玲
     * 
     * 
     */
    Region findBy(String field,Object value);
    
    /**
     * 根据给定的字段和属性值，获得符合条件的所有结果
     * @param field Region中的某个字段
     * @param value 字段的值
     * @return 返回符合条件的所有结果
     * @author huguangling 胡广玲
     * 
     * 
     */
    List<Region> findAllBy(String field,Object value);

    /**
     * 根据父类获取对应的子省市区
     * @param parentId
     * @return
     */
	List<Region> findAllByParentId(Long parentId);

	/**
	 * 根据parentId加载所有地区
	 * @param parentId 父Id
	 * @return 地区列表
	 * 
	 */
	List<Region> loadByParentId(Long parentId);
}