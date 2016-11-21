/*
 * 
 *  GoodsSku 创建于 2016-11-21 14:08:14 版权归作者和作者当前组织所有
 */
package com.mmk.business.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;

/**
* GoodsSku: 商品SKU 数据领域模型
* 2016-11-21 14:08:14
*@author sunzhongqiang 孙中强
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
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="good_id")
    private Long goodId;

    /**
     * 属性值
     */
    @Column(name="sku_name")
    private String skuName;

    /**
     * 商品价格
     */
    @Column(name="price")
    private Double price;

    /**
     * 该sku库存
     */
    @Column(name="stock")
    private Long stock;

    /**
     * 商品条形码
     */
    @Column(name="code")
    private String code;

    /**
     * 商品重量
     */
    @Column(name="weight")
    private Long weight;


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
	* @return skuName ：属性值
	*/
    public String getSkuName() {
        return skuName;
    }
    /** 
    *@param skuName 设置属性值 
    */
    public void setSkuName(String skuName) {
        this.skuName = skuName;
    }

    /** 
	* @return price ：商品价格
	*/
    public Double getPrice() {
        return price;
    }
    /** 
    *@param price 设置商品价格 
    */
    public void setPrice(Double price) {
        this.price = price;
    }

    /** 
	* @return stock ：该sku库存
	*/
    public Long getStock() {
        return stock;
    }
    /** 
    *@param stock 设置该sku库存 
    */
    public void setStock(Long stock) {
        this.stock = stock;
    }

    /** 
	* @return code ：商品条形码
	*/
    public String getCode() {
        return code;
    }
    /** 
    *@param code 设置商品条形码 
    */
    public void setCode(String code) {
        this.code = code;
    }

    /** 
	* @return weight ：商品重量
	*/
    public Long getWeight() {
        return weight;
    }
    /** 
    *@param weight 设置商品重量 
    */
    public void setWeight(Long weight) {
        this.weight = weight;
    }


}