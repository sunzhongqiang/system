package com.mmk.api.goods;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mmk.common.model.ResultData;
import com.mmk.trade.model.Comment;
import com.mmk.trade.service.CommentService;

@RestController
public class CommentApi {

	@Resource
	private CommentService commentService;
	/**
	 * 保存评论数据
	 * @param comment 推荐位置编码
	 * @return 商品 
	 */
	@RequestMapping("/api/goods/comment")
	@ResponseBody
	public ResultData saveRecomment(Comment comment) {
		
		commentService.save(comment);
		ResultData result = new ResultData(true,"评论内容");
		result.addData("comment", comment);
		return result;
	}
	
	/**
	 * 获取评论数据
	 * @param goodsId 商品ID
	 * @return 商品 
	 */
	@RequestMapping("/api/goods/findComment")
	@ResponseBody
	public ResultData findCommentByGoodsId(Long goodsId) {
		
		List<Comment> recommentList	= commentService.findCommentByGoodsId(goodsId);
		ResultData result = new ResultData(true, "评论内容");
		result.addData("recommentList", recommentList);
		return result;
	}
}
