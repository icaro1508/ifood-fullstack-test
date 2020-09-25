package com.ifood.order;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

import com.ifood.order.document.Order;
import com.ifood.order.document.Order.Item;
import com.ifood.order.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.UUID;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
public class OrderApplicationTests {

	@LocalServerPort
	private int port;
	
	@Autowired
	OrderRepository orderRepository;

	@Test
	public void orderTest() {

		orderRepository.deleteAll();
				
		orderRepository.save(new Order(UUID.randomUUID(), UUID.randomUUID(), LocalDateTime.now(), null,
				Arrays.asList(
						new Item("Item 1",1, 3.39),
						new Item("Item 2",3, 1.5),
						new Item("Item 3",1, 4.0))
				));
		orderRepository.save(new Order(UUID.randomUUID(), UUID.randomUUID(), LocalDateTime.now(), null,
				Arrays.asList(
						new Item("Item A",2, 5.5),
						new Item("Item B",2, 2.0))
				));

		for (Order order : orderRepository.findAll()) {
			log.info("Found Order {}", order.toString());
		}
	}

}