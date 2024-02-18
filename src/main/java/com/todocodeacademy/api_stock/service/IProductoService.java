package com.todocodeacademy.api_stock.service;

import com.todocodeacademy.api_stock.model.Producto;
import java.util.List;

public interface IProductoService {
    void saveProducto(Producto producto);
    void deleteProducto(Long id);
    List<Producto>  getProductos();
    Producto findProducto(Long id);
    void editProducto(Long idViejo,
                             String nuevoNombre,
                             String nuevaMarca,
                             Integer nuevoCosto,
                             Integer nuevaCantidadDisponible);
    List<Producto> findFaltaStock();
}
