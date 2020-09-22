package com.ifood.order.controller;

import com.ifood.order.document.Order;
import com.ifood.order.dto.Client;
import com.ifood.order.dto.OrderDetails;
import com.ifood.order.service.OrderDetailsService;
import com.ifood.order.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/v1/orders")
public class OrderDetailsController {
	
	private final OrderDetailsService orderDetailsService;
	
	@Autowired
	public OrderDetailsController(OrderDetailsService orderDetailsService) {
		this.orderDetailsService = orderDetailsService;
	}
	
	
//	@GetMapping("/details")
//	public ResponseEntity<List<OrderDetails>> fetchAllOrders(@PathVariable("orderId") UUID orderId) {
//		ResponseEntity<Order> response = ResponseEntity.of(orderDetailsService.findAll(orderId));
//		log.debug("Req: /order/{} | Res: statusCode={}", orderId.toString(), response.getStatusCode());
//		return response;
//	}
	
	@GetMapping("/details")
	public Collection<Client> fetchAllOrders() {
		return orderDetailsService.findAll();
	}
}
