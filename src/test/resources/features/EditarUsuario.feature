# language: pt

## Funcionalidade da API de Editar Usuarios

@editar_usuario
Funcionalidade: API deve editar um usuário com os dados fornecidos
  Apenas usuários existentes devem poder ser editados. 
     - A API deve ser chamada por um método put ou patch
     - O corpo da requisição deve ser informado nome e cargo
     - O corpo da resposta deve retornar nome, cargo e data de edição
     - O Id do usuario a ser editado deve ser informado na url "/id" 

  @put
  Esquema do Cenario: Chamada do método put informando apenas um parametro valido 
    Dado que é informado um '<dado>' válido na requisição
    E e informado o id do usuario para edicao no parametro path
    E que a URL da API Editar Usuario esteja montada
    Quando invocar o método put de Edição de usuário
    Entao usuário deve ser editado e api deve retornar o código de status '200'
    E o corpo da resposta deve conter o '<dado>' editado com mesmo valor
    E a data de edicao deve ser valida

    Exemplos: 
    | dado 		|
    | nome    |
    | cargo   |

  @put
  Cenario: Chamada método do método put informando os dois parametros para mudar 
    Dado que são informados ambos os parametros válidos na requisição
    E e informado o id do usuario para edicao no parametro path
    E que a URL da API Editar Usuario esteja montada
    Quando invocar o método put de Edição de usuário
    Entao usuário deve ser editado e api deve retornar o código de status '200'
    E o corpo da resposta deve conter ambos valores editados com o mesmo valor
    E a data de edicao deve ser valida

  @patch
  Esquema do Cenario: Chamada do método patch informando apenas um parametro valido 
    Dado que é informado um '<dado>' válido na requisição
    E e informado o id do usuario para edicao no parametro path
    E que a URL da API Editar Usuario esteja montada
    Quando invocar o método patch de Edição de usuário
    Entao usuário deve ser editado e api deve retornar o código de status '200'
    E o corpo da resposta deve conter o '<dado>' editado com mesmo valor
    E a data de edicao deve ser valida

    Exemplos: 
    | dado 		|
    | nome    |
    | cargo   |

  @patch
  Cenario: Chamada método do método patch informando os dois parametros para mudar 
    Dado que são informados ambos os parametros válidos na requisição
    E e informado o id do usuario para edicao no parametro path
    E que a URL da API Editar Usuario esteja montada
    Quando invocar o método patch de Edição de usuário
    Entao usuário deve ser editado e api deve retornar o código de status '200'
    E o corpo da resposta deve conter ambos valores editados com o mesmo valor
    E a data de edicao deve ser valida

