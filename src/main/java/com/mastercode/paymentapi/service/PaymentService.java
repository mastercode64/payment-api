package com.mastercode.paymentapi.service;

import com.mastercode.paymentapi.domain.entity.Payment;

public interface PaymentService {
	Payment createPayment();
	Payment findPayment();
	void checkout(Payment payment);
}
