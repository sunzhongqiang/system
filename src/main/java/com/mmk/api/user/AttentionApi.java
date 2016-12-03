package com.mmk.api.user;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
	@ResponseBody
	@RequestMapping("/api/attention/list")
	public ResultData findAllByUserId(Long userId,Pageable pageable){
		Page<Attention> attionPage = attentionService.findAllByUserId(userId,pageable);
		ResultData resultData = new ResultData(true, "用户关注列表");
		resultData.addData("list", attionPage.getContent());
		resultData.addData("total", attionPage.getTotalElements());
		resultData.addData("totalPage", attionPage.getTotalPages());
		return resultData;
	}
	
	/**
	 * 取消关注
	 * @param userId 用户id
	 * @param attentionId 要取消的关注
	 * @return 操作结果
	 */
	@ResponseBody
	@RequestMapping("/api/attention/delete")
	public ResultData delete(Long userId,Long attentionId){
		Attention attion = attentionService.find(userId);
		ResultData resultData = new ResultData(true, "取消关注成功");
		if(attion.getUserId()==userId){
			attentionService.delete(attion);
		}else{
			return new ResultData(false, "非法用户操作"); 
		}
		return resultData;
	}
}
