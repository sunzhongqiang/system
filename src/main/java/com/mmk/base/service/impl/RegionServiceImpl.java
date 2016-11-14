package com.mmk.base.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mmk.base.condition.RegionCondition;
import com.mmk.base.dao.RegionDao;
import com.mmk.base.dao.RegionRepository;
import com.mmk.base.model.Region;
import com.mmk.base.service.RegionService;
import com.mmk.gene.service.impl.BaseServiceImpl;


@Service
public class RegionServiceImpl extends BaseServiceImpl<Region, Long> implements RegionService {
    @Resource
    private RegionDao regionDao;
	
    private RegionRepository regionRepository;
    /**
    *构造方法
    */
    @Autowired
    public RegionServiceImpl( RegionRepository regionRepository) {
        super(regionRepository);
        this.regionRepository = regionRepository;
    }
    
	@Override
	public Region findOne(Long id) {
		return regionRepository.findOne(id);
	}

	@Override
	public List<Region> findAll() {
		return regionRepository.findAll();
	}

	@Override
    public Page<Region> list(RegionCondition regionCondition, Pageable pageable) {
        return regionDao.list(regionCondition, pageable);
    }
    
    @Override
    public List<Region> list(RegionCondition regionCondition) {
        return regionDao.list(regionCondition);
    }

    /**
     * 根据给定的字段返回符合的对象
     * @param regionId 主键
     * @return 符合条件的唯一对象
     */
    @Override
    public Region findByRegionId(Long regionId){
         return regionRepository.findFirstByRegionId(regionId);
    }
    /**
     * 根据字段获取所有符合的记录
     * @param parentId 所属区域id
     * @return 符合条件的所有对象
     */
    @Override
    public List<Region>  findAllByParentId(Long parentId){
        return regionRepository.findAllByParentId(parentId);
    }
    
     @Override
    public Page<Region>  findAllByParentId(Long parentId, Pageable pageable){
        return regionRepository.findAllByParentId(parentId,pageable);
    }
    /**
     * 是否存在该
     * @param regionName 区域名称
     * @return 如果存在的话返回true ,没有的返回false
     */
    @Override
    public boolean existsRegionName(String regionName){
        return regionRepository.findFirstByRegionName(regionName)!=null;
    }
    /**
     * 根据字段获取所有符合的记录
     * @param regionType 区域级别货类型
     * @return 符合条件的所有对象
     */
    @Override
    public List<Region>  findAllByRegionType(Long regionType){
        return regionRepository.findAllByRegionType(regionType);
    }
    
     @Override
    public Page<Region>  findAllByRegionType(Long regionType, Pageable pageable){
        return regionRepository.findAllByRegionType(regionType,pageable);
    }
    @Override 
    public Region findBy(String field,Object value){
        return regionDao.findBy(field,value);
    }
    
    @Override 
    public List<Region> findAllBy(String field,Object value){
        return regionDao.findAllBy(field,value);
    }
}
