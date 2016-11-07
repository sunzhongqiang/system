/*
 *  TuanRepository 创建于 2016-11-07 14:59:09 版权归作者和作者当前组织所有
 */
package com.mmk.trade.dao;

import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import com.mmk.trade.model.Tuan;

/**
* TuanRepository: 团管理 数据资源层
* 2016-11-07 14:59:09
* @author huguangling 胡广玲
* @version 1.0
*/
public interface TuanRepository extends JpaRepository<Tuan, Long>{


}