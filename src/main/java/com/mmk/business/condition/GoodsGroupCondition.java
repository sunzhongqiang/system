/*
 * 
 *  GoodsGroupCondition 创建于 2016-11-17 11:42:27 版权归作者和作者当前组织所有
 */
package com.mmk.business.condition;
import java.util.Date;
import com.mmk.business.model.GoodsGroup;

/**
* GoodsGroupCondition ： 商品拼团管理 扩展查询模型
* 2016-11-17 11:42:27
*@author 孙中强 sunzhongqiang
*@version 1.0
*
*/
public class GoodsGroupCondition extends GoodsGroup{

    private Double groupPriceBegin;
    private Double groupPriceEnd;
    private Date startTimeBegin;
    private Date startTimeEnd;
    private Date endTimeBegin;
    private Date endTimeEnd;

    /** 
    * @return groupPriceBegin ：拼团价
    */
    public Double getGroupPriceBegin() {
        return groupPriceBegin;
    }
    /** 
    *@param groupPriceBegin 设置拼团价 开始
    */
    public void setGroupPriceBegin(Double groupPriceBegin) {
        this.groupPriceBegin = groupPriceBegin;
    }
    
     /** 
    * @return groupPriceEnd ：拼团价
    */
    public Double getGroupPriceEnd() {
        return groupPriceEnd;
    }
    /** 
    *@param groupPriceEnd 设置拼团价 开始
    */
    public void setGroupPriceEnd(Double groupPriceEnd) {
        this.groupPriceEnd = groupPriceEnd;
    }
    /** 
    * @return startTimeBegin ：拼团开始时间
    */
    public Date getStartTimeBegin() {
        return startTimeBegin;
    }
    /** 
    *@param startTimeBegin 设置拼团开始时间 开始
    */
    public void setStartTimeBegin(Date startTimeBegin) {
        this.startTimeBegin = startTimeBegin;
    }
    
     /** 
    * @return startTimeEnd ：拼团开始时间
    */
    public Date getStartTimeEnd() {
        return startTimeEnd;
    }
    /** 
    *@param startTimeEnd 设置拼团开始时间 开始
    */
    public void setStartTimeEnd(Date startTimeEnd) {
        this.startTimeEnd = startTimeEnd;
    }
    /** 
    * @return endTimeBegin ：拼团结束时间
    */
    public Date getEndTimeBegin() {
        return endTimeBegin;
    }
    /** 
    *@param endTimeBegin 设置拼团结束时间 开始
    */
    public void setEndTimeBegin(Date endTimeBegin) {
        this.endTimeBegin = endTimeBegin;
    }
    
     /** 
    * @return endTimeEnd ：拼团结束时间
    */
    public Date getEndTimeEnd() {
        return endTimeEnd;
    }
    /** 
    *@param endTimeEnd 设置拼团结束时间 开始
    */
    public void setEndTimeEnd(Date endTimeEnd) {
        this.endTimeEnd = endTimeEnd;
    }

}