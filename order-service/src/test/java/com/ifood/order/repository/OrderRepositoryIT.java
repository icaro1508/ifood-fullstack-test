package com.ifood.order.repository;

import static com.ifood.order.utils.EntityMock.createClients;
import static com.ifood.order.utils.EntityMock.createOrder;
import static com.ifood.order.utils.EntityMock.createOrders;
import static org.junit.jupiter.api.Assertions.*;

import com.ifood.order.document.Order;
import com.ifood.order.dto.Client;
import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@ExtendWith(SpringExtension.class)
@DataMongoTest
class OrderRepositoryIT {
	
	private final UUID CLIENT_ID = UUID.fromString("ebf04f85-4a83-4b67-b521-72a144daafc0");
	private final LocalDateTime AFTER = LocalDateTime.of(2020, 9, 22, 0, 0, 0);
	private final LocalDateTime BEFORE = LocalDateTime.of(2020, 9, 24, 0, 0, 0);
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Test
	public void Should_RetrieveOrdersBetweenDate_When_UsingFindByCreatedAtBetween() {
		mongoTemplate.save(createOrder(LocalDateTime.of(2020, 9, 23, 0,0,0), CLIENT_ID));
		mongoTemplate.save(createOrder(LocalDateTime.of(2020, 9, 20, 0,0,0), CLIENT_ID));
		
		Collection<Order> byCreatedAtBetween = orderRepository.findByCreatedAtBetween(AFTER, BEFORE);
		
		Assertions.assertThat(byCreatedAtBetween.size()).isEqualTo(1);
	}
}