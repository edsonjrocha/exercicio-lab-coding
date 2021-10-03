package br.com.impacta.ejrocha.exerciciolabcoding.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.impacta.ejrocha.exerciciolabcoding.dto.OrderDTO;
import br.com.impacta.ejrocha.exerciciolabcoding.exception.EntityNotFoundException;
import br.com.impacta.ejrocha.exerciciolabcoding.model.Order;

@Repository
public class OrderRepository {

    //variavel para simular o banco de dados
    private List<Order> ordersList = new ArrayList<Order>();

    public Order findById(Long orderId) throws EntityNotFoundException {
        for (Order order : ordersList) {
            if (order.getId() == orderId) {
                return order;
            }
        }

        throw new EntityNotFoundException("Pedido com Id = " + orderId + " não encontrado");
    }

    public void save(Order order) {
        ordersList.add(order);
    }

    public void update(Order order, OrderDTO orderDTO) {        
        order.setAddress(orderDTO.getAddress());
        order.setDescricao(orderDTO.getDescricao());
        order.setQntdPedidos(orderDTO.getQntdPedidos());
        order.setPrecoUnitario(orderDTO.getPrecoUnitario());
        order.setPrecoTotal(orderDTO.getPrecoTotal());
        order.setFormaPagamento(orderDTO.getFormaPagamento());
        order.setIdTransacao(orderDTO.getIdTransacao());
        order.setNumeroCartao(orderDTO.getNumeroCartao());
        order.setValidadeCartao(orderDTO.getValidadeCartao());
        order.setBandeira(orderDTO.getBandeira());
    }

    public boolean delete(Order order) {    
        return ordersList.remove(order);
    }
    
}
