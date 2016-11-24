package com.mmk.api.goods;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mmk.business.model.Goods;
import com.mmk.business.model.GoodsGroup;
import com.mmk.business.service.GoodsGroupService;
import com.mmk.business.service.GoodsImgService;
import com.mmk.business.service.GoodsService;
import com.mmk.common.model.ResultData;

@RestController
public class GroupApiImpl {

	@Resource
	private GoodsService goodsService;
	@Resource
	private GoodsGroupService goodsGroupService;

	@Resource
	private GoodsImgService goodsImgService;



	@RequestMapping("/api/group/recommend")
	@ResponseBody
	public ResultData findRecommend(String code) {
		
		Pageable pageable = new PageRequest(0, 50);
		Page<GoodsGroup> page = goodsGroupService.findRecommend(code, pageable );
		ResultData result = new ResultData(true,"推荐的商品");
		result.addData("commendList", page.getContent());
		result.addData("total", page.getTotalElements());
		result.addData("totalPage", page.getTotalPages());
		return result;
	}
	
	@RequestMapping("/api/group/toBegin")
	public ResultData toBegin(Long type,Pageable pageable) {
		Page<GoodsGroup> goodsList = goodsGroupService.findBeginStart(type,pageable);
		ResultData resultData = new ResultData(true, "查找成功");
		resultData.addData("goodsList", goodsList);
		return resultData;
	}
	
	@RequestMapping("/api/group/detail")
	public ResultData detail(Pageable pageable) {
		ResultData resultData = new ResultData(true, "查找成功");
		return resultData;
	}

}