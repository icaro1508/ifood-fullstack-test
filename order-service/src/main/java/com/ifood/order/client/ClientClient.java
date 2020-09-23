package com.ifood.order.client;

import com.ifood.order.dto.Client;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.CollectionModel;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(
		name = "client-service",
		path = "/v1/clients",
		fallback = ClientClient.ClientClientFallback.class
)
public interface ClientClient {

	@GetMapping(value = "/search/byNameAndPhoneAndEmail", consumes = "application/json")
	CollectionModel<Client> findByNameAndPhoneAndEmail(@RequestParam(value = "name", defaultValue = "") String name,
													   @RequestParam(value = "phone", defaultValue = "") String phone,
													   @RequestParam(value = "email", defaultValue = "") String email);
	
	@Slf4j
	@Component
	class ClientClientFallback implements ClientClient{
		
		@Override
		public CollectionModel<Client> findByNameAndPhoneAndEmail(String name, String phone, String email) {
			log.info("Using client Fallback for params: {}, {}, {}", name, phone, email);
			return CollectionModel.empty();
		}
		
	}
}
