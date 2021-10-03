package br.com.impacta.ejrocha.exerciciolabcoding.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.impacta.ejrocha.exerciciolabcoding.dto.OrderDTO;
import br.com.impacta.ejrocha.exerciciolabcoding.dto.PaymentDTO;
import br.com.impacta.ejrocha.exerciciolabcoding.exception.EntityNotFoundException;
import br.com.impacta.ejrocha.exerciciolabcoding.exception.UpdateErrorException;
import br.com.impacta.ejrocha.exerciciolabcoding.model.Order;
import br.com.impacta.ejrocha.exerciciolabcoding.repository.OrderRepository;

@Service
public class OrderService {

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private OrderRepository repository;

    private Long lastId;
    
    public OrderService() {
        this.lastId = 1l;
    }

    public OrderDTO findById(Long orderId) throws EntityNotFoundException {
        Order order = repository.findById(orderId);
        System.out.println(order);
        PaymentDTO paymentDTO = this.paymentService.findById(order.getIdTransacao());

        OrderDTO orderDTO = new OrderDTO(order.getEmail(), order.getNomeCompleto(), order.getAddress(),
                order.getIdPedido(), order.getDescricao(), order.getQntdPedidos(), order.getPrecoUnitario(),
                order.getPrecoTotal(), order.getFormaPagamento(), order.getDataPedido(), order.getStatus(),
                paymentDTO.getIdTransacao(), paymentDTO.getNumeroCartao(), paymentDTO.getValidadeCartao(), paymentDTO.getBandeira());
        return orderDTO;
    }

    public void save(OrderDTO orderDTO) {

        //salvar os dados do pagamento
        this.paymentService.save(new PaymentDTO(orderDTO.getIdTransacao(), orderDTO.getNumeroCartao(), orderDTO.getValidadeCartao(), 
        orderDTO.getBandeira()));

        //salvar os dados do pedido
        Order order = new Order(this.lastId, orderDTO.getEmail(), orderDTO.getNomeCompleto(), orderDTO.getAddress(),
        orderDTO.getIdPedido(), orderDTO.getDescricao(), orderDTO.getQntdPedidos(), orderDTO.getPrecoUnitario(),
        orderDTO.getPrecoTotal(), orderDTO.getFormaPagamento(), orderDTO.getDataPedido(), orderDTO.getStatus(),
        this.paymentService.getLastId() - 1 , orderDTO.getNumeroCartao(), orderDTO.getValidadeCartao(), orderDTO.getBandeira());
        this.repository.save(order);

        this.lastId++;
    }

    public Long getLastId() {
        return this.lastId;
    }

    public void update(Long orderId, OrderDTO orderDTO) throws EntityNotFoundException, UpdateErrorException {

        try {
            //alterando os dados do pagamento
            this.paymentService.update(orderDTO.getIdTransacao(), new PaymentDTO(orderDTO.getIdTransacao(), orderDTO.getNumeroCartao(), orderDTO.getValidadeCartao(), 
            orderDTO.getBandeira()));

            //alterando os dados do pedido
            Order order = repository.findById(orderId);
            repository.update(order, orderDTO);
        } catch (EntityNotFoundException e) {
            throw new EntityNotFoundException(e.getMessage());
        } catch (Exception e) {
            throw new UpdateErrorException("Não foi possivel alterar o pedido");
        }
        
    }

    public boolean delete(Long orderId) throws EntityNotFoundException {        
        Order order = repository.findById(orderId);

        //removendo os dados do pagamento    
        this.paymentService.delete(order.getIdTransacao());

        //removendo os dados do pedido
        return repository.delete(order);        
    }
    
}
