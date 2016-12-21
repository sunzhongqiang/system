/*
 *  UserRoleRepository 创建于 2016-10-27 08:21:19 版权归作者和作者当前组织所有
 */
package com.mmk.system.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.mmk.system.model.UserRole;

/**
 * UserRoleRepository: 系统用户角色 数据资源层 2016-10-27 08:21:19
 * 
 * @author code
 * @version 1.0
 */
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {

	/**
	 * 根据给定的字段：userId 用户主键获取所有符合的记录
	 * 
	 * @param userId　 用户主键
	 * @return 符合条件的所有对象
	 * @author code
	 * 
	 */
	List<UserRole> findAllByUserId(Long userId);

	/**
	 * 根据给定的字段：userId 用户主键所有符合的记录
	 * 
	 * @param userId　用户主键
	 * @param pageable　分页参数
	 * @return 符合条件的所有对象
	 * @author code
	 * 
	 */
	Page<UserRole> findAllByUserId(Long userId, Pageable pageable);

	/**
	 * 根据给定的字段：roleId 角色主键获取所有符合的记录
	 * 
	 * @param roleId　角色主键
	 * @return 符合条件的所有对象
	 * @author code
	 * 
	 */
	List<UserRole> findAllByRoleId(Long roleId);

	/**
	 * 根据给定的字段：roleId 角色主键所有符合的记录
	 * 
	 * @param roleId 角色主键
	 * @param pageable 分页参数
	 * @return 符合条件的所有对象
	 * @author code
	 * 
	 */
	Page<UserRole> findAllByRoleId(Long roleId, Pageable pageable);

}