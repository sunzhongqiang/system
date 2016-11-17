package com.mmk.business.service;

import java.util.List;
import com.mmk.gene.service.BaseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.mmk.business.model.GoodsGroup;
import com.mmk.business.condition.GoodsGroupCondition;

/**
* GoodsGroupService: 商品拼团管理 业务服务层接口
*2016-11-17 11:30:52
*@author 孙中强 sunzhongqiang
*@version 1.0
*/
public interface GoodsGroupService extends BaseService<GoodsGroup, Long> {
    /**
     * 生成的列表分页查询方法
     * @param goodsGroupCondition  查询条件
     * @param pageable 分页参数
     * @return 分页返回查询的结果
     * @author 孙中强 sunzhongqiang
     * 
     */
    Page<GoodsGroup> list(GoodsGroupCondition goodsGroupCondition, Pageable pageable);
    
    /**
     * 不分页查询相关信息，根据传入的model类对象取得查询结果集List
     * @param  goodsGroup 查询类
     * @return 查询的结果集
     * @author 孙中强 sunzhongqiang
     * 
     */
    public List<GoodsGroup> list(GoodsGroupCondition goodsGroup);

    /**
     * 根据给定的字段返回符合的对象
     * @param id 主键
     * @return 符合条件的唯一对象
     * @author 孙中强 sunzhongqiang
     * 
     */
    GoodsGroup findById(Long id);
    /**
     * 根据字段获取所有符合的记录
     * @param goodsId 商品主键
     * @return 符合条件的所有对象
     * @author 孙中强 sunzhongqiang
     * 
     */
    List<GoodsGroup> findAllByGoodsId(Long goodsId);
    /**
     * 根据字段获取所有符合的记录
     * @param goodsId 商品主键
     * @param pageable 分页参数
     * @return 符合条件的所有对象
     * @author 孙中强 sunzhongqiang
     * 
     */
    Page<GoodsGroup> findAllByGoodsId(Long goodsId, Pageable pageable);
    /**
     * 根据给定的字段和属性值，获得符合条件的第一个结果
     * @param field GoodsGroup 中的某个字段
     * @param value 字段的值
     * @return GoodsGroup 返回符合条件的结果，如果没有返回null
     * @author 孙中强 sunzhongqiang
     * 
     * 
     */
    GoodsGroup findBy(String field,Object value);
    
    /**
     * 根据给定的字段和属性值，获得符合条件的所有结果
     * @param field GoodsGroup中的某个字段
     * @param value 字段的值
     * @return 返回符合条件的所有结果
     * @author 孙中强 sunzhongqiang
     * 
     * 
     */
    List<GoodsGroup> findAllBy(String field,Object value);
}