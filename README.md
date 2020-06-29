# Teste Foursalses
Crie uma aplicação que exponha uma API RESTful de gerenciamento para candidatos e seus cartões de crédito.
O banco de dados da aplicacão é h2db
A mesma também se encontra publicada no heroku, conforme links abaixo.
Também contem uma documentação básica da api, via swagger


# URL Heroku
https://foursales.herokuapp.com/


# URL Swagger 
https://foursales.herokuapp.com/swagger-ui.html#/
# Exemplos de chamada

- Para criar um candidato 
```json

{
  "email": "teste@tes2te.com",
  "nome": "teste",
  "cpf" : "11111111111",
  "telefones": [
    {
      "ddd": "33",
      "numero": "33333333"
    }
  ],
  "cartoes": [
    {
      "numero": "2222222222222",
      "dataValidade": "11/11",
      "dataEmissao": "11/10",
      "bandeira": "visa"
    }
  ]
}
```

- Para alterar um candidato
```json

{
  "id" : "3b00cc22-c0dc-4925-8236-0e02cc5e70ff"
  "email": "teste@tes2te.com",
  "nome": "teste",
  "cpf" : "11111111111",
  "telefones": [
    {
      "ddd": "33",
      "numero": "33333333"
    }
  ],
  "cartoes": [
    {
      "numero": "2222222222222",
      "dataValidade": "11/11",
      "dataEmissao": "11/10",
      "bandeira": "visa"
    }
  ]
}
```

- Para alterar um cartão 
```json

 {
      "numero": "2222222222222",
      "dataValidade": "11/11",
      "dataEmissao": "11/10",
      "bandeira": "visa"
    }

```