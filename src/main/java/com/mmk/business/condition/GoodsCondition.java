/*
 * 
 *  GoodsCondition 创建于 2016-10-31 10:48:36 版权归作者和作者当前组织所有
 */
package com.mmk.business.condition;
import java.util.Date;
import java.util.List;

import com.mmk.business.model.Goods;
import com.mmk.business.model.GoodsImg;

/**
* GoodsCondition ： 商品活动 扩展查询模型
* 2016-10-31 10:48:36
*@author huguangling 胡广玲
*@version 1.0
*
*/
public class GoodsCondition extends Goods{

	private List<GoodsImg> goodsImg;

	public List<GoodsImg> getGoodsImg() {
		return goodsImg;
	}

	public void setGoodsImg(List<GoodsImg> goodsImg) {
		this.goodsImg = goodsImg;
	}


}