package com.ifood.order.document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.With;
import org.springframework.data.mongodb.core.mapping.Document;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@With
@Data
@Builder
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