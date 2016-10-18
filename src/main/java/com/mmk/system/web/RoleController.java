/*
 * 
 *  RoleController 创建于 2016-10-12 11:54:19 版权归作者和作者当前组织所有
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

import com.mmk.system.service.RoleService;
import com.mmk.system.model.Role;
import com.mmk.common.model.ExtJsPage;
import com.mmk.common.model.ExtJsPageable;
import com.mmk.system.condition.RoleCondition;

/**
*RoleController ： 系统角色 的web控制层
* 2016-10-12 11:54:19
*@author sunzhongqiang 孙中强
*@version 1.0
*/
@RestController
public class RoleController{
	private Log log = LogFactory.getLog(this.getClass());
	
	@Resource 
	private RoleService roleService;

    /**
	 * 跳转至列表页面
	 * @param roleCondition 查询参数
	 * @param pageable 分页参数
	 * @return 返回页面以及页面模型
	 * @author sunzhongqiang 孙中强
     * 
	 */
	@RequestMapping("/role/list")
	@ResponseBody
	public ExtJsPage<Role> list(RoleCondition roleCondition, ExtJsPageable pageable){		
	    log.info("系统角色列表查询");
		Page<Role> rolePage =roleService.list(roleCondition,pageable.pageable());		
		return  new ExtJsPage< Role >(rolePage);
	}
	
	
	/**
	 * 系统角色数据保存方法
	 * @param role 要保存的数据
	 * @return 保存后的数据
	 * @author sunzhongqiang 孙中强
     * 
	 */
	@RequestMapping("/role/save")
	@ResponseBody
	public Role save(Role role){
		log.info("系统角色保存");
		return roleService.save(role);
	}
	
	/**
     * 系统角色数据批量保存方法
     * @param roleList 要保存的数据
     * @return 是否成功
     * @author sunzhongqiang 孙中强
     * 
     */
    @RequestMapping("/role/saveAll")
    @ResponseBody
    public boolean save(@RequestBody List<Role> roleList){
        log.info("系统角色批量保存");
        try {
            roleService.save(roleList);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage(),e);
            return false;
        }
    }

	
	/**
	 * 跳转至详细信息页面
	 * @param role 要查询的数据
	 * @return 返回详情数据
	 * @author sunzhongqiang 孙中强
     * 
	 */ 
	@RequestMapping("/role/details")
	@ResponseBody
	public Role details(Role role){
		log.info("系统角色详细信息");
		role = roleService.find(role.getCode());
		return role;
	}
	
	/**
	 * 删除数据操作组方法
	 * @param role 要删除的数据
	 * @return 是否成功
	 * @author sunzhongqiang 孙中强
     * 
	 */
	@RequestMapping("/role/delete")
	public boolean delete(Role role){
		log.info("系统角色删除");
        try {
            roleService.delete(role);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return false;
        }
        return true; 
	}
	
	/**
     * 批量删除数据操作组方法
     * @param roleList 要删除的数据
     * @return ture or false 如果成功返回true ,出现错误返回false
     * @author sunzhongqiang 孙中强
     * 
     */
    @RequestMapping("/role/deleteAll")
    public boolean delete(List<Role> roleList){
        log.info("系统角色批量删除");
        try {
            roleService.delete(roleList);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return false;
        }
        return true; 
    }
	
}