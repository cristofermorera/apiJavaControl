package com.example.testApi.Cliente.Controller;

import com.example.testApi.Cliente.Model.Cliente;
import com.example.testApi.Cliente.Service.ServiceCliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/cliente")
public class ControllerCliente {
    @Autowired
    private ServiceCliente serviceCliente;

    @GetMapping
    public List<Cliente> listarCliente() {
        return serviceCliente.listarCliente();
    }
}
