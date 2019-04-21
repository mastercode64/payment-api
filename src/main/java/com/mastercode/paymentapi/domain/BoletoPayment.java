package com.mastercode.paymentapi.domain;

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

}
