/*
 * 
 *  区域管理Controller 创建于 2016-10-12 11:54:23 版权归作者和作者当前组织所有
 */
package com.mmk.system.web;

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
import com.mmk.system.condition.RegionCondition;
import com.mmk.system.model.Region;
import com.mmk.system.service.RegionService;

/**
*@Title: RegionController
*@Description: 区域管理 的web控制层
*@author huguangling 胡广玲
*/
@RestController
public class RegionController extends BaseController {
    
    @Resource 
    private RegionService regionService;

    /**
     * 跳转至列表页面
     * @return 返回页面以及页面模型
     */
    @RequestMapping("/region/list")
    public ModelAndView list(){
        log.info("区域管理列表查询");
        ModelAndView modelAndView = new ModelAndView("region/list");
        return  modelAndView;
    }
    
    
    /**
     * 加载表格数据 用户
     * 
     * @param regionCondition 用户查询参数
     * @param pageable 分页参数
     * @return 查询所得数据
     */
    @RequestMapping("/region/gridData")
    @ResponseBody
    public GridData<Region> loadList(RegionCondition regionCondition, EasyPageable pageable){
        log.info("获取区域管理列表数据");
        Page<Region> regionPage = regionService.list(regionCondition,pageable.pageable());   
        GridData<Region> grid = new GridData<Region>(regionPage);
        return grid;
    }
    
    /**
     * 加载表格数据 用户
     * 
     * @param regionCondition 用户查询参数
     * @param pageable 分页参数
     * @return 查询所得数据
     */
    @RequestMapping("/region/allRegion")
    @ResponseBody
    public List<Region> allRegion(RegionCondition regionCondition){
        log.info("获取区域管理列表数据");
        List<Region> regions = regionService.list(regionCondition);   
        return regions;
    }
    
    
    /**
     * 加载表格数据 用户
     * 
     * @param regionCondition 用户查询参数
     * @param pageable 分页参数
     * @return 查询所得数据
     */
    @RequestMapping("/region/loadRegionByParentId")
    @ResponseBody
    public List<Region> loadRegionByParentId(Long parentId){
        log.info("获取区域管理列表数据");
        List<Region> regions = regionService.loadByParentId(parentId);
        return regions;
    }
    
    
    /**
     * 新增页面
     * @return 跳转到区域管理新增页面
     */
    @RequestMapping("/region/add")
    public ModelAndView addPage(){
        ModelAndView modelAndView = new ModelAndView("region/form");
        modelAndView.addObject("region", new Region());
        return modelAndView;
    }
    
    /**
     * 跳转到编辑页面
     * @param region  跳转到编辑页面
     */ 
    @RequestMapping("/region/edit")
    public ModelAndView editPage(Region region){
        log.info("区域管理编辑页面");
        region = regionService.find(region.getRegionId());
        ModelAndView modelAndView = new ModelAndView("region/form");
        modelAndView.addObject("region", region);
        return modelAndView ;
    }
   
    /**
     * 区域管理数据保存方法
     * @param region 要保存的数据
     * @return region 保存后的数据
     */
    @RequestMapping("/region/save")
    @ResponseBody
    public ResultMsg save(Region region){
        log.info("区域管理保存");
        try {
            regionService.save(region);
        } catch (Exception e) {
            return new ResultMsg(false,"区域管理保存失败");
        }
        return new ResultMsg(true,"区域管理保存成功");
    }
  
    /**
     * 跳转至详细信息页面
     * @param region 参数
     * @return 详情数据
     */ 
    @RequestMapping("/region/details")
    @ResponseBody
    public Region details(Region region){
        log.info("区域管理详细信息");
        region = regionService.find(region.getRegionId());
        return region;
    }
    
    /**
     * 删除数据操作组方法
     * @param page region
     * @return
     */
    @RequestMapping("/region/delete")
    public ResultMsg delete(Region region){
        log.info("区域管理删除");
        try {
            regionService.delete(region);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return new ResultMsg(false, "删除失败");
        }
        return new ResultMsg(true,"删除成功"); 
    }
    
    /**
     * 批量删除数据操作组方法
     * @param page region
     * @return ture or false 如果成功返回true ,出现错误返回false
     */
    @RequestMapping("/region/deleteAll")
    public boolean delete(List<Region> regionList){
        log.info("区域管理批量删除");
        try {
            regionService.delete(regionList);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return false;
        }
        return true; 
    }
    
}