package com.mastercode.paymentapi.service;

import org.springframework.stereotype.Service;

import com.mastercode.paymentapi.domain.entity.Payment;

@Service
public class MyPaymentService implements PaymentService {

	@Override
	public Payment createPayment() {
		return null;
	}

	@Override
	public Payment findPayment() {
		return null;
	}

	@Override
	public void checkout(Payment payment) {
	}

}
