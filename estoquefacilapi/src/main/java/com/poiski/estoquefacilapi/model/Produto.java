package com.poiski.estoquefacilapi.model;

import javax.persistence.JoinColumn;
import javax.persistence.FetchType;
import javax.persistence.CascadeType;
import javax.persistence.ManyToOne;
import javax.persistence.Lob;
import com.poiski.estoquefacilapi.enums.Categoria;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import com.poiski.estoquefacilapi.enums.TipoEmbalagem;
import javax.validation.constraints.NotNull;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.persistence.Entity;

@Entity
@Table(indexes = { @Index(name = "codigoBarrasIndex", columnList = "codigoBarras") })
public class Produto extends CommonEntity {
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
    
	@ManyToOne(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
    @JoinColumn(name = "fornecedorId")
    private Fornecedor fornecedor;
    
    public String getDescricao() {
        return this.descricao;
    }
    
    public void setDescricao(final String descricao) {
        this.descricao = descricao;
    }
    
    public TipoEmbalagem getTipoEmbalagem() {
        return this.tipoEmbalagem;
    }
    
    public void setTipoEmbalagem(final TipoEmbalagem tipoEmbalagem) {
        this.tipoEmbalagem = tipoEmbalagem;
    }
    
    public Double getValor() {
        return this.valor;
    }
    
    public void setValor(final Double valor) {
        this.valor = valor;
    }
    
    public String getCodigoBarras() {
        return this.codigoBarras;
    }
    
    public void setCodigoBarras(final String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }
    
    public Categoria getTipoProduto() {
        return this.tipoProduto;
    }
    
    public void setTipoProduto(final Categoria tipoProduto) {
        this.tipoProduto = tipoProduto;
    }
    
    public String getObservacoes() {
        return this.observacoes;
    }
    
    public void setObservacoes(final String observacoes) {
        this.observacoes = observacoes;
    }
}
