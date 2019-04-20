package com.mastercode.paymentapi.exception;

public class ValidationErrorException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ValidationErrorException() {
		super();
	}

	public ValidationErrorException(String message) {
		super(message);
	}
}
