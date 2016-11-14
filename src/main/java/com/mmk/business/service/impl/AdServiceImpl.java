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
import com.mmk.business.dao.AdRepository;
import com.mmk.business.model.Ad;
import com.mmk.business.condition.AdCondition;
import com.mmk.business.service.AdService;
import com.mmk.business.dao.AdDao;
/**
* AdServiceImpl: 广告 业务服务层实现
* 2016-11-03 11:37:27
* @author huguangling 胡广玲
* @version 1.0
*/
@Service
public class AdServiceImpl extends BaseServiceImpl<Ad, Long> implements AdService {

    private Log log = LogFactory.getLog(this.getClass());
    @Resource
    private AdDao adDao;
    
    private AdRepository adRepository;
    /**
    *构造方法
    * @param adRepository 数据容器
    */
    @Autowired
    public AdServiceImpl( AdRepository adRepository) {
        super(adRepository);
        this.adRepository = adRepository;
    }

    @Override
    public Page<Ad> list(AdCondition adCondition, Pageable pageable) {
        log.info("广告查询列表");
        return adDao.list(adCondition, pageable);
    }
    
    @Override
    public List<Ad> list(AdCondition adCondition) {
        log.info("广告查询列表无分页");
        return adDao.list(adCondition);
    }

    /**
     * 是否存在该
     * @param positionId 位置ID
     * @return 如果存在的话返回true ,没有的返回false
     */
    @Override
    public boolean existsPositionId(Long positionId){
        return adRepository.findFirstByPositionId(positionId)!=null;
    }
    /**
     * 根据给定的字段返回符合的对象
     * @param positionId 位置ID
     * @return 符合条件的唯一对象
     */
    @Override
    public Ad findByPositionId(Long positionId){
         return adRepository.findFirstByPositionId(positionId);
    }
    /**
     * 根据字段获取所有符合的记录
     * @param positionId 位置ID
     * @return 符合条件的所有对象
     */
    @Override
    public List<Ad>  findAllByPositionId(Long positionId){
        return adRepository.findAllByPositionId(positionId);
    }
    
     @Override
    public Page<Ad>  findAllByPositionId(Long positionId, Pageable pageable){
        return adRepository.findAllByPositionId(positionId,pageable);
    }
    @Override 
    public Ad findBy(String field,Object value){
        log.info("广告根据字["+field+"="+value+"] 进行查询符合条件的唯一值");
        return adDao.findBy(field,value);
    }
    
    @Override 
    public List<Ad> findAllBy(String field,Object value){
        log.info("广告根据字["+field+"="+value+"] 进行查询符合条件的所有记录");
        return adDao.findAllBy(field,value);
    }

	@Override
	public List<Ad> findAllByPositionCode(String code) {
		return adDao.findAllByPositionCode(code);
	}
}