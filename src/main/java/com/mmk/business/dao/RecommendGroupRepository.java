/*
 *  RecommendGroupRepository 创建于 2016-11-18 15:08:15 版权归作者和作者当前组织所有
 */
package com.mmk.business.dao;

import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import com.mmk.business.model.RecommendGroup;

/**
* RecommendGroupRepository: 拼团管理 数据资源层
* 2016-11-18 15:08:15
* @author huguangling 胡广玲
* @version 1.0
*/
public interface RecommendGroupRepository extends JpaRepository<RecommendGroup, Long>{

    /**
     *  根据给定的字段：id 主键返回符合条件的第一个对象
     * @param id 主键
     * @return 符合条件的唯一对象
     * @author huguangling 胡广玲
     * 
     */
    RecommendGroup findFirstById(Long id);

}