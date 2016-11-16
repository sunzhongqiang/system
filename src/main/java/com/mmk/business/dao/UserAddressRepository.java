/*
 *  UserAddressRepository 创建于 2016-11-16 09:37:57 版权归作者和作者当前组织所有
 */
package com.mmk.business.dao;

import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import com.mmk.business.model.UserAddress;

/**
* UserAddressRepository: 会员地址 数据资源层
* 2016-11-16 09:37:57
* @author huguangling 胡广玲
* @version 1.0
*/
public interface UserAddressRepository extends JpaRepository<UserAddress, Long>{

    /**
     *  根据给定的字段：id 地址id返回符合条件的第一个对象
     * @param id 地址id
     * @return 符合条件的唯一对象
     * @author huguangling 胡广玲
     * 
     */
    UserAddress findFirstById(Long id);
    /**
     *  根据给定的字段：userId 会员id获取所有符合的记录
     * @param userId 会员id
     * @return 符合条件的所有对象
     * @author huguangling 胡广玲
     * 
     */
    List<UserAddress> findAllByUserId(Long userId);
    /**
     *  根据给定的字段：userId 会员id所有符合的记录
     * @param userId 会员id
     * @param pageable 分页参数
     * @return 符合条件的所有对象
     * @author huguangling 胡广玲
     * 
     */
    Page<UserAddress> findAllByUserId(Long userId,Pageable pageable);
    
    /**
     * 根据用户openid获取用户地址
     * @param openid
     * @param pageable
     * @return 符合条件的所有对象
     * @author 孙中强 sunzhongqiang
     */
	Page<UserAddress> findAllByOpenid(String openid, Pageable pageable);

}