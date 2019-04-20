package com.mastercode.paymentapi.exception;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;

@ControllerAdvice
public class CustomExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> resourceNotFoundHandler(ResourceNotFoundException ex, HttpServletRequest request){		
		HttpStatus status = HttpStatus.NOT_FOUND;
		
		StandardError error =	new StandardError(
				System.currentTimeMillis(),
				status.value(),
				"Resource not found",
				ex.getMessage(),
				request.getRequestURI());
		
		return ResponseEntity.status(status).body(error);
	}

	
	@ExceptionHandler(ValidationErrorException.class)
	public ResponseEntity<?> customValidationErrorHandler(ValidationErrorException ex, HttpServletRequest request){
		HttpStatus status = HttpStatus.BAD_REQUEST;
		
		StandardError error =	new StandardError(
				System.currentTimeMillis(),
				status.value(),
				"Validation error",
				ex.getMessage(),
				request.getRequestURI());
		
		return ResponseEntity.status(status).body(error);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> validationErrorHandler( MethodArgumentNotValidException ex, HttpServletRequest request ) {
	   HttpStatus status = HttpStatus.BAD_REQUEST;
	   
	   final List<String> errors = new ArrayList<String>();
       for (final FieldError error : ex.getBindingResult().getFieldErrors()) {
           errors.add(error.getField() + ": " + error.getDefaultMessage());
       }
       for (final ObjectError error : ex.getBindingResult().getGlobalErrors()) {
           errors.add(error.getObjectName() + ": " + error.getDefaultMessage());
       }
	   
		StandardError error =	new StandardError(
				System.currentTimeMillis(),
				status.value(),
				"Validation error",
				errors,
				request.getRequestURI());
		
		return ResponseEntity.status(status).body(error);
	}
	
	@ExceptionHandler(InvalidFormatException.class)
	public ResponseEntity<?> invalidFormatHandler(InvalidFormatException ex, HttpServletRequest request){
		HttpStatus status = HttpStatus.BAD_REQUEST;
		
		StandardError error =	new StandardError(
				System.currentTimeMillis(),
				status.value(),
				"Invalid Format",
				ex.getMessage(),
				request.getRequestURI());
		
		return ResponseEntity.status(status).body(error);
	}
}
