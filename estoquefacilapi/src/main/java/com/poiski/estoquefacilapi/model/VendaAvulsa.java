package com.poiski.estoquefacilapi.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Formula;

import com.alon.spring.crud.model.BaseEntity;

@Entity
public class VendaAvulsa extends SuperEntity implements BaseEntity {

	private static final long serialVersionUID = 157189133613164351L;
	
	@Column(precision = 10, scale = 2)
	private Double valor;
	
	@Column(precision = 10, scale = 2)
	private Double quantidade;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "produtoId")
	private Produto produto;
	
	@Formula("valor * quantidade")
	private Double valorTotal;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "saidaEstoqueId")
	private SaidaEstoque estoque;
	

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Double quantidade) {
		this.quantidade = quantidade;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public SaidaEstoque getEstoque() {
		return estoque;
	}

	public void setEstoque(SaidaEstoque estoque) {
		this.estoque = estoque;
	}
	
}
