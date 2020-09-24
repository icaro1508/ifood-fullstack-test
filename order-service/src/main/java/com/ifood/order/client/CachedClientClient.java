package com.ifood.order.client;

import com.ifood.order.dto.Client;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import java.util.Collection;

@Slf4j
@Component
public class CachedClientClient {
	
	private final ClientClient clientClient;
	
	public CachedClientClient(ClientClient clientClient) {
		this.clientClient = clientClient;
	}
	
	@Cacheable(cacheNames = "client.findByNameAndPhoneAndEmail")
	public Collection<Client> findByNameAndPhoneAndEmail(String name, String phone, String email) {
		log.info("Fetching client data");
		return clientClient.findByNameAndPhoneAndEmail(name, phone,email).getContent();
	}
}
