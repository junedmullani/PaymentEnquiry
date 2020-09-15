package com.jd.PaymentEnquiryHistory.exceptionhandle;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@ControllerAdvice
public class DatanotfoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ExceptionHandler(value = DatanotfoundException.class)
	   public ResponseEntity<Object> exception(DatanotfoundException exception) {
	      return new ResponseEntity<>("Data not found", HttpStatus.NOT_FOUND);
	   }

	
}
