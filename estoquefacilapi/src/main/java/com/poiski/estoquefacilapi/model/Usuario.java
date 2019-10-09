package com.poiski.estoquefacilapi.model;

import javax.persistence.Column;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.persistence.Entity;

@Entity
@Table(indexes = { @Index(name = "nomeIndex", columnList = "nome") })
public class Usuario extends CommonEntity {
    private static final long serialVersionUID = 8890147873030146440L;
	
    @Column(name = "nome", unique = true)
    private String nome;
    private String senha;
    private String token;
    private String email;
    
    public Usuario() {
    }
    
    public Usuario(final String nome, final String senha, final String email) {
        this.nome = nome;
        this.senha = senha;
        this.email = email;
    }
    
    public String getNome() {
        return this.nome;
    }
    
    public void setNome(final String nome) {
        this.nome = nome;
    }
    
    public String getSenha() {
        return this.senha;
    }
    
    public void setSenha(final String senha) {
        this.senha = senha;
    }
    
    public String getToken() {
        return this.token;
    }
    
    public void setToken(final String token) {
        this.token = token;
    }
    
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(final String email) {
        this.email = email;
    }
}
