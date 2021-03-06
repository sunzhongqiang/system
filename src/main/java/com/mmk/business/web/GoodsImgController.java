/*
 * 
 *  商品相册Controller 创建于 2016-10-12 11:54:23 版权归作者和作者当前组织所有
 */
package com.mmk.business.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.mmk.business.condition.GoodsImgCondition;
import com.mmk.business.model.GoodsImg;
import com.mmk.business.service.GoodsImgService;
import com.mmk.common.BaseController;
import com.mmk.common.model.EasyPageable;
import com.mmk.common.model.GridData;
import com.mmk.common.model.ResultMsg;

/**
*@Title: GoodsImgController
*@Description: 商品相册 的web控制层
*@author huguangling  胡广玲
*/
@RestController
public class GoodsImgController extends BaseController {
    
    @Resource 
    private GoodsImgService goodsImgService;

    /**
     * 跳转至列表页面
     * @return 返回页面以及页面模型
     */
    @RequestMapping("/goodsImg/list")
    public ModelAndView list(){
        log.info("商品相册列表查询");
        ModelAndView modelAndView = new ModelAndView("goodsImg/list");
        return  modelAndView;
    }
    
    
    /**
     * 加载表格数据 用户
     * 
     * @param goodsImgCondition 用户查询参数
     * @param pageable 分页参数
     * @return 查询所得数据
     */
    @RequestMapping("/goodsImg/gridData")
    @ResponseBody
    public GridData<GoodsImg> loadList(GoodsImgCondition goodsImgCondition, EasyPageable pageable){
        log.info("获取商品相册列表数据");
        Page<GoodsImg> goodsImgPage = goodsImgService.list(goodsImgCondition,pageable.pageable());   
        GridData<GoodsImg> grid = new GridData<GoodsImg>(goodsImgPage);
        return grid;
    }
    
    /**
     * 新增页面
     * @return 跳转到商品相册新增页面
     */
    @RequestMapping("/goodsImg/add")
    public ModelAndView addPage(){
        ModelAndView modelAndView = new ModelAndView("goodsImg/form");
        modelAndView.addObject("goodsImg", new GoodsImg());
        return modelAndView;
    }
    
    /**
     * 跳转到编辑页面
     * @param goodsImg  跳转到编辑页面
     */ 
    @RequestMapping("/goodsImg/edit")
    public ModelAndView editPage(GoodsImg goodsImg){
        log.info("商品相册编辑页面");
        goodsImg = goodsImgService.find(goodsImg.getId());
        ModelAndView modelAndView = new ModelAndView("goodsImg/form");
        modelAndView.addObject("goodsImg", goodsImg);
        return modelAndView ;
    }
    
    
    /**
     * 商品相册数据保存方法
     * @param goodsImg 要保存的数据
     * @return goodsImg 保存后的数据
     */
    @RequestMapping("/goodsImg/save")
    @ResponseBody
    public ResultMsg save(GoodsImg goodsImg){
        log.info("商品相册保存");
        try {
            goodsImgService.save(goodsImg);
        } catch (Exception e) {
            return new ResultMsg(false,"商品相册保存失败");
        }
        return new ResultMsg(true,"商品相册保存成功");
    }
    
   
    
    /**
     * 跳转至详细信息页面
     * @param goodsImg 参数
     * @return 详情数据
     */ 
    @RequestMapping("/goodsImg/details")
    @ResponseBody
    public GoodsImg details(GoodsImg goodsImg){
        log.info("商品相册详细信息");
        goodsImg = goodsImgService.find(goodsImg.getId());
        return goodsImg;
    }
    
    /**
     * 删除数据操作组方法
     * @param page goodsImg
     * @return
     */
    @RequestMapping("/goodsImg/delete")
    public ResultMsg delete(GoodsImg goodsImg){
        log.info("商品相册删除");
        try {
            goodsImgService.delete(goodsImg);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return new ResultMsg(false, "删除失败");
        }
        return new ResultMsg(true,"删除成功"); 
    }
    
    /**
     * 批量删除数据操作组方法
     * @param page goodsImg
     * @return ture or false 如果成功返回true ,出现错误返回false
     */
    @RequestMapping("/goodsImg/deleteAll")
    public boolean delete(List<GoodsImg> goodsImgList){
        log.info("商品相册批量删除");
        try {
            goodsImgService.delete(goodsImgList);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return false;
        }
        return true; 
    }
    
}