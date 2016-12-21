/*
 *  AdRepository 创建于 2016-11-03 11:37:27 版权归作者和作者当前组织所有
 */
package com.mmk.business.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.mmk.business.model.Ad;

/**
* AdRepository: 广告 数据资源层
* 2016-11-03 11:37:27
* @author huguangling 胡广玲
* @version 1.0
*/
public interface AdRepository extends JpaRepository<Ad, Long>{

    /**
     *  根据给定的字段：positionId 位置ID返回符合条件的第一个对象
     * @param positionId 位置ID
     * @return 符合条件的唯一对象
     * @author huguangling 胡广玲
     * 
     */
    Ad findFirstByPositionId(Long positionId);
    /**
     *  根据给定的字段：positionId 位置ID获取所有符合的记录
     * @param positionId 位置ID
     * @return 符合条件的所有对象
     * @author huguangling 胡广玲
     * 
     */
    List<Ad> findAllByPositionId(Long positionId);
    /**
     *  根据给定的字段：positionId 位置ID所有符合的记录
     * @param positionId 位置ID
     * @param pageable 分页参数
     * @return 符合条件的所有对象
     * @author huguangling 胡广玲
     * 
     */
    Page<Ad> findAllByPositionId(Long positionId,Pageable pageable);

}