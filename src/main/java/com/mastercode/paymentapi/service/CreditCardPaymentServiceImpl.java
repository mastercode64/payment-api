package com.mastercode.paymentapi.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mastercode.paymentapi.domain.CreditCardPayment;
import com.mastercode.paymentapi.domain.PaymentStatus;
import com.mastercode.paymentapi.exception.ResourceNotFoundException;
import com.mastercode.paymentapi.repository.CreditCardPaymentRepository;
import com.mastercode.paymentapi.util.LocalDateUtils;

@Service
public class CreditCardPaymentServiceImpl implements CreditCardPaymentService {

	@Autowired
	private CreditCardPaymentRepository creditCardPaymentRepository;

	@Override
	public CreditCardPayment createPayment(CreditCardPayment payment) {
		payment.setStatus(PaymentStatus.WAITING);
		LocalDate expirationDate = LocalDateUtils.stringMonthYearToLocalDate(payment.getExpiration());
		payment.setExpirationDate(expirationDate);
		
		
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
