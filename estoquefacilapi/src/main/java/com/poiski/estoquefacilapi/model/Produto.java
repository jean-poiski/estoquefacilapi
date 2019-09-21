package com.poiski.estoquefacilapi.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import com.alon.spring.crud.model.BaseEntity;
import com.poiski.estoquefacilapi.enums.Categoria;
import com.poiski.estoquefacilapi.enums.TipoEmbalagem;

@Entity
public class Produto extends SuperEntity implements BaseEntity {

	private static final long serialVersionUID = 639317072326688711L;
	
	@NotNull
	private String descricao;
	
	@Enumerated(EnumType.STRING)
	private TipoEmbalagem tipoEmbalagem;
	
	@Enumerated(EnumType.STRING)
	private Categoria tipoProduto;
	
	@NotNull
	private Double valor;
	
	@NotNull
	private String codigoBarras;
	
	@Lob
	private String observacoes;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "fornecedorId")
	private Fornecedor fornecedor;

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

	public TipoEmbalagem getTipoEmbalagem() {
		return tipoEmbalagem;
	}

	public void setTipoEmbalagem(TipoEmbalagem tipoEmbalagem) {
		this.tipoEmbalagem = tipoEmbalagem;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public String getCodigoBarras() {
		return codigoBarras;
	}

	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}

	public Categoria getTipoProduto() {
		return tipoProduto;
	}

	public void setTipoProduto(Categoria tipoProduto) {
		this.tipoProduto = tipoProduto;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

}
