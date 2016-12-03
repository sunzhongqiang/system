/*
 * 
 *  商品活动Controller 创建于 2016-10-12 11:54:23 版权归作者和作者当前组织所有
 */
package com.mmk.business.web;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.echin.api.tool.ThumbTool;
import com.mmk.business.condition.GoodsCondition;
import com.mmk.business.model.Goods;
import com.mmk.business.model.GoodsImg;
import com.mmk.business.model.GoodsSku;
import com.mmk.business.service.GoodsGroupService;
import com.mmk.business.service.GoodsImgService;
import com.mmk.business.service.GoodsService;
import com.mmk.business.service.GoodsSkuService;
import com.mmk.common.BaseController;
import com.mmk.common.model.EasyPageable;
import com.mmk.common.model.GridData;
import com.mmk.common.model.ResultMsg;
import com.mmk.common.tool.FileClient;

/**
*@Title: GoodsController
*@Description: 商品活动 的web控制层
*@author huguangling 胡广玲
*/
@RestController
public class GoodsController extends BaseController {
    
    @Resource 
    private GoodsService goodsService;
    @Resource 
    private GoodsSkuService goodsSkuService;
    @Resource 
    private GoodsImgService goodsImgService;
    @Resource 
    private GoodsGroupService goodsGroupService;
    
    /**
     * 跳转至列表页面
     * @return 返回页面以及页面模型
     */
    @RequestMapping("/goods/list")
    public ModelAndView list(){
        log.info("商品活动列表查询");
        ModelAndView modelAndView = new ModelAndView("goods/list");
        return  modelAndView;
    }
    
    
    /**
     * 加载表格数据 用户
     * 
     * @param goodsCondition
     *            用户查询参数
     * @param pageable
     *            分页参数
     * @return 查询所得数据
     */
    @RequestMapping("/goods/gridData")
    @ResponseBody
    public GridData<Goods> loadList(GoodsCondition goodsCondition, EasyPageable pageable){
        log.info("获取商品活动列表数据");
        Page<Goods> goodsPage = goodsService.list(goodsCondition,pageable.pageable());   
        GridData<Goods> grid = new GridData<Goods>(goodsPage);
        return grid;
    }
    
    /**
     * 新增页面
     * @return 跳转到商品活动新增页面
     */
    @RequestMapping("/goods/add")
    public ModelAndView addPage(){
        ModelAndView modelAndView = new ModelAndView("goods/form");
        modelAndView.addObject("goods", new Goods());
        modelAndView.addObject("goodsSku", new GoodsSku());
        return modelAndView;
    }
    
    /**
     * 跳转到编辑页面
     * @param goods  跳转到编辑页面
     */ 
    @RequestMapping("/goods/edit")
    public ModelAndView editPage(Goods goods){
        log.info("商品活动编辑页面");
        goods = goodsService.find(goods.getId());
        GoodsSku goodsSku = goodsSkuService.findByGoodsId(goods.getId());
        List<GoodsImg> goodsImgList = goodsImgService.findByGoodsId(goods.getId());
        
        ModelAndView modelAndView = new ModelAndView("goods/form");
        modelAndView.addObject("goods", goods);
        if(goodsSku == null ){
        	goodsSku = new GoodsSku();
        }
        modelAndView.addObject("imgList", goodsImgList);
        modelAndView.addObject("goodsSku", goodsSku);
        return modelAndView ;
    }
    
    
    /**
     * 切换商品上下架状态
     * @param goods 商品信息
     * return  更改结果
     */ 
    @RequestMapping("/goods/toggleOnSale")
    public ResultMsg toggleOnSale(Goods goods){
        log.info("商品活动编辑页面");
        goods = goodsService.find(goods.getId());
        if(goods.getIsOnsale()){
    	   goods.setIsOnsale(false);
        }else{
        	goods.setIsOnsale(true);
        }
        goodsService.save(goods);
        
        ResultMsg result = new ResultMsg(true,"状态更改完毕");
		return result ;
    }
    
    
    
    
    
    /**
     * 商品活动数据保存方法
     * @param goods 要保存的数据
     * @return goods 保存后的数据
     */
    @RequestMapping("/goods/save")
    @ResponseBody
    public Goods save(@Valid Goods goods , BindingResult result ,
    		String[] originalImg,String[] smallThumbImg,String[] bigThumbImg){
        log.info("商品活动保存");
        ModelAndView modelAndView = new ModelAndView("goods/form");
    	Goods good  = goodsService.findById(goods.getId());
    	if(good != null){
    	    goods.setId(good.getId());
    	}
	    goodsService.save(goods); 
	    List<GoodsSku>  goodSkuList = goodsSkuService.findAllByGoodsId(goods.getId());	    
		List<GoodsImg>  goodImgList = goodsImgService.findByGoodsId(goods.getId());
	    
    	GoodsImg goodImg = new GoodsImg();
    	int imgLength = 0;
	    if(originalImg != null){
	    	imgLength = originalImg.length;
	        // 商品相册的保存
		    for(int i=0; i<originalImg.length; i++){
		    	goodImg = new GoodsImg();
			    if(goodImgList.size() != 0 && goodImgList.size() >= i+1){	
		    		goodImg = goodImgList.get(i);	    	
			    }
		    	goodImg.setGoodsId(goods.getId());
			    goodImg.setOriginalImg(originalImg[i]);
			    goodImg.setBigThumbImg(bigThumbImg[i]);
			    goodImg.setSmallThumbImg(smallThumbImg[i]);
			    goodsImgService.save(goodImg);
		    }
	    }
	    if(goodImgList.size() > imgLength){
	    	for(int j =imgLength; j< goodImgList.size(); j++){
	    		goodsImgService.delete(goodImgList.get(j));
	    	}
	    }
          
        modelAndView.addObject("goods", goods);
        modelAndView.addObject("goodImg", goodImg);
        return goods ;
    }
    
   
    
