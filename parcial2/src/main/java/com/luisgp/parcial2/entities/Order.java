package com.luisgp.parcial2.entities;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCompra;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Customer customer;
}
