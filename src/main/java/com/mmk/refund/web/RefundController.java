/*
 * 
 *  退款表Controller 创建于 2016-10-12 11:54:23 版权归作者和作者当前组织所有
 */
package com.mmk.refund.web;

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
import com.mmk.refund.condition.RefundCondition;
import com.mmk.refund.model.Refund;
import com.mmk.refund.service.RefundService;
import com.mmk.system.model.User;
import com.mmk.system.service.UserService;
import com.mmk.trade.model.Order;
import com.mmk.trade.service.OrderService;

/**
*@Title: RefundController
*@Description: 退款表 的web控制层
*@author huguangling 胡广玲
*/
@RestController
public class RefundController extends BaseController {
    
    @Resource 
    private RefundService refundService;
    @Resource 
    private OrderService orderService;
    @Resource 
    private UserService userService;

    /**
     * 跳转至列表页面
     * @return 返回页面以及页面模型
     */
    @RequestMapping("/refund/list")
    public ModelAndView list(){
        log.info("退款表列表查询");
        ModelAndView modelAndView = new ModelAndView("refund/list");
        return  modelAndView;
    }
    
    
    /**
     * 加载表格数据 用户
     * 
     * @param refundCondition
     *            用户查询参数
     * @param pageable
     *            分页参数
     * @return 查询所得数据
     */
    @RequestMapping("/refund/gridData")
    @ResponseBody
    public GridData<Refund> loadList(RefundCondition refundCondition, EasyPageable pageable){
        log.info("获取退款表列表数据");
        Page<Refund> refundPage = refundService.list(refundCondition,pageable.pageable());   
        GridData<Refund> grid = new GridData<Refund>(refundPage);
//        Page<Order> orderPage = orderService.list(orderCondition,pageable.pageable());
//        GridData<Order> grid = new GridData<Order>(orderPage);
//        ModelAndView modelAndView = new ModelAndView("refund/list");
        return grid;
    }
    
    /**
     * 拒绝退货页面
     * @param id 退款退货ID
     */ 
    @RequestMapping("/refund/refundReason")
    public ModelAndView refundReason(Long id){
        log.info("拒绝退货页面货页面");
        Refund refund = refundService.find(id);
        ModelAndView modelAndView = new ModelAndView("/refund/refundReason");
        if(refund == null){
        	refund = new Refund();
        }
        modelAndView.addObject("refund", refund);
        modelAndView.addObject("id", id);
        return modelAndView ;
    } 
    
    /**
     * 拒绝退款退货的理由
     * @param id 退款退货ID
     */ 
    @RequestMapping("/refund/saveReason")
    public ResultMsg saveReason(Long id, String refuseReason){
        log.info("拒绝退款退货的理由");
        Refund refund = refundService.find(id);
        refund.setRefuseReason(refuseReason);
        refund.setRefundStatus("5");
        refundService.save(refund);
        return  new ResultMsg(true,"拒绝退款退货成功");
    } 
    
    /**
     * 同意退款退货
     * @param id 退款退货ID
     */ 
    @RequestMapping("/refund/refuseAgree")
    public ResultMsg refuseAgree(Long id){
        log.info("同意退款退货");
        Refund refund = refundService.find(id);
        if("0".equals(refund.getHasGoodsReturn())){
            refund.setRefundStatus("4");     	
        } else {
            refund.setRefundStatus("2");
        }
        refundService.save(refund);
        return  new ResultMsg(true,"同意退款退货成功");
    } 
    
    /**
     * 查看退款详情页面
     * @param id 订单ID
     */ 
    @RequestMapping("/refund/refundDetail")
    public ModelAndView refundDetail(Long id){
        log.info("查看订单详情页面");
        ModelAndView modelAndView = new ModelAndView("/refund/refundDetail");
        Order order = orderService.findById(id);
        User user = userService.find(order.getUserId());
        Refund refund = refundService.findByOrderID(id);
        modelAndView.addObject("order", order);
        modelAndView.addObject("refund", refund);
        modelAndView.addObject("user", user);
        
        return modelAndView ;
    } 
    
    /**
     * 新增页面
     * @return 跳转到退款表新增页面
     */
    @RequestMapping("/refund/add")
    public ModelAndView addPage(){
        ModelAndView modelAndView = new ModelAndView("refund/form");
        modelAndView.addObject("refund", new Refund());
        return modelAndView;
    }
    
    /**
     * 跳转到编辑页面
     * @param refund  跳转到编辑页面
     */ 
    @RequestMapping("/refund/edit")
    public ModelAndView editPage(Refund refund){
        log.info("退款表编辑页面");
        refund = refundService.find(refund.getId());
        ModelAndView modelAndView = new ModelAndView("refund/form");
        modelAndView.addObject("refund", refund);
        return modelAndView ;
    }
    

    
    /**
     * 退款表数据保存方法
     * @param refund 要保存的数据
     * @return refund 保存后的数据
     */
    @RequestMapping("/refund/save")
    @ResponseBody
    public ResultMsg save(Refund refund){
        log.info("退款表保存");
        try {
            refundService.save(refund);
        } catch (Exception e) {
            return new ResultMsg(false,"退款表保存失败");
        }
        return new ResultMsg(true,"退款表保存成功");
    }
    
   
    
    /**
     * 跳转至详细信息页面
     * @param refund 参数
     * @return 详情数据
     */ 
    @RequestMapping("/refund/details")
    @ResponseBody
    public Refund details(Refund refund){
        log.info("退款表详细信息");
        refund = refundService.find(refund.getId());
        return refund;
    }
    
    /**
     * 删除数据操作组方法
     * @param page refund
     * @return
     */
    @RequestMapping("/refund/delete")
    public ResultMsg delete(Refund refund){
        log.info("退款表删除");
        try {
            refundService.delete(refund);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return new ResultMsg(false, "删除失败");
        }
        return new ResultMsg(true,"删除成功"); 
    }
    
    /**
     * 批量删除数据操作组方法
     * @param page refund
     * @return ture or false 如果成功返回true ,出现错误返回false
     */
    @RequestMapping("/refund/deleteAll")
    public boolean delete(List<Refund> refundList){
        log.info("退款表批量删除");
        try {
            refundService.delete(refundList);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return false;
        }
        return true; 
    }
    
}