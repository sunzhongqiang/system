/*
 *  ApiRepository 创建于 2016-11-15 10:01:04 版权归作者和作者当前组织所有
 */
package com.mmk.system.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mmk.system.model.Api;

/**
* ApiRepository: 系统API 数据资源层
* 2016-11-15 10:01:04
* @author 
* @version 1.0
*/
public interface ApiRepository extends JpaRepository<Api, Long>{

}