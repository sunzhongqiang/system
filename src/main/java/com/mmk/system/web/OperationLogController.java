/*
 * 
 *  系统操作日志Controller 创建于 2016-10-12 11:54:23 版权归作者和作者当前组织所有
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
import com.mmk.system.condition.OperationLogCondition;
import com.mmk.system.model.OperationLog;
import com.mmk.system.service.OperationLogService;

/**
*@Title: OperationLogController
*@Description: 系统操作日志 的web控制层
*@author 孙中强
*@version 1.0
*@date 2016-10-22 12:17:33
*/
@RestController
public class OperationLogController extends BaseController {
    
    @Resource 
    private OperationLogService operationLogService;

    /**
     * 跳转至列表页面
     * @return 返回页面以及页面模型
     */
    @RequestMapping("/operationLog/list")
    public ModelAndView list(){
        log.info("系统操作日志列表查询");
        ModelAndView modelAndView = new ModelAndView("operationLog/list");
        return  modelAndView;
    }
    
    
    /**
     * 加载表格数据 用户
     * 
     * @param operationLogCondition 用户查询参数
     * @param pageable 分页参数
     * @return 查询所得数据
     */
    @RequestMapping("/operationLog/gridData")
    @ResponseBody
    public GridData<OperationLog> loadList(OperationLogCondition operationLogCondition, EasyPageable pageable){
        log.info("获取系统操作日志列表数据");
        Page<OperationLog> operationLogPage = operationLogService.list(operationLogCondition,pageable.pageable());   
        GridData<OperationLog> grid = new GridData<OperationLog>(operationLogPage);
        return grid;
    }
    
    /**
     * 新增页面
     * @return 跳转到系统操作日志新增页面
     */
    @RequestMapping("/operationLog/add")
    public ModelAndView addPage(){
        ModelAndView modelAndView = new ModelAndView("operationLog/form");
        modelAndView.addObject("operationLog", new OperationLog());
        return modelAndView;
    }
    
    /**
     * 跳转到编辑页面
     * @param operationLog  跳转到编辑页面
     */ 
    @RequestMapping("/operationLog/edit")
    public ModelAndView editPage(OperationLog operationLog){
        log.info("系统操作日志编辑页面");
        operationLog = operationLogService.find(operationLog.getId());
        ModelAndView modelAndView = new ModelAndView("operationLog/form");
        modelAndView.addObject("operationLog", operationLog);
        return modelAndView ;
    }
    
    
    /**
     * 系统操作日志数据保存方法
     * @param operationLog 要保存的数据
     * @return operationLog 保存后的数据
     */
    @RequestMapping("/operationLog/save")
    @ResponseBody
    public ResultMsg save(OperationLog operationLog){
        log.info("系统操作日志保存");
        try {
            operationLogService.save(operationLog);
        } catch (Exception e) {
            return new ResultMsg(false,"系统操作日志保存失败");
        }
        return new ResultMsg(true,"系统操作日志保存成功");
    }
    
   
    
    /**
     * 跳转至详细信息页面
     * @param operationLog 参数
     * @return 详情数据
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
     * @param page operationLog
     * @return
     */
    @RequestMapping("/operationLog/delete")
    public ResultMsg delete(OperationLog operationLog){
        log.info("系统操作日志删除");
        try {
            operationLogService.delete(operationLog);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return new ResultMsg(false, "删除失败");
        }
        return new ResultMsg(true,"删除成功"); 
    }
    
    /**
     * 批量删除数据操作组方法
     * @param page operationLog
     * @return ture or false 如果成功返回true ,出现错误返回false
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