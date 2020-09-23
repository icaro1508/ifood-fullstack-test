package com.ifood.client.document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.With;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@With
@Entity
@Data
@Builder
@AllArgsConstructor
public class Client {
	
	@Id private UUID id = UUID.randomUUID();
	private String name;
	private String email;
	private String phone;
	
	public Client(String name, String email, String phone) {
		this.name = name;
		this.email = email;
		this.phone = phone;
	}
	
	protected Client() {
		this(null, null, null);
	}
}
