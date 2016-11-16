package com.mmk.business.service;

import java.util.List;
import com.mmk.gene.service.BaseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.mmk.business.model.UserAddress;
import com.mmk.business.condition.UserAddressCondition;

/**
* UserAddressService: 会员地址 业务服务层接口
*2016-11-16 09:37:58
*@author huguangling 胡广玲
*@version 1.0
*/
public interface UserAddressService extends BaseService<UserAddress, Long> {
    /**
     * 生成的列表分页查询方法
     * @param userAddressCondition  查询条件
     * @param pageable 分页参数
     * @return 分页返回查询的结果
     * @author huguangling 胡广玲
     * 
     */
    Page<UserAddress> list(UserAddressCondition userAddressCondition, Pageable pageable);
    
    /**
     * 不分页查询相关信息，根据传入的model类对象取得查询结果集List
     * @param  userAddress 查询类
     * @return 查询的结果集
     * @author huguangling 胡广玲
     * 
     */
    public List<UserAddress> list(UserAddressCondition userAddress);

    /**
     * 根据给定的字段返回符合的对象
     * @param id 地址id
     * @return 符合条件的唯一对象
     * @author huguangling 胡广玲
     * 
     */
    UserAddress findById(Long id);
    /**
     * 根据字段获取所有符合的记录
     * @param userId 会员id
     * @return 符合条件的所有对象
     * @author huguangling 胡广玲
     * 
     */
    List<UserAddress> findAllByUserId(Long userId);
    /**
     * 根据字段获取所有符合的记录
     * @param userId 会员id
     * @param pageable 分页参数
     * @return 符合条件的所有对象
     * @author huguangling 胡广玲
     * 
     */
    Page<UserAddress> findAllByUserId(Long userId, Pageable pageable);
    /**
     * 根据给定的字段和属性值，获得符合条件的第一个结果
     * @param field UserAddress 中的某个字段
     * @param value 字段的值
     * @return UserAddress 返回符合条件的结果，如果没有返回null
     * @author huguangling 胡广玲
     * 
     * 
     */
    UserAddress findBy(String field,Object value);
    
    /**
     * 根据给定的字段和属性值，获得符合条件的所有结果
     * @param field UserAddress中的某个字段
     * @param value 字段的值
     * @return 返回符合条件的所有结果
     * @author huguangling 胡广玲
     * 
     * 
     */
    List<UserAddress> findAllBy(String field,Object value);
    
    /**
     * 根据字段获取所有符合的记录
     * @param openid openid
     * @param pageable 分页参数
     * @return 符合条件的所有对象
     * @author sunzhongqiang 孙中强
     * 
     */
    Page<UserAddress> findAllByOpenid(String openid, Pageable pageable);
}