/*
 *  RecommendPositionRepository 创建于 2016-11-14 13:56:04 版权归作者和作者当前组织所有
 */
package com.mmk.business.dao;

import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import com.mmk.business.model.RecommendPosition;

/**
* RecommendPositionRepository: 位置表 数据资源层
* 2016-11-14 13:56:04
* @author huguangling 胡广玲
* @version 1.0
*/
public interface RecommendPositionRepository extends JpaRepository<RecommendPosition, Long>{

    /**
     *  根据给定的字段：id id返回符合条件的第一个对象
     * @param id id
     * @return 符合条件的唯一对象
     * @author huguangling 胡广玲
     * 
     */
    RecommendPosition findFirstById(Long id);

}