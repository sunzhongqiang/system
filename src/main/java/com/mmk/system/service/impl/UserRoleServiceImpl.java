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
import com.mmk.system.dao.UserRoleRepository;
import com.mmk.system.model.UserRole;
import com.mmk.system.condition.UserRoleCondition;
import com.mmk.system.service.UserRoleService;
import com.mmk.system.dao.UserRoleDao;
/**
* UserRoleServiceImpl: 系统用户角色 业务服务层实现
* 2016-10-27 08:21:20
* @author code
* @version 1.0
*/
@Service
public class UserRoleServiceImpl extends BaseServiceImpl<UserRole, Long> implements UserRoleService {

    private Log log = LogFactory.getLog(this.getClass());
    @Resource
    private UserRoleDao userRoleDao;
    
    private UserRoleRepository userRoleRepository;
    /**
    *构造方法
    * @param userRoleRepository 数据容器
    */
    @Autowired
    public UserRoleServiceImpl( UserRoleRepository userRoleRepository) {
        super(userRoleRepository);
        this.userRoleRepository = userRoleRepository;
    }

    @Override
    public Page<UserRole> list(UserRoleCondition userRoleCondition, Pageable pageable) {
        log.info("系统用户角色查询列表");
        return userRoleDao.list(userRoleCondition, pageable);
    }
    
    @Override
    public List<UserRole> list(UserRoleCondition userRoleCondition) {
        log.info("系统用户角色查询列表无分页");
        return userRoleDao.list(userRoleCondition);
    }

    /**
     * 根据字段获取所有符合的记录
     * @param userId 用户主键
     * @return 符合条件的所有对象
     */
    @Override
    public List<UserRole>  findAllByUserId(Long userId){
        return userRoleRepository.findAllByUserId(userId);
    }
    
     @Override
    public Page<UserRole>  findAllByUserId(Long userId, Pageable pageable){
        return userRoleRepository.findAllByUserId(userId,pageable);
    }
    /**
     * 根据字段获取所有符合的记录
     * @param roleId 角色主键
     * @return 符合条件的所有对象
     */
    @Override
    public List<UserRole>  findAllByRoleId(Long roleId){
        return userRoleRepository.findAllByRoleId(roleId);
    }
    
     @Override
    public Page<UserRole>  findAllByRoleId(Long roleId, Pageable pageable){
        return userRoleRepository.findAllByRoleId(roleId,pageable);
    }
    @Override 
    public UserRole findBy(String field,Object value){
        log.info("系统用户角色根据字["+field+"="+value+"] 进行查询符合条件的唯一值");
        return userRoleDao.findBy(field,value);
    }
    
    @Override 
    public List<UserRole> findAllBy(String field,Object value){
        log.info("系统用户角色根据字["+field+"="+value+"] 进行查询符合条件的所有记录");
        return userRoleDao.findAllBy(field,value);
    }
}