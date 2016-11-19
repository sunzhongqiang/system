/*
 * 
 *  拼团推荐管理Controller 创建于 2016-10-12 11:54:23 版权归作者和作者当前组织所有
 */
package com.mmk.business.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.mmk.business.condition.RecommendGroupCondition;
import com.mmk.business.model.RecommendGroup;
import com.mmk.business.service.RecommendGroupService;
import com.mmk.common.BaseController;
import com.mmk.common.model.EasyPageable;
import com.mmk.common.model.GridData;
import com.mmk.common.model.ResultMsg;

/**
*@Title: RecommendGroupController
*@Description: 拼团推荐管理 的web控制层
*@author huguangling 胡广玲
*/
@RestController
public class RecommendGroupController extends BaseController {
    
    @Resource 
    private RecommendGroupService recommendGroupService;

    /**
     * 跳转至列表页面
     * @return 返回页面以及页面模型
     */
    @RequestMapping("/recommendGroup/list")
    public ModelAndView list(){
        log.info("拼团推荐管理列表查询");
        ModelAndView modelAndView = new ModelAndView("recommendGroup/list");
        return  modelAndView;
    }   
    
    /**
     * 加载表格数据 用户
     * 
     * @param recommendGroupCondition　 用户查询参数
     * @param pageable　分页参数
     * @return 查询所得数据
     */
    @RequestMapping("/recommendGroup/gridData")
    @ResponseBody
    public GridData<RecommendGroup> loadList(RecommendGroupCondition recommendGroupCondition, EasyPageable pageable){
        log.info("获取拼团推荐管理列表数据");
        Page<RecommendGroup> recommendGroupPage = recommendGroupService.list(recommendGroupCondition,pageable.pageable());   
        GridData<RecommendGroup> grid = new GridData<RecommendGroup>(recommendGroupPage);
        return grid;
    }
    
    /**
     * 新增页面
     * @return 跳转到拼团推荐管理新增页面
     */
    @RequestMapping("/recommendGroup/add")
    public ModelAndView addPage(){
        ModelAndView modelAndView = new ModelAndView("recommendGroup/form");
        modelAndView.addObject("recommendGroup", new RecommendGroup());
        return modelAndView;
    }
    
    /**
     * 跳转到编辑页面
     * @param recommendGroup  跳转到编辑页面
     */ 
    @RequestMapping("/recommendGroup/edit")
    public ModelAndView editPage(RecommendGroup recommendGroup){
        log.info("拼团推荐管理编辑页面");
        recommendGroup = recommendGroupService.find(recommendGroup.getId());
        ModelAndView modelAndView = new ModelAndView("recommendGroup/form");
        modelAndView.addObject("recommendGroup", recommendGroup);
        return modelAndView ;
    }
       
    /**
     * 拼团推荐管理数据保存方法
     * @param recommendGroup 要保存的数据
     * @return recommendGroup 保存后的数据
     */
    @RequestMapping("/recommendGroup/save")
    @ResponseBody
    public ResultMsg save(RecommendGroup recommendGroup){
        log.info("拼团推荐管理保存");
        try {
            recommendGroupService.save(recommendGroup);
        } catch (Exception e) {
            return new ResultMsg(false,"拼团推荐管理保存失败");
        }
        return new ResultMsg(true,"拼团推荐管理保存成功");
    }
    
    /**
     * 跳转至详细信息页面
     * @param recommendGroup 参数
     * @return 详情数据
     */ 
    @RequestMapping("/recommendGroup/details")
    @ResponseBody
    public RecommendGroup details(RecommendGroup recommendGroup){
        log.info("拼团推荐管理详细信息");
        recommendGroup = recommendGroupService.find(recommendGroup.getId());
        return recommendGroup;
    }
    
    /**
     * 删除数据操作组方法
     * @param page recommendGroup
     * @return
     */
    @RequestMapping("/recommendGroup/delete")
    public ResultMsg delete(RecommendGroup recommendGroup){
        log.info("拼团推荐管理删除");
        try {
            recommendGroupService.delete(recommendGroup);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return new ResultMsg(false, "删除失败");
        }
        return new ResultMsg(true,"删除成功"); 
    }
    
    /**
     * 批量删除数据操作组方法
     * @param page recommendGroup
     * @return ture or false 如果成功返回true ,出现错误返回false
     */
    @RequestMapping("/recommendGroup/deleteAll")
    public boolean delete(List<RecommendGroup> recommendGroupList){
        log.info("拼团推荐管理批量删除");
        try {
            recommendGroupService.delete(recommendGroupList);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return false;
        }
        return true; 
    }
    
    /**
     * 商品 位置 关系表数据保存方法
     * @param recommendGoods 要保存的数据
     * @return recommendGoods 保存后的数据
     */
    @RequestMapping("/recommendGroup/cancleRecomm")
    @ResponseBody
    public ResultMsg cancleRecomm(Long positionId,Long goodId){
        log.info("取消推荐商品 ");
        try {
        	RecommendGroup recommendGroup = recommendGroupService.findByPositionId(positionId,goodId);
        	recommendGroupService.delete(recommendGroup);
        	
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
    @RequestMapping("/recommendGroup/addRecomm")
    @ResponseBody
    public ResultMsg addRecomm(Long positionId,Long goodId){
        log.info("推荐商品 ");
        try {
        	RecommendGroup recommendGroup = recommendGroupService.findByPositionId(positionId,goodId);
        	if(recommendGroup == null){
        		recommendGroup = new RecommendGroup();
        		recommendGroup.setGoodId(goodId);
        		recommendGroup.setPositionId(positionId);
        		recommendGroup.setOrderby(50L);
        		recommendGroupService.save(recommendGroup);
        	}else{
        		return new ResultMsg(false,"商品 重复推荐");
        	}
        	
        } catch (Exception e) {
            return new ResultMsg(false,"商品推荐失败");
        }
        return new ResultMsg(true,"商品推荐成功");
    }
    
    /**
     * 跳转到编辑页面
     * @param refund  跳转到编辑页面
     */ 
    @RequestMapping("/recommendGroup/editOrder")
    public ModelAndView editOrder(Long id){
        log.info("商品排序修改");
        RecommendGroup  recommendGoods = recommendGroupService.find(id);
        ModelAndView modelAndView = new ModelAndView("recommendGroup/editOrder");
        modelAndView.addObject("recommendGoods", recommendGoods);
        return modelAndView ;
    }
    
    /**
     * 商品 排序保存方法
     * @param recommendGroup 要保存的数据
     * @return recommendGroup 保存后的数据
     */
    @RequestMapping("/recommendGroup/saveOrder")
    @ResponseBody
    public ResultMsg saveOrder(Long id, Long orderby){
        log.info("推荐商品排序保存");
        RecommendGroup recomm =  recommendGroupService.findById(id);
        recomm.setOrderby(orderby);
        recommendGroupService.save(recomm);
        return new ResultMsg(true,"推荐商品的排序保存成功");
    }
}