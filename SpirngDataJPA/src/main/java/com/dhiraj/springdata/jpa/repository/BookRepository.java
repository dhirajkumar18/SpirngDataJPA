package com.dhiraj.springdata.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dhiraj.springdata.jpa.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}
