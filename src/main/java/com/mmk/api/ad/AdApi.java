package com.mmk.api.ad;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mmk.business.model.Ad;
import com.mmk.business.service.AdService;
import com.mmk.common.model.ResultData;

@RestController
public class AdApi {
	
	@Resource
	private AdService adService;
	
	@RequestMapping("/api/ad/listByPositionCode")
	@ResponseBody
	public ResultData listByPositionCode(String code){
		List<Ad> adList = adService.findAllByPositionCode(code);
		ResultData resultData = new ResultData(true,"广告位置列表");
		resultData.addData("adList", adList);
		return resultData;
	}
}
