/*
 * 
 *  GoodsSku 创建于 2016-11-01 08:42:10 版权归作者和作者当前组织所有
 */
package com.mmk.business.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;

/**
* GoodsSku: 商品属性 数据领域模型
* 2016-11-01 08:42:10
*@author huguangling 胡广玲
*@version 1.0
*/
@Entity
@Table(name="business_goods_sku")
public class GoodsSku {
    /**
     * 商品属性ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long id;

    /**
     * 商品id
     */
    @Column(name="good_id")
    private Long goodId;

    /**
     * 属性值
     */
    @Column(name="sku_value")
    private String skuValue;

    /**
     * 商品价格
     */
    @Column(name="good_price")
    private Double goodPrice;

    /**
     * 该sku库存
     */
    @Column(name="good_stock")
    private Long goodStock;

    /**
     * 商品条形码
     */
    @Column(name="good_code")
    private String goodCode;

    /**
     * 商品重量
     */
    @Column(name="good_weight")
    private Long goodWeight;

    /**
     * 商品颜色
     */
    @Column(name="good_color")
    private String goodColor;


    /** 
	* @return id ：商品属性ID
	*/
    public Long getId() {
        return id;
    }
    /** 
    *@param id 设置商品属性ID 
    */
    public void setId(Long id) {
        this.id = id;
    }

    /** 
	* @return goodId ：商品id
	*/
    public Long getGoodId() {
        return goodId;
    }
    /** 
    *@param goodId 设置商品id 
    */
    public void setGoodId(Long goodId) {
        this.goodId = goodId;
    }

    /** 
	* @return skuValue ：属性值
	*/
    public String getSkuValue() {
        return skuValue;
    }
    /** 
    *@param skuValue 设置属性值 
    */
    public void setSkuValue(String skuValue) {
        this.skuValue = skuValue;
    }

    /** 
	* @return goodPrice ：商品价格
	*/
    public Double getGoodPrice() {
        return goodPrice;
    }
    /** 
    *@param goodPrice 设置商品价格 
    */
    public void setGoodPrice(Double goodPrice) {
        this.goodPrice = goodPrice;
    }

    /** 
	* @return goodStock ：该sku库存
	*/
    public Long getGoodStock() {
        return goodStock;
    }
    /** 
    *@param goodStock 设置该sku库存 
    */
    public void setGoodStock(Long goodStock) {
        this.goodStock = goodStock;
    }

    /** 
	* @return goodCode ：商品条形码
	*/
    public String getGoodCode() {
        return goodCode;
    }
    /** 
    *@param goodCode 设置商品条形码 
    */
    public void setGoodCode(String goodCode) {
        this.goodCode = goodCode;
    }

    /** 
	* @return goodWeight ：商品重量
	*/
    public Long getGoodWeight() {
        return goodWeight;
    }
    /** 
    *@param goodWeight 设置商品重量 
    */
    public void setGoodWeight(Long goodWeight) {
        this.goodWeight = goodWeight;
    }

    /** 
	* @return goodColor ：商品颜色
	*/
    public String getGoodColor() {
        return goodColor;
    }
    /** 
    *@param goodColor 设置商品颜色 
    */
    public void setGoodColor(String goodColor) {
        this.goodColor = goodColor;
    }


}