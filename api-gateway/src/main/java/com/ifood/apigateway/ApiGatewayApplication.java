package com.ifood.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.retry.annotation.EnableRetry;

@SpringBootApplication
@EnableRetry
public class ApiGatewayApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}
	
}
