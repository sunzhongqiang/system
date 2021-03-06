package com.mmk.api.goods;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mmk.api.GoodsApi;
import com.mmk.business.model.Goods;
import com.mmk.business.model.GoodsImg;
import com.mmk.business.service.GoodsImgService;
import com.mmk.business.service.GoodsService;
import com.mmk.common.model.ResultData;
import com.mmk.common.model.ResultMsg;

@RestController
public class GoodsApiImpl implements GoodsApi {

	@Resource
	private GoodsService goodsServiceImpl;

	@Resource
	private GoodsImgService goodsImgService;

	@RequestMapping("/api/goods/save")
	@Override
	public ResultMsg save(Goods good) {
		Goods goods = goodsServiceImpl.findBy("openid", good.getId());
		if (goods == null) {
			// 新增商品逻辑
			goodsServiceImpl.save(good);
			return new ResultMsg(true, "商品新增成功");
		} else {
			goods.setGoodsMainImg(good.getGoodsMainImg());
			goods.setGoodsName(good.getGoodsName());
			goods.setGoodsNumber(good.getGoodsNumber());
			goods.setGoodsOriginalImg(good.getGoodsOriginalImg());
			goods.setGoodsOriginalPrice(good.getGoodsOriginalPrice());
			goods.setGoodsThumb(good.getGoodsThumb());
			goods.setIsOnsale(good.getIsOnsale());
			goods.setPromotePrice(good.getPromotePrice());
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

	@RequestMapping("/api/goods/findGoodsInfo")
	@Override
	public ResultMsg findGoodsInfo(Long id) {
		Goods goods = goodsServiceImpl.findById(id);
		List<GoodsImg> goodsImageList = goodsImgService.findByGoodsId(id);
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("goods", goods);
		result.put("goodsImgs", goodsImageList);
		return new ResultMsg(true, "查找成功", result);
	}

	@RequestMapping("/api/goods/toBegin")
	@Override
	public ResultData toBegin(Pageable pageable) {
		Page<Goods> goodsList = goodsServiceImpl.findBeginStart(pageable);
		ResultData resultData = new ResultData(true, "查找成功");
		resultData.addData("goodsList", goodsList);
		return resultData;
	}

	@RequestMapping("/api/goods/recommend")
	@Override
	public ResultData findRecommend(String code, Pageable pageable) {
		goodsServiceImpl.findRecommend(code, pageable);
		ResultData result = new ResultData();
		return result;
	}
}
