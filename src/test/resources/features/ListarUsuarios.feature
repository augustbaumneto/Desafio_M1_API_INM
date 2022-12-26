# language: pt

## Funcionalidade da API de Lista Usuarios

@listar_usuarios
Funcionalidade: API deve retornar todos os usuários cadastrados
  Apenas usuários cadastrados serão listados na API. 
     - A API deve retornar através de uma método get
     - Para uma página diferente da primeira o parametro "page" deve ser informado na url
     - Informações da chamada: numero da página, quantidade de usuário por página, total de usuários, 
       total de páginas, listas de usuários na página, suporte (url de suporte e texto informativo) 
     - Deve retornar uma página por chamada, contendo no máximo 6 usuários
     - Informações de cada usuário: id, e-mail, primeiro nome, último nome e avatar


  Cenario: Chamada método get sem informar página 
    Dado que a URL esteja montada
    Quando não é informado a página a ser extraida
    E invocar o método get na Lista de usuário
    Entao deve trazer lista de usuarios validos
    E a página deve ser a primeira
    

