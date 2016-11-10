/*
 *  ShippingRepository 创建于 2016-11-10 08:56:06 版权归作者和作者当前组织所有
 */
package com.mmk.trade.dao;

import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import com.mmk.trade.model.Shipping;

/**
* ShippingRepository: 物流公司 数据资源层
* 2016-11-10 08:56:06
* @author huguangling 胡广玲
* @version 1.0
*/
public interface ShippingRepository extends JpaRepository<Shipping, Long>{

    /**
     *  根据给定的字段：id 主键返回符合条件的第一个对象
     * @param id 主键
     * @return 符合条件的唯一对象
     * @author huguangling 胡广玲
     * 
     */
    Shipping findFirstById(Long id);
    /**
     *  根据给定的字段：id 主键获取所有符合的记录
     * @param id 主键
     * @return 符合条件的所有对象
     * @author huguangling 胡广玲
     * 
     */
    List<Shipping> findAllById(Long id);
    /**
     *  根据给定的字段：id 主键所有符合的记录
     * @param id 主键
     * @param pageable 分页参数
     * @return 符合条件的所有对象
     * @author huguangling 胡广玲
     * 
     */
    Page<Shipping> findAllById(Long id,Pageable pageable);

}