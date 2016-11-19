/*
 *  OperationLogRepository 创建于 2016-10-22 12:17:32 版权归作者和作者当前组织所有
 */
package com.mmk.system.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mmk.system.model.OperationLog;

/**
* OperationLogRepository: 系统操作日志 数据资源层
* 2016-10-22 12:17:32
* @author 孙中强
* @version 1.0
*/
public interface OperationLogRepository extends JpaRepository<OperationLog, Long>{

}