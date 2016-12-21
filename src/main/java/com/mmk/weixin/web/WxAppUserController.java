/*
 * 
 *  微信公众号的用户Controller 创建于 2016-10-12 11:54:23 版权归作者和作者当前组织所有
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
import com.mmk.weixin.condition.WxAppUserCondition;
import com.mmk.weixin.model.WxAppUser;
import com.mmk.weixin.service.WxAppUserService;

/**
*@Title: WxAppUserController
*@Description: 微信公众号的用户 的web控制层
*@author 
*/
@RestController
public class WxAppUserController extends BaseController {
    
    @Resource 
    private WxAppUserService wxAppUserService;

    /**
     * 跳转至列表页面
     * @return 返回页面以及页面模型
     */
    @RequestMapping("/weixin/wxAppUser/list")
    public ModelAndView list(){
        log.info("微信公众号的用户列表查询");
        ModelAndView modelAndView = new ModelAndView("weixin/wxAppUser/list");
        return  modelAndView;
    }
    
    
    /**
     * 加载表格数据 用户
     * 
     * @param wxAppUserCondition
     *            用户查询参数
     * @param pageable
     *            分页参数
     * @return 查询所得数据
     */
    @RequestMapping("/weixin/wxAppUser/gridData")
    @ResponseBody
    public GridData<WxAppUser> loadList(WxAppUserCondition wxAppUserCondition, EasyPageable pageable){
        log.info("获取微信公众号的用户列表数据");
        Page<WxAppUser> wxAppUserPage = wxAppUserService.list(wxAppUserCondition,pageable.pageable());   
        GridData<WxAppUser> grid = new GridData<WxAppUser>(wxAppUserPage);
        return grid;
    }
    
    /**
     * 新增页面
     * @return 跳转到微信公众号的用户新增页面
     */
    @RequestMapping("/weixin/wxAppUser/add")
    public ModelAndView addPage(){
        ModelAndView modelAndView = new ModelAndView("weixin/wxAppUser/form");
        modelAndView.addObject("wxAppUser", new WxAppUser());
        return modelAndView;
    }
    
    /**
     * 跳转到编辑页面
     * @param wxAppUser  跳转到编辑页面
     */ 
    @RequestMapping("/weixin/wxAppUser/edit")
    public ModelAndView editPage(WxAppUser wxAppUser){
        log.info("微信公众号的用户编辑页面");
        wxAppUser = wxAppUserService.find(wxAppUser.getId());
        ModelAndView modelAndView = new ModelAndView("weixin/wxAppUser/form");
        modelAndView.addObject("wxAppUser", wxAppUser);
        return modelAndView ;
    }
    
    
    /**
     * 微信公众号的用户数据保存方法
     * @param wxAppUser 要保存的数据
     * @return wxAppUser 保存后的数据
     */
    @RequestMapping("/weixin/wxAppUser/save")
    @ResponseBody
    public ResultMsg save(WxAppUser wxAppUser){
        log.info("微信公众号的用户保存");
        try {
            wxAppUserService.save(wxAppUser);
        } catch (Exception e) {
            return new ResultMsg(false,"微信公众号的用户保存失败");
        }
        return new ResultMsg(true,"微信公众号的用户保存成功");
    }
    
   
    
    /**
     * 跳转至详细信息页面
     * @param wxAppUser 参数
     * @return 详情数据
     */ 
    @RequestMapping("/weixin/wxAppUser/details")
    @ResponseBody
    public WxAppUser details(WxAppUser wxAppUser){
        log.info("微信公众号的用户详细信息");
        wxAppUser = wxAppUserService.find(wxAppUser.getId());
        return wxAppUser;
    }
    
    /**
     * 删除数据操作组方法
     * @param page wxAppUser
     * @return
     */
    @RequestMapping("/weixin/wxAppUser/delete")
    public ResultMsg delete(WxAppUser wxAppUser){
        log.info("微信公众号的用户删除");
        try {
            wxAppUserService.delete(wxAppUser);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return new ResultMsg(false, "删除失败");
        }
        return new ResultMsg(true,"删除成功"); 
    }
    
    /**
     * 批量删除数据操作组方法
     * @param page wxAppUser
     * @return ture or false 如果成功返回true ,出现错误返回false
     */
    @RequestMapping("/weixin/wxAppUser/deleteAll")
    public boolean delete(List<WxAppUser> wxAppUserList){
        log.info("微信公众号的用户批量删除");
        try {
            wxAppUserService.delete(wxAppUserList);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return false;
        }
        return true; 
    }
    
}