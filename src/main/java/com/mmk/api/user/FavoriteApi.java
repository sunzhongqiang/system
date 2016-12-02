package com.mmk.api.user;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mmk.business.model.Favorite;
import com.mmk.business.service.FavoriteService;
import com.mmk.common.model.ResultData;

@RestController
public class FavoriteApi {

	@Resource
	private FavoriteService favoriteService;
	
	/**
	 * 用户的搜藏列表
	 * @param userId 用户id
	 * @param pageable 分页参数
	 * @return 用户的搜藏列表
	 */
	
	@RequestMapping("/api/favorite/list")
	public ResultData findAllByUserId(Long userId,Pageable pageable){
		Page<Favorite> favoritePage = favoriteService.findAllByUserId(userId,pageable);
		ResultData resultData = new ResultData(true, "用户收藏列表");
		resultData.addData("list", favoritePage.getContent());
		resultData.addData("total", favoritePage.getTotalElements());
		resultData.addData("totalPage", favoritePage.getTotalPages());
		return resultData;
	}
}
