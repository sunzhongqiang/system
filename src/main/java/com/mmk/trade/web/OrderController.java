/*
 * 
 *  订单管理Controller 创建于 2016-10-12 11:54:23 版权归作者和作者当前组织所有
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
import com.mmk.trade.service.OrderService;
import com.mmk.trade.model.Order;
import com.mmk.trade.condition.OrderCondition;

/**
*@Title: OrderController
*@Description: 订单管理 的web控制层
*@author huguangling 胡广玲
*/
@RestController
public class OrderController extends BaseController {
    
    @Resource 
    private OrderService orderService;

    /**
     * 跳转至列表页面
     * @return 返回页面以及页面模型
     */
    @RequestMapping("/order/list")
    public ModelAndView list(){
        log.info("订单管理列表查询");
        ModelAndView modelAndView = new ModelAndView("order/list");
        return  modelAndView;
    }
    
    
    /**
     * 加载表格数据 用户
     * 
     * @param orderCondition
     *            用户查询参数
     * @param pageable
     *            分页参数
     * @return 查询所得数据
     */
    @RequestMapping("/order/gridData")
    @ResponseBody
    public GridData<Order> loadList(OrderCondition orderCondition, EasyPageable pageable){
        log.info("获取订单管理列表数据");
        Page<Order> orderPage = orderService.list(orderCondition,pageable.pageable());   
        GridData<Order> grid = new GridData<Order>(orderPage);
        return grid;
    }
    
    /**
     * 新增页面
     * @return 跳转到订单管理新增页面
     */
    @RequestMapping("/order/add")
    public ModelAndView addPage(){
        ModelAndView modelAndView = new ModelAndView("order/form");
        modelAndView.addObject("order", new Order());
        return modelAndView;
    }
    
    /**
     * 跳转到编辑页面
     * @param order  跳转到编辑页面
     */ 
    @RequestMapping("/order/edit")
    public ModelAndView editPage(Order order){
        log.info("订单管理编辑页面");
        order = orderService.find(order.getId());
        ModelAndView modelAndView = new ModelAndView("order/form");
        modelAndView.addObject("order", order);
        return modelAndView ;
    }
    
    
    /**
     * 订单管理数据保存方法
     * @param order 要保存的数据
     * @return order 保存后的数据
     */
    @RequestMapping("/order/save")
    @ResponseBody
    public ResultMsg save(Order order){
        log.info("订单管理保存");
        try {
            orderService.save(order);
        } catch (Exception e) {
            return new ResultMsg(false,"订单管理保存失败");
        }
        return new ResultMsg(true,"订单管理保存成功");
    }
    
   
    
    /**
     * 跳转至详细信息页面
     * @param order 参数
     * @return 详情数据
     */ 
    @RequestMapping("/order/details")
    @ResponseBody
    public Order details(Order order){
        log.info("订单管理详细信息");
        order = orderService.find(order.getId());
        return order;
    }
    
    /**
     * 删除数据操作组方法
     * @param page order
     * @return
     */
    @RequestMapping("/order/delete")
    public ResultMsg delete(Order order){
        log.info("订单管理删除");
        try {
            orderService.delete(order);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return new ResultMsg(false, "删除失败");
        }
        return new ResultMsg(true,"删除成功"); 
    }
    
    /**
     * 批量删除数据操作组方法
     * @param page order
     * @return ture or false 如果成功返回true ,出现错误返回false
     */
    @RequestMapping("/order/deleteAll")
    public boolean delete(List<Order> orderList){
        log.info("订单管理批量删除");
        try {
            orderService.delete(orderList);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return false;
        }
        return true; 
    }
    
    /**
     * 跳转至详细信息页面
     * @param  id 检查字段是否存在
     * @return  true or false
     */ 
    @RequestMapping("/order/id/exist")
    @ResponseBody
    public boolean existsId(Long id){
        log.info("检测订单管理是否存在  id");
        return orderService.existsId(id);
    }
}