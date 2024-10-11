package com.luisgp.parcial2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luisgp.parcial2.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}
