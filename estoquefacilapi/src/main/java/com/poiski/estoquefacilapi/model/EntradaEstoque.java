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
public class EntradaEstoque extends SuperEntity implements BaseEntity {

	private static final long serialVersionUID = -7284996381478604675L;
	
	@Column(precision = 10, scale = 2)
	private Double valor;
	
	@Column(precision = 10, scale = 2)
	private Double quantidade;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "produtoId")
	private Produto produto;
	
	@Formula("valor * quantidade")
	private Double valorTotal;

	@Override
	public Long getId() {
		return this.getId();
	}

	@Override
	public void setId(Long id) {
		this.setId(id);
	}

}
