package com.example.testApi.Service;

import com.example.testApi.Dao.ClienteDAO;
import com.example.testApi.Model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ServiceCliente {

    @Autowired
    private ClienteDAO clienteRepository;

    public List<Cliente> listarCliente() {
        return clienteRepository.listarTodosCliente();
    }
}
