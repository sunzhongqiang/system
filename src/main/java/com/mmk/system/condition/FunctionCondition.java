/*
 * 
 *  FunctionCondition 创建于 2016-10-24 15:52:09 版权归作者和作者当前组织所有
 */
package com.mmk.system.condition;

import java.util.ArrayList;
import java.util.List;

import com.mmk.system.model.Function;

/**
 * FunctionCondition ： 系统功能 扩展查询模型 2016-10-24 15:52:09
 * 
 * @author huguangling 胡广玲
 * @version 1.0
 *
 */
public class FunctionCondition extends Function {

	private List<FunctionCondition> children = new ArrayList<FunctionCondition>();

	public List<FunctionCondition> getChildren() {
		return children;
	}

	public void setChildren(List<FunctionCondition> children) {
		this.children = children;
	}

}