package com.example.demo.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
public class AppConfig {
	
	@ConditionalOnBean(name = "xyz")
	@Bean
    String Config() {
		System.out.println("App config");
		return "x";
	}

}
