package com.example.testApi.Controller;

import com.example.testApi.Model.Cliente;
import com.example.testApi.Service.ServiceCliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
