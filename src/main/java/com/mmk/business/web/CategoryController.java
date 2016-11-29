/*
 * 
 *  商品分类Controller 创建于 2016-10-12 11:54:23 版权归作者和作者当前组织所有
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
import com.mmk.common.model.Tree;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.mmk.business.service.CategoryService;
import com.mmk.business.model.Category;
import com.mmk.business.condition.CategoryCondition;

/**
*@Title: CategoryController
*@Description: 商品分类 的web控制层
*@author 孙中强 sunzhongqiang
*/
@RestController
public class CategoryController extends BaseController {
    
    @Resource 
    private CategoryService categoryService;

    /**
     * 跳转至列表页面
     * @return 返回页面以及页面模型
     */
    @RequestMapping("/category/list")
    public ModelAndView list(){
        log.info("商品分类列表查询");
        ModelAndView modelAndView = new ModelAndView("category/list");
        return  modelAndView;
    }
    
    
    /**
     * 加载表格数据 用户
     * 
     * @param categoryCondition
     *            用户查询参数
     * @param pageable
     *            分页参数
     * @return 查询所得数据
     */
    @RequestMapping("/category/gridData")
    @ResponseBody
    public GridData<Category> loadList(CategoryCondition categoryCondition, EasyPageable pageable){
        log.info("获取商品分类列表数据");
        Page<Category> categoryPage = categoryService.list(categoryCondition,pageable.pageable());   
        GridData<Category> grid = new GridData<Category>(categoryPage);
        return grid;
    }
    /**
     * 获取treeGrid的数据
     * @param categoryCondition
     * @return 树表数据
     */
    @RequestMapping("/category/treeGrid")
    @ResponseBody
    public List<CategoryCondition> loadTreeGrid(CategoryCondition categoryCondition){
        log.info("获取商品分类列表数据");
        List<CategoryCondition> treeGrid = categoryService.treeGrid(categoryCondition);   
        return treeGrid;
    }
    
    
    /**
     * 获取tree的数据
     * @param categoryCondition
     * @return 树形返回
     */
    @RequestMapping("/category/tree")
    @ResponseBody
    public List<Tree> loadTree(CategoryCondition categoryCondition){
        log.info("获取商品分类列表数据");
        List<Tree> tree = categoryService.tree(categoryCondition);   
        return tree;
    }
    
    /**
     * 新增页面
     * @return 跳转到商品分类新增页面
     */
    @RequestMapping("/category/add")
    public ModelAndView addPage(){
        ModelAndView modelAndView = new ModelAndView("category/form");
        modelAndView.addObject("category", new Category());
        return modelAndView;
    }
    
    /**
     * 跳转到编辑页面
     * @param category  跳转到编辑页面
     */ 
    @RequestMapping("/category/edit")
    public ModelAndView editPage(Category category){
        log.info("商品分类编辑页面");
        category = categoryService.find(category.getId());
        ModelAndView modelAndView = new ModelAndView("category/form");
        modelAndView.addObject("category", category);
        return modelAndView ;
    }
    
    
    /**
     * 商品分类数据保存方法
     * @param category 要保存的数据
     * @return category 保存后的数据
     */
    @RequestMapping("/category/save")
    @ResponseBody
    public ResultMsg save(Category category){
        log.info("商品分类保存");
        try {
            categoryService.save(category);
        } catch (Exception e) {
            return new ResultMsg(false,"商品分类保存失败");
        }
        return new ResultMsg(true,"商品分类保存成功");
    }
    
   
    
    /**
     * 跳转至详细信息页面
     * @param category 参数
     * @return 详情数据
     */ 
    @RequestMapping("/category/details")
    @ResponseBody
    public Category details(Category category){
        log.info("商品分类详细信息");
        category = categoryService.find(category.getId());
        return category;
    }
    
    /**
     * 删除数据操作组方法
     * @param page category
     * @return
     */
    @RequestMapping("/category/delete")
    public ResultMsg delete(Category category){
        log.info("商品分类删除");
        try {
            categoryService.delete(category);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return new ResultMsg(false, "删除失败");
        }
        return new ResultMsg(true,"删除成功"); 
    }
    
    /**
     * 批量删除数据操作组方法
     * @param page category
     * @return ture or false 如果成功返回true ,出现错误返回false
     */
    @RequestMapping("/category/deleteAll")
    public boolean delete(List<Category> categoryList){
        log.info("商品分类批量删除");
        try {
            categoryService.delete(categoryList);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return false;
        }
        return true; 
    }
    
}