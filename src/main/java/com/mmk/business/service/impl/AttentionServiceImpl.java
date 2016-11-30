package com.mmk.business.service.impl;

import javax.annotation.Resource;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.mmk.gene.service.impl.BaseServiceImpl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.mmk.business.dao.AttentionRepository;
import com.mmk.business.model.Attention;
import com.mmk.business.condition.AttentionCondition;
import com.mmk.business.service.AttentionService;
import com.mmk.business.dao.AttentionDao;
/**
* AttentionServiceImpl: 商品或者团的关注 业务服务层实现
* 2016-11-30 09:25:29
* @author huguangling 胡广玲
* @version 1.0
*/
@Service
public class AttentionServiceImpl extends BaseServiceImpl<Attention, Long> implements AttentionService {

    private Log log = LogFactory.getLog(this.getClass());
    @Resource
    private AttentionDao attentionDao;
    
    private AttentionRepository attentionRepository;
    /**
    *构造方法
    * @param attentionRepository 数据容器
    */
    @Autowired
    public AttentionServiceImpl( AttentionRepository attentionRepository) {
        super(attentionRepository);
        this.attentionRepository = attentionRepository;
    }

    @Override
    public Page<Attention> list(AttentionCondition attentionCondition, Pageable pageable) {
        log.info("商品或者团的关注查询列表");
        return attentionDao.list(attentionCondition, pageable);
    }
    
    @Override
    public List<Attention> list(AttentionCondition attentionCondition) {
        log.info("商品或者团的关注查询列表无分页");
        return attentionDao.list(attentionCondition);
    }

    /**
     * 根据给定的字段返回符合的对象
     * @param id 主键
     * @return 符合条件的唯一对象
     */
    @Override
    public Attention findById(Long id){
         return attentionRepository.findFirstById(id);
    }
    /**
     * 根据给定的字段返回符合的对象
     * @param groupId 团id
     * @return 符合条件的唯一对象
     */
    @Override
    public Attention findByGroupId(Long groupId){
         return attentionRepository.findFirstByGroupId(groupId);
    }
    /**
     * 根据给定的字段返回符合的对象
     * @param goodsId 商品主键
     * @return 符合条件的唯一对象
     */
    @Override
    public Attention findByGoodsId(Long goodsId){
         return attentionRepository.findFirstByGoodsId(goodsId);
    }
    /**
     * 根据给定的字段返回符合的对象
     * @param userId 用户ID
     * @return 符合条件的唯一对象
     */
    @Override
    public Attention findByUserId(Long userId){
         return attentionRepository.findFirstByUserId(userId);
    }
    /**
     * 根据给定的字段返回符合的对象
     * @param openid openid
     * @return 符合条件的唯一对象
     */
    @Override
    public Attention findByOpenid(String openid){
         return attentionRepository.findFirstByOpenid(openid);
    }
    @Override 
    public Attention findBy(String field,Object value){
        log.info("商品或者团的关注根据字["+field+"="+value+"] 进行查询符合条件的唯一值");
        return attentionDao.findBy(field,value);
    }
    
    @Override 
    public List<Attention> findAllBy(String field,Object value){
        log.info("商品或者团的关注根据字["+field+"="+value+"] 进行查询符合条件的所有记录");
        return attentionDao.findAllBy(field,value);
    }
}