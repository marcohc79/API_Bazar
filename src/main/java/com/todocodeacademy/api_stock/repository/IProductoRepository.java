package com.todocodeacademy.api_stock.repository;

import com.todocodeacademy.api_stock.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IProductoRepository extends JpaRepository<Producto, Long> {
    static final int MIN_STOCK = 5;
    @Query(value = "SELECT * FROM productos WHERE cantidad_disponible < " + MIN_STOCK, nativeQuery = true)
    List<Producto> findFaltaStock();
}
