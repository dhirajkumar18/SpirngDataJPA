package com.dhiraj.springdata.jpa.exception;

public class OrderNotFoundException extends Exception{
	public OrderNotFoundException(Long id) {
		super("order not found with the given id ="+id);
	}

}
