package com.mastercode.paymentapi.service;

import com.mastercode.paymentapi.domain.entity.Payment;

public interface PaymentService {
	Payment createPayment(Payment payment);
	Payment findPayment(Long id);
	void checkout(Payment payment);
}
