package com.mmk.api.user;

import javax.annotation.Resource;

import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RestController;

import com.mmk.business.service.FavoriteService;
import com.mmk.common.model.ResultData;

@RestController
public class FavoriteApi {

	@Resource
	private FavoriteService favoriteService;
	
	public ResultData findAllByUserId(Long userId,Pageable pageable){
		favoriteService.findAllByUserId(userId,pageable);
		return new ResultData(true, "用户关注列表");
	}
}
