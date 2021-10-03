package br.com.impacta.ejrocha.exerciciolabcoding.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.impacta.ejrocha.exerciciolabcoding.dto.OrderDTO;
import br.com.impacta.ejrocha.exerciciolabcoding.model.Order;
import br.com.impacta.ejrocha.exerciciolabcoding.repository.OrderRepository;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    private Long lastId;
    
    public OrderService() {
        this.lastId = 1l;
    }

    public OrderDTO findById(Long orderId) {
        Order order = repository.findById(orderId);

        OrderDTO orderDTO = new OrderDTO(order.getEmail(), order.getNomeCompleto(), order.getAddress(),
                order.getIdPedido(), order.getDescricao(), order.getQntdPedidos(), order.getPrecoUnitario(),
                order.getPrecoTotal(), order.getFormaPagamento(), order.getDataPedido(), order.getStatus(),
                order.getIdTransacao(), order.getNumeroCartao(), order.getValidadeCartao(), order.getBandeira());
        return orderDTO;
    }

    public void save(OrderDTO orderDTO) {
        Order order = new Order(this.lastId, orderDTO.getEmail(), orderDTO.getNomeCompleto(), orderDTO.getAddress(),
        orderDTO.getIdPedido(), orderDTO.getDescricao(), orderDTO.getQntdPedidos(), orderDTO.getPrecoUnitario(),
        orderDTO.getPrecoTotal(), orderDTO.getFormaPagamento(), orderDTO.getDataPedido(), orderDTO.getStatus(),
        orderDTO.getIdTransacao(), orderDTO.getNumeroCartao(), orderDTO.getValidadeCartao(), orderDTO.getBandeira());
        this.repository.save(order);
        this.lastId++;
    }

    public Long getLastId() {
        return this.lastId;
    }

    public void update(Long orderId, OrderDTO orderDTO) {
        Order order = repository.findById(orderId);
        repository.update(order, orderDTO);
    }

    public boolean delete(Long orderId) {
        Order order = repository.findById(orderId);
        return repository.delete(order);        
    }
    
}
