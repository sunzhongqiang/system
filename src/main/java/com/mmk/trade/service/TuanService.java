package com.mmk.trade.service;

import java.util.List;
import com.mmk.gene.service.BaseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.mmk.trade.model.Tuan;
import com.mmk.trade.condition.TuanCondition;

/**
* TuanService: 团管理 业务服务层接口
*2016-11-07 14:59:09
*@author huguangling 胡广玲
*@version 1.0
*/
public interface TuanService extends BaseService<Tuan, Long> {
    /**
     * 生成的列表分页查询方法
     * @param tuanCondition  查询条件
     * @param pageable 分页参数
     * @return 分页返回查询的结果
     * @author huguangling 胡广玲
     * 
     */
    Page<Tuan> list(TuanCondition tuanCondition, Pageable pageable);
    
    /**
     * 不分页查询相关信息，根据传入的model类对象取得查询结果集List
     * @param  tuan 查询类
     * @return 查询的结果集
     * @author huguangling 胡广玲
     * 
     */
    public List<Tuan> list(TuanCondition tuan);

    /**
     * 根据给定的字段和属性值，获得符合条件的第一个结果
     * @param field Tuan 中的某个字段
     * @param value 字段的值
     * @return Tuan 返回符合条件的结果，如果没有返回null
     * @author huguangling 胡广玲
     * 
     * 
     */
    Tuan findBy(String field,Object value);
    
    /**
     * 根据给定的字段和属性值，获得符合条件的所有结果
     * @param field Tuan中的某个字段
     * @param value 字段的值
     * @return 返回符合条件的所有结果
     * @author huguangling 胡广玲
     * 
     * 
     */
    List<Tuan> findAllBy(String field,Object value);

    
    /**
     * 根据给定的字段和属性值，获得符合条件的所有结果
     * @param field Tuan中的某个字段
     * @param value 字段的值
     * @return 返回符合条件的所有结果
     * @author huguangling 胡广玲
     * 
     * 
     */
    Tuan findById(Long id);

	 /**
     * 根据用户Openid获取团列表
     * @param openid
     * @param status
     * @param pageable
     * @return
     */
	Page<Tuan> listByOpenId(String openid, Long status, Pageable pageable);

	/**
	 * 根据团和状态获取团的列表
	 * @param groupId
	 * @param tuanStatusWait
	 * @param pageable
	 * @return
	 */
	Page<Tuan> findAllByGroupIdAndStatus(Long groupId, Long tuanStatusWait, Pageable pageable);

}