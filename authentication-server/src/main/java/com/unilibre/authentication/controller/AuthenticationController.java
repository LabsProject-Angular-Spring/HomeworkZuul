package com.unilibre.authentication.controller;

import java.util.Date;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import com.unilibre.authentication.model.User;

@RestController
public class AuthenticationController {
	@RequestMapping(value = "/account-service", method = RequestMethod.POST, produces ="application/json")
	public User login(@RequestParam("user") String username, @RequestParam("password") String password ) {		
		return null;
	}
	private String getJWTToken(String username) {
		String secretKey = "mySecretKey";
		
		String token = Jwts
				.builder()
				.setId("softtekJWT")
				.setSubject(username)				
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 600000))
				.signWith(SignatureAlgorithm.HS512,
						secretKey.getBytes()).compact();

		return "Bearer " + token;
	}
}
