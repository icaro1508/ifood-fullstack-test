package com.ifood.order.client;

import com.ifood.order.dto.Client;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.CollectionModel;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(
		name = "client-service",
		path = "/v1/clients",
		fallback = ClientClient.ClientClientFallback.class
)
public interface ClientClient {

	@GetMapping(value = "/search/byNameAndPhoneAndEmail", consumes = "application/json")
	CollectionModel<Client> findByNameAndPhoneAndEmail(@RequestParam("name") String name,
													   @RequestParam("phone") String phone,
													   @RequestParam("email") String email);
	
	@Component
	class ClientClientFallback implements ClientClient{
		
		@Override
		public CollectionModel<Client> findByNameAndPhoneAndEmail(String name, String phone, String email) {
			return CollectionModel.empty();
		}
		
	}
}
