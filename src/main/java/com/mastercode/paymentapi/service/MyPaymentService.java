package com.mastercode.paymentapi.service;

import org.springframework.stereotype.Service;

import com.mastercode.paymentapi.domain.dto.PaymentDTO;
import com.mastercode.paymentapi.domain.entity.Payment;

@Service
public class MyPaymentService implements PaymentService {

	@Override
	public Payment createPayment(PaymentDTO paymentDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Payment findPayment() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void checkout(Payment payment) {
		// TODO Auto-generated method stub

	}

}
