package com.todocodeacademy.api_stock.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter @Setter
public class MontoCantidadVentaDTO implements Serializable {
    private Integer monto_total;
    private Integer cantidad_venta;

    public MontoCantidadVentaDTO(){}

    public MontoCantidadVentaDTO(Integer monto_total, Integer cantidad_venta) {
        this.monto_total = monto_total;
        this.cantidad_venta = cantidad_venta;
    }
}
