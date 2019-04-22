package com.mastercode.paymentapi.domain;

import java.util.UUID;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class BoletoPayment extends Payment {

	@NotBlank
	private String boletoNumber;

	@Override
	public void processPayment() {
		this.setStatus(PaymentStatus.AUTHORIZED);
		this.setBoletoNumber(UUID.randomUUID().toString());
	}

}
