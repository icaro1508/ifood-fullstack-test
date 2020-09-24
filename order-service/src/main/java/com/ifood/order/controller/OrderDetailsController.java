package com.ifood.order.controller;

import com.ifood.order.dto.OrderDetails;
import com.ifood.order.service.OrderDetailsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import java.time.LocalDate;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/v1/orders")
public class OrderDetailsController {
	
	private final OrderDetailsService orderDetailsService;
	
	@Autowired
	public OrderDetailsController(OrderDetailsService orderDetailsService) {
		this.orderDetailsService = orderDetailsService;
	}
	
	@GetMapping("/search/list")
	public @ResponseBody List<OrderDetails> fetchOrderListWithClientData(
			@RequestParam(value = "after") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate after,
			@RequestParam(value = "before") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate before,
			@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "phone", required = false) String phone,
			@RequestParam(value = "email", required = false) String email) {
		return orderDetailsService.findFiltered(after, before, name, phone, email);
	}
}
