package com.luisgp.parcial2.entities;

import java.io.Serializable;

import lombok.Data;

@Data
public class OrderProductId implements Serializable {
    private Integer idCompra;
    private Integer idProducto;
}
//no supe mas como ponerlo para buscar del mysql pero odio esta clase, ojala no tener que crearla, probablemente se pueda pero no tengo la paciencia para buscar
