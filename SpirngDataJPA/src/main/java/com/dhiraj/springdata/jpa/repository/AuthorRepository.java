package com.dhiraj.springdata.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dhiraj.springdata.jpa.entity.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {

}
