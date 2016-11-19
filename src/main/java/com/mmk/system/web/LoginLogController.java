/*
 * 
 *  系统登录日志Controller 创建于 2016-10-12 11:54:23 版权归作者和作者当前组织所有
 */
package com.mmk.system.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.mmk.common.BaseController;
import com.mmk.common.model.EasyPageable;
import com.mmk.common.model.GridData;
import com.mmk.common.model.ResultMsg;
import com.mmk.system.condition.LoginLogCondition;
import com.mmk.system.model.LoginLog;
import com.mmk.system.service.LoginLogService;

/**
*@Title: LoginLogController
*@Description: 系统登录日志 的web控制层
*@author codegenerator
*/
@RestController
public class LoginLogController extends BaseController {
    
    @Resource 
    private LoginLogService loginLogService;

    /**
     * 跳转至列表页面
     * @return 返回页面以及页面模型
     */
    @RequestMapping("/loginLog/list")
    public ModelAndView list(){
        log.info("系统登录日志列表查询");
        ModelAndView modelAndView = new ModelAndView("loginLog/list");
        return  modelAndView;
    }
    
    
    /**
     * 加载表格数据 用户
     * 
     * @param loginLogCondition 用户查询参数
     * @param pageable  分页参数
     * @return 查询所得数据
     */
    @RequestMapping("/loginLog/gridData")
    @ResponseBody
    public GridData<LoginLog> loadList(LoginLogCondition loginLogCondition, EasyPageable pageable){
        log.info("获取系统登录日志列表数据");
        Page<LoginLog> loginLogPage = loginLogService.list(loginLogCondition,pageable.pageable());   
        GridData<LoginLog> grid = new GridData<LoginLog>(loginLogPage);
        return grid;
    }
    
    /**
     * 新增页面
     * @return 跳转到系统登录日志新增页面
     */
    @RequestMapping("/loginLog/add")
    public ModelAndView addPage(){
        ModelAndView modelAndView = new ModelAndView("loginLog/form");
        modelAndView.addObject("loginLog", new LoginLog());
        return modelAndView;
    }
    
    /**
     * 跳转到编辑页面
     * @param loginLog  跳转到编辑页面
     */ 
    @RequestMapping("/loginLog/edit")
    public ModelAndView editPage(LoginLog loginLog){
        log.info("系统登录日志编辑页面");
        loginLog = loginLogService.find(loginLog.getId());
        ModelAndView modelAndView = new ModelAndView("loginLog/form");
        modelAndView.addObject("loginLog", loginLog);
        return modelAndView ;
    }
    
    
    /**
     * 系统登录日志数据保存方法
     * @param loginLog 要保存的数据
     * @return loginLog 保存后的数据
     */
    @RequestMapping("/loginLog/save")
    @ResponseBody
    public ResultMsg save(LoginLog loginLog){
        log.info("系统登录日志保存");
        try {
            loginLogService.save(loginLog);
        } catch (Exception e) {
            return new ResultMsg(false,"系统登录日志保存失败");
        }
        return new ResultMsg(true,"系统登录日志保存成功");
    }
       
    /**
     * 跳转至详细信息页面
     * @param loginLog 参数
     * @return 详情数据
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
     * @param page loginLog
     * @return
     */
    @RequestMapping("/loginLog/delete")
    public ResultMsg delete(LoginLog loginLog){
        log.info("系统登录日志删除");
        try {
            loginLogService.delete(loginLog);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return new ResultMsg(false, "删除失败");
        }
        return new ResultMsg(true,"删除成功"); 
    }
    
    /**
     * 批量删除数据操作组方法
     * @param page loginLog
     * @return ture or false 如果成功返回true ,出现错误返回false
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