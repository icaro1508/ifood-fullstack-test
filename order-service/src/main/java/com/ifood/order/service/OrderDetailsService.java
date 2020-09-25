package com.ifood.order.service;

import com.ifood.order.client.CachedClientClient;
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
	private final CachedClientClient cachedClientClient;
	
	public OrderDetailsService(OrderRepository orderRepository, CachedClientClient cachedClientClient) {
		this.orderRepository = orderRepository;
		this.cachedClientClient = cachedClientClient;
	}
	
	public List<OrderDetails> findFiltered(LocalDate after, LocalDate before, String name, String phone, String email) {
		Collection<Order> orders = this.orderRepository.findByCreatedAtBetween(after.atStartOfDay(), before.atTime(
				LocalTime.MAX));
		
		// cache this
		Map<String, Client> clients = cachedClientClient
				.findByNameAndPhoneAndEmail(name, phone, email)
				.stream().collect(Collectors.toMap(Client::getId, Function.identity()));
		
		List<OrderDetails> ordersList = new ArrayList<>();
		for( Order order : orders) {
			Client orderClient = clients.get(order.getClientId().toString());
			if (orderClient != null) {
				ordersList.add(OrderDetails.builder()
						.id(order.getId())
						.createdAt(LocalDate.from(order.getCreatedAt()))
						.client(orderClient)
						.items(order.getItems())
						.totalValue(order.getItems().stream()
								.map(i -> (i.getPrice() == null ? 0.0 : i.getPrice()) * i.getQuantity())
								.reduce(0.0, Double::sum))
						.build());
			}
		}
		
		return ordersList;
	}
}
