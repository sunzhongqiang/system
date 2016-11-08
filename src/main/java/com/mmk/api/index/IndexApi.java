package com.mmk.api.index;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mmk.business.model.Ad;
import com.mmk.business.model.Goods;
import com.mmk.business.service.AdPositionService;
import com.mmk.business.service.AdService;
import com.mmk.business.service.GoodsService;
import com.mmk.common.model.ResultMsg;

@RestController
public class IndexApi {

	@Resource
	private AdService adService;
	@Resource
	private GoodsService goodsService;
	@Resource
	private AdPositionService	goodPositionService;
//	@Resource
//	private CategoryService categoryService;
//	@Resource
//	private BrandService brandService;
//	@Resource
//	private DicRepository dicRepository;
	
	/**
	 * 广告位商品
	 * @return
	 * @date 2016年1月27日 下午2:47:43
	 * @author zq
	 */
	@RequestMapping("/api/home/indexAd")
	@ResponseBody
	public ResultMsg indexAd(Long position){
		Map<String, Object> result = new HashMap<String,Object>();
		
		//查询【手机首页广告】
		List<Ad> adList = adService.findAllByPositionId(position);
		
		List<Map<String,Object>> data = new ArrayList<Map<String,Object>>();
		for (Ad ad : adList) {
			
			Map<String,Object> object = new HashMap<String,Object>();
			Map<String,Object> photo = new HashMap<String,Object>();
			Map<String,Object> curlvBigMap = new HashMap<String,Object>();
			List<Map<String,Object>> curlvBigList = new ArrayList<Map<String,Object>>();
			
			
			object.put("name", ad.getAdName());
			
			photo.put("small", ad.getAdCode().startsWith("http://img") ? ad.getAdCode() :  "http://www.yiqingo.com/data/afficheimg/"+ad.getAdCode() );
			photo.put("thumb", ad.getAdCode().startsWith("http://img") ? ad.getAdCode() :  "http://www.yiqingo.com/data/afficheimg/"+ad.getAdCode() );
			photo.put("wifi", ad.getAdCode().startsWith("http://img") ? ad.getAdCode() :  "http://www.yiqingo.com/data/afficheimg/"+ad.getAdCode() );
			photo.put("url", ad.getAdLink());
			photo.put("description", ad.getDescription());
			photo.put("action", "");
			photo.put("action_id", 0);
			photo.put("ad_id", ad.getAdId());
			photo.put("show", "web");
			curlvBigMap.put("photo", photo);
			curlvBigList.add(curlvBigMap);
			
			object.put("curlv_big", curlvBigList);
			object.put("curlv_two", null);
			
			data.add(object);
		}
		result.put("data", data);
		return new ResultMsg(true, "查找成功", result);
	}	
	
}
