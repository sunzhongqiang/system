package com.mmk.business.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mmk.business.condition.RecommendPositionCondition;
import com.mmk.business.dao.RecommendPositionDao;
import com.mmk.business.dao.RecommendPositionRepository;
import com.mmk.business.model.RecommendPosition;
import com.mmk.business.service.RecommendPositionService;
import com.mmk.gene.service.impl.BaseServiceImpl;

/**
 * RecommendPositionServiceImpl: 位置表 业务服务层实现 2016-11-14 13:56:04
 * 
 * @author huguangling 胡广玲
 * @version 1.0
 */
@Service
public class RecommendPositionServiceImpl extends BaseServiceImpl<RecommendPosition, Long>
		implements RecommendPositionService {

	private Log log = LogFactory.getLog(this.getClass());
	@Resource
	private RecommendPositionDao recommendPositionDao;

	private RecommendPositionRepository recommendPositionRepository;

	/**
	 * 构造方法
	 * 
	 * @param recommendPositionRepository 数据容器
	 */
	@Autowired
	public RecommendPositionServiceImpl(RecommendPositionRepository recommendPositionRepository) {
		super(recommendPositionRepository);
		this.recommendPositionRepository = recommendPositionRepository;
	}

	@Override
	public Page<RecommendPosition> list(RecommendPositionCondition recommendPositionCondition, Pageable pageable) {
		log.info("位置表查询列表");
		return recommendPositionDao.list(recommendPositionCondition, pageable);
	}

	@Override
	public List<RecommendPosition> list(RecommendPositionCondition recommendPositionCondition) {
		log.info("位置表查询列表无分页");
		return recommendPositionDao.list(recommendPositionCondition);
	}

	/**
	 * 根据给定的字段返回符合的对象
	 * 
	 * @param id  id
	 * @return 符合条件的唯一对象
	 */
	@Override
	public RecommendPosition findById(Long id) {
		return recommendPositionRepository.findFirstById(id);
	}

	@Override
	public RecommendPosition findBy(String field, Object value) {
		log.info("位置表根据字[" + field + "=" + value + "] 进行查询符合条件的唯一值");
		return recommendPositionDao.findBy(field, value);
	}

	@Override
	public List<RecommendPosition> findAllBy(String field, Object value) {
		log.info("位置表根据字[" + field + "=" + value + "] 进行查询符合条件的所有记录");
		return recommendPositionDao.findAllBy(field, value);
	}
}