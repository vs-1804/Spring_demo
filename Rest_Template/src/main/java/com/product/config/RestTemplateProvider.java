package com.product.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.product.model.UserData;

@Component
public class RestTemplateProvider {
	
	@Autowired
	RestTemplate  rest;
	
	public UserData getUserData() {
		
		 return rest.getForObject("http://localhost:8080/RestApi/getData", UserData.class);
	}

}
