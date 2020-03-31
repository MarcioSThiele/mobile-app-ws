package com.appsdeveloperblog.app.ws.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class AppExceptionsHandler extends ResponseEntityExceptionHandler {
	
	//this class to does the API exceptions 
	//you can add more functions with the exceptions, it does not need only one
	@ExceptionHandler(value = {Exception.class})
	public ResponseEntity<Object> handleAnyException(Exception ex, WebRequest request){
		return new ResponseEntity<>(ex, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

}