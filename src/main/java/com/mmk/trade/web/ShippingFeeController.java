/*
 * 
 *  快递地区运费Controller 创建于 2016-10-12 11:54:23 版权归作者和作者当前组织所有
 */
package com.mmk.trade.web;

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
import com.mmk.trade.condition.ShippingFeeCondition;
import com.mmk.trade.model.ShippingFee;
import com.mmk.trade.service.ShippingFeeService;

/**
*@Title: ShippingFeeController
*@Description: 快递地区运费 的web控制层
*@author huguangling 胡广玲
*/
@RestController
public class ShippingFeeController extends BaseController {
    
    @Resource 
    private ShippingFeeService shippingFeeService;

    /**
     * 跳转至列表页面
     * @return 返回页面以及页面模型
     */
    @RequestMapping("/shippingFee/list")
    public ModelAndView list(){
        log.info("快递地区运费列表查询");
        ModelAndView modelAndView = new ModelAndView("shippingFee/list");
        return  modelAndView;
    }
    
    
    /**
     * 加载表格数据 用户
     * 
     * @param shippingFeeCondition
     *            用户查询参数
     * @param pageable
     *            分页参数
     * @return 查询所得数据
     */
    @RequestMapping("/shippingFee/gridData")
    @ResponseBody
    public GridData<ShippingFee> loadList(ShippingFeeCondition shippingFeeCondition, EasyPageable pageable){
        log.info("获取快递地区运费列表数据");
        Page<ShippingFee> shippingFeePage = shippingFeeService.list(shippingFeeCondition,pageable.pageable());   
        GridData<ShippingFee> grid = new GridData<ShippingFee>(shippingFeePage);
        return grid;
    }
    
    /**
     * 新增页面
     * @return 跳转到快递地区运费新增页面
     */
    @RequestMapping("/shippingFee/add")
    public ModelAndView addPage(){
        ModelAndView modelAndView = new ModelAndView("shippingFee/form");
        modelAndView.addObject("shippingFee", new ShippingFee());
        return modelAndView;
    }
    
    /**
     * 跳转到编辑页面
     * @param shippingFee  跳转到编辑页面
     */ 
    @RequestMapping("/shippingFee/edit")
    public ModelAndView editPage(ShippingFee shippingFee){
        log.info("快递地区运费编辑页面");
        shippingFee = shippingFeeService.find(shippingFee.getId());
        ModelAndView modelAndView = new ModelAndView("shippingFee/form");
        modelAndView.addObject("shippingFee", shippingFee);
        return modelAndView ;
    }
    
    
    /**
     * 快递地区运费数据保存方法
     * @param shippingFee 要保存的数据
     * @return shippingFee 保存后的数据
     */
    @RequestMapping("/shippingFee/save")
    @ResponseBody
    public ResultMsg save(ShippingFee shippingFee){
        log.info("快递地区运费保存");
        try {
            shippingFeeService.save(shippingFee);
        } catch (Exception e) {
            return new ResultMsg(false,"快递地区运费保存失败");
        }
        return new ResultMsg(true,"快递地区运费保存成功");
    }
    
   
    
    /**
     * 跳转至详细信息页面
     * @param shippingFee 参数
     * @return 详情数据
     */ 
    @RequestMapping("/shippingFee/details")
    @ResponseBody
    public ShippingFee details(ShippingFee shippingFee){
        log.info("快递地区运费详细信息");
        shippingFee = shippingFeeService.find(shippingFee.getId());
        return shippingFee;
    }
    
    /**
     * 删除数据操作组方法
     * @param page shippingFee
     * @return
     */
    @RequestMapping("/shippingFee/delete")
    public ResultMsg delete(ShippingFee shippingFee){
        log.info("快递地区运费删除");
        try {
            shippingFeeService.delete(shippingFee);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return new ResultMsg(false, "删除失败");
        }
        return new ResultMsg(true,"删除成功"); 
    }
    
    /**
     * 批量删除数据操作组方法
     * @param page shippingFee
     * @return ture or false 如果成功返回true ,出现错误返回false
     */
    @RequestMapping("/shippingFee/deleteAll")
    public boolean delete(List<ShippingFee> shippingFeeList){
        log.info("快递地区运费批量删除");
        try {
            shippingFeeService.delete(shippingFeeList);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return false;
        }
        return true; 
    }
    
}