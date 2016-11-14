package com.mmk.api;

import com.mmk.business.model.Goods;
import com.mmk.business.model.WxUser;
import com.mmk.common.model.ResultMsg;

public interface GoodsApi {
	/**
	 * 商品保存
	 * @param user
	 * @return
	 */
	ResultMsg save(Goods goods);

	/**
	 * 商品检索
	 * @param goods 要检索商品的Id
	 * @return
	 */
	ResultMsg findGoods();

	/**
	 * 商品详情
	 * @param id
	 * @return
	 */
	ResultMsg findGoodsInfo(Long id);
	

}
