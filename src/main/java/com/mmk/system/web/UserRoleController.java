/*
 * 
 *  UserRoleController 创建于 2016-10-13 16:53:44 版权归作者和作者当前组织所有
 */
package com.mmk.system.web;

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

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.mmk.common.ExtJsPage;
import com.mmk.common.ExtJsPageable;
import com.mmk.system.service.UserRoleService;
import com.mmk.system.model.UserRole;
import com.mmk.system.condition.UserRoleCondition;

/**
*UserRoleController ： 系统用户角色 的web控制层
* 2016-10-13 16:53:44
*@author 孙中强 sunzhongqiang
*@version 1.0
*/
@RestController
public class UserRoleController{
	private Log log = LogFactory.getLog(this.getClass());
	
	@Resource 
	private UserRoleService userRoleService;

    /**
	 * 跳转至列表页面
	 * @param userRoleCondition 查询参数
	 * @param pageable 分页参数
	 * @return 返回页面以及页面模型
	 * @author 孙中强 sunzhongqiang
     * 
	 */
	@RequestMapping("/userRole/list")
	@ResponseBody
	public ExtJsPage<UserRole> list(UserRoleCondition userRoleCondition, ExtJsPageable pageable){		
	    log.info("系统用户角色列表查询");
		Page<UserRole> userRolePage =userRoleService.list(userRoleCondition,pageable.pageable());		
		return  new ExtJsPage< UserRole >(userRolePage);
	}
	
	
	/**
	 * 系统用户角色数据保存方法
	 * @param userRole 要保存的数据
	 * @return 保存后的数据
	 * @author 孙中强 sunzhongqiang
     * 
	 */
	@RequestMapping("/userRole/save")
	@ResponseBody
	public UserRole save(UserRole userRole){
		log.info("系统用户角色保存");
		return userRoleService.save(userRole);
	}
	
	/**
     * 系统用户角色数据批量保存方法
     * @param userRoleList 要保存的数据
     * @return 是否成功
     * @author 孙中强 sunzhongqiang
     * 
     */
    @RequestMapping("/userRole/saveAll")
    @ResponseBody
    public boolean save(@RequestBody List<UserRole> userRoleList){
        log.info("系统用户角色批量保存");
        try {
            userRoleService.save(userRoleList);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage(),e);
            return false;
        }
    }

	
	/**
	 * 跳转至详细信息页面
	 * @param userRole 要查询的数据
	 * @return 返回详情数据
	 * @author 孙中强 sunzhongqiang
     * 
	 */ 
	@RequestMapping("/userRole/details")
	@ResponseBody
	public UserRole details(UserRole userRole){
		log.info("系统用户角色详细信息");
		userRole = userRoleService.find(userRole.getId());
		return userRole;
	}
	
	/**
	 * 删除数据操作组方法
	 * @param userRole 要删除的数据
	 * @return 是否成功
	 * @author 孙中强 sunzhongqiang
     * 
	 */
	@RequestMapping("/userRole/delete")
	public boolean delete(UserRole userRole){
		log.info("系统用户角色删除");
        try {
            userRoleService.delete(userRole);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return false;
        }
        return true; 
	}
	
	/**
     * 批量删除数据操作组方法
     * @param userRoleList 要删除的数据
     * @return ture or false 如果成功返回true ,出现错误返回false
     * @author 孙中强 sunzhongqiang
     * 
     */
    @RequestMapping("/userRole/deleteAll")
    public boolean delete(List<UserRole> userRoleList){
        log.info("系统用户角色批量删除");
        try {
            userRoleService.delete(userRoleList);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return false;
        }
        return true; 
    }
	
}