# Documentação para utilização da API OrderService

    A seguir alguns exemplos de chamadas para se utilizar a API

# OrderService

## Endpoint findById

    Possibilita ao usuario buscar um pedido (Order) de acordo com o id

### Exemplo de utilização

    http://localhost:8080/order/findById/1

    OBS.: O serviço irá retornar o pedido no formato JSON

## Endpoint save

    Possibilita ao usuario salvar um pedido (Order)

    OBS.: O serviço irá retornar a URL para acessar o pedido salvo

### Exemplo de utilização

    http://localhost:8080/order/save

    Corpo da requisição:

    {
        "email" : "seuemail@teste.com", 
        "nomeCompleto" : "Seu Nome", 
        "address" : "Um endereço qualquer", 
        "idPedido" : 1, 
        "descricao" : ["Produto 01","Produto 02"],
        "qntdPedidos" : 2, 
        "precoUnitario" : [35.99, 20.00], 
        "precoTotal" : 55.99, 
        "formaPagamento" : "cartao", 
        "dataPedido" : "03/10/2021",
        "status" : "ativo", 
        "idTransacao" : 2, 
        "numeroCartao" : "123", 
        "validadeCartao" : "10/2028", 
        "bandeira" : "Visa"
    }

## Endpoint update

    Possibilita ao usuario atualizar os dados de um pedido (Order), utilizando seu ID para encontra-lo

    OBS.: O serviço o pedido editado em formato JSON

### Exemplo de utilização

    http://localhost:8080/order/update/1

    Corpo da requisição:

    {
        "email" : "seuemail@teste.com", 
        "nomeCompleto" : "Seu Nome Editado", 
        "address" : "Um endereço qualquer 2", 
        "idPedido" : 1, 
        "descricao" : ["Produto 01","Produto 02", "Produto 03"],
        "qntdPedidos" : 1, 
        "precoUnitario" : [10.00, 20.00, 30.00], 
        "precoTotal" : 60.00, 
        "formaPagamento" : "cartao", 
        "dataPedido" : "03/10/2021",
        "status" : "ativo", 
        "idTransacao" : 2, 
        "numeroCartao" : "123", 
        "validadeCartao" : "10/2028", 
        "bandeira" : "Visa"
    }

## Endpoint delete

    Possibilita ao usuario deletar um pedido (Order), utilizando seu ID para encontrá-lo

### Exemplo de utilização

    http://localhost:8080/order/delete/1

    OBS.: O mesmo irá uma mensagem de texto informando se o item foi excluído ou não

