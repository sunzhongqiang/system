/*
 * 
 *  GoodsImg 创建于 2016-11-01 09:00:03 版权归作者和作者当前组织所有
 */
package com.mmk.business.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * GoodsImg: 商品相册 数据领域模型 2016-11-01 09:00:03
 * 
 * @author huguangling 胡广玲
 * @version 1.0
 */
@Entity
@Table(name = "business_goods_img")
public class GoodsImg {
	/**
	 * 商品相册ID
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	/**
	 * 商品ID
	 */
	@Column(name = "goods_id")
	private Long goodsId;

	/**
	 * 商品原图
	 */
	@Column(name = "original_img")
	private String originalImg;

	/**
	 * 商品缩略图1
	 */
	@Column(name = "small_thumb_img")
	private String smallThumbImg;

	/**
	 * 商品缩略图2
	 */
	@Column(name = "big_thumb_img")
	private String bigThumbImg;

	/**
	 * @return id ：商品相册ID
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            设置商品相册ID
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return goodsId ：商品ID
	 */
	public Long getGoodsId() {
		return goodsId;
	}

	/**
	 * @param goodsId
	 *            设置商品ID
	 */
	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}

	/**
	 * @return originalImg ：商品原图
	 */
	public String getOriginalImg() {
		return originalImg;
	}

	/**
	 * @param originalImg
	 *            设置商品原图
	 */
	public void setOriginalImg(String originalImg) {
		this.originalImg = originalImg;
	}

	/**
	 * @return smallThumbImg ：商品缩略图1
	 */
	public String getSmallThumbImg() {
		return smallThumbImg;
	}

	/**
	 * @param smallThumbImg
	 *            设置商品缩略图1
	 */
	public void setSmallThumbImg(String smallThumbImg) {
		this.smallThumbImg = smallThumbImg;
	}

	/**
	 * @return bigThumbImg ：商品缩略图2
	 */
	public String getBigThumbImg() {
		return bigThumbImg;
	}

	/**
	 * @param bigThumbImg
	 *            设置商品缩略图2
	 */
	public void setBigThumbImg(String bigThumbImg) {
		this.bigThumbImg = bigThumbImg;
	}

}