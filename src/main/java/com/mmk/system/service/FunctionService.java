package com.mmk.system.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mmk.common.model.Tree;
import com.mmk.gene.service.BaseService;
import com.mmk.system.condition.FunctionCondition;
import com.mmk.system.model.Function;

/**
* FunctionService: 系统功能 业务服务层接口
*2016-10-24 15:52:09
*@author huguangling 胡广玲
*@version 1.0
*/
public interface FunctionService extends BaseService<Function, Long> {
    /**
     * 生成的列表分页查询方法
     * @param functionCondition  查询条件
     * @param pageable 分页参数
     * @return 分页返回查询的结果
     * @author huguangling 胡广玲
     * 
     */
    Page<Function> list(FunctionCondition functionCondition, Pageable pageable);
    
    /**
     * 不分页查询相关信息，根据传入的model类对象取得查询结果集List
     * @param  function 查询类
     * @return 查询的结果集
     * @author huguangling 胡广玲
     * 
     */
    public List<Function> list(FunctionCondition function);

    /**
     * 根据给定的字段和属性值，获得符合条件的第一个结果
     * @param field Function 中的某个字段
     * @param value 字段的值
     * @return Function 返回符合条件的结果，如果没有返回null
     * @author huguangling 胡广玲
     * 
     * 
     */
    Function findBy(String field,Object value);
    
    /**
     * 根据给定的字段和属性值，获得符合条件的所有结果
     * @param field Function中的某个字段
     * @param value 字段的值
     * @return 返回符合条件的所有结果
     * @author huguangling 胡广玲
     * 
     * 
     */
    List<Function> findAllBy(String field,Object value);

    /**
     * 根据给定的字段和属性值，获得符合条件的所有结果
     * @return 返回符合条件的所有结果
     * @author huguangling 胡广玲
    */
	List<Function> gridTree();

	/**
	 * 根据用户角色ids获取用户菜单tree
	 * @param roleIdList 用户角色Ids
	 * @return 菜单树
	 */
	List<Tree> findUserMenu(List<Long> roleIdList);

}