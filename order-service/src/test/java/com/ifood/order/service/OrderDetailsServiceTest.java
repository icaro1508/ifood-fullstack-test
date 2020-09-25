package com.ifood.order.service;

import static com.ifood.order.utils.EntityMock.createClients;
import static com.ifood.order.utils.EntityMock.createOrders;
import static java.time.temporal.ChronoUnit.DAYS;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

import com.ifood.order.client.CachedClientClient;
import com.ifood.order.document.Order;
import com.ifood.order.document.Order.Item;
import com.ifood.order.dto.Client;
import com.ifood.order.dto.OrderDetails;
import com.ifood.order.repository.OrderRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@ExtendWith(MockitoExtension.class)
class OrderDetailsServiceTest {
	
	private final String CLIENT_UUID = "25ec4c19-6aa1-49e4-b485-777821ce5b27";
	private final String CLIENT_UUID_2 = "d3711525-d778-407f-97b4-e3e8f3919ef0";
	private final LocalDateTime ORDER_DATE = LocalDateTime.of(2020, 9, 23, 0, 0, 0);
	
	@Mock
	OrderRepository orderRepository;
	
	@Mock
	CachedClientClient cachedClientClient;
	
	@InjectMocks
	OrderDetailsService orderDetailsService;
	
	@Test
	public void findFiltered_shouldReturnOrdersWithClient() {
		final UUID clientId = UUID.fromString(CLIENT_UUID);
		final UUID noClientOrderId = UUID.fromString("ebf04f85-4a83-4b67-b521-72a144daafc0");
		
		given(orderRepository.findByCreatedAtBetween(any(), any()))
				.willReturn(createOrders(clientId, noClientOrderId));
		given(cachedClientClient.findByNameAndPhoneAndEmail(any(), any(), any()))
				.willReturn(createClients(clientId, UUID.fromString(CLIENT_UUID_2)));
		
		LocalDate after = LocalDateTime.from(ORDER_DATE.minus(1, DAYS)).toLocalDate();
		LocalDate before = LocalDateTime.from(ORDER_DATE.plus(1, DAYS)).toLocalDate();
		
		
		List<OrderDetails> filtered = orderDetailsService.findFiltered(after, before, null, null, null);
		
		
		OrderDetails actualOrder = filtered.get(0);
		Assertions.assertThat(1).isEqualTo(filtered.size());
		Assertions.assertThat(actualOrder.getClient().getId()).isEqualTo(clientId.toString());
	}
}