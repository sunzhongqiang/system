package com.mmk.base.dao;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mmk.base.condition.RegionCondition;
import com.mmk.base.model.Region;
import com.mmk.gene.dao.SpringDataQueryDao;


/**
*@Title: 地区dao层接口
*@Description: 
*@Copyright: Copyright (c) 2011
*@Company: echin
*@author codebuilder
*@version 1.0
*/
public interface RegionDao extends SpringDataQueryDao<Region>{
	
    /**
     * 根据地区类型查询地区信息
     * @param regionType 地区类型
     * @return List<Region> 查询的结果集
     * @create yiqin Fri Nov 13 10:48:05 GMT+08:00 2015
     */
    List<Region> listByRegionType(String regionType);
    
    /**
     * 根据地区类型一级省所属大区
     * @param regionType 地区类型
     * @return List<Map<String,Object>> 查询的结果集
     * @create yiqin Fri Nov 13 10:48:05 GMT+08:00 2015
     */
    List<Map<String,Object>> listBigRegionInfo(Integer regionType,Long shippingId);
    
    List<Map<String, Object>> isRegionAllSet(String regionName);
    
    /**
     * 分页查询相关信息，根据传入的bean类对象和分页对象page取得查询结果集List
     * @param model Region类
     * @param page 传入的分页对象
     * @return Page<Region> 查询的结果集
     * @author code generator
     * @date 2016-05-23 14:56:51
     * 
     */
    Page<Region> list(RegionCondition region,Pageable pageable);
    /**
     * 不分页查询相关信息，根据传入的model类对象取得查询结果集List
     * @param bean Region类
     * @return List<Region> 查询的结果集
     * @author code generator
     * @date 2016-05-23 14:56:51
     */
    List<Region> list(RegionCondition region);
    /**
     * 使用sql查询，并以map和分页的形式进行返回数据结果
     * @param model Region类
     * @param page 传入的分页对象
     * @return Page<Region> 查询的结果集
     * @author code generator
     * @date 2016-05-23 14:56:51
     * 
     */
    Page< Map<String,Object>> listBySql(RegionCondition region,Pageable pageable);
    
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
    
    /**
     * 获取主键值
     * @return
     */
    Long findMaxRegionId();

    /**
     * 根据代理商id和代理商级别获取所有的区一级的区域列表
     * @param proxyId
     * @param proxyGrade
     * @return
     */
	List<Region> findAllRegionByProxyId(Long proxyId, String proxyGrade);
}
