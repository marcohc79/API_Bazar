package com.todocodeacademy.api_stock.repository;

import com.todocodeacademy.api_stock.model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IVentaRepository extends JpaRepository<Venta, Long> {
}
