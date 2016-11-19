/*
 * 
 *  位置表Controller 创建于 2016-10-12 11:54:23 版权归作者和作者当前组织所有
 */
package com.mmk.business.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.mmk.business.condition.RecommendPositionCondition;
import com.mmk.business.model.RecommendGoods;
import com.mmk.business.model.RecommendGroup;
import com.mmk.business.model.RecommendPosition;
import com.mmk.business.service.RecommendGoodsService;
import com.mmk.business.service.RecommendGroupService;
import com.mmk.business.service.RecommendPositionService;
import com.mmk.common.BaseController;
import com.mmk.common.model.EasyPageable;
import com.mmk.common.model.GridData;
import com.mmk.common.model.ResultMsg;

/**
*@Title: RecommendPositionController
*@Description: 位置表 的web控制层
*@author huguangling 胡广玲
*/
@RestController
public class RecommendPositionController extends BaseController {
    
    @Resource 
    private RecommendPositionService recommendPositionService;
    @Resource 
    private RecommendGoodsService recommendGoodService;
    @Resource 
    private RecommendGroupService recommendGroupService;

    /**
     * 跳转至列表页面
     * @return 返回页面以及页面模型
     */
    @RequestMapping("/recommendPosition/list")
    public ModelAndView list(){
        log.info("位置表列表查询");
        ModelAndView modelAndView = new ModelAndView("recommendPosition/list");
        return  modelAndView;
    }
 
    /**
     * 加载表格数据 用户
     * 
     * @param recommendPositionCondition　用户查询参数
     * @param pageable　分页参数
     * @return 查询所得数据
     */
    @RequestMapping("/recommendPosition/gridData")
    @ResponseBody
    public GridData<RecommendPosition> loadList(RecommendPositionCondition recommendPositionCondition, EasyPageable pageable){
        log.info("获取位置表列表数据");
        Page<RecommendPosition> recommendPositionPage = recommendPositionService.list(recommendPositionCondition,pageable.pageable());   
        GridData<RecommendPosition> grid = new GridData<RecommendPosition>(recommendPositionPage);
        return grid;
    }
    
    /**
     * 新增页面
     * @return 跳转到位置表新增页面
     */
    @RequestMapping("/recommendPosition/add")
    public ModelAndView addPage(){
        ModelAndView modelAndView = new ModelAndView("recommendPosition/form");
        modelAndView.addObject("recommendPosition", new RecommendPosition());
        return modelAndView;
    }
    
    /**
     * 跳转到编辑页面
     * @param recommendPosition  跳转到编辑页面
     */ 
    @RequestMapping("/recommendPosition/edit")
    public ModelAndView editPage(RecommendPosition recommendPosition){
        log.info("位置表编辑页面");
        recommendPosition = recommendPositionService.find(recommendPosition.getId());
        ModelAndView modelAndView = new ModelAndView("recommendPosition/form");
        modelAndView.addObject("recommendPosition", recommendPosition);
        return modelAndView ;
    }   
    
    /**
     * 位置表数据保存方法
     * @param recommendPosition 要保存的数据
     * @return recommendPosition 保存后的数据
     */
    @RequestMapping("/recommendPosition/save")
    @ResponseBody
    public ResultMsg save(RecommendPosition recommendPosition){
        log.info("位置表保存");
        try {
            recommendPositionService.save(recommendPosition);
        } catch (Exception e) {
            return new ResultMsg(false,"位置编码重复，请修改！");
        }
        return new ResultMsg(true,"位置表保存成功");
    }
  
    /**
     * 跳转至详细信息页面
     * @param recommendPosition 参数
     * @return 详情数据
     */ 
    @RequestMapping("/recommendPosition/details")
    @ResponseBody
    public RecommendPosition details(RecommendPosition recommendPosition){
        log.info("位置表详细信息");
        recommendPosition = recommendPositionService.find(recommendPosition.getId());
        return recommendPosition;
    }
    
    /**
     * 删除数据操作组方法
     * @param page recommendPosition
     * @return
     */
    @RequestMapping("/recommendPosition/delete")
    public ResultMsg delete(RecommendPosition recommendPosition){
        log.info("位置表删除");
        try {
        	List<RecommendGroup> recommendGroupList = recommendGroupService.findByPosition(recommendPosition.getId());
        	for (RecommendGroup recommendGroup : recommendGroupList) {
        		recommendGroupService.delete(recommendGroup);
        	}
        	List<RecommendGoods> recommendGoodsList = recommendGoodService.findByPosition(recommendPosition.getId());
        	for(RecommendGoods recommendGoods : recommendGoodsList){
        		recommendGoodService.delete(recommendGoods);
        	}
        	
            recommendPositionService.delete(recommendPosition);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return new ResultMsg(false, "删除失败");
        }
        return new ResultMsg(true,"删除成功"); 
    }
    
    /**
     * 批量删除数据操作组方法
     * @param page recommendPosition
     * @return ture or false 如果成功返回true ,出现错误返回false
     */
    @RequestMapping("/recommendPosition/deleteAll")
    public boolean delete(List<RecommendPosition> recommendPositionList){
        log.info("位置表批量删除");
        try {
            recommendPositionService.delete(recommendPositionList);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return false;
        }
        return true; 
    }
    
}