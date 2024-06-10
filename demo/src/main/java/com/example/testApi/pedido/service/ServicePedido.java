package com.example.testApi.pedido.service;

import com.example.testApi.cliente.dao.ClienteDAO;
import com.example.testApi.pedido.dao.PedidoDAO;
import com.example.testApi.pedido.model.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public class ServicePedido {

    @Autowired
    private PedidoDAO pedidoRepository;

    @Autowired
    private ClienteDAO clienteRepository;

    @Transactional
    public Pedido criarPedido(Pedido pedido) {
        validacao(pedido);
        pedidoRepository.salvarPedido(pedido);
        return pedido;
    }

    public List<Pedido> listarPedidos() {
        return pedidoRepository.listarPedidos();
    }

    public Pedido buscarPedidoPorNumeroControle(String numeroControle) {
        return pedidoRepository.buscarPorNumeroControle(numeroControle);
    }

    public Pedido buscarPedidoPorIdCliente(String idCliente) {
        return pedidoRepository.buscarPorIdCliente(idCliente);
    }
    public Pedido validacao(Pedido pedido){
        if (pedidoRepository.existeNumeroControle(pedido.getNumeroControle())) {
            throw new RuntimeException("Número de controle já cadastrado");
        }

        if (!clienteRepository.existeCliente(pedido.getCodigoCliente())) {
            throw new RuntimeException("Id do cliente é inválido");
        }
        validacaoData(pedido);
        return pedido;
    }

    public Pedido validacaoData(Pedido pedido){
        if (pedido.getDataCadastro() == null) {
            pedido.setDataCadastro(LocalDate.now());
        }
        validacaoQuantidade(pedido);
        return pedido;
    }

    public Pedido validacaoQuantidade(Pedido pedido){
        if (pedido.getQuantidade() == 0) {
            pedido.setQuantidade(1);
        }
        validacaoTotal(pedido);
        return pedido;
    }

    public Pedido validacaoTotal(Pedido pedido){
        BigDecimal valorTotal = pedido.getValor().multiply(BigDecimal.valueOf(pedido.getQuantidade()));
        if (pedido.getQuantidade() > 5 && pedido.getQuantidade() < 10) {
            valorTotal = valorTotal.multiply(BigDecimal.valueOf(0.95));
        } else if (pedido.getQuantidade() >= 10) {
            valorTotal = valorTotal.multiply(BigDecimal.valueOf(0.90));
        }
        return pedido;
    }
}
