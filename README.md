# Food Express API
### EN-US:
An RESTful API made in Java, for a food delivery app.

This is an API made in Java for a food delivery app: customers, stores and orders. (When you create a store, you have a list called menu, where you can
register all the items that you sell) <br>

It has an authentication method used with Spring Security, where the user needs to
register and then login to generate a JWT code that will track all user requests in the API. All functions use DTO on data input and output.
<br><br>
**All passwords are encrypted when they are registered in the database.** <br><br>
This API uses PostgreSQL as its database.
## API Functions:
### Customers:
- List Customers - `/customer`
- Insert customer - `/customer`
- Find customer by id- `/customer/{id}`
- Update customer - `/customer/{id}`
- Delete customer - `/customer/{id}`

### Stores:
- List stores - `/store`
- Find store by id- `/store/{id}`
- Insert store - `/store`
- Update store - `/store/{id}`
- Delete store - `/store/{id}`

### Orders:

- Find order by id - `/order/{id}`
- Insert order - `/order` <br>

  ```
      {
       "email": "example@example.com",
       "storeId": 4,
       "list": [
        {
         "name": "Product 1",
         "price": 10.0
        },
        {
         "name": "Product 2",
         "price": 20.0
        }
       ]
      }
- Pay order - `/pay/{id}`

### Authentication:
- Sign up (username and password) - `/auth/new`
- Sign in - `/auth`

## Technologies used:

- Java
- Spring Boot
- Spring Security
- PostgreSQL
- Flyway Migrations
- Tomcat
- Maven
- Insomnia
- Spring Doc (Open API - Swagger)
- Auth0 (JWT Tokens generator)
- BCrypt Password Encoder

## Documentation
Clone or download the application, upgrade the application.properties with your database link (it must be
a MongoDB database) then
run it, after that consult the documentation with all the methods in the link bellow:
<br>http://localhost:8080/swagger-ui.html

## Author

#### Allas Assis de Oliveira
https://www.linkedin.com/in/allasassis

--------------------------------------------------------
# API Food Express
### PT-BR:

Uma API RESTful feita em Java para um aplicativo de delivery de comida.

Esta é uma API feita em Java para um aplicativo de delivery de comida: clientes, lojas e pedidos.
(Quando você cria uma loja, você tem uma lista chamada menu, onde pode registrar todos os itens que vende.)

Possui um método de autenticação utilizado com Spring Security, onde o usuário precisa
registrar-se e fazer o login para gerar um código JWT que acompanhará todas as solicitações do usuário na API. Todas as funções usam DTO na entrada e saída de dados.
<br><br>
**Todas as senhas são criptografadas quando são cadastradas no banco de dados.** <br><br>
Essa API utiliza o MongoDB como banco de dados e possui testes unitários com JUnit 5.
## Funções da API:
### Clientes:
- Listar clientes - `/customer`
- Inserir cliente - `/customer`
- Achar cliente pelo id- `/customer/{id}`
- Atualizar cliente - `/customer/{id}`
- Deletar cliente - `/customer/{id}`

### Lojas:
- Listar lojas - `/store`
- Achar loja pelo id- `/store/{id}`
- Inserir loja - `/store`
- Atualizar loja - `/store/{id}`
- Deletar loja - `/store/{id}`

### Pedidos:
- Achar pedido pelo id - `/order/{id}`
- Inserir pedido - `/order`<br>

   ```
      {
       "email": "exemplo@exemplo.com",
       "storeId": 4,
       "list": [
        {
         "name": "Produto 1",
         "price": 10.0
        },
        {
         "name": "Produto 2",
         "price": 20.0
        }
       ]
      }
- Pagar pedido - `/pay/{id}`

### Autenticação:
- Registrar (usuário e senha) - `/auth/new`
- Fazer login - `/auth`

## Tecnologias usadas:

- Java
- Spring Boot
- Spring Security
- PostgreSQL
- Flyway Migrations
- Tomcat
- Maven
- Insomnia
- Spring Doc (Open API - Swagger)
- Auth0 (Gerador de tokens JWT)
- BCrypt Password Encoder

## Documentação
Clone ou baixe a aplicação, atualize o application.properties com o link do seu banco de dados (tem que ser
um banco de dados MongoDB), após
isso execute o programa e consulte a documentação com todos os métodos no link abaixo:
<br>http://localhost:8080/swagger-ui.html

## Autor

#### Allas Assis de Oliveira
https://www.linkedin.com/in/allasassis


