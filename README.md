# Pedido API

Esta é uma API para recepção e consulta de pedidos de clientes. A API suporta recebimento de pedidos em formato JSON e XML e é desenvolvida utilizando Spring Boot com o JDBC Template para interação com um banco de dados MySQL.

## Funcionalidades

- Receber pedidos no formato XML e JSON.
- Validar se o número de controle já existe.
- Calcular descontos baseados na quantidade.
- Consultar pedidos por número de controle e data de cadastro.
- Listar todos os pedidos.

## Tecnologias Utilizadas

- Java 1.8 ou versão mais recente
- Spring Boot
- JDBC Template
- MySQL
- H2 Database (para testes)
- JUnit (para testes unitários)

## Configuração do Ambiente

### Pré-requisitos

- JDK 1.8 ou versão mais recente
- Maven
- MySQL

### Configuração do Banco de Dados

Crie um banco de dados MySQL e execute o script SQL fornecido para criar as tabelas necessárias:

```sql
CREATE DATABASE pedido_db;

USE pedido_db;

CREATE TABLE pedido (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    numero_controle VARCHAR(255) UNIQUE NOT NULL,
    data_cadastro DATE,
    nome VARCHAR(255) NOT NULL,
    valor DECIMAL(10, 2) NOT NULL,
    quantidade INT DEFAULT 1,
    codigo_cliente INT NOT NULL,
    valor_total DECIMAL(10, 2) NOT NULL
);
