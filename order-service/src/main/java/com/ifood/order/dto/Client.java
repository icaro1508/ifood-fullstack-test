package com.ifood.order.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

@Data
@NoArgsConstructor
public class Client implements Serializable {
	private String id;
	private String name;
	private String phone;
	private String email;
}
