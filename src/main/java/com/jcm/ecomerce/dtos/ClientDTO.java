package com.jcm.ecomerce.dtos;

import com.jcm.ecomerce.entities.User;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ClientDTO {
	
	private Long id;
	private String name;
	
	public ClientDTO(User entity) {
		id = entity.getId();
		name = entity.getName();
	}
}
