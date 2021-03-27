# language: pt

Funcionalidade: Validar CPF
  Cenario: CPF Valido
    Dado que eu esteja na pagina de validacao de cpf
    E digito um cpf valido "129.360.810-68"
    Quando eu clico no botao enviar
    Entao devo ver uma mensagem de "CPF validado com sucesso"


  Cenario: CPF Inválido
    Dado que eu esteja na pagina de validacao de cpf
    E digito um cpf invalido "129.360.810-69"
    Quando eu clico no botao enviar novamente
    Entao devo ver uma nova mensagem de "Não é válido"


