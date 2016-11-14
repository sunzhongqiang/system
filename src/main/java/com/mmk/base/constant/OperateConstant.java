package com.mmk.base.constant;

/**
 * 系统常量管理
 * 
 * @author zhaoqi
 *
 */
public abstract class OperateConstant {
    /** 当前所使用的系统名称 */
    public static final String OP_SYS_TRADE = "trade";
    public static final String OP_SYS_PROXY = "proxy";
    
    /** 当前所使用的系统操作人类型*/
    public static final String OP_USER_TYPE_PROXY = "proxy";
    public static final String OP_USER_TYPE_RESELLER = "reseller";
    public static final String OP_USER_TYPE_ONLINE = "online";
    public static final String OP_USER_TYPE_SHOP = "shop";
    public static final String OP_USER_TYPE_COMMON = "common";
    
    /** 操作类型 */
    public static final String OP_TYPE_FREEMAIL = "freemail";
    public static final String OP_TYPE_USER_ADD = "employer_add";
    public static final String OP_TYPE_USER_DEL = "employer_del";
    public static final String OP_TYPE_TASK_CLOSE = "task_close";
}