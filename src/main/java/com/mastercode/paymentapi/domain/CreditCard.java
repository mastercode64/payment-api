package com.mastercode.paymentapi.domain;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

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

	@NotNull
	private LocalDate expirationDate;

	@JsonProperty(access = Access.WRITE_ONLY)
	@Transient
	@NotBlank
	private String expiration;

	@NotBlank
	@Column(unique = true)
	@Size(min = 13, max = 19)
	@Pattern(regexp = "[0-9]+", message = "Invalid credit card number")
	private String number;

	@NotBlank
	@Size(min = 3, max = 3)
	@Pattern(regexp = "[0-9]+", message = "Invalid cvv code")
	private String cvv;

}
