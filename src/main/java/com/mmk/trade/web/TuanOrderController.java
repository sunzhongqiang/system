/*
 * 
 *  订单管理Controller 创建于 2016-10-12 11:54:23 版权归作者和作者当前组织所有
 */
package com.mmk.trade.web;

import java.util.Date;
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
import com.mmk.system.model.User;
import com.mmk.system.service.UserService;
import com.mmk.trade.condition.OrderCondition;
import com.mmk.trade.model.TuanOrder;
import com.mmk.trade.model.Shipping;
import com.mmk.trade.service.TuanOrderService;
import com.mmk.trade.service.ShippingService;

/**
*@Title: OrderController
*@Description: 订单管理 的web控制层
*@author huguangling 胡广玲
*/
@RestController
public class TuanOrderController extends BaseController {
    
    @Resource 
    private TuanOrderService orderService;
    @Resource 
    private ShippingService shippingService;
    @Resource 
    private UserService userService;

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
     * @param orderCondition 用户查询参数        
     * @param pageable 分页参数        
     * @return 查询所得数据
     */
    @RequestMapping("/order/gridData")
    @ResponseBody
    public GridData<TuanOrder> loadList(OrderCondition orderCondition, EasyPageable pageable){
        log.info("获取订单管理列表数据");
        Page<TuanOrder> orderPage = orderService.list(orderCondition,pageable.pageable());
        GridData<TuanOrder> grid = new GridData<TuanOrder>(orderPage);
        return grid;
    }
    
    /**
     * 加载表格数据 用户
     * 
     * @param id 订单ID          
     * @param shippingId 物流ID
     * @param invoiceNo 物流单号          
     * @return 查询所得数据
     */
    @RequestMapping("/order/addShipping")
    @ResponseBody
    public ResultMsg addShipping(Long id,Long shippingId, String invoiceNo){
        log.info("更改物流状态");
        TuanOrder order =  orderService.findById(id);

        Shipping shipping = shippingService.findById(shippingId);
        order.setInvoiceNo(invoiceNo);
        order.setShippingName(shipping.getShippingName());
        order.setOrderStatus(3l);
        order.setShippingTime(new Date());
        order.setShippingId(shippingId);
        orderService.save(order);
        return new ResultMsg(true,"物流信息添加成功"); 
    }
    
    /**
     * 新增页面
     * @return 跳转到订单管理新增页面
     */
    @RequestMapping("/order/add")
    public ModelAndView addPage(){
        ModelAndView modelAndView = new ModelAndView("order/form");
        modelAndView.addObject("order", new TuanOrder());
        return modelAndView;
    } 
  
    /**
     * 发货
     * @param id 订单ID
     */ 
    @RequestMapping("/order/shippingpage")
    public ModelAndView shippingPage(Long id){
        log.info("发货页面");
        TuanOrder order = orderService.findById(id);
        ModelAndView modelAndView = new ModelAndView("order/shipping");
        if(order == null){
        	order = new TuanOrder();
        }
        modelAndView.addObject("order", order);
        modelAndView.addObject("id", id);
        return modelAndView ;
    }  
    
    /**
     * 查看订单详情页面
     * @param id 订单ID
     */ 
    @RequestMapping("/order/orderDetail")
    public ModelAndView orderDetail(Long id){
        log.info("查看订单详情页面");
        ModelAndView modelAndView = new ModelAndView("order/orderDetail");
        TuanOrder order = orderService.findById(id);
        User user = userService.find(order.getUserId());
        modelAndView.addObject("order", order);
        modelAndView.addObject("user", user);
        return modelAndView ;
    } 
    
    /**
     * 跳转到编辑页面
     * @param order  跳转到编辑页面
     */ 
    @RequestMapping("/order/edit")
    public ModelAndView editPage(TuanOrder order){
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
    public ResultMsg save(TuanOrder order){
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
    public TuanOrder details(TuanOrder order){
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
    public ResultMsg delete(TuanOrder order){
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
    public boolean delete(List<TuanOrder> orderList){
        log.info("订单管理批量删除");
        try {
            orderService.delete(orderList);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return false;
        }
        return true; 
    }
    
}