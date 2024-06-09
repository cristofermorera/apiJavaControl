package com.example.testApi.Controller;

import com.example.testApi.Model.Pedido;
import com.example.testApi.Service.ServicePedido;
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

    /*@PostMapping
    public ResponseEntity<Pedido> criarPedido(@RequestBody Pedido pedido) {
        Pedido novoPedido = pedidoService.criarPedido(pedido);
        return new ResponseEntity<>(novoPedido, HttpStatus.CREATED);
    }*/

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
    public ResponseEntity<Pedido> buscarPedidoPorIdCliente(@PathVariable String idCliente) {
        Pedido pedido = pedidoService.buscarPedidoPorIdCliente(idCliente);
        return new ResponseEntity<>(pedido, HttpStatus.OK);
    }
}
