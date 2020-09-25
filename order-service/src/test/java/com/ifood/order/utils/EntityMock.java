package com.ifood.order.utils;

import com.ifood.order.document.Order;
import com.ifood.order.document.Order.Item;
import com.ifood.order.dto.Client;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class EntityMock {
	private static final LocalDateTime ORDER_DATE = LocalDateTime.of(2020, 9, 23, 0, 0, 0);
	
	public static List<Order> createOrders(UUID...clientIds) {
		List<Order> orders = new ArrayList<>();
		for (UUID uuid : clientIds) {
			orders.add(createOrder(ORDER_DATE, uuid));
		}
		return orders;
	}
	
	public static Order createOrder(LocalDateTime createdAt, UUID uuid) {
		return Order.builder().id(UUID.randomUUID()).createdAt(createdAt).clientId(uuid).items(Arrays
				.asList(new Item("Item 1", 1, 3.39), new Item("Item 2", 3, 1.5), new Item("Item 3", 1, 4.0))).build();
	}
	
	public static List<Client> createClients(UUID ...clientIds) {
		List<Client> clients = new ArrayList<>();
		for (UUID uuid : clientIds) {
			Client c = new Client();
			c.setId(uuid.toString());
			clients.add(c);
		}
		return clients;
	}
}
