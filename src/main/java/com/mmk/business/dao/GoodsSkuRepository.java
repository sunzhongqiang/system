/*
 *  GoodsSkuRepository 创建于 2016-11-21 14:08:15 版权归作者和作者当前组织所有
 */
package com.mmk.business.dao;

import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import com.mmk.business.model.GoodsSku;

/**
* GoodsSkuRepository: 商品SKU 数据资源层
* 2016-11-21 14:08:15
* @author sunzhongqiang 孙中强
* @version 1.0
*/
public interface GoodsSkuRepository extends JpaRepository<GoodsSku, Long>{

    /**
     *  根据给定的字段：goodId 商品id返回符合条件的第一个对象
     * @param goodId 商品id
     * @return 符合条件的唯一对象
     * @author sunzhongqiang 孙中强
     * 
     */
    GoodsSku findFirstByGoodId(Long goodId);
    /**
     *  根据给定的字段：goodId 商品id获取所有符合的记录
     * @param goodId 商品id
     * @return 符合条件的所有对象
     * @author sunzhongqiang 孙中强
     * 
     */
    List<GoodsSku> findAllByGoodId(Long goodId);
    /**
     *  根据给定的字段：goodId 商品id所有符合的记录
     * @param goodId 商品id
     * @param pageable 分页参数
     * @return 符合条件的所有对象
     * @author sunzhongqiang 孙中强
     * 
     */
    Page<GoodsSku> findAllByGoodId(Long goodId,Pageable pageable);

}