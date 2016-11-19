/*
 * 
 *  商品 位置 关系表Controller 创建于 2016-10-12 11:54:23 版权归作者和作者当前组织所有
 */
package com.mmk.business.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.mmk.business.condition.RecommendGoodsCondition;
import com.mmk.business.model.RecommendGoods;
import com.mmk.business.service.RecommendGoodsService;
import com.mmk.common.BaseController;
import com.mmk.common.model.EasyPageable;
import com.mmk.common.model.GridData;
import com.mmk.common.model.ResultMsg;

/**
*@Title: RecommendGoodsController
*@Description: 商品 位置 关系表 的web控制层
*@author huguangling 胡广玲
*/
@RestController
public class RecommendGoodsController extends BaseController {
    
    @Resource 
    private RecommendGoodsService recommendGoodsService;

    /**
     * 跳转至列表页面
     * @return 返回页面以及页面模型
     */
    @RequestMapping("/recommendGoods/list")
    public ModelAndView list(){
        log.info("商品 位置 关系表列表查询");
        ModelAndView modelAndView = new ModelAndView("recommendGoods/list");
        return  modelAndView;
    }
    
    
    /**
     * 加载表格数据 用户
     * 
     * @param recommendGoodsCondition 用户查询参数
     * @param pageable 分页参数
     * @return 查询所得数据
     */
    @RequestMapping("/recommendGoods/gridData")
    @ResponseBody
    public GridData<RecommendGoods> loadList(RecommendGoodsCondition recommendGoodsCondition, EasyPageable pageable){
        log.info("获取商品 位置 关系表列表数据");
        Page<RecommendGoods> recommendGoodsPage = recommendGoodsService.list(recommendGoodsCondition,pageable.pageable());   
        GridData<RecommendGoods> grid = new GridData<RecommendGoods>(recommendGoodsPage);
        return grid;
    }
    

    
    /**
     * 新增页面
     * @return 跳转到商品 位置 关系表新增页面
     */
    @RequestMapping("/recommendGoods/add")
    public ModelAndView addPage(){
        ModelAndView modelAndView = new ModelAndView("recommendGoods/form");
        modelAndView.addObject("recommendGoods", new RecommendGoods());
        return modelAndView;
    }
    
    /**
     * 跳转到编辑页面
     * @param recommendGoods  跳转到编辑页面
     */ 
    @RequestMapping("/recommendGoods/edit")
    public ModelAndView editPage(RecommendGoods recommendGoods){
        log.info("商品 位置 关系表编辑页面");
        recommendGoods = recommendGoodsService.find(recommendGoods.getId());
        ModelAndView modelAndView = new ModelAndView("recommendGoods/form");
        modelAndView.addObject("recommendGoods", recommendGoods);
        return modelAndView ;
    }
  
    /**
     * 商品 位置 关系表数据保存方法
     * @param recommendGoods 要保存的数据
     * @return recommendGoods 保存后的数据
     */
    @RequestMapping("/recommendGoods/addRecomm")
    @ResponseBody
    public ResultMsg addRecomm(Long positionId,Long goodId){
        log.info("推荐商品 ");
        try {
        	RecommendGoods recommendGoods = recommendGoodsService.findByPositionId(positionId,goodId);
        	if(recommendGoods == null){
        		recommendGoods = new RecommendGoods();
        		recommendGoods.setGoodId(goodId);
        		recommendGoods.setPositionId(positionId);
            	recommendGoods.setOrderby(50L);
            	recommendGoodsService.save(recommendGoods);
        	}else{
        		return new ResultMsg(false,"商品 重复推荐");
        	}
        	
        } catch (Exception e) {
            return new ResultMsg(false,"商品推荐失败");
        }
        return new ResultMsg(true,"商品推荐成功");
    }
    
    /**
     * 商品 位置 关系表数据保存方法
     * @param recommendGoods 要保存的数据
     * @return recommendGoods 保存后的数据
     */
    @RequestMapping("/recommendGoods/cancleRecomm")
    @ResponseBody
    public ResultMsg cancleRecomm(Long positionId,Long goodId){
        log.info("取消推荐商品 ");
        try {
        	RecommendGoods recommendGoods = recommendGoodsService.findByPositionId(positionId,goodId);
        	recommendGoodsService.delete(recommendGoods);
        	
        } catch (Exception e) {
            return new ResultMsg(false,"商品取消推荐失败");
        }
        return new ResultMsg(true,"商品取消推荐成功");
    }
    
    /**
     * 商品 位置 关系表数据保存方法
     * @param recommendGoods 要保存的数据
     * @return recommendGoods 保存后的数据
     */
    @RequestMapping("/recommendGoods/save")
    @ResponseBody
    public ResultMsg save(RecommendGoods recommendGoods){
        log.info("商品 位置 关系表保存");
        try {
            recommendGoodsService.save(recommendGoods);
        } catch (Exception e) {
            return new ResultMsg(false,"商品 位置 关系表保存失败");
        }
        return new ResultMsg(true,"商品 位置 关系表保存成功");
    }
    
    /**
     * 商品 排序保存方法
     * @param recommendGoods 要保存的数据
     * @return recommendGoods 保存后的数据
     */
    @RequestMapping("/recommendGoods/saveOrder")
    @ResponseBody
    public ResultMsg saveOrder(Long id, Long orderby){
        log.info("推荐商品排序保存");
        RecommendGoods recomm =  recommendGoodsService.findById(id);
        recomm.setOrderby(orderby);
        recommendGoodsService.save(recomm);
        return new ResultMsg(true,"推荐商品的排序保存成功");
    }
    
    
    /**
     * 跳转至详细信息页面
     * @param recommendGoods 参数
     * @return 详情数据
     */ 
    @RequestMapping("/recommendGoods/details")
    @ResponseBody
    public RecommendGoods details(RecommendGoods recommendGoods){
        log.info("商品 位置 关系表详细信息");
        recommendGoods = recommendGoodsService.find(recommendGoods.getId());
        return recommendGoods;
    }
    
    /**
     * 删除数据操作组方法
     * @param page recommendGoods
     * @return
     */
    @RequestMapping("/recommendGoods/delete")
    public ResultMsg delete(RecommendGoods recommendGoods){
        log.info("商品 位置 关系表删除");
        try {
            recommendGoodsService.delete(recommendGoods);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return new ResultMsg(false, "删除失败");
        }
        return new ResultMsg(true,"删除成功"); 
    }
    
    /**
     * 批量删除数据操作组方法
     * @param page recommendGoods
     * @return ture or false 如果成功返回true ,出现错误返回false
     */
    @RequestMapping("/recommendGoods/deleteAll")
    public boolean delete(List<RecommendGoods> recommendGoodsList){
        log.info("商品 位置 关系表批量删除");
        try {
            recommendGoodsService.delete(recommendGoodsList);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return false;
        }
        return true; 
    }
    
    /**
     * 跳转到编辑页面
     * @param refund  跳转到编辑页面
     */ 
    @RequestMapping("/recommendGoods/editOrder")
    public ModelAndView editOrder(Long id){
        log.info("商品排序修改");
        RecommendGoods  recommendGoods = recommendGoodsService.find(id);
        ModelAndView modelAndView = new ModelAndView("recommendGoods/editOrder");
        modelAndView.addObject("recommendGoods", recommendGoods);
        return modelAndView ;
    }
    
}