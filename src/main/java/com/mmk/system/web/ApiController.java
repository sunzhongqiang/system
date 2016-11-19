/*
 * 
 *  系统APIController 创建于 2016-10-12 11:54:23 版权归作者和作者当前组织所有
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
import com.mmk.system.condition.ApiCondition;
import com.mmk.system.model.Api;
import com.mmk.system.service.ApiService;

/**
*@Title: ApiController
*@Description: 系统API 的web控制层
*@author 
*/
@RestController
public class ApiController extends BaseController {
    
    @Resource 
    private ApiService apiService;

    /**
     * 跳转至列表页面
     * @return 返回页面以及页面模型
     */
    @RequestMapping("/api/list")
    public ModelAndView list(){
        log.info("系统API列表查询");
        ModelAndView modelAndView = new ModelAndView("api/list");
        return  modelAndView;
    }
      
    /**
     * 加载表格数据 用户
     * 
     * @param apiCondition  用户查询参数
     * @param pageable 分页参数
     * @return 查询所得数据
     */
    @RequestMapping("/api/gridData")
    @ResponseBody
    public GridData<Api> loadList(ApiCondition apiCondition, EasyPageable pageable){
        log.info("获取系统API列表数据");
        Page<Api> apiPage = apiService.list(apiCondition,pageable.pageable());   
        GridData<Api> grid = new GridData<Api>(apiPage);
        return grid;
    }
    
    /**
     * 新增页面
     * @return 跳转到系统API新增页面
     */
    @RequestMapping("/api/add")
    public ModelAndView addPage(){
        ModelAndView modelAndView = new ModelAndView("api/form");
        modelAndView.addObject("api", new Api());
        return modelAndView;
    }
    
    /**
     * 跳转到编辑页面
     * @param api  跳转到编辑页面
     */ 
    @RequestMapping("/api/edit")
    public ModelAndView editPage(Api api){
        log.info("系统API编辑页面");
        api = apiService.find(api.getId());
        ModelAndView modelAndView = new ModelAndView("api/form");
        modelAndView.addObject("api", api);
        return modelAndView ;
    }
     
    /**
     * 系统API数据保存方法
     * @param api 要保存的数据
     * @return api 保存后的数据
     */
    @RequestMapping("/api/save")
    @ResponseBody
    public ResultMsg save(Api api){
        log.info("系统API保存");
        try {
            apiService.save(api);
        } catch (Exception e) {
            return new ResultMsg(false,"系统API保存失败");
        }
        return new ResultMsg(true,"系统API保存成功");
    }
    
    /**
     * 跳转至详细信息页面
     * @param api 参数
     * @return 详情数据
     */ 
    @RequestMapping("/api/details")
    @ResponseBody
    public Api details(Api api){
        log.info("系统API详细信息");
        api = apiService.find(api.getId());
        return api;
    }
    
    /**
     * 删除数据操作组方法
     * @param page api
     * @return
     */
    @RequestMapping("/api/delete")
    public ResultMsg delete(Api api){
        log.info("系统API删除");
        try {
            apiService.delete(api);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return new ResultMsg(false, "删除失败");
        }
        return new ResultMsg(true,"删除成功"); 
    }
    
    /**
     * 批量删除数据操作组方法
     * @param page api
     * @return ture or false 如果成功返回true ,出现错误返回false
     */
    @RequestMapping("/api/deleteAll")
    public boolean delete(List<Api> apiList){
        log.info("系统API批量删除");
        try {
            apiService.delete(apiList);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return false;
        }
        return true; 
    }
    
}