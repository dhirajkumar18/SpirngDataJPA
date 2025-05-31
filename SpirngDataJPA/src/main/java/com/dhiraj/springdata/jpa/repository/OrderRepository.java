package com.dhiraj.springdata.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dhiraj.springdata.jpa.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
