package com.poiski.estoquefacilapi.model;

import org.hibernate.annotations.Formula;
import javax.persistence.JoinColumn;
import javax.persistence.CascadeType;
import javax.persistence.ManyToOne;
import javax.persistence.Column;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.persistence.Entity;

@Entity
@Table(indexes = { @Index(name = "produtoIndex", columnList = "produtoId") })
public class SaidaEstoque extends CommonEntity {
    private static final long serialVersionUID = 9031733008781735450L;

    @Column(precision = 10, scale = 2)
    private Double valor;

    @Column(precision = 10, scale = 2)
    private Double quantidade;

    @ManyToOne(cascade = { CascadeType.DETACH })
    @JoinColumn(name = "produtoId")
    private Produto produto;

    @Formula("valor * quantidade")
    private Double valorTotal;
    
    public Double getValor() {
        return this.valor;
    }
    
    public void setValor(final Double valor) {
        this.valor = valor;
    }
    
    public Double getQuantidade() {
        return this.quantidade;
    }
    
    public void setQuantidade(final Double quantidade) {
        this.quantidade = quantidade;
    }
    
    public Produto getProduto() {
        return this.produto;
    }
    
    public void setProduto(final Produto produto) {
        this.produto = produto;
    }
    
    public Double getValorTotal() {
        return this.valorTotal;
    }
    
    public void setValorTotal(final Double valorTotal) {
        this.valorTotal = valorTotal;
    }
}
