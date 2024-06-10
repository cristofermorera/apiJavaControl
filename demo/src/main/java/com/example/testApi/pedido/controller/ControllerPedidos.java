package com.example.testApi.pedido.controller;

import com.example.testApi.pedido.model.Pedido;
import com.example.testApi.pedido.service.ServicePedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
public class ControllerPedidos {
    @Autowired
    private ServicePedido pedidoService;


    @PostMapping
    public ResponseEntity<?> criarPedido(@RequestBody Pedido pedido) {
        try {
            Pedido novoPedido = pedidoService.criarPedido(pedido);
            return new ResponseEntity<>(novoPedido, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public List<Pedido> listarPedidos() {
        return pedidoService.listarPedidos();
    }

    @GetMapping("/numero_controle/{numeroControle}")
    public ResponseEntity<Pedido> buscarPedidoPorNumeroControle(@PathVariable String numeroControle) {
        Pedido pedido = pedidoService.buscarPedidoPorNumeroControle(numeroControle);
        return new ResponseEntity<>(pedido, HttpStatus.OK);
    }

    @GetMapping("/codigo_cliente/{idCliente}")
    public ResponseEntity<List<Pedido>> buscarPedidoPorIdCliente(@PathVariable String idCliente) {
        List<Pedido> pedido = pedidoService.buscarPedidoPorIdCliente(idCliente);
        return new ResponseEntity<>(pedido, HttpStatus.OK);
    }

    @GetMapping("/data_cadastro/{dataCadastro}")
    public ResponseEntity<List<Pedido>> buscarPedidoPorDataCadastro(@PathVariable String dataCadastro) {
        List<Pedido> pedido = pedidoService.buscarPedidoPorDataCadastro(dataCadastro);
        return new ResponseEntity<>(pedido, HttpStatus.OK);
    }
}
