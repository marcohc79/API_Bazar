package com.todocodeacademy.api_stock.repository;

import com.todocodeacademy.api_stock.dto.ProductoDTO;
import com.todocodeacademy.api_stock.model.Producto;
import com.todocodeacademy.api_stock.model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IVentaRepository extends JpaRepository<Venta, Long> {
    @Query(value = "SELECT p.codigo_producto, p.nombre, p.marca, p.costoV FROM productos p JOIN venta_producto vp ON p.codigo_producto = vp.codigo_producto WHERE vp.codigo_venta = :codigoVenta", nativeQuery = true)
    List<Object[]> findProdutosByCodigoVenta(Long codigoVenta);
}
