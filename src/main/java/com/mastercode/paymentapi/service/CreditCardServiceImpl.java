package com.mastercode.paymentapi.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mastercode.paymentapi.domain.CreditCard;
import com.mastercode.paymentapi.domain.CreditCardPayment;
import com.mastercode.paymentapi.repository.CreditCardRepository;
import com.mastercode.paymentapi.util.LocalDateUtils;

@Service
public class CreditCardServiceImpl implements CreditCardService {

	@Autowired
	private CreditCardRepository creditCardRepository;

	@Override
	public void identifyCreditCard(CreditCardPayment payment) {
		setExpirationDate(payment);
		CreditCard card = createIfNotExistsByNumber(payment.getCreditCard());
		payment.setCreditCard(card);
	}

	private CreditCard createIfNotExistsByNumber(CreditCard creditCard) {
		CreditCard existingCard = creditCardRepository.findByNumber(creditCard.getNumber());
		if (existingCard == null) {
			return creditCardRepository.save(creditCard);
		} else {
			return existingCard;
		}
	}
	
	private void setExpirationDate(CreditCardPayment payment) {
		LocalDate expirationDate = LocalDateUtils.stringMonthYearToLocalDate(payment.getCreditCard().getExpiration());
		payment.getCreditCard().setExpirationDate(expirationDate);
	}

}
