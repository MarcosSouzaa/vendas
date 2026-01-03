# 🚗 Concessionária de Vendas - Backend

Sistema de gerenciamento de estoque e vendas para uma concessionária de veículos, focado em Carros e Caminhões. Este projeto aplica conceitos avançados de **Programação Orientada a Objetos (POO)** integrados ao ecossistema **Spring Boot**.

---

## 🛠️ Tecnologias Utilizadas

* **Java 21**: Linguagem base para o desenvolvimento.
* **Spring Boot 3**: Framework para construção da API e gerenciamento do projeto.
* **Spring Data JPA**: Abstração de persistência de dados.
* **H2 Database**: Banco de dados em memória para ambiente de desenvolvimento.
* **Lombok**: Biblioteca para redução de código boilerplate (Getters/Setters).
* **Maven**: Gerenciador de dependências e automação de build.

---

## 🏗️ Estrutura do Projeto

O projeto utiliza o padrão de camadas (**Layered Architecture**):

* **Model**: Representa as entidades do negócio (Veículo, Carro, Caminhão) com mapeamento de herança via JPA.
* **Repository**: Interfaces para comunicação com o banco de dados.
* **Service**: Camada de lógica de negócios (processamento de vendas, descontos e validações).
* **Controller**: Endpoints da API para integração com o Frontend.

---

## 🚀 Como Executar o Projeto

Siga os passos abaixo para configurar o ambiente e rodar a aplicação localmente:

1.  **Clone o repositório:**
    [`git clone https://github.com/MarcosSouzaa/vendas`](https://github.com/MarcosSouzaa/vendas)

2.  **Entre no diretório do projeto:**
    ```bash
    cd vendas
    ```

3.  **Instale as dependências e compile o projeto:**
    ```bash
    ./mvnw clean install
    ```

4.  **Execute a aplicação:**
    ```bash
    ./mvnw spring-boot:run
    ```

A aplicação estará disponível em `http://localhost:8080`.

---

## 🔗 Endpoints e Banco de Dados

### 🗄️ Acesso ao Banco de Dados (H2)
Como o projeto utiliza o banco de dados H2 em memória, você pode acessar o console para visualizar as tabelas em tempo real:
* **URL:** `http://localhost:8080/h2-console`
* **JDBC URL:** `jdbc:h2:mem:testdb`
* **User:** `sa`
* **Password:** (em branco)

### 🛣️ Principais Endpoints (Exemplos)
* `GET /api/veiculos` - Lista todos os veículos.
* `POST /api/vendas` - Registra uma nova venda.

---

## 📝 Autor

Desenvolvido por **Marcos Souza** - [GitHub](https://github.com/MarcosSouzaa)
