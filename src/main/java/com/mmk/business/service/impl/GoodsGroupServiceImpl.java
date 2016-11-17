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
import com.mmk.business.dao.GoodsGroupRepository;
import com.mmk.business.model.GoodsGroup;
import com.mmk.business.condition.GoodsGroupCondition;
import com.mmk.business.service.GoodsGroupService;
import com.mmk.business.dao.GoodsGroupDao;
/**
* GoodsGroupServiceImpl: 商品拼团管理 业务服务层实现
* 2016-11-17 11:30:52
* @author 孙中强 sunzhongqiang
* @version 1.0
*/
@Service
public class GoodsGroupServiceImpl extends BaseServiceImpl<GoodsGroup, Long> implements GoodsGroupService {

    private Log log = LogFactory.getLog(this.getClass());
    @Resource
    private GoodsGroupDao goodsGroupDao;
    
    private GoodsGroupRepository goodsGroupRepository;
    /**
    *构造方法
    * @param goodsGroupRepository 数据容器
    */
    @Autowired
    public GoodsGroupServiceImpl( GoodsGroupRepository goodsGroupRepository) {
        super(goodsGroupRepository);
        this.goodsGroupRepository = goodsGroupRepository;
    }

    @Override
    public Page<GoodsGroup> list(GoodsGroupCondition goodsGroupCondition, Pageable pageable) {
        log.info("商品拼团管理查询列表");
        return goodsGroupDao.list(goodsGroupCondition, pageable);
    }
    
    @Override
    public List<GoodsGroup> list(GoodsGroupCondition goodsGroupCondition) {
        log.info("商品拼团管理查询列表无分页");
        return goodsGroupDao.list(goodsGroupCondition);
    }

    /**
     * 根据给定的字段返回符合的对象
     * @param id 主键
     * @return 符合条件的唯一对象
     */
    @Override
    public GoodsGroup findById(Long id){
         return goodsGroupRepository.findFirstById(id);
    }
    /**
     * 根据字段获取所有符合的记录
     * @param goodsId 商品主键
     * @return 符合条件的所有对象
     */
    @Override
    public List<GoodsGroup>  findAllByGoodsId(Long goodsId){
        return goodsGroupRepository.findAllByGoodsId(goodsId);
    }
    
     @Override
    public Page<GoodsGroup>  findAllByGoodsId(Long goodsId, Pageable pageable){
        return goodsGroupRepository.findAllByGoodsId(goodsId,pageable);
    }
    @Override 
    public GoodsGroup findBy(String field,Object value){
        log.info("商品拼团管理根据字["+field+"="+value+"] 进行查询符合条件的唯一值");
        return goodsGroupDao.findBy(field,value);
    }
    
    @Override 
    public List<GoodsGroup> findAllBy(String field,Object value){
        log.info("商品拼团管理根据字["+field+"="+value+"] 进行查询符合条件的所有记录");
        return goodsGroupDao.findAllBy(field,value);
    }
}