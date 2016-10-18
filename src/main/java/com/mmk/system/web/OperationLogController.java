/*
 * 
 *  OperationLogController 创建于 2016-10-12 11:54:16 版权归作者和作者当前组织所有
 */
package com.mmk.system.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.mmk.system.service.OperationLogService;
import com.mmk.system.model.OperationLog;
import com.mmk.common.model.ExtJsPage;
import com.mmk.common.model.ExtJsPageable;
import com.mmk.system.condition.OperationLogCondition;

/**
*OperationLogController ： 系统操作日志 的web控制层
* 2016-10-12 11:54:16
*@author sunzhongqiang 孙中强
*@version 1.0
*/
@RestController
public class OperationLogController{
	private Log log = LogFactory.getLog(this.getClass());
	
	@Resource 
	private OperationLogService operationLogService;

    /**
	 * 跳转至列表页面
	 * @param operationLogCondition 查询参数
	 * @param pageable 分页参数
	 * @return 返回页面以及页面模型
	 * @author sunzhongqiang 孙中强
     * 
	 */
	@RequestMapping("/operationLog/list")
	@ResponseBody
	public ExtJsPage<OperationLog> list(OperationLogCondition operationLogCondition, ExtJsPageable pageable){		
	    log.info("系统操作日志列表查询");
		Page<OperationLog> operationLogPage =operationLogService.list(operationLogCondition,pageable.pageable());		
		return  new ExtJsPage< OperationLog >(operationLogPage);
	}
	
	
	/**
	 * 系统操作日志数据保存方法
	 * @param operationLog 要保存的数据
	 * @return 保存后的数据
	 * @author sunzhongqiang 孙中强
     * 
	 */
	@RequestMapping("/operationLog/save")
	@ResponseBody
	public OperationLog save(OperationLog operationLog){
		log.info("系统操作日志保存");
		return operationLogService.save(operationLog);
	}
	
	/**
     * 系统操作日志数据批量保存方法
     * @param operationLogList 要保存的数据
     * @return 是否成功
     * @author sunzhongqiang 孙中强
     * 
     */
    @RequestMapping("/operationLog/saveAll")
    @ResponseBody
    public boolean save(@RequestBody List<OperationLog> operationLogList){
        log.info("系统操作日志批量保存");
        try {
            operationLogService.save(operationLogList);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage(),e);
            return false;
        }
    }

	
	/**
	 * 跳转至详细信息页面
	 * @param operationLog 要查询的数据
	 * @return 返回详情数据
	 * @author sunzhongqiang 孙中强
     * 
	 */ 
	@RequestMapping("/operationLog/details")
	@ResponseBody
	public OperationLog details(OperationLog operationLog){
		log.info("系统操作日志详细信息");
		operationLog = operationLogService.find(operationLog.getId());
		return operationLog;
	}
	
	/**
	 * 删除数据操作组方法
	 * @param operationLog 要删除的数据
	 * @return 是否成功
	 * @author sunzhongqiang 孙中强
     * 
	 */
	@RequestMapping("/operationLog/delete")
	public boolean delete(OperationLog operationLog){
		log.info("系统操作日志删除");
        try {
            operationLogService.delete(operationLog);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return false;
        }
        return true; 
	}
	
	/**
     * 批量删除数据操作组方法
     * @param operationLogList 要删除的数据
     * @return ture or false 如果成功返回true ,出现错误返回false
     * @author sunzhongqiang 孙中强
     * 
     */
    @RequestMapping("/operationLog/deleteAll")
    public boolean delete(List<OperationLog> operationLogList){
        log.info("系统操作日志批量删除");
        try {
            operationLogService.delete(operationLogList);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return false;
        }
        return true; 
    }
	
}