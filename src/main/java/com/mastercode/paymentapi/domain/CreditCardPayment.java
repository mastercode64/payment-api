package com.mastercode.paymentapi.domain;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class CreditCardPayment extends Payment {

	@NotBlank
	private String holderName;

	@NotNull
	private LocalDate expirationDate;

	@Transient
	@NotBlank
	private String expiration;

	@NotBlank
	@Column(unique = true)
	private String number;

	@NotBlank
	private String cvv;

}
