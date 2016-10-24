package com.mmk.system.service.impl;

import javax.annotation.Resource;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.mmk.gene.service.impl.BaseServiceImpl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.mmk.system.dao.OrganizationRepository;
import com.mmk.system.model.Organization;
import com.mmk.system.condition.OrganizationCondition;
import com.mmk.system.service.OrganizationService;
import com.mmk.system.dao.OrganizationDao;
/**
* OrganizationServiceImpl: 组织机构 业务服务层实现
* 2016-10-24 10:07:36
* @author 孙中强 sunzhongqiang
* @version 1.0
*/
@Service
public class OrganizationServiceImpl extends BaseServiceImpl<Organization, Long> implements OrganizationService {

    private Log log = LogFactory.getLog(this.getClass());
    @Resource
    private OrganizationDao organizationDao;
    
    private OrganizationRepository organizationRepository;
    /**
    *构造方法
    * @param organizationRepository 数据容器
    */
    @Autowired
    public OrganizationServiceImpl( OrganizationRepository organizationRepository) {
        super(organizationRepository);
        this.organizationRepository = organizationRepository;
    }

    @Override
    public Page<Organization> list(OrganizationCondition organizationCondition, Pageable pageable) {
        log.info("组织机构查询列表");
        return organizationDao.list(organizationCondition, pageable);
    }
    
    @Override
    public List<Organization> list(OrganizationCondition organizationCondition) {
        log.info("组织机构查询列表无分页");
        return organizationDao.list(organizationCondition);
    }

    @Override 
    public Organization findBy(String field,Object value){
        log.info("组织机构根据字["+field+"="+value+"] 进行查询符合条件的唯一值");
        return organizationDao.findBy(field,value);
    }
    
    @Override 
    public List<Organization> findAllBy(String field,Object value){
        log.info("组织机构根据字["+field+"="+value+"] 进行查询符合条件的所有记录");
        return organizationDao.findAllBy(field,value);
    }
}