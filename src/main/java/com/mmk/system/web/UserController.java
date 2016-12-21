/*
 * 
 *  UserController 创建于 2016-10-12 11:54:23 版权归作者和作者当前组织所有
 */
package com.mmk.system.web;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.mmk.common.BaseController;
import com.mmk.common.CurrentUser;
import com.mmk.common.model.EasyPageable;
import com.mmk.common.model.GridData;
import com.mmk.common.model.ResultMsg;
import com.mmk.system.condition.UserCondition;
import com.mmk.system.model.User;
import com.mmk.system.service.UserService;

/**
 * UserController ： 系统用户 的web控制层 2016-10-12 11:54:23
 * 
 * @author sunzhongqiang 孙中强
 * @version 1.0
 */
@RestController
public class UserController extends BaseController {

	@Resource
	private UserService userService;

	/**
	 * 跳转至列表页面
	 * 
	 * @return 返回页面以及页面模型
	 * 
	 */
	@RequestMapping(value = "/user/index")
	public ModelAndView index() {
		log.info("系统用户index");
		ModelAndView modelAndView = new ModelAndView("user/index");
		return modelAndView;
	}

	/**
	 * 加载表格数据 用户
	 * 
	 * @param userCondition 用户查询参数
	 * @param pageable 分页参数
	 * @return 查询所得数据
	 */
	@RequestMapping("/user/gridData")
	@ResponseBody
	public GridData<User> loadList(UserCondition userCondition, EasyPageable pageable) {
		log.info("获取用户列表数据");
		Page<User> userPage = userService.list(userCondition, pageable.pageable());
		GridData<User> grid = new GridData<User>(userPage);
		return grid;
	}

	/**
	 * 根据组织机构加载用户
	 * 
	 * @param userCondition
	 * @param pageable
	 * @return
	 */
	@RequestMapping("/user/loadByOrgId")
	@ResponseBody
	public GridData<User> loadByOrgId(Long orgId, EasyPageable pageable) {
		log.info("根据组织结构加载用户");
		Page<User> userPage = userService.loadByOrgId(orgId, pageable.pageable());
		GridData<User> grid = new GridData<User>(userPage);
		return grid;
	}

	/**
	 * 编辑页面
	 * 
	 * @return 用户编辑页面
	 */
	@RequestMapping("/user/form")
	public ModelAndView addPage(User user) {
		ModelAndView modelAndView = new ModelAndView("user/form");
		// 如果存在id获取该用户信息
		if (user.getId() != null) {
			user = userService.find(user.getId());
		}
		// 如果用户为空，新增用户
		if (user == null) {
			user = new User();
		}
		modelAndView.addObject("user", user);
		return modelAndView;
	}

	/**
	 * 新增页面
	 * 
	 * @return 用户新增页面
	 */
	@RequestMapping("/user/add")
	public ModelAndView add() {
		return new ModelAndView("user/form", "user", new User());
	}

	/**
	 * 系统用户数据保存方法
	 * 
	 * @param user 要保存的数据
	 * @return 保存后的数据
	 * @author sunzhongqiang 孙中强
	 * 
	 */
	@RequestMapping("/user/save")
	@ResponseBody
	public ResultMsg save(User user) {
		log.info("系统用户保存");

		// 判断id是否存在，如果不存在进行新增，否则进行编辑
		if (user.getId() == null) {
			user.setCreateTime(new Date());
			user.setModifiedTime(new Date());
			user = userService.save(user);
		} else {
			User bean = userService.find(user.getId());
			// 如果存在则进行更新，否则不进行任何处理
			if (bean != null) {
				bean.setModifiedTime(new Date());
				bean.setRealname(user.getRealname());
				bean.setStatus(user.getStatus());
				bean.setDescription(user.getDescription());
				user = userService.save(bean);
			}
		}
		return new ResultMsg(true, "用户保存成功");
	}

