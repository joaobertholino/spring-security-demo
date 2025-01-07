# Spring Security Demo

Este projeto é uma aplicação de demonstração que integra o Spring Security para fornecer autenticação e autorização em uma API REST Spring Boot.

## Funcionalidades

- **Registro de um novo Usuários**: Permite o registro de novo usuarios, feito apenas por um usuario com permição de ADMIN.
- **Autenticação de Usuários**: Permite que os usuários já registrados façam login com credenciais válidas.
- **Autorização baseada em permições**: Restringe o acesso a determinadas partes da aplicação com base nas permições dos usuários.
- **Registro de um novo Produto**: Permite o registro de um novo produto, sendo realizado apenas por usuarios com permição de ADMIN.
	-- **Recupera um protodo da base de dados**: Permite que usuarios com quaisquer permições recuperem um produto especifico da base de dados.

## Tecnologias Utilizadas

- **Java 21**: Linguagem de programação principal.
- **Spring Boot 3.4.1**: Framework para criação de aplicações Java.
- **Spring Security 6.4.2**: Módulo de segurança para autenticação e autorização de usuários.
- **JWT - JSON Web Token**: Utilizado para autenticação de usuários por meio de um token criptografado, utilizado posteriormente em novas requisições do mesmo usuário.
- **Maven 3.9.9**: Gerenciador de dependências e build.
- **Docker e Docker Compose**: Para containerização da aplicação e automatização dos containers.

## Como Executar

- **Clone o repositório**:

	 ```bash
	 git clone git@github.com:joaobertholino/spring-security-demo.git
 	```

- **Entre no diretorio do projeto**:

	 ```bash
	 cd ./spring-security-demo
 	```

- **Execute o Compose no diretorio raiz**:

	 ```bash
	 docker-compose up -d
 	```

- **Faça login com o Usuário ADMIN pré-existente na base de dados**:

	 ```cURL
	 curl --silent --location 'http://localhost:8080/auth/user' --header 'Content-Type: application/json' --data '{"username": "JoaoB", "password": "12345"}'
 	```
 
- Ao realizar a etapa de login, sera retornado no corpo da resposta, o token necessario para realizar as proximas requisições.
