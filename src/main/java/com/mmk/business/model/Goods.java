/*
 * 
 *  Goods 创建于 2016-10-31 10:48:36 版权归作者和作者当前组织所有
 */
package com.mmk.business.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
* Goods: 商品活动 数据领域模型
* 2016-10-31 10:48:36
*@author huguangling 胡广玲
*@version 1.0
*/
@Entity
@Table(name="business_goods")
public class Goods {
    /**
     * 商品ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long id;

    /**
     * 商品分类id
     */
    @Column(name="category_id")
    private Long categoryId;

    /**
     * 商品名称
     */
    @Column(name="goods_name")
    private String goodsName;
    
    /**
	 * 商品描述
	 */
	@Column(name="goods_desc")
	private String goodsDesc; 
	/**
     * 商品数量
     */
    @Column(name="goods_number")
    private Long goodsNumber;
	/**
     * 商品编码
     */
    @Column(name="goods_code")
    private String goodsCode;

    /**
     * 商品原价
     */
    @Column(name="goods_original_price")
    private Double goodsOriginalPrice;

    /**
     * 团购价
     */
    @Column(name="promote_price")
    private Double promotePrice;


    /**
     * 已售数量
     */
    @Column(name="saled_number")
    private Long saledNumber;

    /**
     * 商品相册
     */
    @Column(name="goods_thumb")
    private String goodsThumb;

    /**
     * 商品主图
     */
    @Column(name="goods_main_img")
    private String goodsMainImg;

    /**
     * 商品原图
     */
    @Column(name="goods_original_img")
    private String goodsOriginalImg;

    /**
     * 商品是否下架
     */
    @Column(name="is_onsale")
    private Long isOnsale;


    /** 
	* @return id ：商品ID
	*/
    public Long getId() {
        return id;
    }
    /** 
    *@param id 设置商品ID 
    */
    public void setId(Long id) {
        this.id = id;
    }


    /** 
	* @return goodsName ：商品名称
	*/
    public String getGoodsName() {
        return goodsName;
    }
    /** 
    *@param goodsName 设置商品名称 
    */
    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    /** 
	* @return goodsNumber ：商品数量
	*/
    public Long getGoodsNumber() {
        return goodsNumber;
    }
    /** 
    *@param goodsNumber 设置商品数量 
    */
    public void setGoodsNumber(Long goodsNumber) {
        this.goodsNumber = goodsNumber;
    }

    /** 
   	* @return goodsCode ：商品编码
   	*/
    public String getGoodsCode() {
        return goodsCode;
    }
    /** 
    *@param goodsCode 设置商品编码
    */
    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode;
    }
   
    /** 
	* @return goodsOriginalPrice ：商品原价
	*/
    public Double getGoodsOriginalPrice() {
        return goodsOriginalPrice;
    }
    /** 
    *@param goodsOriginalPrice 设置商品原价 
    */
    public void setGoodsOriginalPrice(Double goodsOriginalPrice) {
        this.goodsOriginalPrice = goodsOriginalPrice;
    }

    /** 
	* @return promotePrice ：团购价
	*/
    public Double getPromotePrice() {
        return promotePrice;
    }
    /** 
    *@param promotePrice 设置团购价 
    */
    public void setPromotePrice(Double promotePrice) {
        this.promotePrice = promotePrice;
    }


    /** 
	* @return saledNumber ：已售数量
	*/
    public Long getSaledNumber() {
        return saledNumber;
    }
    /** 
    *@param saledNumber 设置已售数量 
    */
    public void setSaledNumber(Long saledNumber) {
        this.saledNumber = saledNumber;
    }

    /** 
	* @return goodsThumb ：商品相册
	*/
    public String getGoodsThumb() {
        return goodsThumb;
    }
    /** 
    *@param goodsThumb 设置商品相册 
    */
    public void setGoodsThumb(String goodsThumb) {
        this.goodsThumb = goodsThumb;
    }

    /** 
	* @return goodsMainImg ：商品主图
	*/
    public String getGoodsMainImg() {
        return goodsMainImg;
    }
    /** 
    *@param goodsMainImg 设置商品主图 
    */
    public void setGoodsMainImg(String goodsMainImg) {
        this.goodsMainImg = goodsMainImg;
    }

    /** 
	* @return goodsOriginalImg ：商品原图
	*/
    public String getGoodsOriginalImg() {
        return goodsOriginalImg;
    }
    /** 
    *@param goodsOriginalImg 设置商品原图 
    */
    public void setGoodsOriginalImg(String goodsOriginalImg) {
        this.goodsOriginalImg = goodsOriginalImg;
    }

    /** 
	* @return isOnsale ：商品是否下架
	*/
    public Long getIsOnsale() {
        return isOnsale;
    }
    /** 
    *@param isOnsale 设置商品是否下架 
    */
    public void setIsOnsale(Long isOnsale) {
        this.isOnsale = isOnsale;
    }
    /**
	 * 获取商品描述
	 */
	public String getGoodsDesc() {
		return goodsDesc;
	}
	/**
	 * 设置商品描述
	 */
	public void setGoodsDesc(String goodsDesc) {
		this.goodsDesc = goodsDesc;
	}
	public Long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

}