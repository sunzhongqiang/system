package com.mmk.api.user;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mmk.business.model.Attention;
import com.mmk.business.service.AttentionService;
import com.mmk.common.model.ResultData;

@RestController
public class AttentionApi {

	@Resource
	private AttentionService attentionService;
	
	/**
	 * 用户的关注列表
	 * @param userId 用户id
	 * @param pageable 分页
	 * @return 用的关注列表
	 */
	@RequestMapping("/api/attention/list")
	public ResultData findAllByUserId(Long userId,Pageable pageable){
		Page<Attention> attionPage = attentionService.findAllByUserId(userId,pageable);
		return new ResultData(true, "用户关注列表");
	}
}
