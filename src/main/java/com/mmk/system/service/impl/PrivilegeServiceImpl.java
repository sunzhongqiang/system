package com.mmk.system.service.impl;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.mmk.common.model.Tree;
import com.mmk.gene.service.impl.BaseServiceImpl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.mmk.system.dao.PrivilegeRepository;
import com.mmk.system.model.Organization;
import com.mmk.system.model.Privilege;
import com.mmk.system.condition.OrganizationCondition;
import com.mmk.system.condition.PrivilegeCondition;
import com.mmk.system.service.PrivilegeService;
import com.mmk.system.dao.PrivilegeDao;
/**
* PrivilegeServiceImpl: 系统权限表 业务服务层实现
* 2016-10-25 09:35:10
* @author 
* @version 1.0
*/
@Service
public class PrivilegeServiceImpl extends BaseServiceImpl<Privilege, Long> implements PrivilegeService {

    private Log log = LogFactory.getLog(this.getClass());
    @Resource
    private PrivilegeDao privilegeDao;
    
    private PrivilegeRepository privilegeRepository;
    /**
    *构造方法
    * @param privilegeRepository 数据容器
    */
    @Autowired
    public PrivilegeServiceImpl( PrivilegeRepository privilegeRepository) {
        super(privilegeRepository);
        this.privilegeRepository = privilegeRepository;
    }

    @Override
    public Page<Privilege> list(PrivilegeCondition privilegeCondition, Pageable pageable) {
        log.info("系统权限表查询列表");
        return privilegeDao.list(privilegeCondition, pageable);
    }
    
    @Override
    public List<Privilege> list(PrivilegeCondition privilegeCondition) {
        log.info("系统权限表查询列表无分页");
        return privilegeDao.list(privilegeCondition);
    }

    @Override 
    public Privilege findBy(String field,Object value){
        log.info("系统权限表根据字["+field+"="+value+"] 进行查询符合条件的唯一值");
        return privilegeDao.findBy(field,value);
    }
    
    @Override 
    public List<Privilege> findAllBy(String field,Object value){
        log.info("系统权限表根据字["+field+"="+value+"] 进行查询符合条件的所有记录");
        return privilegeDao.findAllBy(field,value);
    }

	@Override
	public Privilege findByIdAndFunctionID(Long roleId, Long functionId) {
		return privilegeDao.findByIdAndFunctionID(roleId, functionId);
	}

	@Override
	public List<Tree> findFunctionTreeByRoleId(Long roleId) {
		List<Map<String, Object>> rolePrivilege = privilegeDao.findRolePrivilege(roleId);
		List<Tree> tree = new ArrayList<Tree>();
		List<Tree> temp = new ArrayList<Tree>();
		Map<String,Tree> helpMap = new HashMap<String,Tree>();
		for (Map<String, Object> map : rolePrivilege) {
			Long functionId = MapUtils.getLong(map, "functionId");
			Tree treeNode = new Tree();
			treeNode.setText(MapUtils.getString(map, "functionName"));
			treeNode.setId(MapUtils.getString(map, "functionId"));
			treeNode.setChildren(new ArrayList<Tree>());
			treeNode.setPid(MapUtils.getString(map, "parentId"));
			boolean checked = map.get("privilegeId")!=null;
			treeNode.setChecked(checked );
			
			temp.add(treeNode);
			helpMap.put(treeNode.getId(), treeNode);
		}
		
		
		for (Tree child : temp) {
			
			Tree parent = helpMap.get(child.getPid());
			if(parent == null){
				tree.add(child);
			}else{
				parent.getChildren().add(child);
			}
		}
		
		return tree;
	}

	@Override
	public Privilege findByRoleIdAndPrivilegeID(Long roleId, String privilegeID) {
		return privilegeDao.findByRoleIdAndPrivilegeID(roleId, privilegeID);
	}

}