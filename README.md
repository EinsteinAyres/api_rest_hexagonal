
# 📦 API RESTful Genérica com Arquitetura Hexagonal (Estudo)

Este projeto é um estudo de implementação de uma API RESTful em Java utilizando **Arquitetura Hexagonal (Ports and Adapters)**. O objetivo é aplicar boas práticas de design, organização de código e separação de responsabilidades.

---

## 📚 Tecnologias Utilizadas

- Java 17+
- Spring Boot
- Maven
- JPA / Hibernate
- PostgreSQL
- Lombok
- Spring Validation
- MapStruct
- JUnit 5

---

## 🧱 Estrutura da Arquitetura Hexagonal

```
src
├── domain            # Núcleo da aplicação: entidades, regras de negócio, interfaces (ports)
├── application       # Casos de uso e orquestração da lógica de negócio
├── adapters
│   ├── inbound       # Entradas: Controllers REST
│   └── outbound      # Saídas: Repositórios, Gateways externos
└── config            # Configurações de Spring, Beans, Mappers
```

---

## ✅ Boas Práticas Adotadas

### 📐 Arquitetura e Design

- Separação clara entre **camadas de domínio, aplicação e infraestrutura**
- Utilização de **interfaces (ports)** para desacoplamento entre camadas
- Uso de **DTOs** para transporte de dados entre camadas
- Controle de versão da API via versionamento de endpoints (`/api/v1`)

### 📦 Organização do Projeto

- Padrão de nomenclatura consistente
- Pacotes coesos por responsabilidade (não misturar camadas)
- Controllers finos, delegando lógica para **casos de uso (use cases)**

### 🔒 Segurança e Validação

- Validação de entrada com anotações (`@Valid`, `@NotNull`, etc)
- Tratamento global de exceções com `@ControllerAdvice`
- Respostas padronizadas com códigos HTTP apropriados

### 🧪 Testabilidade

- Código desacoplado e orientado a interfaces
- Casos de uso e regras de negócio testáveis isoladamente
- Testes de unidade e integração usando `@SpringBootTest`

### 🚀 Performance e Manutenibilidade

- Uso de Lombok para reduzir boilerplate
- Optional: MapStruct para mapeamento eficiente entre DTOs e modelos
- Beans e mapeamentos organizados em classes de configuração

### 🧩 Extensibilidade

- Adaptadores externos fáceis de trocar ou adicionar
- Integrações com outros sistemas feitas via interfaces (`outbound ports`)

---

## ▶️ Como Rodar o Projeto

```bash
git clone https://github.com/seu-usuario/sua-api.git
cd sua-api
./mvnw spring-boot:run
```

Acesse: [http://localhost:8080/api/v1](http://localhost:8080/api/v1)

---

## 📘 Referências

- [Documentação oficial Spring Boot](https://spring.io/projects/spring-boot)
- [Arquitetura Hexagonal - Alistair Cockburn](https://alistair.cockburn.us/hexagonal-architecture/)
- [Clean Architecture - Uncle Bob](https://8thlight.com/blog/uncle-bob/2012/08/13/the-clean-architecture.html)

---

## 🧠 Observações Finais

Este projeto é um estudo e base para aplicações reais que buscam alta coesão, baixo acoplamento e facilidade de manutenção e evolução.

Sinta-se à vontade para usar como base e aprimorar conforme necessário!
