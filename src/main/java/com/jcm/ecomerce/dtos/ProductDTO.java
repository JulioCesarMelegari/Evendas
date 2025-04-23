package com.jcm.ecomerce.dtos;

import com.jcm.ecomerce.entities.Product;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ProductDTO {
	
	private Long id;
	private String name;
	private String description;
	private Double price;
	private String imgUrl;
	
	public ProductDTO(Product entity) {
		id = entity.getId();
		name = entity.getName();
		description = entity.getDescription();
		price = entity.getPrice();
		imgUrl = entity.getImgUrl();
	}

}
