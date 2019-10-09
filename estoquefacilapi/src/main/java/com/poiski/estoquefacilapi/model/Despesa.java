package com.poiski.estoquefacilapi.model;

import javax.persistence.JoinColumn;
import javax.persistence.CascadeType;
import javax.persistence.ManyToOne;
import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.persistence.Entity;

@Entity
@Table(indexes = { @Index(name = "estoqueIndex", columnList = "entradaEstoqueId") })
public class Despesa extends CommonEntity
{
    private static final long serialVersionUID = 5659534064294468322L;
    
	@NotNull
    private String descricao;
    
	@Column(precision = 10, scale = 2)
    private Double valor;
    private String observacoes;
    
	@ManyToOne(cascade = { CascadeType.DETACH })
    @JoinColumn(name = "entradaEstoqueId")
    private EntradaEstoque estoque;
    
    public String getDescricao() {
        return this.descricao;
    }
    
    public void setDescricao(final String descricao) {
        this.descricao = descricao;
    }
    
    public Double getValor() {
        return this.valor;
    }
    
    public void setValor(final Double valor) {
        this.valor = valor;
    }
    
    public String getObservacoes() {
        return this.observacoes;
    }
    
    public void setObservacoes(final String observacoes) {
        this.observacoes = observacoes;
    }
    
    public EntradaEstoque getEstoque() {
        return this.estoque;
    }
    
    public void setEstoque(final EntradaEstoque estoque) {
        this.estoque = estoque;
    }
}
