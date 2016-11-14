package com.mmk.base.condition;

import com.mmk.base.model.Region;

/**
*@Title: RegionCondition
*@Description: 行政区域管理 扩展查询模型
*@author code generator
*@version 1.0
*@date 2016-05-23 14:56:50
*/
public class RegionCondition extends Region{
	/**
	 * 所属区域的所属区域的id(父父级id)
	 */
	private Long grandpaId;

	public Long getGrandpaId() {
		return grandpaId;
	}

	public void setGrandpaId(Long grandpaId) {
		this.grandpaId = grandpaId;
	}
}