/*
 *  LoginLogRepository 创建于 2016-10-22 13:46:30 版权归作者和作者当前组织所有
 */
package com.mmk.system.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mmk.system.model.LoginLog;

/**
 * LoginLogRepository: 系统登录日志 数据资源层 2016-10-22 13:46:30
 * 
 * @author codegenerator
 * @version 1.0
 */
public interface LoginLogRepository extends JpaRepository<LoginLog, Long> {

}