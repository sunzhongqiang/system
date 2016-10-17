/*
 *  UserRoleRepository 创建于 2016-10-13 16:53:44 版权归作者和作者当前组织所有
 */
package com.mmk.system.dao;

import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import com.mmk.system.model.UserRole;

/**
* UserRoleRepository: 系统用户角色 数据资源层
* 2016-10-13 16:53:44
* @author 孙中强 sunzhongqiang
* @version 1.0
*/
public interface UserRoleRepository extends JpaRepository<UserRole, Long>{

    /**
     *  根据给定的字段：userId 用户主键获取所有符合的记录
     * @param userId 用户主键
     * @return 符合条件的所有对象
     * @author 孙中强 sunzhongqiang
     * 
     */
    List<UserRole> findAllByUserId(Long userId);
    /**
     *  根据给定的字段：userId 用户主键所有符合的记录
     * @param userId 用户主键
     * @param pageable 分页参数
     * @return 符合条件的所有对象
     * @author 孙中强 sunzhongqiang
     * 
     */
    Page<UserRole> findAllByUserId(Long userId,Pageable pageable);
    /**
     *  根据给定的字段：roleCode 角色编码获取所有符合的记录
     * @param roleCode 角色编码
     * @return 符合条件的所有对象
     * @author 孙中强 sunzhongqiang
     * 
     */
    List<UserRole> findAllByRoleCode(String roleCode);
    /**
     *  根据给定的字段：roleCode 角色编码所有符合的记录
     * @param roleCode 角色编码
     * @param pageable 分页参数
     * @return 符合条件的所有对象
     * @author 孙中强 sunzhongqiang
     * 
     */
    Page<UserRole> findAllByRoleCode(String roleCode,Pageable pageable);

}