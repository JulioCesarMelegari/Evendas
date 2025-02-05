package com.jcm.ecomerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jcm.ecomerce.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
