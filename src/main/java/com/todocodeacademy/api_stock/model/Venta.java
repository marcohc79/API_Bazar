package com.todocodeacademy.api_stock.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter @Setter
@Entity
@Table(name = "VENTAS")
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "codigo_venta")
    private Long codigo_venta;
    @Column(name = "fecha_venta")
    private LocalDate fecha_venta;
    @Column(name = "total")
    private Integer total = 0;

    @ManyToMany
    @JoinTable(
            name = "venta_producto",
            joinColumns = @JoinColumn(name = "codigo_venta"),
            inverseJoinColumns = @JoinColumn(name = "codigo_producto")
    )
    private List<Producto> lista_productos;

    @ManyToOne
    @JoinColumn(name = "id_cliente_venta", referencedColumnName = "id_cliente")
    private Cliente cliente;

    public Venta(){}

    public Venta(Long codigo_venta, LocalDate fecha_venta, Integer total, List<Producto> lista_productos, Cliente cliente) {
        this.codigo_venta = codigo_venta;
        this.fecha_venta = fecha_venta;
        this.total = total;
        this.lista_productos = lista_productos;
        this.cliente = cliente;
    }
}
