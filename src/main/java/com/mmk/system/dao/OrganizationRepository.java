/*
 *  OrganizationRepository 创建于 2016-10-24 10:07:36 版权归作者和作者当前组织所有
 */
package com.mmk.system.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mmk.system.model.Organization;

/**
* OrganizationRepository: 组织机构 数据资源层
* 2016-10-24 10:07:36
* @author 孙中强 sunzhongqiang
* @version 1.0
*/
public interface OrganizationRepository extends JpaRepository<Organization, Long>{

}