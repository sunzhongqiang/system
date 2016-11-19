package com.mmk.system.web;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.mmk.common.BaseController;
import com.mmk.common.CurrentUser;
import com.mmk.common.model.ResultMsg;
import com.mmk.common.model.Tree;
import com.mmk.system.service.FunctionService;

@CacheConfig(cacheNames = "demo1")
@RestController
public class IndexController extends BaseController {

	@Resource
	private FunctionService functionService;

	@RequestMapping("/")
	public ModelAndView index(HttpServletRequest request) {

		ModelAndView modelAndView = new ModelAndView("index");
		modelAndView.addObject("username", request.getRemoteUser());
		return modelAndView;
	}

	@RequestMapping("/functionTree")
	@ResponseBody
	public List<Tree> tree() {

		Collection<? extends GrantedAuthority> authorities = CurrentUser.getAuthentication().getAuthorities();
		List<Long> roleIdList = new ArrayList<Long>();
		for (GrantedAuthority simpleGrantedAuthority : authorities) {
			String authority = simpleGrantedAuthority.getAuthority();
			if (StringUtils.isNumeric(authority)) {
				roleIdList.add(Long.valueOf(authority));
			}
		}
		return functionService.findUserMenu(roleIdList);

		// Tree root = new Tree();
		// root.setId("00");
		// root.setText("功能列表");
		//
		//
		//
		// Tree user = new Tree();
		// user.setId("1");
		// user.setText("用户管理");
		// user.setPid("00");
		// Map<String, Object> attr = new HashMap<String, Object>();
		// attr.put("url", "/user/index");
		// user.setAttributes(attr);
		//
		// Tree role = new Tree();
		// role.setId("11");
		// role.setText("角色管理");
		// role.setPid("00");
		// Map<String, Object> roleAttr = new HashMap<String, Object>();
		// roleAttr.put("url", "/role/list");
		// role.setAttributes(roleAttr);
		//
		// Tree userRole = new Tree();
		// userRole.setId("11");
		// userRole.setText("用户角色管理");
		// userRole.setPid("00");
		// Map<String, Object> userRoleAttr = new HashMap<String, Object>();
		// userRoleAttr.put("url", "/userRole/list");
		// userRole.setAttributes(userRoleAttr);
		//
		// Tree organization = new Tree();
		// organization.setId("2");
		// organization.setText("组织架构管理");
		// organization.setPid("00");
		// Map<String, Object> attr2 = new HashMap<String, Object>();
		// attr2.put("url", "/organization/list");
		// organization.setAttributes(attr2);
		//
		//
		// Tree resourceMenu = new Tree();
		// resourceMenu.setId("3");
		// resourceMenu.setText("功能模块管理");
		// resourceMenu.setPid("00");
		// Map<String, Object> menuAttr = new HashMap<String, Object>();
		// menuAttr.put("url", "/function/list");
		// resourceMenu.setAttributes(menuAttr);
		//
		//
		// Tree privilege = new Tree();
		// privilege.setId("12");
		// privilege.setText("角色授权管理");
		// privilege.setPid("00");
		// Map<String, Object> privilegeAttr = new HashMap<String, Object>();
		// privilegeAttr.put("url", "/privilege/list");
		// privilege.setAttributes(privilegeAttr);
		//
		//
		// Tree loginLog = new Tree();
		// loginLog.setId("4");
		// loginLog.setText("登录日志");
		// loginLog.setPid("00");
		// Map<String, Object> attr3 = new HashMap<String, Object>();
		// attr3.put("url", "/loginLog/list");
		// loginLog.setAttributes(attr3);
		//
		// Tree operationLog = new Tree();
		// operationLog.setId("5");
		// operationLog.setText("操作日志");
		// operationLog.setPid("00");
		// Map<String, Object> attr4 = new HashMap<String, Object>();
		// attr4.put("url", "/operationLog/list");
		// operationLog.setAttributes(attr4);
		//
		//
		// List<Tree> rootTree = new ArrayList<Tree>();
		// List<Tree> tree = new ArrayList<Tree>();
		// tree.add(organization);
		// tree.add(user);
		// tree.add(role);
		// tree.add(userRole);
		// tree.add(resourceMenu);
		// tree.add(privilege);
		// tree.add(loginLog);
		// tree.add(operationLog);
		// root.setChildren(tree);
		// rootTree.add(root);
		// return rootTree;
	}

	@RequestMapping("/clearCache")
	@ResponseBody
	@CacheEvict(allEntries = true)
	public ResultMsg clearAllCache() {
		return new ResultMsg(true, "缓存清理完毕");
	}

}
