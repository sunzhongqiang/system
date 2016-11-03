/*
 *  AdPositionRepository 创建于 2016-11-03 11:37:58 版权归作者和作者当前组织所有
 */
package com.mmk.business.dao;

import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import com.mmk.business.model.AdPosition;

/**
* AdPositionRepository: 广告位置 数据资源层
* 2016-11-03 11:37:58
* @author huguangling 胡广玲
* @version 1.0
*/
public interface AdPositionRepository extends JpaRepository<AdPosition, Long>{

    /**
     *  根据给定的字段：positionId 广告位ID返回符合条件的第一个对象
     * @param positionId 广告位ID
     * @return 符合条件的唯一对象
     * @author huguangling 胡广玲
     * 
     */
    AdPosition findFirstByPositionId(Long positionId);
    /**
     *  根据给定的字段：positionId 广告位ID获取所有符合的记录
     * @param positionId 广告位ID
     * @return 符合条件的所有对象
     * @author huguangling 胡广玲
     * 
     */
    List<AdPosition> findAllByPositionId(Long positionId);
    /**
     *  根据给定的字段：positionId 广告位ID所有符合的记录
     * @param positionId 广告位ID
     * @param pageable 分页参数
     * @return 符合条件的所有对象
     * @author huguangling 胡广玲
     * 
     */
    Page<AdPosition> findAllByPositionId(Long positionId,Pageable pageable);

}