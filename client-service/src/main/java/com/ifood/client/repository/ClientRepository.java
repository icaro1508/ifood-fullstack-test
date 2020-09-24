package com.ifood.client.repository;

import com.ifood.client.document.Client;
import com.ifood.client.document.QClient;
import com.querydsl.core.types.dsl.StringExpression;
import com.querydsl.core.types.dsl.StringPath;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import java.util.Collection;
import java.util.UUID;


public interface ClientRepository
		extends CrudRepository<Client, UUID>, QuerydslPredicateExecutor<Client>, QuerydslBinderCustomizer<QClient> {

	@RestResource(path = "byName")
	Collection<Client> findByNameIgnoreCaseContaining(@Param("name") String name);
	
	@RestResource(path = "byPhone")
	Collection<Client> findByPhoneIgnoreCaseContaining(@Param("phone") String phone);
	
	@RestResource(path = "byEmail")
	Collection<Client> findByEmailIgnoreCaseContaining(@Param("email") String email);
	
	@Override
	default void customize(QuerydslBindings querydslBindings, QClient qClient) {
		querydslBindings.bind(String.class).first((StringPath path, String value) -> path.containsIgnoreCase(value));
	}
	
}