package com.jcm.ecomerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jcm.ecomerce.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}
