package com.mmk.business.service;

import java.util.List;
import com.mmk.gene.service.BaseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.mmk.business.model.Favorite;
import com.mmk.business.condition.FavoriteCondition;

/**
* FavoriteService: 团收藏 业务服务层接口
*2016-11-30 09:24:22
*@author huguangling 胡广玲
*@version 1.0
*/
public interface FavoriteService extends BaseService<Favorite, Long> {
    /**
     * 生成的列表分页查询方法
     * @param favoriteCondition  查询条件
     * @param pageable 分页参数
     * @return 分页返回查询的结果
     * @author huguangling 胡广玲
     * 
     */
    Page<Favorite> list(FavoriteCondition favoriteCondition, Pageable pageable);
    
    /**
     * 不分页查询相关信息，根据传入的model类对象取得查询结果集List
     * @param  favorite 查询类
     * @return 查询的结果集
     * @author huguangling 胡广玲
     * 
     */
    public List<Favorite> list(FavoriteCondition favorite);

    /**
     * 根据给定的字段返回符合的对象
     * @param id 收藏主键
     * @return 符合条件的唯一对象
     * @author huguangling 胡广玲
     * 
     */
    Favorite findById(Long id);
    /**
     * 根据给定的字段返回符合的对象
     * @param groupId 团id
     * @return 符合条件的唯一对象
     * @author huguangling 胡广玲
     * 
     */
    Favorite findByGroupId(Long groupId);
    /**
     * 根据给定的字段返回符合的对象
     * @param goodsId 商品主键
     * @return 符合条件的唯一对象
     * @author huguangling 胡广玲
     * 
     */
    Favorite findByGoodsId(Long goodsId);
    /**
     * 根据给定的字段返回符合的对象
     * @param userId 用户ID
     * @return 符合条件的唯一对象
     * @author huguangling 胡广玲
     * 
     */
    Favorite findByUserId(Long userId);
    /**
     * 根据给定的字段返回符合的对象
     * @param openid openid
     * @return 符合条件的唯一对象
     * @author huguangling 胡广玲
     * 
     */
    Favorite findByOpenid(String openid);
    /**
     * 根据给定的字段和属性值，获得符合条件的第一个结果
     * @param field Favorite 中的某个字段
     * @param value 字段的值
     * @return Favorite 返回符合条件的结果，如果没有返回null
     * @author huguangling 胡广玲
     * 
     * 
     */
    Favorite findBy(String field,Object value);
    
    /**
     * 根据给定的字段和属性值，获得符合条件的所有结果
     * @param field Favorite中的某个字段
     * @param value 字段的值
     * @return 返回符合条件的所有结果
     * @author huguangling 胡广玲
     * 
     * 
     */
    List<Favorite> findAllBy(String field,Object value);
    
	/**
	 * 根据用户id获取用户的所有
	 * @param userId 用户主键
	 * @param pageable  分页
	 * @return 用户的分页的关注
	 */
	Page<Favorite> findAllByUserId(Long userId,Pageable pageable);
}