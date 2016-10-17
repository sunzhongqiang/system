/*
 * 
 *  UserController 创建于 2016-10-12 11:54:23 版权归作者和作者当前组织所有
 */
package com.mmk.system.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.mmk.common.ExtJsPage;
import com.mmk.common.ExtJsPageable;
import com.mmk.common.model.Tree;
import com.mmk.system.condition.UserCondition;
import com.mmk.system.model.User;
import com.mmk.system.service.UserService;

/**
*UserController ： 系统用户 的web控制层
* 2016-10-12 11:54:23
*@author sunzhongqiang 孙中强
*@version 1.0
*/
@RestController
public class UserController{
	private Log log = LogFactory.getLog(this.getClass());
	
	@Resource 
	private UserService userService;

    /**
	 * 跳转至列表页面
	 * @param userCondition 查询参数
	 * @param pageable 分页参数
	 * @return 返回页面以及页面模型
	 * @author sunzhongqiang 孙中强
     * 
	 */
	@RequestMapping("/user/list")
	@ResponseBody
	public ExtJsPage<User> list(UserCondition userCondition, ExtJsPageable pageable){		
	    log.info("系统用户列表查询");
		Page<User> userPage =userService.list(userCondition,pageable.pageable());		
		return  new ExtJsPage< User >(userPage);
	}
	
	
	/**
	 * 系统用户数据保存方法
	 * @param user 要保存的数据
	 * @return 保存后的数据
	 * @author sunzhongqiang 孙中强
     * 
	 */
	@RequestMapping("/user/save")
	@ResponseBody
	public User save(User user){
		log.info("系统用户保存");
		return userService.save(user);
	}
	
	/**
     * 系统用户数据批量保存方法
     * @param userList 要保存的数据
     * @return 是否成功
     * @author sunzhongqiang 孙中强
     * 
     */
    @RequestMapping("/user/saveAll")
    @ResponseBody
    public boolean save(@RequestBody List<User> userList){
        log.info("系统用户批量保存");
        try {
            userService.save(userList);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage(),e);
            return false;
        }
    }

	
	/**
	 * 跳转至详细信息页面
	 * @param user 要查询的数据
	 * @return 返回详情数据
	 * @author sunzhongqiang 孙中强
     * 
	 */ 
	@RequestMapping("/user/details")
	@ResponseBody
	public User details(User user){
		log.info("系统用户详细信息");
		user = userService.find(user.getId());
		return user;
	}
	
	/**
	 * 删除数据操作组方法
	 * @param user 要删除的数据
	 * @return 是否成功
	 * @author sunzhongqiang 孙中强
     * 
	 */
	@RequestMapping("/user/delete")
	public boolean delete(User user){
		log.info("系统用户删除");
        try {
            userService.delete(user);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return false;
        }
        return true; 
	}
	
	/**
     * 批量删除数据操作组方法
     * @param userList 要删除的数据
     * @return ture or false 如果成功返回true ,出现错误返回false
     * @author sunzhongqiang 孙中强
     * 
     */
    @RequestMapping("/user/deleteAll")
    public boolean delete(List<User> userList){
        log.info("系统用户批量删除");
        try {
            userService.delete(userList);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return false;
        }
        return true; 
    }
    
    @RequestMapping("/login")
    public ModelAndView login(){
    	return new ModelAndView("login");
    }
    
}