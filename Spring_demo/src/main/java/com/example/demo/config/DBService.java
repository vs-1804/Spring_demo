package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DBService {
	
	@Autowired
	private DB db;
	
	 public String getdata() {
		
		 return db.getdata();
	 }
}
