package com.jcm.ecomerce.services;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jcm.ecomerce.dtos.OrderDTO;
import com.jcm.ecomerce.dtos.OrderItemDTO;
import com.jcm.ecomerce.entities.Order;
import com.jcm.ecomerce.entities.OrderItem;
import com.jcm.ecomerce.entities.OrderStatus;
import com.jcm.ecomerce.entities.Product;
import com.jcm.ecomerce.entities.User;
import com.jcm.ecomerce.repositories.OrderItemRepository;
import com.jcm.ecomerce.repositories.OrderRepository;
import com.jcm.ecomerce.repositories.ProductRepository;
import com.jcm.ecomerce.services.exceptions.ResourceNotFoundException;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository repository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private OrderItemRepository orderItemRepository;
	
	@Autowired
	private UserService userService;
	
	@Transactional(readOnly = true)
	public OrderDTO findById(Long id) {
		Order order = repository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Recurso não encontrado"));
		return new OrderDTO(order);
	}
	
	@Transactional
	public OrderDTO insert(OrderDTO dto) {
		Order order = new Order();
		
		order.setMoment(Instant.now());
		order.setStatus(OrderStatus.WAITING_PAYMENT);
		
		User user = userService.authenticated();
		order.setClient(user);
		
		for(OrderItemDTO itemDto : dto.getItems()) {
			Product product = productRepository.getReferenceById(itemDto.getProductId());
			OrderItem item = new OrderItem(order, product, itemDto.getQuantity(), product.getPrice());
			order.getItems().add(item);
		}
		repository.save(order);
		orderItemRepository.saveAll(order.getItems());
		
		return new OrderDTO(order);
	}

}
