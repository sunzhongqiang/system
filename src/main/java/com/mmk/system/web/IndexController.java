package com.mmk.system.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mmk.common.model.Tree;

@RestController
public class IndexController {
	
	@RequestMapping("/functionTree")
	@ResponseBody
	public List<Tree> tree() {

		Tree root = new Tree();
		root.setId("00");
		root.setText("功能列表");
		root.setPid("0");
		root.setIconCls("icon-folder");

		Tree func1 = new Tree();
		func1.setId("1");
		func1.setText("管理员管理");
		func1.setPid("00");
		func1.setIconCls("icon-company");
		Map<String, Object> attr = new HashMap<String, Object>();
		attr.put("url", "/adminUser/list");
		func1.setAttributes(attr);

		Tree func2 = new Tree();
		func2.setId("2");
		func2.setText("组织架构管理");
		func2.setPid("00");
		func2.setIconCls("icon-company");
		Map<String, Object> attr2 = new HashMap<String, Object>();
		attr2.put("url", "/organization/list");
		func2.setAttributes(attr2);

		Tree resourceMenu = new Tree();
		resourceMenu.setId("3");
		resourceMenu.setText("资源菜单");
		resourceMenu.setPid("00");
		resourceMenu.setIconCls("icon-company");
		Map<String, Object> menuAttr = new HashMap<String, Object>();
		menuAttr.put("url", "/resourceMenu/list");
		resourceMenu.setAttributes(menuAttr);

		Tree func3 = new Tree();
		func3.setId("4");
		func3.setText("登录日志");
		func3.setPid("00");
		func3.setIconCls("icon-company");
		Map<String, Object> attr3 = new HashMap<String, Object>();
		attr3.put("url", "/loginLog/list");
		func3.setAttributes(attr3);

		Tree func4 = new Tree();
		func4.setId("5");
		func4.setText("操作日志");
		func4.setPid("00");
		func4.setIconCls("icon-company");
		Map<String, Object> attr4 = new HashMap<String, Object>();
		attr4.put("url", "/operationLog/list");
		func4.setAttributes(attr4);

		Tree userMenu = new Tree();
		userMenu.setId("6");
		userMenu.setText("区域用户	");
		userMenu.setPid("00");
		userMenu.setIconCls("icon-company");
		Map<String, Object> attr5 = new HashMap<String, Object>();
		attr5.put("url", "/user/list");
		userMenu.setAttributes(attr5);

		List<Tree> tree = new ArrayList<Tree>();
		tree.add(root);
		tree.add(func1);
		tree.add(func2);
		tree.add(userMenu);
		tree.add(resourceMenu);
		tree.add(func3);
		tree.add(func4);
		return tree;
	}

}
