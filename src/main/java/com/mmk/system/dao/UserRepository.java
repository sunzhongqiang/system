/*
 *  UserRepository 创建于 2016-10-12 11:54:22 版权归作者和作者当前组织所有
 */
package com.mmk.system.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mmk.system.model.User;

/**
* UserRepository: 系统用户 数据资源层
* 2016-10-12 11:54:22
* @author sunzhongqiang 孙中强
* @version 1.0
*/
public interface UserRepository extends JpaRepository<User, Long>{

    /**
     *  根据给定的字段：username 用户名返回符合条件的第一个对象
     * @param username 用户名
     * @return 符合条件的唯一对象
     * @author sunzhongqiang 孙中强
     * 
     */
    User findFirstByUsername(String username);

}