package com.jcm.ecomerce.dtos;

import com.jcm.ecomerce.entities.Category;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDTO {
	
	private Long id;
	private String name;
	
	public CategoryDTO(Category entity) {
		id = entity.getId();
		name = entity.getName();
	}

	
}
