/*
 * 
 *  广告Controller 创建于 2016-10-12 11:54:23 版权归作者和作者当前组织所有
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
import com.mmk.business.service.AdService;
import com.mmk.business.model.Ad;
import com.mmk.business.condition.AdCondition;

/**
*@Title: AdController
*@Description: 广告 的web控制层
*@author huguangling 胡广玲
*/
@RestController
public class AdController extends BaseController {
    
    @Resource 
    private AdService adService;

    /**
     * 跳转至列表页面
     * @return 返回页面以及页面模型
     */
    @RequestMapping("/ad/list")
    public ModelAndView list(){
        log.info("广告列表查询");
        ModelAndView modelAndView = new ModelAndView("ad/list");
        return  modelAndView;
    }
    
    
    /**
     * 加载表格数据 用户
     * 
     * @param adCondition
     *            用户查询参数
     * @param pageable
     *            分页参数
     * @return 查询所得数据
     */
    @RequestMapping("/ad/gridData")
    @ResponseBody
    public GridData<Ad> loadList(AdCondition adCondition, EasyPageable pageable){
        log.info("获取广告列表数据");
        Page<Ad> adPage = adService.list(adCondition,pageable.pageable());   
        GridData<Ad> grid = new GridData<Ad>(adPage);
        return grid;
    }
    
    /**
     * 新增页面
     * @return 跳转到广告新增页面
     */
    @RequestMapping("/ad/add")
    public ModelAndView addPage(){
        ModelAndView modelAndView = new ModelAndView("ad/form");
        modelAndView.addObject("ad", new Ad());
        return modelAndView;
    }
    
    /**
     * 跳转到编辑页面
     * @param ad  跳转到编辑页面
     */ 
    @RequestMapping("/ad/edit")
    public ModelAndView editPage(Ad ad){
        log.info("广告编辑页面");
        ad = adService.find(ad.getAdId());
        ModelAndView modelAndView = new ModelAndView("ad/form");
        modelAndView.addObject("ad", ad);
        return modelAndView ;
    }
    
    
    /**
     * 广告数据保存方法
     * @param ad 要保存的数据
     * @return ad 保存后的数据
     */
    @RequestMapping("/ad/save")
    @ResponseBody
    public ResultMsg save(Ad ad){
        log.info("广告保存");
        try {
            adService.save(ad);
        } catch (Exception e) {
            return new ResultMsg(false,"广告保存失败");
        }
        return new ResultMsg(true,"广告保存成功");
    }
    
   
    
    /**
     * 跳转至详细信息页面
     * @param ad 参数
     * @return 详情数据
     */ 
    @RequestMapping("/ad/details")
    @ResponseBody
    public Ad details(Ad ad){
        log.info("广告详细信息");
        ad = adService.find(ad.getAdId());
        return ad;
    }
    
    /**
     * 删除数据操作组方法
     * @param page ad
     * @return
     */
    @RequestMapping("/ad/delete")
    public ResultMsg delete(Ad ad){
        log.info("广告删除");
        try {
            adService.delete(ad);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return new ResultMsg(false, "删除失败");
        }
        return new ResultMsg(true,"删除成功"); 
    }
    
    /**
     * 批量删除数据操作组方法
     * @param page ad
     * @return ture or false 如果成功返回true ,出现错误返回false
     */
    @RequestMapping("/ad/deleteAll")
    public boolean delete(List<Ad> adList){
        log.info("广告批量删除");
        try {
            adService.delete(adList);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return false;
        }
        return true; 
    }
    
    /**
     * 跳转至详细信息页面
     * @param  positionId 检查字段是否存在
     * @return  true or false
     */ 
    @RequestMapping("/ad/positionId/exist")
    @ResponseBody
    public boolean existsPositionId(Long positionId){
        log.info("检测广告是否存在  positionId");
        return adService.existsPositionId(positionId);
    }
}