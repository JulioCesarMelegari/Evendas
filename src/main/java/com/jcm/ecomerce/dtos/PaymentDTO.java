package com.jcm.ecomerce.dtos;

import java.time.Instant;

import com.jcm.ecomerce.entities.Payment;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PaymentDTO {
	
	private Long id;
	private Instant moment;
	
	public PaymentDTO(Payment entity) {
		id = entity.getId();
		moment = entity.getMoment();
	}
}
