package com.mastercode.paymentapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mastercode.paymentapi.domain.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long>{

}
