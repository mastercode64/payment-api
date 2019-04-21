package com.mastercode.paymentapi.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mastercode.paymentapi.domain.BoletoPayment;
import com.mastercode.paymentapi.domain.PaymentStatus;
import com.mastercode.paymentapi.exception.ResourceNotFoundException;
import com.mastercode.paymentapi.repository.BoletoPaymentRepository;

@Service
public class BoletoPaymentServiceImpl implements BoletoPaymentService {

	@Autowired
	private BoletoPaymentRepository boletoPaymentRepository;

	@Override
	public BoletoPayment createPayment(BoletoPayment payment) {
		String randomCode = UUID.randomUUID().toString();
		payment.setBoletoNumber(randomCode);
		payment.setStatus(PaymentStatus.WAITING);
		return boletoPaymentRepository.save(payment);
	}

	@Override
	public BoletoPayment findPayment(Long id) {
		return boletoPaymentRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Boleto payment " + id + " not found"));
	}

	@Override
	public void checkout(Long id) {
		// TODO Auto-generated method stub

	}

}
