/*
 * 
 *  物流管理Controller 创建于 2016-10-12 11:54:23 版权归作者和作者当前组织所有
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
import com.mmk.trade.service.ShippingService;
import com.mmk.trade.model.Shipping;
import com.mmk.trade.condition.ShippingCondition;

/**
*@Title: ShippingController
*@Description: 物流管理 的web控制层
*@author huguangling 胡广玲
*/
@RestController
public class ShippingController extends BaseController {
    
    @Resource 
    private ShippingService shippingService;

    /**
     * 跳转至列表页面
     * @return 返回页面以及页面模型
     */
    @RequestMapping("/shipping/list")
    public ModelAndView list(){
        log.info("物流管理列表查询");
        ModelAndView modelAndView = new ModelAndView("shipping/list");
        return  modelAndView;
    }
    
    
    /**
     * 加载表格数据 用户
     * 
     * @param shippingCondition
     *            用户查询参数
     * @param pageable
     *            分页参数
     * @return 查询所得数据
     */
    @RequestMapping("/shipping/gridData")
    @ResponseBody
    public GridData<Shipping> loadList(ShippingCondition shippingCondition, EasyPageable pageable){
        log.info("获取物流管理列表数据");
        Page<Shipping> shippingPage = shippingService.list(shippingCondition,pageable.pageable());   
        GridData<Shipping> grid = new GridData<Shipping>(shippingPage);
        return grid;
    }
    
    /**
     * 新增页面
     * @return 跳转到物流管理新增页面
     */
    @RequestMapping("/shipping/add")
    public ModelAndView addPage(){
        ModelAndView modelAndView = new ModelAndView("shipping/form");
        modelAndView.addObject("shipping", new Shipping());
        return modelAndView;
    }
    
    /**
     * 跳转到编辑页面
     * @param shipping  跳转到编辑页面
     */ 
    @RequestMapping("/shipping/edit")
    public ModelAndView editPage(Shipping shipping){
        log.info("物流管理编辑页面");
        shipping = shippingService.find(shipping.getId());
        ModelAndView modelAndView = new ModelAndView("shipping/form");
        modelAndView.addObject("shipping", shipping);
        return modelAndView ;
    }
    
    
    /**
     * 物流管理数据保存方法
     * @param shipping 要保存的数据
     * @return shipping 保存后的数据
     */
    @RequestMapping("/shipping/save")
    @ResponseBody
    public ResultMsg save(Shipping shipping){
        log.info("物流管理保存");
        try {
            shippingService.save(shipping);
        } catch (Exception e) {
            return new ResultMsg(false,"物流管理保存失败");
        }
        return new ResultMsg(true,"物流管理保存成功");
    }
    
   
    
    /**
     * 跳转至详细信息页面
     * @param shipping 参数
     * @return 详情数据
     */ 
    @RequestMapping("/shipping/details")
    @ResponseBody
    public Shipping details(Shipping shipping){
        log.info("物流管理详细信息");
        shipping = shippingService.find(shipping.getId());
        return shipping;
    }
    
    /**
     * 删除数据操作组方法
     * @param page shipping
     * @return
     */
    @RequestMapping("/shipping/delete")
    public ResultMsg delete(Shipping shipping){
        log.info("物流管理删除");
        try {
            shippingService.delete(shipping);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return new ResultMsg(false, "删除失败");
        }
        return new ResultMsg(true,"删除成功"); 
    }
    
    /**
     * 批量删除数据操作组方法
     * @param page shipping
     * @return ture or false 如果成功返回true ,出现错误返回false
     */
    @RequestMapping("/shipping/deleteAll")
    public boolean delete(List<Shipping> shippingList){
        log.info("物流管理批量删除");
        try {
            shippingService.delete(shippingList);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return false;
        }
        return true; 
    }
    
}