package com.ifood.client.repository;

import java.util.Collection;
import java.util.UUID;

import com.ifood.client.document.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;


public interface ClientRepository extends CrudRepository<Client, UUID> {

	@RestResource(path = "byName")
	Collection<Client> findByNameIgnoreCaseContaining(@Param("name") String name);
	
	@RestResource(path = "byPhone")
	Collection<Client> findByPhoneIgnoreCaseContaining(@Param("phone") String phone);
	
	@RestResource(path = "byEmail")
	Collection<Client> findByEmailIgnoreCaseContaining(@Param("email") String email);
	
	@RestResource(path = "byNameAndPhoneAndEmail")
	Collection<Client> findByNameIgnoreCaseContainingAndPhoneIgnoreCaseContainingAndEmailIgnoreCaseContaining(
			@Param("name") String name,
			@Param("phone") String phone,
			@Param("email") String  email);
}