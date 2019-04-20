package com.mastercode.paymentapi.service;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mastercode.paymentapi.domain.entity.Payment;
import com.mastercode.paymentapi.exception.ResourceNotFoundException;
import com.mastercode.paymentapi.repository.PaymentRepository;

@Service
public class MyPaymentService implements PaymentService {

	@Autowired
	private PaymentRepository paymentRepository;

	@Override
	public Payment createPayment(@Valid Payment payment) {
		return paymentRepository.save(payment);
	}

	@Override
	public Payment findPayment(Long id) {
		return paymentRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Payment " + id + " not found"));
	}

	@Override
	public void checkout(Payment payment) {
		// TODO Auto-generated method stub

	}

}
