package com.todocodeacademy.api_stock.controller;

import com.todocodeacademy.api_stock.dto.MontoCantidadVentaDTO;
import com.todocodeacademy.api_stock.dto.ProductoDTO;
import com.todocodeacademy.api_stock.model.Venta;
import com.todocodeacademy.api_stock.service.IVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class VentaController {
    @Autowired
    private IVentaService ventaService;

    @PostMapping("/ventas/crear")
    public String saveVenta(@RequestBody Venta venta){
        if(ventaService.saveVenta(venta) == Boolean.FALSE)
            return "Error en venta";
        return "Venta generada";
    }

    @GetMapping("/ventas")
    public List<Venta> getVentas(){
        return ventaService.getVentas();
    }

    @GetMapping("/ventas/{codigo_venta}")
    public Venta findVenta(@PathVariable Long codigo_venta){
        return ventaService.findVenta(codigo_venta);
    }

    @DeleteMapping("/ventas/eliminar/{codigo_venta}")
    public String deleteVenta(@PathVariable Long codigo_venta){
        if (this.findVenta(codigo_venta) == null)
            return "Cuenta no existe";
        ventaService.deleteVenta(codigo_venta);
        return "Cuenta eliminada";
    }

    @PutMapping("/ventas/editar/{codigo_venta}")
    public String editVenta(@PathVariable Long codigo_venta,
                          @RequestParam(required = false, name = "fecha_venta")LocalDate nuevaFecha,
                          @RequestParam(required = false, name = "id_cliente_venta") Long nuevoCliente) {
        ventaService.editVenta(codigo_venta, nuevaFecha, nuevoCliente);
        return "Venta modifica correctamente";
    }

    @GetMapping("/ventas/productos/{codigo_venta}")
    public List<ProductoDTO> findProductosByCodigoVenta(@PathVariable Long codigo_venta){
        return ventaService.findProductosByCodigoVenta(codigo_venta);
    }

    @GetMapping("/ventas/fecha/{fecha_venta}")
    public MontoCantidadVentaDTO findMontoCantidadVenta(@PathVariable("fecha_venta") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fecha_venta){
        return ventaService.findMontoContidadVento(fecha_venta);
    }
}
