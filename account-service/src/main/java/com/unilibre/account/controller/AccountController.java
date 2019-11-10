package com.unilibre.account.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.unilibre.account.model.User;

@RestController

public class AccountController {
	User user = null;
	
	public AccountController() {
		user = new User(1, "alargo@gmail.com", "Test");
	}	

	@RequestMapping(value = "/account-service", method = RequestMethod.POST, 
			consumes = {"application/json"},
			produces ="application/json")
	public User login(@RequestBody Map<String, Object> payload  ) {
		if(payload.get("user").equals("alargo") && payload.get("password").equals("123")) {
			return user;		
		} else {
			return new User(-1, "", "");
		}
	
	}
}
