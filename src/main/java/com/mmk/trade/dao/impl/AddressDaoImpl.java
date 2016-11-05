/*
 * 
 *  AddressDaoImpl 创建于 2016-11-05 13:29:18 版权归作者和作者当前组织所有
 */
package com.mmk.trade.dao.impl;

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

import com.mmk.trade.model.Address;
import com.mmk.trade.dao.AddressDao;

import com.mmk.trade.condition.AddressCondition;



/**
* AddressDaoImpl: 地址管理 数据持久层接口实现
*@author huguangling 胡广玲
*@version 1.0
*
*/
@Repository
public class AddressDaoImpl extends SpringDataQueryDaoImpl<Address> implements AddressDao {
    
    private Log log = LogFactory.getLog(this.getClass());
    
    public AddressDaoImpl(){
        super(Address.class);
    }
    
    /**
     * 分页查询相关信息，根据传入的bean类对象和分页对象page取得查询结果集List
     * @param addressCondition 查询类
     * @param pageable 传入的分页对象
     * @return 符合条件的查询结果集
     * @author huguangling 胡广玲
     * 
     */
    @Override 
    public Page<Address> list(AddressCondition addressCondition,Pageable pageable){
        StringBuffer sb=new StringBuffer("select model from Address model  where 1=1  ");
        Map<String,Object> params = new HashMap<String,Object>();
        return queryByJpql(sb.toString(), params, pageable);
    }

    @Override 
    public List<Address> list(AddressCondition addressCondition){
        StringBuffer sb=new StringBuffer("select model from Address model  where 1=1  ");
        Map<String,Object> params = new HashMap<String,Object>();
        return queryByJpql(sb.toString(), params);
    }
    
    
    @Override 
    public Page< Map<String,Object>> listBySql(AddressCondition condition,Pageable pageable){
        StringBuffer sb=new StringBuffer("select id,user_id,order_id,consignee,email,country,province,city,district,address,zipcode,tel,mobile,best_time from trade_address  where 1=1  ");
        Map<Integer,Object> params = new HashMap<Integer,Object>();
        return queryFieldsBySql(sb.toString(), params, pageable);
    }
    
    @Override 
    public Address findBy(String field,Object value){
        StringBuffer sb=new StringBuffer("select model from Address model  where model.");
        sb.append(field);
        sb.append(" = :value ");
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("value",value);
        List<Address> result = queryByJpql(sb.toString(), params,0l,1l);
        return result.isEmpty() ? null : result.get(0);
    }
    
    @Override 
    public List<Address> findAllBy(String field,Object value){
        StringBuffer sb=new StringBuffer("select model from Address model  where model.");
        sb.append(field);
       sb.append(" = :value ");
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("value",value);
        return queryByJpql(sb.toString(), params);
    }
    
    
}