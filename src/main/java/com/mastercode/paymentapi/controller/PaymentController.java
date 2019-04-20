package com.mastercode.paymentapi.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mastercode.paymentapi.domain.dto.PaymentDTO;
import com.mastercode.paymentapi.domain.entity.Payment;
import com.mastercode.paymentapi.service.PaymentService;

@RestController
@RequestMapping(path = "/payments", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class PaymentController {

	@Autowired
	private PaymentService paymentService;

	@GetMapping(value = "/{id}")
	public ResponseEntity<?> findById() {
		Payment payment = paymentService.findPayment();
		return new ResponseEntity<Payment>(payment, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<?> createPayment(@RequestBody @Valid PaymentDTO payment) {
		paymentService.createPayment(payment);
		return ResponseEntity.ok().build();
	}

}
