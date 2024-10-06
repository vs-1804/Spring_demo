package com.product.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

	@Bean
	@Profile("2")
	RestTemplate rest() {
		System.out.println("Profile1");
		return new RestTemplate();
	}
	@Bean
	@Profile("1")
	RestTemplate rest1() {
		System.out.println("Profile2");
		return new RestTemplate();
	}

}
