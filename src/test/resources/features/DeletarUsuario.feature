# language: pt

## Funcionalidade da API de Deletar Usuario

@deletar_usuario
Funcionalidade: API deve pagar o usuário cadastrado 
  Apenas usuários cadastrados serão passiveis de serem apagados. 
     - A API deve retornar através de uma método delete
     - O ID do usuário deve ser informado na url
     - Deve retornar o código 204  


  Esquema do Cenario: Chamada método delete informando um usuário válido 
    Dado que a URL da API Deletar usuário esteja montada
    E é informado na url o <id> do usuário a ser apagado
    Quando invocar o método delete na API de usuários
    Entao usuário deve ser apagado e retornado o código '204'

    Exemplos: 
    |  id		 	|
    |   1     |
    |   2     |
    |   7     |
    |   8     |
    
    