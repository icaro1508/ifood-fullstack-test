package com.ifood.order.service;

import com.ifood.order.client.ClientClient;
import com.ifood.order.document.Order;
import com.ifood.order.dto.Client;
import com.ifood.order.dto.OrderDetails;
import com.ifood.order.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Slf4j
@Service
public class OrderDetailsService {
	
	private final OrderRepository orderRepository;
	private ClientClient clientClient;
	
	@Autowired
	public OrderDetailsService(OrderRepository orderRepository, ClientClient clientClient) {
		this.orderRepository = orderRepository;
		this.clientClient = clientClient;
	}
	
	public List<OrderDetails> findAll(LocalDate after, LocalDate before, String name, String phone, String email) {
		Collection<Order> orders = this.orderRepository.findByCreatedAtBetween(after.atStartOfDay(), before.atTime(
				LocalTime.MAX));
		
		// cache this
		Map<String, Client> clients = clientClient
				.findByNameAndPhoneAndEmail(name, phone, email).getContent()
				.stream().collect(Collectors.toMap(Client::getId, Function.identity()));
		
		List<OrderDetails> ordersList = new ArrayList<>();
		for( Order order : orders) {
			Client orderClient = clients.get(order.getClientId());
			ordersList.add(OrderDetails.builder()
					.id(order.getId())
					.createdAt(LocalDate.from(order.getCreatedAt()))
					.client(orderClient)
					.items(order.getItems())
					.totalValue(order.getItems().stream()
							.map(i -> i.getPrice())
							.reduce(0.0, (sum, value) -> sum + value))
					.build());
		}
		
		return ordersList;
	}
}
