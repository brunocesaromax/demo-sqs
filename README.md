# Simulador SQS com Spring Boot

Este projeto demonstra como simular o Amazon Simple Queue Service (SQS) usando Spring Boot e LocalStack. Ele fornece um ambiente de desenvolvimento local para testar aplicações baseadas em SQS sem precisar se conectar aos serviços reais da AWS.

## Índice

- [Pré-requisitos](#pré-requisitos)
- [Estrutura do Projeto](#estrutura-do-projeto)
- [Configuração](#configuração)
- [Executando a Aplicação](#executando-a-aplicação)
- [Como Funciona](#como-funciona)
- [Configurações](#configurações)
- [Testes](#testes)
- [Contribuindo](#contribuindo)
- [Licença](#licença)

## Pré-requisitos

- Java 21
- Maven
- Docker (para executar o LocalStack)

## Estrutura do Projeto

```
.
├── src/main/java/com/bcdev/sqs
│   ├── config
│   │   └── SqsConfig.java
│   ├── consumer
│   │   ├── Consumer.java
│   │   └── QueueMessage.java
│   └── SqsApplication.java
├── pom.xml
└── README.md
```

## Configuração

1. Clone o repositório:
   ```
   git clone https://github.com/seuusuario/simulador-sqs-spring-boot.git
   cd simulador-sqs-spring-boot
   ```

2. Instale as dependências:
   ```
   mvn clean install
   ```

3. Inicie o LocalStack:
   ```
   docker run --rm -it -p 4566:4566 -p 4571:4571 localstack/localstack
   ```

## Executando a Aplicação

Execute a aplicação Spring Boot:

```
mvn spring-boot:run
```

A aplicação iniciará, conectará ao serviço SQS do LocalStack e enviará uma mensagem de teste para a fila.

## Como Funciona

1. `SqsApplication.java`: A classe principal da aplicação Spring Boot. Implementa `CommandLineRunner` para enviar uma mensagem de teste para a fila SQS na inicialização.

2. `SqsConfig.java`: Configura o `SqsAsyncClient` para se conectar ao LocalStack ao invés dos serviços reais da AWS.

3. `Consumer.java`: Contém um listener SQS que processa mensagens da fila.

4. `QueueMessage.java`: Uma classe record simples que representa a estrutura das mensagens na fila.

## Configurações

O projeto usa as seguintes configurações:

- Endpoint do LocalStack: `http://localhost:4566`
- Região: `SA_EAST_1` (configurável em `SqsConfig.java`)
- URL da fila: `https://localhost.localstack.cloud:4566/000000000000/queue-test`

Você pode modificar essas configurações nos respectivos arquivos Java ou externalizá-las para um arquivo de propriedades para facilitar a configuração.

## Testes

Para testar a aplicação:

1. Certifique-se de que o LocalStack esteja em execução.
2. Inicie a aplicação Spring Boot.
3. A aplicação enviará automaticamente uma mensagem de teste para a fila na inicialização.
4. O consumidor registrará a mensagem recebida no console.

Você pode adicionar testes mais abrangentes usando o framework de testes do Spring Boot.

## Contribuindo

Contribuições são bem-vindas! Sinta-se à vontade para enviar um Pull Request.

## Licença

Este projeto é de código aberto sob a [Licença MIT](https://opensource.org/licenses/MIT).
