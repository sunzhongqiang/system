/*
 * 
 *  团收藏Controller 创建于 2016-10-12 11:54:23 版权归作者和作者当前组织所有
 */
package com.mmk.business.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.mmk.business.condition.FavoriteCondition;
import com.mmk.business.model.Favorite;
import com.mmk.business.service.FavoriteService;
import com.mmk.common.BaseController;
import com.mmk.common.model.EasyPageable;
import com.mmk.common.model.GridData;
import com.mmk.common.model.ResultMsg;

/**
*@Title: FavoriteController
*@Description: 团收藏 的web控制层
*@author huguangling 胡广玲
*/
@RestController
public class FavoriteController extends BaseController {
    
    @Resource 
    private FavoriteService favoriteService;

    /**
     * 跳转至列表页面
     * @return 返回页面以及页面模型
     */
    @RequestMapping("/favorite/list")
    public ModelAndView list(){
        log.info("团收藏列表查询");
        ModelAndView modelAndView = new ModelAndView("favorite/list");
        return  modelAndView;
    }
    
    
    /**
     * 加载表格数据 用户
     * 
     * @param favoriteCondition
     *            用户查询参数
     * @param pageable
     *            分页参数
     * @return 查询所得数据
     */
    @RequestMapping("/favorite/gridData")
    @ResponseBody
    public GridData<Favorite> loadList(FavoriteCondition favoriteCondition, EasyPageable pageable){
        log.info("获取团收藏列表数据");
        Page<Favorite> favoritePage = favoriteService.list(favoriteCondition,pageable.pageable());   
        GridData<Favorite> grid = new GridData<Favorite>(favoritePage);
        return grid;
    }
    
    /**
     * 新增页面
     * @return 跳转到团收藏新增页面
     */
    @RequestMapping("/favorite/add")
    public ModelAndView addPage(){
        ModelAndView modelAndView = new ModelAndView("favorite/form");
        modelAndView.addObject("favorite", new Favorite());
        return modelAndView;
    }
    
    /**
     * 跳转到编辑页面
     * @param favorite  跳转到编辑页面
     */ 
    @RequestMapping("/favorite/edit")
    public ModelAndView editPage(Favorite favorite){
        log.info("团收藏编辑页面");
        favorite = favoriteService.find(favorite.getId());
        ModelAndView modelAndView = new ModelAndView("favorite/form");
        modelAndView.addObject("favorite", favorite);
        return modelAndView ;
    }
    
    
    /**
     * 团收藏数据保存方法
     * @param favorite 要保存的数据
     * @return favorite 保存后的数据
     */
    @RequestMapping("/favorite/save")
    @ResponseBody
    public ResultMsg save(Favorite favorite){
        log.info("团收藏保存");
        try {
            favoriteService.save(favorite);
        } catch (Exception e) {
            return new ResultMsg(false,"团收藏保存失败");
        }
        return new ResultMsg(true,"团收藏保存成功");
    }
    
   
    
    /**
     * 跳转至详细信息页面
     * @param favorite 参数
     * @return 详情数据
     */ 
    @RequestMapping("/favorite/details")
    @ResponseBody
    public Favorite details(Favorite favorite){
        log.info("团收藏详细信息");
        favorite = favoriteService.find(favorite.getId());
        return favorite;
    }
    
    /**
     * 删除数据操作组方法
     * @param page favorite
     * @return
     */
    @RequestMapping("/favorite/delete")
    public ResultMsg delete(Favorite favorite){
        log.info("团收藏删除");
        try {
            favoriteService.delete(favorite);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return new ResultMsg(false, "删除失败");
        }
        return new ResultMsg(true,"删除成功"); 
    }
    
    /**
     * 批量删除数据操作组方法
     * @param page favorite
     * @return ture or false 如果成功返回true ,出现错误返回false
     */
    @RequestMapping("/favorite/deleteAll")
    public boolean delete(List<Favorite> favoriteList){
        log.info("团收藏批量删除");
        try {
            favoriteService.delete(favoriteList);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return false;
        }
        return true; 
    }
    
}