/*
 *  WxUserRepository 创建于 2016-10-28 14:50:57 版权归作者和作者当前组织所有
 */
package com.mmk.business.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mmk.business.model.WxUser;

/**
* WxUserRepository: 微信用户 数据资源层
* 2016-10-28 14:50:57
* @author 胡广玲 huguangling
* @version 1.0
*/
public interface WxUserRepository extends JpaRepository<WxUser, Long>{
}