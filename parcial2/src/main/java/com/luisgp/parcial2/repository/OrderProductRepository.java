package com.luisgp.parcial2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luisgp.parcial2.entities.OrderProduct;
import com.luisgp.parcial2.entities.OrderProductId;

public interface OrderProductRepository extends JpaRepository<OrderProduct, OrderProductId> {
}//talvez debi nombrarlo product list o algo asi, no me gusta el nombre
