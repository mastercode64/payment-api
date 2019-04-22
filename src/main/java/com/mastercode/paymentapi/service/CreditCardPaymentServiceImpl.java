package com.mastercode.paymentapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mastercode.paymentapi.domain.CreditCardPayment;
import com.mastercode.paymentapi.repository.CreditCardPaymentRepository;

@Service
public class CreditCardPaymentServiceImpl implements CreditCardPaymentService {

	@Autowired
	private CreditCardPaymentRepository creditCardPaymentRepository;

	@Autowired
	private BuyerService buyerService;

	@Autowired
	private CreditCardService creditCardService;

	@Override
	public CreditCardPayment createPayment(CreditCardPayment payment) {
		buyerService.identifyBuyer(payment);
		creditCardService.identifyCreditCard(payment);
		return creditCardPaymentRepository.save(payment);
	}

}
