package com.mmk.api.goods;

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
	 * 获取评论数据
	 * @param comment Comment
	 * @return 商品的评论
	 */
	@RequestMapping("/api/goods/comment")
	@ResponseBody
	public ResultData saveRecomment(Comment comment) {
		
		commentService.save(comment);
		ResultData result = new ResultData(true,"评论内容");
		result.addData("comment", comment);
		return result;
	}
}
