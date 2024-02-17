package com.todocodeacademy.api_stock.service;

import com.todocodeacademy.api_stock.model.Cliente;
import com.todocodeacademy.api_stock.repository.IClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService implements IClienteService{
    @Autowired
    private IClienteRepository clienteRepository;

    @Override
    public void saveCliente(Cliente cliente) {
        clienteRepository.save(cliente);
    }

    @Override
    public void deleteCliente(Long id) {
        clienteRepository.deleteById(id);
    }

    @Override
    public List<Cliente> getClientes() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente findCliente(Long id) {
        return clienteRepository.findById(id).orElse(null);
    }

    @Override
    public void editCliente(Long id, String nuevoNombre, String nuevoApellido, String nuevoDni) {
        Cliente cliente = this.findCliente(id);
        cliente.setNombre(nuevoNombre != null ? nuevoNombre : cliente.getNombre());
        cliente.setApellido(nuevoApellido != null ? nuevoApellido : cliente.getApellido());
        cliente.setDni(nuevoDni != null ? nuevoDni : cliente.getDni());
        this.saveCliente(cliente);
    }
}
