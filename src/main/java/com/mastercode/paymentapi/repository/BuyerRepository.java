package com.mastercode.paymentapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mastercode.paymentapi.domain.Buyer;

@Repository
public interface BuyerRepository extends JpaRepository<Buyer, Long> {
	Buyer findByCpf(String cpf);
}
