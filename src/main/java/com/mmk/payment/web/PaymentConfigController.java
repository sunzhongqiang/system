/*
 * 
 *  支付配置参数Controller 创建于 2016-10-12 11:54:23 版权归作者和作者当前组织所有
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
import com.mmk.payment.service.PaymentConfigService;
import com.mmk.payment.model.PaymentConfig;
import com.mmk.payment.condition.PaymentConfigCondition;

/**
*@Title: PaymentConfigController
*@Description: 支付配置参数 的web控制层
*@author 孙中强 sunzhongqiang
*/
@RestController
public class PaymentConfigController extends BaseController {
    
    @Resource 
    private PaymentConfigService paymentConfigService;

    /**
     * 跳转至列表页面
     * @return 返回页面以及页面模型
     */
    @RequestMapping("/paymentConfig/list")
    public ModelAndView list(){
        log.info("支付配置参数列表查询");
        ModelAndView modelAndView = new ModelAndView("paymentConfig/list");
        return  modelAndView;
    }
    
    
    /**
     * 加载表格数据 用户
     * 
     * @param paymentConfigCondition
     *            用户查询参数
     * @param pageable
     *            分页参数
     * @return 查询所得数据
     */
    @RequestMapping("/paymentConfig/gridData")
    @ResponseBody
    public GridData<PaymentConfig> loadList(PaymentConfigCondition paymentConfigCondition, EasyPageable pageable){
        log.info("获取支付配置参数列表数据");
        Page<PaymentConfig> paymentConfigPage = paymentConfigService.list(paymentConfigCondition,pageable.pageable());   
        GridData<PaymentConfig> grid = new GridData<PaymentConfig>(paymentConfigPage);
        return grid;
    }
    
    /**
     * 新增页面
     * @return 跳转到支付配置参数新增页面
     */
    @RequestMapping("/paymentConfig/add")
    public ModelAndView addPage(){
        ModelAndView modelAndView = new ModelAndView("paymentConfig/form");
        modelAndView.addObject("paymentConfig", new PaymentConfig());
        return modelAndView;
    }
    
    /**
     * 跳转到编辑页面
     * @param paymentConfig  跳转到编辑页面
     */ 
    @RequestMapping("/paymentConfig/edit")
    public ModelAndView editPage(PaymentConfig paymentConfig){
        log.info("支付配置参数编辑页面");
        paymentConfig = paymentConfigService.find(paymentConfig.getId());
        ModelAndView modelAndView = new ModelAndView("paymentConfig/form");
        modelAndView.addObject("paymentConfig", paymentConfig);
        return modelAndView ;
    }
    
    
    /**
     * 支付配置参数数据保存方法
     * @param paymentConfig 要保存的数据
     * @return paymentConfig 保存后的数据
     */
    @RequestMapping("/paymentConfig/save")
    @ResponseBody
    public ResultMsg save(PaymentConfig paymentConfig){
        log.info("支付配置参数保存");
        try {
            paymentConfigService.save(paymentConfig);
        } catch (Exception e) {
            return new ResultMsg(false,"支付配置参数保存失败");
        }
        return new ResultMsg(true,"支付配置参数保存成功");
    }
    
   
    
    /**
     * 跳转至详细信息页面
     * @param paymentConfig 参数
     * @return 详情数据
     */ 
    @RequestMapping("/paymentConfig/details")
    @ResponseBody
    public PaymentConfig details(PaymentConfig paymentConfig){
        log.info("支付配置参数详细信息");
        paymentConfig = paymentConfigService.find(paymentConfig.getId());
        return paymentConfig;
    }
    
    /**
     * 删除数据操作组方法
     * @param page paymentConfig
     * @return
     */
    @RequestMapping("/paymentConfig/delete")
    public ResultMsg delete(PaymentConfig paymentConfig){
        log.info("支付配置参数删除");
        try {
            paymentConfigService.delete(paymentConfig);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return new ResultMsg(false, "删除失败");
        }
        return new ResultMsg(true,"删除成功"); 
    }
    
    /**
     * 批量删除数据操作组方法
     * @param page paymentConfig
     * @return ture or false 如果成功返回true ,出现错误返回false
     */
    @RequestMapping("/paymentConfig/deleteAll")
    public boolean delete(List<PaymentConfig> paymentConfigList){
        log.info("支付配置参数批量删除");
        try {
            paymentConfigService.delete(paymentConfigList);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return false;
        }
        return true; 
    }
    
}