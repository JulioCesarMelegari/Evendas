package com.jcm.ecomerce.entities;

import java.time.LocalDate;
import java.util.ArrayList;
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
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.AccessLevel;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_user")
public class User {
	
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	@Column(unique = true)//banco não aceita repeticao de email
	private String email;
	
	private String phone;
	
	private LocalDate birthDate;
	
	private String password;
	
	@Setter(AccessLevel.NONE)
	@OneToMany(mappedBy = "client")
	private List<Order> orders = new ArrayList<>();
	
	@Setter(AccessLevel.NONE)
	@ManyToMany
	@JoinTable(name = "tb_user_role",
				joinColumns = @JoinColumn(name = "user_id"),
				inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles = new HashSet<>();
	
	public void addRole(Role role) {
		roles.add(role);
	}
	
	public boolean hasRole(String roleNome) {
		for(Role role : roles) {
			if(role.getAuthority().equals(roleNome)) {
				return true;
			}
		}
		return false;
	}

}
