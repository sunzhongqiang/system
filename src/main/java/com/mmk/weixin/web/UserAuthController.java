package com.mmk.weixin.web;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.json.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.mmk.common.BaseController;
import com.mmk.common.tool.ApiClient;
import com.mmk.weixin.constants.WeiXinOpenParams;
import com.mmk.weixin.model.WxAppUser;
import com.mmk.weixin.service.WxAppUserService;
@RestController
public class UserAuthController extends BaseController{
	
	private String REDIRECT_URI = "http://153159.com/weixin/user/info";
	
	@Resource
	private WxAppUserService userService;
	/**
     * 跳转至列表页面
     * @return 返回页面以及页面模型
     */
    @RequestMapping("/weixin/user/login")
    public ModelAndView login(){
        log.info("代公众号实现业务，获取用户授权");
        String url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx4eea902ba31461ff&redirect_uri="+REDIRECT_URI+"&response_type=code&scope=snsapi_userinfo&state=wx4eea902ba31461ff&component_appid="+WeiXinOpenParams.COMPONENT_APPID+"#wechat_redirect";
        ModelAndView modelAndView = new ModelAndView(new RedirectView(url));
        return  modelAndView;
    }
    
    
    /**
     * 
     * @return 获取用户授权
     */
    @RequestMapping("/weixin/user/info")
    public String  info(String code ,String state,String appid){
        log.info("代公众号实现业务，使用code交换token,并获取用户信息");
        String url = "https://api.weixin.qq.com/sns/oauth2/component/access_token?appid="+appid+"&code="+code+"&grant_type=authorization_code&component_appid="+WeiXinOpenParams.COMPONENT_APPID+"&component_access_token="+WeiXinOpenParams.COMPONENT_ACCESS_TOKEN;
		String result = ApiClient.get(url);
		log.info("token-result:"+result);
		JSONObject json = new JSONObject(result);
		String userUrl = "https://api.weixin.qq.com/sns/userinfo";
		Map<String, Object> params2 = new HashMap<String,Object>();
		String accessToken = json.getString("access_token");
		String openid = json.getString("openid");
		log.debug(accessToken);
		log.debug(openid);
		
		WxAppUser user = userService.findByAppIdAndOpenId(appid,openid);
		//用户不存在，获取用户信息
		if(user==null){
			params2.put("access_token", accessToken);
			params2.put("openid", openid);
			params2.put("lang", "zh_CN");
			String encodeUrl = ApiClient.encodeUrl(userUrl, params2);
			result = ApiClient.get(encodeUrl);
			JSONObject userJson = new JSONObject(result);
			
			user = new WxAppUser();
			user.setAppid(appid);
			user.setOpenid(userJson.getString("openid"));
			user.setNickname(userJson.getString("nickname"));
			user.setSex(userJson.getInt("sex"));
			user.setLanguage(userJson.getString("language"));
			user.setCity(userJson.getString("city"));
			user.setCountry(userJson.getString("country"));
			user.setHeadimgurl(userJson.getString("headimgurl"));
			user.setProvince(userJson.getString("province"));
			userService.save(user);
		}
		
        return  result;
    }
}
