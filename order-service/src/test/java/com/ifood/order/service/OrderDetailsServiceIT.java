package com.ifood.order.service;

import static com.ifood.order.utils.EntityMock.createClients;
import static com.ifood.order.utils.EntityMock.createOrders;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

import com.ifood.order.TestRedisConfiguration;
import com.ifood.order.client.CachedClientClient;
import com.ifood.order.client.ClientClient;
import com.ifood.order.dto.Client;
import com.ifood.order.repository.OrderRepository;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.hateoas.CollectionModel;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import java.util.List;
import java.util.UUID;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = TestRedisConfiguration.class)
public class OrderDetailsServiceIT {
	
	private final UUID CLIENT_ID = UUID.fromString("ebf04f85-4a83-4b67-b521-72a144daafc0");
	private final List<Client> CLIENTS = createClients(CLIENT_ID);
	
	@MockBean
	private ClientClient clientClientMock;
	
	@SpyBean
	private CachedClientClient cachedClientClient;
	
	@Test
	public void Should_RetrieveClientFromCache_When_FetchingCachedClient() {
		given(clientClientMock.findByNameAndPhoneAndEmail("john", null, null)).willReturn(CollectionModel.of(CLIENTS));
		
		cachedClientClient.findByNameAndPhoneAndEmail("john", null, null);
		verify(cachedClientClient, times(1)).findByNameAndPhoneAndEmail("john", null, null);
		cachedClientClient.findByNameAndPhoneAndEmail("john", null, null);
		
		verifyNoMoreInteractions(cachedClientClient);
	}
	
}
