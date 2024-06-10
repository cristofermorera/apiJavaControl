package com.example.testApi.pedido.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Pedido {
    private String numeroControle;
    private LocalDate dataCadastro;
    private String nome;
    private BigDecimal valor;
    private Integer quantidade;
    private int codigoCliente;
    private BigDecimal valorTotal;

    public String getNumeroControle() {
        return numeroControle;
    }

    public void setNumeroControle(String numeroControle) {
        this.numeroControle = numeroControle;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public int getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(int codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }
}
