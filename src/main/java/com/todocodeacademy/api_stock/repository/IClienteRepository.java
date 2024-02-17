package com.todocodeacademy.api_stock.repository;

import com.todocodeacademy.api_stock.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClienteRepository extends JpaRepository<Cliente, Long> {
}
