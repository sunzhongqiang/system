/*
 * 
 *  WxAuthApp 创建于 2016-12-21 11:14:34 版权归作者和作者当前组织所有
 */
package com.mmk.weixin.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
* WxAuthApp: 微信授权APP 数据领域模型
* 2016-12-21 11:14:34
*@author 孙中强 sunzhongqiang
*@version 1.0
*/
@Entity
@Table(name="wx_app_auth")
public class WxAppAuth {
    /**
     * 
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id",columnDefinition="COMMENT ''")
    private Long id;

    /**
     * 授权方appid
     */
    @Column(name="authorizer_appid",columnDefinition="COMMENT '授权方appid'")
    private String authorizerAppid;

    /**
     * 令牌
     */
    @Column(name="authorizer_access_token",columnDefinition="COMMENT '令牌'")
    private String authorizerAccessToken;

    /**
     * 据刷新令牌
     */
    @Column(name="authorizer_refresh_token",columnDefinition="COMMENT '据刷新令牌'")
    private String authorizerRefreshToken;

    /**
     * 有效期
     */
    @Column(name="expires_in",columnDefinition="COMMENT '有效期'")
    private Long expiresIn;

    /**
     * 更新时间
     */
    @Temporal(TemporalType.TIMESTAMP)   
    @Column(name="modified",columnDefinition="COMMENT '更新时间'")
    private Date modified;

    /**
     * 昵称
     */
    @Column(name="nick_name",columnDefinition="COMMENT '昵称'")
    private String nickName;

    /**
     * 授权方头像
     */
    @Column(name="head_img",columnDefinition="COMMENT '授权方头像'")
    private String headImg;

    /**
     * 原始ID
     */
    @Column(name="user_name",columnDefinition="COMMENT '原始ID'")
    private String userName;

    /**
     * 主体名称
     */
    @Column(name="principal_name",columnDefinition="COMMENT '主体名称'")
    private String principalName;

    /**
     * 所设置的微信号
     */
    @Column(name="alias",columnDefinition="COMMENT '所设置的微信号'")
    private String alias;

    /**
     * 功能的开通状况
     */
    @Column(name="business_info",columnDefinition="COMMENT '功能的开通状况'")
    private String businessInfo;

    /**
     * 二维码图片的URL
     */
    @Column(name="qrcode_url",columnDefinition="COMMENT '二维码图片的URL'")
    private String qrcodeUrl;

    /**
     * 权限集列表
     */
    @Column(name="func_info",columnDefinition="COMMENT '权限集列表'")
    private String funcInfo;

    /**
     * 授权信息
     */
    @Column(name="authorization_info",columnDefinition="COMMENT '授权信息'")
    private String authorizationInfo;


    /** 
	* @return id ：
	*/
    public Long getId() {
        return id;
    }
    /** 
    *@param id 设置 
    */
    public void setId(Long id) {
        this.id = id;
    }

    /** 
	* @return authorizerAppid ：授权方appid
	*/
    public String getAuthorizerAppid() {
        return authorizerAppid;
    }
    /** 
    *@param authorizerAppid 设置授权方appid 
    */
    public void setAuthorizerAppid(String authorizerAppid) {
        this.authorizerAppid = authorizerAppid;
    }

    /** 
	* @return authorizerAccessToken ：令牌
	*/
    public String getAuthorizerAccessToken() {
        return authorizerAccessToken;
    }
    /** 
    *@param authorizerAccessToken 设置令牌 
    */
    public void setAuthorizerAccessToken(String authorizerAccessToken) {
        this.authorizerAccessToken = authorizerAccessToken;
    }

    /** 
	* @return authorizerRefreshToken ：据刷新令牌
	*/
    public String getAuthorizerRefreshToken() {
        return authorizerRefreshToken;
    }
    /** 
    *@param authorizerRefreshToken 设置据刷新令牌 
    */
    public void setAuthorizerRefreshToken(String authorizerRefreshToken) {
        this.authorizerRefreshToken = authorizerRefreshToken;
    }

    /** 
	* @return expiresIn ：有效期
	*/
    public Long getExpiresIn() {
        return expiresIn;
    }
    /** 
    *@param expiresIn 设置有效期 
    */
    public void setExpiresIn(Long expiresIn) {
        this.expiresIn = expiresIn;
    }

    /** 
	* @return modified ：更新时间
	*/
    public Date getModified() {
        return modified;
    }
    /** 
    *@param modified 设置更新时间 
    */
    public void setModified(Date modified) {
        this.modified = modified;
    }

    /** 
	* @return nickName ：昵称
	*/
    public String getNickName() {
        return nickName;
    }
    /** 
    *@param nickName 设置昵称 
    */
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    /** 
	* @return headImg ：授权方头像
	*/
    public String getHeadImg() {
        return headImg;
    }
    /** 
    *@param headImg 设置授权方头像 
    */
    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    /** 
	* @return userName ：原始ID
	*/
    public String getUserName() {
        return userName;
    }
    /** 
    *@param userName 设置原始ID 
    */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /** 
	* @return principalName ：主体名称
	*/
    public String getPrincipalName() {
        return principalName;
    }
    /** 
    *@param principalName 设置主体名称 
    */
    public void setPrincipalName(String principalName) {
        this.principalName = principalName;
    }

    /** 
	* @return alias ：所设置的微信号
	*/
    public String getAlias() {
        return alias;
    }
    /** 
    *@param alias 设置所设置的微信号 
    */
    public void setAlias(String alias) {
        this.alias = alias;
    }

    /** 
	* @return businessInfo ：功能的开通状况
	*/
    public String getBusinessInfo() {
        return businessInfo;
    }
    /** 
    *@param businessInfo 设置功能的开通状况 
    */
    public void setBusinessInfo(String businessInfo) {
        this.businessInfo = businessInfo;
    }

    /** 
	* @return qrcodeUrl ：二维码图片的URL
	*/
    public String getQrcodeUrl() {
        return qrcodeUrl;
    }
    /** 
    *@param qrcodeUrl 设置二维码图片的URL 
    */
    public void setQrcodeUrl(String qrcodeUrl) {
        this.qrcodeUrl = qrcodeUrl;
    }

    /** 
	* @return funcInfo ：权限集列表
	*/
    public String getFuncInfo() {
        return funcInfo;
    }
    /** 
    *@param funcInfo 设置权限集列表 
    */
    public void setFuncInfo(String funcInfo) {
        this.funcInfo = funcInfo;
    }

    /** 
	* @return authorizationInfo ：授权信息
	*/
    public String getAuthorizationInfo() {
        return authorizationInfo;
    }
    /** 
    *@param authorizationInfo 设置授权信息 
    */
    public void setAuthorizationInfo(String authorizationInfo) {
        this.authorizationInfo = authorizationInfo;
    }


}