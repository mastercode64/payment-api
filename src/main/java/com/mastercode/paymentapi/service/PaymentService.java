package com.mastercode.paymentapi.service;

import com.mastercode.paymentapi.domain.dto.PaymentDTO;
import com.mastercode.paymentapi.domain.entity.Payment;

public interface PaymentService {
	Payment createPayment(PaymentDTO paymentDTO);
	Payment findPayment();
	void checkout(Payment payment);
}
