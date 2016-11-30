/*
 * 
 *  商品或者团的关注Controller 创建于 2016-10-12 11:54:23 版权归作者和作者当前组织所有
 */
package com.mmk.business.web;

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
import com.mmk.business.service.AttentionService;
import com.mmk.business.model.Attention;
import com.mmk.business.condition.AttentionCondition;

/**
*@Title: AttentionController
*@Description: 商品或者团的关注 的web控制层
*@author huguangling 胡广玲
*/
@RestController
public class AttentionController extends BaseController {
    
    @Resource 
    private AttentionService attentionService;

    /**
     * 跳转至列表页面
     * @return 返回页面以及页面模型
     */
    @RequestMapping("/attention/list")
    public ModelAndView list(){
        log.info("商品或者团的关注列表查询");
        ModelAndView modelAndView = new ModelAndView("attention/list");
        return  modelAndView;
    }
    
    
    /**
     * 加载表格数据 用户
     * 
     * @param attentionCondition
     *            用户查询参数
     * @param pageable
     *            分页参数
     * @return 查询所得数据
     */
    @RequestMapping("/attention/gridData")
    @ResponseBody
    public GridData<Attention> loadList(AttentionCondition attentionCondition, EasyPageable pageable){
        log.info("获取商品或者团的关注列表数据");
        Page<Attention> attentionPage = attentionService.list(attentionCondition,pageable.pageable());   
        GridData<Attention> grid = new GridData<Attention>(attentionPage);
        return grid;
    }
    
    /**
     * 新增页面
     * @return 跳转到商品或者团的关注新增页面
     */
    @RequestMapping("/attention/add")
    public ModelAndView addPage(){
        ModelAndView modelAndView = new ModelAndView("attention/form");
        modelAndView.addObject("attention", new Attention());
        return modelAndView;
    }
    
    /**
     * 跳转到编辑页面
     * @param attention  跳转到编辑页面
     */ 
    @RequestMapping("/attention/edit")
    public ModelAndView editPage(Attention attention){
        log.info("商品或者团的关注编辑页面");
        attention = attentionService.find(attention.getId());
        ModelAndView modelAndView = new ModelAndView("attention/form");
        modelAndView.addObject("attention", attention);
        return modelAndView ;
    }
    
    
    /**
     * 商品或者团的关注数据保存方法
     * @param attention 要保存的数据
     * @return attention 保存后的数据
     */
    @RequestMapping("/attention/save")
    @ResponseBody
    public ResultMsg save(Attention attention){
        log.info("商品或者团的关注保存");
        try {
            attentionService.save(attention);
        } catch (Exception e) {
            return new ResultMsg(false,"商品或者团的关注保存失败");
        }
        return new ResultMsg(true,"商品或者团的关注保存成功");
    }
    
   
    
    /**
     * 跳转至详细信息页面
     * @param attention 参数
     * @return 详情数据
     */ 
    @RequestMapping("/attention/details")
    @ResponseBody
    public Attention details(Attention attention){
        log.info("商品或者团的关注详细信息");
        attention = attentionService.find(attention.getId());
        return attention;
    }
    
    /**
     * 删除数据操作组方法
     * @param page attention
     * @return
     */
    @RequestMapping("/attention/delete")
    public ResultMsg delete(Attention attention){
        log.info("商品或者团的关注删除");
        try {
            attentionService.delete(attention);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return new ResultMsg(false, "删除失败");
        }
        return new ResultMsg(true,"删除成功"); 
    }
    
    /**
     * 批量删除数据操作组方法
     * @param page attention
     * @return ture or false 如果成功返回true ,出现错误返回false
     */
    @RequestMapping("/attention/deleteAll")
    public boolean delete(List<Attention> attentionList){
        log.info("商品或者团的关注批量删除");
        try {
            attentionService.delete(attentionList);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return false;
        }
        return true; 
    }
    
}