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
import com.mmk.system.dao.RoleRepository;
import com.mmk.system.model.Role;
import com.mmk.system.condition.RoleCondition;
import com.mmk.system.service.RoleService;
import com.mmk.system.dao.RoleDao;
/**
* RoleServiceImpl: 系统角色 业务服务层实现
* 2016-10-12 11:54:19
* @author sunzhongqiang 孙中强
* @version 1.0
*/
@Service
public class RoleServiceImpl extends BaseServiceImpl<Role, String> implements RoleService {

    private Log log = LogFactory.getLog(this.getClass());
    @Resource
    private RoleDao roleDao;
    
    private RoleRepository roleRepository;
    /**
    *构造方法
    * @param roleRepository 数据容器
    */
    @Autowired
    public RoleServiceImpl( RoleRepository roleRepository) {
        super(roleRepository);
        this.roleRepository = roleRepository;
    }

    @Override
    public Page<Role> list(RoleCondition roleCondition, Pageable pageable) {
        log.info("系统角色查询列表");
        return roleDao.list(roleCondition, pageable);
    }
    
    @Override
    public List<Role> list(RoleCondition roleCondition) {
        log.info("系统角色查询列表无分页");
        return roleDao.list(roleCondition);
    }

    @Override 
    public Role findBy(String field,Object value){
        log.info("系统角色根据字["+field+"="+value+"] 进行查询符合条件的唯一值");
        return roleDao.findBy(field,value);
    }
    
    @Override 
    public List<Role> findAllBy(String field,Object value){
        log.info("系统角色根据字["+field+"="+value+"] 进行查询符合条件的所有记录");
        return roleDao.findAllBy(field,value);
    }
}