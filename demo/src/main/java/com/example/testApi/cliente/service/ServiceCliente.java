package com.example.testApi.cliente.service;

import com.example.testApi.cliente.dao.ClienteDAO;
import com.example.testApi.cliente.model.Cliente;
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
