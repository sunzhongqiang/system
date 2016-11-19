/*
 *  FunctionRepository 创建于 2016-10-24 15:52:09 版权归作者和作者当前组织所有
 */
package com.mmk.system.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mmk.system.model.Function;

/**
* FunctionRepository: 系统功能 数据资源层
* 2016-10-24 15:52:09
* @author huguangling 胡广玲
* @version 1.0
*/
public interface FunctionRepository extends JpaRepository<Function, Long>{

}