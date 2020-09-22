package com.ifood.client.document;

import lombok.Data;
import lombok.Setter;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Client {
	
	@Id private String id;
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
