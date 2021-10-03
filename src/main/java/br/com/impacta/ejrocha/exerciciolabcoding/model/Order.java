package br.com.impacta.ejrocha.exerciciolabcoding.model;

import java.math.BigDecimal;
import java.util.List;

public class Order {
    private Long id;
    private String email;
    private String nomeCompleto;
    private String address;
    private int idPedido;
    private List<String> descricao;
    private int qntdPedidos;
    private List<BigDecimal> precoUnitario;
    private BigDecimal precoTotal;
    private String formaPagamento;
    private String dataPedido;
    private String status;
    
    private int idTransacao;
    private String numeroCartao;
    private String validadeCartao;
    private String bandeira;

    public Order() {

    }

    public Order(Long id, String email, String nomeCompleto, String address, int idPedido, List<String> descricao,
            int qntdPedidos, List<BigDecimal> precoUnitario, BigDecimal precoTotal, String formaPagamento,
            String dataPedido, String status, int idTransacao, String numeroCartao, String validadeCartao,
            String bandeira) {
        this.id = id;
        this.email = email;
        this.nomeCompleto = nomeCompleto;
        this.address = address;
        this.idPedido = idPedido;
        this.descricao = descricao;
        this.qntdPedidos = qntdPedidos;
        this.precoUnitario = precoUnitario;
        this.precoTotal = precoTotal;
        this.formaPagamento = formaPagamento;
        this.dataPedido = dataPedido;
        this.status = status;
        this.idTransacao = idTransacao;
        this.numeroCartao = numeroCartao;
        this.validadeCartao = validadeCartao;
        this.bandeira = bandeira;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public List<String> getDescricao() {
        return descricao;
    }

    public void setDescricao(List<String> descricao) {
        this.descricao = descricao;
    }

    public int getQntdPedidos() {
        return qntdPedidos;
    }

    public void setQntdPedidos(int qntdPedidos) {
        this.qntdPedidos = qntdPedidos;
    }

    public List<BigDecimal> getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(List<BigDecimal> precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public BigDecimal getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(BigDecimal precoTotal) {
        this.precoTotal = precoTotal;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public String getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(String dataPedido) {
        this.dataPedido = dataPedido;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getIdTransacao() {
        return idTransacao;
    }

    public void setIdTransacao(int idTransacao) {
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
