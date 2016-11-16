package com.mmk.api.address;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mmk.common.model.ResultData;

@RestController
public class AddressApi {

	@RequestMapping("/api/address/findByOpenid")
	public ResultData findUserAddress(String openid){
		ResultData result = new ResultData();
		return result ;
	}
}
