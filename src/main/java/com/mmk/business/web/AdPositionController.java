/*
 * 
 *  广告位置Controller 创建于 2016-10-12 11:54:23 版权归作者和作者当前组织所有
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
import com.mmk.business.service.AdPositionService;
import com.mmk.business.service.AdService;
import com.mmk.business.model.Ad;
import com.mmk.business.model.AdPosition;
import com.mmk.business.condition.AdPositionCondition;

/**
*@Title: AdPositionController
*@Description: 广告位置 的web控制层
*@author huguangling 胡广玲
*/
@RestController
public class AdPositionController extends BaseController {
    
    @Resource 
    private AdPositionService adPositionService;
	@Resource
	private AdService adService;

    /**
     * 跳转至列表页面
     * @return 返回页面以及页面模型
     */
    @RequestMapping("/adPosition/list")
    public ModelAndView list(){
        log.info("广告位置列表查询");
        ModelAndView modelAndView = new ModelAndView("adPosition/list");
        return  modelAndView;
    }
    
    
    /**
     * 加载表格数据 用户
     * 
     * @param adPositionCondition
     *            用户查询参数
     * @param pageable
     *            分页参数
     * @return 查询所得数据
     */
    @RequestMapping("/adPosition/gridData")
    @ResponseBody
    public GridData<AdPosition> loadList(AdPositionCondition adPositionCondition, EasyPageable pageable){
        log.info("获取广告位置列表数据");
        Page<AdPosition> adPositionPage = adPositionService.list(adPositionCondition,pageable.pageable());   
        GridData<AdPosition> grid = new GridData<AdPosition>(adPositionPage);
        return grid;
    }
    
    /**
     * 新增页面
     * @return 跳转到广告位置新增页面
     */
    @RequestMapping("/adPosition/add")
    public ModelAndView addPage(){
        ModelAndView modelAndView = new ModelAndView("adPosition/form");
        modelAndView.addObject("adPosition", new AdPosition());
        return modelAndView;
    }
    
    /**
     * 跳转到编辑页面
     * @param adPosition  跳转到编辑页面
     */ 
    @RequestMapping("/adPosition/edit")
    public ModelAndView editPage(AdPosition adPosition){
        log.info("广告位置编辑页面");
        adPosition = adPositionService.find(adPosition.getPositionId());
        ModelAndView modelAndView = new ModelAndView("adPosition/form");
        modelAndView.addObject("adPosition", adPosition);
        return modelAndView ;
    }
    
    
    /**
     * 广告位置数据保存方法
     * @param adPosition 要保存的数据
     * @return adPosition 保存后的数据
     */
    @RequestMapping("/adPosition/save")
    @ResponseBody
    public ResultMsg save(AdPosition adPosition){
        log.info("广告位置保存");
        try {
            adPositionService.save(adPosition);
        } catch (Exception e) {
            return new ResultMsg(false,"广告位置保存失败");
        }
        return new ResultMsg(true,"广告位置保存成功");
    }
    
   
    
    /**
     * 跳转至详细信息页面
     * @param adPosition 参数
     * @return 详情数据
     */ 
    @RequestMapping("/adPosition/details")
    @ResponseBody
    public AdPosition details(AdPosition adPosition){
        log.info("广告位置详细信息");
        adPosition = adPositionService.find(adPosition.getPositionId());
        return adPosition;
    }
    
    /**
     * 删除数据操作组方法
     * @param page adPosition
     * @return
     */
    @RequestMapping("/adPosition/delete")
    public ResultMsg delete(AdPosition adPosition){
        log.info("广告位置删除");
        try {
    		List<Ad> ads = adService.findAllByPositionId(adPosition.getPositionId());
    		adService.delete(ads);
            adPositionService.delete(adPosition);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return new ResultMsg(false, "删除失败");
        }
        return new ResultMsg(true,"删除成功"); 
    }
    
    /**
     * 批量删除数据操作组方法
     * @param page adPosition
     * @return ture or false 如果成功返回true ,出现错误返回false
     */
    @RequestMapping("/adPosition/deleteAll")
    public boolean delete(List<AdPosition> adPositionList){
        log.info("广告位置批量删除");
        try {
            adPositionService.delete(adPositionList);
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
    @RequestMapping("/adPosition/positionId/exist")
    @ResponseBody
    public boolean existsPositionId(Long positionId){
        log.info("检测广告位置是否存在  positionId");
        return adPositionService.existsPositionId(positionId);
    }
}