package com.mastercode.paymentapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mastercode.paymentapi.domain.CreditCardPayment;

@Repository
public interface CreditCardPaymentRepository extends JpaRepository<CreditCardPayment, Long> {

}
