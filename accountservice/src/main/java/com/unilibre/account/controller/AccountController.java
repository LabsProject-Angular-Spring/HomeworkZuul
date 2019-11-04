package com.unilibre.account.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.unilibre.account.model.User;

@RestController

public class AccountController {
	User user = null;
	
	public AccountController() {
		user = new User(100, "alargo@gmail.com", "Test");
	}	

	@RequestMapping(value = "/account-service", method = RequestMethod.POST, produces ="application/json")
	public User login(@RequestParam("user") String username, @RequestParam("password") String password ) {
		if(username.equals("alargo") && password.equals("123")) {
			return user;		
		} else {
			return new User(0, "", "");
		}
	
	}
}
