/*
 *  PaymentConfigRepository 创建于 2016-12-05 11:57:19 版权归作者和作者当前组织所有
 */
package com.mmk.payment.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mmk.payment.model.PaymentConfig;

/**
* PaymentConfigRepository: 支付配置参数 数据资源层
* 2016-12-05 11:57:19
* @author 孙中强 sunzhongqiang
* @version 1.0
*/
public interface PaymentConfigRepository extends JpaRepository<PaymentConfig, Long>{


}