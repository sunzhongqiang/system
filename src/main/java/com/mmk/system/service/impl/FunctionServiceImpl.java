package com.mmk.system.service.impl;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.mmk.common.model.Tree;
import com.mmk.gene.service.impl.BaseServiceImpl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.mmk.system.dao.FunctionRepository;
import com.mmk.system.model.Function;
import com.mmk.system.model.Organization;
import com.mmk.system.condition.FunctionCondition;
import com.mmk.system.condition.OrganizationCondition;
import com.mmk.system.service.FunctionService;
import com.mmk.system.dao.FunctionDao;
/**
* FunctionServiceImpl: 系统功能 业务服务层实现
* 2016-10-24 15:52:09
* @author huguangling 胡广玲
* @version 1.0
*/
@Service
public class FunctionServiceImpl extends BaseServiceImpl<Function, Long> implements FunctionService {

    private Log log = LogFactory.getLog(this.getClass());
    @Resource
    private FunctionDao functionDao;
    
    private FunctionRepository functionRepository;
    /**
    *构造方法
    * @param functionRepository 数据容器
    */
    @Autowired
    public FunctionServiceImpl( FunctionRepository functionRepository) {
        super(functionRepository);
        this.functionRepository = functionRepository;
    }

    @Override
    public Page<Function> list(FunctionCondition functionCondition, Pageable pageable) {
        log.info("系统功能查询列表");
        return functionDao.list(functionCondition, pageable);
    }
    
    @Override
    public List<Function> list(FunctionCondition functionCondition) {
        log.info("系统功能查询列表无分页");
        return functionDao.list(functionCondition);
    }

    @Override 
    public Function findBy(String field,Object value){
        log.info("系统功能根据字["+field+"="+value+"] 进行查询符合条件的唯一值");
        return functionDao.findBy(field,value);
    }
    
    @Override 
    public List<Function> findAllBy(String field,Object value){
        log.info("系统功能根据字["+field+"="+value+"] 进行查询符合条件的所有记录");
        return functionDao.findAllBy(field,value);
    }
    
    @Override
	public List<Function> gridTree(){
		Iterable<Function> functionList = findAll();
		List<FunctionCondition> temp = new ArrayList<FunctionCondition>();
		List<Function> result = new ArrayList<Function>();
		Map<Long,FunctionCondition> helpMap = new HashMap<Long,FunctionCondition>();
		for (Function function : functionList) {
			FunctionCondition condition = new FunctionCondition();
			condition.setId(function.getId());
			condition.setUri(function.getUri());
			condition.setName(function.getName());
			condition.setType(function.getType());
			condition.setParentId(function.getParentId());
			condition.setDescription(function.getDescription());
			helpMap.put(function.getId(), condition);
			temp.add(condition);
		}
		for (FunctionCondition organization : temp) {
			FunctionCondition parent = helpMap.get(organization.getParentId());
			if(parent!=null){
				parent.getChildren().add(organization);
			}else{
				result.add(helpMap.get(organization.getId()));
			}
		}
		return result;
    	
    }

	@Override
	public List<Tree> findUserMenu(List<Long> roleIdList) {
		List<Function> functionList = functionDao.findAllByRoleIds(roleIdList);
		return buildTree(functionList);
	}

	private List<Tree> buildTree(List<Function> functionList) {
		List<Tree> result = new ArrayList<Tree>();
		List<Tree> temp = new ArrayList<Tree>();
		Map<Long,Tree> helpMap = new HashMap<Long,Tree>();
		for (Function function : functionList) {
			Tree node = new Tree();
			node.setText(function.getName());
			node.setId(String.valueOf(function.getId()));
			Map<String,Object> attributes = new HashMap<String,Object>();
			attributes.put("url", function.getUri());
			node.setAttributes(attributes);
			node.setChildren(new ArrayList<Tree>());
			node.setPid(String.valueOf(function.getParentId()));
			temp.add(node);
			helpMap.put(function.getId(), node);
		}
		
		for (Tree node : temp) {
			Tree parent = helpMap.get(node.getPid());
			if(parent!=null){
				parent.getChildren().add(node);
			}else{
				result.add(node);
			}
		}
		return result;
	}
}