package com.mastercode.paymentapi.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class CreditCard {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	private String holderName;
	
	@NotBlank
	private String number;
	
	@NotNull
	private String expirationDate;
	
	@NotBlank
	private String cvv;

	public CreditCard(
			String holderName,
			String number,
			String expirationDate,
			String cvv) {
		this.holderName = holderName;
		this.number = number;
		this.expirationDate = expirationDate;
		this.cvv = cvv;
	}
	
	
	
}
