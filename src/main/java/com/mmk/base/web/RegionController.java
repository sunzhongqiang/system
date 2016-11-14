package com.mmk.base.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.mmk.base.condition.RegionCondition;
import com.mmk.base.dao.RegionDao;
import com.mmk.base.dao.RegionRepository;
import com.mmk.base.model.Region;
import com.mmk.base.service.RegionService;


@RestController
public class RegionController {

	@Resource
	private RegionRepository regionRepository;
	@Resource 
	private RegionService regionService;
	@Resource
	private RegionDao regionDao;
	
	@RequestMapping("/region")
	@ResponseBody
	public List<Region> region(Long id){
		List<Region> regionList = regionRepository.findByParentId(id); 
		return regionList;
	}
	

    /**
	 * 跳转至列表页面
	 * @param pageable region
	 * @return
	 * @author code generator
     * @date 2016-05-23 14:56:51
	 */
	@RequestMapping("/region/list")
	public ModelAndView list(RegionCondition regionCondition, Pageable pageable){		
		Page<Region> regionList=regionService.list(regionCondition,pageable);
		ModelAndView mv = new ModelAndView("region/list");
		
		if(null!=regionCondition.getParentId() && 0!=regionCondition.getParentId()){
			//查询parentId的区域
			Region region = regionRepository.findOne(regionCondition.getParentId());
			long rType = region.getRegionType().longValue();//根据父级的类型查询列表上添加区域文字提示
			regionCondition.setGrandpaId(region.getParentId());
			mv.addObject("addSpanTxt", rType==0?"新增二级区域：":(rType==1?"新增三级区域：":(rType==2?"新增四级区域：":"新增五级区域")));
		}else{
			regionCondition.setParentId(0L);
			mv.addObject("addSpanTxt", "新增一级区域：");
		}
		
		mv.addObject("page", regionList);
		mv.addObject("regionCondition", regionCondition);
		return mv;
	}
	
	/**
	 * 跳转至行政区域管理新增页面
	 * @param pageable
	 * @return 行政区域管理新增页面
	 * @author code generator
     * @date 2016-05-23 14:56:51
	 */
	@RequestMapping("/region/add")
	public ModelAndView add(){
		ModelAndView mv = new ModelAndView("region/form");
		mv.addObject("region",new Region());
		return mv;		
	}
	
	/**
	 * 行政区域管理数据保存方法
	 * @param region
	 * @return 行政区域管理列表页面
	 * @author code generator
     * @date 2016-05-23 14:56:51
	 */
	@RequestMapping("/region/save")
	public ModelAndView save(Region region, Pageable pageable){
		Region pRegion = regionRepository.findOne(region.getParentId());
		region.setRegionId(regionDao.findMaxRegionId());
		region.setAgencyId(0L);
		region.setCheckNum(0L);
		region.setHotCity(0L);
		region.setIsDisplay(1L);
		region.setRegionType(0!=region.getParentId().longValue()?pRegion.getRegionType()+1:0);
		region.setFullRegionName(0!=region.getParentId().longValue()?(pRegion.getFullRegionName()+" "+region.getRegionName()):region.getRegionName());
		regionService.save(region);
		
		RegionCondition regionCondition = new RegionCondition();
		regionCondition.setParentId(region.getParentId());
		Page<Region> regionList=regionService.list(regionCondition,pageable);
		ModelAndView mv = new ModelAndView("region/list");
		
		if(null!=regionCondition.getParentId() && 0!=regionCondition.getParentId()){
			//查询parentId的区域
			long rType = pRegion.getRegionType().longValue();//根据父级的类型查询列表上添加区域文字提示
			regionCondition.setGrandpaId(pRegion.getParentId());
			mv.addObject("addSpanTxt", rType==0?"新增二级区域：":(rType==1?"新增三级区域：":(rType==2?"新增四级区域：":"新增五级区域")));
		}else{
			regionCondition.setParentId(0L);
			mv.addObject("addSpanTxt", "新增一级区域：");
		}
		
		mv.addObject("page", regionList);
		mv.addObject("regionCondition", regionCondition);
		return mv;
	}

	/**
	 * 跳转至修改页面
	 * @param page region
	 * @return
	 * @author code generator
     * @date 2016-05-23 14:56:51
	 */
	@RequestMapping("/region/edit")
	public ModelAndView edit(Region qRegion){
		Region region = regionService.find(qRegion.getRegionId());
		ModelAndView mv = new ModelAndView("region/form");
		mv.addObject("region",region);
		return mv;
	}
	
	/**
	 * 修改数据方法
	 * @param page region
	 * @return
	 * @author code generator
     * @date 2016-05-23 14:56:51
	 */
	@RequestMapping("/region/update")
	public ModelAndView update(Region region,String backurl){
		//需要更新区域全称
		Region pRegion = regionRepository.findOne(region.getParentId());
		region.setFullRegionName(0!=region.getParentId().longValue()?(pRegion.getFullRegionName()+" "+region.getRegionName()):region.getRegionName());
		regionService.save(region);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("message", "编辑成功");
		ModelAndView mv = new ModelAndView(new RedirectView(backurl), map);
		return mv;
	}
	
	/**
	 * 跳转至详细信息页面
	 * @param page region
	 * @return
	 * @author code generator
     * @date 2016-05-23 14:56:51
	 */ 
	@RequestMapping("/region/details")
	public ModelAndView details(Region qRegion){
		Region region = regionService.find(qRegion.getRegionId());
		ModelAndView mv = new ModelAndView("region/details");
		mv.addObject("region",region);
		return mv;
	}
	
	/**
	 * 删除数据操作组方法
	 * @param page region
	 * @return
	 * @author code generator
     * @date 2016-05-23 14:56:51
	 */
	@RequestMapping("/region/delete")
	@ResponseBody
	public Map<String, Object> delete(Region region){
		Map<String, Object> map = new HashMap<String, Object>();
		List<Region> regionList = regionRepository.findByParentId(region.getRegionId()); 
		if(regionList.isEmpty()){
			regionService.delete(region);
			map.put("success", "true");
		}else{
			map.put("success", "false");
			map.put("msg", "有子级区域的不可删除");
		}
		
		return map;
	}
	
    /**
     * 跳转至详细信息页面
     * @param page region
     * @return  true or false
     * @author code generator
     * @date 2016-05-23 14:56:51
     */ 
    @RequestMapping("/region/regionName/exist")
    @ResponseBody
    boolean existsRegionName(String regionName){
        return regionService.existsRegionName(regionName);
    }
}
