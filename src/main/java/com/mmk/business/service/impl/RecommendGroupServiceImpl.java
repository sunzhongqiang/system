package com.mmk.business.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mmk.business.condition.RecommendGroupCondition;
import com.mmk.business.dao.RecommendGroupDao;
import com.mmk.business.dao.RecommendGroupRepository;
import com.mmk.business.model.RecommendGroup;
import com.mmk.business.service.RecommendGroupService;
import com.mmk.gene.service.impl.BaseServiceImpl;
/**
* RecommendGroupServiceImpl: 拼团推荐管理 业务服务层实现
* 2016-11-18 15:33:45
* @author huguangling 胡广玲
* @version 1.0
*/
@Service
public class RecommendGroupServiceImpl extends BaseServiceImpl<RecommendGroup, Long> implements RecommendGroupService {

    private Log log = LogFactory.getLog(this.getClass());
    @Resource
    private RecommendGroupDao recommendGroupDao;
    
    private RecommendGroupRepository recommendGroupRepository;
    /**
    *构造方法
    * @param recommendGroupRepository 数据容器
    */
    @Autowired
    public RecommendGroupServiceImpl( RecommendGroupRepository recommendGroupRepository) {
        super(recommendGroupRepository);
        this.recommendGroupRepository = recommendGroupRepository;
    }

    @Override
    public Page<RecommendGroup> list(RecommendGroupCondition recommendGroupCondition, Pageable pageable) {
        log.info("拼团推荐管理查询列表");
        return recommendGroupDao.list(recommendGroupCondition, pageable);
    }
    
    @Override
    public List<RecommendGroup> list(RecommendGroupCondition recommendGroupCondition) {
        log.info("拼团推荐管理查询列表无分页");
        return recommendGroupDao.list(recommendGroupCondition);
    }

    /**
     * 根据给定的字段返回符合的对象
     * @param id 主键
     * @return 符合条件的唯一对象
     */
    @Override
    public RecommendGroup findById(Long id){
         return recommendGroupRepository.findFirstById(id);
    }
    @Override 
    public RecommendGroup findBy(String field,Object value){
        log.info("拼团推荐管理根据字["+field+"="+value+"] 进行查询符合条件的唯一值");
        return recommendGroupDao.findBy(field,value);
    }
    
    @Override 
    public List<RecommendGroup> findAllBy(String field,Object value){
        log.info("拼团推荐管理根据字["+field+"="+value+"] 进行查询符合条件的所有记录");
        return recommendGroupDao.findAllBy(field,value);
    }
    

	@Override
	public RecommendGroup findByPositionId(Long positionId, Long goodId) {
        log.info("推荐商品 ");
        return recommendGroupDao.findByPositionId(positionId,goodId);
	}

	@Override
	public List<RecommendGroup> findByPosition(Long positionId) {
        log.info("查找对应位置下的推荐团 ");
        return recommendGroupDao.findByPosition(positionId);
	}
}