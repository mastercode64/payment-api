package com.mastercode.paymentapi.service;

import com.mastercode.paymentapi.domain.BoletoPayment;

public interface BoletoPaymentService {
	BoletoPayment createPayment(BoletoPayment payment);
	BoletoPayment findPayment(Long id);
	void checkout(Long id);
}
