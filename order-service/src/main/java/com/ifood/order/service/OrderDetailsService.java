package com.ifood.order.service;

import com.ifood.order.client.ClientClient;
import com.ifood.order.document.Order;
import com.ifood.order.dto.Client;
import com.ifood.order.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

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
	
//	public Object findAll() {
//		Collection<Order> orderList = this.orderRepository.findByCreatedAtBetween();
//	}
	
	public Collection<Client> findAll() {
		return clientClient.findByNameAndPhoneAndEmail("doe", "", "").getContent();
	}
}
