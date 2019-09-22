package com.poiski.estoquefacilapi.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Formula;

import com.alon.spring.crud.model.BaseEntity;

@Entity
@Table(indexes = {@Index(name = "produtoIndex", columnList = "produtoId")})
public class SaidaEstoque extends CommonEntity implements BaseEntity {

	private static final long serialVersionUID = 9031733008781735450L;
	
	@Column(precision = 10, scale = 2)
	private Double valor;
	
	@Column(precision = 10, scale = 2)
	private Double quantidade;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "produtoId")
	private Produto produto;
	
	@Formula("valor * quantidade")
	private Double valorTotal;

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

}
