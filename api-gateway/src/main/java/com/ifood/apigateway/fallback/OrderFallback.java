package com.ifood.apigateway.fallback;

import com.google.inject.internal.cglib.core.$AbstractClassGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping(path = "orderFallback", produces = "application/json")
public class OrderFallback {

	private LoadBalancerClient loadBalancer;
	
	@Autowired
	public OrderFallback(LoadBalancerClient loadBalancer) {
	
	}
	
	@GetMapping
	public ResponseEntity<List> orderFallback() {
		return ResponseEntity.ok(Collections.emptyList());
	}

}
