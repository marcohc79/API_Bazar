package com.todocodeacademy.api_stock.service;

import com.todocodeacademy.api_stock.model.Producto;
import com.todocodeacademy.api_stock.repository.IProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService implements IProductoService{
    @Autowired
    private IProductoRepository productoRepository;

    @Override
    public void saveProducto(Producto producto) {
        productoRepository.save(producto);
    }

    @Override
    public void deleteProducto(Long id) {
        productoRepository.deleteById(id);
    }

    @Override
    public List<Producto> getProductos() {
        return productoRepository.findAll();
    }

    @Override
    public Producto findProducto(Long id) {
        return productoRepository.findById(id).orElse(null);
    }

    @Override
    public void editProducto(Long codigoProducto, String nuevoNombre, String nuevaMarca, Integer nuevoCosto, Integer nuevaCantidadDisponible) {
        Producto producto = this.findProducto(codigoProducto);
        producto.setNombre(nuevoNombre != null ? nuevoNombre : producto.getNombre());
        producto.setMarca(nuevaMarca != null ? nuevaMarca : producto.getMarca());
        producto.setCosto(nuevoCosto != null ? nuevoCosto : producto.getCosto());
        producto.setCantidad_disponible(nuevaCantidadDisponible != null ? nuevaCantidadDisponible : producto.getCantidad_disponible());
        this.saveProducto(producto);
    }

    @Override
    public List<Producto> findFaltaStock() {
       return productoRepository.findFaltaStock();
    }

}
