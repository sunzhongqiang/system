/*
 * 
 *  Goods 创建于 2016-10-31 09:12:44 版权归作者和作者当前组织所有
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
* Goods: 商品管理 数据领域模型
* 2016-10-31 09:12:44
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
     * 分类ID
     */
    @Column(name="cat_id")
    private Long catId;

    /**
     * 商品名称
     */
    @Column(name="goods_name")
    private String goodsName;

    /**
     * 商品编码
     */
    @Column(name="goods_sn")
    private String goodsSn;

    /**
     * 商品数量
     */
    @Column(name="goods_number")
    private Long goodsNumber;

    /**
     * 商品价格
     */
    @Column(name="goods_price")
    private Long goodsPrice;

    /**
     * 商品重量
     */
    @Column(name="goods_weight")
    private Long goodsWeight;

    /**
     * 商品条形码
     */
    @Column(name="bar_code")
    private String barCode;

    /**
     * 品牌ID
     */
    @Column(name="brand_id")
    private Long brandId;

    /**
     * 品牌名称
     */
    @Column(name="brand_name")
    private String brandName;

    /**
     * 团购价
     */
    @Column(name="promote_price")
    private Double promotePrice;

    /**
     * 促销开始时间
     */
    @Temporal(TemporalType.TIMESTAMP)   
    @Column(name="pmt_start_date")
    private Date pmtStartDate;

    /**
     * 促销结束时间
     */
    @Temporal(TemporalType.TIMESTAMP)   
    @Column(name="pmt_end_date")
    private Date pmtEndDate;

    /**
     * 促销数量
     */
    @Column(name="pmt_number")
    private Long pmtNumber;

    /**
     * 商品摘要
     */
    @Column(name="goods_brief")
    private String goodsBrief;

    /**
     * 商品描述
     */
    @Column(name="goods_desc")
    private String goodsDesc;

    /**
     * 已售数量
     */
    @Column(name="saled_number")
    private Long saledNumber;

    /**
     * 虚拟售出数量
     */
    @Column(name="virtue_sale_num")
    private Long virtueSaleNum;

    /**
     * 卖家备注
     */
    @Column(name="seller_note")
    private String sellerNote;

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
    @Column(name="is_delete")
    private Long isDelete;


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
	* @return catId ：分类ID
	*/
    public Long getCatId() {
        return catId;
    }
    /** 
    *@param catId 设置分类ID 
    */
    public void setCatId(Long catId) {
        this.catId = catId;
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
	* @return goodsSn ：商品编码
	*/
    public String getGoodsSn() {
        return goodsSn;
    }
    /** 
    *@param goodsSn 设置商品编码 
    */
    public void setGoodsSn(String goodsSn) {
        this.goodsSn = goodsSn;
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
	* @return goodsPrice ：商品价格
	*/
    public Long getGoodsPrice() {
        return goodsPrice;
    }
    /** 
    *@param goodsPrice 设置商品价格 
    */
    public void setGoodsPrice(Long goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    /** 
	* @return goodsWeight ：商品重量
	*/
    public Long getGoodsWeight() {
        return goodsWeight;
    }
    /** 
    *@param goodsWeight 设置商品重量 
    */
    public void setGoodsWeight(Long goodsWeight) {
        this.goodsWeight = goodsWeight;
    }

    /** 
	* @return barCode ：商品条形码
	*/
    public String getBarCode() {
        return barCode;
    }
    /** 
    *@param barCode 设置商品条形码 
    */
    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    /** 
	* @return brandId ：品牌ID
	*/
    public Long getBrandId() {
        return brandId;
    }
    /** 
    *@param brandId 设置品牌ID 
    */
    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    /** 
	* @return brandName ：品牌名称
	*/
    public String getBrandName() {
        return brandName;
    }
    /** 
    *@param brandName 设置品牌名称 
    */
    public void setBrandName(String brandName) {
        this.brandName = brandName;
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
	* @return pmtStartDate ：促销开始时间
	*/
    public Date getPmtStartDate() {
        return pmtStartDate;
    }
    /** 
    *@param pmtStartDate 设置促销开始时间 
    */
    public void setPmtStartDate(Date pmtStartDate) {
        this.pmtStartDate = pmtStartDate;
    }

    /** 
	* @return pmtEndDate ：促销结束时间
	*/
    public Date getPmtEndDate() {
        return pmtEndDate;
    }
    /** 
    *@param pmtEndDate 设置促销结束时间 
    */
    public void setPmtEndDate(Date pmtEndDate) {
        this.pmtEndDate = pmtEndDate;
    }

    /** 
	* @return pmtNumber ：促销数量
	*/
    public Long getPmtNumber() {
        return pmtNumber;
    }
    /** 
    *@param pmtNumber 设置促销数量 
    */
    public void setPmtNumber(Long pmtNumber) {
        this.pmtNumber = pmtNumber;
    }

    /** 
	* @return goodsBrief ：商品摘要
	*/
    public String getGoodsBrief() {
        return goodsBrief;
    }
    /** 
    *@param goodsBrief 设置商品摘要 
    */
    public void setGoodsBrief(String goodsBrief) {
        this.goodsBrief = goodsBrief;
    }

    /** 
	* @return goodsDesc ：商品描述
	*/
    public String getGoodsDesc() {
        return goodsDesc;
    }
    /** 
    *@param goodsDesc 设置商品描述 
    */
    public void setGoodsDesc(String goodsDesc) {
        this.goodsDesc = goodsDesc;
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
	* @return virtueSaleNum ：虚拟售出数量
	*/
    public Long getVirtueSaleNum() {
        return virtueSaleNum;
    }
    /** 
    *@param virtueSaleNum 设置虚拟售出数量 
    */
    public void setVirtueSaleNum(Long virtueSaleNum) {
        this.virtueSaleNum = virtueSaleNum;
    }

    /** 
	* @return sellerNote ：卖家备注
	*/
    public String getSellerNote() {
        return sellerNote;
    }
    /** 
    *@param sellerNote 设置卖家备注 
    */
    public void setSellerNote(String sellerNote) {
        this.sellerNote = sellerNote;
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
	* @return isDelete ：商品是否下架
	*/
    public Long getIsDelete() {
        return isDelete;
    }
    /** 
    *@param isDelete 设置商品是否下架 
    */
    public void setIsDelete(Long isDelete) {
        this.isDelete = isDelete;
    }


}