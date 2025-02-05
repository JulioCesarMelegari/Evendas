package com.jcm.ecomerce.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jcm.ecomerce.dtos.ProductDTO;
import com.jcm.ecomerce.entities.Product;
import com.jcm.ecomerce.repositories.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository repository;
	
	@Transactional(readOnly = true) //pacote spring
	public ProductDTO findById(Long id) {
		Product product = repository.findById(id).get();
		return new ProductDTO(product);
	}

}
