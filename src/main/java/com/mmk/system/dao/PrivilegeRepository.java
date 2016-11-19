/*
 *  PrivilegeRepository 创建于 2016-10-25 09:35:10 版权归作者和作者当前组织所有
 */
package com.mmk.system.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mmk.system.model.Privilege;

/**
* PrivilegeRepository: 系统权限表 数据资源层
* 2016-10-25 09:35:10
* @author 
* @version 1.0
*/
public interface PrivilegeRepository extends JpaRepository<Privilege, Long>{

}