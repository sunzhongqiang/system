/*
 * 
 *  商品属性Controller 创建于 2016-10-12 11:54:23 版权归作者和作者当前组织所有
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
import com.mmk.business.service.GoodsSkuService;
import com.mmk.business.model.GoodsSku;
import com.mmk.business.condition.GoodsSkuCondition;

/**
 * @Title: GoodsSkuController
 * @Description: 商品属性 的web控制层
 * @author huguangling 胡广玲
 */
@RestController
public class GoodsSkuController extends BaseController {

	@Resource
	private GoodsSkuService goodsSkuService;

	/**
	 * 跳转至列表页面
	 * 
	 * @return 返回页面以及页面模型
	 */
	@RequestMapping("/goodsSku/list")
	public ModelAndView list() {
		log.info("商品属性列表查询");
		ModelAndView modelAndView = new ModelAndView("goodsSku/list");
		return modelAndView;
	}

	/**
	 * 加载表格数据 用户
	 * 
	 * @param goodsSkuCondition
	 *            用户查询参数
	 * @param pageable
	 *            分页参数
	 * @return 查询所得数据
	 */
	@RequestMapping("/goodsSku/gridData")
	@ResponseBody
	public GridData<GoodsSku> loadList(GoodsSkuCondition goodsSkuCondition, EasyPageable pageable) {
		log.info("获取商品属性列表数据");
		Page<GoodsSku> goodsSkuPage = goodsSkuService.list(goodsSkuCondition, pageable.pageable());
		GridData<GoodsSku> grid = new GridData<GoodsSku>(goodsSkuPage);
		return grid;
	}

	/**
	 * 新增页面
	 * 
	 * @return 跳转到商品属性新增页面
	 */
	@RequestMapping("/goodsSku/add")
	public ModelAndView addPage() {
		ModelAndView modelAndView = new ModelAndView("goodsSku/form");
		modelAndView.addObject("goodsSku", new GoodsSku());
		return modelAndView;
	}

	/**
	 * 跳转到编辑页面
	 * 
	 * @param goodsSku
	 *            跳转到编辑页面
	 */
	@RequestMapping("/goodsSku/edit")
	public ModelAndView editPage(GoodsSku goodsSku) {
		log.info("商品属性编辑页面");
		goodsSku = goodsSkuService.find(goodsSku.getId());
		ModelAndView modelAndView = new ModelAndView("goodsSku/form");
		modelAndView.addObject("goodsSku", goodsSku);
		return modelAndView;
	}

	/**
	 * 商品属性数据保存方法
	 * 
	 * @param goodsSku
	 *            要保存的数据
	 * @return goodsSku 保存后的数据
	 */
	@RequestMapping("/goodsSku/save")
	@ResponseBody
	public ResultMsg save(GoodsSku goodsSku) {
		log.info("商品属性保存");
		try {
			goodsSkuService.save(goodsSku);
		} catch (Exception e) {
			return new ResultMsg(false, "商品属性保存失败");
		}
		return new ResultMsg(true, "商品属性保存成功");
	}

	/**
	 * 跳转至详细信息页面
	 * 
	 * @param goodsSku
	 *            参数
	 * @return 详情数据
	 */
	@RequestMapping("/goodsSku/details")
	@ResponseBody
	public GoodsSku details(GoodsSku goodsSku) {
		log.info("商品属性详细信息");
		goodsSku = goodsSkuService.find(goodsSku.getId());
		return goodsSku;
	}

	/**
	 * 删除数据操作组方法
	 * 
	 * @param page
	 *            goodsSku
	 * @return
	 */
	@RequestMapping("/goodsSku/delete")
	public ResultMsg delete(GoodsSku goodsSku) {
		log.info("商品属性删除");
		try {
			goodsSkuService.delete(goodsSku);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return new ResultMsg(false, "删除失败");
		}
		return new ResultMsg(true, "删除成功");
	}

	/**
	 * 批量删除数据操作组方法
	 * 
	 * @param page
	 *            goodsSku
	 * @return ture or false 如果成功返回true ,出现错误返回false
	 */
	@RequestMapping("/goodsSku/deleteAll")
	public boolean delete(List<GoodsSku> goodsSkuList) {
		log.info("商品属性批量删除");
		try {
			goodsSkuService.delete(goodsSkuList);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return false;
		}
		return true;
	}

	/**
	 * 跳转至详细信息页面
	 * 
	 * @param goodId
	 *            检查字段是否存在
	 * @return true or false
	 */
	@RequestMapping("/goodsSku/goodId/exist")
	@ResponseBody
	public boolean existsGoodId(Long goodId) {
		log.info("检测商品属性是否存在  goodId");
		return goodsSkuService.existsGoodId(goodId);
	}
}