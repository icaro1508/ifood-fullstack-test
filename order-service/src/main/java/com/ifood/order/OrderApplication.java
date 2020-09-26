package com.ifood.order;

import com.ifood.order.document.Order;
import com.ifood.order.event.OrderEventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.UUID;

@SpringBootApplication
@EnableMongoRepositories("com.ifood.order.repository")
@EnableDiscoveryClient
@EnableFeignClients
@EnableCaching
public class OrderApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(OrderApplication.class, args);
	}
	
	@Bean
	OrderEventHandler orderEventHandler() {
        return new OrderEventHandler();
    }
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Override
	public void run(String... args) throws Exception {
		mongoTemplate.save(Order.builder()
				.id(UUID.randomUUID())
				.clientId(UUID.fromString("daa880de-3ef2-452d-a97e-e12ff9bf6113"))
				.restaurantId(UUID.fromString("fe09d81f-4105-4c4f-a231-9461c757b651"))
				.createdAt(LocalDateTime.now())
				.confirmedAt(LocalDateTime.now())
				.items(Arrays.asList(
						new Order.Item( "item 1", 1, 10.0),
						new Order.Item("item 2", 5, 10.0),
						new Order.Item("item 3", 3, 7.0)
				))
				.build());
				
		mongoTemplate.save(Order.builder()
				.id(UUID.randomUUID())
				.clientId(UUID.fromString("daa880de-3ef2-452d-a97e-e12ff9bf6113"))
				.restaurantId(UUID.fromString("fe09d81f-4105-4c4f-a231-9461c757b651"))
				.createdAt(LocalDateTime.now())
				.confirmedAt(LocalDateTime.now())
				.items(Arrays.asList(
						new Order.Item( "item 1", 1, 10.0),
						new Order.Item("item 2", 100, 1.0)
				))
				.build());
		
		mongoTemplate.save(Order.builder()
				.id(UUID.randomUUID())
				.clientId(UUID.fromString("35521a8a-67d9-41b0-94b1-6141efe40397"))
				.restaurantId(UUID.fromString("fe09d81f-4105-4c4f-a231-9461c757b651"))
				.createdAt(LocalDateTime.now())
				.confirmedAt(LocalDateTime.now())
				.items(Arrays.asList(
						new Order.Item( "item 1", 1, 10.0)
				))
				.build());
		
		mongoTemplate.save(Order.builder()
				.id(UUID.randomUUID())
				.clientId(UUID.fromString("35521a8a-67d9-41b0-94b1-6141efe40397"))
				.restaurantId(UUID.fromString("fe09d81f-4105-4c4f-a231-9461c757b651"))
				.createdAt(LocalDateTime.now())
				.confirmedAt(LocalDateTime.now())
				.items(Arrays.asList(
						new Order.Item( "item 1", 5, 10.0)
				))
				.build());
		
		mongoTemplate.save(Order.builder()
				.id(UUID.randomUUID())
				.clientId(UUID.fromString("e4b5af81-30a3-49e2-a687-2297b10252f0"))
				.restaurantId(UUID.fromString("fe09d81f-4105-4c4f-a231-9461c757b651"))
				.createdAt(LocalDateTime.now())
				.confirmedAt(LocalDateTime.now())
				.items(Arrays.asList(
						new Order.Item( "item 1", 5, 2.0),
						new Order.Item( "item 1", 2, 3.0),
						new Order.Item( "item 1", 3, 7.0),
						new Order.Item( "item 1", 7, 1.0)
				))
				.build());
		
		mongoTemplate.save(Order.builder()
				.id(UUID.randomUUID())
				.clientId(UUID.fromString("aa8223a8-d7bb-482b-a82c-35fe1494c19e"))
				.restaurantId(UUID.fromString("fe09d81f-4105-4c4f-a231-9461c757b651"))
				.createdAt(LocalDateTime.now())
				.confirmedAt(LocalDateTime.now())
				.items(Arrays.asList(
						new Order.Item( "item 1", 1, 10.0)
				))
				.build());
		
	}
	
}
