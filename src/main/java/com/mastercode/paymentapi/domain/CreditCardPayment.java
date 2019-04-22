package com.mastercode.paymentapi.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class CreditCardPayment extends Payment {

	@ManyToOne(optional = false, cascade = CascadeType.ALL)
	private CreditCard creditCard;

	@Override
	public void processPayment() {
		this.setStatus(PaymentStatus.AUTHORIZED);
	}

}
