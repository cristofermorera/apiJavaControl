package com.example.testApi.Pedido.Dao;


import com.example.testApi.Pedido.Model.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class PedidoDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Pedido salvarPedido(Pedido pedido) {
        String sql = "INSERT INTO pedido (numero_controle, data_cadastro, nome, valor, quantidade, codigo_cliente, valor_total) VALUES (?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, pedido.getNumeroControle(), pedido.getDataCadastro(), pedido.getNome(), pedido.getValor(), pedido.getQuantidade(), pedido.getCodigoCliente(), pedido.getValorTotal());
        return pedido;
    }

    public boolean existeNumeroControle(String numeroControle) {
        String sql = "SELECT COUNT(*) FROM pedido WHERE numero_controle = ?";
        Integer count = jdbcTemplate.queryForObject(sql, new Object[]{numeroControle}, Integer.class);
        return count != null && count > 0;
    }

    public List<Pedido> listarPedidos() {
        String sql = "SELECT * FROM pedido";
        return jdbcTemplate.query(sql, this::mapRowToPedido);
    }

    public Pedido buscarPorNumeroControle(String numeroControle) {
        String sql = "SELECT * FROM pedido WHERE numero_controle = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{numeroControle}, this::mapRowToPedido);
    }

    public Pedido buscarPorIdCliente(String idClient) {
        String sql = "SELECT * FROM pedido WHERE codigo_cliente = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{idClient}, this::mapRowToPedido);
    }

    private Pedido mapRowToPedido(ResultSet rs, int rowNum) throws SQLException {
        Pedido pedido = new Pedido();
        pedido.setNumeroControle(rs.getString("numero_controle"));
        pedido.setDataCadastro(rs.getDate("data_cadastro").toLocalDate());
        pedido.setNome(rs.getString("nome"));
        pedido.setValor(rs.getBigDecimal("valor"));
        pedido.setQuantidade(rs.getInt("quantidade"));
        pedido.setCodigoCliente(rs.getInt("codigo_cliente"));
        pedido.setValorTotal(rs.getBigDecimal("valor_total"));
        return pedido;
    }
}


