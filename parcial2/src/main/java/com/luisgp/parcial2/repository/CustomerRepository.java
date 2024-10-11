package com.luisgp.parcial2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luisgp.parcial2.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{

}
