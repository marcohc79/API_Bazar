package com.todocodeacademy.api_stock.service;

import com.todocodeacademy.api_stock.model.Cliente;
import java.util.List;

public interface IClienteService {
    void saveCliente(Cliente cliente);
    void deleteCliente(Long id);
    List<Cliente> getClientes();
    Cliente findCliente(Long id);
    void editCliente(Long id,
                            String nuevoNombre,
                            String nuevoApellido,
                            String nuevoDni);
}
