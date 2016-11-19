/*
 * 
 *  系统角色Controller 创建于 2016-10-12 11:54:23 版权归作者和作者当前组织所有
 */
package com.mmk.system.web;

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
import com.mmk.system.condition.RoleCondition;
import com.mmk.system.model.Role;
import com.mmk.system.service.RoleService;

/**
 * @Title: RoleController
 * @Description: 系统角色 的web控制层
 * @author huguangling 胡广玲
 */
@RestController
public class RoleController extends BaseController {

	@Resource
	private RoleService roleService;

	/**
	 * 跳转至列表页面
	 * 
	 * @return 返回页面以及页面模型
	 */
	@RequestMapping("/role/list")
	public ModelAndView list() {
		log.info("系统角色列表查询");
		ModelAndView modelAndView = new ModelAndView("role/list");
		return modelAndView;
	}

	/**
	 * 加载表格数据 用户
	 * 
	 * @param roleCondition 用户查询参数
	 * @param pageable 分页参数
	 * @return 查询所得数据
	 */
	@RequestMapping("/role/gridData")
	@ResponseBody
	public GridData<Role> loadList(RoleCondition roleCondition, EasyPageable pageable) {
		log.info("获取系统角色列表数据");
		Page<Role> rolePage = roleService.list(roleCondition, pageable.pageable());
		GridData<Role> grid = new GridData<Role>(rolePage);
		return grid;
	}

	/**
	 * 新增页面
	 * 
	 * @return 跳转到系统角色新增页面
	 */
	@RequestMapping("/role/add")
	public ModelAndView addPage() {
		ModelAndView modelAndView = new ModelAndView("role/form");
		modelAndView.addObject("role", new Role());
		return modelAndView;
	}

	/**
	 * 跳转到编辑页面
	 * 
	 * @param role 跳转到编辑页面
	 */
	@RequestMapping("/role/edit")
	public ModelAndView editPage(Role role) {
		log.info("系统角色编辑页面");
		role = roleService.find(role.getId());
		ModelAndView modelAndView = new ModelAndView("role/form");
		modelAndView.addObject("role", role);
		return modelAndView;
	}

	/**
	 * 系统角色数据保存方法
	 * 
	 * @param role 要保存的数据
	 * @return role 保存后的数据
	 */
	@RequestMapping("/role/save")
	@ResponseBody
	public ResultMsg save(Role role) {
		log.info("系统角色保存");
		try {
			roleService.save(role);
		} catch (Exception e) {
			return new ResultMsg(false, "系统角色保存失败");
		}
		return new ResultMsg(true, "系统角色保存成功");
	}

	/**
	 * 跳转至详细信息页面
	 * 
	 * @param role 参数
	 * @return 详情数据
	 */
	@RequestMapping("/role/details")
	@ResponseBody
	public Role details(Role role) {
		log.info("系统角色详细信息");
		role = roleService.find(role.getId());
		return role;
	}

	/**
	 * 删除数据操作组方法
	 * 
	 * @param page role
	 * @return
	 */
	@RequestMapping("/role/delete")
	public ResultMsg delete(Role role) {
		log.info("系统角色删除");
		try {
			roleService.delete(role);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return new ResultMsg(false, "删除失败");
		}
		return new ResultMsg(true, "删除成功");
	}

	/**
	 * 批量删除数据操作组方法
	 * 
	 * @param page role
	 * @return ture or false 如果成功返回true ,出现错误返回false
	 */
	@RequestMapping("/role/deleteAll")
	public boolean delete(List<Role> roleList) {
		log.info("系统角色批量删除");
		try {
			roleService.delete(roleList);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return false;
		}
		return true;
	}

	/**
	 * 禁用角色权限
	 * 
	 * @param page role
	 * @return 禁用成功
	 */
	@RequestMapping("/role/disable")
	public ResultMsg disable(Role role) {
		log.info("系统角色禁用");
		role = roleService.find(role.getId());
		role.setStatus("disable");
		roleService.save(role);
		return new ResultMsg(true, "成功禁用");
	}

	/**
	 * 启用角色权限
	 * 
	 * @param page role
	 * @return 启用成功
	 */
	@RequestMapping("/role/enable")
	public ResultMsg enable(Role role) {
		log.info("系统角色启用");
		role = roleService.find(role.getId());
		role.setStatus("enable");
		roleService.save(role);
		return new ResultMsg(true, "成功禁用");
	}

}