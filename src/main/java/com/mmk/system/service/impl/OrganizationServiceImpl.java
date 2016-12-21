package com.mmk.system.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mmk.common.model.Tree;
import com.mmk.gene.service.impl.BaseServiceImpl;
import com.mmk.system.condition.OrganizationCondition;
import com.mmk.system.dao.OrganizationDao;
import com.mmk.system.dao.OrganizationRepository;
import com.mmk.system.model.Organization;
import com.mmk.system.service.OrganizationService;
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

	@Override
	public List<Tree> tree() {
		
		Tree root = new Tree();
		root.setId("");
		root.setText("公司部门");
		root.setChildren(new ArrayList<Tree>());
		
		Iterable<Organization> organizationList = findAll();
		List<Tree> temp = new ArrayList<Tree>();
		List<Tree> result = new ArrayList<Tree>();
		Map<String,Tree> helpMap = new HashMap<String,Tree>();
		for (Organization organization : organizationList) {
			Tree node = new Tree();
			node.setId(String.valueOf(organization.getId()));
			node.setPid(String.valueOf(organization.getParentId()));
			node.setText(String.valueOf(organization.getName()));
			node.setChildren(new ArrayList<Tree>());
			
			temp.add(node);
			
			helpMap.put(node.getId(), node);
		}
		
		for (Tree node : temp) {
			Tree parent = helpMap.get(node.getPid());
			if(parent!=null){
				parent.getChildren().add(node);
			}else{
				root.getChildren().add(node);
			}
		}
		
		result.add(root);
		return result;
	}

	@Override
	public List<Organization> treeGrid() {
		Iterable<Organization> organizationList = findAll();
		List<OrganizationCondition> temp = new ArrayList<OrganizationCondition>();
		List<Organization> result = new ArrayList<Organization>();
		Map<Long,OrganizationCondition> helpMap = new HashMap<Long,OrganizationCondition>();
		for (Organization organization : organizationList) {
			OrganizationCondition condition = new OrganizationCondition();
			condition.setId(organization.getId());
			condition.setParentId(organization.getParentId());
			condition.setCode(organization.getCode());
			condition.setName(organization.getName());
			helpMap.put(organization.getId(), condition);
			temp.add(condition);
		}
		for (OrganizationCondition organization : temp) {
			OrganizationCondition parent = helpMap.get(organization.getParentId());
			if(parent!=null){
				parent.getChildren().add(organization);
			}else{
				result.add(helpMap.get(organization.getId()));
			}
		}
		return result;
	}
}