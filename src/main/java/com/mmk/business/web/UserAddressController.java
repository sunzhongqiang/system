/*
 * 
 *  会员地址Controller 创建于 2016-10-12 11:54:23 版权归作者和作者当前组织所有
 */
package com.mmk.business.web;

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
import com.mmk.business.service.UserAddressService;
import com.mmk.business.model.UserAddress;
import com.mmk.business.condition.UserAddressCondition;

/**
*@Title: UserAddressController
*@Description: 会员地址 的web控制层
*@author huguangling 胡广玲
*/
@RestController
public class UserAddressController extends BaseController {
    
    @Resource 
    private UserAddressService userAddressService;

    /**
     * 跳转至列表页面
     * @return 返回页面以及页面模型
     */
    @RequestMapping("/userAddress/list")
    public ModelAndView list(){
        log.info("会员地址列表查询");
        ModelAndView modelAndView = new ModelAndView("userAddress/list");
        return  modelAndView;
    }
    
    
    /**
     * 加载表格数据 用户
     * 
     * @param userAddressCondition
     *            用户查询参数
     * @param pageable
     *            分页参数
     * @return 查询所得数据
     */
    @RequestMapping("/userAddress/gridData")
    @ResponseBody
    public GridData<UserAddress> loadList(UserAddressCondition userAddressCondition, EasyPageable pageable){
        log.info("获取会员地址列表数据");
        Page<UserAddress> userAddressPage = userAddressService.list(userAddressCondition,pageable.pageable());   
        GridData<UserAddress> grid = new GridData<UserAddress>(userAddressPage);
        return grid;
    }
    
    /**
     * 新增页面
     * @return 跳转到会员地址新增页面
     */
    @RequestMapping("/userAddress/add")
    public ModelAndView addPage(){
        ModelAndView modelAndView = new ModelAndView("userAddress/form");
        modelAndView.addObject("userAddress", new UserAddress());
        return modelAndView;
    }
    
    /**
     * 跳转到编辑页面
     * @param userAddress  跳转到编辑页面
     */ 
    @RequestMapping("/userAddress/edit")
    public ModelAndView editPage(UserAddress userAddress){
        log.info("会员地址编辑页面");
        userAddress = userAddressService.find(userAddress.getId());
        ModelAndView modelAndView = new ModelAndView("userAddress/form");
        modelAndView.addObject("userAddress", userAddress);
        return modelAndView ;
    }
    
    
    /**
     * 会员地址数据保存方法
     * @param userAddress 要保存的数据
     * @return userAddress 保存后的数据
     */
    @RequestMapping("/userAddress/save")
    @ResponseBody
    public ResultMsg save(UserAddress userAddress){
        log.info("会员地址保存");
        try {
            userAddressService.save(userAddress);
        } catch (Exception e) {
            return new ResultMsg(false,"会员地址保存失败");
        }
        return new ResultMsg(true,"会员地址保存成功");
    }
    
   
    
    /**
     * 跳转至详细信息页面
     * @param userAddress 参数
     * @return 详情数据
     */ 
    @RequestMapping("/userAddress/details")
    @ResponseBody
    public UserAddress details(UserAddress userAddress){
        log.info("会员地址详细信息");
        userAddress = userAddressService.find(userAddress.getId());
        return userAddress;
    }
    
    /**
     * 删除数据操作组方法
     * @param page userAddress
     * @return
     */
    @RequestMapping("/userAddress/delete")
    public ResultMsg delete(UserAddress userAddress){
        log.info("会员地址删除");
        try {
            userAddressService.delete(userAddress);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return new ResultMsg(false, "删除失败");
        }
        return new ResultMsg(true,"删除成功"); 
    }
    
    /**
     * 批量删除数据操作组方法
     * @param page userAddress
     * @return ture or false 如果成功返回true ,出现错误返回false
     */
    @RequestMapping("/userAddress/deleteAll")
    public boolean delete(List<UserAddress> userAddressList){
        log.info("会员地址批量删除");
        try {
            userAddressService.delete(userAddressList);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return false;
        }
        return true; 
    }
    
}