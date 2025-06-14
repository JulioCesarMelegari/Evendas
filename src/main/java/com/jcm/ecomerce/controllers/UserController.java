package com.jcm.ecomerce.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jcm.ecomerce.dtos.UserDTO;
import com.jcm.ecomerce.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService service;
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_CLIENT')")
	@GetMapping("/me")
	public ResponseEntity<UserDTO> getMe(){
		UserDTO dto = service.getMe();
		return ResponseEntity.ok(dto);
	}

}
