/*
 *  ApiRepository 创建于 2016-11-14 10:22:13 版权归作者和作者当前组织所有
 */
package com.mmk.system.dao;

import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import com.mmk.system.model.Api;

/**
* ApiRepository: 系统API 数据资源层
* 2016-11-14 10:22:13
* @author 孙中强 sunzhongqiang
* @version 1.0
*/
public interface ApiRepository extends JpaRepository<Api, Long>{


}