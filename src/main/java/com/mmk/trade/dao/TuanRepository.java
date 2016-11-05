/*
 *  TuanRepository 创建于 2016-11-05 13:24:20 版权归作者和作者当前组织所有
 */
package com.mmk.trade.dao;

import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import com.mmk.trade.model.Tuan;

/**
* TuanRepository: 团管理 数据资源层
* 2016-11-05 13:24:20
* @author huguangling 胡广玲
* @version 1.0
*/
public interface TuanRepository extends JpaRepository<Tuan, Long>{

    /**
     *  根据给定的字段：orderId 订单ID返回符合条件的第一个对象
     * @param orderId 订单ID
     * @return 符合条件的唯一对象
     * @author huguangling 胡广玲
     * 
     */
    Tuan findFirstByOrderId(Long orderId);
    /**
     *  根据给定的字段：orderId 订单ID获取所有符合的记录
     * @param orderId 订单ID
     * @return 符合条件的所有对象
     * @author huguangling 胡广玲
     * 
     */
    List<Tuan> findAllByOrderId(Long orderId);
    /**
     *  根据给定的字段：orderId 订单ID所有符合的记录
     * @param orderId 订单ID
     * @param pageable 分页参数
     * @return 符合条件的所有对象
     * @author huguangling 胡广玲
     * 
     */
    Page<Tuan> findAllByOrderId(Long orderId,Pageable pageable);

}