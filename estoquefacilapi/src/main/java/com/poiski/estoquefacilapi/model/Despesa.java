package com.poiski.estoquefacilapi.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.alon.spring.crud.model.BaseEntity;

@Entity
@Table(indexes = {@Index(name = "estoqueIndex", columnList = "entradaEstoqueId")})
public class Despesa extends SuperEntity implements BaseEntity {

	private static final long serialVersionUID = 5659534064294468322L;
	
	@NotNull
	private String descricao;
	
	private Double valor;
	
	private String observacoes;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "entradaEstoqueId")
	private EntradaEstoque estoque;
	
	@Override
	public Long getId() {
		return this.getId();
	}

	@Override
	public void setId(Long id) {
		this.setId(id);
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public EntradaEstoque getEstoque() {
		return estoque;
	}

	public void setEstoque(EntradaEstoque estoque) {
		this.estoque = estoque;
	}

}
