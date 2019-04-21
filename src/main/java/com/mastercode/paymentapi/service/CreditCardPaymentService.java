package com.mastercode.paymentapi.service;

import com.mastercode.paymentapi.domain.CreditCardPayment;

public interface CreditCardPaymentService {
	CreditCardPayment createPayment(CreditCardPayment payment);
	CreditCardPayment findPayment(Long id);
	void checkout(Long id);
}
