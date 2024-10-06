package com.product.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.model.UserData;

@RestController
@RequestMapping("/RestApi")
@CrossOrigin(origins = "*")
public class UserController {
	
	 @GetMapping("/getData") 
	 public UserData get()
	    {
	        UserData userData = new UserData();
	        userData.setId(1);
	        userData.setName("darshanGPawar@geek");
	        userData.setData("Data send by Rest-API");
	 
	        return userData;
	    }

}