    /**
     * 跳转至详细信息页面
     * @param goods 参数
     * @return 详情数据
     */ 
    @RequestMapping("/goods/details")
    @ResponseBody
    public Goods details(Goods goods){
        log.info("商品活动详细信息");
        goods = goodsService.find(goods.getId());
        return goods;
    }
    
    /**
     * 删除数据操作组方法
     * @param page goods
     * @return
     */
    @RequestMapping("/goods/delete")
    public ResultMsg delete(Goods goods){
        log.info("商品活动删除");
        try {
            goodsService.delete(goods);
            List<GoodsSku> goodsSkus = goodsSkuService.findAllByGoodsId(goods.getId());
            goodsSkuService.delete(goodsSkus);
            List<GoodsImg>  goodImgList = goodsImgService.findByGoodsId(goods.getId());
            for(GoodsImg goodsImg : goodImgList){
            	goodsImgService.delete(goodsImg);
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return new ResultMsg(false, "删除失败");
        }
        return new ResultMsg(true,"删除成功"); 
    }
    
    /**
     * 批量删除数据操作组方法
     * @param page goods
     * @return ture or false 如果成功返回true ,出现错误返回false
     */
    @RequestMapping("/goods/deleteAll")
    public boolean delete(List<Goods> goodsList){
        log.info("商品活动批量删除");
        try {
            goodsService.delete(goodsList);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return false;
        }
        return true; 
    }
    
    /**
     * 跳转至详细信息页面
     * @param  id 检查字段是否存在
     * @return  true or false
     */ 
    @RequestMapping("/goods/id/exist")
    @ResponseBody
    public boolean existsId(Long id){
        log.info("检测商品活动是否存在  id");
        return goodsService.existsId(id);
    }
    
    
    @RequestMapping(value = "/goods/upload")
    @ResponseBody
    public Map<String,Object> upload(MultipartFile file,String callback){
   	 long start = System.currentTimeMillis();
        Map<String, Object> result = new HashMap<String,Object>();
        File dest;
        File size60;
        File size440;
        if(file.getSize()>0){
            try {
               dest = Files.write(Files.createTempFile("copy", "temp"), file.getBytes()).toFile();
               size60 = ThumbTool.size(dest, 350, 350);
               size440 = ThumbTool.size(dest, 600, 600);
               result = FileClient.getDefault().uploadGoods("originalimg", file.getOriginalFilename(), dest,"goodsimg", size440, "thumbimg", size60);
               result.put("success", true);
           } catch (IOException e) {
               result.put("success", false);
               result.put("message", e.getMessage());
               e.printStackTrace();
           }
           dest = null;
           size60 = null;
           size440 = null;
       }
       return result ;
    }
    
    /**
     * 加载表格数据 用户
     * 
     * @param recommendGoodsCondition 用户查询参数
     * @return 查询所得数据
     */
    @RequestMapping("/goods/goodsList")
    @ResponseBody
    public List<Map<String, Object>> goodsGrid(Long positionId){
        log.info("获取商品 位置 关系表列表数据");
        List<Object[]> goodsGrid = goodsService.goodsGrid(positionId);
    	List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
        for (Object[] array : goodsGrid) {
			Map<String, Object> element = new HashMap<String,Object>();
			element.put("goods", array[0]);
			element.put("recommend", array[1]);
			result.add(element );
		}
	
		return result;   
        
    }
    /**
     * 查询商品分组里所有的商品信息
     * 
     * @param goodsGroupCondition 用户查询参数
     * @return 查询所得数据
     */
    @RequestMapping("/goods/groupsGrid")
    @ResponseBody
    public List<Map<String, Object>> groupsGrid(Long positionId,EasyPageable pageable){
    	log.info("查询指定位置下的推荐团里的所有的商品信息");
        List<Object[]> goodsGrid = goodsService.groupsGrid(positionId,pageable.pageable());
    	List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
        for (Object[] array : goodsGrid) {
			Map<String, Object> element = new HashMap<String,Object>();
			element.put("goods", array[0]);
			element.put("recommend", array[1]);
			result.add(element );
		}
        return result;
    }
}