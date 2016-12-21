/*
 *  AttentionRepository 创建于 2016-11-30 09:25:29 版权归作者和作者当前组织所有
 */
package com.mmk.business.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mmk.business.model.Attention;

/**
* AttentionRepository: 商品或者团的关注 数据资源层
* 2016-11-30 09:25:29
* @author huguangling 胡广玲
* @version 1.0
*/
public interface AttentionRepository extends JpaRepository<Attention, Long>{

    /**
     *  根据给定的字段：id 主键返回符合条件的第一个对象
     * @param id 主键
     * @return 符合条件的唯一对象
     * @author huguangling 胡广玲
     * 
     */
    Attention findFirstById(Long id);
    /**
     *  根据给定的字段：groupId 团id返回符合条件的第一个对象
     * @param groupId 团id
     * @return 符合条件的唯一对象
     * @author huguangling 胡广玲
     * 
     */
    Attention findFirstByGroupId(Long groupId);
    /**
     *  根据给定的字段：goodsId 商品主键返回符合条件的第一个对象
     * @param goodsId 商品主键
     * @return 符合条件的唯一对象
     * @author huguangling 胡广玲
     * 
     */
    Attention findFirstByGoodsId(Long goodsId);
    /**
     *  根据给定的字段：userId 用户ID返回符合条件的第一个对象
     * @param userId 用户ID
     * @return 符合条件的唯一对象
     * @author huguangling 胡广玲
     * 
     */
    Attention findFirstByUserId(Long userId);
    /**
     *  根据给定的字段：openid openid返回符合条件的第一个对象
     * @param openid openid
     * @return 符合条件的唯一对象
     * @author huguangling 胡广玲
     * 
     */
    Attention findFirstByOpenid(String openid);

}