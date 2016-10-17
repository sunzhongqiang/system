/*
 * 
 *  LoginLogController 创建于 2016-10-12 11:54:12 版权归作者和作者当前组织所有
 */
package com.mmk.system.web;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mmk.common.ExtJsPage;
import com.mmk.common.ExtJsPageable;
import com.mmk.system.condition.LoginLogCondition;
import com.mmk.system.model.LoginLog;
import com.mmk.system.service.LoginLogService;

/**
*LoginLogController ： 系统登录日志 的web控制层
* 2016-10-12 11:54:12
*@author sunzhongqiang 孙中强
*@version 1.0
*/
@RestController
public class LoginLogController{
	private Log log = LogFactory.getLog(this.getClass());
	
	@Resource 
	private LoginLogService loginLogService;

    /**
	 * 跳转至列表页面
	 * @param loginLogCondition 查询参数
	 * @param pageable 分页参数
	 * @return 返回页面以及页面模型
	 * @author sunzhongqiang 孙中强
     * 
	 */
	@RequestMapping("/loginLog/list")
	@ResponseBody
	public ExtJsPage<LoginLog> list(LoginLogCondition loginLogCondition,ExtJsPageable pageable){		
	    log.info("系统登录日志列表查询");
		Page<LoginLog> loginLogPage =loginLogService.list(loginLogCondition,pageable.pageable());		
		return  new ExtJsPage< LoginLog >(loginLogPage);
	}
	
	
	/**
	 * 系统登录日志数据保存方法
	 * @param loginLog 要保存的数据
	 * @return 保存后的数据
	 * @author sunzhongqiang 孙中强
     * 
	 */
	@RequestMapping("/loginLog/save")
	@ResponseBody
	public LoginLog save(LoginLog loginLog){
		log.info("系统登录日志保存");
		return loginLogService.save(loginLog);
	}
	
	/**
     * 系统登录日志数据批量保存方法
     * @param loginLogList 要保存的数据
     * @return 是否成功
     * @author sunzhongqiang 孙中强
     * 
     */
    @RequestMapping("/loginLog/saveAll")
    @ResponseBody
    public boolean save(@RequestBody List<LoginLog> loginLogList){
        log.info("系统登录日志批量保存");
        try {
            loginLogService.save(loginLogList);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage(),e);
            return false;
        }
    }

	
	/**
	 * 跳转至详细信息页面
	 * @param loginLog 要查询的数据
	 * @return 返回详情数据
	 * @author sunzhongqiang 孙中强
     * 
	 */ 
	@RequestMapping("/loginLog/details")
	@ResponseBody
	public LoginLog details(LoginLog loginLog){
		log.info("系统登录日志详细信息");
		loginLog = loginLogService.find(loginLog.getId());
		return loginLog;
	}
	
	/**
	 * 删除数据操作组方法
	 * @param loginLog 要删除的数据
	 * @return 是否成功
	 * @author sunzhongqiang 孙中强
     * 
	 */
	@RequestMapping("/loginLog/delete")
	public boolean delete(LoginLog loginLog){
		log.info("系统登录日志删除");
        try {
            loginLogService.delete(loginLog);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return false;
        }
        return true; 
	}
	
	/**
     * 批量删除数据操作组方法
     * @param loginLogList 要删除的数据
     * @return ture or false 如果成功返回true ,出现错误返回false
     * @author sunzhongqiang 孙中强
     * 
     */
    @RequestMapping("/loginLog/deleteAll")
    public boolean delete(List<LoginLog> loginLogList){
        log.info("系统登录日志批量删除");
        try {
            loginLogService.delete(loginLogList);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return false;
        }
        return true; 
    }
	
}