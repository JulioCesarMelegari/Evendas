package com.jcm.ecomerce.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
@Setter
@Entity
@Table(name = "tb_order_item")
public class OrderItem {
	
	@EqualsAndHashCode.Include
	@Setter(AccessLevel.NONE)
	@Getter(AccessLevel.NONE)
	@EmbeddedId
	private OrderItemPk id = new OrderItemPk();
	
	private Integer quantity;
	
	private Double price;
	
	public OrderItem() {}

	public OrderItem(Order order,Product product, Integer quantity, Double price) {
		id.setOrder(order);
		id.setProduct(product);
		this.quantity = quantity;
		this.price = price;
	}
	
	public Order getOrder() {
		return id.getOrder();
	}
	public Product getProduct() {
		return id.getProduct();
	}
	public void setOrder(Order order) {
		id.setOrder(order);
	}
	public void setProduct(Product product) {
		id.setProduct(product);
	}
	
}
