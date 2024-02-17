package com.todocodeacademy.api_stock.controller;

import com.todocodeacademy.api_stock.model.Producto;
import com.todocodeacademy.api_stock.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductoController {
    @Autowired
    private IProductoService productoService;

    @PostMapping("/productos/crear")
    public String saveProducto(@RequestBody Producto producto) {
        productoService.saveProducto(producto);
        return "Producto creado";
    }
    @GetMapping("/productos")
    public List<Producto> getProductos(){
        return productoService.getProductos();
    }
    @GetMapping("/productos/{codigo_producto}")
    public Producto findProducto(@PathVariable Long codigo_producto){
        return productoService.findProducto(codigo_producto);
    }
    @DeleteMapping("/productos/eliminar/{codigo_producto}")
    public String deleteProducto(@PathVariable Long codigo_producto){
        productoService.deleteProducto(codigo_producto);
        return "Producto eliminado";
    }
    @PutMapping("/productos/editar/{codigo_producto}")
    public String editProducto(@PathVariable Long codigo_producto,
                               @RequestParam(required = false, name = "nombre") String nuevoNombre,
                               @RequestParam(required = false, name = "marca") String nuevaMarca,
                               @RequestParam(required = false, name = "costo") Integer nuevoCosto,
                               @RequestParam(required = false, name = "cantidad_disponible") Integer nuevaCantidad){

        if (productoService.findProducto(codigo_producto) == null)
            return "Producto no encontrado";

        productoService.editProducto(codigo_producto, nuevoNombre, nuevaMarca, nuevoCosto, nuevaCantidad);
        return "Se modifico correctamente";
    }
}
