package com.mmk.common.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Tree  {

	//树唯一KEY
	private String id;
	//显示文本
	private String text;
	//状态
	private String state = "open";// open,closed
	//是否选中
	private boolean checked = false;
	//额外属性
	private Map<String,Object> attributes;
	//树的孩子
	private List<Tree> children = new ArrayList<Tree>(); // 孩子节点
	// 样式
	private String iconCls;
	// 父节点
	private String pid; // 父节点的id

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	public Map<String,Object> getAttributes() {
		return attributes;
	}

	public void setAttributes(Map<String,Object> attributes) {
		this.attributes = attributes;
	}

	public List<Tree> getChildren() {
		return children;
	}

	public void setChildren(List<Tree> children) {
		this.children = children;
	}

	public String getIconCls() {
		return iconCls;
	}

	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

}
