package com.dhiraj.springdata.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dhiraj.springdata.jpa.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

}
