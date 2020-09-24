package com.ifood.order.dto;

import com.ifood.order.document.Order;
import lombok.Builder;
import lombok.Data;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Data
@Builder
public class OrderDetails {
	
	private UUID id;
	private final LocalDate createdAt;
	private final Double totalValue;
	private final List<Order.Item> items;
	private final Client client;
}
