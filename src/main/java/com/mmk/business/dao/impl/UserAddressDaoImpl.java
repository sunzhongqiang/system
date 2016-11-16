/*
 * 
 *  UserAddressDaoImpl 创建于 2016-11-16 09:37:58 版权归作者和作者当前组织所有
 */
package com.mmk.business.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import javax.annotation.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import com.mmk.gene.dao.impl.SpringDataQueryDaoImpl;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.mmk.business.model.UserAddress;
import com.mmk.business.dao.UserAddressDao;

import com.mmk.business.condition.UserAddressCondition;



/**
* UserAddressDaoImpl: 会员地址 数据持久层接口实现
*@author huguangling 胡广玲
*@version 1.0
*
*/
@Repository
public class UserAddressDaoImpl extends SpringDataQueryDaoImpl<UserAddress> implements UserAddressDao {
    
    private Log log = LogFactory.getLog(this.getClass());
    
    public UserAddressDaoImpl(){
        super(UserAddress.class);
    }
    
    /**
     * 分页查询相关信息，根据传入的bean类对象和分页对象page取得查询结果集List
     * @param userAddressCondition 查询类
     * @param pageable 传入的分页对象
     * @return 符合条件的查询结果集
     * @author huguangling 胡广玲
     * 
     */
    @Override 
    public Page<UserAddress> list(UserAddressCondition userAddressCondition,Pageable pageable){
        StringBuffer sb=new StringBuffer("select model from UserAddress model  where 1=1  ");
        Map<String,Object> params = new HashMap<String,Object>();
        if(userAddressCondition.getUserId()!=null){
            sb.append(" and model.userId = :userId ");
            params.put("userId",userAddressCondition.getUserId());
        }
        if(StringUtils.isNotBlank(userAddressCondition.getConsignee())){
            sb.append(" and model.consignee like :consignee ");
            params.put("consignee","%"+userAddressCondition.getConsignee()+"%");
        }
        if(userAddressCondition.getProvince()!=null){
            sb.append(" and model.province = :province ");
            params.put("province",userAddressCondition.getProvince());
        }
        if(userAddressCondition.getCity()!=null){
            sb.append(" and model.city = :city ");
            params.put("city",userAddressCondition.getCity());
        }
        if(userAddressCondition.getDistrict()!=null){
            sb.append(" and model.district = :district ");
            params.put("district",userAddressCondition.getDistrict());
        }
        if(StringUtils.isNotBlank(userAddressCondition.getMobile())){
            sb.append(" and model.mobile like :mobile ");
            params.put("mobile","%"+userAddressCondition.getMobile()+"%");
        }
        return queryByJpql(sb.toString(), params, pageable);
    }

    @Override 
    public List<UserAddress> list(UserAddressCondition userAddressCondition){
        StringBuffer sb=new StringBuffer("select model from UserAddress model  where 1=1  ");
        Map<String,Object> params = new HashMap<String,Object>();
        if(userAddressCondition.getUserId()!=null){
            sb.append(" and model.userId = :userId ");
            params.put("userId",userAddressCondition.getUserId());
        }
        if(StringUtils.isNotBlank(userAddressCondition.getConsignee())){
            sb.append(" and model.consignee like :consignee ");
            params.put("consignee","%"+userAddressCondition.getConsignee()+"%");
        }
        if(userAddressCondition.getProvince()!=null){
            sb.append(" and model.province = :province ");
            params.put("province",userAddressCondition.getProvince());
        }
        if(userAddressCondition.getCity()!=null){
            sb.append(" and model.city = :city ");
            params.put("city",userAddressCondition.getCity());
        }
        if(userAddressCondition.getDistrict()!=null){
            sb.append(" and model.district = :district ");
            params.put("district",userAddressCondition.getDistrict());
        }
        if(StringUtils.isNotBlank(userAddressCondition.getMobile())){
            sb.append(" and model.mobile like :mobile ");
            params.put("mobile","%"+userAddressCondition.getMobile()+"%");
        }
        return queryByJpql(sb.toString(), params);
    }
    
    
    @Override 
    public Page< Map<String,Object>> listBySql(UserAddressCondition condition,Pageable pageable){
        StringBuffer sb=new StringBuffer("select id,address_name,user_id,openid,consignee,email,country,county_name,province,province_name,city,city_name,district,district_name,address,zipcode,tel,mobile from business_user_address  where 1=1  ");
        Map<Integer,Object> params = new HashMap<Integer,Object>();
        if(condition.getUserId()!=null){
            sb.append(" and user_id = ?3 ");
            params.put(3,condition.getUserId());
        }
        if(StringUtils.isNotBlank(condition.getConsignee())){
            sb.append(" and consignee like ?5 ");
            params.put(5,"%"+condition.getConsignee()+"%");
        }
        if(condition.getProvince()!=null){
            sb.append(" and province = ?9 ");
            params.put(9,condition.getProvince());
        }
        if(condition.getCity()!=null){
            sb.append(" and city = ?11 ");
            params.put(11,condition.getCity());
        }
        if(condition.getDistrict()!=null){
            sb.append(" and district = ?13 ");
            params.put(13,condition.getDistrict());
        }
        if(StringUtils.isNotBlank(condition.getMobile())){
            sb.append(" and mobile like ?18 ");
            params.put(18,"%"+condition.getMobile()+"%");
        }
        return queryFieldsBySql(sb.toString(), params, pageable);
    }
    
    @Override 
    public UserAddress findBy(String field,Object value){
        StringBuffer sb=new StringBuffer("select model from UserAddress model  where model.");
        sb.append(field);
        sb.append(" = :value ");
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("value",value);
        List<UserAddress> result = queryByJpql(sb.toString(), params,0l,1l);
        return result.isEmpty() ? null : result.get(0);
    }
    
    @Override 
    public List<UserAddress> findAllBy(String field,Object value){
        StringBuffer sb=new StringBuffer("select model from UserAddress model  where model.");
        sb.append(field);
       sb.append(" = :value ");
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("value",value);
        return queryByJpql(sb.toString(), params);
    }
    
    
}