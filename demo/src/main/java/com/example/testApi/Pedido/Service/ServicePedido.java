package com.example.testApi.Pedido.Service;

import com.example.testApi.Cliente.Dao.ClienteDAO;
import com.example.testApi.Pedido.Dao.PedidoDAO;
import com.example.testApi.Pedido.Model.Pedido;
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
        /*if (pedidoRepository.buscarPorNumeroControle(pedido.getNumeroControle()) != null) {
            throw new RuntimeException("Número de controle já cadastrado");
        }*/

        if (pedido.getDataCadastro() == null) {
            pedido.setDataCadastro(LocalDate.now());
        }

        if (pedido.getQuantidade() == 0) {
            pedido.setQuantidade(1);
        }

        BigDecimal valorTotal = pedido.getValor().multiply(BigDecimal.valueOf(pedido.getQuantidade()));
        if (pedido.getQuantidade() > 5 && pedido.getQuantidade() < 10) {
            valorTotal = valorTotal.multiply(BigDecimal.valueOf(0.95));
        } else if (pedido.getQuantidade() >= 10) {
            valorTotal = valorTotal.multiply(BigDecimal.valueOf(0.90));
        }

        pedido.setValorTotal(valorTotal);

        if (pedidoRepository.existeNumeroControle(pedido.getNumeroControle())) {
            throw new RuntimeException("Número de controle já cadastrado");
        }

        if (!clienteRepository.existeCliente(pedido.getCodigoCliente())) {
            throw new RuntimeException("Id do cliente é inválido");
        }

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
}
