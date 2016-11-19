/*
 * 
 *  OrganizationCondition 创建于 2016-10-24 10:07:36 版权归作者和作者当前组织所有
 */
package com.mmk.system.condition;
import java.util.ArrayList;
import java.util.List;

import com.mmk.system.model.Organization;

/**
* OrganizationCondition ： 组织机构 扩展查询模型
* 2016-10-24 10:07:36
*@author 孙中强 sunzhongqiang
*@version 1.0
*
*/
public class OrganizationCondition extends Organization{


	private List<OrganizationCondition> children = new ArrayList<OrganizationCondition>();

	public List<OrganizationCondition> getChildren() {
		return children;
	}

	public void setChildren(List<OrganizationCondition> children) {
		this.children = children;
	}

}