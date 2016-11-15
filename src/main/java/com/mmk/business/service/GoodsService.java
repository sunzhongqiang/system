package com.mmk.business.service;

import java.util.List;
import com.mmk.gene.service.BaseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.mmk.business.model.Goods;
import com.mmk.business.condition.GoodsCondition;

/**
* GoodsService: 商品活动 业务服务层接口
*2016-10-31 10:48:36
*@author huguangling 胡广玲
*@version 1.0
*/
public interface GoodsService extends BaseService<Goods, Long> {
    /**
     * 生成的列表分页查询方法
     * @param goodsCondition  查询条件
     * @param pageable 分页参数
     * @return 分页返回查询的结果
     * @author huguangling 胡广玲
     * 
     */
    Page<Goods> list(GoodsCondition goodsCondition, Pageable pageable);
    
    /**
     * 不分页查询相关信息，根据传入的model类对象取得查询结果集List
     * @param  goods 查询类
     * @return 查询的结果集
     * @author huguangling 胡广玲
     * 
     */
    public List<Goods> list(GoodsCondition goods);

    /**
     * 是否存在该
     * @param id 商品ID
     * @return 如果存在的话返回true ,没有的返回false
     * @author huguangling 胡广玲
     * 
     */
    boolean existsId(Long id);
    /**
     * 根据给定的字段返回符合的对象
     * @param id 商品ID
     * @return 符合条件的唯一对象
     * @author huguangling 胡广玲
     * 
     */
    Goods findById(Long id);
    /**
     * 根据字段获取所有符合的记录
     * @param id 商品ID
     * @return 符合条件的所有对象
     * @author huguangling 胡广玲
     * 
     */
    List<Goods> findAllById(Long id);
    /**
     * 根据字段获取所有符合的记录
     * @param id 商品ID
     * @param pageable 分页参数
     * @return 符合条件的所有对象
     * @author huguangling 胡广玲
     * 
     */
    Page<Goods> findAllById(Long id, Pageable pageable);
    /**
     * 根据给定的字段和属性值，获得符合条件的第一个结果
     * @param field Goods 中的某个字段
     * @param value 字段的值
     * @return Goods 返回符合条件的结果，如果没有返回null
     * @author huguangling 胡广玲
     * 
     * 
     */
    Goods findBy(String field,Object value);
    
    /**
     * 根据给定的字段和属性值，获得符合条件的所有结果
     * @param field Goods中的某个字段
     * @param value 字段的值
     * @return 返回符合条件的所有结果
     * @author huguangling 胡广玲
     * 
     * 
     */
    List<Goods> findAllBy(String field,Object value);
	
    /**
     * 根据给定的字段和属性值，获得符合条件的所有结果
     * @param field RecommendGoods中的某个字段
     * @return 返回符合条件的所有结果
     * @author huguangling 胡广玲
     * 
     * 
     */
    List<List<Object>> goodsGrid(Long positionId);
<<<<<<< HEAD

	/**
	 * 获取即将开团的商品
	 * @return
	 */
	Page<Goods> findBeginStart(Pageable pageable);
=======
>>>>>>> branch 'master' of https://github.com/sunzhongqiang/system.git
}