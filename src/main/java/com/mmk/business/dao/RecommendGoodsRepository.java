/*
 *  RecommendGoodsRepository 创建于 2016-11-14 13:55:42 版权归作者和作者当前组织所有
 */
package com.mmk.business.dao;

import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import com.mmk.business.model.RecommendGoods;

/**
* RecommendGoodsRepository: 商品 位置 关系表 数据资源层
* 2016-11-14 13:55:42
* @author huguangling 胡广玲
* @version 1.0
*/
public interface RecommendGoodsRepository extends JpaRepository<RecommendGoods, Long>{

    /**
     *  根据给定的字段：id 主键返回符合条件的第一个对象
     * @param id 主键
     * @return 符合条件的唯一对象
     * @author huguangling 胡广玲
     * 
     */
    RecommendGoods findFirstById(Long id);

}