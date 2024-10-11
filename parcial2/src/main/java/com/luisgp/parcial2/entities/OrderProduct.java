package com.luisgp.parcial2.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import lombok.Data;

@Data
@Entity
@IdClass(OrderProductId.class)
public class OrderProduct {
    @Id
    private Integer idCompra;
    @Id
    private Integer idProducto;
    private Integer cantidad;
}
