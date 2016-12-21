package com.mmk.business.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mmk.business.condition.FavoriteCondition;
import com.mmk.business.dao.FavoriteDao;
import com.mmk.business.dao.FavoriteRepository;
import com.mmk.business.model.Favorite;
import com.mmk.business.service.FavoriteService;
import com.mmk.gene.service.impl.BaseServiceImpl;
/**
* FavoriteServiceImpl: 团收藏 业务服务层实现
* 2016-11-30 09:24:22
* @author huguangling 胡广玲
* @version 1.0
*/
@Service
public class FavoriteServiceImpl extends BaseServiceImpl<Favorite, Long> implements FavoriteService {

    private Log log = LogFactory.getLog(this.getClass());
    @Resource
    private FavoriteDao favoriteDao;
    
    private FavoriteRepository favoriteRepository;
    /**
    *构造方法
    * @param favoriteRepository 数据容器
    */
    @Autowired
    public FavoriteServiceImpl( FavoriteRepository favoriteRepository) {
        super(favoriteRepository);
        this.favoriteRepository = favoriteRepository;
    }

    @Override
    public Page<Favorite> list(FavoriteCondition favoriteCondition, Pageable pageable) {
        log.info("团收藏查询列表");
        return favoriteDao.list(favoriteCondition, pageable);
    }
    
    @Override
    public List<Favorite> list(FavoriteCondition favoriteCondition) {
        log.info("团收藏查询列表无分页");
        return favoriteDao.list(favoriteCondition);
    }

    /**
     * 根据给定的字段返回符合的对象
     * @param id 收藏主键
     * @return 符合条件的唯一对象
     */
    @Override
    public Favorite findById(Long id){
         return favoriteRepository.findFirstById(id);
    }
    /**
     * 根据给定的字段返回符合的对象
     * @param goodsId 商品主键
     * @return 符合条件的唯一对象
     */
    @Override
    public Favorite findByGoodsId(Long goodsId){
         return favoriteRepository.findFirstByGoodsId(goodsId);
    }
    /**
     * 根据给定的字段返回符合的对象
     * @param userId 用户ID
     * @return 符合条件的唯一对象
     */
    @Override
    public Favorite findByUserId(Long userId){
         return favoriteRepository.findFirstByUserId(userId);
    }
    /**
     * 根据给定的字段返回符合的对象
     * @param openid openid
     * @return 符合条件的唯一对象
     */
    @Override
    public Favorite findByOpenid(String openid){
         return favoriteRepository.findFirstByOpenid(openid);
    }
    @Override 
    public Favorite findBy(String field,Object value){
        log.info("团收藏根据字["+field+"="+value+"] 进行查询符合条件的唯一值");
        return favoriteDao.findBy(field,value);
    }
    
    @Override 
    public List<Favorite> findAllBy(String field,Object value){
        log.info("团收藏根据字["+field+"="+value+"] 进行查询符合条件的所有记录");
        return favoriteDao.findAllBy(field,value);
    }

	@Override
	public Page<Favorite> findAllByUserId(Long userId, Pageable pageable) {
		return favoriteDao.findAllByUserId(userId,pageable);
	}

	@Override
	public Favorite findByUserIdAndGroupId(Long userId, Long groupId) {
		return favoriteDao.findByUserIdAndGroupId(userId, groupId);
	}
}