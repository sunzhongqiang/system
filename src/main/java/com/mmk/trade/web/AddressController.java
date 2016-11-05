/*
 * 
 *  地址管理Controller 创建于 2016-10-12 11:54:23 版权归作者和作者当前组织所有
 */
package com.mmk.trade.web;

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
import com.mmk.trade.service.AddressService;
import com.mmk.trade.model.Address;
import com.mmk.trade.condition.AddressCondition;

/**
*@Title: AddressController
*@Description: 地址管理 的web控制层
*@author huguangling 胡广玲
*/
@RestController
public class AddressController extends BaseController {
    
    @Resource 
    private AddressService addressService;

    /**
     * 跳转至列表页面
     * @return 返回页面以及页面模型
     */
    @RequestMapping("/address/list")
    public ModelAndView list(){
        log.info("地址管理列表查询");
        ModelAndView modelAndView = new ModelAndView("address/list");
        return  modelAndView;
    }
    
    
    /**
     * 加载表格数据 用户
     * 
     * @param addressCondition
     *            用户查询参数
     * @param pageable
     *            分页参数
     * @return 查询所得数据
     */
    @RequestMapping("/address/gridData")
    @ResponseBody
    public GridData<Address> loadList(AddressCondition addressCondition, EasyPageable pageable){
        log.info("获取地址管理列表数据");
        Page<Address> addressPage = addressService.list(addressCondition,pageable.pageable());   
        GridData<Address> grid = new GridData<Address>(addressPage);
        return grid;
    }
    
    /**
     * 新增页面
     * @return 跳转到地址管理新增页面
     */
    @RequestMapping("/address/add")
    public ModelAndView addPage(){
        ModelAndView modelAndView = new ModelAndView("address/form");
        modelAndView.addObject("address", new Address());
        return modelAndView;
    }
    
    /**
     * 跳转到编辑页面
     * @param address  跳转到编辑页面
     */ 
    @RequestMapping("/address/edit")
    public ModelAndView editPage(Address address){
        log.info("地址管理编辑页面");
        address = addressService.find(address.getId());
        ModelAndView modelAndView = new ModelAndView("address/form");
        modelAndView.addObject("address", address);
        return modelAndView ;
    }
    
    
    /**
     * 地址管理数据保存方法
     * @param address 要保存的数据
     * @return address 保存后的数据
     */
    @RequestMapping("/address/save")
    @ResponseBody
    public ResultMsg save(Address address){
        log.info("地址管理保存");
        try {
            addressService.save(address);
        } catch (Exception e) {
            return new ResultMsg(false,"地址管理保存失败");
        }
        return new ResultMsg(true,"地址管理保存成功");
    }
    
   
    
    /**
     * 跳转至详细信息页面
     * @param address 参数
     * @return 详情数据
     */ 
    @RequestMapping("/address/details")
    @ResponseBody
    public Address details(Address address){
        log.info("地址管理详细信息");
        address = addressService.find(address.getId());
        return address;
    }
    
    /**
     * 删除数据操作组方法
     * @param page address
     * @return
     */
    @RequestMapping("/address/delete")
    public ResultMsg delete(Address address){
        log.info("地址管理删除");
        try {
            addressService.delete(address);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return new ResultMsg(false, "删除失败");
        }
        return new ResultMsg(true,"删除成功"); 
    }
    
    /**
     * 批量删除数据操作组方法
     * @param page address
     * @return ture or false 如果成功返回true ,出现错误返回false
     */
    @RequestMapping("/address/deleteAll")
    public boolean delete(List<Address> addressList){
        log.info("地址管理批量删除");
        try {
            addressService.delete(addressList);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return false;
        }
        return true; 
    }
    
    /**
     * 跳转至详细信息页面
     * @param  userId 检查字段是否存在
     * @return  true or false
     */ 
    @RequestMapping("/address/userId/exist")
    @ResponseBody
    public boolean existsUserId(Long userId){
        log.info("检测地址管理是否存在  userId");
        return addressService.existsUserId(userId);
    }
}