package com.dhiraj.springdata.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dhiraj.springdata.jpa.entity.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {

}
