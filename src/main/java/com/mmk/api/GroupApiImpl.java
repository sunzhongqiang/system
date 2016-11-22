package com.mmk.api;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	public ResultData findRecommend(String code, Pageable pageable) {
		Page<GoodsGroup> page = goodsGroupService.findRecommend(code, pageable);
		ResultData result = new ResultData();
		return result;
	}

}
