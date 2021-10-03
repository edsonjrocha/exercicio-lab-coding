package br.com.impacta.ejrocha.exerciciolabcoding.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.impacta.ejrocha.exerciciolabcoding.dto.OrderDTO;
import br.com.impacta.ejrocha.exerciciolabcoding.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService service;

    @Value("${configuracao.caminho_url}")
    private String urlServidor;
    
    @GetMapping("/findById/{orderId}")
    public ResponseEntity<OrderDTO> findById(@PathVariable("orderId") Long orderId){
        OrderDTO order = service.findById(orderId);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody OrderDTO order) {
        service.save(order);
        return new ResponseEntity<>(this.urlServidor + "/order/findById/" + (service.getLastId() - 1),
                HttpStatus.OK);
    }

    @PutMapping("/update/{orderId}")
    public ResponseEntity<OrderDTO> update(@PathVariable("orderId") Long orderId, @RequestBody OrderDTO orderDTO){
        service.update(orderId, orderDTO);
        return new ResponseEntity<>(orderDTO, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{orderId}")
    public ResponseEntity<Object> delete(@PathVariable("orderId") Long orderId) {

        String mensagem = "Não foi possivel excluir o Pedido com ID = " + orderId;

        if(service.delete(orderId)) {
            mensagem = "Pedido com ID = " + orderId + " excluido com sucesso";
        }
        
        return new ResponseEntity<>(mensagem, HttpStatus.OK);
    }

}
