# language: pt

## Funcionalidade da API de Criar Usuarios

@criar_usuario
Funcionalidade: API deve criar um usuário com os dados fornecidos
  Apenas usuários inexistentes deve ser criado na api. 
     - A API deve ser chamada por um método post
     - O corpo da requisição deve ser informado nome e cargo
     - O corpo da resposta deve retornar nome, cargo, id e data de criação 


  Cenario: Chamada do método post informando dados válidos 
    Dado é informado os dados válidos na requisição
    E que a URL da API Criar Usuario esteja montada
    Quando invocar o método post de Criação de usuário
    Entao usuário deve ser criado e api deve retornar o código de status '201'
    E o corpo da resposta deve conter dados válidos


