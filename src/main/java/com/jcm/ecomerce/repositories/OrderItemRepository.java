package com.jcm.ecomerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jcm.ecomerce.entities.OrderItem;
import com.jcm.ecomerce.entities.OrderItemPk;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPk>{

}
