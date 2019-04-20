package com.mastercode.paymentapi.domain.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.mastercode.paymentapi.domain.PaymentType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Payment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String clientId;

	private String buyerName;
	private String buyerEmail;
	private String buyerCPF;

	@Enumerated(EnumType.STRING)
	private PaymentType paymentType;

	@ManyToOne
	private CreditCard creditCard;
	
	private String boletoNumber;

}
