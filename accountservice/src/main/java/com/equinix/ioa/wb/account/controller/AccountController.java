package com.equinix.ioa.wb.account.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.equinix.ioa.wb.account.model.User;

@RestController

public class AccountController {
	User user = null;
	
	public AccountController() {
		user = new User(100, "test@equinix.com", "Test");
	}	

	@RequestMapping(value = "/account-service", method = RequestMethod.GET, produces ="application/json")
	public User login() {
		return user;
	}
}
