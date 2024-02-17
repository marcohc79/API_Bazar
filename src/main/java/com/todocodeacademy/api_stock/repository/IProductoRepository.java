package com.todocodeacademy.api_stock.repository;

import com.todocodeacademy.api_stock.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductoRepository extends JpaRepository<Producto, Long> {
}
