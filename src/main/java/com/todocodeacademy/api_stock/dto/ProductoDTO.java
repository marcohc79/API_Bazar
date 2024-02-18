package com.todocodeacademy.api_stock.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter @Setter
public class ProductoDTO implements Serializable {
    private Long codigo_producto;
    private String nombre;
    private String marca;
    private Integer costa;

    public ProductoDTO(){}

    public ProductoDTO(Long codigo_producto, String nombre, String marca, Integer costa) {
        this.codigo_producto = codigo_producto;
        this.nombre = nombre;
        this.marca = marca;
        this.costa = costa;
    }
}
