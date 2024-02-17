package com.todocodeacademy.api_stock.service;

import com.todocodeacademy.api_stock.model.Cliente;
import java.util.List;

public interface IClienteService {
    public void saveCliente(Cliente cliente);
    public void deleteCliente(Long id);
    public List<Cliente> getClientes();
    public Cliente findCliente(Long id);
    public void editCliente(Long id,
                            String nuevoNombre,
                            String nuevoApellido,
                            String nuevoDni);
}
