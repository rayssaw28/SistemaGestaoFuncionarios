# Sistema de Gestão de Funcionários

---
    Feito por: Rayssa Rodrigues Alves
    Kauã Oliveira de Honorato
---

Aplicação completa desenvolvida com **Spring Boot 3 (Backend)** e **Angular 21 (Frontend)** para gerenciar o cadastro, listagem, atualização e inativação de funcionários.  
O sistema utiliza banco **H2** para persistência local e documentação automática via **Swagger UI**.

---

## Passos para Execução:

1. Clonar o Repositório
2. Entrar na pasta do backend
3. Executar a aplicação
   
**O servidor será iniciado em http://localhost:8080**

4. Acessar o console do banco H2

5. Entrar na pasta do frontend

6. Instalar as dependências
7. Executar o servidor Angular

**O frontend será iniciado em http://localhost:4200**

## Alguns endpoints da API:

GET	/api/funcionarios	- Lista todos os funcionários ou filtra por cargo/ativo	
GET	/api/funcionarios/{id} -	Busca funcionário por ID	
POST	/api/funcionarios	- Cadastra novo funcionário ou reativa um inativo	
PUT	/api/funcionarios/{id} -	Atualiza dados de um funcionário ativo	
PATCH	/api/funcionarios/{id}/inativar	- Inativa um funcionário	

## Link do Swagger UI

Acesse a documentação interativa da API:
http://localhost:8080/swagger-ui.html
