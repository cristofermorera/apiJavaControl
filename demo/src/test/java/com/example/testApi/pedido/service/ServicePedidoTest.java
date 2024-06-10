package com.example.testApi.pedido.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.example.testApi.pedido.model.Pedido;
import com.example.testApi.pedido.dao.PedidoDAO;
import com.example.testApi.pedido.service.ServicePedido;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ServicePedidoTest {

    @Mock
    private PedidoDAO pedidoRepository;

    @InjectMocks
    private ServicePedido pedidoService;

    @BeforeEach
    public void setUp() {
        pedidoService = new ServicePedido();
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCriarPedido_Sucesso() {
        // Simula um pedido válido
        Pedido pedido = new Pedido();
        pedido.setNumeroControle("123456");
        pedido.setDataCadastro(LocalDate.now());
        pedido.setNome("Produto Teste");
        pedido.setValor(new BigDecimal("100.00"));
        pedido.setQuantidade(10);
        pedido.setCodigoCliente(1);

        // Simula o comportamento do repositório ao salvar o pedido
        when(pedidoRepository.salvarPedido(pedido)).thenReturn(pedido);
    }

    @Test(expected = RuntimeException.class)
    public void testCriarPedido_NumeroControleExistente() {
        // Simula um pedido com número de controle já existente
        Pedido pedido = new Pedido();
        pedido.setNumeroControle("123456"); // Número de controle já existe

        // Simula o comportamento do repositório ao encontrar um pedido com o mesmo número de controle
        when(pedidoRepository.buscarPorNumeroControle("123456")).thenReturn(pedido);

        // Chama o método de serviço para criar o pedido
        pedidoService.criarPedido(pedido); // Isso deve lançar uma exceção RuntimeException
    }
}

