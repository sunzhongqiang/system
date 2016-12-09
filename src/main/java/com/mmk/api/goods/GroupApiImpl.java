package com.mmk.api.goods;

import java.util.List;

import javax.annotation.Resource;
import javax.management.AttributeList;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mmk.business.model.Attention;
import com.mmk.business.model.Favorite;
import com.mmk.business.model.Goods;
import com.mmk.business.model.GoodsGroup;
import com.mmk.business.model.GoodsImg;
import com.mmk.business.model.GoodsSku;
import com.mmk.business.service.AttentionService;
import com.mmk.business.service.FavoriteService;
import com.mmk.business.service.GoodsGroupService;
import com.mmk.business.service.GoodsImgService;
import com.mmk.business.service.GoodsService;
import com.mmk.business.service.GoodsSkuService;
import com.mmk.common.model.ResultData;

@RestController
public class GroupApiImpl {

	@Resource
	private GoodsService goodsService;
	@Resource
	private GoodsGroupService goodsGroupService;
	
	@Resource
	private GoodsSkuService goodsSkuService;

	@Resource
	private GoodsImgService goodsImgService;
	
	@Resource
	private FavoriteService favoriteService;
	@Resource
	private AttentionService attentionService;



	/**
	 * 推荐的团商品数据
	 * @param code 推荐位置编码
	 * @return 推荐的团商品
	 */
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
	
	/**
	 * 即将开始的团商品
	 * @param type 类型，默认是全部的商品
	 * @param pageable 分页参数
	 * @return 即将开团的团商品数据
	 */
	@RequestMapping("/api/group/toBegin")
	public ResultData toBegin(Long type,Pageable pageable) {
		Page<GoodsGroup> goodsList = goodsGroupService.findBeginStart(type,pageable);
		ResultData resultData = new ResultData(true, "查找成功");
		resultData.addData("groupList", goodsList.getContent());
		resultData.addData("total", goodsList.getTotalElements());
		resultData.addData("totalPage", goodsList.getTotalPages());
		resultData.addData("number", goodsList.getNumber());
		resultData.addData("numberOfElement", goodsList.getNumberOfElements());
		return resultData;
	}
	/**
	 * 团详情
	 * @param id 团商品的主键
	 * @return 团商品的详细信息
	 */
	@RequestMapping("/api/group/detail")
	public ResultData detail(Long id) {
		if(id!=null){
			GoodsGroup goodsGroup = goodsGroupService.find(id);
			if(goodsGroup!=null){
				ResultData resultData = new ResultData(true, "查找成功");
				Long goodsId = goodsGroup.getGoods().getId();
				List<GoodsSku> attributeList = goodsSkuService.findAllByGoodsId(goodsId);
				List<GoodsImg> goodsImageList = goodsImgService.findByGoodsId(goodsId);
				resultData.addData("goodsGroup", goodsGroup);
				resultData.addData("skuList", attributeList);
				resultData.addData("goodsImgs", goodsImageList);
				return resultData;
			}else{
				return new ResultData(false, "没有找到对应的团商品");
			}
		}else{
			return new ResultData(false, "ID不可以为空");
		}
	}
	
	/**
	 * 团商品收藏
	 * @param userId 用户的主键
	 * @param groupId 团商品Id
	 * @return 团商品的收藏结果
	 */
	@RequestMapping("/api/group/addFavorite")
	public ResultData addFavorite(Long userId,Long groupId) {
		if(userId!=null){
			GoodsGroup goodsGroup = goodsGroupService.find(groupId);
			if(goodsGroup!=null){
				ResultData resultData = new ResultData(true, "团商品收藏成功");
				Favorite fa = favoriteService.findByUserIdAndGroupId(userId, groupId);
				if(fa != null){
					return new ResultData(false, "团商品已被收藏");
				}
				Favorite favorite = new Favorite();
				favorite.setGroupId(goodsGroupService.get(groupId));
				favorite.setUserId(userId);
				favoriteService.save(favorite);
				return resultData;
			}else{
				return new ResultData(false, "没有找到对应的团商品");
			}
		}else{
			return new ResultData(false, "USERID不可以为空");
		}
	}
	
	/**
	 * 团商品是否已被收藏
	 * @param userId 用户的主键
	 * @param groupId 团商品Id
	 * @return 团商品的收藏结果判断
	 */
	@RequestMapping("/api/group/isFavorited")
	public ResultData isFavorited(Long userId,Long groupId) {
		if(userId!=null){
			GoodsGroup goodsGroup = goodsGroupService.find(groupId);
			if(goodsGroup!=null){
				Favorite fa = favoriteService.findByUserIdAndGroupId(userId, groupId);
				if(fa != null){
					return new ResultData(false, "团商品已被收藏");
				}
				return new ResultData(true, "团商品未被收藏");
			}else{
				return new ResultData(false, "没有找到对应的团商品");
			}
		}else{
			return new ResultData(false, "USERID不可以为空");
		}
	}
	
	/**
	 * 团商品关注
	 * @param userId 用户的主键
	 * @param groupId 团id
	 * @return 团商品的关注结果
	 */
	@RequestMapping("/api/group/addAttenion")
	public ResultData addAttenion(Long userId,Long groupId) {
		if(userId!=null){
			GoodsGroup goodsGroup = goodsGroupService.find(groupId);
			if(goodsGroup!=null){
				ResultData resultData = new ResultData(true, "团商品收藏成功");
				Attention at = attentionService.findByUserIdAndGroupId(userId, groupId);
				if(at != null){
					return new ResultData(false, "团商品已被预约关注");
				}
				Attention attention = new Attention();
				attention.setGroupId(groupId);
				attention.setUserId(userId);
				attentionService.save(attention);
				return resultData;
			}else{
				return new ResultData(false, "没有找到对应的团商品");
			}
		}else{
			return new ResultData(false, "USERID不可以为空");
		}
	}

}
