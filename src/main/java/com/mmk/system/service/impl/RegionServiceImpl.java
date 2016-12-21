package com.mmk.system.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mmk.gene.service.impl.BaseServiceImpl;
import com.mmk.system.condition.RegionCondition;
import com.mmk.system.dao.RegionDao;
import com.mmk.system.dao.RegionRepository;
import com.mmk.system.model.Region;
import com.mmk.system.service.RegionService;
/**
* RegionServiceImpl: 区域管理 业务服务层实现
* 2016-11-14 13:31:38
* @author huguangling 胡广玲
* @version 1.0
*/
@Service
public class RegionServiceImpl extends BaseServiceImpl<Region, Long> implements RegionService {

    private Log log = LogFactory.getLog(this.getClass());
    @Resource
    private RegionDao regionDao;
    
    private RegionRepository regionRepository;
    /**
    *构造方法
    * @param regionRepository 数据容器
    */
    @Autowired
    public RegionServiceImpl( RegionRepository regionRepository) {
        super(regionRepository);
        this.regionRepository = regionRepository;
    }

    @Override
    public Page<Region> list(RegionCondition regionCondition, Pageable pageable) {
        log.info("区域管理查询列表");
        return regionDao.list(regionCondition, pageable);
    }
    
    @Override
    public List<Region> list(RegionCondition regionCondition) {
        log.info("区域管理查询列表无分页");
        return regionDao.list(regionCondition);
    }

    /**
     * 根据给定的字段返回符合的对象
     * @param parentId 所属区域id
     * @return 符合条件的唯一对象
     */
    @Override
    public Region findByParentId(Long parentId){
         return regionRepository.findFirstByParentId(parentId);
    }
    /**
     * 根据给定的字段返回符合的对象
     * @param regionName 区域名称
     * @return 符合条件的唯一对象
     */
    @Override
    public Region findByRegionName(String regionName){
         return regionRepository.findFirstByRegionName(regionName);
    }
    @Override 
    public Region findBy(String field,Object value){
        log.info("区域管理根据字["+field+"="+value+"] 进行查询符合条件的唯一值");
        return regionDao.findBy(field,value);
    }
    
    @Override 
    public List<Region> findAllBy(String field,Object value){
        log.info("区域管理根据字["+field+"="+value+"] 进行查询符合条件的所有记录");
        return regionDao.findAllBy(field,value);
    }

	@Override
	public List<Region> findAllByParentId(Long parentId) {
		return regionRepository.findAllByParentId(parentId);
	}

	@Override
	public List<Region> loadByParentId(Long parentId) {
		return regionDao.loadByParentId(parentId);
	}
}