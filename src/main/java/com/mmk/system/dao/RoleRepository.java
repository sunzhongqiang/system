/*
 *  RoleRepository 创建于 2016-10-24 14:26:41 版权归作者和作者当前组织所有
 */
package com.mmk.system.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mmk.system.model.Role;

/**
* RoleRepository: 系统角色 数据资源层
* 2016-10-24 14:26:41
* @author huguangling 胡广玲
* @version 1.0
*/
public interface RoleRepository extends JpaRepository<Role, Long>{

}