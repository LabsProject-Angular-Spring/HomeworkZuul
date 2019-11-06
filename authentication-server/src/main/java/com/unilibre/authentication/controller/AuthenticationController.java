package com.unilibre.authentication.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import com.unilibre.authentication.feign.AccountServiceClientFeign;
import com.unilibre.authentication.model.User;

@RestController
public class AuthenticationController {
	@Autowired
	private AccountServiceClientFeign accountServiceClientFeign; 
	
	@RequestMapping(value = "/authentication-service", method = RequestMethod.POST, produces ="application/json")
	public User login(@RequestParam("user") String username, @RequestParam("password") String password ) {		
		Map<String,String> map = new HashMap<String, String>();
		map.put("user", username);
	    map.put("password", password);
		User user = accountServiceClientFeign.GetUser(map);		
		if(user.getId()!=0) {
			getJWTToken(username);
		}
		return user;
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

		return "Token " + token;
	}
}
