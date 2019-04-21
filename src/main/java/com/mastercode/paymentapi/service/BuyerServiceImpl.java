package com.mastercode.paymentapi.service;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mastercode.paymentapi.domain.Buyer;
import com.mastercode.paymentapi.domain.Payment;
import com.mastercode.paymentapi.repository.BuyerRepository;

@Service
public class BuyerServiceImpl implements BuyerService {
	@Autowired
	private BuyerRepository buyerRepository;

	@Override
	public void identifyBuyer(Payment payment) {
		Buyer buyer = createIfNotExistsByCpf(payment.getBuyer());
		payment.setBuyer(buyer);
	}

	private Buyer createIfNotExistsByCpf(@Valid Buyer buyer) {
		Buyer existingBuyer = buyerRepository.findByCpf(buyer.getCpf());
		if (existingBuyer == null) {
			return buyerRepository.save(buyer);
		} else {
			return existingBuyer;
		}
	}
}
