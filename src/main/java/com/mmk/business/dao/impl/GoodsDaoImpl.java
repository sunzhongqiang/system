/*
 * 
 *  GoodsDaoImpl 创建于 2016-10-31 10:48:36 版权归作者和作者当前组织所有
 */
package com.mmk.business.dao.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Repository;

import com.mmk.business.condition.GoodsCondition;
import com.mmk.business.dao.GoodsDao;
import com.mmk.business.model.Goods;
import com.mmk.gene.dao.impl.SpringDataQueryDaoImpl;

/**
 * GoodsDaoImpl: 商品活动 数据持久层接口实现
 * 
 * @author huguangling 胡广玲
 * @version 1.0
 *
 */
@Repository
public class GoodsDaoImpl extends SpringDataQueryDaoImpl<Goods> implements GoodsDao {

	private Log log = LogFactory.getLog(this.getClass());

	public GoodsDaoImpl() {
		super(Goods.class);
	}

	/**
	 * 分页查询相关信息，根据传入的bean类对象和分页对象page取得查询结果集List
	 * 
	 * @param goodsCondition  查询类
	 * @param pageable  传入的分页对象
	 * @return 符合条件的查询结果集
	 * @author huguangling 胡广玲
	 * 
	 */
	@Override
	public Page<Goods> list(GoodsCondition goodsCondition, Pageable pageable) {
		StringBuffer sb = new StringBuffer("select model from Goods model  where 1=1  ");
		Map<String, Object> params = new HashMap<String, Object>();
	    if(goodsCondition.getIsOnsale()!=null){
            sb.append(" and model.isOnsale = :isOnsale ");
            params.put("isOnsale",goodsCondition.getIsOnsale());
        }
        if(StringUtils.isNotBlank(goodsCondition.getGoodsName())){
            sb.append(" and model.goodsName like :goodsName ");
            params.put("goodsName","%"+goodsCondition.getGoodsName()+"%");
        }
        Sort sort = pageable.getSort();
		if (sort != null) {
			sb.append(" order by ");
			for (Order order : sort) {
				sb.append(" model.".concat(order.getProperty()));
				sb.append(" ".concat(order.getDirection().toString()));
			}
		} else {
			 sb.append(" order by model.id desc ");
		}
		return queryByJpql(sb.toString(), params, pageable);
	}

	@Override
	public List<Goods> list(GoodsCondition goodsCondition) {
		StringBuffer sb = new StringBuffer("select model from Goods model  where 1=1  ");
		Map<String, Object> params = new HashMap<String, Object>();
		return queryByJpql(sb.toString(), params);
	}

	@Override
	public Page<Map<String, Object>> listBySql(GoodsCondition condition, Pageable pageable) {
		StringBuffer sb = new StringBuffer(
				"select id,goods_cat,goods_name,goods_number,goods_original_price,promote_price,promote_start_date,promote_end_date,promote_number,saled_number,goods_thumb,goods_main_img,goods_original_img,is_delete from business_goods  where 1=1  ");
		Map<Integer, Object> params = new HashMap<Integer, Object>();
		return queryFieldsBySql(sb.toString(), params, pageable);
	}

	@Override
	public Goods findBy(String field, Object value) {
		StringBuffer sb = new StringBuffer("select model from Goods model  where model.");
		sb.append(field);
		sb.append(" = :value ");
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("value", value);
		List<Goods> result = queryByJpql(sb.toString(), params, 0l, 1l);
		return result.isEmpty() ? null : result.get(0);
	}

	@Override
	public List<Goods> findAllBy(String field, Object value) {
		StringBuffer sb = new StringBuffer("select model from Goods model  where model.");
		sb.append(field);
		sb.append(" = :value ");
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("value", value);
		return queryByJpql(sb.toString(), params);
	}

	@Override
	public List<Object[]> findGoodsGrid(Long positionId) {
		StringBuffer sb = new StringBuffer(
				"select model,recommendGoods from Goods model,RecommendGoods recommendGoods where recommendGoods.goodsId = model.id ");
		Map<String, Object> params = new HashMap<String, Object>();
		sb.append(" and recommendGoods.positionId = :positionId ");
		params.put("positionId", positionId);
		sb.append(" order by recommendGoods.orderby asc ");

		return queryArrayByJpql(sb.toString(), params);

	}

	@Override
	public List<Object[]> findGroupsGrid(Long positionId, Pageable pageable) {
		StringBuffer sb = new StringBuffer();
		sb.append("select model,recommendGroup ");
		sb.append(" from Goods model,  ");
		sb.append(" RecommendGroup recommendGroup,");
		sb.append(" GoodsGroup goodsGroup");
		sb.append(" where  ");
		sb.append(" goodsGroup.goods.id = model.id ");
		sb.append(" and goodsGroup.id = recommendGroup.groupId ");
		Map<String, Object> params = new HashMap<String, Object>();
		sb.append(" and recommendGroup.positionId = :positionId ");
		params.put("positionId", positionId);
		sb.append(" order by recommendGroup.orderby asc ");
		Page page = queryArrayByJpql(sb.toString(), params,pageable);
		return page.getContent();

	}
	
	@Override
	public Page<Goods> findAllGoodsBy(Date begin, Date end, long cat, Pageable pageable) {
		StringBuffer sb = new StringBuffer("select model from Goods model  where model.goodsCat = :cat  ");
		sb.append(" and model.promoteStartDate between :start and :end ");

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("cat", cat);
		params.put("start", begin);
		params.put("end", end);

		return queryByJpql(sb.toString(), params, pageable);
	}

	@Override
	public Page<Goods> findRecommend(String code, Pageable pageable) {
		StringBuffer sb = new StringBuffer(
				"select model from Goods model,RecommendGoods recommendGoods,RecommendPosition position where recommendGoods.goodsId = model.id and position.id = recommendGoods.positionId ");
		Map<String, Object> params = new HashMap<String, Object>();
		sb.append(" and position.code = :code ");
		params.put("code", code);
		sb.append(" order by recommendGoods.orderby asc ");

		return queryByJpql(sb.toString(), params, pageable);
	}
}