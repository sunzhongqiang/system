/*
 * 
 *  LoginLogCondition 创建于 2016-10-22 13:46:30 版权归作者和作者当前组织所有
 */
package com.mmk.system.condition;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.mmk.system.model.LoginLog;

/**
* LoginLogCondition ： 系统登录日志 扩展查询模型
* 2016-10-22 13:46:30
*@author codegenerator
*@version 1.0
*
*/
public class LoginLogCondition extends LoginLog{

	@DateTimeFormat(iso=ISO.DATE)
    private Date loginTimeBegin;
	@DateTimeFormat(pattern = "yyyy-MM-dd",iso=ISO.DATE)
    private Date loginTimeEnd;

    /** 
    * @return loginTimeBegin ：登录时间
    */
    
    public Date getLoginTimeBegin() {
        return loginTimeBegin;
    }
    /** 
    *@param loginTimeBegin 设置登录时间 开始
    */
    public void setLoginTimeBegin(Date loginTimeBegin) {
        this.loginTimeBegin = loginTimeBegin;
    }
    
     /** 
    * @return loginTimeEnd ：登录时间
    */
    public Date getLoginTimeEnd() {
        return loginTimeEnd;
    }
    /** 
    *@param loginTimeEnd 设置登录时间 开始
    */
    public void setLoginTimeEnd(Date loginTimeEnd) {
        this.loginTimeEnd = loginTimeEnd;
    }

}