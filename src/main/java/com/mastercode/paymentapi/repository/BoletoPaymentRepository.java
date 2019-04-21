package com.mastercode.paymentapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mastercode.paymentapi.domain.BoletoPayment;

@Repository
public interface BoletoPaymentRepository extends JpaRepository<BoletoPayment, Long> {

}
