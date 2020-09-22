package com.ifood.order.service;

import com.ifood.order.document.Order;
import com.ifood.order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.UUID;

@Service
public class OrderService {
	
	private final OrderRepository orderRepository;
	
	@Autowired
	public OrderService(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}
	
	public Optional<Order> findOrderById(UUID orderId) {
		return this.orderRepository.findById(orderId);
	}
}
