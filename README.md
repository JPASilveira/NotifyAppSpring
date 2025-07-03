# NotifyApp - Abstract Factory + DAO Factory com Spring Boot

Este projeto foi desenvolvido como parte da disciplina de **Projeto de Software** no curso de Sistemas de Informação do **IFRS - Campus Vacaria**.

## 🎯 Objetivo do Projeto

Implementar uma arquitetura modular com os padrões **Abstract Factory** e **DAO Factory**, utilizando **Spring Boot** para demonstrar o uso de injeção de dependência, perfis de configuração e desacoplamento da lógica de persistência e envio de mensagens.

## 🏗️ Tecnologias Utilizadas

- **Java 17+**
- **Spring Boot**
- **H2 e SQLite**
- **Thymeleaf, HTML, JS**

## 🧱 Estrutura do Projeto

- `application/` – Serviços de negócio.
- `config/` – Beans e configuração via `@ConditionalOnProperty`.
- `domain/` – Interfaces, entidades e fábricas abstratas.
- `infrastructure/` – Implementações concretas por canal e banco.
- `presentation/` – Controllers REST e formulários web.

## 🧪 Padrões Aplicados

### 📦 Abstract Factory
Gerencia os componentes de envio:
- `NotifyFactory` → cria `MessageFormatter` e `MessageSender`.
- Fábricas concretas: `EmailNotifyFactory`, `WhatsAppNotifyFactory`.

### 🗃️ DAO Factory
Gerencia os repositórios de persistência:
- `RepositoryFactory` → cria `NotifyLogRepository`.
- Fábricas concretas: `H2NotifyLogFactory`, `SQLiteNotifyLogFactory`.

## ⚙️ Configuração via `application.properties`

```properties
notify.type=email              # ou whatsapp
spring.profiles.active=h2      # ou sqlite
```

## 🔄 Fluxo de Execução

1. Cliente envia POST para `/notify`.
2. `NotifyService` usa a `NotifyFactory` para formatar e enviar a mensagem.
3. Usa a `RepositoryFactory` para registrar o envio no banco de dados selecionado.

## ✅ Benefícios do Projeto

- Modularidade e baixo acoplamento entre as camadas.
- Facilidade para extensão com novos canais ou bancos.
- Configuração totalmente baseada em propriedades.

## 👨‍🎓 Créditos

Projeto acadêmico desenvolvido por **João Pedro A. Silveira**  
Curso de Sistemas de Informação – **IFRS Campus Vacaria**  
Disciplina: **Projeto de Software** – 2025

## 📄 Licença

Este projeto é de uso livre e pode ser reutilizado para fins acadêmicos ou educacionais.
