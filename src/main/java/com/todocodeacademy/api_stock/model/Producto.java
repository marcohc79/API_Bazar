package com.todocodeacademy.api_stock.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@Entity
@Table(name = "PRODUCTOS")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "codigo_producto")
    private Long codigo_producto;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "marca")
    private String marca;
    @Column(name = "costo")
    private Integer costo = 0;
    @Column(name = "cantidad_disponible")
    private Integer cantidad_disponible = 0;

    public Producto(){}

    public Producto(Long codigo_producto, String nombre, String marca, Integer costo, Integer cantidad_disponible) {
        this.codigo_producto = codigo_producto;
        this.nombre = nombre;
        this.marca = marca;
        this.costo = costo;
        this.cantidad_disponible = cantidad_disponible;
    }
}
