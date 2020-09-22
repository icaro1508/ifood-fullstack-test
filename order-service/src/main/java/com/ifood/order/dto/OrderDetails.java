package com.ifood.order.dto;

import com.ifood.order.document.Order;
import lombok.Builder;
import lombok.Data;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
@Builder
public class OrderDetails {
	
	private UUID id;
	private final UUID clientId;
	private final Date createdAt;
	private final Date confirmedAt;
	private final List<Order.Item> items;
}
