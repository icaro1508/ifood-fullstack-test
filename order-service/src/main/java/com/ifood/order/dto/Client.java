package com.ifood.order.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Client {
	private String id;
	private String name;
	private String phone;
	private String email;
}
