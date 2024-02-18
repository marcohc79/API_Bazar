package com.todocodeacademy.api_stock.service;

import com.todocodeacademy.api_stock.dto.MontoCantidadVentaDTO;
import com.todocodeacademy.api_stock.dto.ProductoDTO;
import com.todocodeacademy.api_stock.model.Venta;

import java.time.LocalDate;
import java.util.List;

public interface IVentaService {
    Boolean  saveVenta(Venta venta);
    void deleteVenta(Long codigo_venta);
    List<Venta> getVentas();
    Venta findVenta(Long codigo_venta);
    void editVenta(Long codigo_venta, LocalDate nuevaFecha, Long nuevoCliente);

    List<ProductoDTO> findProductosByCodigoVenta(Long codigoVenta);
    MontoCantidadVentaDTO findMontoContidadVento(LocalDate fechaVenta);
}
