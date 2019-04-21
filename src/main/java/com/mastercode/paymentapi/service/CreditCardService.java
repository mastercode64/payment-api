package com.mastercode.paymentapi.service;

import com.mastercode.paymentapi.domain.CreditCardPayment;

public interface CreditCardService {
	void identifyCreditCard(CreditCardPayment payment);
}
