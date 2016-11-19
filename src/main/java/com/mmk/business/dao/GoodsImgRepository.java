/*
 *  GoodsImgRepository 创建于 2016-11-01 09:00:03 版权归作者和作者当前组织所有
 */
package com.mmk.business.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mmk.business.model.GoodsImg;

/**
* GoodsImgRepository: 商品相册 数据资源层
* 2016-11-01 09:00:03
* @author huguangling  胡广玲
* @version 1.0
*/
public interface GoodsImgRepository extends JpaRepository<GoodsImg, Long>{
	
}