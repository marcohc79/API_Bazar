package com.todocodeacademy.api_stock.service;

import com.todocodeacademy.api_stock.model.Venta;

import java.time.LocalDate;
import java.util.List;

public interface IVentaService {
    public Boolean  saveVenta(Venta venta);
    public void deleteVenta(Long codigo_venta);
    public List<Venta> getVentas();
    public Venta findVenta(Long codigo_venta);
    public void editVenta(Long codigo_venta, LocalDate nuevaFecha, Long nuevoCliente);
}
