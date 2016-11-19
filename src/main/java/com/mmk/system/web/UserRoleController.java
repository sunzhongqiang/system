/*
 * 
 *  系统用户角色Controller 创建于 2016-10-12 11:54:23 版权归作者和作者当前组织所有
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
import com.mmk.system.condition.UserRoleCondition;
import com.mmk.system.model.UserRole;
import com.mmk.system.service.UserRoleService;

/**
*@Title: UserRoleController
*@Description: 系统用户角色 的web控制层
*@author code
*/
@RestController
public class UserRoleController extends BaseController {
    
    @Resource 
    private UserRoleService userRoleService;

    /**
     * 跳转至列表页面
     * @return 返回页面以及页面模型
     */
    @RequestMapping("/userRole/list")
    public ModelAndView list(){
        log.info("系统用户角色列表查询");
        ModelAndView modelAndView = new ModelAndView("userRole/list");
        return  modelAndView;
    }
    
    
    /**
     * 加载表格数据 用户
     * 
     * @param userRoleCondition 用户查询参数
     * @param pageable 分页参数
     * @return 查询所得数据
     */
    @RequestMapping("/userRole/gridData")
    @ResponseBody
    public GridData<UserRole> loadList(UserRoleCondition userRoleCondition, EasyPageable pageable){
        log.info("获取系统用户角色列表数据");
        Page<UserRole> userRolePage = userRoleService.list(userRoleCondition,pageable.pageable());   
        GridData<UserRole> grid = new GridData<UserRole>(userRolePage);
        return grid;
    }
    
    /**
     * 新增页面
     * @return 跳转到系统用户角色新增页面
     */
    @RequestMapping("/userRole/add")
    public ModelAndView addPage(){
        ModelAndView modelAndView = new ModelAndView("userRole/form");
        modelAndView.addObject("userRole", new UserRole());
        return modelAndView;
    }
    
    /**
     * 跳转到编辑页面
     * @param userRole  跳转到编辑页面
     */ 
    @RequestMapping("/userRole/edit")
    public ModelAndView editPage(UserRole userRole){
        log.info("系统用户角色编辑页面");
        userRole = userRoleService.find(userRole.getId());
        ModelAndView modelAndView = new ModelAndView("userRole/form");
        modelAndView.addObject("userRole", userRole);
        return modelAndView ;
    }
   
    /**
     * 系统用户角色数据保存方法
     * @param userRole 要保存的数据
     * @return userRole 保存后的数据
     */
    @RequestMapping("/userRole/save")
    @ResponseBody
    public ResultMsg save(UserRole userRole){
        log.info("系统用户角色保存");
        try {
            userRoleService.save(userRole);
        } catch (Exception e) {
            return new ResultMsg(false,"系统用户角色保存失败");
        }
        return new ResultMsg(true,"系统用户角色保存成功");
    }
 
    /**
     * 跳转至详细信息页面
     * @param userRole 参数
     * @return 详情数据
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
     * @param page userRole
     * @return
     */
    @RequestMapping("/userRole/delete")
    public ResultMsg delete(UserRole userRole){
        log.info("系统用户角色删除");
        try {
            userRoleService.delete(userRole);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return new ResultMsg(false, "删除失败");
        }
        return new ResultMsg(true,"删除成功"); 
    }
    
    /**
     * 批量删除数据操作组方法
     * @param page userRole
     * @return ture or false 如果成功返回true ,出现错误返回false
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
    
    @RequestMapping("/userRole/userRoleList")
    @ResponseBody
    public List<Tree> roleList(Long userId){
        log.info("根据用户获取用户角色");
        List<Tree>  userRole = userRoleService.findRoleListByUserId(userId);
        return userRole;
    }
    
    @RequestMapping("/userRole/updateUserRole")
    @ResponseBody
    public void updateUserRole(Long userId, Long roleId,boolean checked){
        log.info("根据用户角色设置角色权限");
        UserRole  userRole = userRoleService.findByUserIdAndRoleId(userId, roleId);
        if(checked){
        	if(userRole ==null){
        	      UserRole user_Role = new UserRole();
        	      user_Role.setRoleId(roleId);
        	      user_Role.setUserId(userId);
                  userRoleService.save(user_Role);
        	}
        }else if(userRole != null){     	
            userRoleService.delete(userRole);
        }
        return ;
    }
}