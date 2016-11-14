/*
 *  RefundActionRepository 创建于 2016-11-14 13:32:00 版权归作者和作者当前组织所有
 */
package com.mmk.refund.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mmk.refund.model.RefundAction;

/**
* RefundActionRepository: 操作表 数据资源层
* 2016-11-14 13:32:00
* @author huguangling 胡广玲
* @version 1.0
*/
public interface RefundActionRepository extends JpaRepository<RefundAction, Long>{


}