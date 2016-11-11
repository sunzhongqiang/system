/*
 * 
 *  评价管理Controller 创建于 2016-10-12 11:54:23 版权归作者和作者当前组织所有
 */
package com.mmk.trade.web;

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
import org.springframework.web.servlet.ModelAndView;

import com.mmk.common.BaseController;
import com.mmk.common.model.EasyPageable;
import com.mmk.common.model.GridData;
import com.mmk.common.model.ResultMsg;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.mmk.trade.service.CommentService;
import com.mmk.trade.model.Comment;
import com.mmk.trade.condition.CommentCondition;

/**
*@Title: CommentController
*@Description: 评价管理 的web控制层
*@author huguangling 胡广玲
*/
@RestController
public class CommentController extends BaseController {
    
    @Resource 
    private CommentService commentService;

    /**
     * 跳转至列表页面
     * @return 返回页面以及页面模型
     */
    @RequestMapping("/comment/list")
    public ModelAndView list(){
        log.info("评价管理列表查询");
        ModelAndView modelAndView = new ModelAndView("comment/list");
        return  modelAndView;
    }
    
    
    /**
     * 加载表格数据 用户
     * 
     * @param commentCondition
     *            用户查询参数
     * @param pageable
     *            分页参数
     * @return 查询所得数据
     */
    @RequestMapping("/comment/gridData")
    @ResponseBody
    public GridData<Comment> loadList(CommentCondition commentCondition, EasyPageable pageable){
        log.info("获取评价管理列表数据");
        Page<Comment> commentPage = commentService.list(commentCondition,pageable.pageable());   
        GridData<Comment> grid = new GridData<Comment>(commentPage);
        return grid;
    }
    
    /**
     * 新增页面
     * @return 跳转到评价管理新增页面
     */
    @RequestMapping("/comment/add")
    public ModelAndView addPage(){
        ModelAndView modelAndView = new ModelAndView("comment/form");
        modelAndView.addObject("comment", new Comment());
        return modelAndView;
    }
    
    /**
     * 跳转到编辑页面
     * @param comment  跳转到编辑页面
     */ 
    @RequestMapping("/comment/edit")
    public ModelAndView editPage(Comment comment){
        log.info("评价管理编辑页面");
        comment = commentService.find(comment.getId());
        ModelAndView modelAndView = new ModelAndView("comment/form");
        modelAndView.addObject("comment", comment);
        return modelAndView ;
    }
    
    
    /**
     * 评价管理数据保存方法
     * @param comment 要保存的数据
     * @return comment 保存后的数据
     */
    @RequestMapping("/comment/save")
    @ResponseBody
    public ResultMsg save(Comment comment){
        log.info("评价管理保存");
        try {
            commentService.save(comment);
        } catch (Exception e) {
            return new ResultMsg(false,"评价管理保存失败");
        }
        return new ResultMsg(true,"评价管理保存成功");
    }
    
   
    
    /**
     * 跳转至详细信息页面
     * @param comment 参数
     * @return 详情数据
     */ 
    @RequestMapping("/comment/details")
    @ResponseBody
    public Comment details(Comment comment){
        log.info("评价管理详细信息");
        comment = commentService.find(comment.getId());
        return comment;
    }
    
    /**
     * 删除数据操作组方法
     * @param page comment
     * @return
     */
    @RequestMapping("/comment/delete")
    public ResultMsg delete(Comment comment){
        log.info("评价管理删除");
        try {
            commentService.delete(comment);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return new ResultMsg(false, "删除失败");
        }
        return new ResultMsg(true,"删除成功"); 
    }
    
    /**
     * 批量删除数据操作组方法
     * @param page comment
     * @return ture or false 如果成功返回true ,出现错误返回false
     */
    @RequestMapping("/comment/deleteAll")
    public boolean delete(List<Comment> commentList){
        log.info("评价管理批量删除");
        try {
            commentService.delete(commentList);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return false;
        }
        return true; 
    }
    
}