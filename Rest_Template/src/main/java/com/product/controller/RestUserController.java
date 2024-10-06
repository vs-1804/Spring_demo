package com.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.config.RestTemplateProvider;
import com.product.model.UserData;

@RestController
public class RestUserController {
	
	@Autowired
	RestTemplateProvider  provider;
	@GetMapping("/get")
	UserData getdata() {
		return provider.getUserData();
	}

}
