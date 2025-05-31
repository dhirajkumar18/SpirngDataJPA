package com.dhiraj.springdata.jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dhiraj.springdata.jpa.entity.Order;
import com.dhiraj.springdata.jpa.entity.Product;
import com.dhiraj.springdata.jpa.exception.BookNotFoundException;
import com.dhiraj.springdata.jpa.exception.OrderNotFoundException;
import com.dhiraj.springdata.jpa.repository.OrderRepository;


@RestController
@RequestMapping("/api/v1")

public class OrderController {
	
	@Autowired
	private OrderRepository orderRepository;
	    
	@PostMapping("/orders")
	public Order createOrder(@RequestBody Order order) {
		
		for(Product product : order.getProducts()) {
			product.setOrder(order);
		}
		return orderRepository.save(order);
	}
	
	@GetMapping("/orders")
	public List<Order> getAllOrders(){
		return orderRepository.findAll();
	}
	
	@GetMapping("/orders/{id}")
	public Order getOrderById(@PathVariable Long id) throws OrderNotFoundException {
		return orderRepository.findById(id).orElseThrow(() -> new OrderNotFoundException(id));
	}
	
}
