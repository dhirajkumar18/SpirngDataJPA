package com.dhiraj.springdata.jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dhiraj.springdata.jpa.entity.Author;
import com.dhiraj.springdata.jpa.entity.Book;
import com.dhiraj.springdata.jpa.exception.BookNotFoundException;
import com.dhiraj.springdata.jpa.repository.BookRepository;

@RestController
@RequestMapping("/api/v1")
public class BookController {

	@Autowired
	private BookRepository bookRepository;

	@PostMapping("/books")
	public Book createBook(@RequestBody Book book) {

		for (Author author : book.getAuthors()) {
			author.setBook(book);
		}
		return bookRepository.save(book);
	}

	@GetMapping("/books")
	public List<Book> getAllBooks() {
		return bookRepository.findAll();
	}
	
	@GetMapping("/books/{id}")
	public Book getBookById(@PathVariable Long id) throws BookNotFoundException {
		return bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException(id));
	}
}
	


