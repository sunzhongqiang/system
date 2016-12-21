/*
 * 
 *  CategoryCondition 创建于 2016-11-29 13:54:25 版权归作者和作者当前组织所有
 */
package com.mmk.business.condition;
import java.util.ArrayList;
import java.util.List;

import com.mmk.business.model.Category;

/**
* CategoryCondition ： 商品分类 扩展查询模型
* 2016-11-29 13:54:25
*@author 孙中强 sunzhongqiang
*@version 1.0
*
*/
public class CategoryCondition extends Category{

	private List<CategoryCondition> children = new ArrayList<CategoryCondition>();

	public List<CategoryCondition> getChildren() {
		return children;
	}

	public void setChildren(List<CategoryCondition> children) {
		this.children = children;
	}
	

}