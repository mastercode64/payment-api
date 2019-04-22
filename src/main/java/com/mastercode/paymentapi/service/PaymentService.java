package com.mastercode.paymentapi.service;

import com.mastercode.paymentapi.domain.Payment;

public interface PaymentService {
	Payment findPayment(Long id);
}
