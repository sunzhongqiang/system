package com.mmk.api.user;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mmk.business.model.Attention;
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
	@ResponseBody
	public ResultData findAllByUserId(Long userId,Pageable pageable){
		Page<Favorite> favoritePage = favoriteService.findAllByUserId(userId,pageable);
		ResultData resultData = new ResultData(true, "用户收藏列表");
		resultData.addData("list", favoritePage.getContent());
		resultData.addData("total", favoritePage.getTotalElements());
		resultData.addData("totalPage", favoritePage.getTotalPages());
		return resultData;
	}
	
	/**
	 * 取消关注
	 * @param userId 用户id
	 * @param groupId 推荐团商品
	 * @return 操作结果
	 */
	@ResponseBody
	@RequestMapping("/api/favorite/delete")
	public ResultData delete(Long userId,Long groupId){
		Favorite favorite = favoriteService.findByUserIdAndGroupId(userId, groupId);
		ResultData resultData = new ResultData(true, "取消关注收藏");
		if(favorite!=null){
			favoriteService.delete(favorite);
		}else{
			return new ResultData(false, "非法用户操作"); 
		}
		return resultData;
	}
}
