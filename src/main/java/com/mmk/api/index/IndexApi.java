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
	@RequestMapping("/home/indexAd")
	@ResponseBody
	public Map<String,Object> indexAd(Long position){
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
		
		Map<String,Object> status = new HashMap<String,Object>();
		status.put("succeed", 1);
		
		result.put("data", data);
		result.put("status", status);
		return result ;
	}
	
	
//	/**
//	 * 原广告位商品-查询分类的
//	 * @return
//	 * @date 2016年1月27日 下午2:47:43
//	 * @author zq
//	 */
//	@RequestMapping("/home/indexAdCat")
//	@ResponseBody
//	public Map<String,Object> indexAdCat(Long position){
//		Map<String, Object> result = new HashMap<String,Object>();
//		
//		//查询【手机首页广告】
//		List<Ad> adList = adService.findAllByPositionId(position);
//		
//		List<Map<String,Object>> data = new ArrayList<Map<String,Object>>();
//		for (Ad ad : adList) {
//			
//			Map<String,Object> object = new HashMap<String,Object>();
//			Map<String,Object> photo = new HashMap<String,Object>();
//			Map<String,Object> curlvBigMap = new HashMap<String,Object>();
//			List<Map<String,Object>> curlvBigList = new ArrayList<Map<String,Object>>();
//			
//			
//			photo.put("small", ad.getAdCode().startsWith("http://img") ? ad.getAdCode() :  "http://www.yiqingo.com/data/afficheimg/"+ad.getAdCode() );
//			photo.put("thumb", ad.getAdCode().startsWith("http://img") ? ad.getAdCode() :  "http://www.yiqingo.com/data/afficheimg/"+ad.getAdCode() );
//			photo.put("wifi", ad.getAdCode().startsWith("http://img") ? ad.getAdCode() :  "http://www.yiqingo.com/data/afficheimg/"+ad.getAdCode() );
//			photo.put("url", ad.getAdLink());
//			photo.put("description", "");
//			photo.put("action", "");
//			photo.put("action_id", 0);
//			photo.put("ad_id", ad.getAdId());
//			photo.put("ad_code", ad.getAdCode().startsWith("http://img") ? ad.getAdCode() :  "http://www.yiqingo.com/data/afficheimg/"+ad.getAdCode());
//			photo.put("show", "web");
//			curlvBigMap.put("photo", photo);
//			curlvBigList.add(curlvBigMap);
//			
//			object.put("curlv_big", curlvBigList);
//			object.put("curlv_two", null);
//			
//			data.add(object);
//		}
//		
//		Map<String,Object> status = new HashMap<String,Object>();
//		status.put("succeed", 1);
//		
//		result.put("data", data);
//		result.put("status", status);
//		return result ;
//	}
	
//	@RequestMapping("/home/data")
//	@ResponseBody
//	public Map<String,Object> index(){
//		Map<String, Object> result = new HashMap<String,Object>();
//		List<Ad> loopAd = adService.findAllByPositionId(26L);
//		List<Ad> adList = adService.findAllByPositionId(22L);
//		List<Goods> goodsList = goodsService.findPromt(null);
//		List<Map<String,Object>> player = new ArrayList<Map<String,Object>>();
//		for (Ad ad : loopAd) {
//			
//			Map<String,Object> object = new HashMap<String,Object>();
//			Map<String,Object> photo = new HashMap<String,Object>();
//			
//			photo.put("small", ad.getAdCode().startsWith("http://img") ? ad.getAdCode() :  "http://www.yiqingo.com/data/afficheimg/"+ad.getAdCode() );
//			photo.put("thumb", ad.getAdCode().startsWith("http://img") ? ad.getAdCode() :  "http://www.yiqingo.com/data/afficheimg/"+ad.getAdCode() );
//			photo.put("wifi", ad.getAdCode().startsWith("http://img") ? ad.getAdCode() :  "http://www.yiqingo.com/data/afficheimg/"+ad.getAdCode() );
//			photo.put("url", ad.getAdLink());
//			photo.put("description", "");
//			photo.put("action", "");
//			photo.put("action_id", 0);
//			photo.put("ad_id", ad.getAdId());
//			photo.put("ad_code", ad.getAdCode().startsWith("http://img") ? ad.getAdCode() :  "http://www.yiqingo.com/data/afficheimg/"+ad.getAdCode());
//			object.put("photo", photo);
//			player.add(object);
//		}
//		List<Map<String,Object>> ad = new ArrayList<Map<String,Object>>();
//		for (Ad object : adList) {
//			Map<String,Object> adObject = new HashMap<String,Object>();
//			adObject.put("name", object.getAdName());
//			adObject.put("opennew", 0);
//			adObject.put("url", object.getAdLink());
//			adObject.put("pic", object.getAdCode().startsWith("http://img") ? object.getAdCode() :  "http://www.yiqingo.com/data/afficheimg/"+object.getAdCode());
//			adObject.put("show", "");
//			ad.add(adObject);
//		}
//		List<Map<String,Object>> promoteGoods = new ArrayList<Map<String,Object>>();
//		for (Goods goods :goodsList) {
//			Map<String,Object> object = new HashMap<String,Object>();
//			object.put("id", goods.getId());
//			object.put("name", goods.getGoodsName());
//			object.put("market_price", goods.getMarketPrice());
//			object.put("shop_price", goods.getShopPrice());
//			object.put("promote_price", goods.getPromotePrice());
//			object.put("brief", "");
//			object.put("number", "已售出"+goods.getVirtueSaleNum()+"件");
//			object.put("countdown",goods.getPromoteEndDate());
//			Map<String,Object> img = new HashMap<String,Object>();
//			img.put("small", goods.getGoodsThumb().startsWith("http://img") ? goods.getGoodsThumb() : "http://www.yiqingo.com/".concat(goods.getGoodsThumb()));
//			img.put("thumb", goods.getGoodsImg().startsWith("http://img") ? goods.getGoodsImg() : "http://www.yiqingo.com/".concat(goods.getGoodsImg()));
//			img.put("url", goods.getOriginalImg().startsWith("http://img") ? goods.getOriginalImg() : "http://www.yiqingo.com/".concat(goods.getOriginalImg()));
//			object.put("img",img);
//			promoteGoods.add(object);
//		}
//		
//		Map<String,Object> status = new HashMap<String,Object>();
//		status.put("succeed", 1);
//		
//		Map<String,Object> data = new HashMap<String,Object>();
//		
//		data.put("player", player);
//		data.put("ad", ad);
//		data.put("promote_goods", promoteGoods);
//		
//		//版本更新信息，取字典
//		Dic appcode = dicRepository.findByKey("appcode");
//		Dic updateflag = dicRepository.findByKey("updateflag");
////		System.out.println(appcode.getValue());
//		data.put("appcode", null!=appcode?appcode.getValue():"1.0");
//		data.put("news", "亲，有新版本更新哦，赶紧下载吧！");
//		data.put("updateflag", null!=updateflag?updateflag.getValue():0);//1-强制跟新 0-非强制更新
//		data.put("updateurl", "http://www.yiqingo.com/Android/yiqingo.apk");
//		
//		result.put("data", data);
//		result.put("status", status);
//		return result ;
//	}
	
	
}
