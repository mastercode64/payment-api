package com.mastercode.paymentapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mastercode.paymentapi.domain.BoletoPayment;
import com.mastercode.paymentapi.repository.BoletoPaymentRepository;

@Service
public class BoletoPaymentServiceImpl implements BoletoPaymentService {

	@Autowired
	private BoletoPaymentRepository boletoPaymentRepository;

	@Autowired
	private BuyerService buyerService;

	@Override
	public BoletoPayment createPayment(BoletoPayment payment) {
		buyerService.identifyBuyer(payment);
		payment.processPayment();
		return boletoPaymentRepository.save(payment);
	}

}
