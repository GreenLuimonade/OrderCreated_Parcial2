package com.luisgp.parcial2.entities;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;


@Entity
@Data
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;//odio los integer los odio mucho, no sirven me joden el codigo y no se porque
    private String name;
    private String email;
    private Double balance;
}



