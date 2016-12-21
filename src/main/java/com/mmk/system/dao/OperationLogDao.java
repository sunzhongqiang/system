/*
 * 
 *  OperationLogDao 创建于 2016-10-22 12:17:32 版权归作者和作者当前组织所有
 */
package com.mmk.system.dao;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mmk.gene.dao.SpringDataQueryDao;
import com.mmk.system.condition.OperationLogCondition;
import com.mmk.system.model.OperationLog;

/**
 * OperationLogDao:系统操作日志 数据持久层接口
 * 
 * @author 孙中强
 * @version 1.0 Modified By Modified Date
 */
public interface OperationLogDao extends SpringDataQueryDao<OperationLog> {

	/**
	 * 分页查询相关信息，根据传入的bean类对象和分页对象page取得查询结果集List
	 * 
	 * @param operationLog 查询类
	 * @param pageable 传入的分页对象
	 * @return 符合条件的查询结果集
	 * @author 孙中强
	 * 
	 * 
	 */
	Page<OperationLog> list(OperationLogCondition operationLog, Pageable pageable);

	/**
	 * 不分页查询相关信息，根据传入的model类对象取得查询结果集List
	 * 
	 * @param operationLog 查询类
	 * @return 符合条件的查询结果集
	 * @author 孙中强
	 * 
	 */
	List<OperationLog> list(OperationLogCondition operationLog);

	/**
	 * 使用sql查询，并以map和分页的形式进行返回数据结果
	 * 
	 * @param operationLog OperationLog类
	 * @param pageable 传入的分页对象
	 * @return 符合条件的查询结果集
	 * @author 孙中强
	 * 
	 * 
	 */
	Page<Map<String, Object>> listBySql(OperationLogCondition operationLog, Pageable pageable);

	/**
	 * 根据给定的字段和属性值，获得符合条件的第一个结果
	 * 
	 * @param field OperationLog 中的某个字段
	 * @param value 字段对应的值
	 * @return 返回符合条件的结果，如果没有返回null
	 * @author 孙中强
	 * 
	 * 
	 */
	OperationLog findBy(String field, Object value);

	/**
	 * 根据给定的字段和属性值，获得符合条件的所有结果
	 * 
	 * @param field OperationLog 中的某个字段
	 * @param value 字段对应的值
	 * @return 返回符合条件的所有结果
	 * @author 孙中强
	 * 
	 * 
	 */
	List<OperationLog> findAllBy(String field, Object value);

}