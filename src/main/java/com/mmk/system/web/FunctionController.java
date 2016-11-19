/*
 * 
 *  系统功能Controller 创建于 2016-10-12 11:54:23 版权归作者和作者当前组织所有
 */
package com.mmk.system.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.mmk.common.BaseController;
import com.mmk.common.model.EasyPageable;
import com.mmk.common.model.GridData;
import com.mmk.common.model.ResultMsg;
import com.mmk.system.condition.FunctionCondition;
import com.mmk.system.model.Function;
import com.mmk.system.service.FunctionService;

/**
*@Title: FunctionController
*@Description: 系统功能 的web控制层
*@author huguangling 胡广玲
*/
@CacheConfig(cacheNames="privilege")
@RestController
public class FunctionController extends BaseController {
    
    @Resource 
    private FunctionService functionService;

    /**
     * 跳转至列表页面
     * @return 返回页面以及页面模型
     */
    @RequestMapping("/function/list")
    public ModelAndView list(){
        log.info("系统功能列表查询");
        ModelAndView modelAndView = new ModelAndView("function/list");
        return  modelAndView;
    }
    
    /**
     * 加载表格数据 用户
     * 
     * @param functionCondition 用户查询参数
     * @param pageable 分页参数
     * @return 查询所得数据
     */
    @RequestMapping("/function/gridData")
    @ResponseBody
    public GridData<Function> loadList(FunctionCondition functionCondition, EasyPageable pageable){
        log.info("获取系统功能列表数据");
        Page<Function> functionPage = functionService.list(functionCondition,pageable.pageable());   
        GridData<Function> grid = new GridData<Function>(functionPage);
        return grid;
    }
    
    /**
     * 新增页面
     * @return 跳转到系统功能新增页面
     */
    @RequestMapping("/function/add")
    public ModelAndView addPage(){
        ModelAndView modelAndView = new ModelAndView("function/form");
        modelAndView.addObject("function", new Function());
        return modelAndView;
    }
    
    /**
     * 跳转到编辑页面
     * @param function  跳转到编辑页面
     */ 
    @RequestMapping("/function/edit")
    public ModelAndView editPage(Function function){
        log.info("系统功能编辑页面");
        function = functionService.find(function.getId());
        ModelAndView modelAndView = new ModelAndView("function/form");
        modelAndView.addObject("function", function);
        return modelAndView ;
    }
       
    /**
     * 系统功能数据保存方法
     * @param function 要保存的数据
     * @return function 保存后的数据
     */
    @CacheEvict
    @RequestMapping("/function/save")
    @ResponseBody
    public ResultMsg save(Function function){
        log.info("系统功能保存");
        try {
            functionService.save(function);
        } catch (Exception e) {
            return new ResultMsg(false,"系统功能保存失败");
        }
        return new ResultMsg(true,"系统功能保存成功");
    }  
    
    /**
     * 跳转至详细信息页面
     * @param function 参数
     * @return 详情数据
     */ 
    @RequestMapping("/function/details")
    @ResponseBody
    public Function details(Function function){
        log.info("系统功能详细信息");
        function = functionService.find(function.getId());
        return function;
    }
    
    /**
     * 删除数据操作组方法
     * @param page function
     * @return
     */
    @CacheEvict
    @RequestMapping("/function/delete")
    public ResultMsg delete(Function function){
        log.info("系统功能删除");
        try {
            functionService.delete(function);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return new ResultMsg(false, "删除失败");
        }
        return new ResultMsg(true,"删除成功"); 
    }
    
    /**
     * 批量删除数据操作组方法
     * @param page function
     * @return ture or false 如果成功返回true ,出现错误返回false
     */
    @RequestMapping("/function/deleteAll")
    public boolean delete(List<Function> functionList){
        log.info("系统功能批量删除");
        try {
            functionService.delete(functionList);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return false;
        }
        return true; 
    }
    
    /**
     * 返回组织结构树
     * @return 组织结构树
     */
    @RequestMapping("/function/tree")
    @ResponseBody
    public List<Function> tree(){
        log.info("获取功能树");
        List<Function> tree = functionService.gridTree();   
        return tree;
    }
}