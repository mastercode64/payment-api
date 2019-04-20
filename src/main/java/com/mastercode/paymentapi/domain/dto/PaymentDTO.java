package com.mastercode.paymentapi.domain.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CPF;

import com.mastercode.paymentapi.domain.PaymentType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentDTO {
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
	@Min(value = 0)
	private BigDecimal value;

	@NotNull
	private PaymentType type;

	/* BOLETO INFO */
	private String boletoNumber;
	
	/* CREDIT CARD INFO */
	private String cardHolderName;
	private String cardNumber;
	private LocalDate cardExpirationDate;
	private String cardCvv;
}
