# API de Agendamento de Consultas

## Introdução

Esta API foi desenvolvida para médicos e pacientes, com o objetivo de permitir o cadastro de médicos e pacientes, além de facilitar o agendamento de consultas entre eles. Foi construída com **Spring Boot** e utiliza o **PostgreSQL** como banco de dados. O projeto é parte de um estudo para testar meus conhecimentos em desenvolvimento de APIs RESTful.

## Funcionalidades

- Cadastro de médicos
- Cadastro de pacientes
- Agendamento de consultas
- Listagem de consultas

## Tecnologias Utilizadas

- **Java 17**
- 
- **Spring Boot**
- **PostgreSQL**
- **Maven**
- **JPA/Hibernate**

## Configurações de Banco de Dados

A aplicação utiliza o banco de dados **PostgreSQL**. Para configurar o banco de dados, você pode alterar as propriedades no arquivo `application.properties` ou `application.yml`.

Exemplo de configuração no `application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost/agendamento_consultas
spring.datasource.username=postgres


