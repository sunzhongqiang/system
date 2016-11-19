/*
 * 
 *  微信用户Controller 创建于 2016-10-12 11:54:23 版权归作者和作者当前组织所有
 */
package com.mmk.business.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.mmk.business.condition.WxUserCondition;
import com.mmk.business.model.WxUser;
import com.mmk.business.service.WxUserService;
import com.mmk.common.BaseController;
import com.mmk.common.model.EasyPageable;
import com.mmk.common.model.GridData;
import com.mmk.common.model.ResultMsg;

/**
 * @Title: WxUserController
 * @Description: 微信用户 的web控制层
 * @author 胡广玲 huguangling
 */
@RestController
public class WxUserController extends BaseController {

	@Resource
	private WxUserService wxUserService;

	/**
	 * 跳转至列表页面
	 * 
	 * @return 返回页面以及页面模型
	 */
	@RequestMapping("/wxUser/list")
	public ModelAndView list() {
		log.info("微信用户列表查询");
		ModelAndView modelAndView = new ModelAndView("wxUser/list");
		return modelAndView;
	}

	/**
	 * 加载表格数据 用户
	 * 
	 * @param wxUserCondition　用户查询参数
	 * @param pageable　 分页参数
	 * @return 查询所得数据
	 */
	@RequestMapping("/wxUser/gridData")
	@ResponseBody
	public GridData<WxUser> loadList(WxUserCondition wxUserCondition, EasyPageable pageable) {
		log.info("获取微信用户列表数据");
		Page<WxUser> wxUserPage = wxUserService.list(wxUserCondition, pageable.pageable());
		GridData<WxUser> grid = new GridData<WxUser>(wxUserPage);
		return grid;
	}

	/**
	 * 新增页面
	 * 
	 * @return 跳转到微信用户新增页面
	 */
	@RequestMapping("/wxUser/add")
	public ModelAndView addPage() {
		ModelAndView modelAndView = new ModelAndView("wxUser/form");
		modelAndView.addObject("wxUser", new WxUser());
		return modelAndView;
	}

	/**
	 * 跳转到编辑页面
	 * 
	 * @param wxUser
	 *            跳转到编辑页面
	 */
	@RequestMapping("/wxUser/edit")
	public ModelAndView editPage(WxUser wxUser) {
		log.info("微信用户编辑页面");
		wxUser = wxUserService.find(wxUser.getId());
		ModelAndView modelAndView = new ModelAndView("wxUser/form");
		modelAndView.addObject("wxUser", wxUser);
		return modelAndView;
	}

	/**
	 * 微信用户数据保存方法
	 * 
	 * @param wxUser
	 *            要保存的数据
	 * @return wxUser 保存后的数据
	 */
	@RequestMapping("/wxUser/save")
	@ResponseBody
	public ResultMsg save(WxUser wxUser) {
		log.info("微信用户保存");
		try {
			wxUserService.save(wxUser);
		} catch (Exception e) {
			return new ResultMsg(false, "微信用户保存失败");
		}
		return new ResultMsg(true, "微信用户保存成功");
	}

	/**
	 * 跳转至详细信息页面
	 * 
	 * @param wxUser
	 *            参数
	 * @return 详情数据
	 */
	@RequestMapping("/wxUser/details")
	@ResponseBody
	public WxUser details(WxUser wxUser) {
		log.info("微信用户详细信息");
		wxUser = wxUserService.find(wxUser.getId());
		return wxUser;
	}

	/**
	 * 删除数据操作组方法
	 * 
	 * @param page
	 *            wxUser
	 * @return
	 */
	@RequestMapping("/wxUser/delete")
	public ResultMsg delete(WxUser wxUser) {
		log.info("微信用户删除");
		try {
			wxUserService.delete(wxUser);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return new ResultMsg(false, "删除失败");
		}
		return new ResultMsg(true, "删除成功");
	}

	/**
	 * 批量删除数据操作组方法
	 * 
	 * @param page
	 *            wxUser
	 * @return ture or false 如果成功返回true ,出现错误返回false
	 */
	@RequestMapping("/wxUser/deleteAll")
	public boolean delete(List<WxUser> wxUserList) {
		log.info("微信用户批量删除");
		try {
			wxUserService.delete(wxUserList);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return false;
		}
		return true;
	}

}