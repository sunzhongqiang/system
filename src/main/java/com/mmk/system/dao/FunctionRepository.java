/*
 *  FunctionRepository 创建于 2016-10-21 15:48:04 版权归作者和作者当前组织所有
 */
package com.mmk.system.dao;

import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import com.mmk.system.model.Function;

/**
* FunctionRepository: 系统功能 数据资源层
* 2016-10-21 15:48:04
* @author codegenerator
* @version 1.0
*/
public interface FunctionRepository extends JpaRepository<Function, String>{


}