package com.mmk.business.service;

import java.util.List;
import com.mmk.gene.service.BaseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.mmk.business.model.GoodsSku;
import com.mmk.business.condition.GoodsSkuCondition;

/**
* GoodsSkuService: 商品SKU 业务服务层接口
*2016-11-21 14:08:15
*@author sunzhongqiang 孙中强
*@version 1.0
*/
public interface GoodsSkuService extends BaseService<GoodsSku, Long> {
    /**
     * 生成的列表分页查询方法
     * @param goodsSkuCondition  查询条件
     * @param pageable 分页参数
     * @return 分页返回查询的结果
     * @author sunzhongqiang 孙中强
     * 
     */
    Page<GoodsSku> list(GoodsSkuCondition goodsSkuCondition, Pageable pageable);
    
    /**
     * 不分页查询相关信息，根据传入的model类对象取得查询结果集List
     * @param  goodsSku 查询类
     * @return 查询的结果集
     * @author sunzhongqiang 孙中强
     * 
     */
    public List<GoodsSku> list(GoodsSkuCondition goodsSku);

    /**
     * 是否存在该
     * @param goodId 商品id
     * @return 如果存在的话返回true ,没有的返回false
     * @author sunzhongqiang 孙中强
     * 
     */
    boolean existsGoodId(Long goodId);
    /**
     * 根据给定的字段返回符合的对象
     * @param goodId 商品id
     * @return 符合条件的唯一对象
     * @author sunzhongqiang 孙中强
     * 
     */
    GoodsSku findByGoodId(Long goodId);
    /**
     * 根据字段获取所有符合的记录
     * @param goodId 商品id
     * @return 符合条件的所有对象
     * @author sunzhongqiang 孙中强
     * 
     */
    List<GoodsSku> findAllByGoodId(Long goodId);
    /**
     * 根据字段获取所有符合的记录
     * @param goodId 商品id
     * @param pageable 分页参数
     * @return 符合条件的所有对象
     * @author sunzhongqiang 孙中强
     * 
     */
    Page<GoodsSku> findAllByGoodId(Long goodId, Pageable pageable);
    /**
     * 根据给定的字段和属性值，获得符合条件的第一个结果
     * @param field GoodsSku 中的某个字段
     * @param value 字段的值
     * @return GoodsSku 返回符合条件的结果，如果没有返回null
     * @author sunzhongqiang 孙中强
     * 
     * 
     */
    GoodsSku findBy(String field,Object value);
    
    /**
     * 根据给定的字段和属性值，获得符合条件的所有结果
     * @param field GoodsSku中的某个字段
     * @param value 字段的值
     * @return 返回符合条件的所有结果
     * @author sunzhongqiang 孙中强
     * 
     * 
     */
    List<GoodsSku> findAllBy(String field,Object value);
}