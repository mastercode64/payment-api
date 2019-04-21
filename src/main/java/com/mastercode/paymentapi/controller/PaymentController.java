package com.mastercode.paymentapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mastercode.paymentapi.domain.BoletoPayment;
import com.mastercode.paymentapi.domain.CreditCardPayment;
import com.mastercode.paymentapi.domain.PaymentType;
import com.mastercode.paymentapi.response.BoletoCreationResponse;
import com.mastercode.paymentapi.service.BoletoPaymentService;
import com.mastercode.paymentapi.service.CreditCardPaymentService;

@RestController
@RequestMapping(path = "/payments", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class PaymentController {

	@Autowired
	private BoletoPaymentService boletoPaymentService;

	@Autowired
	private CreditCardPaymentService creditCardPaymentService;

	@GetMapping(value = "/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id, @RequestBody PaymentType paymentType) {
		return new ResponseEntity<>(null, HttpStatus.OK);
	}

	@PostMapping(path = "/boleto")
	public ResponseEntity<?> createBoletoPayment(@RequestBody BoletoPayment payment) {
		payment = boletoPaymentService.createPayment(payment);
		BoletoCreationResponse response = new BoletoCreationResponse(payment.getBoletoNumber());
		return new ResponseEntity<BoletoCreationResponse>(response, HttpStatus.CREATED);
	}

	@PostMapping(path = "/credit-card")
	public ResponseEntity<?> createCreditCardPayment(@RequestBody CreditCardPayment payment) {
		payment = creditCardPaymentService.createPayment(payment);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

}
