package com.jd.PaymentEnquiryHistory.exceptionhandle;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class NullDataException extends RuntimeException {

private static final long serialVersionUID = 1L;
	
	@ExceptionHandler(value = NullDataException.class)
	   public ResponseEntity<Object> exception(NullDataException exception) {
	      return new ResponseEntity<>("Null Data Found.", HttpStatus.PARTIAL_CONTENT);
	   }

	
	
}
