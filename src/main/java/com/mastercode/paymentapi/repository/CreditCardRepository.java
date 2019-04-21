package com.mastercode.paymentapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mastercode.paymentapi.domain.CreditCard;

@Repository
public interface CreditCardRepository extends JpaRepository<CreditCard, Long> {
	CreditCard findByNumber(String number);
}
