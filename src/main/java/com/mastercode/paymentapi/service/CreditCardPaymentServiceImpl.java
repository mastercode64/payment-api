package com.mastercode.paymentapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mastercode.paymentapi.domain.CreditCardPayment;
import com.mastercode.paymentapi.exception.ResourceNotFoundException;
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

	@Override
	public CreditCardPayment findPayment(Long id) {
		return creditCardPaymentRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Credit card payment " + id + " not found"));
	}

	@Override
	public void checkout(Long id) {
		// TODO Auto-generated method stub

	}

}
