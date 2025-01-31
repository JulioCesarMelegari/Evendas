package com.jcm.ecomerce.entities;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tb_product")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	@Column(columnDefinition = "TEXT")//jpa informa ao banco de dados que o campo receberá um texto maior
	private String description;
	
	private Double price;
	
	private String imgUrl;
	
	//no relacionamento muitos para muitnos, no banco teremos uma terceira tabela refererenciando o id do produto com id da categoria
	@Setter(AccessLevel.NONE) //importante que os ids nao se repitam na terceira tabela auxiliar para isso utilizamos o tipo Set e não List
	@ManyToMany
	@JoinTable(name = "tb_product_category", 
		joinColumns = @JoinColumn(name = "product_id"),
		inverseJoinColumns = @JoinColumn(name = "category_id"))//codigo acima define a tabela de associação
	private Set<Category> categories = new HashSet<>(); 
	
	@Setter(AccessLevel.NONE)
	@OneToMany(mappedBy = "id.product")
	private Set<OrderItem> items = new HashSet<>();
	
	public List<Order> getOrders(){
		return items.stream().map(x -> x.getOrder()).toList();
	}
	
}
