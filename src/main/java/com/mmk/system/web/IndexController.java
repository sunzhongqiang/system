package com.mmk.system.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.mmk.common.model.Tree;

@CacheConfig(cacheNames="demo1")
@RestController
public class IndexController {
	
	
	@RequestMapping("/")
	public ModelAndView index(HttpServletRequest request) {
		
		ModelAndView modelAndView = new ModelAndView("index");
		modelAndView.addObject("username", request.getUserPrincipal().getName());
		modelAndView.addObject("remoteuser", request.getRemoteUser());
		return modelAndView;
	}
	
	@Cacheable
	@RequestMapping("/functionTree")
	@ResponseBody
	public List<Tree> tree() {

		Tree root = new Tree();
		root.setId("00");
		root.setText("功能列表");
		root.setIconCls("icon-folder");
		
		

		Tree user = new Tree();
		user.setId("1");
		user.setText("管理员管理");
		user.setPid("00");
		user.setIconCls("icon-company");
		Map<String, Object> attr = new HashMap<String, Object>();
		attr.put("url", "/user/list");
		user.setAttributes(attr);

		Tree organization = new Tree();
		organization.setId("2");
		organization.setText("组织架构管理");
		organization.setPid("00");
		organization.setIconCls("icon-company");
		Map<String, Object> attr2 = new HashMap<String, Object>();
		attr2.put("url", "/organization/list");
		organization.setAttributes(attr2);
		

		Tree resourceMenu = new Tree();
		resourceMenu.setId("3");
		resourceMenu.setText("功能模块");
		resourceMenu.setPid("00");
		resourceMenu.setIconCls("icon-company");
		Map<String, Object> menuAttr = new HashMap<String, Object>();
		menuAttr.put("url", "/resourceMenu/list");
		resourceMenu.setAttributes(menuAttr);

		Tree loginLog = new Tree();
		loginLog.setId("4");
		loginLog.setText("登录日志");
		loginLog.setPid("00");
		loginLog.setIconCls("icon-company");
		Map<String, Object> attr3 = new HashMap<String, Object>();
		attr3.put("url", "/loginLog/list");
		loginLog.setAttributes(attr3);

		Tree operationLog = new Tree();
		operationLog.setId("5");
		operationLog.setText("操作日志");
		operationLog.setPid("00");
		operationLog.setIconCls("icon-company");
		Map<String, Object> attr4 = new HashMap<String, Object>();
		attr4.put("url", "/operationLog/list");
		operationLog.setAttributes(attr4);


		List<Tree> rootTree = new ArrayList<Tree>();
		List<Tree> tree = new ArrayList<Tree>();
		tree.add(organization);
		tree.add(user);
		tree.add(resourceMenu);
		tree.add(loginLog);
		tree.add(operationLog);
		root.setChildren(tree);
		rootTree.add(root);
		return rootTree;
	}
	
	
	
	

}
