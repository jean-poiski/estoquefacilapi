package com.poiski.estoquefacilapi.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.alon.spring.crud.model.BaseEntity;
import com.poiski.estoquefacilapi.enums.Categoria;
import com.poiski.estoquefacilapi.enums.TipoEmbalagem;

@Entity
public class Produto implements BaseEntity {

	private static final long serialVersionUID = 639317072326688711L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private String descricao;
	
	@Enumerated(EnumType.STRING)
	private TipoEmbalagem tipoEmbalagem;
	
	@Enumerated(EnumType.STRING)
	private Categoria tipoProduto;
	
	private Double quantidade;
	
	@NotNull
	private Double valor;
	
	@NotNull
	private String codigoBarras;
	
	@Lob
	private String observacoes;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy hh:mm:ss")
	private Date dataInclusao;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy hh:mm:ss")
	private Date dataAlteracao;
	
	private String usuarioInclusao;
	
	private String usuarioAlteracao;
	

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;

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

	public Double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Double quantidade) {
		this.quantidade = quantidade;
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

	public Date getDataInclusao() {
		return dataInclusao;
	}

	public void setDataInclusao(Date dataInclusao) {
		this.dataInclusao = dataInclusao;
	}

	public Date getDataAlteracao() {
		return dataAlteracao;
	}

	public void setDataAlteracao(Date dataAlteracao) {
		this.dataAlteracao = dataAlteracao;
	}

	public String getUsuarioInclusao() {
		return usuarioInclusao;
	}

	public void setUsuarioInclusao(String usuarioInclusao) {
		this.usuarioInclusao = usuarioInclusao;
	}

	public String getUsuarioAlteracao() {
		return usuarioAlteracao;
	}

	public void setUsuarioAlteracao(String usuarioAlteracao) {
		this.usuarioAlteracao = usuarioAlteracao;
	}

}
