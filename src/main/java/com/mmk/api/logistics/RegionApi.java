package com.mmk.api.logistics;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mmk.common.model.ResultData;
import com.mmk.system.model.Region;
import com.mmk.system.service.RegionService;

@RestController
public class RegionApi {

	@Resource
	private RegionService regionService;
	
	/**
	 * 根据父类获取下面的省市区
	 * @param parentId 父类，第一个是0l
	 * @return 子类省市区列表
	 */
	@RequestMapping("/api/region/loadByParentId")
	public ResultData findByParentId(Long parentId){
		List<Region> regionList = regionService.findAllByParentId(parentId);
		ResultData resultData = new ResultData(true, "获取省市区列表");
		resultData.addData("regionList", regionList);
		return resultData;
	}
}