	/**
	 * 系统用户数据批量保存方法
	 * 
	 * @param userList  要保存的数据
	 * @return 是否成功
	 * @author sunzhongqiang 孙中强
	 * 
	 */
	@RequestMapping("/user/saveAll")
	@ResponseBody
	public ResultMsg save(@RequestBody List<User> userList) {
		log.info("系统用户批量保存");
		try {
			userService.save(userList);
			return new ResultMsg(true, "批量保存成功");
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage(), e);
			return new ResultMsg(false, "保存失败：" + e.getMessage());
		}
	}

	/**
	 * 跳转至详细信息页面
	 * 
	 * @param user 要查询的数据
	 * @return 返回详情数据
	 * @author sunzhongqiang 孙中强
	 * 
	 */
	@RequestMapping("/user/details")
	@ResponseBody
	public User details(User user) {
		log.info("系统用户详细信息");
		user = userService.find(user.getId());
		return user;
	}

	/**
	 * 删除数据操作组方法
	 * 
	 * @param user 要删除的数据
	 * @return 是否成功
	 * @author sunzhongqiang 孙中强
	 * 
	 */
	@RequestMapping("/user/delete")
	public ResultMsg delete(User user) {
		log.info("系统用户删除");
		try {
			userService.delete(user);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return new ResultMsg(false, e.getMessage());
		}
		return new ResultMsg(true, "删除成功");
	}

	/**
	 * 批量删除数据操作组方法
	 * 
	 * @param userList 要删除的数据
	 * @return ture or false 如果成功返回true ,出现错误返回false
	 * @author sunzhongqiang 孙中强
	 * 
	 */
	@RequestMapping("/user/deleteAll")
	public boolean delete(List<User> userList) {
		log.info("系统用户批量删除");
		try {
			userService.delete(userList);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return false;
		}
		return true;
	}

	/**
	 * 判断用户名是否重复
	 * 
	 * @param username 当前的用户名
	 * @param id 当前的用户id
	 * @return true or false
	 */
	@RequestMapping("/user/username/exist")
	@ResponseBody
	public boolean existsUsername(String username, Long id) {
		log.info("检测用户是否存在  username");
		User userInfo = userService.findByUsername(username);
		if (userInfo != null && !userInfo.getId().equals(id)) {
			return true;
		}
		return false;
	}

	/**
	 * 修改密码逻辑
	 * 
	 * @param oldPwd 旧密码
	 * @param pwd 新密码
	 * @return 处理结果
	 */
	@RequestMapping("/user/changePwd")
	@ResponseBody
	public ResultMsg changePwd(String oldPwd, String pwd) {
		User user = CurrentUser.getUser();
		if (user == null) {
			return new ResultMsg(false, "没有可以修改密码的用户");
		}
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(16);
		if (encoder.matches(oldPwd, user.getPassword())) {// 说明原密码输入正确
			user.setPassword(encoder.encode(pwd));
			userService.save(user);
			return new ResultMsg(true, "修改成功，请重新登录！");
		} else {
			return new ResultMsg(false, "原密码错误！");
		}
	}

	/**
	 * 修改密码逻辑
	 * 
	 * @param oldPwd 旧密码
	 * @param pwd 新密码
	 * @return 处理结果
	 */
	@RequestMapping("/user/changeUserPwd")
	@ResponseBody
	public ResultMsg changeUserPwd(User user) {
		User userBean = userService.find(user.getId());
		if (userBean == null) {
			return new ResultMsg(false, "没有可以修改密码的用户");
		}
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(16);
		userBean.setPassword(encoder.encode(user.getPassword()));
		userService.save(userBean);
		return new ResultMsg(true, "修改成功，请重新登录！");
	}

	/**
	 * 密码修改页面
	 * 
	 * @return 返回密码修改页面
	 */
	@RequestMapping("/user/changePwdForm")
	public ModelAndView changePwdForm() {
		return new ModelAndView("user/changePwdForm");
	}

	/**
	 * 修改密码界面
	 * 
	 * @param user 要修改的用户密码
	 * @return 修改密码界面
	 */
	@RequestMapping("/user/editPwdForm")
	public ModelAndView changePwdForm(User user) {
		ModelAndView modelAndView = new ModelAndView("user/editPwdForm");
		modelAndView.addObject("id", user.getId());
		return modelAndView;
	}

	/**
	 * 修改组织界面
	 * 
	 * @param user 要修改的用户
	 * @return 修改组织界面
	 */
	@RequestMapping("/user/changeOrgForm")
	public ModelAndView changeOrgForm(User user) {
		ModelAndView modelAndView = new ModelAndView("user/changeOrgForm");
		modelAndView.addObject("id", user.getId());
		modelAndView.addObject("user", userService.get(user.getId()));
		return modelAndView;
	}

	/**
	 * 修改组织结构
	 * 
	 * @param user 要修改的用户
	 * @return 修改结果
	 */
	@RequestMapping("/user/changeOrganization")
	public ResultMsg changeOrganization(User user) {
		User bean = userService.get(user.getId());
		bean.setOrganization(user.getOrganization());
		userService.save(bean);
		return new ResultMsg(true, "部门修改成功");
	}

}