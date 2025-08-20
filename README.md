---

# Challenge Backend Developer - Cotações Financeiras

## Descrição

Este projeto consiste em uma **aplicação backend em Java (Spring Boot)** que consome a [AwesomeAPI de moedas](https://docs.awesomeapi.com.br/api-de-moedas) e fornece dados financeiros atualizados por meio de endpoints REST. O projeto inclui suporte para execução em **Docker**.

O objetivo é fornecer cotações de moedas e histórico de valores, que podem ser consumidos por qualquer front-end, incluindo widgets HTML.

---

## Tecnologias Utilizadas

* Java 17+
* Spring Boot
* Spring Web
* Feign Client (Spring Cloud OpenFeign)
* Lombok
* ModelMapper
* Docker & Docker Compose
* H2 (opcional, para testes locais)
* JUnit 5 + MockMvc (testes unitários)

---

## Estrutura do Projeto

* `Controller`: Contém os endpoints REST que disponibilizam as cotações.
* `Client`: Implementa o Feign Client que consome a AwesomeAPI.
* `Model`: Classes de modelo (`Conversor`, `TaxaCambio`).
* `Controller/Dto`: DTOs usados para respostas dos endpoints.

---

## Endpoints Disponíveis

Todos os endpoints estão prefixados com `/consuma`.

1. **Cotação atual de uma moeda**

```
GET /consuma/atual/{moedas}
```

* Exemplo: `/consuma/atual/USD`
* Retorna um `TaxaCambioResponseDto` com os valores atuais das moedas.

2. **Fechamento dos últimos dias de uma moeda**

```
GET /consuma/moeda/recente/{moeda}/{numero_dias}
```

* Exemplo: `/consuma/moeda/recente/USD/5`
* Retorna lista de `ConversorResponseDto` com histórico diário.

3. **Cotações sequenciais de uma única moeda**

```
GET /consuma/cotacao/sequencial/{moeda}/{quantidade}
```

* Exemplo: `/consuma/cotacao/sequencial/USD/10`
* Retorna lista de cotações sequenciais.

4. **Cotações sequenciais de 1 minuto (intervalo de 1 minuto)**

```
GET /consuma/cotacao/sequencial1minuto/{moeda}/{quantidade}
```

* Exemplo: `/consuma/cotacao/sequencial1minuto/USD/10`
* Retorna cotações com intervalo de 1 minuto.

5. **Fechamento de período específico**

```
GET /consuma/moeda/periodo/especifico/{moeda}/{numero_dias}
```

* Exemplo: `/consuma/moeda/periodo/especifico/USD/7`
* Retorna lista de cotações para o período informado.

---

## Como Rodar o Projeto

### Pré-requisitos

* Java 17 ou superior
* Maven 3.8+
* Docker & Docker Compose

### Passos

1. **Build do projeto**

```bash
mvn clean package
```

2. **Rodar via Docker**

* Certifique-se de que o `Dockerfile` e o `docker-compose.yml` estão na raiz do projeto.

```bash
docker-compose build
docker-compose up
```

3. O backend estará disponível em:

```
http://localhost:8080
```

---

## Testes

* Os testes unitários usam **MockMvc** para simular chamadas aos endpoints.
* Para rodar os testes:

```bash
mvn test
```

---

## Observações

* O front-end fornecido (HTML) não foi integrado; o projeto entrega o backend completamente funcional.
* As respostas das requisições são em **JSON**, podendo ser consumidas por qualquer front-end.
* Segue os princípios de **Clean Code** e estrutura modular para fácil manutenção e escalabilidade.

---
