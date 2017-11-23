package com.companyname.stock.stockservice.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class Config {

	@LoadBalanced//used for eureka service clieet side load balancing 
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
