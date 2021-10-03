package br.com.impacta.ejrocha.exerciciolabcoding.model;

public class Payment {
    
    private Long idTransacao;
    private String numeroCartao;
    private String validadeCartao;
    private String bandeira;

    public Payment(Long idTransacao, String numeroCartao, String validadeCartao, String bandeira) {
        this.idTransacao = idTransacao;
        this.numeroCartao = numeroCartao;
        this.validadeCartao = validadeCartao;
        this.bandeira = bandeira;
    }

    public Long getIdTransacao() {
        return idTransacao;
    }

    public void setIdTransacao(Long idTransacao) {
        this.idTransacao = idTransacao;
    }

    public String getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public String getValidadeCartao() {
        return validadeCartao;
    }

    public void setValidadeCartao(String validadeCartao) {
        this.validadeCartao = validadeCartao;
    }

    public String getBandeira() {
        return bandeira;
    }

    public void setBandeira(String bandeira) {
        this.bandeira = bandeira;
    }

}
