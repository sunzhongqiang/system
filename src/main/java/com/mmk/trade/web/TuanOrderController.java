/*
 * 
 *  团订单管理Controller 创建于 2016-10-12 11:54:23 版权归作者和作者当前组织所有
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
import com.mmk.trade.service.TuanOrderService;
import com.mmk.trade.model.TuanOrder;
import com.mmk.trade.condition.TuanOrderCondition;

/**
*@Title: TuanOrderController
*@Description: 团订单管理 的web控制层
*@author huguangling 胡广玲
*/
@RestController
public class TuanOrderController extends BaseController {
    
    @Resource 
    private TuanOrderService tuanOrderService;

    /**
     * 跳转至列表页面
     * @return 返回页面以及页面模型
     */
    @RequestMapping("/tuanOrder/list")
    public ModelAndView list(){
        log.info("团订单管理列表查询");
        ModelAndView modelAndView = new ModelAndView("tuanOrder/list");
        return  modelAndView;
    }
    
    
    /**
     * 加载表格数据 用户
     * 
     * @param tuanOrderCondition
     *            用户查询参数
     * @param pageable
     *            分页参数
     * @return 查询所得数据
     */
    @RequestMapping("/tuanOrder/gridData")
    @ResponseBody
    public GridData<TuanOrder> loadList(TuanOrderCondition tuanOrderCondition, EasyPageable pageable){
        log.info("获取团订单管理列表数据");
        Page<TuanOrder> tuanOrderPage = tuanOrderService.list(tuanOrderCondition,pageable.pageable());   
        GridData<TuanOrder> grid = new GridData<TuanOrder>(tuanOrderPage);
        return grid;
    }
    
    /**
     * 新增页面
     * @return 跳转到团订单管理新增页面
     */
    @RequestMapping("/tuanOrder/add")
    public ModelAndView addPage(){
        ModelAndView modelAndView = new ModelAndView("tuanOrder/form");
        modelAndView.addObject("tuanOrder", new TuanOrder());
        return modelAndView;
    }
    
    /**
     * 跳转到编辑页面
     * @param tuanOrder  跳转到编辑页面
     */ 
    @RequestMapping("/tuanOrder/edit")
    public ModelAndView editPage(TuanOrder tuanOrder){
        log.info("团订单管理编辑页面");
        tuanOrder = tuanOrderService.find(tuanOrder.getId());
        ModelAndView modelAndView = new ModelAndView("tuanOrder/form");
        modelAndView.addObject("tuanOrder", tuanOrder);
        return modelAndView ;
    }
    
    
    /**
     * 团订单管理数据保存方法
     * @param tuanOrder 要保存的数据
     * @return tuanOrder 保存后的数据
     */
    @RequestMapping("/tuanOrder/save")
    @ResponseBody
    public ResultMsg save(TuanOrder tuanOrder){
        log.info("团订单管理保存");
        try {
            tuanOrderService.save(tuanOrder);
        } catch (Exception e) {
            return new ResultMsg(false,"团订单管理保存失败");
        }
        return new ResultMsg(true,"团订单管理保存成功");
    }
    
   
    
    /**
     * 跳转至详细信息页面
     * @param tuanOrder 参数
     * @return 详情数据
     */ 
    @RequestMapping("/tuanOrder/details")
    @ResponseBody
    public TuanOrder details(TuanOrder tuanOrder){
        log.info("团订单管理详细信息");
        tuanOrder = tuanOrderService.find(tuanOrder.getId());
        return tuanOrder;
    }
    
    /**
     * 删除数据操作组方法
     * @param page tuanOrder
     * @return
     */
    @RequestMapping("/tuanOrder/delete")
    public ResultMsg delete(TuanOrder tuanOrder){
        log.info("团订单管理删除");
        try {
            tuanOrderService.delete(tuanOrder);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return new ResultMsg(false, "删除失败");
        }
        return new ResultMsg(true,"删除成功"); 
    }
    
    /**
     * 批量删除数据操作组方法
     * @param page tuanOrder
     * @return ture or false 如果成功返回true ,出现错误返回false
     */
    @RequestMapping("/tuanOrder/deleteAll")
    public boolean delete(List<TuanOrder> tuanOrderList){
        log.info("团订单管理批量删除");
        try {
            tuanOrderService.delete(tuanOrderList);
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
    @RequestMapping("/tuanOrder/id/exist")
    @ResponseBody
    public boolean existsId(Long id){
        log.info("检测团订单管理是否存在  id");
        return tuanOrderService.existsId(id);
    }
}