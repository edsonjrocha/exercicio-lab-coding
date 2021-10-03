package br.com.impacta.ejrocha.exerciciolabcoding.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.impacta.ejrocha.exerciciolabcoding.dto.PaymentDTO;
import br.com.impacta.ejrocha.exerciciolabcoding.model.Payment;

@Repository
public class PaymentRepository {
    
    //variavel para simular o banco de dados
    private List<Payment> paymentsList = new ArrayList<Payment>();

    public Payment findById(Long paymentId) {
        for (Payment payment : paymentsList) {
            if (payment.getIdTransacao() == paymentId) {
                return payment;
            }
        }
        return null;
    }

    public void save(Payment payment) {
        paymentsList.add(payment);
    }

    public void update(Payment payment, PaymentDTO paymentDTO) {      
        payment.setIdTransacao(paymentDTO.getIdTransacao());
        payment.setNumeroCartao(paymentDTO.getNumeroCartao());
        payment.setBandeira(paymentDTO.getBandeira());
        payment.setValidadeCartao(paymentDTO.getValidadeCartao());
    }

    public boolean delete(Payment payment) {    
        return paymentsList.remove(payment);
    }

}
