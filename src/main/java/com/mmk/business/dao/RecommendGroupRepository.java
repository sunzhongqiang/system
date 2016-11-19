/*
 *  RecommendGroupRepository 创建于 2016-11-18 15:33:45 版权归作者和作者当前组织所有
 */
package com.mmk.business.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mmk.business.model.RecommendGroup;

/**
* RecommendGroupRepository: 拼团推荐管理 数据资源层
* 2016-11-18 15:33:45
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