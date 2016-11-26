/*
 *  ShippingFeeRepository 创建于 2016-11-26 11:33:42 版权归作者和作者当前组织所有
 */
package com.mmk.trade.dao;

import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import com.mmk.trade.model.ShippingFee;

/**
* ShippingFeeRepository: 快递地区运费 数据资源层
* 2016-11-26 11:33:42
* @author huguangling 胡广玲
* @version 1.0
*/
public interface ShippingFeeRepository extends JpaRepository<ShippingFee, Long>{

    /**
     *  根据给定的字段：id 主键返回符合条件的第一个对象
     * @param id 主键
     * @return 符合条件的唯一对象
     * @author huguangling 胡广玲
     * 
     */
    ShippingFee findFirstById(Long id);
    /**
     *  根据给定的字段：shippingId 配送方式获取所有符合的记录
     * @param shippingId 配送方式
     * @return 符合条件的所有对象
     * @author huguangling 胡广玲
     * 
     */
    List<ShippingFee> findAllByShippingId(Long shippingId);
    /**
     *  根据给定的字段：shippingId 配送方式所有符合的记录
     * @param shippingId 配送方式
     * @param pageable 分页参数
     * @return 符合条件的所有对象
     * @author huguangling 胡广玲
     * 
     */
    Page<ShippingFee> findAllByShippingId(Long shippingId,Pageable pageable);

}