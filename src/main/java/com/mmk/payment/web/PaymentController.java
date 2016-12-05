/*
 * 
 *  支付方式Controller 创建于 2016-10-12 11:54:23 版权归作者和作者当前组织所有
 */
package com.mmk.payment.web;

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
import com.mmk.payment.service.PaymentService;
import com.mmk.payment.model.Payment;
import com.mmk.payment.condition.PaymentCondition;

/**
*@Title: PaymentController
*@Description: 支付方式 的web控制层
*@author 孙中强 sunzhongqiang
*/
@RestController
public class PaymentController extends BaseController {
    
    @Resource 
    private PaymentService paymentService;

    /**
     * 跳转至列表页面
     * @return 返回页面以及页面模型
     */
    @RequestMapping("/payment/list")
    public ModelAndView list(){
        log.info("支付方式列表查询");
        ModelAndView modelAndView = new ModelAndView("payment/list");
        return  modelAndView;
    }
    
    
    /**
     * 加载表格数据 用户
     * 
     * @param paymentCondition
     *            用户查询参数
     * @param pageable
     *            分页参数
     * @return 查询所得数据
     */
    @RequestMapping("/payment/gridData")
    @ResponseBody
    public GridData<Payment> loadList(PaymentCondition paymentCondition, EasyPageable pageable){
        log.info("获取支付方式列表数据");
        Page<Payment> paymentPage = paymentService.list(paymentCondition,pageable.pageable());   
        GridData<Payment> grid = new GridData<Payment>(paymentPage);
        return grid;
    }
    
    /**
     * 新增页面
     * @return 跳转到支付方式新增页面
     */
    @RequestMapping("/payment/add")
    public ModelAndView addPage(){
        ModelAndView modelAndView = new ModelAndView("payment/form");
        modelAndView.addObject("payment", new Payment());
        return modelAndView;
    }
    
    /**
     * 跳转到编辑页面
     * @param payment  跳转到编辑页面
     */ 
    @RequestMapping("/payment/edit")
    public ModelAndView editPage(Payment payment){
        log.info("支付方式编辑页面");
        payment = paymentService.find(payment.getId());
        ModelAndView modelAndView = new ModelAndView("payment/form");
        modelAndView.addObject("payment", payment);
        return modelAndView ;
    }
    
    
    /**
     * 支付方式数据保存方法
     * @param payment 要保存的数据
     * @return payment 保存后的数据
     */
    @RequestMapping("/payment/save")
    @ResponseBody
    public ResultMsg save(Payment payment){
        log.info("支付方式保存");
        try {
            paymentService.save(payment);
        } catch (Exception e) {
            return new ResultMsg(false,"支付方式保存失败");
        }
        return new ResultMsg(true,"支付方式保存成功");
    }
    
   
    
    /**
     * 跳转至详细信息页面
     * @param payment 参数
     * @return 详情数据
     */ 
    @RequestMapping("/payment/details")
    @ResponseBody
    public Payment details(Payment payment){
        log.info("支付方式详细信息");
        payment = paymentService.find(payment.getId());
        return payment;
    }
    
    /**
     * 删除数据操作组方法
     * @param page payment
     * @return
     */
    @RequestMapping("/payment/delete")
    public ResultMsg delete(Payment payment){
        log.info("支付方式删除");
        try {
            paymentService.delete(payment);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return new ResultMsg(false, "删除失败");
        }
        return new ResultMsg(true,"删除成功"); 
    }
    
    /**
     * 批量删除数据操作组方法
     * @param page payment
     * @return ture or false 如果成功返回true ,出现错误返回false
     */
    @RequestMapping("/payment/deleteAll")
    public boolean delete(List<Payment> paymentList){
        log.info("支付方式批量删除");
        try {
            paymentService.delete(paymentList);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return false;
        }
        return true; 
    }
    
}