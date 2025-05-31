package com.dhiraj.springdata.jpa.entity;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="orders")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String customerName;
	
	@OneToMany(mappedBy="order", cascade = CascadeType.ALL,orphanRemoval = true)
	private List<Product> products;
	
	public Order() {
		super();
	}

	public Order(Long id, String customerName, List<Product> products) {
		super();
		this.id = id;
		this.customerName = customerName;
		this.products = products;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
    
	
	@Override
	public int hashCode() {
		return Objects.hash(customerName, id, products);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return Objects.equals(customerName, other.customerName) && Objects.equals(id, other.id)
				&& Objects.equals(products, other.products);
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", customerName=" + customerName + ", products=" + products + "]";
	}
	
	
	

}
