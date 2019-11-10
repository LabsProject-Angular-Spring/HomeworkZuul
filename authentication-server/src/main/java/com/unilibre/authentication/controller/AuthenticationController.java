package com.unilibre.authentication.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import com.unilibre.authentication.feign.AccountServiceClientFeign;
import com.unilibre.authentication.model.User;

@RestController
public class AuthenticationController {
	
	@Autowired
	private AccountServiceClientFeign accountServiceClientFeign; 
	
	@RequestMapping(value = "/authentication-service", 
			method = RequestMethod.POST, 
			consumes = {"application/json"},
			produces ="application/json")
	public com.unilibre.authentication.model.User login(@RequestBody Map<String, Object> payload) {		

		com.unilibre.authentication.model.User user = accountServiceClientFeign.login(payload);	
	
		if(user.getId()!=0) {
			user.setToken(getJWTToken((String)payload.get("user")));
			return user;
		} else {
			return null;
		}
		
	}
	private String getJWTToken(String username) {
		String secretKey = "SecretKey";
		
		String token = Jwts
				.builder()
				.setId("unilibre")
				.setSubject(username)				
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 600000))
				.signWith(SignatureAlgorithm.HS512,
						secretKey.getBytes()).compact();

		return token;
	}
}
