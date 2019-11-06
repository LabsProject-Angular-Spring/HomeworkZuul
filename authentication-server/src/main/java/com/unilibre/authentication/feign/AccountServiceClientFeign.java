package com.unilibre.authentication.feign;



import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.unilibre.authentication.model.User;

import feign.Headers;

@FeignClient(name = "ACCOUNT-SERVICE")
public interface AccountServiceClientFeign {
	
	@RequestMapping(value = "/account-service", method = RequestMethod.POST)
	@Headers("Content-Type: application/x-www-form-urlencoded")
	public User GetUser(@RequestBody  Map<String, ?> formParams);	
}
