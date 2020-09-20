package com.ifood.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.ifood.demo.order.OrderEventHandler;

@SpringBootApplication
@EnableMongoRepositories("com.ifood.demo")
public class OrderApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderApplication.class, args);
	}
	
    @Bean
    OrderEventHandler orderEventHandler() {
        return new OrderEventHandler();
    }
}
