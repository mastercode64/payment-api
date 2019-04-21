package com.mastercode.paymentapi.service;

import com.mastercode.paymentapi.domain.Payment;

public interface BuyerService {
	void identifyBuyer(Payment payment);
}
