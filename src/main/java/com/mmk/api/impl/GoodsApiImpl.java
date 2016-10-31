package com.mmk.api.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mmk.api.GoodsApi;
import com.mmk.business.model.Goods;
import com.mmk.business.model.WxUser;
import com.mmk.business.service.WxUserService;
import com.mmk.business.service.impl.GoodsServiceImpl;
import com.mmk.common.model.ResultMsg;

@RestController
public class GoodsApiImpl implements GoodsApi{
	
	@Resource
	private GoodsServiceImpl goodsServiceImpl;
	
	
	@RequestMapping("/api/goods/save")
	@Override
	public ResultMsg save(Goods good) {
		Goods goods = goodsServiceImpl.findBy("openid", good.getId());
		if (goods == null) {
			// 新增商品逻辑
			goodsServiceImpl.save(good);
			return new ResultMsg(true, "商品新增成功");

		} else {
			goods.setGoodsCat(good.getGoodsCat());
			goods.setGoodsMainImg(good.getGoodsMainImg());
			goods.setGoodsName(good.getGoodsName());
			goods.setGoodsNumber(good.getGoodsNumber());
			goods.setGoodsOriginalImg(good.getGoodsOriginalImg());
			goods.setGoodsOriginalPrice(good.getGoodsOriginalPrice());
			goods.setGoodsThumb(good.getGoodsThumb());
			goods.setIsDelete(good.getIsDelete());
			goods.setPromoteEndDate(good.getPromoteEndDate());
			goods.setPromoteNumber(goods.getPromoteNumber());
			goods.setPromotePrice(good.getPromotePrice());
			goods.setPromoteStartDate(good.getPromoteStartDate());
			goods.setGoodsOriginalPrice(good.getGoodsOriginalPrice());
		}
		return new ResultMsg(false, "商品已经存在！");
	}


	@RequestMapping("/api/goods/findGoods")
	@Override
	public ResultMsg findGoods() {
		Iterable<Goods> goods = goodsServiceImpl.findAll();
		if (goods == null) {
			return new ResultMsg(false, "该商品不存在");
		} else {
			Map<String, Object> result = new HashMap<String, Object>();
			result.put("good", goods);
			return new ResultMsg(true, "查找成功", result);
		}
	}

}
