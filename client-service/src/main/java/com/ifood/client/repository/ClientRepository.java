package com.ifood.client.repository;

import java.util.Collection;

import com.ifood.client.document.Client;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;


public interface ClientRepository extends MongoRepository<Client, String> {

	@RestResource(path = "byName")
	Collection<Client> findByNameIgnoreCaseContaining(@Param("name") String name);
	
	@RestResource(path = "byPhone")
	Collection<Client> findByPhoneIgnoreCaseContaining(@Param("phone") String phone);
	
	@RestResource(path = "byEmail")
	Collection<Client> findByEmailIgnoreCaseContaining(@Param("email") String email);
}