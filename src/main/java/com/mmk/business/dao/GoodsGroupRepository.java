/*
 *  GoodsGroupRepository 创建于 2016-11-17 11:42:27 版权归作者和作者当前组织所有
 */
package com.mmk.business.dao;

import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import com.mmk.business.model.GoodsGroup;

/**
* GoodsGroupRepository: 商品拼团管理 数据资源层
* 2016-11-17 11:42:27
* @author 孙中强 sunzhongqiang
* @version 1.0
*/
public interface GoodsGroupRepository extends JpaRepository<GoodsGroup, Long>{

    /**
     *  根据给定的字段：id 主键返回符合条件的第一个对象
     * @param id 主键
     * @return 符合条件的唯一对象
     * @author 孙中强 sunzhongqiang
     * 
     */
    GoodsGroup findFirstById(Long id);
    /**
     *  根据给定的字段：goodsId 商品主键获取所有符合的记录
     * @param goodsId 商品主键
     * @return 符合条件的所有对象
     * @author 孙中强 sunzhongqiang
     * 
     */
    List<GoodsGroup> findAllByGoodsId(Long goodsId);
    /**
     *  根据给定的字段：goodsId 商品主键所有符合的记录
     * @param goodsId 商品主键
     * @param pageable 分页参数
     * @return 符合条件的所有对象
     * @author 孙中强 sunzhongqiang
     * 
     */
    Page<GoodsGroup> findAllByGoodsId(Long goodsId,Pageable pageable);

}