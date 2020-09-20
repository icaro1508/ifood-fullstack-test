package com.ifood.order.controller;

import com.ifood.order.dto.OrderDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
public class OrderController {

	@GetMapping
	public ResponseEntity<OrderDto> root() {
		log.info("Eu que respondi :)");
		return ResponseEntity.ok(OrderDto.builder()
				.id(UUID.randomUUID())
				.clientId(UUID.randomUUID())
				.confirmedAt(new Date())
				.createdAt(new Date())
				.items(Collections.emptyList())
				.build()
		);
	}
	
	@GetMapping("/a")
	public ResponseEntity<List<OrderDto>> root2() {
		return ResponseEntity.ok(Collections.emptyList());
	}
}
