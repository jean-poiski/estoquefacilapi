package com.poiski.estoquefacilapi.model;

import javax.persistence.Lob;
import javax.validation.constraints.NotNull;
import javax.persistence.Entity;

@Entity
public class Fornecedor extends CommonEntity {
    private static final long serialVersionUID = 8080929595910578146L;

    @NotNull
    private String cnpj;

    @NotNull
    private String razaoSocial;
    private Long cep;
    private String rua;
    private Long numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String uf;

    @NotNull
    private String telefone;
    private String celular;
    private String email;

    @Lob
    private String observacoes;
    
    public String getCnpj() {
        return this.cnpj;
    }
    
    public void setCnpj(final String cnpj) {
        this.cnpj = cnpj;
    }
    
    public String getRazaoSocial() {
        return this.razaoSocial;
    }
    
    public void setRazaoSocial(final String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }
    
    public Long getCep() {
        return this.cep;
    }
    
    public void setCep(final Long cep) {
        this.cep = cep;
    }
    
    public String getRua() {
        return this.rua;
    }
    
    public void setRua(final String rua) {
        this.rua = rua;
    }
    
    public Long getNumero() {
        return this.numero;
    }
    
    public void setNumero(final Long numero) {
        this.numero = numero;
    }
    
    public String getComplemento() {
        return this.complemento;
    }
    
    public void setComplemento(final String complemento) {
        this.complemento = complemento;
    }
    
    public String getBairro() {
        return this.bairro;
    }
    
    public void setBairro(final String bairro) {
        this.bairro = bairro;
    }
    
    public String getCidade() {
        return this.cidade;
    }
    
    public void setCidade(final String cidade) {
        this.cidade = cidade;
    }
    
    public String getUf() {
        return this.uf;
    }
    
    public void setUf(final String uf) {
        this.uf = uf;
    }
    
    public String getTelefone() {
        return this.telefone;
    }
    
    public void setTelefone(final String telefone) {
        this.telefone = telefone;
    }
    
    public String getCelular() {
        return this.celular;
    }
    
    public void setCelular(final String celular) {
        this.celular = celular;
    }
    
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(final String email) {
        this.email = email;
    }
    
    public String getObservacoes() {
        return this.observacoes;
    }
    
    public void setObservacoes(final String observacoes) {
        this.observacoes = observacoes;
    }
}
