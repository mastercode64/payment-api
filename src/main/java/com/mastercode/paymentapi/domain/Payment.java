package com.mastercode.paymentapi.domain;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Payment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	private String clientID;

	@ManyToOne(optional = false, cascade = CascadeType.ALL)
	private Buyer buyer;
	
	@Enumerated(EnumType.STRING)
	private PaymentStatus status = PaymentStatus.WAITING;

	@NotNull
	@Digits(fraction = 2, integer = 20)
	@DecimalMin(value = "0.01")
	private BigDecimal value;

}
