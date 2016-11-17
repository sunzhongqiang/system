/*
 * 
 *  WxUserDao 创建于 2016-10-28 14:50:57 版权归作者和作者当前组织所有
 */
package com.mmk.business.dao;

import java.util.List;
import java.util.Map;
import com.mmk.gene.dao.SpringDataQueryDao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.mmk.business.condition.WxUserCondition;
import com.mmk.business.model.WxUser;

/**
 * WxUserDao:微信用户 数据持久层接口
 * 
 * @author 胡广玲 huguangling
 * @version 1.0
 */
public interface WxUserDao extends SpringDataQueryDao<WxUser> {

	/**
	 * 分页查询相关信息，根据传入的bean类对象和分页对象page取得查询结果集List
	 * 
	 * @param wxUser
	 *            查询类
	 * @param pageable
	 *            传入的分页对象
	 * @return 符合条件的查询结果集
	 * @author 胡广玲 huguangling
	 * 
	 * 
	 */
	Page<WxUser> list(WxUserCondition wxUser, Pageable pageable);

	/**
	 * 不分页查询相关信息，根据传入的model类对象取得查询结果集List
	 * 
	 * @param wxUser
	 *            查询类
	 * @return 符合条件的查询结果集
	 * @author 胡广玲 huguangling
	 * 
	 */
	List<WxUser> list(WxUserCondition wxUser);

	/**
	 * 使用sql查询，并以map和分页的形式进行返回数据结果
	 * 
	 * @param wxUser
	 *            WxUser类
	 * @param pageable
	 *            传入的分页对象
	 * @return 符合条件的查询结果集
	 * @author 胡广玲 huguangling
	 * 
	 * 
	 */
	Page<Map<String, Object>> listBySql(WxUserCondition wxUser, Pageable pageable);

	/**
	 * 根据给定的字段和属性值，获得符合条件的第一个结果
	 * 
	 * @param field
	 *            WxUser 中的某个字段
	 * @param value
	 *            字段对应的值
	 * @return 返回符合条件的结果，如果没有返回null
	 * @author 胡广玲 huguangling
	 * 
	 * 
	 */
	WxUser findBy(String field, Object value);

	/**
	 * 根据给定的字段和属性值，获得符合条件的所有结果
	 * 
	 * @param field
	 *            WxUser 中的某个字段
	 * @param value
	 *            字段对应的值
	 * @return 返回符合条件的所有结果
	 * @author 胡广玲 huguangling
	 * 
	 * 
	 */
	List<WxUser> findAllBy(String field, Object value);

}