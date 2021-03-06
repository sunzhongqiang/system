/*
 * 
 *  商品拼团管理Controller 创建于 2016-10-12 11:54:23 版权归作者和作者当前组织所有
 */
package com.mmk.business.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.mmk.business.condition.GoodsGroupCondition;
import com.mmk.business.model.Goods;
import com.mmk.business.model.GoodsGroup;
import com.mmk.business.service.GoodsGroupService;
import com.mmk.business.service.GoodsService;
import com.mmk.common.BaseController;
import com.mmk.common.model.EasyPageable;
import com.mmk.common.model.GridData;
import com.mmk.common.model.ResultMsg;

/**
*@Title: GoodsGroupController
*@Description: 商品拼团管理 的web控制层
*@author 孙中强 sunzhongqiang
*/
@RestController
public class GoodsGroupController extends BaseController {
    
    @Resource 
    private GoodsGroupService goodsGroupService;
    @Resource 
    private GoodsService goodsService;

    /**
     * 跳转至列表页面
     * @return 返回页面以及页面模型
     */
    @RequestMapping("/goodsGroup/list")
    public ModelAndView list(){
        log.info("商品拼团管理列表查询");
        ModelAndView modelAndView = new ModelAndView("goodsGroup/list");
        return  modelAndView;
    }
    
    
    /**
     * 加载表格数据 用户
     * 
     * @param goodsGroupCondition  用户查询参数
     * @param pageable 分页参数
     * @return 查询所得数据
     */
    @RequestMapping("/goodsGroup/gridData")
    @ResponseBody
    public GridData<GoodsGroup> loadList(GoodsGroupCondition goodsGroupCondition, EasyPageable pageable){
        log.info("获取商品拼团管理列表数据");
        Page<GoodsGroup> goodsGroupPage = goodsGroupService.list(goodsGroupCondition,pageable.pageable());   
        GridData<GoodsGroup> grid = new GridData<GoodsGroup>(goodsGroupPage);
        return grid;
    }
    
    /**
     * 加载表格数据 用户
     * 
     * @param goodsGroupCondition 用户查询参数
     * @param pageable 分页参数
     * @return 查询所得数据
     */
    @RequestMapping("/goodsGroup/loadByGoods")
    @ResponseBody
    public List<GoodsGroup> loadByGoods(Long goodsId){
    	log.info("获取商品拼团管理列表数据");
        List<GoodsGroup> goodsGroupPage = goodsGroupService.findAllByGoodsId(goodsId);   
        return goodsGroupPage;
    }
    
    /**
     * 新增页面
     * @return 跳转到商品拼团管理新增页面
     */
    @RequestMapping("/goodsGroup/add")
    public ModelAndView addPage(Long goodsId){
        ModelAndView modelAndView = new ModelAndView("goodsGroup/form");
        GoodsGroup goodsGroup = new GoodsGroup();
        Goods goods = goodsService.find(goodsId);
		goodsGroup.setGoods(goods );
		
		modelAndView.addObject("goodsGroup", goodsGroup);
        
        return modelAndView;
    }
    
    /**
     * 跳转到编辑页面
     * @param goodsGroup  跳转到编辑页面
     */ 
    @RequestMapping("/goodsGroup/edit")
    public ModelAndView editPage(GoodsGroup goodsGroup){
        log.info("商品拼团管理编辑页面");
        goodsGroup = goodsGroupService.find(goodsGroup.getId());
        ModelAndView modelAndView = new ModelAndView("goodsGroup/form");
        modelAndView.addObject("goodsGroup", goodsGroup);
        return modelAndView ;
    }
    
    
    /**
     * 商品拼团管理数据保存方法
     * @param goodsGroup 要保存的数据
     * @return goodsGroup 保存后的数据
     */
    @RequestMapping("/goodsGroup/save")
    @ResponseBody
    public ResultMsg save(GoodsGroup goodsGroup){
        log.info("商品拼团管理保存");
        try {
        	goodsGroup.setGroupNum(0l);
            goodsGroupService.save(goodsGroup);
        } catch (Exception e) {
            return new ResultMsg(false,"商品拼团管理保存失败");
        }
        return new ResultMsg(true,"商品拼团管理保存成功");
    }
    
   
    
    /**
     * 跳转至详细信息页面
     * @param goodsGroup 参数
     * @return 详情数据
     */ 
    @RequestMapping("/goodsGroup/details")
    @ResponseBody
    public GoodsGroup details(GoodsGroup goodsGroup){
        log.info("商品拼团管理详细信息");
        goodsGroup = goodsGroupService.find(goodsGroup.getId());
        return goodsGroup;
    }
    
    /**
     * 删除数据操作组方法
     * @param page goodsGroup
     * @return
     */
    @RequestMapping("/goodsGroup/delete")
    public ResultMsg delete(GoodsGroup goodsGroup){
        log.info("商品拼团管理删除");
        try {
            goodsGroupService.delete(goodsGroup);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return new ResultMsg(false, "删除失败");
        }
        return new ResultMsg(true,"删除成功"); 
    }
    
    /**
     * 批量删除数据操作组方法
     * @param page goodsGroup
     * @return ture or false 如果成功返回true ,出现错误返回false
     */
    @RequestMapping("/goodsGroup/deleteAll")
    public boolean delete(List<GoodsGroup> goodsGroupList){
        log.info("商品拼团管理批量删除");
        try {
            goodsGroupService.delete(goodsGroupList);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return false;
        }
        return true; 
    }
    
    /**
     * 拼团商品推荐
     * @param pageable pageable
     * @return 跳转到商品拼团管理新增页面
     */
    @RequestMapping("/goodsGroup/goodsList")
    public GridData<GoodsGroup> goodsList(GoodsGroupCondition goodsGroupCondition,EasyPageable pageable){
    	 Page<GoodsGroup> page = goodsGroupService.list(goodsGroupCondition, pageable.pageable());
    	 GridData<GoodsGroup> goodsGroupList = new GridData<GoodsGroup>(page);
        return goodsGroupList;
    }
}