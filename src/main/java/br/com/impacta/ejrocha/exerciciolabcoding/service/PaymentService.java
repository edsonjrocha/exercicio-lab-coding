package br.com.impacta.ejrocha.exerciciolabcoding.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.impacta.ejrocha.exerciciolabcoding.dto.PaymentDTO;
import br.com.impacta.ejrocha.exerciciolabcoding.model.Payment;
import br.com.impacta.ejrocha.exerciciolabcoding.repository.PaymentRepository;

@Service
public class PaymentService {
    
    @Autowired
    private PaymentRepository repository;

    private Long lastId;
    
    public PaymentService() {
        this.lastId = 1l;
    }

    public PaymentDTO findById(Long paymentId) {
        Payment payment = repository.findById(paymentId);

        PaymentDTO paymentDTO = new PaymentDTO(payment.getIdTransacao(), payment.getNumeroCartao(), 
        payment.getValidadeCartao(), payment.getBandeira());
        return paymentDTO;
    }

    public void save(PaymentDTO paymentDTO) {
        Payment payment = new Payment(this.lastId, paymentDTO.getNumeroCartao(), 
        paymentDTO.getValidadeCartao(), paymentDTO.getBandeira());
        this.repository.save(payment);
        this.lastId++;
    }

    public Long getLastId() {
        return this.lastId;
    }

    public void update(Long paymentId, PaymentDTO paymentDTO) {
        Payment payment = repository.findById(paymentId);
        repository.update(payment, paymentDTO);
    }

    public boolean delete(Long paymentId) {
        Payment payment = repository.findById(paymentId);
        return repository.delete(payment);        
    }

}
