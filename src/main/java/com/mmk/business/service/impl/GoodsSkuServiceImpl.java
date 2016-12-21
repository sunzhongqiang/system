package com.mmk.business.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mmk.business.condition.GoodsSkuCondition;
import com.mmk.business.dao.GoodsSkuDao;
import com.mmk.business.dao.GoodsSkuRepository;
import com.mmk.business.model.GoodsSku;
import com.mmk.business.service.GoodsSkuService;
import com.mmk.gene.service.impl.BaseServiceImpl;
/**
* GoodsSkuServiceImpl: 商品SKU 业务服务层实现
* 2016-11-21 14:08:15
* @author sunzhongqiang 孙中强
* @version 1.0
*/
@Service
public class GoodsSkuServiceImpl extends BaseServiceImpl<GoodsSku, Long> implements GoodsSkuService {

    private Log log = LogFactory.getLog(this.getClass());
    @Resource
    private GoodsSkuDao goodsSkuDao;
    
    private GoodsSkuRepository goodsSkuRepository;
    /**
    *构造方法
    * @param goodsSkuRepository 数据容器
    */
    @Autowired
    public GoodsSkuServiceImpl( GoodsSkuRepository goodsSkuRepository) {
        super(goodsSkuRepository);
        this.goodsSkuRepository = goodsSkuRepository;
    }

    @Override
    public Page<GoodsSku> list(GoodsSkuCondition goodsSkuCondition, Pageable pageable) {
        log.info("商品SKU查询列表");
        return goodsSkuDao.list(goodsSkuCondition, pageable);
    }
    
    @Override
    public List<GoodsSku> list(GoodsSkuCondition goodsSkuCondition) {
        log.info("商品SKU查询列表无分页");
        return goodsSkuDao.list(goodsSkuCondition);
    }

    /**
     * 是否存在该
     * @param goodsId 商品id
     * @return 如果存在的话返回true ,没有的返回false
     */
    @Override
    public boolean existsGoodsId(Long goodsId){
        return goodsSkuRepository.findFirstByGoodsId(goodsId)!=null;
    }
    /**
     * 根据给定的字段返回符合的对象
     * @param goodsId 商品id
     * @return 符合条件的唯一对象
     */
    @Override
    public GoodsSku findByGoodsId(Long goodsId){
         return goodsSkuRepository.findFirstByGoodsId(goodsId);
    }
    /**
     * 根据字段获取所有符合的记录
     * @param goodsId 商品id
     * @return 符合条件的所有对象
     */
    @Override
    public List<GoodsSku>  findAllByGoodsId(Long goodsId){
        return goodsSkuRepository.findAllByGoodsId(goodsId);
    }
    
     @Override
    public Page<GoodsSku>  findAllByGoodsId(Long goodsId, Pageable pageable){
        return goodsSkuRepository.findAllByGoodsId(goodsId,pageable);
    }
    @Override 
    public GoodsSku findBy(String field,Object value){
        log.info("商品SKU根据字["+field+"="+value+"] 进行查询符合条件的唯一值");
        return goodsSkuDao.findBy(field,value);
    }
    
    @Override 
    public List<GoodsSku> findAllBy(String field,Object value){
        log.info("商品SKU根据字["+field+"="+value+"] 进行查询符合条件的所有记录");
        return goodsSkuDao.findAllBy(field,value);
    }
}