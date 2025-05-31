package com.dhiraj.springdata.jpa.exception;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
		
	@ExceptionHandler(BookNotFoundException.class)
	public ResponseEntity<Map<String,Object>> handleBookNotFoundException(BookNotFoundException be) throws BookNotFoundException {
		Map<String,Object> response=new HashMap<>();
		response.put("timestamp", LocalDate.now());
		response.put("message",be.getMessage());
		response.put("status", HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler(OrderNotFoundException.class)
	public ResponseEntity<Map<String,Object>> handleOrderNotFoundException(OrderNotFoundException oe) throws OrderNotFoundException {
		Map<String,Object> response=new HashMap<>();
		response.put("timestamp", LocalDate.now());
		response.put("message",oe.getMessage());
		response.put("status", HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
		
	}
	

}
