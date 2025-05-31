package com.dhiraj.springdata.jpa.exception;

public class BookNotFoundException extends Exception{
	public BookNotFoundException(Long id) {
		super("Book not found with the given id ="+id);
	}

}
