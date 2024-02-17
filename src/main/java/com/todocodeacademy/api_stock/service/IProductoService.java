package com.todocodeacademy.api_stock.service;

import com.todocodeacademy.api_stock.model.Producto;
import java.util.List;

public interface IProductoService {
    public void saveProducto(Producto producto);
    public void deleteProducto(Long id);
    public List<Producto>  getProductos();
    public Producto findProducto(Long id);
    public void editProducto(Long idViejo,
                             String nuevoNombre,
                             String nuevaMarca,
                             Integer nuevoCosto,
                             Integer nuevaCantidadDisponible);
}
