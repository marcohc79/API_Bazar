package com.todocodeacademy.api_stock.service;

import com.todocodeacademy.api_stock.model.Cliente;
import com.todocodeacademy.api_stock.model.Producto;
import com.todocodeacademy.api_stock.model.Venta;
import com.todocodeacademy.api_stock.repository.IVentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class VentaService implements IVentaService{
    @Autowired
    private IVentaRepository ventaRepository;
    @Autowired
    private IProductoService productoService;
    @Autowired
    private IClienteService clienteService;

    @Override
    public Boolean saveVenta(Venta venta) {
        List<Producto> productos = venta.getLista_productos();
        Integer sumaTotal = 0;
        for (Producto producto : productos) {
            Producto productoActual = productoService.findProducto(producto.getCodigo_producto());
            if (productoActual.getCantidad_disponible() <= 0)
                return Boolean.FALSE;
            sumaTotal += productoActual.getCosto();
            productoActual.setCantidad_disponible(productoActual.getCantidad_disponible() - 1);
            productoService.saveProducto(productoActual);
        }
        venta.setTotal(sumaTotal);
        ventaRepository.save(venta);
        return Boolean.TRUE;
    }

    @Override
    public void deleteVenta(Long codigo_venta) {
        ventaRepository.deleteById(codigo_venta);
    }

    @Override
    public List<Venta> getVentas() {
        return ventaRepository.findAll();
    }

    @Override
    public Venta findVenta(Long codigo_venta) {
        return ventaRepository.findById(codigo_venta).orElse(null);
    }

    @Override
    public void editVenta(Long codigo_venta, LocalDate nuevaFecha, Long nuevoCliente) {
        Venta venta = this.findVenta(codigo_venta);
        venta.setFecha_venta(nuevaFecha != null ? nuevaFecha : venta.getFecha_venta());

        if (nuevoCliente != null){
            Cliente clienteNuvo = clienteService.findCliente(nuevoCliente);
            venta.setCliente(clienteNuvo);
        }

        this.saveVenta(venta);
    }
}
