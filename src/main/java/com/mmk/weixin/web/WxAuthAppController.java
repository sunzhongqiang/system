/*
 * 
 *  微信授权APPController 创建于 2016-10-12 11:54:23 版权归作者和作者当前组织所有
 */
package com.mmk.weixin.web;

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
import com.mmk.weixin.condition.WxAuthAppCondition;
import com.mmk.weixin.model.WxAuthApp;
import com.mmk.weixin.service.WxAuthAppService;

/**
*@Title: WxAuthAppController
*@Description: 微信授权APP 的web控制层
*@author 孙中强 sunzhongqiang
*/
@RestController
public class WxAuthAppController extends BaseController {
    
    @Resource 
    private WxAuthAppService wxAuthAppService;

    /**
     * 跳转至列表页面
     * @return 返回页面以及页面模型
     */
    @RequestMapping("/weixin/wxAuthApp/list")
    public ModelAndView list(){
        log.info("微信授权APP列表查询");
        ModelAndView modelAndView = new ModelAndView("weixin/wxAuthApp/list");
        return  modelAndView;
    }
    
    
    /**
     * 加载表格数据 用户
     * 
     * @param wxAuthAppCondition
     *            用户查询参数
     * @param pageable
     *            分页参数
     * @return 查询所得数据
     */
    @RequestMapping("/weixin/wxAuthApp/gridData")
    @ResponseBody
    public GridData<WxAuthApp> loadList(WxAuthAppCondition wxAuthAppCondition, EasyPageable pageable){
        log.info("获取微信授权APP列表数据");
        Page<WxAuthApp> wxAuthAppPage = wxAuthAppService.list(wxAuthAppCondition,pageable.pageable());   
        GridData<WxAuthApp> grid = new GridData<WxAuthApp>(wxAuthAppPage);
        return grid;
    }
    
    /**
     * 新增页面
     * @return 跳转到微信授权APP新增页面
     */
    @RequestMapping("/weixin/wxAuthApp/add")
    public ModelAndView addPage(){
        ModelAndView modelAndView = new ModelAndView("weixin/wxAuthApp/form");
        modelAndView.addObject("wxAuthApp", new WxAuthApp());
        return modelAndView;
    }
    
    /**
     * 跳转到编辑页面
     * @param wxAuthApp  跳转到编辑页面
     */ 
    @RequestMapping("/weixin/wxAuthApp/edit")
    public ModelAndView editPage(WxAuthApp wxAuthApp){
        log.info("微信授权APP编辑页面");
        wxAuthApp = wxAuthAppService.find(wxAuthApp.getId());
        ModelAndView modelAndView = new ModelAndView("weixin/wxAuthApp/form");
        modelAndView.addObject("wxAuthApp", wxAuthApp);
        return modelAndView ;
    }
    
    
    /**
     * 微信授权APP数据保存方法
     * @param wxAuthApp 要保存的数据
     * @return wxAuthApp 保存后的数据
     */
    @RequestMapping("/weixin/wxAuthApp/save")
    @ResponseBody
    public ResultMsg save(WxAuthApp wxAuthApp){
        log.info("微信授权APP保存");
        try {
            wxAuthAppService.save(wxAuthApp);
        } catch (Exception e) {
            return new ResultMsg(false,"微信授权APP保存失败");
        }
        return new ResultMsg(true,"微信授权APP保存成功");
    }
    
   
    
    /**
     * 跳转至详细信息页面
     * @param wxAuthApp 参数
     * @return 详情数据
     */ 
    @RequestMapping("/weixin/wxAuthApp/details")
    @ResponseBody
    public WxAuthApp details(WxAuthApp wxAuthApp){
        log.info("微信授权APP详细信息");
        wxAuthApp = wxAuthAppService.find(wxAuthApp.getId());
        return wxAuthApp;
    }
    
    /**
     * 删除数据操作组方法
     * @param page wxAuthApp
     * @return
     */
    @RequestMapping("/weixin/wxAuthApp/delete")
    public ResultMsg delete(WxAuthApp wxAuthApp){
        log.info("微信授权APP删除");
        try {
            wxAuthAppService.delete(wxAuthApp);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return new ResultMsg(false, "删除失败");
        }
        return new ResultMsg(true,"删除成功"); 
    }
    
    /**
     * 批量删除数据操作组方法
     * @param page wxAuthApp
     * @return ture or false 如果成功返回true ,出现错误返回false
     */
    @RequestMapping("/weixin/wxAuthApp/deleteAll")
    public boolean delete(List<WxAuthApp> wxAuthAppList){
        log.info("微信授权APP批量删除");
        try {
            wxAuthAppService.delete(wxAuthAppList);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return false;
        }
        return true; 
    }
    
}