package com.ifood.order.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Client {
	private String id;
	private String name;
	private String phone;
	private String email;
}
