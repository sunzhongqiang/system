/*
 * 
 *  微信开发者账号配置Controller 创建于 2016-10-12 11:54:23 版权归作者和作者当前组织所有
 */
package com.mmk.weixin.web;

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
import org.springframework.web.servlet.ModelAndView;

import com.mmk.common.BaseController;
import com.mmk.common.model.EasyPageable;
import com.mmk.common.model.GridData;
import com.mmk.common.model.ResultMsg;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.mmk.weixin.service.WxAppConfigService;
import com.mmk.weixin.model.WxAppConfig;
import com.mmk.weixin.condition.WxAppConfigCondition;

/**
*@Title: WxAppConfigController
*@Description: 微信开发者账号配置 的web控制层
*@author 孙中强 sunzhongqiang
*/
@RestController
public class WxAppConfigController extends BaseController {
    
    @Resource 
    private WxAppConfigService wxAppConfigService;

    /**
     * 跳转至列表页面
     * @return 返回页面以及页面模型
     */
    @RequestMapping("/weixin/wxAppConfig/list")
    public ModelAndView list(){
        log.info("微信开发者账号配置列表查询");
        ModelAndView modelAndView = new ModelAndView("weixin/wxAppConfig/list");
        return  modelAndView;
    }
    
    
    /**
     * 加载表格数据 用户
     * 
     * @param wxAppConfigCondition
     *            用户查询参数
     * @param pageable
     *            分页参数
     * @return 查询所得数据
     */
    @RequestMapping("/weixin/wxAppConfig/gridData")
    @ResponseBody
    public GridData<WxAppConfig> loadList(WxAppConfigCondition wxAppConfigCondition, EasyPageable pageable){
        log.info("获取微信开发者账号配置列表数据");
        Page<WxAppConfig> wxAppConfigPage = wxAppConfigService.list(wxAppConfigCondition,pageable.pageable());   
        GridData<WxAppConfig> grid = new GridData<WxAppConfig>(wxAppConfigPage);
        return grid;
    }
    
    /**
     * 新增页面
     * @return 跳转到微信开发者账号配置新增页面
     */
    @RequestMapping("/weixin/wxAppConfig/add")
    public ModelAndView addPage(){
        ModelAndView modelAndView = new ModelAndView("weixin/wxAppConfig/form");
        modelAndView.addObject("wxAppConfig", new WxAppConfig());
        return modelAndView;
    }
    
    /**
     * 跳转到编辑页面
     * @param wxAppConfig  跳转到编辑页面
     */ 
    @RequestMapping("/weixin/wxAppConfig/edit")
    public ModelAndView editPage(WxAppConfig wxAppConfig){
        log.info("微信开发者账号配置编辑页面");
        wxAppConfig = wxAppConfigService.find(wxAppConfig.getId());
        ModelAndView modelAndView = new ModelAndView("weixin/wxAppConfig/form");
        modelAndView.addObject("wxAppConfig", wxAppConfig);
        return modelAndView ;
    }
    
    
    /**
     * 微信开发者账号配置数据保存方法
     * @param wxAppConfig 要保存的数据
     * @return wxAppConfig 保存后的数据
     */
    @RequestMapping("/weixin/wxAppConfig/save")
    @ResponseBody
    public ResultMsg save(WxAppConfig wxAppConfig){
        log.info("微信开发者账号配置保存");
        try {
            wxAppConfigService.save(wxAppConfig);
        } catch (Exception e) {
            return new ResultMsg(false,"微信开发者账号配置保存失败");
        }
        return new ResultMsg(true,"微信开发者账号配置保存成功");
    }
    
   
    
    /**
     * 跳转至详细信息页面
     * @param wxAppConfig 参数
     * @return 详情数据
     */ 
    @RequestMapping("/weixin/wxAppConfig/details")
    @ResponseBody
    public WxAppConfig details(WxAppConfig wxAppConfig){
        log.info("微信开发者账号配置详细信息");
        wxAppConfig = wxAppConfigService.find(wxAppConfig.getId());
        return wxAppConfig;
    }
    
    /**
     * 删除数据操作组方法
     * @param page wxAppConfig
     * @return
     */
    @RequestMapping("/weixin/wxAppConfig/delete")
    public ResultMsg delete(WxAppConfig wxAppConfig){
        log.info("微信开发者账号配置删除");
        try {
            wxAppConfigService.delete(wxAppConfig);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return new ResultMsg(false, "删除失败");
        }
        return new ResultMsg(true,"删除成功"); 
    }
    
    /**
     * 批量删除数据操作组方法
     * @param page wxAppConfig
     * @return ture or false 如果成功返回true ,出现错误返回false
     */
    @RequestMapping("/weixin/wxAppConfig/deleteAll")
    public boolean delete(List<WxAppConfig> wxAppConfigList){
        log.info("微信开发者账号配置批量删除");
        try {
            wxAppConfigService.delete(wxAppConfigList);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return false;
        }
        return true; 
    }
    
    /**
     * 跳转至详细信息页面
     * @param  code 检查字段是否存在
     * @return  true or false
     */ 
    @RequestMapping("/weixin/wxAppConfig/code/exist")
    @ResponseBody
    public boolean existsCode(String code){
        log.info("检测微信开发者账号配置是否存在  code");
        return wxAppConfigService.existsCode(code);
    }
}