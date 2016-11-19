/*
 * 
 *  系统权限表Controller 创建于 2016-10-12 11:54:23 版权归作者和作者当前组织所有
 */
package com.mmk.system.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.mmk.common.BaseController;
import com.mmk.common.model.EasyPageable;
import com.mmk.common.model.GridData;
import com.mmk.common.model.ResultMsg;
import com.mmk.common.model.Tree;
import com.mmk.system.condition.PrivilegeCondition;
import com.mmk.system.model.Function;
import com.mmk.system.model.Privilege;
import com.mmk.system.service.FunctionService;
import com.mmk.system.service.PrivilegeService;

/**
 * @Title: PrivilegeController
 * @Description: 系统权限表 的web控制层
 * @author
 */
@RestController
public class PrivilegeController extends BaseController {

	@Resource
	private PrivilegeService privilegeService;

	@Resource
	private FunctionService functionService;

	/**
	 * 跳转至列表页面
	 * 
	 * @return 返回页面以及页面模型
	 */
	@RequestMapping("/privilege/list")
	public ModelAndView list() {
		log.info("系统权限表列表查询");
		ModelAndView modelAndView = new ModelAndView("privilege/list");
		return modelAndView;
	}

	/**
	 * 加载表格数据 用户
	 * 
	 * @param privilegeCondition 用户查询参数
	 * @param pageable 分页参数
	 * @return 查询所得数据
	 */
	@RequestMapping("/privilege/gridData")
	@ResponseBody
	public GridData<Privilege> loadList(PrivilegeCondition privilegeCondition, EasyPageable pageable) {
		log.info("获取系统权限表列表数据");
		Page<Privilege> privilegePage = privilegeService.list(privilegeCondition, pageable.pageable());
		GridData<Privilege> grid = new GridData<Privilege>(privilegePage);
		return grid;
	}

	/**
	 * 新增页面
	 * 
	 * @return 跳转到系统权限表新增页面
	 */
	@RequestMapping("/privilege/add")
	public ModelAndView addPage() {
		ModelAndView modelAndView = new ModelAndView("privilege/form");
		modelAndView.addObject("privilege", new Privilege());
		return modelAndView;
	}

	/**
	 * 跳转到编辑页面
	 * 
	 * @param privilege 跳转到编辑页面
	 */
	@RequestMapping("/privilege/edit")
	public ModelAndView editPage(Privilege privilege) {
		log.info("系统权限表编辑页面");
		privilege = privilegeService.find(privilege.getId());
		ModelAndView modelAndView = new ModelAndView("privilege/form");
		modelAndView.addObject("privilege", privilege);
		return modelAndView;
	}

	/**
	 * 系统权限表数据保存方法
	 * 
	 * @param privilege 要保存的数据
	 * @return privilege 保存后的数据
	 */
	@RequestMapping("/privilege/save")
	@ResponseBody
	public ResultMsg save(Privilege privilege) {
		log.info("系统权限表保存");
		try {
			privilegeService.save(privilege);
		} catch (Exception e) {
			return new ResultMsg(false, "系统权限表保存失败");
		}
		return new ResultMsg(true, "系统权限表保存成功");
	}

	/**
	 * 跳转至详细信息页面
	 * 
	 * @param privilege 参数
	 * @return 详情数据
	 */
	@RequestMapping("/privilege/details")
	@ResponseBody
	public Privilege details(Privilege privilege) {
		log.info("系统权限表详细信息");
		privilege = privilegeService.find(privilege.getId());
		return privilege;
	}

	/**
	 * 删除数据操作组方法
	 * 
	 * @param page privilege
	 * @return
	 */
	@RequestMapping("/privilege/delete")
	public ResultMsg delete(Privilege privilege) {
		log.info("系统权限表删除");
		try {
			privilegeService.delete(privilege);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return new ResultMsg(false, "删除失败");
		}
		return new ResultMsg(true, "删除成功");
	}

	/**
	 * 批量删除数据操作组方法
	 * 
	 * @param page privilege
	 * @return ture or false 如果成功返回true ,出现错误返回false
	 */
	@RequestMapping("/privilege/deleteAll")
	public boolean delete(List<Privilege> privilegeList) {
		log.info("系统权限表批量删除");
		try {
			privilegeService.delete(privilegeList);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return false;
		}
		return true;
	}

	/**
	 * 跳转至详细信息页面
	 * 
	 * @param privilege 参数
	 * @return 用户角色权限
	 */
	@RequestMapping("/privilege/loadByRoleId")
	@ResponseBody
	public List<Privilege> loadByRoleId(Long roleId) {
		log.info("用户角色权限详细信息");
		List<Privilege> privilegeList = privilegeService.findAllBy("roleId", roleId);
		return privilegeList;
	}

	/**
	 * 跳转至详细信息页面
	 * 
	 * @param privilege 参数
	 * @return 用户角色权限设置
	 */
	@Cacheable(cacheNames = "privilege")
	@RequestMapping("/privilege/authorize")
	@ResponseBody
	public void authorize(Long roleId, Long functionId, boolean checked) {
		Privilege privilege = privilegeService.findByIdAndFunctionID(roleId, functionId);

		if (checked) {
			if (privilege == null) {
				privilege = new Privilege();
			}
			Function function = functionService.find(functionId);
			privilege.setFunctionUri(function.getUri());
			privilege.setFunctionId(functionId);
			privilege.setRoleId(roleId);
			privilegeService.save(privilege);
		} else {
			if (privilege != null) {
				privilegeService.delete(privilege);
			}
		}
		return;
	}

	/**
	 * 跳转至详细信息页面
	 * 
	 * @param privilege 参数
	 * @return 用户角色权限设置
	 */
	@RequestMapping("/privilege/authorizeTree")
	@ResponseBody
	public List<Tree> authorizeTree(Long roleId) {
		log.info("用户角色权限设置");
		List<Tree> privilege = privilegeService.findFunctionTreeByRoleId(roleId);
		return privilege;
	}
}