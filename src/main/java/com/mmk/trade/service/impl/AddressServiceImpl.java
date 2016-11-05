package com.mmk.trade.service.impl;

import javax.annotation.Resource;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.mmk.gene.service.impl.BaseServiceImpl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.mmk.trade.dao.AddressRepository;
import com.mmk.trade.model.Address;
import com.mmk.trade.condition.AddressCondition;
import com.mmk.trade.service.AddressService;
import com.mmk.trade.dao.AddressDao;
/**
* AddressServiceImpl: 地址管理 业务服务层实现
* 2016-11-05 13:29:18
* @author huguangling 胡广玲
* @version 1.0
*/
@Service
public class AddressServiceImpl extends BaseServiceImpl<Address, Long> implements AddressService {

    private Log log = LogFactory.getLog(this.getClass());
    @Resource
    private AddressDao addressDao;
    
    private AddressRepository addressRepository;
    /**
    *构造方法
    * @param addressRepository 数据容器
    */
    @Autowired
    public AddressServiceImpl( AddressRepository addressRepository) {
        super(addressRepository);
        this.addressRepository = addressRepository;
    }

    @Override
    public Page<Address> list(AddressCondition addressCondition, Pageable pageable) {
        log.info("地址管理查询列表");
        return addressDao.list(addressCondition, pageable);
    }
    
    @Override
    public List<Address> list(AddressCondition addressCondition) {
        log.info("地址管理查询列表无分页");
        return addressDao.list(addressCondition);
    }

    /**
     * 是否存在该
     * @param userId 用户ID
     * @return 如果存在的话返回true ,没有的返回false
     */
    @Override
    public boolean existsUserId(Long userId){
        return addressRepository.findFirstByUserId(userId)!=null;
    }
    /**
     * 根据给定的字段返回符合的对象
     * @param userId 用户ID
     * @return 符合条件的唯一对象
     */
    @Override
    public Address findByUserId(Long userId){
         return addressRepository.findFirstByUserId(userId);
    }
    /**
     * 根据字段获取所有符合的记录
     * @param userId 用户ID
     * @return 符合条件的所有对象
     */
    @Override
    public List<Address>  findAllByUserId(Long userId){
        return addressRepository.findAllByUserId(userId);
    }
    
     @Override
    public Page<Address>  findAllByUserId(Long userId, Pageable pageable){
        return addressRepository.findAllByUserId(userId,pageable);
    }
    @Override 
    public Address findBy(String field,Object value){
        log.info("地址管理根据字["+field+"="+value+"] 进行查询符合条件的唯一值");
        return addressDao.findBy(field,value);
    }
    
    @Override 
    public List<Address> findAllBy(String field,Object value){
        log.info("地址管理根据字["+field+"="+value+"] 进行查询符合条件的所有记录");
        return addressDao.findAllBy(field,value);
    }
}