package com.todocodeacademy.api_stock.repository;

import com.todocodeacademy.api_stock.model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface IVentaRepository extends JpaRepository<Venta, Long> {
    @Query(value = "SELECT p.codigo_producto, p.nombre, p.marca, p.costoV FROM productos p " +
            "JOIN venta_producto vp ON p.codigo_producto = vp.codigo_producto WHERE vp.codigo_venta = :codigoVenta",
            nativeQuery = true)
    List<Object[]> findProdutosByCodigoVenta(Long codigoVenta);

    @Query(value = "SELECT SUM(v.total) AS monto_tolal, COUNT(*) AS cantidad_venta FROM ventas v WHERE fecha_venta = :fechaVenta",
            nativeQuery = true)
    List<Object[]> findMontoTotalCantidadVenta(LocalDate fechaVenta);
}
