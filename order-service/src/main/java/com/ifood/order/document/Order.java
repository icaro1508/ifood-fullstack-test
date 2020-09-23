package com.ifood.order.document;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.With;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@With
@Data
@Document
@RequiredArgsConstructor
@AllArgsConstructor
public class Order {
	
	private @Id UUID id = UUID.randomUUID();
	private final UUID clientId;
	private final UUID restaurantId;
	private final LocalDateTime createdAt;
	private final LocalDateTime confirmedAt;
	private final List<Item> items;
	
	protected Order() {
		this(null, null, null, null, null);
	}
	
	@With
	@Data
	@RequiredArgsConstructor
	public static class Item {

		private final String description;
		private final Integer quantity;
		private final Double price;
		
		protected Item() {
			this(null, null, null);
		}
	}
}