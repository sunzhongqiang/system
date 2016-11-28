/*
 * 
 *  组织机构Controller 创建于 2016-10-12 11:54:23 版权归作者和作者当前组织所有
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
import com.mmk.common.model.Tree;
import com.mmk.system.condition.OrganizationCondition;
import com.mmk.system.model.Organization;
import com.mmk.system.service.OrganizationService;

/**
*@Title: OrganizationController
*@Description: 组织机构 的web控制层
*@author 孙中强 sunzhongqiang
*/
@RestController
public class OrganizationController extends BaseController {
    
    @Resource 
    private OrganizationService organizationService;

    /**
     * 跳转至列表页面
     * @return 返回页面以及页面模型
     */
    @RequestMapping("/organization/list")
    public ModelAndView list(){
        log.info("组织机构列表查询");
        ModelAndView modelAndView = new ModelAndView("organization/list");
        return  modelAndView;
    }
    
    
    /**
     * 加载表格数据 用户
     * 
     * @param organizationCondition 用户查询参数
     * @param pageable 分页参数
     * @return 查询所得数据
     */
    @RequestMapping("/organization/gridData")
    @ResponseBody
    public GridData<Organization> loadList(OrganizationCondition organizationCondition, EasyPageable pageable){
        log.info("获取组织机构列表数据");
        Page<Organization> organizationPage = organizationService.list(organizationCondition,pageable.pageable());   
        GridData<Organization> grid = new GridData<Organization>(organizationPage);
        return grid;
    }
    
    
    /**
     * 返回组织结构树treeGrid
     * @return 组织结构树
     */
    @RequestMapping("/organization/treeGrid")
    @ResponseBody
    public List<Organization> treeGrid(){
        log.info("获取组织机构树");
        List<Organization> treeGrid = organizationService.treeGrid();   
        return treeGrid;
    }
    
    /**
     * 返回组织结构树treeGrid
     * @return 组织结构树
     */
    @RequestMapping("/organization/tree")
    @ResponseBody
    public List<Tree> tree(){
        log.info("获取组织机构树");
        List<Tree> tree = organizationService.tree();   
        return tree;
    }
    
    /**
     * 新增页面
     * @return 跳转到组织机构新增页面
     */
    @RequestMapping("/organization/add")
    public ModelAndView addPage(){
        ModelAndView modelAndView = new ModelAndView("organization/form");
        modelAndView.addObject("organization", new Organization());
        return modelAndView;
    }
    
    /**
     * 跳转到编辑页面
     * @param organization  跳转到编辑页面
     */ 
    @RequestMapping("/organization/edit")
    public ModelAndView editPage(Organization organization){
        log.info("组织机构编辑页面");
        organization = organizationService.find(organization.getId());
        ModelAndView modelAndView = new ModelAndView("organization/form");
        modelAndView.addObject("organization", organization);
        return modelAndView ;
    }
     
    /**
     * 组织机构数据保存方法
     * @param organization 要保存的数据
     * @return organization 保存后的数据
     */
    @RequestMapping("/organization/save")
    @ResponseBody
    public ResultMsg save(Organization organization){
        log.info("组织机构保存");
        try {
        	Long parentId = organization.getParentId();
        	if(parentId!=null){
        		Organization parent = organizationService.find(parentId);
        		organization.setPath(parent.getPath()+parent.getCode()+"/");
        	}else {
				organization.setPath("/");
			}
            organizationService.save(organization);
        } catch (Exception e) {
            return new ResultMsg(false,"组织机构保存失败");
        }
        return new ResultMsg(true,"组织机构保存成功");
    }
    
   
    
    /**
     * 跳转至详细信息页面
     * @param organization 参数
     * @return 详情数据
     */ 
    @RequestMapping("/organization/details")
    @ResponseBody
    public Organization details(Organization organization){
        log.info("组织机构详细信息");
        organization = organizationService.find(organization.getId());
        return organization;
    }
    
    /**
     * 删除数据操作组方法
     * @param page organization
     * @return
     */
    @RequestMapping("/organization/delete")
    public ResultMsg delete(Organization organization){
        log.info("组织机构删除");
        try {
            organizationService.delete(organization);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return new ResultMsg(false, "删除失败");
        }
        return new ResultMsg(true,"删除成功"); 
    }
    
    /**
     * 批量删除数据操作组方法
     * @param page organization
     * @return ture or false 如果成功返回true ,出现错误返回false
     */
    @RequestMapping("/organization/deleteAll")
    public boolean delete(List<Organization> organizationList){
        log.info("组织机构批量删除");
        try {
            organizationService.delete(organizationList);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return false;
        }
        return true; 
    }
    @RequestMapping("/organization/existCode")
    public boolean existCode(String code,Long id){
    	Organization organization = organizationService.findBy("code", code);
    	if(organization==null){
    		return true;
    	}else{
    		if(organization.getId().equals(id)){
    			return true;
    		}
    	}
    	return false;
    }
    
}