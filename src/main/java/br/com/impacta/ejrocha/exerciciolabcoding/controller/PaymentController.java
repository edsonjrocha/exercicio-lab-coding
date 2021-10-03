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

import br.com.impacta.ejrocha.exerciciolabcoding.dto.PaymentDTO;
import br.com.impacta.ejrocha.exerciciolabcoding.service.PaymentService;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    
    @Autowired
    private PaymentService service;

    @Value("${configuracao.caminho_url}")
    private String urlServidor;

    @GetMapping("/findById/{paymentId}")
    public ResponseEntity<PaymentDTO> findById(@PathVariable("paymentId") Long paymentId){
        PaymentDTO paymentDTO = service.findById(paymentId);
        return new ResponseEntity<>(paymentDTO, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody PaymentDTO paymentDTO) {
        service.save(paymentDTO);
        return new ResponseEntity<>(this.urlServidor + "/payment/findById/" + (service.getLastId() - 1),
                HttpStatus.OK);
    }

    @PutMapping("/update/{paymentId}")
    public ResponseEntity<PaymentDTO> update(@PathVariable("paymentId") Long paymentId, @RequestBody PaymentDTO paymentDTO){
        service.update(paymentId, paymentDTO);
        return new ResponseEntity<>(paymentDTO, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{paymentId}")
    public ResponseEntity<Object> delete(@PathVariable("paymentId") Long paymentId) {

        String mensagem = "Não foi possivel excluir o Pedido com ID = " + paymentId;

        if(service.delete(paymentId)) {
            mensagem = "Pedido com ID = " + paymentId + " excluido com sucesso";
        }
        
        return new ResponseEntity<>(mensagem, HttpStatus.OK);
    }

}
