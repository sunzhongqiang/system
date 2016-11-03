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
import com.mmk.business.dao.AdPositionRepository;
import com.mmk.business.model.AdPosition;
import com.mmk.business.condition.AdPositionCondition;
import com.mmk.business.service.AdPositionService;
import com.mmk.business.dao.AdPositionDao;
/**
* AdPositionServiceImpl: 广告位置 业务服务层实现
* 2016-11-03 11:37:58
* @author huguangling 胡广玲
* @version 1.0
*/
@Service
public class AdPositionServiceImpl extends BaseServiceImpl<AdPosition, Long> implements AdPositionService {

    private Log log = LogFactory.getLog(this.getClass());
    @Resource
    private AdPositionDao adPositionDao;
    
    private AdPositionRepository adPositionRepository;
    /**
    *构造方法
    * @param adPositionRepository 数据容器
    */
    @Autowired
    public AdPositionServiceImpl( AdPositionRepository adPositionRepository) {
        super(adPositionRepository);
        this.adPositionRepository = adPositionRepository;
    }

    @Override
    public Page<AdPosition> list(AdPositionCondition adPositionCondition, Pageable pageable) {
        log.info("广告位置查询列表");
        return adPositionDao.list(adPositionCondition, pageable);
    }
    
    @Override
    public List<AdPosition> list(AdPositionCondition adPositionCondition) {
        log.info("广告位置查询列表无分页");
        return adPositionDao.list(adPositionCondition);
    }

    /**
     * 是否存在该
     * @param positionId 广告位ID
     * @return 如果存在的话返回true ,没有的返回false
     */
    @Override
    public boolean existsPositionId(Long positionId){
        return adPositionRepository.findFirstByPositionId(positionId)!=null;
    }
    /**
     * 根据给定的字段返回符合的对象
     * @param positionId 广告位ID
     * @return 符合条件的唯一对象
     */
    @Override
    public AdPosition findByPositionId(Long positionId){
         return adPositionRepository.findFirstByPositionId(positionId);
    }
    /**
     * 根据字段获取所有符合的记录
     * @param positionId 广告位ID
     * @return 符合条件的所有对象
     */
    @Override
    public List<AdPosition>  findAllByPositionId(Long positionId){
        return adPositionRepository.findAllByPositionId(positionId);
    }
    
     @Override
    public Page<AdPosition>  findAllByPositionId(Long positionId, Pageable pageable){
        return adPositionRepository.findAllByPositionId(positionId,pageable);
    }
    @Override 
    public AdPosition findBy(String field,Object value){
        log.info("广告位置根据字["+field+"="+value+"] 进行查询符合条件的唯一值");
        return adPositionDao.findBy(field,value);
    }
    
    @Override 
    public List<AdPosition> findAllBy(String field,Object value){
        log.info("广告位置根据字["+field+"="+value+"] 进行查询符合条件的所有记录");
        return adPositionDao.findAllBy(field,value);
    }
}