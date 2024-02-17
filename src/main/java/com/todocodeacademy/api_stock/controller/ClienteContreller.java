package com.todocodeacademy.api_stock.controller;

import com.todocodeacademy.api_stock.model.Cliente;
import com.todocodeacademy.api_stock.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClienteContreller {
    @Autowired
    private IClienteService clienteService;

    @PostMapping("/clientes/crear")
    public String saveCliente(@RequestBody Cliente cliente){
        clienteService.saveCliente(cliente);
        return "Cliente creado";
    }
    @DeleteMapping("/clientes/eliminar/{id_cliente}")
    public String deleteCliente(@PathVariable Long id_cliente){
        clienteService.deleteCliente(id_cliente);
        return "Cliente eliminado";
    }
    @GetMapping("/clientes")
    public List<Cliente> getClientes(){
        return clienteService.getClientes();
    }
    @GetMapping("/clientes/{id_cliente}")
    public Cliente findCliente(@PathVariable Long id_cliente){
        return clienteService.findCliente(id_cliente);
    }
    @PutMapping("/clientes/editar/{id_cliente}")
    public String editCliente(@PathVariable Long id_cliente,
                              @RequestParam(required = false, name = "nombre") String nuevoNombre,
                              @RequestParam(required = false, name = "apellido") String nuevoApellido,
                              @RequestParam(required = false, name = "dni") String nuevoDni){
        if (clienteService.findCliente(id_cliente) == null)
            return "Cliente no encontrado";
        clienteService.editCliente(id_cliente, nuevoNombre, nuevoApellido, nuevoDni);
        return "Cliente editado";
    }
}
