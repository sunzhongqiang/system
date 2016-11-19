/*
 * 
 *  操作表Controller 创建于 2016-10-12 11:54:23 版权归作者和作者当前组织所有
 */
package com.mmk.refund.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.mmk.common.BaseController;
import com.mmk.common.model.EasyPageable;
import com.mmk.common.model.GridData;
import com.mmk.common.model.ResultMsg;
import com.mmk.refund.condition.RefundActionCondition;
import com.mmk.refund.model.RefundAction;
import com.mmk.refund.service.RefundActionService;

/**
 * @Title: RefundActionController
 * @Description: 操作表 的web控制层
 * @author huguangling 胡广玲
 */
@RestController
public class RefundActionController extends BaseController {

	@Resource
	private RefundActionService refundActionService;

	/**
	 * 跳转至列表页面
	 * 
	 * @return 返回页面以及页面模型
	 */
	@RequestMapping("/refundAction/list")
	public ModelAndView list() {
		log.info("操作表列表查询");
		ModelAndView modelAndView = new ModelAndView("refundAction/list");
		return modelAndView;
	}

	/**
	 * 加载表格数据 用户
	 * 
	 * @param refundActionCondition
	 *            用户查询参数
	 * @param pageable
	 *            分页参数
	 * @return 查询所得数据
	 */
	@RequestMapping("/refundAction/gridData")
	@ResponseBody
	public GridData<RefundAction> loadList(RefundActionCondition refundActionCondition, EasyPageable pageable) {
		log.info("获取操作表列表数据");
		Page<RefundAction> refundActionPage = refundActionService.list(refundActionCondition, pageable.pageable());
		GridData<RefundAction> grid = new GridData<RefundAction>(refundActionPage);
		return grid;
	}

	/**
	 * 新增页面
	 * 
	 * @return 跳转到操作表新增页面
	 */
	@RequestMapping("/refundAction/add")
	public ModelAndView addPage() {
		ModelAndView modelAndView = new ModelAndView("refundAction/form");
		modelAndView.addObject("refundAction", new RefundAction());
		return modelAndView;
	}

	/**
	 * 跳转到编辑页面
	 * 
	 * @param refundAction
	 *            跳转到编辑页面
	 */
	@RequestMapping("/refundAction/edit")
	public ModelAndView editPage(RefundAction refundAction) {
		log.info("操作表编辑页面");
		refundAction = refundActionService.find(refundAction.getId());
		ModelAndView modelAndView = new ModelAndView("refundAction/form");
		modelAndView.addObject("refundAction", refundAction);
		return modelAndView;
	}

	/**
	 * 操作表数据保存方法
	 * 
	 * @param refundAction
	 *            要保存的数据
	 * @return refundAction 保存后的数据
	 */
	@RequestMapping("/refundAction/save")
	@ResponseBody
	public ResultMsg save(RefundAction refundAction) {
		log.info("操作表保存");
		try {
			refundActionService.save(refundAction);
		} catch (Exception e) {
			return new ResultMsg(false, "操作表保存失败");
		}
		return new ResultMsg(true, "操作表保存成功");
	}

	/**
	 * 跳转至详细信息页面
	 * 
	 * @param refundAction
	 *            参数
	 * @return 详情数据
	 */
	@RequestMapping("/refundAction/details")
	@ResponseBody
	public RefundAction details(RefundAction refundAction) {
		log.info("操作表详细信息");
		refundAction = refundActionService.find(refundAction.getId());
		return refundAction;
	}

	/**
	 * 删除数据操作组方法
	 * 
	 * @param page
	 *            refundAction
	 * @return
	 */
	@RequestMapping("/refundAction/delete")
	public ResultMsg delete(RefundAction refundAction) {
		log.info("操作表删除");
		try {
			refundActionService.delete(refundAction);
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
	 *            refundAction
	 * @return ture or false 如果成功返回true ,出现错误返回false
	 */
	@RequestMapping("/refundAction/deleteAll")
	public boolean delete(List<RefundAction> refundActionList) {
		log.info("操作表批量删除");
		try {
			refundActionService.delete(refundActionList);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return false;
		}
		return true;
	}

}