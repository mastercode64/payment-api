package com.mastercode.paymentapi.domain.entity;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CPF;

import com.mastercode.paymentapi.domain.PaymentType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Payment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	private String clientID;

	@NotBlank
	private String buyerName;

	@NotBlank
	@Email
	private String buyerEmail;

	@NotBlank
	@CPF
	private String buyerCPF;

	@NotNull
	@Min(value = 50)
	private BigDecimal value;

	@NotNull
	private PaymentType type;

	private String boletoNumber;

	@OneToOne(orphanRemoval = true, cascade = CascadeType.ALL)
	private CreditCard creditCard;

}
