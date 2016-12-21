/*
 *  PaymentRepository 创建于 2016-12-05 11:56:57 版权归作者和作者当前组织所有
 */
package com.mmk.payment.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mmk.payment.model.Payment;

/**
* PaymentRepository: 支付方式 数据资源层
* 2016-12-05 11:56:57
* @author 孙中强 sunzhongqiang
* @version 1.0
*/
public interface PaymentRepository extends JpaRepository<Payment, Long>{


}