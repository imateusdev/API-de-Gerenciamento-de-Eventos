# 🎉 API de Gerenciamento de Eventos

[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.3.5-brightgreen.svg)](https://spring.io/projects/spring-boot)
[![Java](https://img.shields.io/badge/Java-17-orange.svg)](https://www.oracle.com/java/)
[![PostgreSQL](https://img.shields.io/badge/PostgreSQL-Latest-blue.svg)](https://www.postgresql.org/)
[![License](https://img.shields.io/badge/License-MIT-red.svg)](LICENSE)

## 📋 Sobre o Projeto

API REST para gerenciamento de eventos desenvolvida com Spring Boot. Permite criar, listar, atualizar e deletar eventos, além de gerenciar usuários e suas participações.

## 🚀 Tecnologias Utilizadas

* Spring Boot 3.3.5
* Java 17
* PostgreSQL
* Spring Data JPA
* Swagger/OpenAPI
* Lombok
* Maven

## 💻 Pré-requisitos

* Java 17
* Maven
* PostgreSQL

## 🔧 Instalação e Execução

1. Clone o repositório:
```bash
git clone https://github.com/imateusdev/API-de-Gerenciamento-de-Eventos

2.Configure as variáveis de ambiente no arquivo .env:
DB_URL=sua_url_do_banco
DB_USERNAME=seu_usuario
DB_PASSWORD=sua_senha

3.Execute o projeto
mvn spring-boot:run
```
## 📚 Documentação da API

Acesse a documentação Swagger em: `http://localhost:8080/swagger-ui.html`

### Endpoints Principais

#### Eventos
* `POST /api/events` - Criar evento
* `GET /api/events` - Listar eventos
* `GET /api/events/{id}` - Buscar evento por ID
* `PUT /api/events/{id}` - Atualizar evento
* `DELETE /api/events/{id}` - Deletar evento

#### Usuários
* `POST /api/users` - Criar usuário
* `GET /api/users` - Listar usuários


## 📝 Licença

Este projeto está sob a licença MIT. Veja o arquivo LICENSE para mais detalhes.

## 👨‍💻 Autor

Mateus Anacleto - [GitHub](https://github.com/imateusdev)


