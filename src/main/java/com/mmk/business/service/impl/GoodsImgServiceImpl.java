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
import com.mmk.business.dao.GoodsImgRepository;
import com.mmk.business.model.GoodsImg;
import com.mmk.business.condition.GoodsImgCondition;
import com.mmk.business.service.GoodsImgService;
import com.mmk.business.dao.GoodsImgDao;
/**
* GoodsImgServiceImpl: 商品相册 业务服务层实现
* 2016-11-01 09:00:03
* @author huguangling  胡广玲
* @version 1.0
*/
@Service
public class GoodsImgServiceImpl extends BaseServiceImpl<GoodsImg, Long> implements GoodsImgService {

    private Log log = LogFactory.getLog(this.getClass());
    @Resource
    private GoodsImgDao goodsImgDao;
    
    private GoodsImgRepository goodsImgRepository;
    /**
    *构造方法
    * @param goodsImgRepository 数据容器
    */
    @Autowired
    public GoodsImgServiceImpl( GoodsImgRepository goodsImgRepository) {
        super(goodsImgRepository);
        this.goodsImgRepository = goodsImgRepository;
    }

    @Override
    public Page<GoodsImg> list(GoodsImgCondition goodsImgCondition, Pageable pageable) {
        log.info("商品相册查询列表");
        return goodsImgDao.list(goodsImgCondition, pageable);
    }
    
    @Override
    public List<GoodsImg> list(GoodsImgCondition goodsImgCondition) {
        log.info("商品相册查询列表无分页");
        return goodsImgDao.list(goodsImgCondition);
    }

    @Override 
    public GoodsImg findBy(String field,Object value){
        log.info("商品相册根据字["+field+"="+value+"] 进行查询符合条件的唯一值");
        return goodsImgDao.findBy(field,value);
    }
    
    @Override 
    public List<GoodsImg> findAllBy(String field,Object value){
        log.info("商品相册根据字["+field+"="+value+"] 进行查询符合条件的所有记录");
        return goodsImgDao.findAllBy(field,value);
    }

	@Override
	public List<GoodsImg> findByGoodsId(Long id) {
        log.info("根据商品ID查找相册");
        return goodsImgDao.findByGoodsId(id);
	}
}