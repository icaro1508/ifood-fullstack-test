package com.ifood.order.client;

import com.ifood.order.dto.Client;
import feign.hystrix.FallbackFactory;
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
		fallbackFactory = ClientClient.ClientClientFallbackFactory.class
)
public interface ClientClient {

	@GetMapping
	CollectionModel<Client> findByNameAndPhoneAndEmail(@RequestParam(value = "name") String name,
													   @RequestParam(value = "phone") String phone,
													   @RequestParam(value = "email") String email);
	
	@Slf4j
	@Component
	class ClientClientFallbackFactory implements FallbackFactory<ClientClient>{
		
		@Override
		public ClientClient create(Throwable cause) {
			log.info("Using fallback ClientClient for reason: {}, {}", cause.getMessage(), cause);
			return new ClientClient() {
				@Override
				public CollectionModel<Client> findByNameAndPhoneAndEmail(String name, String phone, String email) {
					return CollectionModel.empty();
				}
			};
		}
		
	}
}
