package com.mastercode.paymentapi.service;

import com.mastercode.paymentapi.domain.BoletoPayment;

public interface BoletoPaymentService {
	BoletoPayment createPayment(BoletoPayment payment);
}
