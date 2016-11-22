package com.mmk.business.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mmk.business.condition.RecommendGoodsCondition;
import com.mmk.business.dao.RecommendGoodsDao;
import com.mmk.business.dao.RecommendGoodsRepository;
import com.mmk.business.model.RecommendGoods;
import com.mmk.business.service.RecommendGoodsService;
import com.mmk.gene.service.impl.BaseServiceImpl;
/**
* RecommendGoodsServiceImpl: 商品 位置 关系表 业务服务层实现
* 2016-11-14 13:55:42
* @author huguangling 胡广玲
* @version 1.0
*/
@Service
public class RecommendGoodsServiceImpl extends BaseServiceImpl<RecommendGoods, Long> implements RecommendGoodsService {

    private Log log = LogFactory.getLog(this.getClass());
    @Resource
    private RecommendGoodsDao recommendGoodsDao;
    
    private RecommendGoodsRepository recommendGoodsRepository;
    /**
    *构造方法
    * @param recommendGoodsRepository 数据容器
    */
    @Autowired
    public RecommendGoodsServiceImpl( RecommendGoodsRepository recommendGoodsRepository) {
        super(recommendGoodsRepository);
        this.recommendGoodsRepository = recommendGoodsRepository;
    }

    @Override
    public Page<RecommendGoods> list(RecommendGoodsCondition recommendGoodsCondition, Pageable pageable) {
        log.info("商品 位置 关系表查询列表");
        return recommendGoodsDao.list(recommendGoodsCondition, pageable);
    }
    
    @Override
    public List<RecommendGoods> list(RecommendGoodsCondition recommendGoodsCondition) {
        log.info("商品 位置 关系表查询列表无分页");
        return recommendGoodsDao.list(recommendGoodsCondition);
    }

    /**
     * 根据给定的字段返回符合的对象
     * @param id 主键
     * @return 符合条件的唯一对象
     */
    @Override
    public RecommendGoods findById(Long id){
         return recommendGoodsRepository.findFirstById(id);
    }
    @Override 
    public RecommendGoods findBy(String field,Object value){
        log.info("商品 位置 关系表根据字["+field+"="+value+"] 进行查询符合条件的唯一值");
        return recommendGoodsDao.findBy(field,value);
    }
    
    @Override 
    public List<RecommendGoods> findAllBy(String field,Object value){
        log.info("商品 位置 关系表根据字["+field+"="+value+"] 进行查询符合条件的所有记录");
        return recommendGoodsDao.findAllBy(field,value);
    }

	@Override
	public RecommendGoods findByPositionId(Long positionId, Long goodsId) {
        log.info("推荐商品 ");
        return recommendGoodsDao.findByPositionId(positionId,goodsId);
	}

	@Override
	public List<RecommendGoods> findByPosition(Long positionId) {
        log.info("查找对应位置下的推荐商品 ");
        return recommendGoodsDao.findByPosition(positionId);
	}

}