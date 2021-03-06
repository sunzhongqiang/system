package com.mmk.api.index;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mmk.business.model.Ad;
import com.mmk.business.service.AdPositionService;
import com.mmk.business.service.AdService;
import com.mmk.business.service.GoodsService;
import com.mmk.common.model.ResultData;

@RestController
public class IndexApi {

	@Resource
	private AdService adService;
	@Resource
	private GoodsService goodsService;
	@Resource
	private AdPositionService	goodPositionService;
	
	/**
	 * 
	 * @param position
	 * @return
	 */
	@RequestMapping("/api/home/indexAd")
	@ResponseBody
	public ResultData indexAd(Long position){
		Map<String, Object> result = new HashMap<String,Object>();
		
		//查询【手机首页广告】
		List<Ad> adList = adService.findAllByPositionId(position);
		ResultData resultData = new ResultData(true, "首页广告", result);
		resultData.addData("adList", adList);
		return resultData;
	}	
}
