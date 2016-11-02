package com.mmk.business.service.impl;

import javax.annotation.Resource;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.mmk.gene.service.impl.BaseServiceImpl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.config.annotation.authentication.configurers.userdetails.DaoAuthenticationConfigurer;

import com.mmk.business.dao.GoodsRepository;
import com.mmk.business.model.Goods;
import com.mmk.business.condition.GoodsCondition;
import com.mmk.business.service.GoodsService;
import com.mmk.business.dao.GoodsDao;
/**
* GoodsServiceImpl: 商品活动 业务服务层实现
* 2016-10-31 10:48:36
* @author huguangling 胡广玲
* @version 1.0
*/
@Service
public class GoodsServiceImpl extends BaseServiceImpl<Goods, Long> implements GoodsService {

    private Log log = LogFactory.getLog(this.getClass());
    @Resource
    private GoodsDao goodsDao;
    
    private GoodsRepository goodsRepository;
    /**
    *构造方法
    * @param goodsRepository 数据容器
    */
    @Autowired
    public GoodsServiceImpl( GoodsRepository goodsRepository) {
        super(goodsRepository);
        this.goodsRepository = goodsRepository;
    }

    @Override
    public Page<Goods> list(GoodsCondition goodsCondition, Pageable pageable) {
        log.info("商品活动查询列表");
        return goodsDao.list(goodsCondition, pageable);
    }
    
    @Override
    public List<Goods> list(GoodsCondition goodsCondition) {
        log.info("商品活动查询列表无分页");
        return goodsDao.list(goodsCondition);
    }

    /**
     * 是否存在该
     * @param id 商品ID
     * @return 如果存在的话返回true ,没有的返回false
     */
    @Override
    public boolean existsId(Long id){
        return goodsRepository.findFirstById(id)!=null;
    }
    /**
     * 根据给定的字段返回符合的对象
     * @param id 商品ID
     * @return 符合条件的唯一对象
     */
    @Override
    public Goods findById(Long id){
         return goodsRepository.findFirstById(id);
    }
    /**
     * 根据字段获取所有符合的记录
     * @param id 商品ID
     * @return 符合条件的所有对象
     */
    @Override
    public List<Goods>  findAllById(Long id){
        return goodsRepository.findAllById(id);
    }
    
     @Override
    public Page<Goods>  findAllById(Long id, Pageable pageable){
        return goodsRepository.findAllById(id,pageable);
    }
    @Override 
    public Goods findBy(String field,Object value){
        log.info("商品活动根据字["+field+"="+value+"] 进行查询符合条件的唯一值");
        return goodsDao.findBy(field,value);
    }
    
    @Override 
    public List<Goods> findAllBy(String field,Object value){
        log.info("商品活动根据字["+field+"="+value+"] 进行查询符合条件的所有记录");
        return goodsDao.findAllBy(field,value);
    }

	@Override
	public Long findMaxId() {
		log.info("获取最新保存的商品ID");
		return goodsDao.findMaxId();
	}
}