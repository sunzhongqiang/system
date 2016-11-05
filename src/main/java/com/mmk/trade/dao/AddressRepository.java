/*
 *  AddressRepository 创建于 2016-11-05 13:29:18 版权归作者和作者当前组织所有
 */
package com.mmk.trade.dao;

import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import com.mmk.trade.model.Address;

/**
* AddressRepository: 地址管理 数据资源层
* 2016-11-05 13:29:18
* @author huguangling 胡广玲
* @version 1.0
*/
public interface AddressRepository extends JpaRepository<Address, Long>{

    /**
     *  根据给定的字段：userId 用户ID返回符合条件的第一个对象
     * @param userId 用户ID
     * @return 符合条件的唯一对象
     * @author huguangling 胡广玲
     * 
     */
    Address findFirstByUserId(Long userId);
    /**
     *  根据给定的字段：userId 用户ID获取所有符合的记录
     * @param userId 用户ID
     * @return 符合条件的所有对象
     * @author huguangling 胡广玲
     * 
     */
    List<Address> findAllByUserId(Long userId);
    /**
     *  根据给定的字段：userId 用户ID所有符合的记录
     * @param userId 用户ID
     * @param pageable 分页参数
     * @return 符合条件的所有对象
     * @author huguangling 胡广玲
     * 
     */
    Page<Address> findAllByUserId(Long userId,Pageable pageable);

}