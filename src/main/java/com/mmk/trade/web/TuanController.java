/*
 * 
 *  拼团管理Controller 创建于 2016-10-12 11:54:23 版权归作者和作者当前组织所有
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
import com.mmk.trade.service.TuanService;
import com.mmk.trade.model.Tuan;
import com.mmk.trade.condition.TuanCondition;

/**
*@Title: TuanController
*@Description: 拼团管理 的web控制层
*@author huguangling 胡广玲
*/
@RestController
public class TuanController extends BaseController {
    
    @Resource 
    private TuanService tuanService;

    /**
     * 跳转至列表页面
     * @return 返回页面以及页面模型
     */
    @RequestMapping("/tuan/list")
    public ModelAndView list(){
        log.info("拼团管理列表查询");
        ModelAndView modelAndView = new ModelAndView("tuan/list");
        return  modelAndView;
    }
    
    
    /**
     * 加载表格数据 用户
     * 
     * @param tuanCondition
     *            用户查询参数
     * @param pageable
     *            分页参数
     * @return 查询所得数据
     */
    @RequestMapping("/tuan/gridData")
    @ResponseBody
    public GridData<Tuan> loadList(TuanCondition tuanCondition, EasyPageable pageable){
        log.info("获取拼团管理列表数据");
        Page<Tuan> tuanPage = tuanService.list(tuanCondition,pageable.pageable());   
        GridData<Tuan> grid = new GridData<Tuan>(tuanPage);
        return grid;
    }
    
    /**
     * 新增页面
     * @return 跳转到拼团管理新增页面
     */
    @RequestMapping("/tuan/add")
    public ModelAndView addPage(){
        ModelAndView modelAndView = new ModelAndView("tuan/form");
        modelAndView.addObject("tuan", new Tuan());
        return modelAndView;
    }
    
    /**
     * 跳转到编辑页面
     * @param tuan  跳转到编辑页面
     */ 
    @RequestMapping("/tuan/edit")
    public ModelAndView editPage(Tuan tuan){
        log.info("拼团管理编辑页面");
        tuan = tuanService.find(tuan.getId());
        ModelAndView modelAndView = new ModelAndView("tuan/form");
        modelAndView.addObject("tuan", tuan);
        return modelAndView ;
    }
    
    
    /**
     * 拼团管理数据保存方法
     * @param tuan 要保存的数据
     * @return tuan 保存后的数据
     */
    @RequestMapping("/tuan/save")
    @ResponseBody
    public ResultMsg save(Tuan tuan){
        log.info("拼团管理保存");
        try {
            tuanService.save(tuan);
        } catch (Exception e) {
            return new ResultMsg(false,"拼团管理保存失败");
        }
        return new ResultMsg(true,"拼团管理保存成功");
    }
    
   
    
    /**
     * 跳转至详细信息页面
     * @param tuan 参数
     * @return 详情数据
     */ 
    @RequestMapping("/tuan/details")
    @ResponseBody
    public Tuan details(Tuan tuan){
        log.info("拼团管理详细信息");
        tuan = tuanService.find(tuan.getId());
        return tuan;
    }
    
    /**
     * 删除数据操作组方法
     * @param page tuan
     * @return
     */
    @RequestMapping("/tuan/delete")
    public ResultMsg delete(Tuan tuan){
        log.info("拼团管理删除");
        try {
            tuanService.delete(tuan);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return new ResultMsg(false, "删除失败");
        }
        return new ResultMsg(true,"删除成功"); 
    }
    
    /**
     * 批量删除数据操作组方法
     * @param page tuan
     * @return ture or false 如果成功返回true ,出现错误返回false
     */
    @RequestMapping("/tuan/deleteAll")
    public boolean delete(List<Tuan> tuanList){
        log.info("拼团管理批量删除");
        try {
            tuanService.delete(tuanList);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return false;
        }
        return true; 
    }
    
    /**
     * 跳转至详细信息页面
     * @param  orderId 检查字段是否存在
     * @return  true or false
     */ 
    @RequestMapping("/tuan/orderId/exist")
    @ResponseBody
    public boolean existsOrderId(Long orderId){
        log.info("检测拼团管理是否存在  orderId");
        return tuanService.existsOrderId(orderId);
    }
}