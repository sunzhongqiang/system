package com.mmk.trade.service.impl;

import javax.annotation.Resource;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.mmk.gene.service.impl.BaseServiceImpl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.mmk.trade.dao.CommentRepository;
import com.mmk.trade.model.Comment;
import com.mmk.trade.condition.CommentCondition;
import com.mmk.trade.service.CommentService;
import com.mmk.trade.dao.CommentDao;
/**
* CommentServiceImpl: 评价管理 业务服务层实现
* 2016-11-11 13:31:11
* @author huguangling 胡广玲
* @version 1.0
*/
@Service
public class CommentServiceImpl extends BaseServiceImpl<Comment, Long> implements CommentService {

    private Log log = LogFactory.getLog(this.getClass());
    @Resource
    private CommentDao commentDao;
    
    private CommentRepository commentRepository;
    /**
    *构造方法
    * @param commentRepository 数据容器
    */
    @Autowired
    public CommentServiceImpl( CommentRepository commentRepository) {
        super(commentRepository);
        this.commentRepository = commentRepository;
    }

    @Override
    public Page<Comment> list(CommentCondition commentCondition, Pageable pageable) {
        log.info("评价管理查询列表");
        return commentDao.list(commentCondition, pageable);
    }
    
    @Override
    public List<Comment> list(CommentCondition commentCondition) {
        log.info("评价管理查询列表无分页");
        return commentDao.list(commentCondition);
    }

    /**
     * 根据给定的字段返回符合的对象
     * @param id 评价ID
     * @return 符合条件的唯一对象
     */
    @Override
    public Comment findById(Long id){
         return commentRepository.findFirstById(id);
    }
    /**
     * 根据字段获取所有符合的记录
     * @param userName 用户名
     * @return 符合条件的所有对象
     */
    @Override
    public List<Comment>  findAllByUserName(String userName){
        return commentRepository.findAllByUserName(userName);
    }
    
     @Override
    public Page<Comment>  findAllByUserName(String userName, Pageable pageable){
        return commentRepository.findAllByUserName(userName,pageable);
    }
    @Override 
    public Comment findBy(String field,Object value){
        log.info("评价管理根据字["+field+"="+value+"] 进行查询符合条件的唯一值");
        return commentDao.findBy(field,value);
    }
    
    @Override 
    public List<Comment> findAllBy(String field,Object value){
        log.info("评价管理根据字["+field+"="+value+"] 进行查询符合条件的所有记录");
        return commentDao.findAllBy(field,value);
    }

	@Override
	public List<Comment> findCommentByGoodsId(Long goodsId) {
        log.info("评价管理根据商品ID进行查询符合条件的所有记录");
        return commentDao.findCommentByGoodsId(goodsId);
	}
}