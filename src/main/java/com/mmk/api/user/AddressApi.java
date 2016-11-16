package com.mmk.api.user;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mmk.business.model.UserAddress;
import com.mmk.business.service.UserAddressService;
import com.mmk.common.model.ResultData;

@RestController
public class AddressApi {
	
	private UserAddressService addressService;

	/**
	 * 获取用户的所有地址信息
	 * @param openid 用户的openid
	 * @param pageable 分页信息
	 * @return 所有
	 */
	@RequestMapping("/api/address/findAllByOpenid")
	@ResponseBody
	public ResultData findUserAddress(String openid,Pageable pageable){
		ResultData result = new ResultData();
		
		Page<UserAddress> userAddress = addressService.findAllByOpenid(openid, pageable);
		result.addData("page", userAddress);
		return result ;
	}
	
	/**
	 * 用户地址详情
	 * @param openid 用户openid
	 * @param addressid 地址id
	 * @return 用户的地址信息
	 */
	@RequestMapping("/api/address/findByOpenid")
	@ResponseBody
	public ResultData findUserAddress(String openid,Long addressId){
		
		UserAddress userAddress = addressService.find(addressId);
		
		if(userAddress==null){
			ResultData result = new ResultData(false,"没有找到用户地址");
			return result;
		}
		
		if(!openid.equals(userAddress.getOpenid())){
			ResultData result = new ResultData(false,"改地址不用户地址");
			return result;
		}
		
		ResultData result = new ResultData(true,"用户地址信息");
		result.addData("userAddress", userAddress);
		return result ;
	}
	
	
	/**
	 * 用户地址详情
	 * @param openid 用户openid
	 * @param addressid 地址id
	 * @return 用户的地址信息
	 */
	@RequestMapping("/api/address/save")
	@ResponseBody
	public ResultData save(String openid,UserAddress address){
		
		try {
			UserAddress saved = addressService.save(address);
			ResultData result = new ResultData(true,"用户地址信息");
			result.addData("userAddress", saved);
			return result;
		} catch (Exception e) {
			ResultData result = new ResultData(false,"用户地址保存失败");
			return result ;
		}
	}
	
	/**
	 * 用户地址详情
	 * @param openid 用户openid
	 * @param addressid 地址id
	 * @return 用户的地址信息
	 */
	@RequestMapping("/api/address/delete")
	@ResponseBody
	public ResultData delete(String openid,Long addressId){
		
		UserAddress userAddress = addressService.find(addressId);
		
		if(userAddress==null){
			ResultData result = new ResultData(false,"没有找到用户地址");
			return result;
		}
		
		if(!openid.equals(userAddress.getOpenid())){
			ResultData result = new ResultData(false,"非用户地址信息");
			return result;
		}
		
		addressService.delete(userAddress);
		ResultData result = new ResultData(true,"用户信息删除成功！");
		return result ;
	}
}
