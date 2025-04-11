package com.jcm.ecomerce.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
	
	@Transactional(readOnly = true)
	public Page<ProductDTO> findAll(Pageable pageable) {
		Page<Product> list = repository.findAll(pageable);
		return list.map(x ->new ProductDTO(x));
	}
	
	@Transactional
	public ProductDTO insert(ProductDTO dto) {
		Product entity = new Product();	
		copyDtoToEntity(dto, entity);
		entity = repository.save(entity);
		
		return new ProductDTO(entity);
	}
	
	@Transactional
	public ProductDTO update(Long id, ProductDTO dto) {
		Product entity = repository.getReferenceById(id);//diferentemente do findById(id).get()
		copyDtoToEntity(dto, entity);				//não faz a busca no banco
		entity = repository.save(entity);        //apenas referencia no jpa		
		return new ProductDTO(entity);
	}
	
	@Transactional
	public void delete(Long id) {
		repository.deleteById(id);
	}

	private void copyDtoToEntity(ProductDTO dto, Product entity) {
		entity.setName(dto.getName());
		entity.setDescription(dto.getDescription());
		entity.setPrice(dto.getPrice());
		entity.setImgUrl(dto.getImgUrl());	
	}

}
