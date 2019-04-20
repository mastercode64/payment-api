package com.mastercode.paymentapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mastercode.paymentapi.service.PaymentService;

@RestController
@RequestMapping(path = "/payments", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class PaymentController {
	
	@Autowired
	private PaymentService paymentService;

	@GetMapping(value = "/{id}")
	public ResponseEntity<?> findById() {		
		paymentService.findPayment();
		return null;
	}

	@PostMapping
	public ResponseEntity<?> createPayment() {
		paymentService.createPayment();
		return null;
	}

}
