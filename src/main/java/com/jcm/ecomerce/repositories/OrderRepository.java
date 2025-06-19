package com.jcm.ecomerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jcm.ecomerce.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
