package com.example.testApi.Cliente.Dao;


import com.example.testApi.Cliente.Model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ClienteDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public boolean existeCliente(int codigoCliente) {
        String sql = "SELECT COUNT(*) FROM cliente WHERE codigo_cliente = ?";
        Integer count = jdbcTemplate.queryForObject(sql, new Object[]{codigoCliente}, Integer.class);
        return count != null && count > 0;
    }

    public List<Cliente> listarTodosCliente() {
        String sql = "SELECT * FROM cliente";
        return jdbcTemplate.query(sql, this::mapRowToCliente);
    }

    private Cliente mapRowToCliente(ResultSet rs, int rowNum) throws SQLException {
        Cliente cliente = new Cliente();
        cliente.setId((long) rs.getInt("codigo_cliente"));
        return cliente;
    }
}
